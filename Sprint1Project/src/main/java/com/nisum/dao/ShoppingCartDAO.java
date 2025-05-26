package com.nisum.dao;

import com.nisum.model.ShoppingCart;
import com.nisum.util.DBconnection;
import java.sql.*;
import java.util.ArrayList;

public class ShoppingCartDAO {

    public void addShoppingCart(ShoppingCart shoppingCart){
        String query = "INSERT INTO ShoppingCart VALUES ( ?, ? , ? , ? , ? )";
        try {
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,shoppingCart.getCartID());
            stm.setInt(2,shoppingCart.getUserId());
            stm.setDouble(3,shoppingCart.getCartTotal());
            stm.setDate(4, new java.sql.Date(shoppingCart.getCreatedDate().getTime()));
            stm.setDate(5, new java.sql.Date(shoppingCart.getLastUpdatedDate().getTime()));
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public ShoppingCart getShoppingCartByCartID(Integer id){
        String query = "SELECT * FROM ShoppingCart WHERE CartID  = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            ShoppingCart shoppingCart = new ShoppingCart();
            if(rs.next()){
                shoppingCart.setCartID(rs.getInt("CartID"));
                shoppingCart.setUserId(rs.getInt("UserID"));
                shoppingCart.setCartTotal(rs.getDouble("CartTotal"));
                shoppingCart.setCreatedDate(rs.getDate("CreatedDate"));
                shoppingCart.setLastUpdatedDate(rs.getDate("LastUpdatedDate"));
            }
            return shoppingCart;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public ShoppingCart getShoppingCartByUserID(Integer id){
        String query = "SELECT * FROM ShoppingCart WHERE UserID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            ShoppingCart shoppingCart = new ShoppingCart();
            if(rs.next()){
                shoppingCart.setCartID(rs.getInt("CartID"));
                shoppingCart.setUserId(rs.getInt("UserID"));
                shoppingCart.setCartTotal(rs.getDouble("CartTotal"));
                shoppingCart.setCreatedDate(rs.getDate("CreatedDate"));
                shoppingCart.setLastUpdatedDate(rs.getDate("LastUpdatedDate"));
            }
            return shoppingCart;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public ArrayList<ShoppingCart> getAllShoppingCart(){
        String query = "SELECT * FROM ShoppingCart";
        ArrayList<ShoppingCart> list = new ArrayList<>();
        try{
            Connection con = new DBconnection().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setCartID(rs.getInt("CartID"));
                shoppingCart.setUserId(rs.getInt("UserID "));
                shoppingCart.setCartTotal(rs.getDouble("CartTotal"));
                shoppingCart.setCreatedDate(rs.getDate("CreatedDate"));
                shoppingCart.setLastUpdatedDate(rs.getDate("LastUpdatedDate"));
                list.add(shoppingCart);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public void updateShoppingCart(ShoppingCart shoppingCart){
        String query = "UPDATE ShoppingCart SET  UserID    = ?, \n" +
                "    CartTotal    = ?, CreatedDate    = ?, LastUpdatedDate    = ?  WHERE CartID   = ? ";
        try {
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(5,shoppingCart.getCartID());
            stm.setInt(1,shoppingCart.getUserId());
            stm.setDouble(2,shoppingCart.getCartTotal());
            stm.setDate(3, new java.sql.Date(shoppingCart.getCreatedDate().getTime()));
            stm.setDate(4, new java.sql.Date(shoppingCart.getLastUpdatedDate().getTime()));
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not updated",ex);
        }
    }

    public void deleteShoppingCart(Integer CartID){
        String query = "DELETE FROM ShoppingCart WHERE CartID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,CartID);
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not deleted",ex);
        }
    }

    public void deleteCartItembyUserID(Integer UserID ){
        String query = "DELETE FROM ShoppingCart WHERE UserID  = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,UserID );
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not deleted",ex);
        }
    }

    public void deleteAllShoppingCartItems(){
        String query = "TRUNCATE ShoppingCart";
        try{
            Connection con = new DBconnection().getConnection();
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

}
