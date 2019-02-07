package com.example.moviesinc.catalogue.DAO;

import com.example.moviesinc.catalogue.Model.Image;
import com.example.moviesinc.catalogue.Model.MediaItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
public class MediaItemDAOHib implements MediaItemDAO {


    private List<MediaItem> mediaItemList = new ArrayList<>();

    @Override
    public List<MediaItem> findMediaItems(String medium, String movieName, String category) {
        List<MediaItem> resultList = new ArrayList<>();
        resultList = mediaItemList.stream().filter( !category.isEmpty() && !category.equalsIgnoreCase("All") ? m -> m.getCategory().equalsIgnoreCase(category) : m -> true).collect(toList());
        resultList = resultList.stream().filter( !movieName.isEmpty() ? m -> m.getName().contains(movieName) : m -> true).collect(toList());
        return resultList.stream().filter( !medium.isEmpty() && !medium.equalsIgnoreCase("All") ? m -> m.getMedium().equalsIgnoreCase(medium): m->true).collect(toList());
    }

    @Override
    public void save(MediaItem mediaItem) {
        mediaItemList.add(mediaItem);
    }

}
