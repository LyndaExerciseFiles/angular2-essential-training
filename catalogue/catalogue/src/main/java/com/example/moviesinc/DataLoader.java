package com.example.moviesinc;

import com.example.moviesinc.catalogue.Model.Image;
import com.example.moviesinc.catalogue.Model.MediaItem;
import com.example.moviesinc.catalogue.Service.MediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private Image image1 = new Image("./media/firebug1.png", true, true);
    private Image image2 = new Image("./media/firebug2.png", false, false);
    private Image image3 = new Image("./media/smalltall1.png", false, false);
    private Image image4 = new Image("./media/smalltall2.png", false, true);

    private List<Image> imageList1 = new ArrayList<Image>();
    private List<Image> imageList2 = new ArrayList<Image>();

    private MediaItem mediaItem1 = new MediaItem(1, "Firebug", "Series", "Science Fiction", 2010, 1.00, new Date(), "A1234567890", false);
    private MediaItem mediaItem2 = new MediaItem(2, "The Small Tall", "Movies", "Comedy", 2015, 3.50, new Date(), "A1234567891", true);
    private MediaItem mediaItem3 = new MediaItem(3, "The Redemption", "Movies", "Action", 2016, 4.7, new Date(), "A1234567892", false);
    private MediaItem mediaItem4 = new MediaItem(4, "Hoopers", "Series", "Drama", 2013, 3.2, new Date(), "A1234567893", true);
    private MediaItem mediaItem5 = new MediaItem(5, "Happy Joe: Cheery Road", "Movies", "Action", 2010, 1.9, new Date(), "A1234567894", false);

    @Autowired
    private MediaItemService mediaItemService ;

    public void run(ApplicationArguments args) {
        imageList1.add(image1);
        imageList1.add(image2);
        mediaItem1.setImages(imageList1);
        mediaItemService.save(mediaItem1);

        imageList2.add(image3);
        imageList2.add(image4);
        mediaItem2.setImages(imageList2);
        mediaItemService.save(mediaItem2);

        mediaItemService.save(mediaItem3);
        mediaItemService.save(mediaItem4);
        mediaItemService.save(mediaItem5);
    }
}

