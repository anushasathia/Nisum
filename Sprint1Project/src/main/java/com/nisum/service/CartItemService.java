package com.nisum.service;

import com.nisum.dao.CartItemDAO;
import com.nisum.dao.ShoppingCartDAO;
import com.nisum.model.CartItem;
import com.nisum.model.ShoppingCart;

import java.time.LocalDate;
import java.util.Date;

public class CartItemService {

    private final Integer userid = 1;
    public void addCartItemToShoppingCart(CartItem cartItem){
        ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartByUserID(1);
        if(shoppingCart == null || shoppingCart.getCartID() == null){
            shoppingCart = new ShoppingCart(1,userid, cartItem.getFinalPrice(),new Date(),new Date());
            shoppingCartDAO.addShoppingCart(shoppingCart);
        }else{
            double currentCartValue = shoppingCart.getCartTotal();
            double totalCartValue = cartItem.getFinalPrice() + currentCartValue;
            shoppingCart.setCartTotal(totalCartValue);
            shoppingCartDAO.updateShoppingCart(shoppingCart);
        }

    }

}
