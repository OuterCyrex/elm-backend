package com.elm.controller;

import com.elm.service.BusinessService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BusinessController {
    BusinessService businessService = new BusinessService();
    ObjectMapper mapper = new ObjectMapper();


    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (route) {
                case "/BusinessController/test":
                    this.Test(req, resp);
                case "/BusinessController/listBusinessByOrderTypeId":
                    this.ListBusinessByOrderTypeId(req, resp);
                case "/BusinessController/getBusinessById":
                    this.GetBusinessById(req, resp);
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

    private void ListBusinessByOrderTypeId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write(mapper.writeValueAsString(businessService.GetBusinessByOrderTypeId(Integer.parseInt(req.getParameter("orderTypeId")))));
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    private void GetBusinessById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write(mapper.writeValueAsString(businessService.GetBusinessById(Integer.parseInt(req.getParameter("businessId")))));
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
