package com.hanser.service.leader;

import com.hanser.mapper.leader.LeaderMapper;
import com.hanser.pojo.Order;
import com.hanser.pojo.Report;
import com.hanser.pojo.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Resource
    private LeaderMapper leaderMapper;

    @Override
    public List getOrderList(String name,int count) {
        return leaderMapper.getOrderList(name,count);
    }

    @Override
    public Order getOrder(int id) {
        return leaderMapper.getOrder(id);
    }

    @Override
    public String getCompareReport(int id) {
        return leaderMapper.getCompareReport(id);
    }

    @Override
    public boolean updateInfo(int pid, int oid) {
        Report report = leaderMapper.getReport(oid, pid);
        return (leaderMapper.updateOrder(report) == 1
                && leaderMapper.deleteRecord(oid) > 0
                && leaderMapper.updateOrderStatus(oid,5) == 1);
    }

    @Override
    public List getOrders(int status,int did,int count) {
        return leaderMapper.getOrders(status,did,count);
    }

    @Override
    public boolean updateStatus(int pid,int oid,int status,int blacklist) {
        if (blacklist == 0){
            return leaderMapper.updateProStatus(pid) == 1 && leaderMapper.updateOrderStatus(oid,status) == 1 ? true : false;
        } else {
            return leaderMapper.updateOrderStatus(oid,status) == 1 ? true : false;
        }
    }

    @Override
    public boolean deleteProvider(int pid,int oid) {
        return leaderMapper.deleteProvider(pid) == 1 && leaderMapper.updateOrderStatus(oid,6) == 1 ? true : false;
    }
}
