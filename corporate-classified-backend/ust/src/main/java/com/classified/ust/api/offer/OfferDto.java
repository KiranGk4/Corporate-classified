package com.classified.ust.api.offer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OfferDto {
    private int offerDtoLikes;
    private LocalDateTime offerDtoOpenedDate;
    private LocalDateTime offerDtoClosedDate;
    private LocalDateTime offerDtoEngagedDate;

}
