package com.hanser.mapper.file;

import com.hanser.pojo.FileUploadEntity;
import com.hanser.pojo.Project;
import com.hanser.vo.file.FileReq;
import com.hanser.vo.project.ProjectReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Component
public interface FileMapper {
    List<FileUploadEntity> selectList(@Param("search") FileReq search);

    int insert(@Param("search")FileReq search);

    int deleteById(int id);

    int updateFileByName(@Param("name")String name, @Param("projectId")int projectId);
}