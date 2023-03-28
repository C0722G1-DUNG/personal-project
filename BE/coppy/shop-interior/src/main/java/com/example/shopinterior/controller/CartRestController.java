package com.example.shopinterior.controller;

import com.example.shopinterior.dto.cart.CartDto;
import com.example.shopinterior.dto.cart.ICartDto;
import com.example.shopinterior.dto.cart.ITotalCart;
import com.example.shopinterior.entity.account.User;
import com.example.shopinterior.entity.cart.Cart;
import com.example.shopinterior.entity.product.Product;
import com.example.shopinterior.service.account.IUserService;
import com.example.shopinterior.service.cart.ICartService;
import com.example.shopinterior.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    @Autowired
    private IProductService iProductService;
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
    @GetMapping("total")
    public ResponseEntity<ITotalCart> totalCart(@RequestParam(defaultValue = "") int idAccount) {
        Optional<User> user = iUserService.findByIdAccount(idAccount);
        if (user.isPresent()) {
            ITotalCart iCartDto = iCartService.totalCostUser(user.get());
           if (iCartDto!=null){
               return new ResponseEntity<>(iCartDto, HttpStatus.OK);
           }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("minus/{id}")
    public ResponseEntity<Cart> minQuantity(@PathVariable Integer id){
        Optional<Cart> cart = iCartService.findById(id);
        if (cart.isPresent()){
            Cart cartOld = cart.get();
            cartOld.setQuantity(cartOld.getQuantity()-1);
            iCartService.save(cartOld);
            return new ResponseEntity<>(cartOld, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("plus/{id}")
    public ResponseEntity<Cart> maxQuantity(@PathVariable Integer id){
        Optional<Cart> cart = iCartService.findById(id);
        if (cart.isPresent()){
            Cart cartOld = cart.get();
            cartOld.setQuantity(cartOld.getQuantity()+1);
            iCartService.save(cartOld);
            return new ResponseEntity<>(cartOld, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("add-product-to-cart")
    public ResponseEntity<Cart> addProductToCart(@RequestBody CartDto cartDto) {
            Optional<Product> product = iProductService.findById(cartDto.getProductDto().getIdProduct());
            Optional<User> user = iUserService.findById(cartDto.getId());
            if (product.isPresent() && user.isPresent()) {
                Optional<Cart> cart = iCartService.findCartByUserAndProduct(user.get(),product.get());
                if (cart.isPresent()) {
                    Cart cartOld = cart.get();
                    cartOld.setQuantity(cartOld.getQuantity() + cartDto.getQuantity());
                    iCartService.save(cartOld);
                    return new ResponseEntity<>(cartOld, HttpStatus.OK);
                } else {
                    Cart cartNew = new Cart();
                    BeanUtils.copyProperties(cartDto, cartNew);
                    cartNew.setUser(user.get());
                    cartNew.setProduct(product.get());
                    if (cartNew.getQuantity() <= 0) {
                        cartNew.setQuantity(1);
                    }
                    iCartService.save(cartNew);
                    return new ResponseEntity<>(cartNew, HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
