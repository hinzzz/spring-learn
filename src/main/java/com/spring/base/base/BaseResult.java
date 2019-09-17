package com.spring.base.base;

public class BaseResult {
    private boolean status;
    private String message;
    private Object data;

    private BaseResult(boolean status, String message,Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static BaseResult error(String message){
        return new BaseResult(false,message,null);
    }

    public static BaseResult success(String message){
        return new BaseResult(true,message,null);
    }

    public static BaseResult success(String message,Object data){
        return new BaseResult(true,message,data);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
