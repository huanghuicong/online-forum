package com.web.onlineforumapi.interceptor;

import com.web.onlineforumapi.common.BusinessException;
import com.web.onlineforumapi.common.ResultData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SysExceptionHandler {

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResultData handleBusinessException(BusinessException e) {
        e.printStackTrace();
        return ResultData.error("500",  e.getMessage());
    }
}
