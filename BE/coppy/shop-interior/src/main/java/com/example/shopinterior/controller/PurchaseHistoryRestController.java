package com.example.shopinterior.controller;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.dto.oder.IPurchaseHistoryDto;
import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.entity.oder.PurchaseHistory;
import com.example.shopinterior.service.oder.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/history")
public class PurchaseHistoryRestController {
    @Autowired
    private IPurchaseHistoryService iPurchaseHistoryService;

    @GetMapping("{id}")
    public ResponseEntity<Page<IPurchaseHistoryDto>> getList(@PageableDefault(page = 0, size = 3) Pageable pageable,@PathVariable int id) {
            Page<IPurchaseHistoryDto> purchaseHistories = iPurchaseHistoryService.showListPurchaseHistory(id,pageable);
            if (!purchaseHistories.isEmpty()){
                return new ResponseEntity<>(purchaseHistories, HttpStatus.OK);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
