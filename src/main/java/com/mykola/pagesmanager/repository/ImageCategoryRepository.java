package com.mykola.pagesmanager.repository;

import com.mykola.pagesmanager.entities.image.ImageCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository to work with Image category entity
 */
@Repository
public interface ImageCategoryRepository extends CrudRepository<ImageCategory, Long> {
}
