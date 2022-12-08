package com.hanser.mapper.EID;

import com.hanser.pojo.Provider;
import com.hanser.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface EIDMapper {

    //查询函数，实现根据用户名进行模糊查询和状态（待审核:1 或待复查:2、审核完成:3）查询,没有参数就默认返回所有的
    List<Provider> getProvider(HashMap map);

    //修改对应id的供应商的审批建议,并修改状态为2
    int updateSuggestionById(@Param("id") int id, @Param("advice") String advice);

    //?导出excel，将当前页面的众多信息导出成excel形式
//    File<> outputFiles();
}
