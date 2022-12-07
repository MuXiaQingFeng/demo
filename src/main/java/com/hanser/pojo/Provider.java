package com.hanser.pojo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
//供应商
public class Provider {
    private List<Order> orderList;
    private float price;
    private Date supplyDate;
    private String nominationReason;


    private int id;

    private String providerName;

    private String providerCode;

    private String providerPassword;

    private int providerStatus;

    private String registrationNumber;

    private String phone;

    private String email;

    private String bankName;

    private String bankId;

    private String bankLevel;

    private int isBankGuarantee;

    private String bankContact;

    private String dutyParagraph;

    private String contacts;

    private String contactPhone;

    private String registeredAddress;

    private String registeredPostcode;

    private String postalAddress;

    private String postalPostcode;

    private String legalPerson;

    private String homepage;

    private int registeredCapital;

    private String wharfConditions;

    private Date creationDate;

    private String ownership;

    private int peopleNumber;

    private String businessScope;

    private int providerNature;

    private int companyNature;

    private int isISO9001;

    private int isISO14001;

    private String licence;
    private String fax;

    private String advice;
}
