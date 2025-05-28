package com.elm.service;

import com.elm.dao.OrderDao;
import com.elm.model.dto.order.SaveOrderRequest;
import com.elm.model.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private static final OrderDao orderDao = new OrderDao();

    public int createOrder(SaveOrderRequest in) throws SQLException {
        Order order = new Order();
        order.setUserId(in.getUserId());
        order.setBusinessId(in.getBusinessId());
        order.setDaId(in.getDaId());
        order.setOrderTotal(in.getOrderTotal());
        return orderDao.NewOrder(order);
    }

    public List<Order> OrderList(String UserId) throws SQLException {
        Order order = new Order();
        order.setUserId(UserId);
        return orderDao.FindOrders(order);
    }

    public Order GetOrder(int OrderId) throws SQLException {
        Order order = new Order();
        order.setOrderId(OrderId);
        return orderDao.FindOrders(order).get(0);
    }
}
