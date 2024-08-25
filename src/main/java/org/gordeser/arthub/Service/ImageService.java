package org.gordeser.arthub.Service;

import lombok.RequiredArgsConstructor;
import org.gordeser.arthub.Entity.ImageEntity;
import org.gordeser.arthub.Repository.ImageRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageEntity getImageById(Long imageId) throws Exception {
        return imageRepository.findById(imageId).orElseThrow(Exception::new);
    }

    public ImageEntity createImage(ImageEntity imageEntity) throws Exception {
        return imageRepository.save(imageEntity);
    }

    public void deleteImageById(Long imageId) throws Exception {
        ImageEntity imageToDelete = imageRepository.findById(imageId).orElseThrow(Exception::new);
        imageRepository.delete(imageToDelete);
    }
}
