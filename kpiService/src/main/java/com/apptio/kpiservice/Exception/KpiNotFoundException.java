package com.apptio.kpiservice.Exception;

public class KpiNotFoundException extends Exception {
    public KpiNotFoundException(){}
    public KpiNotFoundException(String message){
        super(message);
    }
}
