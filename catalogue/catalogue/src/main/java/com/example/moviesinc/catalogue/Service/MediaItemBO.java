package com.example.moviesinc.catalogue.Service;

import com.example.moviesinc.catalogue.Model.MediaItem;

import java.util.List;

public interface MediaItemBO {

    public List<MediaItem> findMediaItems(String medium, String movieName, String category);

    public void save(MediaItem mediaItem);

}
