package com.example.shopinterior.service.product.impl;

import com.example.shopinterior.dto.product.IProductDto;
import com.example.shopinterior.entity.product.Product;
import com.example.shopinterior.repository.product.IProductRepository;
import com.example.shopinterior.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Page<IProductDto> showListProduct(String searchNameProduct, Double searchMinPrice, Double searchMaxPrice, Pageable pageable) {
        return iProductRepository.showListProduct(searchNameProduct,searchMinPrice,searchMaxPrice,pageable);
    }

    @Override
    public IProductDto findByIdProduct(int idProduct) {
        return iProductRepository.findByIdProduct(idProduct);
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.saveProduct(product.getNameProduct(),product.getPrice());
    }

    @Override
    public Page<IProductDto> showList(Pageable pageable) {
        return iProductRepository.showList(pageable);
    }

}
