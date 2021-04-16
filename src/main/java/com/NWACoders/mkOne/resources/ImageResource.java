package com.NWACoders.mkOne.resources;

import com.NWACoders.mkOne.models.Images;
import com.NWACoders.mkOne.services.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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

    @GetMapping("find/{id}")
    public  ResponseEntity<Images> findImageById(@PathVariable("id") int id){
        if(imagesService.findImageById(id) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Images foundImage = imagesService.findImageById(id);
        return new ResponseEntity<>(foundImage, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Images> addNewImage(@RequestBody Images image){
//        if(image.getImageName() == null || image.getImageName().isEmpty()
//                || Float.toString(image.getSize()) == null || Float.toString(image.getSize()).isEmpty()
//        && image.getSize() > 5.00){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

//        image.setImageCode(UUID.randomUUID().toString());
        Images newImage = imagesService.addNewImage(image);

        return new ResponseEntity<>(newImage, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Images> updateExistingImage(@RequestBody Images images){

        if(images.getName() == null || images.getName().isEmpty()
                || Float.toString(images.getSize()) == null || Float.toString(images.getSize()).isEmpty() ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Images updatedImage = imagesService.updateImage(images);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExistingImageById(@PathVariable("id") int id){
        imagesService.deleteImageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
