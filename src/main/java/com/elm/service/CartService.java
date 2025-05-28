package com.elm.service;

import java.sql.SQLException;
import java.util.List;

import com.elm.dao.CartDao;
import com.elm.model.dto.cart.NewCartRequest;
import com.elm.model.entity.Cart;

public class CartService {
    private final CartDao cartDao = new CartDao();

    public int addCart(NewCartRequest in) throws SQLException{
        Cart cart = new Cart();
        cart.setBusinessId(in.getBusinessId());
        cart.setFoodId(in.getFoodId());
        cart.setQuantity(1);
        cart.setUserId(in.getUserId());

        return cartDao.addCart(cart);
    }

    public List<Cart> CartList(String  UserId) throws SQLException{
        Cart cart = new Cart();
        cart.setUserId(UserId);
        return cartDao.findCart(cart);
    }
}