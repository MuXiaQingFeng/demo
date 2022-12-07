package com.hanser.vo.project;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

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
     * 合同编号id
     */
    private String orderId;
    /**
     * 合同编号
     */
    private String orderName;
    /**
     * 合同状态
     */
    private String orderStatus;
    /**
     * 管理员code
     */
    private String staffCode;


    private String ids;
}
