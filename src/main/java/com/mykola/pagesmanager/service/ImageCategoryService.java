package com.mykola.pagesmanager.service;

import com.mykola.pagesmanager.entities.image.ImageCategory;
import com.mykola.pagesmanager.repository.ImageCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Image category Service
 */
@Service
public class ImageCategoryService {
    @Autowired
    private ImageCategoryRepository categoryRepository;

    /**
     * Save the new image category to the database
     *
     * @param imageCategory - the new image category
     * @return The saved Image category
     */
    public ImageCategory save(ImageCategory imageCategory) {
        return categoryRepository.save(imageCategory);
    }

    /**
     * Get List of the all image categories.
     *
     * @return List of the all image categories
     */
    public List<ImageCategory> viewAll() {
        return (List<ImageCategory>) categoryRepository.findAll();
    }
}
