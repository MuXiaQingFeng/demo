package com.hanser.controller.EID;

import com.hanser.service.EID.EIDService;
import com.hanser.util.JsonUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/EID")
public class EIDControllerImpl implements EIDController {

    @Resource(name = "eidService")
    private EIDService eidService;

    @Override
    @CrossOrigin
    @RequestMapping(value = {"/getProvider/{status}","/getProvider/{status}/{name}"})
    public String getProvider(@PathVariable(required = false) String name,@PathVariable int status) {
        return JsonUtils.getJson(eidService.getProvider(name, status));
    }

    @Override
    @CrossOrigin
    @RequestMapping("/updateSuggestionById/{id}/{advice}")
    public String updateSuggestionById(@PathVariable int id,@PathVariable String advice) {
        return JsonUtils.getJson(eidService.updateSuggestionById(id, advice));
    }
}
