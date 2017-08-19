package com.shsxt.crm.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.crm.base.BaseModel;

/**
 * 客户流失实体类
 * Created by Tony on 2016/8/25.
 */
@SuppressWarnings("serial")
public class CustomerLoss extends BaseModel {
    private String cusNo; // 客户编号
    private String cusName; // 客户名称
    private String cusManager; // 客户经理
    private Date lastOrderTime; // 上次下单日期
    private Date confirmLossTime; // 确认流失日期
    private Integer state; // 状态 0 暂缓流失 1 确认流失
    private String lossReason; // 流失原因


    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusManager() {
        return cusManager;
    }

    public void setCusManager(String cusManager) {
        this.cusManager = cusManager;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getLastOrderTime() {
        return lastOrderTime;
    }

    public void setLastOrderTime(Date lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getConfirmLossTime() {
        return confirmLossTime;
    }

    public void setConfirmLossTime(Date confirmLossTime) {
        this.confirmLossTime = confirmLossTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLossReason() {
        return lossReason;
    }

    public void setLossReason(String lossReason) {
        this.lossReason = lossReason;
    }
}
