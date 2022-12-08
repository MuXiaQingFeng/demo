package com.hanser.mapper.leader;

import com.hanser.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LeaderMapper {
    // 模块三，获取订单列表,列表对应一个按钮可以查看符合条件的所有报价完的供应商,要求大于5W元，订单状态是4，名字可以用来模糊查询
    List<Order> getOrderList(@Param("orderName") String name,@Param("count") int count);

    // 模块三，点击订单列表里一个详细的订单，查看订单的详细信息以及报价的供应商
    Order getOrder(@Param("oid") int id);

    //模块三，根据订单id得到比价报告
    String getCompareReport(@Param("id") int id);

    //模块三、得到一个report
    Report getReport(@Param("oid") int oid,@Param("pid") int pid);

    // 根据中标供应商报价信息,更新order表
    int updateOrder(Report report);

    //模块三、指定供应商中标后，删除中间表信息
    int deleteRecord(@Param("oid") int oid);

    //模块三，修改中间表的状态信息（是否中标）
    int updateProviderStatus(@Param("pid") int pid, @Param("oid") int oid);

    //模块三，修改订单的状态信息（指定供应商中标设为5，年终评价完成则设为6）
    int updateOrderStatus(@Param("oid") int oid,@Param("orderStatus") int status);

    //模块四，根据日期，订单状态，部门did查看对应订单,count=0代表分管领导1，count=1代表分管领导2，count=2代表普通部门
    List<Order> getOrders(@Param("orderStatus") int status,@Param("departmentId") int id,@Param("count") int count);

    //模块四，将对应供应商拉入黑名单(状态变成0)
    int updateProStatus(@Param("pid") int id);

    //模块四，让指定供应商不合格（直接删除记录）
    int deleteProvider(@Param("pid") int id);

}
