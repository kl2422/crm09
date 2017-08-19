package com.shsxt.crm.dto;

import com.shsxt.crm.base.BaseQuery;

/**
 * Created by Tony on 2016/8/25.
 */
@SuppressWarnings("serial")
public class CustomerLossQuery extends BaseQuery {
    private String cusName;
    private String cusManager;
    private Integer state;

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
