package com.nisum.models;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private LocalDate dateofbirth;
    private String major;
    private LocalDate admissiondate;
    private double gpa;

    public Student(Integer id, String name, String email, LocalDate dateofbirth, String major, LocalDate admissiondate, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.major = major;
        this.admissiondate = admissiondate;
        this.gpa = gpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public LocalDate getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(LocalDate admissiondate) {
        this.admissiondate = admissiondate;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
