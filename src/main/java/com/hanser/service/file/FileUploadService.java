package com.hanser.service.file;

import com.hanser.pojo.FileUploadEntity;
import com.hanser.vo.file.FileReq;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface FileUploadService {
    void upload(MultipartFile file, String baseDir) throws Exception;

    void download(HttpServletResponse response , int id) throws IOException;

    List<FileUploadEntity> getFileList(@Param("search")FileReq search);
}