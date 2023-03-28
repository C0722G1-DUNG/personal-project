package com.example.shopinterior.repository.cart;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.dto.cart.ITotalCart;
import com.example.shopinterior.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findCartByUserIdAndProductIdProduct(Integer userId, Integer idProduct);

    @Query(value = "select c.id_cart as idCart, p.id_product as idProduct,p.name_product as nameProduct, " +
            "p.description as description,p.price as price,i.image_one as imageOne," +
            "c.user_id as id,c.quantity as quantity,(c.quantity*p.price) as totalCost from cart c " +
            "join product p on c.product_id_product = p.id_product join image i on i.product_id_product = p.id_product " +
            "where c.user_id = :idUser",
            countQuery = "select c.id_cart as idCart, p.id_product as idProduct,p.name_product as nameProduct, " +
                    "p.description as description,p.price as price,i.image_one as imageOne," +
                    "c.user_id as id,c.quantity as quantity,(c.quantity*p.price) as totalCost from cart c " +
                    "join product p on c.product_id_product = p.id_product join image i on i.product_id_product = p.id_product " +
                    "where c.user_id = :idUser",
            nativeQuery = true)
    List<ICartDto> findAllByUser(@Param("idUser") int idUser);

    @Query(value = "select sum(c.quantity*p.price)  as totalCostUser from cart c " +
            "join product p on c.product_id_product = p.id_product where c.user_id = :idUser",
            countQuery = "select sum(c.quantity*p.price)  as totalCostUser from cart c " +
                    "join product p on c.product_id_product = p.id_product where c.user_id = :idUser",
            nativeQuery = true)
    ITotalCart totalCostUser(@Param("idUser") int idUser);
}
