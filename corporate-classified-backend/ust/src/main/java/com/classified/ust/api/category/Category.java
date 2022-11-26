package com.classified.ust.api.category;

import com.classified.ust.api.offer.Offer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "classified_category")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    @Column(nullable = false)
    private String categoryName;
    private boolean categoryActive;
    @Column(nullable = false)
    private LocalDateTime categoryCreatedDate;
    private LocalDateTime categoryModifiedDate;

    /*public Category(long categoryId) {
        this.categoryId = categoryId;
    }*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @JsonIgnore
    @Column(name ="offer_id")
    private List<Offer> offerList;
}
