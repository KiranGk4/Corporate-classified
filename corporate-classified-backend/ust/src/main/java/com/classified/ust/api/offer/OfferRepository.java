package com.classified.ust.api.offer;

import com.classified.ust.api.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    //Set<Offer> findAllByCategory(Long id);
    //Set<Offer> findOfferByCategory(Category id);

    //Set<Offer> findOfferByActive(boolean b);
   //@Query("SELECT c FROM Employee c WHERE c.category =?1")
    @Query("from Offer where category_id=?1")
    List<Offer> findAllByCategory(Long category_id);

    @Query("from Offer where offer_opened_date=?1")
    Set<Offer> findAllByOfferOpenedDate(LocalDate date);
    @Query("from Offer where employee_id=?1")
    Set<Offer> findAllByEmployeeId(Long id);
}
