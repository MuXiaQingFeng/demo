package com.hanser.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 項目id
     */
    private int id;
    /**
     * 项目编码
     */
    private String projectCode;
    /**
     *  项目名称
     */
    private String projectName;
    /**
     * 询比价
     */
    private BigDecimal price;
    /**
     * 合同金额
     */
    private BigDecimal amount;
    /**
     * 实施单位id
     */
    private int providerId;
    /**
     * 实施单位编码
     */
    private String providerCode;
    /**
     * 实施单位名称
     */
    private String providerName;
    /**
     * 合同签订时间
     */
    private String creationDate;
    /**
     *
     */
    private String byDate;
    /**
     * 验收时间(返质保金用)
     */
    private String endDate;
    /**
     * 管理员id
     */
    private int staffId;
    /**
     * 管理员code
     */
    private String staffCode;
    /**
     * 部门Id
     */
    private int departmentId;
    /**
     * 管理部门名称
     */
    private String departmentName;

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


    private String ids;
}
