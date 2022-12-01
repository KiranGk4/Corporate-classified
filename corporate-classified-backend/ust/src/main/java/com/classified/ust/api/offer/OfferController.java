package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.employee.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/offer-by-employee/{id}")
    public ResponseEntity<Set<OfferDto>> getOffer(@PathVariable Long id)
    {
        try
        {
            Set<Offer> offer = offerService.getAllOfferByEmployeeId(id);
            Set<OfferDto> offerDtoSet = offerService.convertToOfferDtoSet(offer);
            return new ResponseEntity<Set<OfferDto>>(offerDtoSet, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/post-offer")
    public ResponseEntity<OfferDto> addOffer(@RequestBody Offer offer)
    {
        log.info("add offer");
        try
        {
            Offer offer1 = offerService.saveOffer(offer);
            OfferDto offerDto = offerService.convertToOfferDto(offer1);
            return new ResponseEntity<OfferDto>(offerDto,HttpStatus.CREATED);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping("/update-offer/{id}")
    public void updateOffer(@RequestBody Offer offer,@PathVariable Long id)
    {

            offerService.updateOffer(offer);
            //OfferDto offerDto = offerService.convertToOfferDto(offer1);
           // return offer1;

    }

    @CrossOrigin("http://localhost:4200/")
    @PutMapping("/engage-offer")
    public void engageOffer(@RequestBody Offer offer)
    {

            offerService.engageOffer(offer);
            //OfferDto offerDto = offerService.convertToOfferDto(offer1);
          //  return offer1;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/offer-by-category/{id}")
    public ResponseEntity <List<OfferDto>> getOfferByCategory(@PathVariable Long id) {
        try {
            List<Offer> offer = offerService.getOfferByCategory(id);
            List<OfferDto> offerDtoList = offerService.convertToOfferDtoList(offer);
           // List<OfferDto> offerDto = offerService.
            return new ResponseEntity<List<OfferDto>>(offerDtoList, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/offer-by-date/{date}")
    public ResponseEntity <Set<OfferDto>> getOfferByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        try {
            Set<Offer> offer = offerService.getOfferAllByDate(date);
            Set<OfferDto> offerDtoSet = offerService.convertToOfferDtoSet(offer);
            return new ResponseEntity<Set<OfferDto>>(offerDtoSet, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/offer-all")
    public ResponseEntity <List<OfferDto>> getAllOffer() {
        try {
            List<Offer> offer = offerService.getOfferAll();
            List<OfferDto> offerDtoList = offerService.convertToOfferDtoList(offer);
            return new ResponseEntity<List<OfferDto>>(offerDtoList, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/offer-by-id/{offerId}")
    public ResponseEntity <OfferDto> getAllOffer(@PathVariable Long offerId) {
        try {
            Offer offer = offerService.getOfferById(offerId);
            OfferDto offerDto = offerService.convertToOfferDto(offer);
            return new ResponseEntity<OfferDto>(offerDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   /* @GetMapping("/offer-like/{id}")
    public ResponseEntity<?> getLikeCount(@PathVariable long id)
    {
        try {
            Offer offer = offerService.getLikeCount(id);
            return new ResponseEntity<>(offer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }*/
}
