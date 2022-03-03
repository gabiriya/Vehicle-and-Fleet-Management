package com.grados.firstfullproject.exception;

public class NotFound extends RuntimeException{
    private String className;
    private String fieldName;
    private Object fieldValue;

    public NotFound(String className, String fieldName, Object fieldValue){
        super(String.format("%s not found with %s : '%s'",className,fieldName,fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.className = className;
    }

    public String getClassName(){
        return className;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }
}
