package com.inzi.customer_service.service.impl;

import com.inzi.customer_service.dto.CustomerDTO;
import com.inzi.customer_service.dto.CustomerDto2;
import com.inzi.customer_service.entity.Customer;
import com.inzi.customer_service.exception.InvalidNameException;
import com.inzi.customer_service.repository.CustomerRepository;
import com.inzi.customer_service.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    public CustomerDTO mapToDto(Customer customer){return modelMapper.map(customer, CustomerDTO.class);}
    public Customer mapToEntity(CustomerDTO customerDTO){return modelMapper.map(customerDTO,Customer.class);}

    @Override
    public String validate(String email, String dob) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailAndDob(email, dob);

        if (optionalCustomer.isEmpty())
            return "No request placed for you";
        else
            return "Success";
    }

    @Override
    public String customerDetailsPageValidation(CustomerDto2 customerDTO) {
        System.out.println(customerDTO);
        Customer customer = customerRepository.findByFirstNameAndLastName(customerDTO.getFirstName(), customerDTO.getLastName()).orElseThrow(
                () -> new InvalidNameException(customerDTO.getFirstName(), customerDTO.getLastName())
        );

        System.out.println("____Dto and Entity____" +customer);
        if(customer.getEmail().equalsIgnoreCase(customerDTO.getEmail()))
        {
            return "Success: Personal Details Validated";
        }
        return "Failed: Invalid Details";
    }

    @Override
    public List<CustomerDTO> fetchAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }




}
