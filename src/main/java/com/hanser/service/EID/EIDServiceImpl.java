package com.hanser.service.EID;

import com.hanser.mapper.EID.EIDMapper;
import com.hanser.pojo.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;

@Service("eidService")
public class EIDServiceImpl implements EIDService {
    @Resource
    private EIDMapper eidMapper;

    @Override
    public List getProvider(String name,int status) {
        HashMap map = new HashMap();
        if (name != ""){
            map.put("name",name);
        }
        if (status != -1){
            map.put("status",status);
        }
        return eidMapper.getProvider(map);
    }

    @Override
    public boolean updateSuggestionById(int id, String advice) {
        return eidMapper.updateSuggestionById(id,advice) == 1 ? true : false;
    }

    @Override
    public File outputFiles() {
        return null;
    }
}
