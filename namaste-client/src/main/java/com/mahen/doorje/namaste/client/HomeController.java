package com.mahen.doorje.namaste.client;

import com.mahen.doorje.namaste.client.api.namaste.Namaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private Namaste namaste;

    @Autowired
    public HomeController(Namaste namaste) {
        this.namaste = namaste;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute(namaste.getProfile());
        model.addAttribute(namaste.getMessage());
        return "home";
    }
}
