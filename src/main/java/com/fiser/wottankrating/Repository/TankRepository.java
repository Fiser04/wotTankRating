package com.fiser.wottankrating.Repository;

import com.fiser.wottankrating.Model.Tank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankRepository extends JpaRepository<Tank, Long> {
}
