package com.nisum;

import java.sql.*;
import java.time.LocalDate;

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

}
