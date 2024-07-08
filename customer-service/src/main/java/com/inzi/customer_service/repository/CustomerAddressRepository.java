package com.inzi.customer_service.repository;

import com.inzi.customer_service.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {
}
