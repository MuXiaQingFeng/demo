package com.hanser.vo.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVo<T> implements Serializable {
    private T data;

    private Integer code;

    private String message;

}