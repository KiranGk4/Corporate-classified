package com.classified.ust.api.category;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CategoryDto {
    private long categoryId;
    private String categoryName;
}
