package com.example.shopinterior.controller;

import com.example.shopinterior.entity.product.Image;
import com.example.shopinterior.service.image.IImageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/image")
public class ImageRestController {
    @Autowired
    private IImageService iImageService;

    @PostMapping("/save")
    public ResponseEntity<Image> createDataForm(@Valid @RequestBody Image image, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
//        DataForm dataForm = new DataForm();
//        BeanUtils.copyProperties(dataFormDto, dataForm);
        iImageService.saveImage(image);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
