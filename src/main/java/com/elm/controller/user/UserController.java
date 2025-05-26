package com.elm.controller.user;

import com.elm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {
    public void handle(String route, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (route) {
            case "/UserController/saveUser":
                this.saveUser(req, resp);
        }
    }

    private void saveUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        new UserService().saveUser
    }
}
