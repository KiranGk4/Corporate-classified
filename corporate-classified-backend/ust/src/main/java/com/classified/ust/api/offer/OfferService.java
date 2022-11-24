package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.like.Like;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Slf4j
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    public Set<Offer> getAllOfferByEmployeeId(Long id)
    {
        return offerRepository.findAllByEmployeeId(id);
    }

   /* public Set<Offer> getAllOffer()
    {
        return offerRepository.findOfferByActive(true);
    }*/

    public Offer saveOffer(Offer offer)
    {
        offer.setOfferActive(true);
        offer.setOfferOpenedDate(LocalDate.now());
        offer.setOfferCreatedDate(LocalDateTime.now());
       // Employee employee = (Employee)auth.getPrincipal();
        //System.out.println(employee.getEmployeeEmail());
        //offer.setEmployee();
        return offerRepository.save(offer);
    }

    public Offer updateOffer(Offer offer) {
        Offer updateOffer = offerRepository.findById(offer.getOfferId()).orElseThrow(()-> new NoSuchElementException());
        updateOffer.setOfferModifiedDate(LocalDateTime.now());
        updateOffer.setOfferDescription(offer.getOfferDescription());
        updateOffer.setOfferNegotiable(offer.isOfferNegotiable());
        updateOffer.setCategory(offer.getCategory());
        updateOffer.setOfferPrice(offer.getOfferPrice());
        updateOffer.setOfferTitle(offer.getOfferTitle());
        return offerRepository.save(updateOffer);
    }

    public List<Offer> getOfferByCategory(Long id)
    {
        return offerRepository.findAllByCategory(id);
    }

    public List<Offer> getOfferAll() {
        return offerRepository.findAll();
    }

    public Set<Offer> getOfferAllByDate(LocalDate date){
        return offerRepository.findAllByOfferOpenedDate(date);
    }


}

