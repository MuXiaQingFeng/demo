package com.hanser.service.file.impl;

import com.hanser.Enum.ResultEnum;
import com.hanser.exception.FileException;
import com.hanser.mapper.file.FileMapper;
import com.hanser.pojo.FileUploadEntity;
import com.hanser.service.file.FileUploadService;
import com.hanser.util.FileUploadUtils;
import com.hanser.util.FileUtils;
import com.hanser.vo.file.FileReq;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Resource
    FileMapper uploadMapper;

    @Override
    public void upload(MultipartFile file, String baseDir) throws Exception {
        //就算什么也不传，controller层的file也不为空，但是originalFilename会为空（亲测）
        String originalFilename = file.getOriginalFilename();

        if(originalFilename == null || "".equals(originalFilename)) {
            throw new Exception( "上传文件不能为空");
        }
        //检测是否上传过同样的文件，如果有的话就删除。（这边可根据个人的情况修改逻辑）
        FileReq fileReq = new FileReq();
        fileReq.setOldName(originalFilename);
        List<FileUploadEntity> oldEntityList = uploadMapper.selectList(fileReq);

        FileUploadEntity oldEntity = oldEntityList.size() > 0 ? oldEntityList.get(0):null;
        //新的文件
        FileReq uploadEntity = new FileReq();
        uploadEntity.setCreateTime(new Date());
        uploadEntity.setUpdateTime(new Date());
        uploadEntity.setOldName(file.getOriginalFilename());        //这边可以根据业务修改，项目中不要写死
        uploadEntity.setName("" + uploadEntity.getId());
        String name = "" + uploadEntity.getId();
        String fileLocation = null ;
        if(baseDir != null) {
            fileLocation = FileUploadUtils.upload(baseDir, file);
        }else {
            fileLocation = FileUploadUtils.upload(file);
        }

        uploadEntity.setLocation(fileLocation);
        uploadMapper.insert(uploadEntity);

        if(oldEntity != null) {
            //确保新的文件保存成功后，删除原有的同名文件(实体文件 and 数据库文件)
            FileUtils.deleteFile(oldEntity.getLocation());
            uploadMapper.deleteById(oldEntity.getId());
        }
    }

    @Override
    public void download(HttpServletResponse response, int id) throws IOException {
        FileReq fileReq = new FileReq();
        fileReq.setId(id);
        List<FileUploadEntity> uploadEntityList = uploadMapper.selectList(fileReq);

        FileUploadEntity uploadEntity = uploadEntityList.size() > 0 ? uploadEntityList.get(0):null;
        if (uploadEntity == null ) {
            throw new FileException(ResultEnum.FILE_NOT_EXIST);
        }
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");        //这边可以设置文件下载时的名字，我这边用的是文件原本的名字，可以根据实际场景设置
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(uploadEntity.getOldName(), "UTF-8"));
        FileUtils.writeBytes(uploadEntity.getLocation(), response.getOutputStream());
    }

    @Override
    public List<FileUploadEntity> getFileList(FileReq search) {
        if (search.getId()==0&&(search.getName()==null||search.getName().equals(""))&&(search.getOldName()==null||search.getOldName().equals(""))) {
            return null;
        }
        return uploadMapper.selectList(search);
    }
}
