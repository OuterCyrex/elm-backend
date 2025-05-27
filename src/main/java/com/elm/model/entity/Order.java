package com.elm.model.entity;

public class Order {
    private Integer orderId;
    private String userId;
    private Integer businessId;
    private String orderDate;

    public Order() {}

    public Order(Integer orderId, String userId, Integer businessId, String orderDate, Double orderTotal, Integer orderState, Integer daId) {
        this.orderId = orderId;
        this.userId = userId;
        this.businessId = businessId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.orderState = orderState;
        this.daId = daId;
    }

    private Double orderTotal;
    private Integer daId;
    private Integer orderState;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
}
