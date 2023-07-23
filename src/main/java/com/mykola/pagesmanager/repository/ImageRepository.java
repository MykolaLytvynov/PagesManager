package com.mykola.pagesmanager.repository;

import com.mykola.pagesmanager.entities.image.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JpaRepository to work with Image entity
 */
@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    /**
     * Get List of the sorted images.
     * List of the images should be sorted by date added, the newest first.
     *
     * @return List of the sorted images
     */
    List<Image> findByOrderByDateDesc();
}
