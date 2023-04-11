package com.example.shopinterior.repository.oder;

import com.example.shopinterior.dto.oder.IPurchaseHistoryDto;
import com.example.shopinterior.dto.oder.SellingProducts;
import com.example.shopinterior.entity.oder.PurchaseHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IPurchaseHistoryRepository  extends JpaRepository<PurchaseHistory,Integer> {
    @Query(value = "SELECT ph.id_purchase_history, ph.quantity as quantity ,p.name_product as nameProduct,p.price as price ," +
            " i.image_one as imageOne FROM purchase_history ph join product p on ph.product_id_product = p.id_product " +
            "join oder o on o.id_oder = ph.oder_id_oder join image i on i.product_id_product = p.id_product " +
            "where  oder_id_oder = :idOder order by  ph.id_purchase_history desc",
            countQuery = "SELECT ph.id_purchase_history, ph.quantity as quantity ,p.name_product as nameProduct,p.price as price ," +
                    " i.image_one as imageOne FROM purchase_history ph join product p on ph.product_id_product = p.id_product " +
                    "join oder o on o.id_oder = ph.oder_id_oder join image i on i.product_id_product = p.id_product " +
                    "where  oder_id_oder = :idOder order by  ph.id_purchase_history desc",
            nativeQuery = true)
    List<IPurchaseHistoryDto> showListPurchaseHistory(@Param("idOder") int idOder);
    @Query(value = "select  p.quantity as quantity, p.id_product as idProduct, p.price as price, i.image_one as imageOne, p.name_product as nameProduct," +
            " sum(ph.quantity) as total from purchase_history ph " +
            "join product p on ph.product_id_product = p.id_product " +
            "join image i on i.product_id_product = p.id_product" +
            " GROUP BY ph.product_id_product " +
            "order by total desc",
            countQuery = "select  p.quantity as quantity, p.id_product as idProduct, p.price as price, i.image_one as imageOne, p.name_product as nameProduct, " +
                    "sum(ph.quantity) as total from purchase_history ph " +
                    "join product p on ph.product_id_product = p.id_product " +
                    "join image i on i.product_id_product = p.id_product " +
                    "GROUP BY ph.product_id_product " +
                    "order by total desc;",
            nativeQuery = true)
    Page<SellingProducts> showListSellingProducts(Pageable pageable);
}
