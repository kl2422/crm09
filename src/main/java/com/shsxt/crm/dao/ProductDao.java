package com.shsxt.crm.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shsxt.crm.dto.ProductQuery;
import com.shsxt.crm.model.Product;

public interface ProductDao {

	PageList<Product> selectForPage(ProductQuery productQuery, PageBounds buildPageBounds);

}
