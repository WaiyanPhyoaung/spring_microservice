package com.wypa.movie_info_service.controller;

import com.wypa.movie_info_service.data_source.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @GetMapping("/{movieId}")
    public MovieInfo getMovie(@PathVariable("movieId")int movieId){
        return new MovieInfo(1,"Kywar Sein Ma");
    }
}
