package com.cg.films.dto;

public class CategoryDTO {
    private Long categoryId;
    private String name;

    public CategoryDTO(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}