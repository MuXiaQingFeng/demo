package com.hanser.service.EID;

import com.hanser.pojo.Staff;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public interface EIDService {

    //查询函数，实现根据用户名name进行模糊查询和状态status（待审核:1 或待复查:2、审核完成:3）查询,没有参数就默认返回所有的
    List getProvider(String name, int status);

    //修改对应id的供应商的审批建议
    boolean updateSuggestionById(int id, String advice);

    //?导出excel，将当前页面的众多信息导出成excel形式
    File outputFiles();
}
