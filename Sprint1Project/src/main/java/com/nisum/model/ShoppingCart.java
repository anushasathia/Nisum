package com.nisum.model;

import java.util.Date;
public class ShoppingCart {
    private Integer cartID;
    private Integer userId;
    private double cartTotal;
    private Date createdDate;
    private Date lastUpdatedDate;

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getCartID() {
        return cartID;
    }

    public void setCartID(Integer cartID) {
        this.cartID = cartID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ShoppingCart(Integer cartID, Integer userId, double cartTotal, Date createdDate, Date lastUpdatedDate) {
        this.cartID = cartID;
        this.userId = userId;
        this.cartTotal = cartTotal;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public ShoppingCart() {
    }
}
