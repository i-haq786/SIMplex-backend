package com.inzi.customer_service.service;

import com.inzi.customer_service.dto.CustomerIdentityDto;

public interface CustomerIdentityService {
    public String idProofCheck(CustomerIdentityDto customerIdentityDto);
}
