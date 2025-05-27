package com.elm.service;

import com.elm.dao.FoodDao;
import com.elm.model.entity.Food;
import com.elm.model.vo.FoodResponse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodService {
    FoodDao foodDao = new FoodDao();

    private FoodResponse EntityToResponse(Food food) {
        return new FoodResponse(
                food.getFoodId(),
                food.getFoodName(),
                food.getFoodExplain(),
                food.getFoodImg(),
                food.getFoodPrice(),
                food.getBusinessId(),
                food.getRemarks()
        );
    }

    public List<FoodResponse> FindFood(int BusinessId) throws SQLException {
        Food food = new Food();
        food.setBusinessId(BusinessId);
        List<FoodResponse> respList = new ArrayList<>();
        for (Food f : foodDao.FindFood(food)) {
            respList.add(EntityToResponse(f));
        }
        return respList;
    }
}
