package com.elm.dao;

import com.elm.model.entity.Food;
import com.elm.model.entity.OrderDetail;
import com.elm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao {
    public List<OrderDetail> FindOrderDetail(OrderDetail detail) throws SQLException {
        List<OrderDetail> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM orderdetailet WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (detail.getOdId() != null) {
            sql.append(" AND odId = ?");
            params.add(detail.getOdId());
        }
        if (detail.getOrderId() != null) {
            sql.append(" AND orderId = ?");
            params.add(detail.getOrderId());
        }
        if (detail.getFoodId() != null) {
            sql.append(" AND foodId = ?");
            params.add(detail.getFoodId());
        }
        if (detail.getQuantity() != null) {
            sql.append(" AND quantity = ?");
            params.add(detail.getQuantity());
        }

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())
        ) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    OrderDetail od = new OrderDetail();
                    od.setOdId(rs.getInt("odId"));
                    od.setOrderId(rs.getInt("orderId"));
                    od.setFoodId(rs.getInt("foodId"));
                    od.setQuantity(rs.getInt("quantity"));

                    // 查询 Food 并补全
                    Food food = new Food();
                    food.setFoodId(od.getFoodId());
                    Food fullFood = new FoodDao().FindFood(food).get(0);
                    od.setFood(fullFood);

                    list.add(od);
                }
            }
        }

        return list;
    }
}
