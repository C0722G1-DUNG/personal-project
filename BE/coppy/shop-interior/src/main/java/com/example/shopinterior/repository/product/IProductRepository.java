package com.example.shopinterior.repository.product;

import com.example.shopinterior.dto.product.IProductDto;
import com.example.shopinterior.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p.id_product as idProduct, p.name_product as nameProduct ,p.description as description,p.price as price,c.id_category as idCategory," +
            "c.name_category as nameCategory,i.id_image as idImage,i.image_one as imageOne, i.image_two as imageTwo ," +
            "i.image_three as imageThree FROM product p join image i on i.product_id_product=p.id_product " +
            "join category c on p.category_id_category = c.id_category where flag_delete = false" +
            " and p.name_product like %:searchNameProduct% and price between :searchMinPrice" +
            " and :searchMaxPrice order by id_product desc",
            countQuery = "select p.id_product as idProduct, p.name_product as nameProduct,p.description as description ,p.price as price,c.id_category as idCategory," +
                    "c.name_category as nameCategory,i.id_image as idImage,i.image_one as imageOne, i.image_two as imageTwo " +
                    ",i.image_three as imageThree FROM product p join image i on i.product_id_product=p.id_product " +
                    "join category c on p.category_id_category = c.id_category where flag_delete = false " +
                    " and p.name_product like %:searchNameProduct% and price between :searchMinPrice " +
                    "and :searchMaxPrice order by id_product desc",
            nativeQuery = true)
    Page<IProductDto> showListProduct(@Param("searchNameProduct") String searchNameProduct, @Param("searchMinPrice") Double searchMinPrice, @Param("searchMaxPrice") Double searchMaxPrice,Pageable pageable);

    @Query(value = "select p.id_product as idProduct, p.name_product as nameProduct ,p.description as description,p.price as price," +
            "c.id_category as idCategory,c.name_category as nameCategory,i.id_image as idImage,i.image_one as imageOne, " +
            "i.image_two as imageTwo ,i.image_three as imageThree FROM product p " +
            "join image i on i.product_id_product=p.id_product " +
            "join category c on p.category_id_category = c.id_category where flag_delete = false and p.id_product = :idProduct order by id_product desc",
            countQuery = "select p.id_product as idProduct, p.name_product as nameProduct,p.description as description ,p.price as price," +
                    "c.id_category as idCategory,c.name_category as nameCategory,i.id_image as idImage,i.image_one as imageOne, " +
                    "i.image_two as imageTwo ,i.image_three as imageThree FROM product p " +
                    "join image i on i.product_id_product=p.id_product join category c on p.category_id_category = c.id_category" +
                    " where flag_delete = false and p.id_product = :idProduct order by id_product desc",
            nativeQuery = true)
    IProductDto findByIdProduct(@Param("idProduct") int idProduct);

    @Transactional
    @Modifying
    @Query(value = "insert into product (name_product,price,flag_delete) values (:nameProduct,:price,false )", nativeQuery = true)
    void saveProduct(@Param("nameProduct") String nameProduct, @Param("price") Double price);

    @Query(value = "select p.id_product as idProduct, p.name_product as nameProduct ,p.description as description,p.price as price,c.id_category as idCategory," +
            "c.name_category as nameCategory,i.id_image as idImage,i.image_one as imageOne, i.image_two as imageTwo ," +
            "i.image_three as imageThree FROM product p join image i on i.product_id_product=p.id_product " +
            "join category c on p.category_id_category = c.id_category where flag_delete = false order by id_product desc",
            countQuery = "select p.id_product as idProduct, p.name_product as nameProduct,p.description as description ,p.price as price,c.id_category as idCategory," +
                    "c.name_category as nameCategory,i.id_image as idImage,i.image_one as imageOne, i.image_two as imageTwo " +
                    ",i.image_three as imageThree FROM product p join image i on i.product_id_product=p.id_product " +
                    "join category c on p.category_id_category = c.id_category where flag_delete = false  order by id_product desc",
            nativeQuery = true)
    Page<IProductDto> showList(Pageable pageable);

}
