package com.wypa.movie_catalogue_service.data_source;

import java.util.List;

public class RatingList {
    private List<RatingInfo> lists;

    public RatingList() {
    }

    public RatingList(List<RatingInfo> lists) {
        this.lists = lists;
    }

    public List<RatingInfo> getLists() {
        return lists;
    }

    public void setLists(List<RatingInfo> lists) {
        this.lists = lists;
    }
}
