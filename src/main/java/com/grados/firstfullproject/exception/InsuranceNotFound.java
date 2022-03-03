package com.grados.firstfullproject.exception;

public class InsuranceNotFound extends RuntimeException{
    private final String fieldName;
    private final Object fieldValue;

    public InsuranceNotFound(String fieldName, Object fieldValue){
        super(String.format("Insurance not found with %s : '%s'",fieldName,fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }
}
