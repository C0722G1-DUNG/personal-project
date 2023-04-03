package com.example.shopinterior.repository.oder;

import com.example.shopinterior.entity.oder.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseHistoryRepository  extends JpaRepository<PurchaseHistory,Integer> {
}
