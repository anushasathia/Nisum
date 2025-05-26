package com.nisum;
import com.nisum.util.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Answer{
    private Integer id;
    private String name;
    private String category;
    private Integer price;

    public static ArrayList<Answer>  getFilterResult(String category, String order){
        ArrayList<Answer> answerArrayList = new ArrayList<>();
        try(Connection con = DBconnection.getConnection()){
            String query = "SELECT * FROM products ORDER BY " + category + ' ' + order;
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Answer answer = new Answer(rs.getInt("id"),rs.getString("name"),rs.getString("category"),rs.getInt("price"));
                answerArrayList.add(answer);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("There was some error in connection");
        }
        return answerArrayList;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Answer(Integer id, String name, String category, Integer price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id : " + this.id +
                 " name : " + this.name +
                 " category : " + this.category +
                 " price : " + this.price;
    }
}


public class App {
    public static void main(String[] args) {
        ArrayList<Answer> answerArrayList = Answer.getFilterResult("price","ASC");
        for(Answer answer  :  answerArrayList){
            System.out.println(answer);
        }

    }
}
