package com.grados.firstfullproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
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
