package com.example.shopinterior.service.oder;

import com.example.shopinterior.dto.oder.IPurchaseHistoryDto;
import com.example.shopinterior.entity.oder.PurchaseHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


public interface IPurchaseHistoryService {
    PurchaseHistory save(PurchaseHistory PurchaseHistory);
    Page<IPurchaseHistoryDto> showListPurchaseHistory(@Param("idOder") int idOder, Pageable pageable);
}
