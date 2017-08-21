package com.shsxt.crm.dto;

import com.shsxt.crm.base.BaseQuery;

@SuppressWarnings("serial")
public class KhgxQuery extends BaseQuery {
	
	private String customerName; // 编号

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
}
