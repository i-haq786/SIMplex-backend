package com.inzi.customer_service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerIdentityDto {

    @NotNull(message = "Government Id cant be null")
    long id;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "DOB cant be null")
    Date dob;

    @NotNull(message = "The email can't be null")
    String firstName;

    @NotNull(message = "The LastName can't be null")
    String LastName;

    @Email
    @NotNull(message = "The email can't be null")
    String email;

    @NotNull(message = "The state can't be null")
    String state;
}
