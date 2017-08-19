package com.shsxt.crm.dto;

import com.shsxt.crm.base.BaseQuery;
import com.shsxt.crm.constant.CustomerServeStatus;

@SuppressWarnings("serial")
public class CustomerServeQuery extends BaseQuery {
	
	private Integer state;
	private String stateStr;
	private String customer;
	private String overview;
	private String serveType;
	private String createTimefrom;
	private String createTimeto;
	public Integer getState() {
		return state;
	}
	public String getStateStr() {
		return stateStr;
	}
	public void setState(Integer state) {
		this.setStateStr(CustomerServeStatus.findByStatus(state));
		this.state = state;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	public String getCustomer() {
		return customer;
	}
	public String getOverview() {
		return overview;
	}
	public String getServeType() {
		return serveType;
	}
	public String getCreateTimefrom() {
		return createTimefrom;
	}
	public String getCreateTimeto() {
		return createTimeto;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public void setServeType(String serveType) {
		this.serveType = serveType;
	}
	public void setCreateTimefrom(String createTimefrom) {
		this.createTimefrom = createTimefrom;
	}
	public void setCreateTimeto(String createTimeto) {
		this.createTimeto = createTimeto;
	}
}
