package com.NWACoders.mkOne.services;

import com.NWACoders.mkOne.exceptions.ImageNotFoundException;
import com.NWACoders.mkOne.models.Images;
import com.NWACoders.mkOne.repos.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {

    private final ImageRepository imageRepository;


    @Autowired
    public ImagesService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    //Creates a new image in the repo
    public Images addNewImage(Images image){
        return imageRepository.save(image);
    }

    //iterates and finds all images
    public Iterable<Images> displayAllImages(){
        return imageRepository.findAll();
    }

    public Images updateImage(Images image){
        return imageRepository.save(image);
    }

    public Images findImageById(int id){
        return imageRepository.findById(id)
                .orElseThrow(() -> new ImageNotFoundException("Image by id: " + id + " was not found."));
    }

    public void deleteImageById(int id){
        imageRepository.deleteById(id);
    }
}
