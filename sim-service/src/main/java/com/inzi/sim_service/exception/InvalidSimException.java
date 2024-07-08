package com.inzi.sim_service.exception;

public class InvalidSimException extends  RuntimeException{
    public InvalidSimException(String serviceNumber, String simNumber){
        super(String.format("INVALID SIM DETAILS: NO SIM FOUND WITH SERVICE_NUMBER=%S AND SIM_NUMBER=%S",serviceNumber,simNumber));
    }

}