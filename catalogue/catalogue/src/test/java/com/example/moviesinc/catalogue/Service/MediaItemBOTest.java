package com.example.moviesinc.catalogue.Service;

import com.example.moviesinc.BaseBOTest;
import com.example.moviesinc.catalogue.DAO.MediaItemDAO;
import com.example.moviesinc.catalogue.Model.MediaItem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MediaItemBOTest extends BaseBOTest {

    private final Logger LOG = LoggerFactory.getLogger(MediaItemBOTest.class);

    @Mock
    private MediaItemDAO mediaItemDAO;

    @InjectMocks
    private MediaItemBOImpl mediaItemBO;

    @Before
    public void setUp() {
        mediaItemBO = new MediaItemBOImpl();
        MockitoAnnotations.initMocks(this);
    }

    private MediaItem prepareMediaItemData() {
        MediaItem entity = new MediaItem();
        entity.setId(1);
        entity.setYear(2010);
        entity.setImages(null);
        entity.setCategory("Action");
        entity.setFavourite(true);
        entity.setMedium("Movies");
        entity.setMovieId("ABC01234DEF56");
        entity.setName("The Expendables");
        entity.setWatchedOn(new Date());
        entity.setRating(1.0);
        return entity;
    }

    @Test
    public void test01_findMediaItems_validData_noException() throws Exception {
        LOG.debug("Ïnvoking test01_findMediaItems_validData_noException to get All Media Items Match the criteria");
        MediaItem mediaItem = prepareMediaItemData();
        List<MediaItem> mediaItemList = new ArrayList<>();
        mediaItemList.add(mediaItem);
        when(mediaItemDAO.findMediaItems(anyString())).thenReturn(mediaItemList);

        mediaItemBO.findMediaItems("Movies");
        verify(mediaItemDAO).findMediaItems("Movies");
    }

    @Test
    public void test02_save_validData_noException() throws Exception {
        LOG.debug("Ïnvoking test02_save_validData_noException to save media item");
        MediaItem mediaItem = prepareMediaItemData();
        mediaItemBO.save(mediaItem);
        verify(mediaItemDAO).save(mediaItem);
    }
}
