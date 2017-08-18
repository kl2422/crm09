package com.shsxt.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.constant.ModuleGrade;
import com.shsxt.crm.dao.ModuleDao;
import com.shsxt.crm.dao.PermissionDao;
import com.shsxt.crm.model.Module;
import com.shsxt.crm.model.Permission;
import com.shsxt.crm.model.Role;
import com.shsxt.crm.util.AssertUtil;

@Service
public class PermissionService {

	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private ModuleDao moduleDao;

	/**
	 * 授权或者取消权限
	 * @param roleId 角色ID
	 * @param moduleId 模块ID
	 * @param checked 是否授权
	 */
	//	public void addDodoRelate(Integer roleId, Integer moduleId, boolean checked) {
	//		
	//		// 基本参数验证
	//		AssertUtil.intIsNotEmpty(roleId, "请选择角色");
	//		AssertUtil.intIsNotEmpty(moduleId, "请选择模块");
	//		
	//		// 角色验证
	//		Role role = roleService.findById(roleId);
	//		AssertUtil.notNull(role, "该角色不存在");
	//		
	//		// 模块验证
	//		Module module = moduleService.findById(moduleId);
	//		AssertUtil.notNull(module, "该模块不存在");
	//		
	//		// 判断checked
	//		if (checked) { // 授权
	//			List<Permission> permissions = new ArrayList<>();
	//			// 先把该模块赋值给此角色
	//			Permission permission = new Permission();
	//			permission.setAclValue(module.getOptValue());
	//			permission.setModuleId(moduleId);
	//			permission.setRoleId(roleId);
	//			permissions.add(permission);
	//			
	//			// 把父模块赋值给此角色
	//			// 1. 先查询父模块是否绑定此角色: 父模块可能有多个
	//			if(ModuleGrade.first.getGrade() == module.getGrade()) { // 第一级有一个父模块
	//				Permission parentPermission = permissionDao.findByRolePermission(module.getParentId(), roleId);
	//				if (parentPermission == null) { // 父模块没有绑定子模块
	//					Module parentModule = moduleService.findById(module.getParentId());
	//					parentPermission = new Permission();
	//					parentPermission.setAclValue(parentModule.getOptValue());
	//					parentPermission.setModuleId(parentModule.getId());
	//					parentPermission.setRoleId(roleId);
	//					permissions.add(parentPermission);
	//				}
	//			} else if (ModuleGrade.second.getGrade() == module.getGrade()) { // 第二级有两父模块
	//				String[] parentIds = module.getTreePath()
	//						.substring(1, module.getTreePath().lastIndexOf(",") + 1).split(","); // ,1,2,
	//				for(String parentIdStr : parentIds) {
	//					Permission parentPermission = permissionDao.findByRolePermission(Integer.parseInt(parentIdStr), roleId);
	//					if (parentPermission != null) {
	//						continue;
	//					}
	//					Module parentModule = moduleService.findById(Integer.parseInt(parentIdStr));
	//					parentPermission = new Permission();
	//					parentPermission.setAclValue(parentModule.getOptValue());
	//					parentPermission.setModuleId(parentModule.getId());
	//					parentPermission.setRoleId(roleId);
	//					permissions.add(parentPermission);
	//				}
	//			}
	//			
	//			// 把子模块赋值给此角色
	//			String treePath = "";
	//			if (ModuleGrade.root.getGrade() == module.getGrade()) {
	//				treePath = "," + moduleId + ",";
	//			} else {
	//				treePath = module.getTreePath() + moduleId + ",";
	//			}
	//			
	//			List<Module> childrenModules = moduleDao.findChildrenModules(treePath);
	//			for(Module childModule : childrenModules) {
	//				Permission childPermission = new Permission();
	//				childPermission.setAclValue(childModule.getOptValue());
	//				childPermission.setModuleId(childModule.getId());
	//				childPermission.setRoleId(roleId);
	//				permissions.add(childPermission);
	//			}
	//			
	//			// 执行插入操作
	//			permissionDao.insertBatch(permissions);
	//			
	//		} else { // 取消权限
	//			
	//			// 解绑本模块
	//			permissionDao.delete(moduleId, roleId);
	//			
	//			// 解绑本模块的子级模块
	//			// 获取子模块然后在删除
	//			String treePath = "";
	//			if (ModuleGrade.root.getGrade() == module.getGrade()) {
	//				treePath = "," + moduleId + ",";
	//			} else {
	//				treePath = module.getTreePath() + moduleId + ",";
	//			} 
	//			permissionDao.deelteChildrenModule(treePath, roleId);
	//			
	//			
	//			// 解绑本模块的父级模块
	//			if(module.getGrade() > ModuleGrade.root.getGrade()) { // 排除根级模块
	//				String[] parentIds = module.getTreePath()
	//						.substring(1, module.getTreePath().lastIndexOf(",")).split(","); // ,1,2,
	//				for(int i = parentIds.length - 1; i > -1; i-- ) {
	//					Integer parentId = Integer.parseInt(parentIds[i]);
	//					// 判定parentId下面是否有其他子级与此角色进行过绑定 如果有就不删除，如没有就删除
	//					// 获取父级模块
	//					Module parentModule = moduleDao.findById(parentId);
	//					String ptreePath = "";
	//					if (ModuleGrade.root.getGrade() == parentModule.getGrade()) {
	//						ptreePath = "," + parentId + ",";
	//					} else {
	//						ptreePath = parentModule.getTreePath() + parentId + ",";
	//					} 
	//					Integer count = permissionDao.findChildrens(ptreePath, roleId);
	//					if (count == null || count == 0) {
	//						permissionDao.delete(parentId, roleId);
	//					}
	//				}
	//			}
	//			
	//		}
	//	}

