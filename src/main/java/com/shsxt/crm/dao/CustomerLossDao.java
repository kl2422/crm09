package com.shsxt.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dto.CustomerLossQuery;
import com.shsxt.crm.model.CustomerLoss;

public interface CustomerLossDao {

	void insertBatch(@Param(value="customerLosses") List<CustomerLoss> customerLosses);
	
	PageList<CustomerLoss> selectForPage(CustomerLossQuery query, PageBounds pageBounds);
	
	CustomerLoss loadById(@Param(value="id") Integer lossId);
	
	void update(CustomerLoss customerLoss);
	
	
}
