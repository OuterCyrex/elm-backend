package com.elm.model.entity;

public class OrderDetail {
    private Integer odId;
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
    private Food food;

    public OrderDetail() {}

    public OrderDetail(Integer orderId, Integer odId, Integer quantity, Integer foodId, Food food) {
        this.orderId = orderId;
        this.odId = odId;
        this.quantity = quantity;
        this.foodId = foodId;
        this.food = food;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
