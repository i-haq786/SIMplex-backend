package com.inzi.sim_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SimOffers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private long offerId;

    @Column(name = "call_qty")
    private long callQty;

    @Column(name = "cost")
    private long cost;

    @Column(name = "data_qty")
    private long dataQty;

    private long duration;

    @Column(name = "offer_name")
    private String offerName;

    @OneToOne
    @JoinColumn(name = "sim_id",unique = true)
    private SimDetails simDetails;

}
