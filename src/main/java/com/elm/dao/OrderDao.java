package com.elm.dao;

import com.elm.model.entity.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrderDao {

    @Insert("INSERT INTO orders (userId, businessId, orderDate, orderTotal, daId, orderState) " +
            "VALUES (#{userId}, #{businessId}, #{orderDate}, #{orderTotal}, #{daId}, #{orderState})")
    int newOrder(Order order);

    @SelectProvider(type = OrderSqlProvider.class, method = "findOrders")
    List<Order> findOrders(Order order);

    class OrderSqlProvider {
        public String findOrders(Order o) {
            return new SQL() {{
                SELECT("*");
                FROM("orders");

                if (o.getOrderId() != null) {
                    WHERE("orderId = #{orderId}");
                }
                if (o.getUserId() != null && !o.getUserId().isEmpty()) {
                    WHERE("userId = #{userId}");
                }
                if (o.getBusinessId() != null) {
                    WHERE("businessId = #{businessId}");
                }
                if (o.getOrderState() != null) {
                    WHERE("orderState = #{orderState}");
                }
            }}.toString();
        }
    }
}

