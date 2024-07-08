package com.inzi.sim_service.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimDetailsDto {

    private long simId;

    @NotNull(message = "Service Number is Mandatory")
    //@Size(min = 10, max = 10, message = "Sim Service Number should be 10 digit Numerical Value")
    @Digits(integer = 10, fraction = 0, message = "Sim Number should be a 10 digit numerical value")
    private long serviceNumber;

    @NotNull(message = "Sim Number is mandatory")
    //@Size(min = 13, max = 10, message = "Sim Number should be 13 digit Numeric Value")
    @Digits(integer = 13, fraction = 0, message = "Sim Number should be a 13 digit numerical value")
    private long simNumber;

    //any condition?
    private String simStatus;
}

