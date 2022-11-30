package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.category.CategoryDto;
import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.like.Like;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "classified_offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long offerId;
    @Column(nullable = false)
    private String offerTitle;
    @Column(nullable = false)
    private String offerDescription;
    private int offerLikes;
    private boolean offerActive;
    @Column(nullable = false)
    private LocalDate offerOpenedDate;
    private LocalDate offerEngagedDate;
    private LocalDate offerClosedDate;
    @Column(nullable = false)
    private double offerPrice;
    private boolean offerNegotiable;
    private LocalDateTime offerCreatedDate;
    private LocalDateTime offerModifiedDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;      //Employee who posted the offer.

    @Column(name = "employee_engage_id")
    private long employeeEngage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

   /* @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDto category;

   /* @ManyToOne
    @JoinColumn(name = "like_id")
    private Like like;*/
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer")
   @JsonIgnore
   @Column(name = "like_id")
   private List<Like> likeList;


}
