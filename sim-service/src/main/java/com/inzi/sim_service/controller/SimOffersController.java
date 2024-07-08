package com.inzi.sim_service.controller;


import com.inzi.sim_service.dto.SimOffersDto;
import com.inzi.sim_service.service.SimOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/SimOffers")
public class SimOffersController {

    @Autowired
    SimOffersService simOffersService;

    @PostMapping("/")
    public ResponseEntity<SimOffersDto> addSimOffers(@RequestBody SimOffersDto simOffersDto)
    {
        return new ResponseEntity<>(simOffersService.addSimOffers(simOffersDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> fetchOffersById(@PathVariable Long id)
    {
        return new ResponseEntity<>(simOffersService.fetchOffersById(id).toString(),HttpStatus.OK);
    }

}

