package com.supertange.community.community.exception;

//继承RuntimeException 不用当场用try catch解决， 用controllerAdvice去拦截既可以了
public class CustomizeException  extends  RuntimeException{
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code=errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
