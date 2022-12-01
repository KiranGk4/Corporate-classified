package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import com.classified.ust.api.category.CategoryDto;
import com.classified.ust.api.employee.Employee;
import com.classified.ust.api.like.Like;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OfferService {
    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ModelMapper modelMapper;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    public Set<Offer> getAllOfferByEmployeeId(Long id)
    {
        Set<Offer> offer = offerRepository.findAllByEmployeeId(id);
        for(Offer o:offer)
        {
            o.setOfferLikes((int) getLikeCount(o));
            offerRepository.save(o);
        }
        return offer;
    }

   /* public Set<Offer> getAllOffer()
    {
        return offerRepository.findOfferByActive(true);
    }*/

    public Offer saveOffer(Offer offer)
    {
        log.info("saving the offer"+LocalDate.now());
        offer.setOfferActive(true);
        LocalDate date = LocalDate.now();
        offer.setOfferOpenedDate(date);
        offer.setOfferCreatedDate(LocalDateTime.now());
       // Employee employee = (Employee)auth.getPrincipal();
        //System.out.println(employee.getEmployeeEmail());
        //offer.setEmployee();
        return offerRepository.save(offer);
    }

    public void updateOffer(Offer offer) {

        Offer updateOffer = offerRepository.findById(offer.getOfferId()).orElseThrow(()-> new NoSuchElementException());
        updateOffer.setOfferModifiedDate(LocalDateTime.now());
        updateOffer.setOfferTitle(offer.getOfferTitle());
        updateOffer.setOfferDescription(offer.getOfferDescription());
        updateOffer.setOfferNegotiable(offer.isOfferNegotiable());
        updateOffer.setCategory(offer.getCategory());
        Offer newOffer = offerRepository.save(updateOffer);
        log.info(newOffer+" >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //return newOffer;
        //updateOffer.setOfferPrice(offer.getOfferPrice());
       // updateOffer.setOfferTitle(offer.getOfferTitle());
        //return offerRepository.save(updateOffer);
    }

    public List<Offer> getOfferByCategory(Long id)
    {
        return offerRepository.findAllByCategory(id);
    }


    public List<Offer> getOfferAll() {
        List<Offer> offer = offerRepository.findAll();
        for(Offer o:offer)
        {
            o.setOfferLikes((int) getLikeCount(o));
            offerRepository.save(o);
        }
        return offer;
    }

    public Set<Offer> getOfferAllByDate(LocalDate date){
        return offerRepository.findAllByOfferOpenedDate(date);
    }

    public static long getLikeCount(Offer offer)
    {
       // Offer offer = offerRepository.findById(id).orElseThrow(()->new NoSuchElementException());
        long count = offer.getLikeList().stream().filter(like -> like.isLikeActive()).count();
        return count;
    }

    public List<OfferDto> convertToOfferDtoList(List<Offer> offer) {
        return offer.stream().map(e->modelMapper.map(e, OfferDto.class)).collect(Collectors.toList());
    }
    public OfferDto convertToOfferDto(Offer offer)
    {
        return modelMapper.map(offer, OfferDto.class);
    }

    public Set<OfferDto> convertToOfferDtoSet(Set<Offer> offer) {
        return offer.stream().map(e->modelMapper.map(e, OfferDto.class)).collect(Collectors.toSet());
    }

    public Offer getOfferById(Long offerId) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+offerId);
        return offerRepository.findById(offerId).orElseThrow(()->new NoSuchElementException());
    }

    public void engageOffer(Offer offer) {
        Offer updateOffer = offerRepository.findById(offer.getOfferId()).orElseThrow(()->new NoSuchElementException());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>"+offer.getEmployeeEngage());
        updateOffer.setEmployeeEngage(offer.getEmployeeEngage());
        log.info(">>>>>>>>>>>>>>UPdateOffer>>>>>>>>>>>"+updateOffer.getEmployeeEngage());
        updateOffer.setOfferEngagedDate(LocalDate.now());
        updateOffer.setOfferClosedDate(LocalDate.now());
        Offer newOffer = offerRepository.save(updateOffer);
        log.info(">>>>>>>>>>>>>>> "+newOffer);

        //updateOffer.setOfferActive(false);
        //return offerRepository.save(updateOffer);
    }
   /* public CategoryDto convertCategoryToDTO(Category category)
    {
        //return studentDTOList.stream().map(e->modelMapper.map(e, StudentDTO.class)).collect(Collectors.toList());
        return modelMapper.map(category, CategoryDto.class);
    }*/
}

