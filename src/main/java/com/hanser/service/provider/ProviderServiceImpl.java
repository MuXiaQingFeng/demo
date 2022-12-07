package com.hanser.service.provider;

import com.hanser.mapper.provider.ProviderMapper;
import com.hanser.pojo.Provider;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private ProviderMapper providerMapper;

    @Override
    public Provider login(String code, String password) {
        Provider provider = providerMapper.login(code, password);
        if (!provider.getProviderPassword().equals(password)) {
            provider = null;
        }
        return provider;
    }

    @Override
    public boolean register(String code,String password) {
        HashMap map = new HashMap();
        map.put("code",code);
        map.put("password",password);
        return providerMapper.register(map) == 1 ? true : false;
    }

    @Override
    public boolean updatePassword(int id, String password) {
        return providerMapper.updatePassword(id, password) == 1 ? true : false;
    }

    @Override
    public Provider getProviderById(int id) {
        return providerMapper.getProviderById(id);
    }

    @Override
    public boolean updateProvider(Provider provider) {
        return providerMapper.updateProvider(provider) == 1 ? true : false;
    }

    @Override
    public List getOrder(int id,String orderName) {
        HashMap map = new HashMap();
        map.put("pid",id);
        if (orderName == null){
            map.put("orderName","");
        } else {
            map.put("orderName",orderName);
        }
        return providerMapper.getOrder(map).getOrderList();
    }

    @Override
    public List<Provider> getProviderList() {
        return providerMapper.getProviderList();
    }

    @Override
    public boolean updateReport(int pid,int oid,float price,Date date) {
        HashMap map = new HashMap();
        map.put("providerId",pid);
        map.put("orderId",oid);
        map.put("price",price);
        map.put("supplyDate",date);
        return providerMapper.updateReport(map) == 1 ? true : false;
    }
}
