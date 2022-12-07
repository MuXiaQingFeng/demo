package com.hanser.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {
    //转换非日期对象
    public static String getJson(Object obj){
        return getJson(obj,"yyyy-MM-dd");
    }

    //转换日期对象
    public static String getJson(Object obj, String dataFormat){
        ObjectMapper mapper = new ObjectMapper();
        //关闭默认的使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
        //指定json的日期格式
        mapper.setDateFormat(sdf);
        String str = "";
        //将对象转换成字符串
        try {
            str = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
