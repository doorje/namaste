package com.mahen.doorje.namaste.client.web.controller;

import com.mahen.doorje.namaste.client.api.namaste.NamasteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private NamasteClient namaste;

    @Autowired
    public HomeController(NamasteClient namaste) {
        this.namaste = namaste;
    }

    @GetMapping("/")
    public String home(Model model) {

        DefaultOAuth2User user = (DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("account", namaste.getAccount(user.getName()));
        return "home";
    }
}