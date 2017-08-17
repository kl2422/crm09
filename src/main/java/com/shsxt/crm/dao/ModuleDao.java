package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.model.Module;
import com.shsxt.crm.vo.ModuleVO;

public interface ModuleDao {
	
	PageList<Module> selectForPage(PageBounds pageBounds);
	
	Module findById(@Param(value="id")Integer id);
	
	void insert(Module module);
	
	Module findByOptValue(String optValue);

	void update(Module moduleFromDB);
	
	void deleteBatch(@Param(value="ids") String ids);
	
	@Select("select id, module_name from t_module where is_valid = 1 and grade = #{grade}")
	List<Module> findByGrade(@Param(value="grade") Integer grade);
	
	@Select("select id, module_name, parent_id from t_module where is_valid = 1 ")
	List<ModuleVO> findAll();

	@Select("SELECT module_id FROM t_permission WHERE role_id = #{roleId} and is_valid = 1")
	List<Integer> findByRoleId(@Param(value="roleId")Integer roleId);
	
	@Select("SELECT id, module_name, parent_id, opt_value FROM t_module where tree_path LIKE '${treePath}%'")
	List<Module> findChildrenModules(@Param(value="treePath") String treePath);

}
