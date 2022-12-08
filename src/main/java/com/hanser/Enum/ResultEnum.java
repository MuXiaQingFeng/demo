package com.hanser.Enum;

public enum ResultEnum {

    SUCCESS(200, "操作成功"),

    OPERATE_FAIL(500, "操作失败"),

    FILE_NOT_EXIST(2001, "文件不存在");

    private Integer code;

    private String msg;

    private ResultEnum(Integer code, String msg) {
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
