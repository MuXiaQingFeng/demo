package com.hanser.service.provider;

import com.hanser.pojo.Provider;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ProviderService {

    //登录，输入账号code和密码password 得到provider对象
    Provider login(String code, String password);

    //注册，传入账号密码进行简单的注册
    boolean register(String code, String password);

    //修改账号密码
    boolean updatePassword(int id, String password);

    //通过供应商id得到特定的供应商
    Provider getProviderById(int id);

    //完善信息界面进行信息的完善
    boolean updateProvider(Provider provider);

    //根据供应商id和订单名orderName(模糊查询，可以没有) 查出该供应商所有需要报价的订单列表
    List getOrder(int id, String orderName);

    List<Provider> getProviderList();

    //供应商填写pid,oid对应的询价报告(报价price以及供货日期date)
    boolean updateReport(int pid, int oid, float price, Date date);
}
