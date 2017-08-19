package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.shsxt.crm.model.CustomerReprieve;

public interface CustomerReprieveDao {
	@Select("select id, measure from t_customer_reprieve where is_valid = 1 and loss_id = #{lossId}")
	List<CustomerReprieve> findAll(@Param(value="lossId")Integer lossId);
	
	@Insert("insert into t_customer_reprieve (loss_id, measure, "
			+ " create_date, update_date, is_valid) value(#{lossId}, #{measure}, now(), now(), 1)")
	void insert(@Param(value="lossId")Integer lossId, @Param(value="measure")String measure);
	
	@Update("update t_customer_reprieve set measure = #{measure} where id = #{id}")
	void update(@Param(value="id")Integer id, @Param(value="measure")String measure);
	
	@Update("update t_customer_reprieve set is_valid = 0 where id = #{id}")
	void delete(@Param(value="id")Integer id);

}
