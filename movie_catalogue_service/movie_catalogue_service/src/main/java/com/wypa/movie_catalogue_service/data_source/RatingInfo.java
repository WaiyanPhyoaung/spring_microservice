package com.wypa.movie_catalogue_service.data_source;

public class RatingInfo {
    private int movieId;
    private int rating;

    public RatingInfo() {
    }

    public RatingInfo(int movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
