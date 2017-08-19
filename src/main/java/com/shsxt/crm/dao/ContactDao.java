package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dto.ContactQuery;
import com.shsxt.crm.model.Contact;

public interface ContactDao {
	
	
	@Select("select id, cus_id, contact_time, address, overview, "
			+ " create_date, update_date from t_customer_contact "
			+ " where cus_id = #{customerId} and is_valid = 1")
	PageList<Contact> selectForPage(ContactQuery query, PageBounds pageBounds);
	
	@Insert("insert into t_customer_contact (cus_id, contact_time, address, "
			+ " overview, create_date, update_date, is_valid) values(#{cusId},"
			+ "#{contactTime},#{address},#{overview},now(),now(),1)")
	void insert(Contact contact);
	
	@Update("update t_customer_contact set contact_time = #{contactTime}, "
			+ "address = #{address}, overview = #{overview}, update_date = now() where id = #{id}")
	void update(Contact contact);
	
	@Update("update t_customer_contact set is_valid = 0 where id = #{id}")
	void delete(@Param(value="id")Integer id);

}
