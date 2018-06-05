package com.example.moviesinc.catalogue.Model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class MediaItem {
    private int id;
    private String name;
    private String medium;
    private String category;
    private int year;
    private Double rating;
    private Date watchedOn;
    private String movieId;
    private Boolean isFavourite;
    private List<Image> images;

    public MediaItem(){}

    public MediaItem(String name, String medium, String category, String year, Double rating, Date watchedOn, String movieId, Boolean isFavourite) {
        this.id = id;
        this.name = name;
        this.medium = medium;
        this.category = category;
        this.year = Integer.parseInt(year);
        this.rating = rating;
        this.watchedOn = watchedOn;
        this.movieId = movieId;
        this.isFavourite = isFavourite;
    }

    public MediaItem(int id, String name, String medium, String category, int year, Double rating, Date watchedOn, String movieId, Boolean isFavourite) {
        this.id = id;
        this.name = name;
        this.medium = medium;
        this.category = category;
        this.year = year;
        this.rating = rating;
        this.watchedOn = watchedOn;
        this.movieId = movieId;
        this.isFavourite = isFavourite;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Date getWatchedOn() {
        return watchedOn;
    }

    public void setWatchedOn(Date watchedOn) {
        this.watchedOn = watchedOn;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
