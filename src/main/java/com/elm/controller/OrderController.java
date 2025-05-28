package com.elm.controller;

import com.elm.model.dto.order.SaveOrderRequest;
import com.elm.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderController {
    OrderService orderService = new OrderService();
    ObjectMapper mapper = new ObjectMapper();


    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (route) {
                case "/BusinessController/test":
                    this.Test(req, resp);
                case "/OrdersController/createOrders":
                    this.CreateOrders(req, resp);
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
        }
    }

    private void Test(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write("OrderController");
    }

    private void CreateOrders(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        int id = orderService.createOrder(new SaveOrderRequest(
                Double.parseDouble(req.getParameter("totalPrice")),
                Integer.parseInt(req.getParameter("daId")),
                req.getParameter("userId"),
                Integer.parseInt(req.getParameter("businessId"))));
        resp.getWriter().write(String.valueOf(id));
    }
}