package com.hanser.mapper.admin;

import com.hanser.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {
    //模块二，新增一个订单
    public int insertOrder(Order order);
}
