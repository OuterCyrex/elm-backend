package com.elm.controller;

import com.elm.service.FoodService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FoodController {
    FoodService foodService = new FoodService();
    ObjectMapper mapper = new ObjectMapper();


    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (route) {
                case "/UserController/test":
                    this.Test(req, resp);
                case "/FoodController/listFoodByBusinessId":
                    this.GetFoodByBusinessId(req, resp);
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
            e.printStackTrace();
        }
    }

    private void Test(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write("BusinessController");
    }

    private void GetFoodByBusinessId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write(mapper.writeValueAsString(foodService.FindFood(Integer.parseInt(req.getParameter("businessId")))));
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
