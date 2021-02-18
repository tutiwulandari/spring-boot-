package com.enigma.wulan.models;

public class ItemElement {

    private Integer id;
    private Integer price;
    private String name;
    private Integer stock;
    private UnitModel unitId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public UnitModel getUnitId() {
        return unitId;
    }

    public void setUnitId(UnitModel unitId) {
        this.unitId = unitId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

