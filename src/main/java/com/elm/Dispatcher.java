package com.elm;

import com.elm.controller.HelloController;
import com.elm.controller.business.BusinessController;
import com.elm.controller.user.UserController;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/*")
public class Dispatcher extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getRequestURI();
        String context = req.getContextPath();
        String action = path.substring(context.length());

        if (action.startsWith("/hello")) {
            new HelloController().handle(req, resp);
        }

        if (action.startsWith("/UserController")) {
            new UserController().handle(action, req, resp);
        }

        if (action.startsWith("/BusinessController")) {
            new BusinessController().handle(action, req, resp);
        }
    }
}

