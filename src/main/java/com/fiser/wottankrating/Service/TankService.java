package com.fiser.wottankrating.Service;

import com.fiser.wottankrating.Model.*;
import com.fiser.wottankrating.Repository.TankRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TankService {
    private final TankRepository tankRepository;
    TankService(TankRepository tankRepository) {
        this.tankRepository = tankRepository;
    }

    public Tank findById(Long id) {
        return tankRepository.findById(id).orElse(null);
    }

    public List<Tank> findAll() {
        return tankRepository.findAll();
    }

    public Tank create(Tank tank) {
        return tankRepository.save(tank);
    }

    public void deleteById(Long id) {
        Tank tank = tankRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tank not found"));
        tank.getEquipment().clear();
        tankRepository.save(tank);
        tankRepository.delete(tank);
    }

}
