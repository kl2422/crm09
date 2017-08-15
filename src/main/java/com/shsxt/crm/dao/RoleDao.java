package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shsxt.crm.model.Role;

public interface RoleDao {
	
	@Select("select id, role_name, role_remark, create_date, "
			+ "update_date from t_role where is_valid = 1")
	List<Role> findAll();
	
	@Select("select id, role_name, role_remark, create_date, "
			+ "update_date from t_role where is_valid = 1 and role_name = #{roleName}")
	Role findByName(@Param(value="roleName")String roleName);
	
	@Insert("insert into t_role (role_name, role_remark, create_date, update_date, is_valid)"
			+ " values (#{roleName},#{roleRemark},now(),now(),1)")
	void insert(Role role);
	
	@Select("select id, role_name, role_remark, create_date, "
			+ "update_date from t_role where is_valid = 1 and id = #{id}")
	Role findById(@Param(value="id")Integer id);

	@Update("update t_role set role_name = #{roleName}, "
			+ "role_remark = #{roleRemark}, update_date = now() where id = #{id}")
	void update(Role role);
	
	@Update("update t_role set is_valid = 0, update_date = now() where id in (${ids})")
	void deleteBatch(@Param(value="ids")String ids);

}
