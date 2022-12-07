package com.hanser.controller.leader;

public interface LeaderController {

    //模块三，根据订单名获取订单列表(搜索栏，模糊查询)
    String getOrderList(String name,int count);

    //模块三，点击订单列表里一个详细的订单，根据订单id查看订单的详细信息以及报价的供应商
    String getOrder(int id);

    //模块三，根据订单id得到比价报告
    String getCompareReport(int id);

    //模块三，修改中间表的状态信息（是否中标）
    String updateInfo(int pid, int oid);

    //模块四，根据日期，订单状态，部门did查看对应订单，(count=0代表分管领导1，count=1代表分管领导2，count=2代表普通部门，也就是did生效)
    String getOrders(int status,int did,int count);

    //模块四，blacklist==0,把对应供应商拉入黑名单，否则修改订单状态(指的是部门负责人审批，分管领导审批，总经理审批)
    String updateStatus(int oid,int pid,int status,int blacklist);

    //模块四，让指定供应商不合格（直接删除记录）
    String deleteProvider(int oid,int pid);
}
