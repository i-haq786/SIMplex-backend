package com.inzi.customer_service.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class CustomerIdentity {
    @NotNull
    @Column(name = "unique_id_number")
    long id;
    @Past
    @Column(name = "date_of_birth")
    Date dob;
    String firstName;
    String LastName;
    @Id
    @Email
    @Column(name = "email_address")
    String email;
    String state;
}
