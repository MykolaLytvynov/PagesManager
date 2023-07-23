package com.mykola.pagesmanager.entities.image;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Image entity
 */
@Entity
@Data
@Table(name = "image_table")
public class Image {

    /** Image id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    /** Image encoded in Base64 */
    private String base64Image;

    /** Name of the image */
    private String name;

    /** Date when the image was added */
    private Date date = new Date();

    /** Image category, such as nature */
    @ManyToOne(fetch = FetchType.LAZY)
    private ImageCategory category;
}
