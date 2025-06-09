package com.elm.service;

import java.sql.SQLException;
import java.util.List;

import com.elm.dao.BusinessDao;
import com.elm.dao.CartDao;
import com.elm.dao.FoodDao;
import com.elm.model.dto.cart.NewCartRequest;
import com.elm.model.entity.Business;
import com.elm.model.entity.Cart;
import com.elm.model.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private BusinessDao businessDao;

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

        List<Cart> cartList = cartDao.findCart(cart);

        for (Cart cartItem : cartList) {
            Food f = new Food();
            f.setFoodId(cartItem.getFoodId());

            Business b = new Business();
            b.setBusinessId(cartItem.getBusinessId());

            cartItem.setFood(foodDao.findFood(f).get(0));
            cartItem.setBusiness(businessDao.findBusiness(b).get(0));
        }

        return cartList;
    }

    public int RemoveCart(Cart cart) {
        return cartDao.deleteCart(cart);
    }

    public int UpdateCart(Cart cart) {
        return cartDao.updateCart(cart);
    }
}