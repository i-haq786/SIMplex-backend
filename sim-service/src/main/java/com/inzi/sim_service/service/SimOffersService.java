package com.inzi.sim_service.service;

import com.inzi.sim_service.dto.SimOffersDto;

public interface SimOffersService {
    public SimOffersDto addSimOffers (SimOffersDto simOffersDto);
    public SimOffersDto fetchOffersById(Long id);
}

