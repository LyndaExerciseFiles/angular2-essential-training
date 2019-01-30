package com.example.moviesinc.catalogue.DAO;

import com.example.moviesinc.catalogue.Model.MediaItem;

import java.util.List;

public interface MediaItemDAO  {

    List<MediaItem> findMediaItems(String medium, String movieName, String category);

    void save(MediaItem mediaItem);

}
