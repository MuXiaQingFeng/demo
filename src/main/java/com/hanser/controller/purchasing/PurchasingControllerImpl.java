package com.hanser.controller.purchasing;

import com.hanser.pojo.Provider;
import com.hanser.service.provider.ProviderService;
import com.hanser.service.purchasing.PurchasingService;
import com.hanser.util.JsonUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/purchasing")
public class PurchasingControllerImpl{

    @Resource
    private PurchasingService purchasingService;
    @Resource
    private ProviderService providerService;

    @CrossOrigin
    @RequestMapping(value = {"/getProvider1/{status}/{name}", "/getProvider1/{status}"})
    public String getProvider1(@PathVariable(required = false) String name, @PathVariable int status) {
        return JsonUtils.getJson(purchasingService.getProvider1(name, status));
    }

    @CrossOrigin
    @RequestMapping("/updateProviderStatus1/{id}/{status}")
    public String updateProviderStatus1(@PathVariable int id,@PathVariable int status) {
        return JsonUtils.getJson(purchasingService.updateProviderStatus1(id,status));
    }

    @CrossOrigin
    @RequestMapping("/addOrder/{did}/{orderName}/{type}/{num}/{isUp5}/{byDate}")
    public String addOrder(@PathVariable int did, @PathVariable String orderName, @PathVariable String type, @PathVariable int num, @PathVariable boolean isUp5, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date byDate) {
        return JsonUtils.getJson(purchasingService.addOrder(did, orderName, type, num, isUp5, byDate));
    }

    @CrossOrigin
    @RequestMapping("/deleteProvider/{id}")
    public String deleteProvider(@PathVariable int id) {
        return JsonUtils.getJson(purchasingService.deleteProvider(id));
    }

    @CrossOrigin
    @RequestMapping(value = {"/getOrderList/{departmentId}/{isUp}/{orderStatus}/{orderName}", "/getOrderList/{departmentId}/{isUp}/{orderStatus}"})
    public String getOrderList(@PathVariable int departmentId, @PathVariable(required = false) String orderName, @PathVariable int isUp, @PathVariable int orderStatus) {
        return JsonUtils.getJson(purchasingService.getOrderList(departmentId, orderName, isUp, orderStatus));
    }

    @CrossOrigin
    @RequestMapping("/addRecord/{oid}/{type}")
    public String addRecord(@PathVariable int oid, @PathVariable String type) {
        return JsonUtils.getJson(purchasingService.addRecord(oid, type));
    }

    @CrossOrigin
    @RequestMapping(value = {"/getOrder/{oid}/{providerStatus}/{providerName}", "/getOrder/{oid}/{providerStatus}"})
    public String getOrder(@PathVariable int oid, @PathVariable int providerStatus, @PathVariable(required = false) String providerName) {
        return JsonUtils.getJson(purchasingService.getOrder(oid, providerStatus, providerName));
    }



    @CrossOrigin
    @RequestMapping(value = {"/updateProviderStatus2/{oid}/{pid}/{providerStatus}/{orderStatus}/{reason}", "/updateProviderStatus2/{oid}/{pid}/{providerStatus}/{orderStatus}"})
    public String updateProviderStatus2(@PathVariable int oid, @PathVariable int pid, @PathVariable int providerStatus, @PathVariable int orderStatus, @PathVariable(required = false) String reason) {
        return JsonUtils.getJson(purchasingService.updateProviderStatus2(oid, pid, providerStatus, orderStatus, reason));
    }

    @CrossOrigin
    @RequestMapping("/updateOrderStatus/{oid}")
    public String updateOrderStatus(@PathVariable int oid) {
        return JsonUtils.getJson(purchasingService.updateOrderStatus(oid));
    }

    @CrossOrigin
    @RequestMapping("/updateDraw/{x}/{oid}")
    public String updateDraw(@PathVariable int x, @PathVariable int oid) {
        return JsonUtils.getJson(purchasingService.updateDraw(x, oid));
    }

    @CrossOrigin
    @RequestMapping("/updateOrder/{oid}/{priceParity}")
    public String updateOrder(@PathVariable int oid, @PathVariable String priceParity) {
        return JsonUtils.getJson(purchasingService.updatePriceParity(oid, priceParity));
    }

    @CrossOrigin
    @RequestMapping("/getCompareReport/{id}")
    public String getCompareReport(@PathVariable int id) {
        return JsonUtils.getJson(purchasingService.getCompareReport(id));
    }

    @CrossOrigin
    @RequestMapping("/getOrders/{did}")
    public String getOrders(@PathVariable int did) {
        return JsonUtils.getJson(purchasingService.getOrders(did));
    }

    @CrossOrigin
    @RequestMapping("/updateAssess/{id}/{advice}")
    public String updateAssess(@PathVariable int id, @PathVariable String advice) {
        return JsonUtils.getJson(purchasingService.updateAssess(id, advice));
    }
}
