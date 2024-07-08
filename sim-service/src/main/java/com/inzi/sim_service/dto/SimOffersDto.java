package com.inzi.sim_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimOffersDto {
    private long offerId;
    private long callQty;
    private long cost;
    private long dataQty;
    private long duration;
    private String offerName;
    private SimDetailsDto simDetailsDto;


    @Override
    public String toString()
    {
        return callQty+" calls +"+
                dataQty+ "Gb for Rs."+
                cost + ", Validity: "+
                duration+" days.";

    }
}