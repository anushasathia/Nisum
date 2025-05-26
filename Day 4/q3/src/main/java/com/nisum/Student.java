package com.nisum;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private Integer studentid;
    private String firstname;
    private String lastname;
    private LocalDate dateofbirth;
    private String email;

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

    public Student(Integer studentid, String firstname, String lastname, String dateofbirth, String email) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dob = LocalDate.parse(dateofbirth, formatter);

        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dob;
        this.email = email;
    }

    public Student() {
    }

    public static boolean insertStudent(Connection con, Student s){
        try {
            String query = "INSERT INTO students VALUES (?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,s.getStudentid());
            stm.setString(2,s.getFirstname());
            stm.setString(3,s.getLastname());
            stm.setDate(4,Date.valueOf(s.getDateofbirth()));
            stm.setString(5,s.getEmail());

            int updateValue = stm.executeUpdate();
            return updateValue > 0;


        } catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }

    }


    public static boolean updateStudent(Connection con, Student s){
        try{
            String query = "INSERT INTO students VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE" +
                    " studentid = VALUES(studentid)," +
                    "FirstName = VALUES(FirstName)," +
                    "LastName = VALUES(LastName)," +
                    "DateOfBirth = VALUES(DateOfBirth)," +
                    "Email = VALUES(Email)";

            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,s.getStudentid());
            stm.setString(2,s.getFirstname());
            stm.setString(3,s.getLastname());
            stm.setDate(4,Date.valueOf(s.getDateofbirth()));
            stm.setString(5,s.getEmail());

            int updateValue = stm.executeUpdate();
            return updateValue > 0;

        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean deleteStudent(Connection con,int id){
        try{
            String query = "DELETE FROM students WHERE studentid = ? ";
            PreparedStatement stm = con.prepareStatement(query);

            stm.setInt(1,id);

            int updateValue = stm.executeUpdate();
            return updateValue > 0;

        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }



}
