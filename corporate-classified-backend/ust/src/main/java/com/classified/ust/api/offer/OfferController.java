package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.employee.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@Slf4j
public class OfferController {
    @Autowired
    OfferService offerService;

    @GetMapping("/offer-by-employee/{id}")
    public ResponseEntity<Set<Offer>> getOffer(@PathVariable Long id)
    {
        try
        {
            Set<Offer> offer = offerService.getAllOfferByEmployeeId(id);
            return new ResponseEntity<Set<Offer>>(offer, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post-offer")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer)
    {
        try
        {
            Offer offer1 = offerService.saveOffer(offer);
            return new ResponseEntity<>(offer1,HttpStatus.CREATED);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @PutMapping("/update-offer")
    public ResponseEntity<Offer> updateOffer(@RequestBody Offer offer)
    {
        try
        {
            Offer offer1 = offerService.updateOffer(offer);
            return new ResponseEntity<>(offer1,HttpStatus.CREATED);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping("/offer-by-category/{id}")
    public ResponseEntity <List<Offer>> getOfferByCategory(@PathVariable Long id) {
        try {
            List<Offer> offer = offerService.getOfferByCategory(id);
            return new ResponseEntity<List<Offer>>(offer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/offer-by-date/{date}")
    public ResponseEntity <Set<Offer>> getOfferByDate(@PathVariable LocalDate date) {
        try {
            Set<Offer> offer = offerService.getOfferAllByDate(date);
            return new ResponseEntity<Set<Offer>>(offer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/offer-all")
    public ResponseEntity <List<Offer>> getAllOffer() {
        try {
            List<Offer> offer = offerService.getOfferAll();
            return new ResponseEntity<List<Offer>>(offer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
