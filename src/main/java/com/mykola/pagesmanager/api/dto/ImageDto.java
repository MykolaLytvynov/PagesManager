package com.mykola.pagesmanager.api.dto;

import com.mykola.pagesmanager.entities.image.Image;
import com.mykola.pagesmanager.entities.image.ImageCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

/**
 * Image Dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    /** Name of the image */
    @NotEmpty(message = "Name should not be empty")
    private String name;

    /** Representation of an uploaded file received in a multipart request */
    private MultipartFile file;

    /** Image category, such as nature */
    @NotNull(message = "Category should be added")
    private ImageCategory category;

    /**
     * Get Image entity with from Image Dto
     *
     * @param imageDto - Image Dto
     * @return Image entity
     */
    public static Image fromImageDto(ImageDto imageDto) throws IOException {
        Image image = new Image();
        image.setName(imageDto.getName());
        image.setDate(new Date());
        image.setCategory(imageDto.getCategory());

        byte[] bytes = imageDto.getFile().getBytes();
        String imageBase64 = Base64.getEncoder().encodeToString(bytes);
        image.setBase64Image(imageBase64);

        return image;
    }
}
