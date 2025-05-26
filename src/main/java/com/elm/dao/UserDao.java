package com.elm.dao;

import com.elm.model.User;
import com.elm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class UserDao {

    /**
     * NewUser 返回RowsAffected
     */
    public int NewUser(User user) throws SQLException {
        String sql = "INSERT INTO user (userId, password, userName, userSex, userImg, delTag) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getUserName());
        pstmt.setShort(4, user.getUserSex());
        pstmt.setString(5, user.getUserImg());
        pstmt.setShort(6, user.getDelTag());

        return pstmt.executeUpdate();
    }

}
