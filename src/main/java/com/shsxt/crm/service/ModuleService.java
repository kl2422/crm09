package com.shsxt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.base.BaseQuery;
import com.shsxt.crm.constant.ModuleGrade;
import com.shsxt.crm.dao.ModuleDao;
import com.shsxt.crm.exception.ParamException;
import com.shsxt.crm.model.Module;
import com.shsxt.crm.util.AssertUtil;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleDao moduleDao;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	public Map<String, Object> selectForPage(BaseQuery query) {
		
		// 构建分页查询对象
		PageBounds pageBounds = query.buildPageBounds();
		
		// 直接调用dao的查询方法
		PageList<Module> modules = moduleDao.selectForPage(pageBounds);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", modules);
		result.put("total", modules.getPaginator().getTotalCount());
		return result;
	}
	
	/**
	 * 添加
	 * @param module
	 */
	public void add(Module module) {
		// 基本参数验证
//		String moduleName = module.getModuleName();
//		AssertUtil.isNotEmpty(moduleName, "请输入模块名称");
//		Integer orders = module.getOrders();
//		AssertUtil.intIsNotEmpty(orders, "请输入排序");
//		String url = module.getUrl();
//		AssertUtil.isNotEmpty(url, "请输入访问路径或者方法");
//		String optValue = module.getOptValue();
//		AssertUtil.isNotEmpty(optValue, "请输入操作权限");
//		Integer grade = module.getGrade();
//		AssertUtil.intIsNotEmpty(grade, "请输入层级关系");
		checkParams(module);
		
		// 层级判断 如果是第一级以后就需要有上一级
		Integer grade = module.getGrade();
		if (grade != ModuleGrade.root.getGrade()) {
			AssertUtil.intIsNotEmpty(module.getParentId(), "请选择上一级");
		}
		
		// 构建tree_path
//		if (grade != ModuleGrade.root.getGrade()) { // 只有不是根级才会有treePath
//			// 现获取父级
//			Module parentModule = moduleDao.findById(module.getParentId());
//			AssertUtil.notNull(parentModule, "该父级不存在，请重新选择");
//			String parentTreePath = parentModule.getTreePath();
//			String treePath = "";
//			if (StringUtils.isNoneBlank(parentTreePath)) { 
//				treePath = parentTreePath + parentModule.getId() + ",";
//			} else {// 父级是根级 就不会有treePath
//				treePath = "," + parentModule.getId() + ",";
//			}
//			module.setTreePath(treePath);
//		}
		String treePath =  buildTreePath(grade, module.getParentId());
		module.setTreePath(treePath);
		
		// 权限值的唯一验证
		Module moduleByPermission = moduleDao.findByOptValue(module.getOptValue());
		AssertUtil.isTrue(moduleByPermission != null, "该权限值已存在，请重新输入");
		
		// TODO 统一个父级下的模块名称唯一
		
		module.setCreateDate(new Date());
		module.setUpdateDate(new Date());
		module.setIsValid(1);
		// 保存
		moduleDao.insert(module);
		
	}
	
	/**
	 * 更新
	 * @param module
	 */
	public void update(Module module) {
		// 基本参数验证
		Integer id = module.getId();
		AssertUtil.intIsNotEmpty(id, "请选择记录进行修改");
		checkParams(module);
		
		// 层级判断 如果是第一级以后就需要有上一级
		Integer grade = module.getGrade();
		if (grade != ModuleGrade.root.getGrade()) {
			AssertUtil.intIsNotEmpty(module.getParentId(), "请选择上一级");
		}
		
		// 先根据Id查询此模块
		Module moduleFromDB = moduleDao.findById(id);
		AssertUtil.notNull(moduleFromDB, "此模块不存在，请重新选择");
		
		// 构建tree_path: 先验证数据库中的记录的父级是否等于传入的父级
		if (module.getParentId() != null && !module.getParentId().equals(moduleFromDB.getParentId())) {
			// 构建treePath
			String treePath = buildTreePath(grade, module.getParentId());
			module.setTreePath(treePath);
		} else {
			module.setTreePath(moduleFromDB.getTreePath());
		}
		
		// 权限值的唯一验证
		if (!module.getOptValue().equals(moduleFromDB.getOptValue())) {
			Module moduleByPermission = moduleDao.findByOptValue(module.getOptValue());
			AssertUtil.isTrue(moduleByPermission != null, "该权限值已存在，请重新输入");
		}
		
		// 更新
		BeanUtils.copyProperties(module, moduleFromDB);
		moduleDao.update(moduleFromDB);
	}
	
	/**
	 * 获取某一级的菜单
	 * @param grade
	 * @return
	 */
	public List<Module> findModuleByGrade(Integer grade) {
		if (grade == null || grade < 0) {
			throw new ParamException("请选择层级");
		}
		List<Module> modules = moduleDao.findByGrade(grade);
		return modules;
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	public void delete(String ids) {
		AssertUtil.isNotEmpty(ids, "请选择记录进行删除");
		moduleDao.deleteBatch(ids);
		
	}
	
	/**
	 * 基本参数验证
	 * @param module
	 */
	private void checkParams(Module module) {
		String moduleName = module.getModuleName();
		AssertUtil.isNotEmpty(moduleName, "请输入模块名称");
		Integer orders = module.getOrders();
		AssertUtil.intIsNotEmpty(orders, "请输入排序");
		String url = module.getUrl();
		AssertUtil.isNotEmpty(url, "请输入访问路径或者方法");
		String optValue = module.getOptValue();
		AssertUtil.isNotEmpty(optValue, "请输入操作权限");
		Integer grade = module.getGrade();
		if (grade == null || grade < 0) {
			throw new ParamException("请选择层级关系");
		}
	}
	
	/**
	 * 构建treePath
	 * @param grade
	 * @param parentId
	 * @return
	 */
	private String buildTreePath(Integer grade, Integer parentId) {
		
		if (grade == ModuleGrade.root.getGrade()) { // 根级菜单不需要treePath
			return null;
		}
		String treePath = null;
		// 现获取父级
		Module parentModule = moduleDao.findById(parentId);
		AssertUtil.notNull(parentModule, "该父级不存在，请重新选择");
		String parentTreePath = parentModule.getTreePath();
		if (StringUtils.isNoneBlank(parentTreePath)) { 
			treePath = parentTreePath + parentModule.getId() + ",";
		} else {// 父级是根级 就不会有treePath
			treePath = "," + parentModule.getId() + ",";
		}
		return treePath;
	}
}
