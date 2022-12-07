package com.hanser.controller.project;

import com.hanser.service.project.ProjectService;
import com.hanser.util.JsonUtils;
import com.hanser.vo.project.ProjectReq;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/project")
public class ProjectController {


    @Resource
    private ProjectService projectService;

    @CrossOrigin
    @GetMapping(value = {"/getProjectList"})
    public String getProjectList(ProjectReq projectReq) {
        return JsonUtils.getJson(projectService.getProjectList(projectReq));
    }

    @CrossOrigin
    @PutMapping("/updateProject")
    public String updateProject(ProjectReq projectReq) {
        return JsonUtils.getJson(projectService.updateProject(projectReq));
    }
    @CrossOrigin
    @PostMapping("/addProject")
    public String addOrder(ProjectReq projectReq) {
        return JsonUtils.getJson(projectService.addProject(projectReq));
    }

    @CrossOrigin
    @DeleteMapping("/deleteProject")
    public String deleteProject(String ids) {
        return JsonUtils.getJson(projectService.deleteProject(ids));
    }
}
