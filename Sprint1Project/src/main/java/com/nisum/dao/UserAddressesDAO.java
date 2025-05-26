package com.nisum.dao;

import com.nisum.model.UserAddresses;
import com.nisum.util.DBconnection;

import java.sql.*;
import java.util.ArrayList;

public class UserAddressesDAO {

    public void addAddresses(UserAddresses userAddresses){
        String query = "INSERT INTO UserAddresses VALUES ( ?, ? , ? , ? , ? , ?, ?)";
        try {
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,userAddresses.getAddressId());
            stm.setInt(2,userAddresses.getUserID());
            stm.setString(3,userAddresses.getAddressLine1());
            stm.setString(4,userAddresses.getAddressLine2());
            stm.setString(5,userAddresses.getZipcode());
            stm.setString(6,userAddresses.getState());
            stm.setString(7,userAddresses.getCountry());
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public UserAddresses getAddressByAddressId(Integer id){
        String query = "SELECT * FROM UserAddresses WHERE AddressID  = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            UserAddresses userAddresses = new UserAddresses();
            if(rs.next()){
                userAddresses.setAddressId(rs.getInt("AddressID"));
                userAddresses.setUserID(rs.getInt("UserID"));
                userAddresses.setAddressLine1(rs.getString("AddressLine1"));
                userAddresses.setAddressLine2(rs.getString("AddressLine2"));
                userAddresses.setZipcode(rs.getString("ZipCode"));
                userAddresses.setState(rs.getString("State"));
                userAddresses.setCountry(rs.getString("Country"));
            }
            return userAddresses;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Failed to retrieve address",ex);
        }
    }

    public ArrayList<UserAddresses> getAddressByUserId(Integer id){
        ArrayList<UserAddresses> list = new ArrayList<>();
        String query = "SELECT * FROM UserAddresses WHERE UserID  = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                UserAddresses userAddresses = new UserAddresses();
                userAddresses.setAddressId(rs.getInt("AddressID"));
                userAddresses.setUserID(rs.getInt("UserID"));
                userAddresses.setAddressLine1(rs.getString("AddressLine1"));
                userAddresses.setAddressLine2(rs.getString("AddressLine2"));
                userAddresses.setZipcode(rs.getString("ZipCode"));
                userAddresses.setState(rs.getString("State"));
                userAddresses.setCountry(rs.getString("Country"));
                list.add(userAddresses);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Failed to retrieve address",ex);
        }
    }

    public ArrayList<UserAddresses> getAllAddresses(){
        String query = "SELECT * FROM UserAddresses";
        ArrayList<UserAddresses> list = new ArrayList<>();
        try{
            Connection con = new DBconnection().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                UserAddresses userAddresses = new UserAddresses();
                userAddresses.setAddressId(rs.getInt("AddressID"));
                userAddresses.setUserID(rs.getInt("UserID"));
                userAddresses.setAddressLine1(rs.getString("AddressLine1"));
                userAddresses.setAddressLine2(rs.getString("AddressLine2"));
                userAddresses.setZipcode(rs.getString("ZipCode"));
                userAddresses.setState(rs.getString("State"));
                userAddresses.setCountry(rs.getString("Country"));
                list.add(userAddresses);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public void updateAddress(UserAddresses userAddresses){
        String query = "UPDATE UserAddresses SET UserID    = ?, AddressLine1    = ?, \n" +
                "    AddressLine2    = ?, ZipCode    = ?, State    = ?, Country    = ? WHERE AddressID   = ? ";
        try {
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(7,userAddresses.getAddressId());
            stm.setInt(1,userAddresses.getUserID());
            stm.setString(2,userAddresses.getAddressLine1());
            stm.setString(3,userAddresses.getAddressLine2());
            stm.setString(4,userAddresses.getZipcode());
            stm.setString(5,userAddresses.getState());
            stm.setString(6,userAddresses.getCountry());
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not updated",ex);
        }
    }

    public void deleteAddress(Integer addressid){
        String query = "DELETE FROM UserAddresses WHERE AddressID  = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,addressid);
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not deleted",ex);
        }
    }

    public void deleteAddressbyUserID (Integer userID){
        String query = "DELETE FROM UserAddresses WHERE UserID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,userID);
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not deleted",ex);
        }
    }


}
