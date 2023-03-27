package com.example.shopinterior.controller;

import com.example.shopinterior.dto.product.IProductDto;
import com.example.shopinterior.dto.product.ProductDto;
import com.example.shopinterior.entity.product.Product;
import com.example.shopinterior.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public ResponseEntity<Page<IProductDto>> searchByContent(@RequestParam() Optional<String> searchNameProduct,
                                                             @RequestParam() Optional<Double> searchMinPrice,
                                                             @RequestParam() Optional<Double> searchMaxPrice,@PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<IProductDto> productDtoList;
        String searchNameProductValue = searchNameProduct.orElse("");
        Double searchMinPriceValue = searchMinPrice.orElse(0.0);
        Double searchMaxPriceValue = searchMaxPrice.orElse(99999999999999999.0);
        if (!searchNameProductValue.equals("")|| searchMinPriceValue!=0.0||searchMaxPriceValue!=99999999999999999.0){
            productDtoList= iProductService.showListProduct(searchNameProductValue,searchMinPriceValue,searchMaxPriceValue,pageable);
        }
        else {
            productDtoList = iProductService.showList(pageable);
        }
        if (productDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<IProductDto> showListClassStudentById(@PathVariable("id") int id) {
        IProductDto productDto = iProductService.findByIdProduct(id);
        if (productDto==null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Product> createDataForm(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
