package com.fiser.wottankrating.Controller;
import com.fiser.wottankrating.Model.*;
import com.fiser.wottankrating.Service.EquipmentService;
import com.fiser.wottankrating.Service.TankService;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TankController {

        private final TankService tankService;
        private final EquipmentService equipmentService;

        public TankController(TankService tankService,  EquipmentService equipmentService) {
            this.tankService = tankService;
            this.equipmentService = equipmentService;
        }

        @GetMapping("/tanks")
        public String viewTanks(Model model) {
            model.addAttribute("tanks", tankService.findAll());
            return "tank-list";
        }

    @GetMapping("/tanks/new")
    public String showCreateForm(Model model) {
        model.addAttribute("tank", new Tank());
        return getString(model);
    }

    @NonNull
    private String getString(Model model) {
        model.addAttribute("difficulties", DifficultyType.values());
        model.addAttribute("rating", Rating.values());
        model.addAttribute("allEquipment", equipmentService.findAll());
        model.addAttribute("tankClass", TankClass.values());
        model.addAttribute("tier", Tier.values());
        model.addAttribute("nations", Nations.values());
        return "tank-form";
    }


    @GetMapping("/tanks/edit/{id}")
    public String editTank(@PathVariable Long id, Model model) {
        model.addAttribute("tank", tankService.findById(id));
        return getString(model);
    }

    // Handle Delete
    @PostMapping("/tanks/delete/{id}")
    public String deleteTank(@PathVariable Long id) {
        tankService.deleteById(id);
        return "redirect:/tanks";
    }

    @PostMapping("/tanks/save")
    public String saveTank(@ModelAttribute("tank") Tank tank) {
        tankService.create(tank);
        return "redirect:/tanks";
    }

}