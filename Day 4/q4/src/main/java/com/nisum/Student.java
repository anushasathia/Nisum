package com.nisum;



import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Student {
    private Integer studentid;
    private String firstname;
    private String lastname;
    private LocalDate dateofbirth;
    private String email;
    private Integer credits;

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Student getStudent(Connection con ,Integer studentid){
        Student student = null;
        try {
            student = new Student();
            String query = "SELECT * FROM students WHERE studentid = ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,studentid);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                student.setEmail(rs.getString("email"));
                student.setDateofbirth(rs.getObject("DateOfBirth",LocalDate.class));
                student.setStudentid(rs.getInt("Studentid"));
                student.setFirstname(rs.getString("firstname"));
                student.setLastname(rs.getString("lastname"));
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return student;
    }

    public Student(Integer studentid, String firstname, String lastname, LocalDate dateofbirth, String email, Integer credits) {
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.credits = credits;
    }

    public Student() {
    }

    public static HashMap<Integer,Student> getAllStudent(Connection con){
        HashMap<Integer,Student> listofstudents = new HashMap<>();
        try{
            String query = "SELECT * FROM students";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Student student = new Student();
                student.setEmail(rs.getString("email"));
                student.setDateofbirth(rs.getObject("DateOfBirth",LocalDate.class));
                student.setStudentid(rs.getInt("Studentid"));
                student.setFirstname(rs.getString("firstname"));
                student.setLastname(rs.getString("lastname"));
                student.setLastname(rs.getString("lastname"));
                student.setCredits(rs.getInt("credits"));
                listofstudents.put(rs.getInt("Studentid"),student);
            }

            return listofstudents;
        }catch (SQLException ex){
            ex.printStackTrace();
            return listofstudents;
        }
    }

    public static void creditTransfer(Connection con, Student s1,Student s2){
        try{
            con.setAutoCommit(false);
            int s1Credits = s1.getCredits();
            int s2Credits = s2.getCredits();
            if(s1Credits > 0) {
                s2Credits = s1Credits + s2Credits;
                s1Credits = 0;

                String query = "UPDATE students SET credits = ? WHERE studentid = ?";
                try {
                    PreparedStatement stm = con.prepareStatement(query);
                    stm.setInt(1, s2Credits);
                    stm.setInt(2, s2.getStudentid());
                    stm.executeUpdate();
                    stm.setInt(1, s1Credits);
                    stm.setInt(2, s1.getStudentid());
                    stm.executeUpdate();
                    con.commit();
                }catch (SQLException ex){
                    con.rollback();
                    ex.printStackTrace();;
                }
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }




}
