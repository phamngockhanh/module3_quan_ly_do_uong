package com.nhom2.project_capybra_system.entity;

public class Category {
    private Integer id;
    private String name;

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
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
}
