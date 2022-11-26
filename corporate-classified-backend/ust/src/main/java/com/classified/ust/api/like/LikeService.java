package com.classified.ust.api.like;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class LikeService {
    @Autowired
    LikeRepository likeRepository;

    public Like getLikeById(Long id) {
        return likeRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    public Like addLike(Like like)
    {
        like.setLikeActive(true);
        like.setLikeDate(LocalDate.now());
        like.getOffer().setOfferLikes((like.getOffer().getOfferLikes()+1));
        return likeRepository.save(like);
    }

    public Like updateLike(Like like)
    {
        boolean likeStatus = likeRepository.findById(like.getLikeId()).isPresent();
        if(likeStatus)
        {
            like.setLikeActive(false);
        }
        else
        {
            like.setLikeActive(true);
        }
        like.setLikeDate(LocalDate.now());
        return likeRepository.save(like);
    }
}
