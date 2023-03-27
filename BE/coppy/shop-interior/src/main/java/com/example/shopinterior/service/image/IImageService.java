package com.example.shopinterior.service.image;

import com.example.shopinterior.entity.product.Image;
import org.springframework.data.repository.query.Param;

public interface IImageService {
    void saveImage(Image image);
}
