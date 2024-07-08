package com.inzi.customer_service.repository;


import com.inzi.customer_service.entity.CustomerIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerIdentityRepository extends JpaRepository<CustomerIdentity,String> {
    public Optional<CustomerIdentity> findById(String id);
}

