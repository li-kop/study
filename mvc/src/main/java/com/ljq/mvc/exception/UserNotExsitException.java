package com.ljq.mvc.exception;

/**
 * @author : LJQ
 * @date : 2019/6/7 13:26
 */

public class UserNotExsitException extends RuntimeException{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserNotExsitException(String id){
        super("user not exist");
         this.id=id;
    }
}
