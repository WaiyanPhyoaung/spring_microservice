package com.wypa.rating_data_service.controller;


import com.wypa.rating_data_service.data_source.RatingInfo;
import com.wypa.rating_data_service.data_source.RatingList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @GetMapping("/movies/{movieId}")
    public RatingInfo getRating(@PathVariable("movieId")int movieId){
        return new RatingInfo(1, 5);
    }
    @GetMapping("/user/{userId}")
    public RatingList getRatingLists(@PathVariable("userId")int userId){
        List<RatingInfo> lists =  List.of(
                new RatingInfo(1,5),
                new RatingInfo(1,4),
                new RatingInfo(1,4)
        );

        RatingList ratings = new RatingList();
        ratings.setLists(lists);

        return ratings;
    }
}
