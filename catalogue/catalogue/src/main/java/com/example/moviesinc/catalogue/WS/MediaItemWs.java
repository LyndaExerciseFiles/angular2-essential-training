package com.example.moviesinc.catalogue.WS;

import com.example.moviesinc.catalogue.Model.MediaItem;
import com.example.moviesinc.catalogue.Service.MediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service("mediaItemWs")
@RestController
@RequestMapping("/mediaitems")
public class MediaItemWs {

    @Autowired
    public MediaItemService mediaItemService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<MediaItem> findMediaItems(@RequestParam(defaultValue="All") String medium) {
        return mediaItemService.findMediaItems(medium);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void addMediaItem(@RequestBody MediaItem mediaItem) {
        mediaItemService.save(mediaItem);
    }

}
