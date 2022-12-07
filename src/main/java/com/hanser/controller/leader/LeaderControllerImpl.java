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
public class LeaderControllerImpl implements LeaderController {

    @Resource
    private LeaderService leaderService;

    @Override
    @CrossOrigin
    @RequestMapping(value = {"/getOrderList/{count}","/getOrderList/{count}/{name}"})
    public String getOrderList(@PathVariable(required = false) String name,@PathVariable int count) {
        return JsonUtils.getJson(leaderService.getOrderList(name,count));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/getOrder/{id}")
    public String getOrder(@PathVariable int id) {
        return JsonUtils.getJson(leaderService.getOrder(id));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/getCompareReport/{id}")
    public String getCompareReport(@PathVariable int id) {
        return JsonUtils.getJson(leaderService.getCompareReport(id));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/updateInfo/{pid}/{oid}")
    public String updateInfo(@PathVariable int pid,@PathVariable int oid) {
        return JsonUtils.getJson(leaderService.updateInfo(pid,oid));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/getOrders/{status}/{did}/{count}")
    public String getOrders(@PathVariable int status,@PathVariable int did,@PathVariable int count) {
        return JsonUtils.getJson(leaderService.getOrders(status,did,count));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/updateStatus/{pid}/{oid}/{status}/{blacklist}")
    public String updateStatus(@PathVariable int pid,@PathVariable int oid,@PathVariable int status,@PathVariable int blacklist) {
        return JsonUtils.getJson(leaderService.updateStatus(pid, oid,status,blacklist));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/deleteProvider/{pid}/{oid}")
    public String deleteProvider(@PathVariable int pid,@PathVariable int oid) {
        return JsonUtils.getJson(leaderService.deleteProvider(pid, oid));
    }
}
