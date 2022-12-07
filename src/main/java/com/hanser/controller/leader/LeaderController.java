package com.hanser.controller.leader;

import com.hanser.service.leader.LeaderService;
import com.hanser.util.JsonUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/leader")
public class LeaderController {

    @Resource
    private LeaderService leaderService;

    @CrossOrigin
    @RequestMapping(value = {"/getOrderList/{count}","/getOrderList/{count}/{name}"})
    public String getOrderList(@PathVariable(required = false) String name,@PathVariable int count) {
        return JsonUtils.getJson(leaderService.getOrderList(name,count));
    }

    @CrossOrigin
    @RequestMapping("/getOrder/{id}")
    public String getOrder(@PathVariable int id) {
        return JsonUtils.getJson(leaderService.getOrder(id));
    }

    @CrossOrigin
    @RequestMapping("/getCompareReport/{id}")
    public String getCompareReport(@PathVariable int id) {
        return JsonUtils.getJson(leaderService.getCompareReport(id));
    }

    @CrossOrigin
    @RequestMapping("/updateInfo/{pid}/{oid}")
    public String updateInfo(@PathVariable int pid,@PathVariable int oid) {
        return JsonUtils.getJson(leaderService.updateInfo(pid,oid));
    }

    @CrossOrigin
    @RequestMapping("/getOrders/{status}/{did}/{count}")
    public String getOrders(@PathVariable int status,@PathVariable int did,@PathVariable int count) {
        return JsonUtils.getJson(leaderService.getOrders(status,did,count));
    }

    @CrossOrigin
    @RequestMapping("/updateStatus/{pid}/{oid}/{status}/{blacklist}")
    public String updateStatus(@PathVariable int pid,@PathVariable int oid,@PathVariable int status,@PathVariable int blacklist) {
        return JsonUtils.getJson(leaderService.updateStatus(pid, oid,status,blacklist));
    }

    @CrossOrigin
    @RequestMapping("/deleteProvider/{pid}/{oid}")
    public String deleteProvider(@PathVariable int pid,@PathVariable int oid) {
        return JsonUtils.getJson(leaderService.deleteProvider(pid, oid));
    }
}
