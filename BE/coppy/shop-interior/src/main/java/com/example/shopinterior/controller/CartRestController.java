package com.example.shopinterior.controller;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.service.account.IUserService;
import com.example.shopinterior.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartRestController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public ResponseEntity<List<ICartDto>> getList(@RequestParam(defaultValue = "") int idAccount) {
        Optional<User> user = iUserService.findByIdAccount(idAccount);
        if (user.isPresent()) {
            List<ICartDto> cartList = iCartService.findAllByUser(user.get());
            if (!cartList.isEmpty()) {
                return new ResponseEntity<>(cartList, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
