package com.inzi.customer_service.exception;

public class InvalidNameException extends RuntimeException{
    private final String str1;
    private final String str2;

    public InvalidNameException(String str1, String str2) {
        super(String.format("Not found with Name - %s %s", str1, str2));
        this.str1 = str1;
        this.str2 = str2;
    }
}
