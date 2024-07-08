package com.inzi.customer_service.service.impl;


import com.inzi.customer_service.dto.CustomerAddressDto;
import com.inzi.customer_service.entity.CustomerAddress;
import com.inzi.customer_service.repository.CustomerAddressRepository;
import com.inzi.customer_service.service.CustomerAddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CustomerAddressRepository customerAddressRepository;

    public CustomerAddressDto mapToDto(CustomerAddress customerAddress)
    {
        return modelMapper.map(customerAddress,CustomerAddressDto.class);
    }

    public CustomerAddress mapToEntity(CustomerAddressDto customerAddressDto)
    {
        return modelMapper.map(customerAddressDto,CustomerAddress.class);
    }


    @Override
    public CustomerAddressDto addressUpdate(CustomerAddressDto customerAddressDto) {
        CustomerAddress customerAddress= mapToEntity(customerAddressDto);
        return mapToDto(customerAddressRepository.save(customerAddress));
    }
}
