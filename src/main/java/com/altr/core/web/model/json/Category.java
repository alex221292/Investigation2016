package com.altr.core.web.model.json;


public class Category {
    private String categoryName;
    private String categoryId;

    public Category(String name, String id) {
        this.categoryName = name;
        this.categoryId = id;
    }

    public Category() {
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    public String getId() {
        return categoryId;
    }

    public void setId(String id) {
        this.categoryId = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + categoryName + '\'' +
                ", id='" + categoryId + '\'' +
                '}';
    }
}
