package com.inzi.sim_service.service;


import com.inzi.sim_service.dto.SimDetailsDto;

public interface SimDetailsService {

    public SimDetailsDto addSimDetails(SimDetailsDto simDetailsDto);
    public String fetchSimStatus(Long serviceNumber, Long simNumber);
    public Boolean isValidSimId(Long id);
    public String activateSim(long id);
}
