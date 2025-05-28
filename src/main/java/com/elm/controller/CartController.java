package com.elm.controller;

import com.elm.model.dto.cart.NewCartRequest;
import com.elm.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartController {
    CartService cartService = new CartService();
    ObjectMapper mapper = new ObjectMapper();

    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (route) {
                case "/CartController/saveCart":
                    this.saveCart(req, resp);
                    break;
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    private void saveCart(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        NewCartRequest c = new NewCartRequest();
        c.setUserId(req.getParameter("userId"));
        c.setFoodId(Integer.parseInt(req.getParameter("foodId")));
        c.setBusinessId(Integer.parseInt(req.getParameter("businessId")));

        int rows = cartService.addCart(c);

        resp.getWriter().write(String.valueOf(rows));
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}