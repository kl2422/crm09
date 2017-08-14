package com.shsxt.crm.dto;

import com.shsxt.crm.base.BaseQuery;

@SuppressWarnings("serial")
public class SaleChanceQuery extends BaseQuery {
	
	private String customerName;
	private String overview; 
	private String createMan;
	private Integer state; // 0=未分配 1=已分配
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getCreateMan() {
		return createMan;
	}
	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
