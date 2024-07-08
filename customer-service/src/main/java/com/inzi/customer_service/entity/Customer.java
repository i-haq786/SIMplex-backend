package com.inzi.customer_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "unique_id_number")
    long uid;

    @Column(name = "date_of_birth")
    String dob;
    @Column(name = "email_address", unique = true)
    String email;
    @Size(max = 15, message = "First Name too long")
    String firstName;
    @Size(max = 15, message = "Last Name too long")
    String lastName;
    String idType;

    // @OneToOne ????
    //@JoinColumn(name = "address_id" )
    // @Column(name = "customer_address_addressId")

    @OneToOne
    @JoinColumn(name = "customer_address_addressId" )
    CustomerAddress customerAddress;

    long simId;
    String state;

    public Customer(String email, String s, String dob, String state) {
        this.email = email;
        s=this.firstName + this.lastName;
        this.dob = dob;
        this.state = state;
    }

}
