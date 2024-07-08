package com.inzi.customer_service.repository;

import com.inzi.customer_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public Optional<Customer> findByEmailAndDob(String email, String dob);

    public Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
