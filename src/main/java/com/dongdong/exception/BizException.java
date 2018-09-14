package com.dongdong.exception;

public class BizException extends Exception {

    private static final String PATTERN = "{\"code\":\"%s\", \"message\":\"%s\", " +
            "\"timeStamp\":\"%s\"}";

    public BizException(String code, String message, String timeStamp) {
        super(String.format(PATTERN, code, message, timeStamp));
    }

    public BizException(String code, String message) {
        super(String.format(PATTERN, code, message, Long.toString(System.currentTimeMillis())));
    }
}
