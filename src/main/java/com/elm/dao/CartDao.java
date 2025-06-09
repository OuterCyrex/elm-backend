package com.elm.dao;

import com.elm.model.entity.Cart;
import com.elm.model.entity.Food;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface CartDao {

    @Insert("INSERT INTO cart (foodId, businessId, userId, quantity) VALUES (#{foodId}, #{businessId}, #{userId}, #{quantity})")
    int addCart(Cart cart);

    @SelectProvider(type = CartSqlProvider.class, method = "findCart")
    List<Cart> findCart(Cart cart);

    @Delete("DELETE FROM cart WHERE businessId = #{businessId} AND userId = #{userId} AND foodId = #{foodId}")
    int deleteCart(Cart cart);

    @Update("UPDATE cart SET quantity = #{quantity} WHERE businessId = #{businessId} AND userId = #{userId} AND foodId = #{foodId}")
    int updateCart(Cart cart);

    class CartSqlProvider {
        public String findCart(Cart c) {
            return new SQL() {{
                SELECT("*");
                FROM("cart");

                if (c.getCartId() != null) {
                    WHERE("cartId = #{cartId}");
                }
                if (c.getFoodId() != null) {
                    WHERE("foodId = #{foodId}");
                }
                if (c.getBusinessId() != null) {
                    WHERE("businessId = #{businessId}");
                }
                if (c.getUserId() != null && !c.getUserId().isEmpty()) {
                    WHERE("userId = #{userId}");
                }
                if (c.getQuantity() != null) {
                    WHERE("quantity = #{quantity}");
                }
            }}.toString();
        }
    }
}

