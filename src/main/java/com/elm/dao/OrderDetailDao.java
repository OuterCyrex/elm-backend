package com.elm.dao;

import com.elm.model.entity.OrderDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface OrderDetailDao {

    @SelectProvider(type = OrderDetailSqlProvider.class, method = "findOrderDetail")
    List<OrderDetail> findOrderDetail(OrderDetail detail);

    class OrderDetailSqlProvider {
        public String findOrderDetail(OrderDetail d) {
            return new SQL() {{
                SELECT("*");
                FROM("orderdetailet");

                if (d.getOdId() != null) {
                    WHERE("odId = #{odId}");
                }
                if (d.getOrderId() != null) {
                    WHERE("orderId = #{orderId}");
                }
                if (d.getFoodId() != null) {
                    WHERE("foodId = #{foodId}");
                }
                if (d.getQuantity() != null) {
                    WHERE("quantity = #{quantity}");
                }
            }}.toString();
        }
    }
}
