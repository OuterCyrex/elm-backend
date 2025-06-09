package com.elm.service;

import com.elm.dao.BusinessDao;
import com.elm.dao.OrderDao;
import com.elm.model.dto.order.SaveOrderRequest;
import com.elm.model.entity.Business;
import com.elm.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BusinessDao businessDao;

    public int createOrder(SaveOrderRequest in) throws SQLException {
        Order order = new Order();
        order.setUserId(in.getUserId());
        order.setBusinessId(in.getBusinessId());
        order.setDaId(in.getDaId());
        order.setOrderTotal(in.getOrderTotal());
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        order.setOrderState(0);
        return orderDao.newOrder(order);
    }

    public List<Order> OrderList(String UserId) throws SQLException {
        Order order = new Order();
        order.setUserId(UserId);
        List<Order> orderList = orderDao.findOrders(order);

        for (Order orderItem : orderList) {
            Business b = new Business();
            b.setBusinessId(orderItem.getBusinessId());
            orderItem.setBusiness(businessDao.findBusiness(b).get(0));
        }

        return orderList;
    }

    public Order GetOrder(int OrderId) throws SQLException {
        Order order = new Order();
        order.setOrderId(OrderId);

        order = orderDao.findOrders(order).get(0);

        Business b = new Business();
        b.setBusinessId(order.getBusinessId());
        order.setBusiness(businessDao.findBusiness(b).get(0));

        return order;
    }
}
