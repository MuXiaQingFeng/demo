package com.hanser.controller.staff;

import com.hanser.service.purchasing.PurchasingService;
import com.hanser.service.staff.StaffService;
import com.hanser.util.JsonUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/staff")
public class StaffControllerImpl implements StaffController{

    @Resource
    private StaffService staffService;

    @Override
    @CrossOrigin
    @RequestMapping("/login/{code}/{password}")
    public String login(@PathVariable String code, @PathVariable String password) {
        return JsonUtils.getJson(staffService.login(code, password));
    }

}
