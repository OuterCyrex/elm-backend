package com.elm.service;

import com.elm.dao.UserDao;
import com.elm.model.dto.GetUserRequest;
import com.elm.model.dto.SaveUserRequest;
import com.elm.model.dto.UserLoginRequest;
import com.elm.model.entity.User;
import com.elm.model.vo.UserResponse;

import java.sql.SQLException;

public class UserService {
    private static final UserDao userDao = new UserDao();

    public int saveUser(SaveUserRequest in) {
        try {

            return userDao.NewUser(new User(
                    in.getUserId(),
                    in.getPassword(),
                    in.getUserName(),
                    "",
                    in.getUserSex(),
                    (short) 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }


    public int GetUserById(GetUserRequest in) {
        try {
            return userDao.UserExists(new User(
                    in.getUserId(),
                    null,
                    null,
                    null,
                    (short) 0,
                    (short) 0)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public UserResponse Login(UserLoginRequest in) {
        try {
            return new UserResponse(userDao.findUser(new User(
                    in.getUserId(),
                    in.getPassword(),
                    null,
                    null,
                    (short) 0,
                    (short) 0)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
