package com.elm.controller;

import com.elm.model.dto.user.GetUserRequest;
import com.elm.model.dto.user.SaveUserRequest;
import com.elm.model.dto.user.UserLoginRequest;
import com.elm.model.vo.UserResponse;
import com.elm.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {
    UserService userService = new UserService();
    ObjectMapper mapper = new ObjectMapper();


    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            switch (route) {
                case "/UserController/test":
                    this.Test(req, resp);
                case "/UserController/saveUser":
                    this.saveUser(req, resp);
                case "/UserController/getUserById":
                    this.getUserById(req, resp);
                case "/UserController/getUserByIdByPass":
                    this.getUserByIdByPass(req, resp);
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
            e.printStackTrace();
        }
    }

    private void Test(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write("UserController");
    }

    private void saveUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String userName = req.getParameter("userName");
        String userSexStr = req.getParameter("userSex");

        short userSex = Short.parseShort(userSexStr);

        int result = userService.saveUser(new SaveUserRequest(userId, password, userName, userSex));

        resp.getWriter().write(String.valueOf(result));
    }

    private void getUserById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        String userId = req.getParameter("userId");
        resp.setContentType("text/plain;charset=UTF-8");

        int id = userService.GetUserById(new GetUserRequest(userId));

        resp.getWriter().write(String.valueOf(id));
    }

    private void getUserByIdByPass(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        UserResponse result = userService.Login(new UserLoginRequest(userId, password));

        resp.getWriter().write(mapper.writeValueAsString(result));
    }
}
