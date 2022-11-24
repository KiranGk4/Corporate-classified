package com.classified.ust.api.category;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.offer.Offer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Slf4j
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id)
    {
        try
        {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Category> getCategory(@RequestBody Category category)
    {
        try
        {
            Category category1 = categoryService.addCategory(category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}