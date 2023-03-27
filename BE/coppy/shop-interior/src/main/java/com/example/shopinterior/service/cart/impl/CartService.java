package com.example.shopinterior.service.cart.impl;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.repository.cart.ICartRepository;
import com.example.shopinterior.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;
    @Override
    public List<ICartDto> findAllByUser(User user) {
        return iCartRepository.findAllByUser(user.getId());
    }
}
