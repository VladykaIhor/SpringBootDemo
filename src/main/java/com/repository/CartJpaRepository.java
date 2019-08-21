package com.repository;

import com.entity.Cart;
import com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartJpaRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> getCartByUser(User user);
}
