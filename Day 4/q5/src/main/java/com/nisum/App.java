package com.nisum;
import com.nisum.util.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Answer{
    private String courseName;
    private String instructor;
    private String grade;

    public Answer(String courseName, String instructor, String grade) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public static ArrayList<Answer> joinMethod(Integer studentId){
            try {
                Connection con = DBconnection.getConnection();
                String query = "SELECT course_name,instructor,grade \n" +
                        "FROM DAY4.students\n" +
                        "INNER JOIN DAY4.enrollments\n" +
                        "ON DAY4.students.id = DAY4.enrollments.student_id\n" +
                        "INNER JOIN DAY4.courses\n" +
                        "ON DAY4.courses.id = DAY4.enrollments.course_id\n" +
                        "WHERE DAY4.students.id = ?;";
                PreparedStatement stm = con.prepareStatement(query);
                stm.setInt(1,studentId);
                ResultSet rs = stm.executeQuery();
                ArrayList<Answer> answerArrayList  = new ArrayList<>();
                while(rs.next()){
                    Answer answer = new Answer(rs.getString("course_name"),rs.getString("instructor"),rs.getString("grade"));
                    answerArrayList.add(answer);
                }
                return answerArrayList;
            }catch (SQLException ex){
                ex.printStackTrace();
                System.out.println("there is some error in connection");
                return null;
            }
        }

    @Override
    public String toString() {
        return " Course Name : " + this.courseName +
                " \nInstructor Name : " + this.instructor +
                " \nGrade :" + this.grade;
    }
}


public class App {
    public static void main(String[] args) {
       ArrayList<Answer> answerArrayList = Answer.joinMethod(1);
       for(Answer answer : answerArrayList){
           System.out.println(answer);
       }

    }
}
