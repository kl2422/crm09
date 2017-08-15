package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.RoleDao;
import com.shsxt.crm.model.Role;
import com.shsxt.crm.util.AssertUtil;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public Map<String, Object> findAll() {
		List<Role> roles = roleDao.findAll();
		Map<String, Object> result = new HashMap<>();
		result.put("rows", roles);
		return result;
	}

	public void add(String roleName, String roleRemark) {
		// 基本参数验证  //TODO
		// 唯一性验证
		Role role = roleDao.findByName(roleName.trim());
		AssertUtil.isTrue(role != null, "该角色已存在，请重新输入");
		role = new Role();
		role.setRoleName(roleName);
		role.setRoleRemark(roleRemark);
		roleDao.insert(role);
	}

	public void update(Integer id, String roleName, String roleRemark) {
		// 基本参数验证  //TODO
		AssertUtil.intIsNotEmpty(id, "请选择记录进行更新");
		Role role = findById(id);
		if (!role.getRoleName().equals(roleName)) {
			// 验证名称是否唯一
			Role roleByName = roleDao.findByName(roleName.trim());
			AssertUtil.isTrue(roleByName != null, "该角色已存在，请重新输入");
		}
		role.setRoleName(roleName);
		role.setRoleRemark(roleRemark);
		roleDao.update(role);
	}

	public void deleteBatch(String ids) {
		AssertUtil.isNotEmpty(ids, "请选择记录进行删除");
		roleDao.deleteBatch(ids);
	}

	public Role findById(Integer roleId) {
		AssertUtil.intIsNotEmpty(roleId, "请选择角色");
		Role role = roleDao.findById(roleId);
		AssertUtil.notNull(role, "该角色不存在");
		return role;
	}
	
	
}
