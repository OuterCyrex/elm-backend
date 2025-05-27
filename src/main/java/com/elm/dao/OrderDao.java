package com.elm.dao;

import com.elm.model.entity.Order;
import com.elm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class OrderDao {
    public int NewOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (userId, businessId, orderDate, orderTotal, daId, orderState) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, order.getUserId());
        pstmt.setInt(2, order.getBusinessId());
        pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new java.util.Date()));
        pstmt.setDouble(4, order.getOrderTotal());
        pstmt.setInt(5, order.getDaId());
        pstmt.setInt(6, 0);

        int rowsAffected = pstmt.executeUpdate();
        conn.close();

        return rowsAffected;
    }
}
