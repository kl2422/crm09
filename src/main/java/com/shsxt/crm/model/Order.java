package com.shsxt.crm.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shsxt.crm.base.BaseModel;

/**
 * Created by Tony on 2016/8/24.
 */
@SuppressWarnings("serial")
public class Order extends BaseModel {

    private Integer cusId; // 所属客户
    private String orderNo; // 订单号
    private Date orderDate; // 订购日期
    private String address; // 送货地址
    private Integer state; // 状态 0 未回款 1 已回款
    private Double totalPrice; // 订单总金额

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
}
