package com.shsxt.crm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dao.ProductDao;
import com.shsxt.crm.dto.ProductQuery;
import com.shsxt.crm.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public Map<String, Object> selectForPage(ProductQuery productQuery) {
		PageList<Product> pageDatas = productDao.selectForPage(productQuery, productQuery.buildPageBounds());
		Map<String, Object> result = new HashMap<>();
		result.put("rows", pageDatas);
		result.put("total", pageDatas.getPaginator().getTotalCount());
		return result;
	}

}
