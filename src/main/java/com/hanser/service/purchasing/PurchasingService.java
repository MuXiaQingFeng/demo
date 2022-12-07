package com.hanser.service.purchasing;

import com.hanser.pojo.Staff;

import java.io.File;
import java.util.Date;
import java.util.List;

public interface PurchasingService {
    //?导出excel，将当前页面的众多信息导出成excel形式
    File outputFiles();

    // 模块一查询，查供应商表，实现模糊查询(根据供应商名字name的模糊查询，状态status是可选（0:被加入了黑名单，1：待评核，2：待审批 3：合格）)
    List getProvider1(String name, int status);

    //模块一，指定对应id的供应商合格,把状态设为status
    boolean updateProviderStatus1(int id,int status);

    //模块一，指定对应id的供应商不合格,直接删除
    boolean deleteProvider(int id);

    //模块二,采购人员增加一个订单
    /*(#{did}, #{orderName}, #{type}, #{num}, #{isUp5},now(), #{byDate})*/
    boolean addOrder(int did, String orderName, String type, int num, boolean isUp5, Date byDate);

    // 模块二，获取订单列表,列表对应一个按钮可以查看符合条件的所有供应商
    // 这个列表可以加限定条件：订单名(orderName),金额是否大于5w元(isUp),订单状态(orderStatus)
    // 模块三也是通过这个获得订单列表
    List getOrderList(int departmentId,String orderName, int isUp, int orderStatus);

    // 模块二 根据订单type查出供应商中符合要求的合格供应商列表,并更新中间表信息(更新oid，pid和供应商状态)
    boolean addRecord(int oid, String type);

    // 模块二、三，得到特定订单的供应商列表，订单id(oid)是必须的，可选的参数还有供应商状态(提名，抽签抽中:providerStatus),供应商名字providerName
    List getOrder(int oid, int providerStatus, String providerName);

    // 模块二、三，修改中间表的oid，pid对应供应商的供应商状态信息providerStatus（提名,询价,中标），
    // 可选参数是提名理由reason，模块二提名时候的提名理由
    boolean updateProviderStatus2(int oid, int pid, int providerStatus, int orderStatus, String reason);

    //模块二 提名时最后用来修改订单状态
    boolean updateOrderStatus(int oid);

    // 模块二，抽签，抽取对应数量x的供应商，oid为订单id，自动抽签并修改中间表状态码
    boolean updateDraw(int x, int oid);

    //模块三，根据订单id填写订单的比价报告
    boolean updatePriceParity(int oid, String priceParity);

    //模块三，根据订单id得到比价报告
    String getCompareReport(int id);

    //模块四，根据日期查看本部门did本年度已经完成的的订单情况
    List getOrders(int did);

    //模块四，采购部门对订单id对应的供应商提出建议
    boolean updateAssess(int id, String advice);
}
