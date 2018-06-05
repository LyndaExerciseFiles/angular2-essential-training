package com.example.moviesinc.catalogue.Service;

import com.example.moviesinc.catalogue.Model.MediaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemServiceImpl implements MediaItemService {

    @Autowired
    private MediaItemBO mediaItemBO;


    @Override
    public List<MediaItem> findMediaItems(String medium) {
        return mediaItemBO.findMediaItems(medium);
    }

    @Override
    public void save(MediaItem mediaItem) {
        mediaItemBO.save(mediaItem);
    }
}
