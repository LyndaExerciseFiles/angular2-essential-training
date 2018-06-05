package com.example.moviesinc.catalogue.DAO;

import com.example.moviesinc.catalogue.Model.Image;
import com.example.moviesinc.catalogue.Model.MediaItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MediaItemDAOHib implements MediaItemDAO {


    private List<MediaItem> mediaItemList = new ArrayList<>();

    @Override
    public List<MediaItem> findMediaItems(String medium) {

        if(medium.equalsIgnoreCase("All") || medium.equalsIgnoreCase("")){
            return mediaItemList;
        } else {
             return mediaItemList.stream().filter( mediaItem -> mediaItem.getMedium().equalsIgnoreCase(medium) ).collect(Collectors.toList());
        }

    }

    @Override
    public void save(MediaItem mediaItem) {
        mediaItemList.add(mediaItem);
    }

}
