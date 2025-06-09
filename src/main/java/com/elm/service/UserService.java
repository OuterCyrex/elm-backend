package com.elm.service;

import com.elm.dao.UserDao;
import com.elm.model.dto.user.GetUserRequest;
import com.elm.model.dto.user.SaveUserRequest;
import com.elm.model.dto.user.UserLoginRequest;
import com.elm.model.entity.User;
import com.elm.model.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    private UserResponse EntityToResponse(User user) {
        return new UserResponse(user);
    }

    public int saveUser(SaveUserRequest in) throws SQLException{
        return userDao.insertUser(new User(in.getUserId(), in.getPassword(), in.getUserName(), "", in.getUserSex(), (short) 0));
    }

    public int GetUserById(GetUserRequest in) throws SQLException{
        User user = new User();
        user.setUserId(in.getUserId());
        user.setDelTag(0);
        return userDao.findUser(user).size();
    }

    public UserResponse Login(UserLoginRequest in) throws SQLException {
        User user = new User();
        user.setUserId(in.getUserId());
        user.setPassword(in.getPassword());
        user.setDelTag(0);
        return EntityToResponse(userDao.findUser(user).get(0));
    }
}
