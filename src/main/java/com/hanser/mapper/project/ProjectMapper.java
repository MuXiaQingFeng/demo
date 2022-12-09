package com.hanser.mapper.project;

import com.hanser.pojo.Project;
import com.hanser.vo.project.ProjectReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {
    List<Project> getProjectList(@Param("search")ProjectReq search);

    int updateProject(@Param("search")ProjectReq search);

    int addProject(@Param("search")ProjectReq search);

    int deleteProject(int id);
}
