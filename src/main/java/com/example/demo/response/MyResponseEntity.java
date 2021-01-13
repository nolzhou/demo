package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author nolzhou
 * @desc ...
 * @date 2021-01-11 23:48:01
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyResponseEntity<T> {
    protected int code;
    protected String msg;
    protected T data;

    public MyResponseEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> MyResponseEntity<T> sendOK(T data){
        return new MyResponseEntity<>(1,"ok",data);
    }
}
