package com.grados.firstfullproject.exception;

import java.time.LocalDate;

public class NotExpired extends RuntimeException{
    private final LocalDate expiredDate;
//    private final String fieldName;
    private final Object fieldValue;

    public NotExpired(LocalDate expiredDate, Object fieldValue){
        super(String.format("the current insurance with id %s is not expired yet \n it will expired in %s",fieldValue,expiredDate));

//        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.expiredDate = expiredDate;
    }

    public LocalDate getClassName(){
        return expiredDate;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

//    public String getFieldName() {
//        return fieldName;
//    }
}
