package com.hanser.service.project;

import com.hanser.mapper.file.FileMapper;
import com.hanser.mapper.project.ProjectMapper;
import com.hanser.mapper.provider.ProviderMapper;
import com.hanser.mapper.staff.StaffMapper;
import com.hanser.pojo.FileUploadEntity;
import com.hanser.pojo.Project;
import com.hanser.pojo.Provider;
import com.hanser.pojo.Staff;
import com.hanser.vo.file.FileReq;
import com.hanser.vo.project.ProjectReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    ProjectMapper projectMapper;
    @Resource
    StaffMapper staffMapper;
    @Resource
    ProviderMapper providerMapper;
    @Resource
    FileMapper fileMapper;

    @Override
    public boolean addProject(ProjectReq search) {
        if (search.getId()!=0) {
            projectMapper.deleteProject(search.getId());
        }
        if (!(search.getProviderId().equals(""))&&search.getProviderId()!=null) {
            Provider provider = providerMapper.getProviderById(Integer.parseInt(search.getProviderId()));
            search.setProviderCode(provider.getProviderCode());
            search.setProviderName(provider.getProviderName());
        }
        if (!(search.getStaffId()==0)) {
            Staff staff = staffMapper.getStaffById(search.getStaffId());
            search.setStaffCode(staff.getStaffCode());
            search.setDepartmentId(staff.getDepartmentId());
        }
        String projectCode = recountNew((int)((Math.random()*9+1)*10000000));
        search.setProjectCode(projectCode);
        Project project = projectMapper.addProject(search);
        if (search.getFileList().size()>0) {
            for (String s : search.getFileList()) {
                FileReq fileReq = new FileReq();
                fileReq.setName(s);
                List<FileUploadEntity> fileUploadEntities = fileMapper.selectList(fileReq);
                if (fileUploadEntities.size() == 1) {
                    fileMapper.updateFileByName(fileUploadEntities.get(0).getName(), project.getId());
                }
            }
        }
        return project != null;
    }

    @Override
    public List getProjectList(ProjectReq projectReq) {
        if (projectReq.getStaffId()!=0) {
            Staff staff = staffMapper.getStaffById(projectReq.getStaffId());
            if (staff.getDepartmentId() == 8) {
                return projectMapper.getProjectList(projectReq);
            } else if (staff.getDepartmentId() == 7 && staff.getType().equals("1")) {
                List<Project> resultList = projectMapper.getProjectList(projectReq);
                for (int i = resultList.size() - 1; i >=0; i--) {
                    if (resultList.get(i).getDepartmentId() != 5 && resultList.get(i).getDepartmentId() != 6) {
                        resultList.remove(i);
                    }
                }
                return resultList;
            } else if (staff.getDepartmentId() == 7) {
                List<Project> resultList = projectMapper.getProjectList(projectReq);
                for (int i = resultList.size() - 1; i >=0; i--) {
                    if (resultList.get(i).getDepartmentId() == 5 || resultList.get(i).getDepartmentId() == 6) {
                        resultList.remove(i);
                    }
                }
                return resultList;
            } else {
                projectReq.setDepartmentId(staff.getDepartmentId());
                return projectMapper.getProjectList(projectReq);
            }
        }
        return null;
    }

    @Override
    public boolean updateProject(ProjectReq projectReq) {
        List<String> ids = new ArrayList<>();
        if (projectReq.getIds()!=null||projectReq.getIds()==""){
            ids = Arrays.asList(projectReq.getIds().split(","));
            int result = 0;
            for (String id : ids) {
                projectReq.setId(Integer.parseInt(id));
                result += projectMapper.updateProject(projectReq);
            }
            return result == 0;
        }

        return projectMapper.updateProject(projectReq) != 0;
    }

    @Override
    public boolean deleteProject(String ids) {
        int result = 0;
        for (String s : ids.split(",")) {
            result += projectMapper.deleteProject(Integer.parseInt(s));
        }
        return result!=0;
    }


    private String recountNew(int maxCount) {
        if(maxCount<0) {
            return null;
        }
        // HT20170731-99999999
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str = format.format(new Date());
        maxCount=maxCount+1;
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(9);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(9);

        String countStr= "HT" + str + "-" + nf.format(maxCount);
        return countStr;
    }
}
