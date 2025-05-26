package com.nisum.dao;

import com.nisum.model.CartItem;
import com.nisum.util.DBconnection;

import java.sql.*;
import java.util.ArrayList;

public class InitialCartItemDAO {

    public void addItems(CartItem cartItem){
        String query = "INSERT INTO InitialCartItems VALUES ( ?, ? , ? , ? , ? , ?, ?, ?)";
        try {
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,cartItem.getCartItemID());
            stm.setInt(2,cartItem.getCartID());
            stm.setInt(3,cartItem.getProductID());
            stm.setString(4,cartItem.getSku());
            stm.setInt(5,cartItem.getQuantity());
            stm.setDouble(6,cartItem.getUnitPrice());
            stm.setDouble(7,cartItem.getDiscount());
            stm.setDouble(8,cartItem.getFinalPrice());
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public CartItem getCartItemByCartItemID(Integer id) {
        String query = "SELECT * FROM InitialCartItems WHERE cartItemID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                CartItem cartItem = new CartItem();
                cartItem.setCartItemID(rs.getInt("CartItemID"));
                cartItem.setCartID(rs.getInt("CartID"));
                cartItem.setProductID(rs.getInt("ProductID"));
                cartItem.setSku(rs.getString("SKU"));
                cartItem.setQuantity(rs.getInt("Quantity"));
                cartItem.setUnitPrice(rs.getDouble("UnitPrice"));
                cartItem.setDiscount(rs.getDouble("Discount"));
                cartItem.setFinalPrice(rs.getDouble("FinalPrice"));
                return cartItem;
            }
            return null;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data not found",ex);
        }
    }


    public ArrayList<CartItem> getCartItemsByCartID(Integer id){
        ArrayList<CartItem> list = new ArrayList<>();
        String query = "SELECT * FROM InitialCartItems WHERE cartID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                CartItem cartItem = new CartItem();
                cartItem.setCartItemID(rs.getInt("CartItemID"));
                cartItem.setCartID(rs.getInt("CartID"));
                cartItem.setProductID(rs.getInt("ProductID"));
                cartItem.setSku(rs.getString("SKU"));
                cartItem.setQuantity(rs.getInt("Quantity"));
                cartItem.setUnitPrice(rs.getDouble("UnitPrice"));
                cartItem.setDiscount(rs.getDouble("Discount"));
                cartItem.setFinalPrice(rs.getDouble("FinalPrice"));
                list.add(cartItem);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public ArrayList<CartItem> getAllCartItems(){
        String query = "SELECT * FROM InitialCartItems";
        ArrayList<CartItem> list = new ArrayList<>();
        try{
            Connection con = new DBconnection().getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()){
                CartItem cartItem = new CartItem();
                cartItem.setCartItemID(rs.getInt("CartItemID"));
                cartItem.setCartID(rs.getInt("CartID"));
                cartItem.setProductID(rs.getInt("ProductID"));
                cartItem.setSku(rs.getString("SKU"));
                cartItem.setQuantity(rs.getInt("Quantity"));
                cartItem.setUnitPrice(rs.getDouble("UnitPrice"));
                cartItem.setDiscount(rs.getDouble("Discount"));
                cartItem.setFinalPrice(rs.getDouble("FinalPrice"));
                list.add(cartItem);
            }
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public void updateCartItem(CartItem cartItem){
        String query = "UPDATE InitialCartItems SET CartID   = ?, ProductID   = ?, \n" +
                "    SKU   = ?, Quantity   = ?, UnitPrice   = ?, Discount   = ?, FinalPrice   = ? WHERE CartItemID  = ? ";
        try {
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(8,cartItem.getCartItemID());
            stm.setInt(1,cartItem.getCartID());
            stm.setInt(2,cartItem.getProductID());
            stm.setString(3,cartItem.getSku());
            stm.setInt(4,cartItem.getQuantity());
            stm.setDouble(5,cartItem.getUnitPrice());
            stm.setDouble(6,cartItem.getDiscount());
            stm.setDouble(7,cartItem.getFinalPrice());
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public void deleteCartItem(Integer cartItemID){
        String query = "DELETE FROM InitialCartItems WHERE CartItemID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,cartItemID);
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

    public void deleteCartItembyCartID(Integer cartid){
        String query = "DELETE FROM InitialCartItems WHERE CartID = ?";
        try{
            Connection con = new DBconnection().getConnection();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1,cartid);
            stm.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
            throw  new RuntimeException("Data is not inserted",ex);
        }
    }

}

