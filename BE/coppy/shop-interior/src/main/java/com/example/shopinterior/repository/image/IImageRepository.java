package com.example.shopinterior.repository.image;

import com.example.shopinterior.entity.product.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IImageRepository extends JpaRepository<Image,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into image (image_one,image_two,image_three) values (:imageOne,:imageTwo,:imageThree)",nativeQuery = true)
    void saveImage(@Param("imageOne") String imageOne,@Param("imageTwo") String imageTwo,@Param("imageThree") String imageThree);
}
