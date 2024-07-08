package com.inzi.sim_service.service.impl;


import com.inzi.sim_service.dto.SimDetailsDto;
import com.inzi.sim_service.entity.SimDetails;
import com.inzi.sim_service.exception.InvalidSimException;
import com.inzi.sim_service.exception.ResourceNotFoundException;
import com.inzi.sim_service.repository.SimDetailsRepository;
import com.inzi.sim_service.service.SimDetailsService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SimDetailsServiceImpl implements SimDetailsService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SimDetailsRepository simDetailsRepository;

    SimDetailsDto mapToDto(SimDetails simDetails){
        return modelMapper.map(simDetails, SimDetailsDto.class);
    }

    SimDetails mapToEntity(SimDetailsDto simDetailsDto){
        return modelMapper.map(simDetailsDto, SimDetails.class);
    }


    @Override
    public SimDetailsDto addSimDetails(SimDetailsDto simDetailsDto) {
        SimDetails simDetails= mapToEntity(simDetailsDto);
        return mapToDto(simDetailsRepository.save(simDetails));
    }

    @Override
    public String fetchSimStatus(Long serviceNumber, Long simNumber) {
        // SimDetails optionalSimDetails = simDetailsRepository.findByServiceNumberAndSimNumber(serviceNumber, simNumber);
        //orElseThrow only works with Optionals

        SimDetails simDetails = simDetailsRepository.findByServiceNumberAndSimNumber(serviceNumber, simNumber)
                .orElseThrow(
                        ()->new InvalidSimException(simNumber.toString(),serviceNumber.toString())
                );

        if(simDetails.getSimStatus().equalsIgnoreCase("Active"))
        {
            return "SIM already active";
        }

        return "Valid details. Welcome!!.";

    }

    @Override
    public Boolean isValidSimId(Long id) {
        Optional<SimDetails> simDetailsOptional = simDetailsRepository.findBySimId(id);

        // Check if simDetailsOptional has a value and if it matches the given ID
        return simDetailsOptional.isPresent() && simDetailsOptional.get().getSimId() == id;
    }

    @Override
    public String activateSim(long id)
    {
        SimDetails simDetails = simDetailsRepository.findBySimId(id).orElseThrow(
                ()-> new ResourceNotFoundException("Sim","sim_id",id)
        );

        if(simDetails.getSimStatus().equalsIgnoreCase("Inactive")) {
            simDetails.setSimStatus("Active");
            simDetailsRepository.save(simDetails);
            return "Sim Activated";
        }
        else return "Already Active";
    }

}
