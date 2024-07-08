package com.inzi.customer_service.service;

import com.inzi.customer_service.dto.CustomerDTO;
import com.inzi.customer_service.dto.CustomerDto2;

import java.util.List;

public interface CustomerService {
    public String validate(String email, String dob);
    public String customerDetailsPageValidation(CustomerDto2 customerDTO);
    public List<CustomerDTO> fetchAllCustomers();
}
