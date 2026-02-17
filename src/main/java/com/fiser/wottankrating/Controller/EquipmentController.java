package com.fiser.wottankrating.Controller;

import com.fiser.wottankrating.Model.Equipment;
import com.fiser.wottankrating.Service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EquipmentController {
    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/equipment")
    public String viewTanks(Model model) {
        model.addAttribute("allEquipment", equipmentService.findAll());
        return "equipment-list";
    }


    @GetMapping("/equipment/new")
    public String showEquipmentForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        return "equipment-form";
    }

    @PostMapping("/equipment/save")
    public String saveEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.create(equipment);
        return "redirect:/equipment";
    }

    @GetMapping("/equipment/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Equipment equipment = equipmentService.findById(id);
        model.addAttribute("equipment", equipment);
        return "equipment-form";
    }

    @PostMapping("/equipment/delete/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.delete(id);
        return "redirect:/equipment";
    }
}
