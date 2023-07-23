package com.mykola.pagesmanager.api.controller;

import com.mykola.pagesmanager.api.dto.ImageDto;
import com.mykola.pagesmanager.service.ImageCategoryService;
import com.mykola.pagesmanager.service.ImageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Controller of images
 */
@Controller
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageCategoryService categoryService;

    /**
     * Get the "save" view by HTTP GET request
     *
     * @param model - Interface that defines a holder for model attributes
     * @return - The view "save"
     */
    @GetMapping("/add")
    public String addImage(Model model){
        model.addAttribute("imageDto", new ImageDto());
        model.addAttribute("categories", categoryService.viewAll());
        return "image/save";
    }

    /**
     * Add the image to the database
     *
     * @param imageDto - Image Dto
     * @param bindingResult - BindingResult holds the result of a validation
     *                      and binding and contains errors that may have occurred
     * @param model - Interface that defines a holder for model attributes
     * @return The view "getAll"
     */
    @PostMapping("/add")
    public String addImagePost(@ModelAttribute("imageDto") @Valid ImageDto imageDto,
                               BindingResult bindingResult, Model model) throws IOException {
        // Checking if the user has added an image
        if (imageDto.getFile().getBytes().length == 0) {
            bindingResult.addError(new FieldError("imageDto", "file", "Page should be added"));
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.viewAll());
            return "image/save";
        }
        imageService.addImage(imageDto);
        return "redirect:/images";
    }

    /**
     * Get the "getAll" view where all the images will be.
     * List of the images should be sorted by date added, the newest first.
     *
     * @param model - Interface that defines a holder for model attributes
     * @return The view "getAll"
     */
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("images", imageService.getSortedImages());
        return "image/getAll";
    }

    /**
     * Get the image by id
     *
     * @param id - Image id
     * @param model - Interface that defines a holder for model attributes
     * @return The view "showOneImage"
     */
    @GetMapping("/{id}")
    public String getImage(@PathVariable("id") long id, Model model){
        model.addAttribute("image", imageService.viewById(id));
        return "image/showOneImage";
    }
}
