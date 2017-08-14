package com.shsxt.crm.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.UserDao;
import com.shsxt.crm.exception.ParamException;
import com.shsxt.crm.model.User;
import com.shsxt.crm.util.MD5Util;
import com.shsxt.crm.util.UserIDBase64;
import com.shsxt.crm.vo.UserLoginIdentity;
import com.shsxt.crm.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 登录
	 * @param userName
	 * @param password
	 */
	public UserLoginIdentity login(String userName, String password) {
//		Map<String, Object> result = new HashMap<>();
		// 基本参数验证
		if(StringUtils.isBlank(userName)) {
			throw new ParamException("请输入用户名");
//			result.put("resultCode", 0);
//			result.put("resultMessage", "请输入用户名");
//			return result;
		}
		
		if(StringUtils.isBlank(password)) {
//			result.put("resultCode", 0);
//			result.put("resultMessage", "请输入密码");
//			return result;
			throw new ParamException("请输入密码");
		}
		// 根据userName查询数据
		User user = userDao.findByUserName(userName.trim());
		
		// 对结果进行判定
		if (user == null) {
			throw new ParamException("用户名或密码错误");
//			result.put("resultCode", 0);
//			result.put("resultMessage", "用户名或密码错误");
//			return result;
		}
		// 密码验证 MD5加密
		String md5Pwd = MD5Util.md5Method(password);
		if (!md5Pwd.equals(user.getPassword())) {
			throw new ParamException("用户名或密码错误");
//			result.put("resultCode", 0);
//			result.put("resultMessage", "用户名或密码错误");
//			return result;
		}
		
		// 构建登录实体
		UserLoginIdentity userLoginIdentity = new UserLoginIdentity();
		userLoginIdentity.setRealName(user.getTrueName());
		userLoginIdentity.setUserIdString(UserIDBase64.encoderUserID(user.getId()));
		userLoginIdentity.setUserName(userName);
		
		// 返回
//		result.put("resultCode", 1);
//		result.put("resultMessage", "登录成功");
//		result.put("result", userLoginIdentity);
//		ResultInfo result = new ResultInfo(Constant.SUCCESS_CODE, "登录成功", userLoginIdentity);
		return userLoginIdentity;
	}

	public List<UserVO> findCutomerManager() {
		List<UserVO> customerManagers = userDao.findCutomerManager();
		return customerManagers;
	}
	
}
