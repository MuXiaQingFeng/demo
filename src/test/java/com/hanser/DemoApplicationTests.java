package com.hanser;


import com.hanser.mapper.leader.LeaderMapper;
import com.hanser.mapper.staff.StaffMapper;
import com.hanser.pojo.Provider;
import com.hanser.service.provider.ProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    StaffMapper mapper;
    @Resource
    LeaderMapper mapper1;
    @Resource
    PurchasingController controller;
    @Resource
    ProviderService service;
    @Resource
    Provider provider;

    @Test
    void contextLoads() throws SQLException {
        /*(#{did}, #{orderName}, #{type}, #{num}, #{isUp5},now(), #{byDate})*/
        /*HashMap map = new HashMap();
        map.put("did",20220927);
        map.put("orderName","hanser");
        map.put("type","han");
        map.put("num",20);
        map.put("isUp5",true);
        map.put("byDate",new Date());
        System.out.println(purchasingController.addOrder(20220927,"hanser","han",20,true,new Date()));*/
        System.out.println(mapper.login("采购部门1", "010217"));

    }

}
