package com.classified.ust.api.category;

import com.classified.ust.api.offer.Offer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }


    public Category addCategory(Category category) {
        category.setCategoryActive(true);
        category.setCategoryCreatedDate(LocalDateTime.now());
        category.setCategoryModifiedDate(category.getCategoryCreatedDate());
        return categoryRepository.save(category);
    }
}
