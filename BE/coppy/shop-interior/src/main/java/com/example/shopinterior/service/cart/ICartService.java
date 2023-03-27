package com.example.shopinterior.service.cart;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.entity.account.User;



import java.util.List;

public interface ICartService {
    List<ICartDto> findAllByUser(User user);
}
