package com.hanser.handler;

import com.hanser.Enum.ResultEnum;
import com.hanser.exception.FileException;
import com.hanser.util.ResultUtils;
import com.hanser.vo.result.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.stream.Collectors;
@RestControllerAdvice
public class ExceptionHandlers {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler({Exception.class})
    public ResultVo globalExceptionHandler(Exception e){
        this.logger.error(e.getMessage(), e);
        return new ResultUtils().fail(ResultEnum.OPERATE_FAIL);
    }

    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
    @ExceptionHandler(BindException.class)
    public ResultVo BindExceptionHandler(BindException e) {
        this.logger.error(e.getMessage(), e);
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return new ResultUtils().fail(message);
    }


    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVo MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        this.logger.error(e.getMessage(), e);
        String message = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining());
        return new ResultUtils().fail(message);
    }



    @ExceptionHandler({FileException.class})
    public ResultVo FileExceptionHandler(FileException e){
        this.logger.error(e.getErrMsg(), e);
        return new ResultUtils().fail(e.getCode(), e.getErrMsg());
    }

}
