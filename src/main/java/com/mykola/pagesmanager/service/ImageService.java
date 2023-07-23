package com.mykola.pagesmanager.service;

import com.mykola.pagesmanager.api.dto.ImageDto;
import com.mykola.pagesmanager.entities.image.Image;
import com.mykola.pagesmanager.exception.NotFoundException;
import com.mykola.pagesmanager.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Image Service
 */
@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    /**
     * Save the new image to the database
     *
     * @param imageDto - Image Dto
     * @return The saved Image
     */
    public Image addImage(ImageDto imageDto) throws IOException {
        return imageRepository.save(ImageDto.fromImageDto(imageDto));
    }

    /**
     * Get List of the all images.
     *
     * @return List of the all images
     */
    public List<Image> viewAll() {
        return (List<Image>) imageRepository.findAll();
    }

    /**
     * Get List of the sorted images.
     * List of the images should be sorted by date added, the newest first.
     *
     * @return List of the sorted images
     */
    public List<Image> getSortedImages() {
        return imageRepository.findByOrderByDateDesc();
    }

    /**
     * Get the image by id
     *
     * @param id - Image id
     * @return the found image
     */
    public Image viewById(long id) {
        // If the image is not found, then exception will be
        NotFoundException notFoundException = new NotFoundException("Image was not found by id = " + id);
        Image result = imageRepository.findById(id).orElse(null);
        if (result == null) throw notFoundException;
        return result;
    }

}
