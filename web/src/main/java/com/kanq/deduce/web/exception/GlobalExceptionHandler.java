package com.kanq.deduce.web.exception;

import javax.servlet.http.HttpServletRequest;

import com.kanq.deduce.web.vo.ApiResult;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ApiResult defaultErrorHandler(Exception e, HttpServletRequest req){
        errLog(e, req);
        return ApiResult.FAILED;
    }


    public ApiResult kanqErrorHandler(Exception e, HttpServletRequest req){
        debugLog(e, req);
        KanqException exception = (KanqException)e;
        return new ApiResult<>(exception.getCode(), exception.getMessage());
    }

    private void errLog(Exception e, HttpServletRequest req){
        String addr = req.getRemoteAddr();
        String queryString = req.getQueryString();
        String path = queryString != null ? (req.getRequestURI().toString() + "?" + queryString): req.getRequestURI().toString();
        log.error("ip:{}, path:{}, message:{}", addr, path, e.getMessage());
    }

    private void debugLog(Exception e, HttpServletRequest req){
        String addr = req.getRemoteAddr();
        String queryString = req.getQueryString();
        String path = queryString != null ? (req.getRequestURI().toString() + "?" + queryString): req.getRequestURI().toString();
        log.debug("ip:{}, path:{}, message:{}", addr, path, e.getMessage());
    }
}
