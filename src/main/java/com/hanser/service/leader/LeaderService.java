package com.hanser.service.leader;

import com.hanser.pojo.Order;
import com.hanser.pojo.Staff;

import java.util.List;

public interface LeaderService {
    //模块三，根据订单名,count代表他是第一个领导还是第二个领导获取订单列表
    List getOrderList(String name,int count);

    //模块三，点击订单列表里一个详细的订单，查看订单的详细信息以及报价的供应商
    Order getOrder(int id);

    //模块三，根据订单id得到比价报告
    String getCompareReport(int id);

    //模块三，根据中标供应商的报价信息更新order表，删除中间表为oid的记录，更新order的status=5
    boolean updateInfo(int pid, int oid);

    //模块四，根据日期，订单状态，部门did查看对应订单
    List getOrders(int status,int did,int count);

    //模块四，blacklist=true,让供应商加入黑名单，否则就正常更新订单状态
    boolean updateStatus(int pid,int oid,int status,int blacklist);

    //模块四，让指定供应商不合格（直接删除记录）
    boolean deleteProvider(int pid,int oid);
}
