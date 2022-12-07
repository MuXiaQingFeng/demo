package com.hanser.mapper.provider;

import com.hanser.pojo.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface ProviderMapper {
    //登录，输入账号code和密码password
    Provider login(@Param("code") String code, @Param("password") String password);

    //注册，传入账号密码进行简单的注册
    int register(HashMap map);

    //修改账号密码
    int updatePassword(@Param("id") int id, @Param("password") String password);

    //通过供应商id得到特定的供应商
    Provider getProviderById(@Param("pid") int id);

    //完善信息界面进行信息的完善
    int updateProvider(Provider provider);

    //根据供应商id(pid),查出一个供应商，这个供应商的orderList里是所有需要报价的订单列表(provider_status = 2,被抽中的)
    //map参数：pid：供应商id，   orderName：订单名，可以没有，模糊查询，
    Provider getOrder(HashMap map);

    //供应商填写询价报告(在提名时report表就存在了表项，所以直接更新)
    int updateReport(HashMap map);

    List<Provider> getProviderList();

}
