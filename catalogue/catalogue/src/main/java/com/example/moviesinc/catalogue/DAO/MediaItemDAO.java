package com.example.moviesinc.catalogue.DAO;

import com.example.moviesinc.catalogue.Model.MediaItem;

import java.util.List;

public interface MediaItemDAO  {

    List<MediaItem> findMediaItems(String medium);

    void save(MediaItem mediaItem);

}
