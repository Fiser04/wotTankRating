package com.fiser.wottankrating.Service;

import com.fiser.wottankrating.Model.Equipment;
import com.fiser.wottankrating.Model.Tank;
import com.fiser.wottankrating.Repository.EquipmentRepository;
import com.fiser.wottankrating.Repository.TankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final TankRepository tankRepository;
    EquipmentService(EquipmentRepository equipmentRepository,  TankRepository tankRepository) {
        this.equipmentRepository = equipmentRepository;
        this.tankRepository = tankRepository;
    }

    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    public Equipment findById(Long id) {
        return equipmentRepository.findById(id).get();
    }

    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public void delete(Long id) {

        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        List<Tank> tanks = tankRepository.findAll();
        for (Tank tank : tanks) {
            if (tank.getEquipment() != null) {
                tank.getEquipment().remove(equipment);
            }
        }
        equipmentRepository.delete(equipment);
    }
}
