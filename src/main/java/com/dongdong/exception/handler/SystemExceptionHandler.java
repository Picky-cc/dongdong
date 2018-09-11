package com.dongdong.exception.handler;

import com.dongdong.consts.ResponseCode;
import com.dongdong.consts.Result;
import com.dongdong.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class SystemExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BizException.class)
    public String handleTheBizException(BizException e) {
        log.error("系统发生BizException:{}", e);
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        log.error("系统发生未知错误:{}", e);
        Result result = new Result();
        result.setCode(ResponseCode.SYSTEM_ERROR.getCode());
        result.setMessage(ResponseCode.SYSTEM_ERROR.getMessage());
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        return result;
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodExceptionHandler(HttpRequestMethodNotSupportedException e){
        log.error("系统发生请求方式错误:{}", e);
        Result result = new Result();
        result.setCode(ResponseCode.REQUEST_METHOD_ERROR.getCode());
        result.setMessage(ResponseCode.REQUEST_METHOD_ERROR.getMessage());
        result.setTimeStamp(Long.toString(System.currentTimeMillis()));
        return result;
    }
}
