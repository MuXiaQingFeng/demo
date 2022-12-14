package com.hanser.vo.project;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProjectReq {

    /**
     * 項目id
     */
    private int id;
    /**
     *  项目名称
     */
    private String projectName;
    /**
     * 询比价
     */
    private BigDecimal price;
    /**
     * 项目金额
     */
    private BigDecimal amount;

    /**
     * 管理员Id
     */
    private int staffId;

    /**
     * 部门Id
     */
    private int departmentId;
    /**
     * 項目編碼
     */
    private String projectCode;
    /**
     * 中标产品id
     */
    private String providerId;
    /**
     * 中标产品编码
     */
    private String providerCode;
    /**
     * 中标产品名称
     */
    private String providerName;
    /**
     * 项目开始日期
     */
    private String creationDate;
    /**
     * 质保金结束日期
     */
    private String byDate;
    /**
     * 项目结束日期
     */
    private String endDate;
    /**
     * 管理员code
     */
    private String staffCode;

    /**
     * 采购方式(询比价、招投标)
     */
    private String purchaseMode;

    /**
     * 付款进度
     */
    private String paymentProcess;

    /**
     * 项目实施进度(每月更新)
     */
    private String projectImplementProcess;


    private List<String> fileList;


    private String ids;
}
