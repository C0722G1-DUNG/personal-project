package com.example.shopinterior.service.image.impl;

import com.example.shopinterior.entity.product.Image;
import com.example.shopinterior.repository.image.IImageRepository;
import com.example.shopinterior.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepository iImageRepository;
    @Override
    public void saveImage(Image image) {
        iImageRepository.saveImage(image.getImageOne(),image.getImageTwo(),image.getImageThree());
    }
}
