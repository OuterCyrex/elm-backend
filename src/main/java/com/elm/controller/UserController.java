package com.elm.controller;

import com.elm.model.dto.user.GetUserRequest;
import com.elm.model.dto.user.SaveUserRequest;
import com.elm.model.dto.user.UserLoginRequest;
import com.elm.model.vo.UserResponse;
import com.elm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elm/UserController")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    private int saveUser(
            @RequestParam String userId,
            @RequestParam String password,
            @RequestParam String userName,
            @RequestParam Integer userSex
    ) throws Exception {
        SaveUserRequest req = new SaveUserRequest();
        req.setUserId(userId);
        req.setPassword(password);
        req.setUserName(userName);
        req.setUserSex(userSex);
        return userService.saveUser(req);
    }

    @PostMapping("/getUserById")
    private int getUserById(@RequestParam String userId) throws Exception {
        GetUserRequest req = new GetUserRequest(userId);
        return userService.GetUserById(req);
    }

    @PostMapping("/getUserByIdByPass")
    private UserResponse getUserByIdByPass(
            @RequestParam String userId,
            @RequestParam String password
    ) throws Exception {
        UserLoginRequest req = new UserLoginRequest(userId, password);
        return userService.Login(req);
    }
}
