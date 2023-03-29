package com.example.shopinterior.service.cart;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.dto.cart.ITotalCart;
import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.entity.cart.Cart;
import com.example.shopinterior.entity.product.Product;



import java.util.List;
import java.util.Optional;

public interface ICartService {
    List<ICartDto> findAllByUser(User user);
    Optional<Cart> findCartByUserAndProduct(User user, Product product);
    void save(Cart cart);
    Optional<Cart> findById(Integer id);
    ITotalCart totalCostUser(User user);
    void  remove(Cart cart);
}
