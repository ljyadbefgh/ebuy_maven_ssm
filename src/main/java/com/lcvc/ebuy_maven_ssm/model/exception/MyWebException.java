package com.lcvc.ebuy_maven_ssm.model.exception;

/**
 * 自定义异常，用于Web传值产生的业务异常
 */
public class MyWebException extends RuntimeException {
    public MyWebException() {
        super();
    }

    public MyWebException(String message) {
        super(message);
    }
}
