package com.hanser.mapper.staff;

import com.hanser.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {
    //员工登录
    Staff login(@Param("code") String code,@Param("password") String password);
    //通过指定条件得到员工列表
    List<Staff> getStaff();

    Staff getStaffById(@Param("id") int id);
    //增加员工账号
    int addStaff(Staff staff);
    //删除员工账号
    int deleteStaffById(@Param("id") int id);
    //更新员工账号信息
    int updateStaff(Staff staff);
}
