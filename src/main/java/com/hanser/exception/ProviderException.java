package com.hanser.exception;

import com.hanser.Enum.ProviderEnum;
import com.hanser.Enum.ResultEnum;

public class ProviderException extends RuntimeException{

    private int code;

    private String errMsg;

    public  ProviderException(ProviderEnum providerEnum){
        this.code = providerEnum.getCode();
        this.errMsg = providerEnum.getMsg();
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
