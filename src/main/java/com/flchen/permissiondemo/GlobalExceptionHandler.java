package com.flchen.permissiondemo;


import com.flchen.permissiondemo.common.mo.ResponseMO;
import com.flchen.permissiondemo.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一异常处理基类
 *
 * @author Beldon.
 * @create 2017-11-3 下午2:26
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 判断是否是dev
     */
    protected boolean dev;

    /**
     * 全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseMO defaultErrorHandler(Exception e) {
        logger.error(e.getMessage(), e);
        String debugInfo = null;
        if (dev) {
            debugInfo = e.toString();
        }
        return ResponseUtil.error("内部发生错误，请联系管理员", debugInfo);
    }


    /**
     * 参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class
            , MissingServletRequestParameterException.class})
    public ResponseMO methodArgumentNotValidException(Exception e) {
        if (logger.isDebugEnabled()) {
            logger.info(e.getMessage(), e);
        }

        //参数缺失异常
        if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException exception = (MissingServletRequestParameterException) e;
            String message = exception.getParameterName() + "不能为空";
            return ResponseUtil.error(message);
        }

        List<ObjectError> allErrors = new ArrayList<>();
        if (e instanceof BindException) {
            allErrors = ((BindException) e).getBindingResult().getAllErrors();
        } else if (e instanceof MethodArgumentNotValidException) {
            allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
        }
        StringBuffer errors = new StringBuffer();
        for (ObjectError allError : allErrors) {
            errors.append(allError.getDefaultMessage());
            break;
        }

        String debugInfo = null;
        if (dev) {
            debugInfo = e.toString();
        }

        return ResponseUtil.error(errors.toString(), debugInfo);
    }

    /**
     * 请求方法不支持异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseMO methodNotSupported(HttpRequestMethodNotSupportedException e) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getMessage(), e);
        }
        String message = "不支持" + e.getMethod() + "请求访问";

        String debugInfo = null;
        if (dev) {
            debugInfo = e.toString();
        }
        return ResponseUtil.error(message, debugInfo);
    }

    /**
     * 请求内容不支持
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseMO httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        if (logger.isDebugEnabled()) {
            logger.debug(e.getMessage(), e);
        }
        String message = "不支持'" + e.getContentType() + "'内容";

        String debugInfo = null;
        if (dev) {
            debugInfo = e.toString();
        }
        return ResponseUtil.error(message, debugInfo);
    }

}
