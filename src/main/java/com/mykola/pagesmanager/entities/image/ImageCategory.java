package com.mykola.pagesmanager.entities.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Image category entity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "image_category")
public class ImageCategory {

    /** Image category id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Name of the Image category */
    private String name;
}
