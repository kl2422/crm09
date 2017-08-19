package com.shsxt.crm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.model.OrderDetails;

public interface OrderDetailDao {
	
	@Select("SELECT sum(sum) FROM t_order_details where order_id = #{orderId}")
	Integer countTotal(@Param(value="orderId")Integer orderId);
	
	@Select("SELECT t.id, t.goods_name, t.goods_num, t.order_id, t.is_valid,"
			+ "t.create_date, t.price, t.sum, t.unit, t.update_date FROM t_order_details t "
			+ " where order_id = #{orderId}")
	PageList<OrderDetails> selectForPage(@Param("orderId")Integer orderId, PageBounds buildPageBounds);

}
