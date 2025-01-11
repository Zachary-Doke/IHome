package com.ihome.exception;

import com.ihome.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionAdvice {

    Logger log= LoggerFactory.getLogger(GlobalExceptionAdvice.class);
    @ExceptionHandler({Exception.class})
    public ResponseMessage handlerException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error("请求地址：{"+request.getRequestURI()+"}，发生异常：{"+e.getMessage()+"}");
        return new ResponseMessage(500, e.getMessage(), null);
    }

}
