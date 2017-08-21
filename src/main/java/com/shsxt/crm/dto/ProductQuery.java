package com.shsxt.crm.dto;

import com.shsxt.crm.base.BaseQuery;

/**
 * Created by Tony on 2016/8/24.
 */
public class ProductQuery extends BaseQuery {
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
