package com.classified.ust.api.category;

import com.classified.ust.api.offer.Offer;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new NoSuchElementException());
    }


    public Category addCategory(Category category) {
        category.setCategoryActive(true);
        category.setCategoryCreatedDate(LocalDateTime.now());
        category.setCategoryModifiedDate(category.getCategoryCreatedDate());
        return categoryRepository.save(category);
    }

    public List<Category> getCategoryAll() {
        return categoryRepository.findAll();
    }

    public List<CategoryDto> convertToCategoryDto(List<Category> category) {
        return category.stream().map(e-> modelMapper.map(e, CategoryDto.class)).collect(Collectors.toList());
    }
}
