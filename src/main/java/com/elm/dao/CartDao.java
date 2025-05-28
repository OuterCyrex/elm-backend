package com.elm.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.elm.model.entity.Cart;
import com.elm.utils.DBUtil;

public class CartDao {

    /**
     * 添加购物车记录
     */
    public int addCart(Cart cart) throws SQLException {
        String sql = "INSERT INTO cart (cartId, foodId, businessId, userId, quantity) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, cart.getCartId());
        pstmt.setInt(2, cart.getFoodId());
        pstmt.setInt(3, cart.getBusinessId());
        pstmt.setString(4, cart.getUserId());
        pstmt.setInt(5, cart.getQuantity());

        int rowsAffected = pstmt.executeUpdate();

        conn.close();
        return rowsAffected;
    }

    /**
     * 查询购物车记录
     */
    public List<Cart> findCart(Cart cart) throws SQLException {
        List<Cart> cartList = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM cart WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (cart.getCartId() != null) {
            sql.append(" AND cartId = ?");
            params.add(cart.getCartId());
        }
        if (cart.getFoodId() != null) {
            sql.append(" AND foodId = ?");
            params.add(cart.getFoodId());
        }
        if (cart.getBusinessId() != null) {
            sql.append(" AND businessId = ?");
            params.add(cart.getBusinessId());
        }
        if (cart.getUserId() != null && !cart.getUserId().isEmpty()) {
            sql.append(" AND userId = ?");
            params.add(cart.getUserId());
        }
        if (cart.getQuantity() != null) {
            sql.append(" AND quantity = ?");
            params.add(cart.getQuantity());
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
                    Cart c = new Cart();
                    c.setCartId(rs.getInt("cartId"));
                    c.setFoodId(rs.getInt("foodId"));
                    c.setBusinessId(rs.getInt("businessId"));
                    c.setUserId(rs.getString("userId"));
                    c.setQuantity(rs.getInt("quantity"));
                    cartList.add(c);
                }
            }
        }

        return cartList;
    }
}
