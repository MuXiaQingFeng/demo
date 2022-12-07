package com.hanser.service.staff;

import com.hanser.pojo.Staff;

import java.util.List;

public interface StaffService {
    //员工登录
    Staff login(String code, String password);
}
