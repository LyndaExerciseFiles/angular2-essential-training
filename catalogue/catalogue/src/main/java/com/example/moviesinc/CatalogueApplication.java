package com.example.moviesinc;

import com.example.moviesinc.catalogue.Model.Image;
import com.example.moviesinc.catalogue.Model.MediaItem;
import com.example.moviesinc.catalogue.Service.MediaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueApplication.class, args);

	}

}

