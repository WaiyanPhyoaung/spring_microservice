package com.wypa.movie_catalogue_service.controller;

import com.wypa.movie_catalogue_service.data_source.MovieCatalogueItem;
import com.wypa.movie_catalogue_service.data_source.MovieInfo;
import com.wypa.movie_catalogue_service.data_source.RatingInfo;
import com.wypa.movie_catalogue_service.data_source.RatingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webBuilder;

    @GetMapping("/{userId}")
    public List<MovieCatalogueItem> getMovies(@PathVariable("userId") int userId){

        RatingList ratings = restTemplate.getForObject("http://rating/ratings/user/" + userId
                , RatingList.class);

        List<MovieCatalogueItem> catalogueItems = ratings.getLists().stream().map(rating -> {
            MovieInfo movie = restTemplate.getForObject("http://movieInfo/movies/" + rating.getMovieId(), MovieInfo.class);
            return new MovieCatalogueItem(movie.getMovie_name(), "Description", rating.getRating());
        }).collect(Collectors.toList());

        return catalogueItems;
    }
}

// 'Using Web Client'
//    MovieInfo movie = webBuilder.build().get().uri("http://localhost:8181/movies/" + rating.getMovieId())
//            .retrieve().bodyToMono(MovieInfo.class).block();