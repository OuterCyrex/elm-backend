package com.elm.dao;

import com.elm.model.entity.User;
import com.elm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * NewUser 返回RowsAffected
     */
    public int NewUser(User user) throws SQLException {
        String sql = "INSERT INTO user (userId, password, userName, userSex, userImg, delTag) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn;
        PreparedStatement pstmt;

        conn = DBUtil.getConnection();
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getUserName());
        pstmt.setShort(4, user.getUserSex());
        pstmt.setString(5, user.getUserImg());
        pstmt.setShort(6, user.getDelTag());

        int rowsAffected = pstmt.executeUpdate();
        conn.close();

        return rowsAffected;
    }

    public int UserExists(User user) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM user WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (user.getUserId() != null) {
            sql.append(" AND userId = ?");
            params.add(user.getUserId());
        }
        if (user.getPassword() != null) {
            sql.append(" AND password = ?");
            params.add(user.getPassword());
        }
        if (user.getUserName() != null) {
            sql.append(" AND userName = ?");
            params.add(user.getUserName());
        }
        if (user.getUserSex() != 0) {
            sql.append(" AND userSex = ?");
            params.add(user.getUserSex());
        }
        if (user.getUserImg() != null) {
            sql.append(" AND userImg = ?");
            params.add(user.getUserImg());
        }

        sql.append(" AND delTag = 0");

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())
        ) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }

    public User findUser(User user) throws SQLException {
        StringBuilder sql = new StringBuilder("SELECT * FROM user WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (user.getUserId() != null) {
            sql.append(" AND userId = ?");
            params.add(user.getUserId());
        }
        if (user.getPassword() != null) {
            sql.append(" AND password = ?");
            params.add(user.getPassword());
        }
        if (user.getUserName() != null) {
            sql.append(" AND userName = ?");
            params.add(user.getUserName());
        }
        if (user.getUserSex() != 0) {
            sql.append(" AND userSex = ?");
            params.add(user.getUserSex());
        }
        if (user.getUserImg() != null) {
            sql.append(" AND userImg = ?");
            params.add(user.getUserImg());
        }

        sql.append(" AND delTag = 0");

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())
        ) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("userName"),
                        rs.getString("userImg"),
                        rs.getShort("userSex"),
                        (short) 0
                );
            }
        }

        return null;
    }
}
