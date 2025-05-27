package com.elm.model.dto.order;

public class SaveOrderRequest {
    private Double orderTotal;
    private Integer daId;
    private String userId;
    private Integer businessId;

    public SaveOrderRequest() {}

    public SaveOrderRequest(Double orderTotal, Integer daId, String userId, Integer businessId) {
        this.orderTotal = orderTotal;
        this.daId = daId;
        this.userId = userId;
        this.businessId = businessId;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
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
}
