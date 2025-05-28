package com.elm.controller;

import com.elm.model.dto.address.NewAddressRequest;
import com.elm.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddressController {
    AddressService addressService = new AddressService();
    ObjectMapper mapper = new ObjectMapper();

    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (route) {
                case "/DeliveryAddressController/saveDeliveryAddress":
                    this.saveAddress(req, resp);
                    break;
                case "/DeliveryAddressController/listDeliveryAddressByUserId":
                    this.FindAddressByUserId(req, resp);
                    break;
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
            e.printStackTrace();
        }
    }

    private void saveAddress(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        NewAddressRequest da = new NewAddressRequest();
        da.setUserId(req.getParameter("userId"));
        da.setContactName(req.getParameter("contactName"));
        da.setContactSex(Integer.parseInt(req.getParameter("contactSex")));
        da.setContactTel(req.getParameter("contactTel"));
        da.setAddress(req.getParameter("address"));

        int rows = addressService.addAddress(da);

        resp.getWriter().write(String.valueOf(rows));
        resp.getWriter().flush();
        resp.getWriter().close();
    }

    private void FindAddressByUserId(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        resp.getWriter().write(mapper.writeValueAsString(addressService.AddressList(req.getParameter("userId"))));
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}

