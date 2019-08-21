package com.controller;

import com.entity.User;
import com.service.ProductService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Objects;

@Controller
@SessionAttributes("user")
public class InitController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public InitController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String login(@AuthenticationPrincipal User user) {
        if (Objects.isNull(user)) {
            return "redirect:/login";
        } else if ("ROLE_ADMIN".equals(user.getRole())) {
            return "redirect:/admin/users";
        } else {
            return "redirect:/user/products";
        }
    }

    @GetMapping(path = {"/login"})
    public String login() {
        return "login";
    }

    @GetMapping(path = {"/logout"})
    public String logout() {
        return "redirect:/";
    }
}
