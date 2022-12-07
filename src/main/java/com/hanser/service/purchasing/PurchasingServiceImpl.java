package com.hanser.service.purchasing;

import com.hanser.mapper.purchasing.PurchasingMapper;
import com.hanser.pojo.Provider;
import com.hanser.pojo.Report;
import com.hanser.pojo.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

@Service
public class PurchasingServiceImpl implements PurchasingService {
    @Resource
    private PurchasingMapper purchasingMapper;

    @Override
    public File outputFiles() {
        return null;
    }

    @Override
    public List getProvider1(String name, int status) {
        HashMap map = new HashMap();
        if (name != "") {
            map.put("name", name);
        }
        if (status != -1) {
            map.put("status", status);
        }
        return purchasingMapper.getProvider1(map);
    }

    @Override
    public boolean updateProviderStatus1(int id,int status) {
        return purchasingMapper.updateProviderStatus1(id,status) == 1 ? true : false;
    }

    @Override
    public boolean deleteProvider(int id) {
        return purchasingMapper.deleteProvider(id) == 1 ? true : false;
    }

    @Override
    public boolean addOrder(int did, String orderName, String type, int num, boolean isUp5, Date byDate) {
        HashMap map = new HashMap();
        map.put("did", did);
        map.put("orderName", orderName);
        map.put("type", type);
        map.put("num", num);
        map.put("isUp5", isUp5);
        map.put("byDate", byDate);
        return purchasingMapper.addOrder(map) == 1 ? true : false;
    }

    @Override
    public List getOrderList(int departmentId,String orderName, int isUp, int orderStatus) {
        HashMap map = new HashMap();
        if (departmentId != -1){
            map.put("departmentId", departmentId);
        }
        if (orderName != "") {
            map.put("orderName", orderName);
        }
        if (isUp != -1) {
            map.put("isUp", isUp);
        }
        if (orderStatus != -1) {
            map.put("orderStatus", orderStatus);
        }
        return purchasingMapper.getOrderList(map);
    }

    @Override
    public boolean addRecord(int oid, String type) {
        HashMap map = new HashMap();
        map.put("oid", oid);
        map.put("providerList", purchasingMapper.getProvider2(type));
        purchasingMapper.deleteRecord(oid);
        return purchasingMapper.addRecord(map) > 0 ? true : false;
    }

    @Override
    public List getOrder(int oid, int providerStatus, String providerName) {
        HashMap map = new HashMap();
        map.put("oid", oid);
        if (providerName != "") {
            map.put("providerName", providerName);
        }
        if (providerStatus != -1) {
            map.put("providerStatus", providerStatus);
        }
        return purchasingMapper.getOrder(map).getProviderList();
    }

    @Override
    public boolean updateProviderStatus2(int oid, int pid, int providerStatus, int orderStatus, String reason) {
        HashMap map = new HashMap();
        map.put("oid", oid);
        map.put("pid", pid);
        map.put("providerStatus", providerStatus);
        if (reason != "") {
            map.put("reason", reason);
        }
        if (providerStatus == 4) {
            Report report = purchasingMapper.getReport(oid, pid);
            if (purchasingMapper.updateOrder(report) != 1) {
                return false;
            }
            purchasingMapper.deleteRecord(oid);
            return purchasingMapper.updateOrderStatus(oid, orderStatus) == 1 ? true : false;
        } else if (providerStatus == 1) {
            return purchasingMapper.updateProviderStatus2(map) == 1 ? true : false;
        }
        return (purchasingMapper.updateProviderStatus2(map) == 1)
                && (purchasingMapper.updateOrderStatus(oid, orderStatus) == 1) ? true : false;
    }

    @Override
    public boolean updateOrderStatus(int oid) {
        return purchasingMapper.updateOrderStatus(oid, 1) == 1 ? true : false;
    }

    @Override
    public boolean updateDraw(int x, int oid) {
        HashMap map = new HashMap();
        map.put("oid", oid);
        map.put("providerStatus", 1);
        List<Provider> list = purchasingMapper.getOrder(map).getProviderList();
        List<Integer> drawList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            Provider provider = list.get(random.nextInt(list.size()));
            int randomX = provider.getId();
            drawList.add(randomX);
            list.remove(provider);
        }
        map.put("drawList", drawList);
        if (purchasingMapper.updateOrderStatus(oid, 2) == 1) {
            return purchasingMapper.updateDraw(map) > 0 ? true : false;
        }
        return false;
    }


    @Override
    public boolean updatePriceParity(int oid, String priceParity) {
        if (purchasingMapper.updatePriceParity(oid, priceParity) == 1) {
            return purchasingMapper.updateOrderStatus(oid, 4) == 1 ? true : false;
        }
        return false;
    }

    @Override
    public String getCompareReport(int id) {
        return purchasingMapper.getCompareReport(id);
    }

    @Override
    public List getOrders(int did) {
        return purchasingMapper.getOrders(did);
    }

    @Override
    public boolean updateAssess(int id, String advice) {
        return purchasingMapper.updateAssess(id, advice) == 1 ? true : false;
    }
}
