package com.hanser.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//询价报告
public class Report {
    private int id;
    private int orderId;
    private int providerId;
    private float price;
    private Date supplyDate;
    //1:被提名了，2：被抽签抽中了但没有报价，3:已经报完价，4:中标
    private int providerStatus;
    private String nominationReason;
}
