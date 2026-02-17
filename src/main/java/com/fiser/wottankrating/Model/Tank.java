package com.fiser.wottankrating.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tank")
public class Tank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private DifficultyType difficultyTank;

    @Enumerated(EnumType.STRING)
    private Rating difficultyFirepower;

    @Enumerated(EnumType.STRING)
    private Rating difficultyArmour;

    @Enumerated(EnumType.STRING)
    private Rating difficultyMobility;

    @Enumerated(EnumType.STRING)
    private TankClass tankClass;

    @Enumerated(EnumType.STRING)
    private Tier tier;

    @Enumerated(EnumType.STRING)
    private Nations nations;

    @ManyToMany
    @JoinTable(
            name = "selected_equipment",
            joinColumns = @JoinColumn(name = "tank_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<Equipment> equipment;


}
