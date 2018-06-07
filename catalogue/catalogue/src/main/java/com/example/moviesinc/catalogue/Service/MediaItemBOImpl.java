package com.example.moviesinc.catalogue.Service;

import com.example.moviesinc.catalogue.DAO.MediaItemDAO;
import com.example.moviesinc.catalogue.DAO.MediaItemDAOHib;
import com.example.moviesinc.catalogue.Model.MediaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemBOImpl implements MediaItemBO {

    @Autowired
    private MediaItemDAO mediaItemDAO;

    @Override
    public List<MediaItem> findMediaItems(String medium) {
        return mediaItemDAO.findMediaItems(medium);
    }

    @Override
    public void save(MediaItem mediaItem) {
        mediaItemDAO.save(mediaItem);
    }

}
