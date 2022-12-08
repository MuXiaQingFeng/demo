package com.hanser.util;

import com.hanser.Enum.ResultEnum;
import com.hanser.vo.result.ResultVo;

public class ResultUtils {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMessage(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(object);
        return resultVo;
    }
    public static ResultVo success(){
        return success(null);
    }
    public static ResultVo fail(Integer code,String message){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMessage(message);
        return  resultVo;
    }
    public static ResultVo fail(ResultEnum resultEnum){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(resultEnum.getCode());
        resultVo.setMessage(resultEnum.getMsg());
        return  resultVo;
    }


    public static ResultVo fail(String message) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultEnum.OPERATE_FAIL.getCode());
        resultVo.setMessage(message);
        return  resultVo;
    }
}
