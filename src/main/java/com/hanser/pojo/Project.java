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
     * 項目編碼
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
     * 项目金额
     */
    private BigDecimal amount;
    /**
     * 中标产品id
     */
    private int providerId;
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
    private int orderId;
    /**
     * 合同编号
     */
    private String orderName;
    /**
     * 合同状态
     */
    private String orderStatus;
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

    private String ids;
}
