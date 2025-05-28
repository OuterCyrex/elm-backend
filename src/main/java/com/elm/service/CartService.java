package com.elm.service;

import java.sql.SQLException;

import com.elm.dao.CartDao;
import com.elm.model.dto.cart.NewCartRequest;
import com.elm.model.entity.Cart;

public class CartService {
    private final CartDao cartDao = new CartDao();

    public int addCart(NewCartRequest in) throws SQLException{
        Cart cart = new Cart();
        cart.setBusinessId(in.getBusinessId());
        cart.setFoodId(in.getFoodId());
        cart.setQuantity(in.getQuantity());
        cart.setUserId(in.getUserId());

        return cartDao.addCart(cart);
    }
}