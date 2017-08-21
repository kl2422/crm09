package com.shsxt.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shsxt.crm.base.BaseController;
import com.shsxt.crm.dto.ProductQuery;
import com.shsxt.crm.service.ProductService;

/**
 * Created by Tony on 2016/8/24.
 */
@Controller
@RequestMapping("product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;

	@RequestMapping("index")
	public String index() {
		return "product";
	}

	@RequestMapping("list")
	public @ResponseBody Map<String, Object> selectForPage(ProductQuery productQuery) {
		Map<String, Object> result = productService.selectForPage(productQuery);
		return result;
	}

}
