package com.supertange.community.community.exception;

//继承RuntimeException 不用当场用try catch解决， 用controllerAdvice去拦截既可以了
public class CustomizeException  extends  RuntimeException{
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
