package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.shsxt.crm.model.Permission;

public interface PermissionDao {
	
	@Select("select id, role_id, module_id from t_permission "
			+ " where is_valid = 1 and module_id = #{moduleId} and role_id = #{roleId}")
	Permission findByRolePermission(@Param(value="moduleId")Integer moduleId, @Param(value="roleId")Integer roleId);

	void insertBatch(@Param(value="permissions")List<Permission> permissions);
	
	@Delete("delete from t_permission where module_id = #{moduleId} and role_id = #{roleId}")
	void delete(@Param(value="moduleId")Integer moduleId, @Param(value="roleId")Integer roleId);
	
	@Select("SELECT count(1) from t_permission where role_id = #{roleId} "
			+ " and module_id in (SELECT id FROM t_module where tree_path like '${treePath}%')")
	Integer findChildrens(@Param(value="treePath")String treePath, @Param(value="roleId")Integer roleId);
	
	@Delete("DELETE from t_permission where role_id = #{roleId} and module_id in "
			+ " (SELECT id FROM t_module where tree_path like '${treePath}%')")
	void deelteChildrenModule(@Param(value="treePath")String treePath, @Param(value="roleId")Integer roleId);

}
