package com.gyf.my.shop.commons.dto;

import java.io.Serializable;

public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS=200;
    public static final int STATUS_FAIl=500;

    private int status;
    private String message;

    public static BaseResult success(){
        return createResult(STATUS_SUCCESS,"成功");
    }

    public static BaseResult success(String message){
        return   createResult(STATUS_SUCCESS,message);
    }

    public static BaseResult fail(){
        return createResult(STATUS_FAIl,"失败");
    }

    public static BaseResult fail(String message){
        return createResult(STATUS_FAIl,message);
    }

    public static BaseResult fail(int status,String message){
        return createResult(status,message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BaseResult createResult(int status,String message){
        BaseResult baseResult=new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }
}
