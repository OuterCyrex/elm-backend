package com.elm.service;

import com.elm.dao.FoodDao;
import com.elm.model.entity.Food;
import com.elm.model.vo.FoodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodDao foodDao;

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
        for (Food f : foodDao.findFood(food)) {
            respList.add(EntityToResponse(f));
        }
        return respList;
    }
}
