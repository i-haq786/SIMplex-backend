package com.inzi.sim_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SimDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sim_id")
    private long simId;

    @Column(name = "service_number", unique = true)
    private long serviceNumber;

    @Column(name = "sim_number", unique = true)
    private long simNumber;

    @Column(name = "sim_status")
    private String simStatus;
}
