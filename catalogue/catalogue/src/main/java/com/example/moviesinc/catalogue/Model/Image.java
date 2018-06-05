package com.example.moviesinc.catalogue.Model;

public class Image {

    private String imgSrc;
    private Boolean selected;
    private Boolean isAvailableFullSize;

    public Image(String imgSrc, Boolean selected, Boolean isAvailableFullSize) {
        this.imgSrc = imgSrc;
        this.selected = selected;
        this.isAvailableFullSize = isAvailableFullSize;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getAvailableFullSize() {
        return isAvailableFullSize;
    }

    public void setAvailableFullSize(Boolean availableFullSize) {
        isAvailableFullSize = availableFullSize;
    }
}
