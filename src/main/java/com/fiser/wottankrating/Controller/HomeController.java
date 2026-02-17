package com.fiser.wottankrating.Controller;

import com.fiser.wottankrating.Service.TankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final TankService tankService;

    public HomeController(TankService tankService) {
        this.tankService = tankService;
    }

    @GetMapping("/")
    public String viewPublicGallery(Model model) {
        model.addAttribute("tanks", tankService.findAll());
        return "home";
    }
}