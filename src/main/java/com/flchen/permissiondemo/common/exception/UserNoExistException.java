package com.flchen.permissiondemo.common.exception;

/**
 * @author wg
 * @create 2018-04-23 下午4:45
 */
public class UserNoExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserNoExistException(String message) {
        super(message);
    }
}
