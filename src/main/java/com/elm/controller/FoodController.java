package com.elm.controller;

import com.elm.model.vo.FoodResponse;
import com.elm.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/FoodController")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/listFoodByBusinessId")
    private List<FoodResponse> ListFoodByBusinessId(@RequestParam Integer businessId) throws Exception {
        return foodService.FindFood(businessId);
    }
}
