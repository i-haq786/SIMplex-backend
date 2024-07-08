package com.inzi.customer_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private long uid;
    @NotNull(message = "The dob can't be null")
    private String dob;
    @NotNull(message = "The email can't be null")
//  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String idType;
    private CustomerAddressDto customerAddressDto;
    private long simId;
    private String state;
}
