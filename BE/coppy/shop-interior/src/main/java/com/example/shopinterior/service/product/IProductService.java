package com.example.shopinterior.service.product;

import com.example.shopinterior.dto.product.IProductDto;
import com.example.shopinterior.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IProductService {
    Page<IProductDto> showListProduct(@Param("searchNameProduct") String searchNameProduct, @Param("searchMinPrice") Double searchMinPrice, @Param("searchMaxPrice") Double searchMaxPrice, Pageable pageable);
    IProductDto findByIdProduct(@Param("idProduct") int idProduct);
    void saveProduct(Product product);
    Page<IProductDto> showList(Pageable pageable);
    Optional<Product> findById(Integer id);
    void update(Product product);
}
