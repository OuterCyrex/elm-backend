package com.elm.dao;

import com.elm.model.entity.Business;
import com.elm.model.entity.Order;
import com.elm.model.entity.OrderDetail;
import com.elm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public List<Order> FindOrders(Order orderParam) throws SQLException {
        List<Order> orderList = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM orders WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (orderParam != null) {
            if (orderParam.getOrderId() != null) {
                sql.append(" AND orderId = ?");
                params.add(orderParam.getOrderId());
            }
            if (orderParam.getUserId() != null && !orderParam.getUserId().isEmpty()) {
                sql.append(" AND userId = ?");
                params.add(orderParam.getUserId());
            }
            if (orderParam.getBusinessId() != null) {
                sql.append(" AND businessId = ?");
                params.add(orderParam.getBusinessId());
            }
            if (orderParam.getOrderState() != null) {
                sql.append(" AND orderState = ?");
                params.add(orderParam.getOrderState());
            }
        }

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())
        ) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                BusinessDao businessDao = new BusinessDao();
                OrderDetailDao detailDao = new OrderDetailDao();

                while (rs.next()) {
                    Order order = new Order();
                    order.setOrderId(rs.getInt("orderId"));
                    order.setUserId(rs.getString("userId"));
                    order.setBusinessId(rs.getInt("businessId"));
                    order.setOrderDate(rs.getString("orderDate"));
                    order.setOrderTotal(rs.getDouble("orderTotal"));

                    int daId = rs.getInt("daId");
                    if (!rs.wasNull()) {
                        order.setDaId(daId);
                    } else {
                        order.setDaId(null);
                    }

                    order.setOrderState(rs.getInt("orderState"));

                    // 关联查询 Business
                    Business b = new Business();
                    b.setBusinessId(order.getBusinessId());
                    Business business = businessDao.FindBusiness(b).get(0);
                    order.setBusiness(business);

                    // 关联查询订单明细列表
                    OrderDetail detail = new OrderDetail();
                    detail.setOrderId(rs.getInt("orderId"));
                    List<OrderDetail> details = detailDao.FindOrderDetail(detail);
                    order.setList(details);

                    orderList.add(order);
                }
            }
        }

        return orderList;
    }

}
