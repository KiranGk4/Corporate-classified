package com.classified.ust.api.like;

import com.classified.ust.api.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class LikeController {
    @Autowired
    LikeService likeService;

    @GetMapping("/like/{id}")
    public ResponseEntity<Like> getLike(@PathVariable Long id)
    {
        try
        {
            Like like = likeService.getLikeById(id);
            return new ResponseEntity<Like>(like, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/like")
    public ResponseEntity<Like> addLike(@RequestBody Like like)
    {
        try
        {
            Like like1 = likeService.addLike(like);
            return new ResponseEntity<Like>(like1,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/like")
    public ResponseEntity<Like> updateLike(@RequestBody Like like)
    {
        try
        {
            Like like1 = likeService.updateLike(like);
            return new ResponseEntity<Like>(like1,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
