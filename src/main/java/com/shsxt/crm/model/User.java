package com.shsxt.crm.model;

import java.util.ArrayList;
import java.util.List;

import com.shsxt.crm.base.BaseModel;
import com.shsxt.crm.vo.RoleVO;

@SuppressWarnings("serial")
public class User extends BaseModel {
	
	private String userName;
	private String password;
	private String trueName;
	private String email;
	private String phone;
	private Integer isValid;
	private List<RoleVO> roles;
	private List<Integer> roleIds;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public List<RoleVO> getRoles() {
		List<Integer> roleIds = new ArrayList<>();
		if (roles != null && roles.size() > 0) {
			for(RoleVO role : roles) {
				roleIds.add(role.getId());
			}
			setRoleIds(roleIds);
		}
		return roles;
	}
	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	
}
