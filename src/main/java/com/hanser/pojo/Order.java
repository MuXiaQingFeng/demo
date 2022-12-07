package com.hanser.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Order {
    //该订单提名或抽签抽中的供应商
    private List<Provider> providerList;

    private int id;
    private int projectId;
    private String orderName;
    private String type;
    private int providerId;
    private String num;
    private String quality;
    private float price;
    private boolean isUp5;
    private Date creationDate;
    private Date byDate;
    private Date endDate;
    private int orderStatus;
    private String priceParity;
    private String yearAdvice;
}
