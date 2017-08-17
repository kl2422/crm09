package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.shsxt.crm.model.UserRole;

public interface UserRoleDao {
	
	void insertBatch(List<UserRole> userRoles);
	
	@Delete("delete from t_user_role where user_id = #{userId}")
	void deleteByUserId(@Param(value="userId")Integer userId);
	
}
