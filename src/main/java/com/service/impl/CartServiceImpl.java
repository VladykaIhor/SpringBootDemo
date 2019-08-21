package com.service.impl;

import com.entity.Cart;
import com.entity.Product;
import com.entity.User;
import com.repository.CartJpaRepository;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartJpaRepository cartJpaRepository;

    @Autowired
    public CartServiceImpl(CartJpaRepository cartJpaRepository) {
        this.cartJpaRepository = cartJpaRepository;
    }

    @Override
    public void addProductToCart(User user, Product product) {
        Optional<Cart> cart = getCartByUser(user);
        cart.get().setProducts(product);
    }

    @Override
    public List<Product> getCartProducts() {
        return null;
    }

    @Override
    public void createCart(Cart cart) {
        cartJpaRepository.saveAndFlush(cart);
    }

    @Override
    public Optional<Cart> getCartByUser(User user) {
        return cartJpaRepository.getCartByUser(user);
    }

    @Override
    public int getSizeOfACart(Cart cart) {
        return cart.getSizeOfCart();
    }
}
