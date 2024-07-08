package com.inzi.sim_service.exception;


public class InvalidInputException extends RuntimeException{
    public InvalidInputException( String str1, String str2)
    {
        super(String.format("INVALID %S: %S !",str1,str2));
    }

}