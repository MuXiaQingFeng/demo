package com.hanser.controller.file;

import com.hanser.service.file.FileUploadService;
import com.hanser.util.JsonUtils;
import com.hanser.vo.file.FileReq;
import com.hanser.vo.project.ProjectReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {


    @Autowired
    FileUploadService fileUploadService;

    //使用默认路径
    @CrossOrigin
    @RequestMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        fileUploadService.upload(file, null);
        return null;
    }

    //自定义路径
    @CrossOrigin
    @RequestMapping("/upload/template")
    public String uploadPlace(MultipartFile file) throws Exception {
        fileUploadService.upload(file, "D:\\upload");
        return null;
    }

    // 查询文件列表
    @CrossOrigin
    @GetMapping(value = {"/getFileList"})
    public String getFileList(FileReq fileReq) {
        return JsonUtils.getJson(fileUploadService.getFileList(fileReq));
    }

    //下载
    @CrossOrigin
    @GetMapping("/download/{id}")
    public String downloadFile(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
        fileUploadService.download(response, id);
        return null;
    }
}
