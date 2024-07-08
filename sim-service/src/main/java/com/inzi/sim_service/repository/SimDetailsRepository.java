package com.inzi.sim_service.repository;

import com.inzi.sim_service.entity.SimDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SimDetailsRepository extends JpaRepository<SimDetails, Long> {

    public Optional<SimDetails> findByServiceNumberAndSimNumber(long serviceNumber, long simNumber);
    public Optional<SimDetails> findBySimId(@Param("simId")long simId);
}
