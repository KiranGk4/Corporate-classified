package com.classified.ust.api.like;

import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.offer.Offer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "classified_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long likeId;

    private String likedBy;

    private LocalDate likeDate;
    private boolean likeActive;

    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "like")
    //@JsonIgnore
    @Column(name = "offer_id")
    private List<Offer> offerList;*/

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "offer_id")
    private Offer offer;
}
