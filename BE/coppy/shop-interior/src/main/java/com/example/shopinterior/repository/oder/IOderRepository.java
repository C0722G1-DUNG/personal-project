package com.example.shopinterior.repository.oder;

import com.example.shopinterior.dto.oder.IOderDto;
import com.example.shopinterior.entity.oder.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IOderRepository  extends JpaRepository<Oder,Integer> {
    @Query(value = "SELECT o.id_oder as idOder, o.delivery_address as deliveryAddress , o.deliver_phone as deliverPhone," +
            " o.order_date as orderDate, o.order_value as orderValue, u.name as name FROM oder o " +
            "join user u on o.user_id = u.id order by id_oder desc",
            countQuery = "SELECT o.id_oder as idOder, o.delivery_address as deliveryAddress , o.deliver_phone as deliverPhone, " +
                    "o.order_date as orderDate, o.order_value as orderValue, u.name as name FROM oder o " +
                    "join user u on o.user_id = u.id order by id_oder desc",
            nativeQuery = true)
    Page<IOderDto> showListOder(Pageable pageable);
}
