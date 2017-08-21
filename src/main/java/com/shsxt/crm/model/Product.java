package com.shsxt.crm.model;

import com.shsxt.crm.base.BaseModel;

/**
 * 产品实体
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Product extends BaseModel {

    private String productName; // 产品名称
    private String model; // 型号
    private String unit; // 单位
    private Float price; // 价格
    private Integer store; // 库存
    private String remark; // 备注

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getStore() {
        return store;
    }
    public void setStore(Integer store) {
        this.store = store;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

}
