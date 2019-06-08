package com.ljq.mvc.web.controller;

import com.ljq.mvc.exception.UserNotExsitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : LJQ
 * @date : 2019/6/7 13:34
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExsitException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistException(UserNotExsitException ex) {
        Map<String, Object> map = new HashMap<>(10);
        map.put("id", ex.getId());
        map.put("message", ex.getMessage());
        return map;
    }

}
