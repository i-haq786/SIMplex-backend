package com.inzi.sim_service.repository;


import com.inzi.sim_service.entity.SimOffers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SimOffersRepository extends JpaRepository<SimOffers, Long> {

    @Query("SELECT s from SimOffers s where s.simDetails.simId=:simId")
    Optional<SimOffers> findOfferBySimId(@Param("simId") long simId);

    //   public Optional<SimOffers> findBySimId(Long simId);

}
