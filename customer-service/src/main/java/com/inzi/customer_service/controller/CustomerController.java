package com.inzi.customer_service.controller;

import com.inzi.customer_service.dto.CustomerDTO;
import com.inzi.customer_service.dto.CustomerDto2;
import com.inzi.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/Customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    //us03
    @PostMapping("/verify")
    public ResponseEntity<String> verificationProcess(@Valid @RequestBody CustomerDTO customerDTO) {
        String result = customerService.validate(customerDTO.getEmail(), customerDTO.getDob());
        return ResponseEntity.accepted().body(result);
    }

    @PostMapping("/us04")
    public ResponseEntity<String> customerDetailsPageValidation(@Valid @RequestBody CustomerDto2 customerDTO) {
        return new ResponseEntity<>(customerService.customerDetailsPageValidation(customerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return new ResponseEntity<>(customerService.fetchAllCustomers(),HttpStatus.OK);
    }
}
