package com.supertange.community.community.exception;


/**
 * 后面可能有不同的业务，不同的service ，最好不要把所有的业务异常都定义到一个之中
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"问题找不到了，换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何评论进行回复"),
    SYSTEM_ERROR(2003, "服务器冒烟了，请稍后再试"),
    NOT_LOGIN(2004,"当前用户未登录"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"你操作的评论不见了，换个试试？"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空");
    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
