package com.hanser.Enum;

public enum ProviderEnum {

    PROVIDER_ID_NOT_EXIST(2002, "供应商不存在");

    private Integer code;

    private String msg;

    private ProviderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {

        return code;
    }

    public String getMsg() {

        return msg;
    }
}
