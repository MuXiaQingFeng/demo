package com.hanser.service.staff;

import com.hanser.mapper.staff.StaffMapper;
import com.hanser.pojo.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Resource
    private StaffMapper staffMapper;

    public Staff login(String code, String password) {
        Staff staff = staffMapper.login(code, password);
        if (!staff.getStaffPassword().equals(password)) {
            staff = null;
        }
        return staff;
    }

}
