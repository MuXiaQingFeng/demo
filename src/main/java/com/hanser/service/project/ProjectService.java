package com.hanser.service.project;

import com.hanser.vo.project.ProjectReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectService {

    List getProjectList(@Param("search")ProjectReq search);

    boolean addProject(@Param("search") ProjectReq search);

    boolean updateProject(@Param("search")ProjectReq search);

    boolean deleteProject(String ids);
}
