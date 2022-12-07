package com.hanser.controller.provider;

import com.hanser.pojo.Provider;
import com.hanser.service.provider.ProviderService;
import com.hanser.util.JsonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/provider")
public class ProviderController{

    @Resource
    private ProviderService providerService;

    @CrossOrigin
    @RequestMapping("/login/{code}/{password}")
    public String login(@PathVariable String code,@PathVariable String password) {
        return JsonUtils.getJson(providerService.login(code,password));
    }

    @CrossOrigin
    @RequestMapping("/register/{code}/{password}")
    public String register(@PathVariable String code,@PathVariable String password) {
        return JsonUtils.getJson(providerService.register(code,password));
    }

    @CrossOrigin
    @RequestMapping("/updatePassword/{id}/{password}")
    public String updatePassword(@PathVariable int id,@PathVariable String password) {
        return JsonUtils.getJson(providerService.updatePassword(id,password));
    }

    @CrossOrigin
    @RequestMapping("/getProviderById/{id}")
    public String getProviderById(@PathVariable int id) {
        return JsonUtils.getJson(providerService.getProviderById(id));
    }

    @CrossOrigin
    @PostMapping("/updateProvider")
    public String updateProvider(@RequestBody Provider provider) {
        return JsonUtils.getJson(providerService.updateProvider(provider));
    }

    @CrossOrigin
    @RequestMapping(value = {"/getOrder/{id}","/getOrder/{id}/{orderName}",})
    public String getOrder(@PathVariable int id,@PathVariable(required = false) String orderName) {
        return JsonUtils.getJson(providerService.getOrder(id,orderName));
    }

    @CrossOrigin
    @RequestMapping("/updateReport/{pid}/{oid}/{price}/{date}")
    public String updateReport(@PathVariable int pid,@PathVariable int oid,@PathVariable float price,@PathVariable Date date) {
        return JsonUtils.getJson(providerService.updateReport(pid,oid,price,date));
    }

    @CrossOrigin
    @GetMapping(value = {"/getProviderList"})
    public String getProviderList() {
        return JsonUtils.getJson(providerService.getProviderList());
    }


}
