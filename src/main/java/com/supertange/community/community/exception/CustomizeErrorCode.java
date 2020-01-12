package com.supertange.community.community.exception;


/**
 * 后面可能有不同的业务，不同的service ，最好不要把所有的业务异常都定义到一个之中
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("问题找不到了，换个试试？");
    private String message;



    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
