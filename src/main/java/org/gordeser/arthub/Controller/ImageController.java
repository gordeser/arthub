package org.gordeser.arthub.Controller;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.ImageEntity;
import org.gordeser.arthub.Service.ImageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images/")
@CrossOrigin("")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{image_id}")
    public ImageEntity getImageById(@PathVariable("image_id") Long imageId) throws Exception {
        return imageService.getImageById(imageId);
    }

    @PostMapping
    public ImageEntity createImage(@Validated(ImageEntity.class) @RequestBody ImageEntity image) throws Exception {
        return imageService.createImage(image);
    }

    @DeleteMapping("{image_id}")
    public void deleteImageById(@PathVariable("image_id") Long imageId) throws Exception {
        imageService.deleteImageById(imageId);
    }
}

