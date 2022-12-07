package com.hanser.mapper.purchasing;

import com.hanser.pojo.Order;
import com.hanser.pojo.Provider;
import com.hanser.pojo.Report;
import com.hanser.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface PurchasingMapper {
    //?导出excel，将当前页面的众多信息导出成excel形式
    File outputFiles();

    //...模块一查询，查供应商表，实现模糊查询(根据供应商名字的模糊查询，状态是可选（0:被加入了黑名单，1：待评核，2：待审批 3：合格）)
    List getProvider1(HashMap map);

    //模块一，指定对应id的供应商合格,把状态设为status
    int updateProviderStatus1(@Param("pid") int id,@Param("providerStatus") int status);

    //模块一，指定对应id的供应商不合格,直接删除
    int deleteProvider(@Param("pid") int id);


    // 模块二，新增一个订单，订单会加到对应部门下
    // param: did部门id，orderName订单名，type订单类型，num货物数量，isUp5是否大于5W元，byDate截止日期
    int addOrder(HashMap map);


    // 模块二，获取订单列表,列表对应一个按钮可以查看符合条件的所有供应商
    // 这个列表可以加限定条件：从属部门id(departmentId),订单名(orderName),金额是否大于5w元(isUp),订单状态(orderStatus)
    // 模块三也是通过这个获得订单列表
    List getOrderList(HashMap map);

    // 模块二 根据订单type查出供应商中符合要求的合格供应商列表
    List getProvider2(@Param("type") String type);



    // 更新中间表的信息,传入的是上面的方法得到的所有满足订单type的供应商providerList
    int addRecord(HashMap map);

    //删除中间表的oid对应的记录
    int deleteRecord(@Param("oid") int id);

    //*模块二、三，订单id(oid)是必须的，可选的参数还有供应商状态(提名，抽签抽中:providerStatus),供应商名字providerName
    Order getOrder(HashMap map);

    // 模块二、三，修改中间表的oid，pid对应供应商的供应商状态信息providerStatus（提名,询价,中标），
    // 可选参数是提名理由reason，模块二提名时候的提名理由
    int updateProviderStatus2(HashMap map);

    // 模块二、三  修改供应商状态时，根据oid顺便修改订单状态orderStatus
    int updateOrderStatus(@Param("oid") int oid,@Param("orderStatus") int status);

    //模块三、得到一个中间表,供应商中标更新order时用
    Report getReport(@Param("oid") int oid,@Param("pid") int pid);

    //模块三，用得到的中间表更新order
    int updateOrder(Report report);

    //模块二，抽签，抽取对应数量的供应商，drawList为抽签抽中的供应商的id，修改抽中的供应商的的状态码,抽签抽中了自动询价
    int updateDraw(HashMap map);

    //模块三，根据订单id填写订单的比价报告（一个订单只有一个）
    int updatePriceParity(@Param("oid") int id, @Param("priceParity") String priceParity);

    //模块三，根据订单id得到比价报告
    String getCompareReport(@Param("oid") int id);

    //模块四，根据日期查看本年度对应部门did已经完成的（对应status）的订单情况
    List getOrders(@Param("did") int id);

    //模块四，采购部门对订单id对应的供应商提出建议
    int updateAssess(@Param("oid") int id, @Param("yearAdvice") String advice);
}
