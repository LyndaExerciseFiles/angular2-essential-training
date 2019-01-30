package com.example.moviesinc.catalogue.WS;

import com.example.moviesinc.catalogue.Model.Filter;
import com.example.moviesinc.catalogue.Model.MediaItem;
import com.example.moviesinc.catalogue.Service.MediaItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service("mediaItemWs")
@RestController
@RequestMapping("/mediaitems")
public class MediaItemWs {

    @Autowired
    public MediaItemService mediaItemService;

    @RequestMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<MediaItem> findMediaItems(@RequestParam(defaultValue="All") String medium, @RequestParam(name="filter", required = false) String filterJson) {
        ObjectMapper mapper = new ObjectMapper();
        Filter filter = new Filter();
        try {
            filter = mapper.readValue(filterJson, Filter.class);
        }catch (Exception e){
            System.out.println("no filter");
        }
        if( filter != null) {
            return mediaItemService.findMediaItems(medium, filter.getMovieName()!= null ? filter.getMovieName() : "", filter.getCategory()!= null ? filter.getCategory() : "");
        } else {
            return mediaItemService.findMediaItems(medium, null, null);
        }
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public void addMediaItem(@RequestBody MediaItem mediaItem) {
        mediaItemService.save(mediaItem);
    }

}
