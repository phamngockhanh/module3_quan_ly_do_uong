package com.nhom2.project_capybra_system.entity;
public class Product {
    private Integer id;
    private String name;
    private Long price;
    private Integer categoryId;
    private Boolean status;
    private String description;
    private String image;
    private String size;

    public Product() {
    }

    public Product(Integer id, String name, Long price, Integer categoryId, Boolean status, String description, String image, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
        this.description = description;
        this.image = image;
        this.size = size;
    }

    public Product(String name, long price, int categoryId, boolean status, String description, String image) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
        this.description = description;
        this.image = image;
    }

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
