package com.inzi.sim_service.service.impl;


import com.inzi.sim_service.dto.SimOffersDto;
import com.inzi.sim_service.entity.SimOffers;
import com.inzi.sim_service.exception.InvalidInputException;
import com.inzi.sim_service.exception.ResourceNotFoundException;
import com.inzi.sim_service.repository.SimOffersRepository;
import com.inzi.sim_service.service.SimOffersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimOffersServiceImpl implements SimOffersService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SimOffersRepository simOffersRepository;

    public SimOffersDto mapToDto(SimOffers simOffers)
    {
        return modelMapper.map(simOffers, SimOffersDto.class);
    }

    public SimOffers mapToEntity(SimOffersDto simOffersDto)
    {
        return modelMapper.map(simOffersDto, SimOffers.class);
    }

    @Override
    public SimOffersDto addSimOffers(SimOffersDto simOffersDto) {
        SimOffers simOffers = mapToEntity(simOffersDto);
        return mapToDto(simOffersRepository.save(simOffers));
    }

    @Override
    public SimOffersDto fetchOffersById(Long simId) {
        SimOffers simOffers = simOffersRepository.findOfferBySimId(simId)
                .orElseThrow(
                        ()-> new InvalidInputException("Sim Id", simId.toString())
                );
        if(simOffers==null)
        {
            throw new ResourceNotFoundException("","",simId);
        }
        return mapToDto(simOffers);
    }

}
