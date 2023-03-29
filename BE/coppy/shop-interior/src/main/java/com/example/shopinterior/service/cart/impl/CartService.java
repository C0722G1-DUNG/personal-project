package com.example.shopinterior.service.cart.impl;

import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.dto.cart.ITotalCart;
import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.entity.cart.Cart;
import com.example.shopinterior.entity.product.Product;
import com.example.shopinterior.repository.cart.ICartRepository;
import com.example.shopinterior.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;
    @Override
    public List<ICartDto> findAllByUser(User user) {
        return iCartRepository.findAllByUser(user.getId());
    }

    @Override
    public Optional<Cart> findCartByUserAndProduct(User user, Product product) {
        return iCartRepository.findCartByUserIdAndProductIdProduct(user.getId(),product.getIdProduct());
    }

    @Override
    public void save(Cart cart) {
        iCartRepository.save(cart);
    }

    @Override
    public Optional<Cart> findById(Integer id) {
        return iCartRepository.findById(id);
    }

    @Override
    public ITotalCart totalCostUser(User user) {
        return iCartRepository.totalCostUser(user.getId());
    }

    @Override
    public void remove(Cart cart) {
        iCartRepository.deleteById(cart.getIdCart());
    }
}
