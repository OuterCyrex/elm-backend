package com.elm.controller;

import com.elm.model.dto.order.SaveOrderRequest;
import com.elm.model.entity.Order;
import com.elm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/OrdersController")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrders")
    private int CreateOrders(
            @RequestParam Double orderTotal,
            @RequestParam Integer daId,
            @RequestParam String userId,
            @RequestParam Integer businessId
    ) throws Exception {
        return orderService.createOrder(new SaveOrderRequest(orderTotal, daId, userId, businessId));
    }

    @PostMapping("/listOrdersByUserId")
    private List<Order> OrderList(@RequestParam String userId) throws Exception {
        return orderService.OrderList(userId);
    }

    @PostMapping("/getOrdersById")
    private Order GetOrderById(@RequestParam Integer orderId) throws Exception {
        return orderService.GetOrder(orderId);
    }
}