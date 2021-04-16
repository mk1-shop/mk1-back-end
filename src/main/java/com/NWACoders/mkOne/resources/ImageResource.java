package com.NWACoders.mkOne.resources;

import com.NWACoders.mkOne.models.Images;
import com.NWACoders.mkOne.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*")
public class ImageResource {


    private final ImagesService imagesService;

    @Autowired
    public ImageResource(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Images>> getAllAvaliableImages(){
       Iterable<Images> images = imagesService.displayAllImages();
       return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Images> addNewImage(Images image){
        //setting up a unique id for the image added
        image.setImageCode(UUID.randomUUID().toString());
        Images newImage = imagesService.addNewImage(image);

        return new ResponseEntity<>(newImage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Images> updateExistingImage(Images images){
        Images updatedImage = imagesService.updateImage(images);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExistingImageById(@PathVariable("id") int id){
        imagesService.deleteImageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
