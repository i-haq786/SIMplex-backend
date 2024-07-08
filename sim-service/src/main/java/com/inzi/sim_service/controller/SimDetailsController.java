package com.inzi.sim_service.controller;

import com.inzi.sim_service.dto.SimDetailsDto;
import com.inzi.sim_service.service.SimDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/simDetails")
@CrossOrigin
public class SimDetailsController {

    @Autowired
    SimDetailsService simDetailsService;

    @PostMapping("/")
    public ResponseEntity<SimDetailsDto> addSimDetails(@Valid @RequestBody SimDetailsDto simDetailsDto)
    {
        return  new ResponseEntity<>(simDetailsService.addSimDetails(simDetailsDto), HttpStatus.CREATED);
    }

    //us01
    @GetMapping("/validateSim/serviceNumber/{serviceNumber}/simNumber/{simNumber}")
    public ResponseEntity<String> fetchSimStatus( @Valid @PathVariable Long serviceNumber, @PathVariable Long simNumber)
    {
        return new ResponseEntity<>(simDetailsService.fetchSimStatus(serviceNumber,simNumber),HttpStatus.OK);

    }
    //us02
    @GetMapping ("/isValidSimId/{id}")
    public ResponseEntity<Boolean> isValidSimId(@PathVariable long id)
    {
        return new ResponseEntity<>(simDetailsService.isValidSimId(id),HttpStatus.OK);
    }

    @PutMapping("/activateSim/{id}")
    ResponseEntity<String> activateSim(@PathVariable long id)
    {
        return new ResponseEntity<>(simDetailsService.activateSim(id), HttpStatus.FOUND);
    }
}