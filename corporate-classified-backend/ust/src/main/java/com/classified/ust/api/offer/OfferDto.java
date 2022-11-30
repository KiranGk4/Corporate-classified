package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.category.CategoryDto;
import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.employee.EmployeeDto;
import com.classified.ust.api.like.Like;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class OfferDto {
    private long offerId;
    private int offerLikes;
    private LocalDate offerOpenedDate;
    private LocalDate offerClosedDate;
    private LocalDate offerEngagedDate;
    private String offerTitle;
    private String offerDescription;

    private boolean offerActive;

    private double offerPrice;
    private boolean offerNegotiable;
    private EmployeeDto employee;      //Employee who posted the offer.

    private long employeeEngage;

    private CategoryDto category;


}
