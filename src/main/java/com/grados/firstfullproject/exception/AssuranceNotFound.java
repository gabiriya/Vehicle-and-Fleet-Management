package com.grados.firstfullproject.exception;

public class AssuranceNotFound extends RuntimeException{
    private String fieldName;
    private Object fieldValue;

    public AssuranceNotFound(String fieldName, Object fieldValue){
        super(String.format("Assurance not found with %s : '%s'",fieldName,fieldValue));
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
