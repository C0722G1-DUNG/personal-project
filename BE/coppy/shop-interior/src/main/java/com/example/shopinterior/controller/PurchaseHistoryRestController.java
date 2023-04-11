package com.example.shopinterior.controller;

import com.example.shopinterior.dto.oder.IPurchaseHistoryDto;
import com.example.shopinterior.dto.oder.SellingProducts;
import com.example.shopinterior.service.oder.IPurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/history")
public class PurchaseHistoryRestController {
    @Autowired
    private IPurchaseHistoryService iPurchaseHistoryService;

    @GetMapping("")
    public ResponseEntity<Page<SellingProducts>> getListSellingProduct(@PageableDefault(page = 0, size = 3) Pageable pageable) {
        Page<SellingProducts> sellingProducts = iPurchaseHistoryService.showListSellingProducts(pageable);
        if (!sellingProducts.isEmpty()){
            return new ResponseEntity<>(sellingProducts, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<IPurchaseHistoryDto>> getList(@PathVariable int id) {
            List<IPurchaseHistoryDto> purchaseHistories = iPurchaseHistoryService.showListPurchaseHistory(id);
            if (!purchaseHistories.isEmpty()){
                return new ResponseEntity<>(purchaseHistories, HttpStatus.OK);
            }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
