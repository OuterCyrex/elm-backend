package com.elm.dao;

import com.elm.model.entity.Food;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface FoodDao {

    @SelectProvider(type = FoodSqlProvider.class, method = "findFood")
    List<Food> findFood(Food criteria);

    class FoodSqlProvider {
        public String findFood(Food f) {
            return new SQL() {{
                SELECT("*");
                FROM("food");

                if (f.getFoodId() != null) {
                    WHERE("foodId = #{foodId}");
                }
                if (f.getFoodName() != null && !f.getFoodName().isEmpty()) {
                    WHERE("foodName LIKE CONCAT('%', #{foodName}, '%')");
                }
                if (f.getFoodExplain() != null && !f.getFoodExplain().isEmpty()) {
                    WHERE("foodExplain LIKE CONCAT('%', #{foodExplain}, '%')");
                }
                if (f.getFoodImg() != null && !f.getFoodImg().isEmpty()) {
                    WHERE("foodImg = #{foodImg}");
                }
                if (f.getFoodPrice() != null) {
                    WHERE("foodPrice = #{foodPrice}");
                }
                if (f.getBusinessId() != null) {
                    WHERE("businessId = #{businessId}");
                }
                if (f.getRemarks() != null && !f.getRemarks().isEmpty()) {
                    WHERE("remarks LIKE CONCAT('%', #{remarks}, '%')");
                }
            }}.toString();
        }
    }
}

