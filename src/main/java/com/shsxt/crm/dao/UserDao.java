package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dto.UserQuery;
import com.shsxt.crm.model.User;
import com.shsxt.crm.vo.UserVO;

public interface UserDao {
	
	@Select("select id,user_name as userName, password,true_name as trueName, email, "
			+ " phone, is_valid as isValid, create_date as createDate, update_date as updateDate from t_user "
			+ " where id = #{id}")
	User findById(@Param(value="id")Integer id);
	
	List<User> find();
	
	/**
	 * 根据用户名查询
	 * @param userName
	 * @return
	 */
	@Select("select id, user_name, password, true_name, email "
			+ " from t_user where user_name = #{userName}")
	User findByUserName(@Param(value="userName")String userName);
	
	@Select("SELECT t1.id, t1.true_name FROM t_user t1 LEFT JOIN t_user_role t2 "
			+ " on t1.id = t2.user_id WHERE t2.role_id = 3")
	List<UserVO> findCutomerManager();
	
	PageList<User> selectForPage(UserQuery query, PageBounds buildPageBounds);
	
	void insert(User user);
	
	void update(User user);
	
	void deleteBatch(@Param(value="ids")String ids);
	
	@Update("update t_user set password = #{password} where id = #{userId}")
	int updatePassword(@Param(value="userId")Integer id, @Param(value="password")String newPwd);

}
