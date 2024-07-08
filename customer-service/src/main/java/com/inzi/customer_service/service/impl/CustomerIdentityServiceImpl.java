package com.inzi.customer_service.service.impl;


import com.inzi.customer_service.dto.CustomerIdentityDto;
import com.inzi.customer_service.entity.CustomerIdentity;
import com.inzi.customer_service.exception.InvalidNameException;
import com.inzi.customer_service.repository.CustomerIdentityRepository;
import com.inzi.customer_service.service.CustomerIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerIdentityServiceImpl implements CustomerIdentityService {

    @Autowired
    CustomerIdentityRepository customerIdentityRepository;

    @Override
    public String idProofCheck(CustomerIdentityDto customerIdentityDto) {
        CustomerIdentity customerIdentity= customerIdentityRepository.findById(customerIdentityDto.getEmail()).orElseThrow(
                ()-> new InvalidNameException("email", customerIdentityDto.getEmail())
        );
        boolean isValid = customerIdentityDto.getId()==(customerIdentity.getId()) &&
                customerIdentityDto.getEmail().equalsIgnoreCase(customerIdentity.getEmail()) &&
                customerIdentityDto.getDob()==customerIdentity.getDob() &&
                customerIdentityDto.getFirstName().equalsIgnoreCase(customerIdentity.getFirstName()) &&
                customerIdentityDto.getLastName().equalsIgnoreCase(customerIdentity.getLastName())&&
                customerIdentityDto.getState().equalsIgnoreCase(customerIdentity.getState());

        if(isValid)
            return "Id Proof Check: PASS";
        else
            return "Id Proof Check: FAILED!";
    }
}
