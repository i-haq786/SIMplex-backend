package com.inzi.customer_service.controller;

import com.inzi.customer_service.dto.CustomerAddressDto;
import com.inzi.customer_service.service.CustomerAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping (value="/api/address")
public class CustomerAddressController {

    @Autowired
    CustomerAddressService customerAddressService;

    //US05
    @PutMapping(value = "/")
    public ResponseEntity<CustomerAddressDto> addressUpdate(@Valid @RequestBody CustomerAddressDto customerAddressDto)
    {
        return new ResponseEntity<>(customerAddressService.addressUpdate(customerAddressDto), HttpStatus.OK);
    }

}
