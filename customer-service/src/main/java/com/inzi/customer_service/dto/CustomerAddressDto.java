package com.inzi.customer_service.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDto {
    private long id;

    @Size(max = 25, message = "Address too long")
    private String address;
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City should not contain any special characters except space")
    private String city;
    //    @Size(min= 6, max = 6 , message = "Incorrect Pincode")
    @Pattern(regexp = "^[0-9]{6}$", message = "Incorrect Pincode")
    private String pincode;
    private String state;
}
