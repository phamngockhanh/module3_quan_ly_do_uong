package com.nhom2.project_capybra_system.entity;

public class ProductTopping {
    private Integer id;
    private Integer productId;
    private Integer toppingId;

    public ProductTopping() {
    }

    public ProductTopping(Integer id, Integer productId, Integer toppingId) {
        this.id = id;
        this.productId = productId;
        this.toppingId = toppingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getToppingId() {
        return toppingId;
    }

    public void setToppingId(Integer toppingId) {
        this.toppingId = toppingId;
    }
}
