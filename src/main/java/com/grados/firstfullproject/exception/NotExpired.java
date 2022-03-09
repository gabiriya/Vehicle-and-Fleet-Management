package com.grados.firstfullproject.exception;

public class NotExpired extends RuntimeException{
    private final Object expiredDate;
//    private final String fieldName;
    private final Object fieldValue;

    public NotExpired(Object expiredDate, Object fieldValue){
        super(String.format("the current insurance with id %s is not expired yet\n it will expired in %s",expiredDate,fieldValue));

//        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.expiredDate = expiredDate;
    }

    public Object getClassName(){
        return expiredDate;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

//    public String getFieldName() {
//        return fieldName;
//    }
}
