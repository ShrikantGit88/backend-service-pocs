package com.example.demo.exception;

public class UserModificationException extends RuntimeException {
    private Object fieldValue;

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

    public UserModificationException(String message, Object fieldValue) {
        super(String.format("User modificatoin failed !!", fieldValue));
    }
}
