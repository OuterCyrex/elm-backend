package com.elm.controller;

import com.elm.model.vo.BusinessResponse;
import com.elm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @PostMapping("/listBusinessByOrderTypeId")
    private List<BusinessResponse> ListBusinessByOrderTypeId(@RequestParam Integer orderTypeId) throws Exception {
        return businessService.GetBusinessByOrderTypeId(orderTypeId);
    }

    @PostMapping("/getBusinessById")
    private BusinessResponse GetBusinessById(@RequestParam Integer businessId) throws Exception {
        return businessService.GetBusinessById(businessId);
    }
}
