package com.elm.dao;

import com.elm.model.entity.Food;
import com.elm.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {

    public List<Food> FindFood(Food criteria) throws SQLException {
        Connection conn = DBUtil.getConnection();

        List<Food> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM food WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (criteria.getFoodId() != null) {
            sql.append(" AND foodId = ?");
            params.add(criteria.getFoodId());
        }
        if (criteria.getFoodName() != null && !criteria.getFoodName().isEmpty()) {
            sql.append(" AND foodName LIKE ?");
            params.add("%" + criteria.getFoodName() + "%");
        }
        if (criteria.getFoodExplain() != null && !criteria.getFoodExplain().isEmpty()) {
            sql.append(" AND foodExplain LIKE ?");
            params.add("%" + criteria.getFoodExplain() + "%");
        }
        if (criteria.getFoodImg() != null && !criteria.getFoodImg().isEmpty()) {
            sql.append(" AND foodImg = ?");
            params.add(criteria.getFoodImg());
        }
        if (criteria.getFoodPrice() != null) {
            sql.append(" AND foodPrice = ?");
            params.add(criteria.getFoodPrice());
        }
        if (criteria.getBusinessId() != null) {
            sql.append(" AND businessId = ?");
            params.add(criteria.getBusinessId());
        }
        if (criteria.getRemarks() != null && !criteria.getRemarks().isEmpty()) {
            sql.append(" AND remarks LIKE ?");
            params.add("%" + criteria.getRemarks() + "%");
        }

        PreparedStatement ps = conn.prepareStatement(sql.toString());

        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Food food = new Food();
            food.setFoodId(rs.getInt("foodId"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodExplain(rs.getString("foodExplain"));
            food.setFoodImg(rs.getString("foodImg"));
            food.setFoodPrice(rs.getDouble("foodPrice"));
            food.setBusinessId(rs.getInt("businessId"));
            food.setRemarks(rs.getString("remarks"));

            result.add(food);
        }

        conn.close();
        return result;
    }
}

