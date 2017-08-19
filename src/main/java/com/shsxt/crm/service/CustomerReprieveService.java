package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shsxt.crm.dao.CustomerReprieveDao;
import com.shsxt.crm.model.CustomerReprieve;
import com.shsxt.crm.util.AssertUtil;

@Service
public class CustomerReprieveService {
	
	@Autowired
	private CustomerReprieveDao customerReprieveDao;

	public Map<String, Object> findAll(Integer lossId) {
		AssertUtil.intIsNotEmpty(lossId, "请选择暂缓记录");
		List<CustomerReprieve> customerReprieves = customerReprieveDao.findAll(lossId);
		Map<String, Object> result = new HashMap<>();
		result.put("rows", customerReprieves);
		return result;
	}

	public void save(Integer lossId, String measure) {
		AssertUtil.intIsNotEmpty(lossId, "请选择暂缓记录");
		AssertUtil.isNotEmpty(measure, "请输入措施");
		customerReprieveDao.insert(lossId, measure.trim());
	}

	public void update(Integer id, String measure) {
		AssertUtil.intIsNotEmpty(id, "请选择记录");
		AssertUtil.isNotEmpty(measure, "请输入措施");
		customerReprieveDao.update(id, measure.trim());
		
	}

	public void delete(Integer id) {
		customerReprieveDao.delete(id);
	}
	
}
