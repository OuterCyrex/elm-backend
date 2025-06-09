package com.elm.controller;

import com.elm.model.dto.cart.NewCartRequest;
import com.elm.model.entity.Cart;
import com.elm.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/CartController")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/saveCart")
    private int saveCart(@RequestParam String userId,
                          @RequestParam Integer foodId,
                          @RequestParam Integer businessId
    ) throws Exception {
        NewCartRequest c = new NewCartRequest();
        c.setUserId(userId);
        c.setFoodId(foodId);
        c.setBusinessId(businessId);

        return cartService.addCart(c);
    }

    @PostMapping("/listCart")
    public List<Cart> ListCart(@RequestParam String userId) throws Exception {
        return cartService.CartList(userId);
    }

    @PostMapping("/removeCart")
    public int RemoveCart(
            @RequestParam String userId,
            @RequestParam Integer businessId,
            @RequestParam Integer foodId
    ) throws Exception {
        Cart c = new Cart();
        c.setUserId(userId);
        c.setBusinessId(businessId);
        c.setFoodId(foodId);

        return cartService.RemoveCart(c);
    }

    @PostMapping("/updateCart")
    public int UpdateCart(
            @RequestParam Integer quantity,
            @RequestParam String userId,
            @RequestParam Integer businessId,
            @RequestParam Integer foodId
    ) throws Exception {
        Cart c = new Cart();
        c.setUserId(userId);
        c.setBusinessId(businessId);
        c.setFoodId(foodId);
        c.setQuantity(quantity);

        return cartService.UpdateCart(c);
    }
}