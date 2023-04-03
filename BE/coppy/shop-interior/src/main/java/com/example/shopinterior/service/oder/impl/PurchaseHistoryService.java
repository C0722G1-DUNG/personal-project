package com.example.shopinterior.service.oder.impl;

import com.example.shopinterior.entity.oder.PurchaseHistory;
import com.example.shopinterior.repository.oder.IPurchaseHistoryRepository;
import com.example.shopinterior.service.oder.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseHistoryService implements IPurchaseHistoryService {
    @Autowired
    private IPurchaseHistoryRepository iPurchaseHistoryRepository;
    @Override
    public PurchaseHistory save(PurchaseHistory purchaseHistory) {
        return iPurchaseHistoryRepository.save(purchaseHistory);
    }
}
