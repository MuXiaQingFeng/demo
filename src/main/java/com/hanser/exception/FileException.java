package com.hanser.exception;

import com.hanser.Enum.ResultEnum;

public class FileException extends RuntimeException{

    private int code;

    private String errMsg;

    public  FileException(ResultEnum fileEnum){
        this.code = fileEnum.getCode();
        this.errMsg = fileEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