	/**
	 * 添加权限
	 * @param roleId
	 * @param moduleId
	 * @param checked
	 */
	public void addDodoRelate(Integer roleId, Integer moduleId, boolean checked) {

		// 基本参数验证
		AssertUtil.intIsNotEmpty(roleId, "请选择角色");
		AssertUtil.intIsNotEmpty(moduleId, "请选择模块");

		// 角色验证
		Role role = roleService.findById(roleId);
		AssertUtil.notNull(role, "该角色不存在");

		// 模块验证
		Module module = moduleService.findById(moduleId);
		AssertUtil.notNull(module, "该模块不存在");

		// 判断checked
		if (checked) { // 授权
			List<Permission> permissions = new ArrayList<>();
			// 先把该模块赋值给此角色
			buildPermission(module, roleId, permissions);

			// 把父模块赋值给此角色
			addParentModulePermission(module, roleId, permissions);

			// 把子模块赋值给此角色
			addChildrenModulePermission(module, roleId, permissions);

			// 执行插入操作
			permissionDao.insertBatch(permissions);

		} else { // 取消权限

			// 解绑本模块
			permissionDao.delete(moduleId, roleId);

			// 解绑本模块的子级模块: 获取子模块然后在删除
			String treePath = buildTreePath(module);
			permissionDao.deleteChildrenModule(treePath, roleId);

			// 解绑本模块的父级模块
			releaseParentModule(module, roleId);
		}
	}

	/**
	 * 添加父模块权限
	 * @param module
	 * @param roleId
	 * @param permissions
	 */
	private void addParentModulePermission(Module module, Integer roleId, 
			List<Permission> permissions) {
		// 先查询父模块是否绑定此角色: 父模块可能有多个
		if(ModuleGrade.first.getGrade() == module.getGrade()) { // 第一级有一个父模块
			Permission parentPermission = permissionDao.findByRolePermission(module.getParentId(), roleId);
			if (parentPermission != null) { // 父模块没有绑定子模块
				return;
			}
			Module parentModule = moduleService.findById(module.getParentId());
			buildPermission(parentModule, roleId, permissions);
		} else if (ModuleGrade.second.getGrade() == module.getGrade()) { // 第二级有两父模块
			String[] parentIds = module.getTreePath()
					.substring(1, module.getTreePath().lastIndexOf(",") + 1).split(","); // ,1,2,
			for(String parentIdStr : parentIds) {
				Permission parentPermission = permissionDao.findByRolePermission(Integer.parseInt(parentIdStr), roleId);
				if (parentPermission != null) {
					continue;
				}
				Module parentModule = moduleService.findById(Integer.parseInt(parentIdStr));
				buildPermission(parentModule, roleId, permissions);
			}
		}
	}

	/**
	 * 添加子模块
	 * @param module
	 * @param roleId
	 * @param permissions
	 */
	private void addChildrenModulePermission(Module module, Integer roleId, 
			List<Permission> permissions) {

		// 构建treePath
		String treePath = buildTreePath(module);

		List<Module> childrenModules = moduleDao.findChildrenModules(treePath);
		for(Module childModule : childrenModules) {
			buildPermission(childModule, roleId, permissions);
		}
	}
	
	/**
	 * 解绑
	 * @param module
	 * @param roleId
	 */
	private void releaseParentModule(Module module, Integer roleId) {
		// 排除根级模块
		if(module.getGrade() == ModuleGrade.root.getGrade()) {
			return;
		}
		String treePath = module.getTreePath(); // ,1,2,
		String[] parentIds = treePath.substring(treePath.indexOf(",") + 1, treePath.lastIndexOf(",")).split(","); 
		
		for(int i = parentIds.length - 1; i > -1; i-- ) {
			Integer parentId = Integer.parseInt(parentIds[i]);
			// 判定parentId下面是否有其他子级与此角色进行过绑定 如果有就不删除，如没有就删除
			// 获取父级模块
			Module parentModule = moduleDao.findById(parentId);
			String ptreePath = buildTreePath(parentModule);
			Integer count = permissionDao.findChildrens(ptreePath, roleId);
			if (count == null || count == 0) {
				permissionDao.delete(parentId, roleId);
			}
		}
	}

	/**
	 * 添加Permission
	 * @param module
	 * @param roleId
	 * @param permissions
	 */
	private void buildPermission(Module module, Integer roleId, 
			List<Permission> permissions) {
		Permission permission = new Permission();
		permission.setAclValue(module.getOptValue());
		permission.setModuleId(module.getId());
		permission.setRoleId(roleId);
		permissions.add(permission);
	}

	/**
	 * 构建treePath
	 * @param module
	 * @return
	 */
	private String buildTreePath(Module module) {
		String treePath = "";
		if (ModuleGrade.root.getGrade() == module.getGrade()) {
			treePath = "," + module.getId() + ",";
		} else {
			treePath = module.getTreePath() + module.getId() + ",";
		}
		return treePath;
	}

	/**
	 * 获取登录用户的权限
	 * @param userId
	 * @return
	 */
	public List<String> findUserPermissions(Integer userId) {
		AssertUtil.intIsNotEmpty(userId, "请登录");
		List<String> permissions = permissionDao.findUserPermissions(userId);
		return permissions;
	}

}
