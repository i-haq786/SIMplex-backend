package com.inzi.customer_service.controller;

import com.inzi.customer_service.dto.CustomerIdentityDto;
import com.inzi.customer_service.service.CustomerIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/customerIdentity")
public class CustomerIdentityController {

    @Autowired
    CustomerIdentityService customerIdentityService;

    @PutMapping("/idProofCheck")
    public ResponseEntity<String> idProofCheck(CustomerIdentityDto customerIdentityDto)
    {
        return new ResponseEntity<>(customerIdentityService.idProofCheck(customerIdentityDto), HttpStatus.OK);
    }
}