package com.enigma.wulan.models;

import javax.validation.constraints.NotNull;

public class TransactionRequest {

    private Integer itemId;

    @NotNull
    private Integer quantity;

    private Integer userId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
