package com.apptio.kpiservice.Exception;

public class KPIAlreadyExistsException extends Exception{
    public KPIAlreadyExistsException(){}
    public KPIAlreadyExistsException(String message){
        super(message);
    }
}
