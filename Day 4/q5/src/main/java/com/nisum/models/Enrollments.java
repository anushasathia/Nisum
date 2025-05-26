package com.nisum.models;

import java.time.LocalDate;

public class Enrollments {
    private Integer studentid;
    private Integer courseid;
    private String semester;
    private LocalDate enrollmentDate;
    private String grade;

    public Enrollments(Integer studentid, Integer courseid, String semester, LocalDate enrollmentDate, String grade) {
        this.studentid = studentid;
        this.courseid = courseid;
        this.semester = semester;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
