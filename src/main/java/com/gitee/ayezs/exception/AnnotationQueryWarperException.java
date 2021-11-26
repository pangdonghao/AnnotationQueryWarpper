package com.gitee.ayezs.exception;

public class AnnotationQueryWarperException extends RuntimeException{
    /**
     * 错误信息
     */
    private String message;

    public AnnotationQueryWarperException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
