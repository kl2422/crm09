package com.shsxt.crm.model;

import com.shsxt.crm.base.BaseModel;

/**
 * 订单详情类
 * Created by Tony on 2016/8/25.
 */
@SuppressWarnings("serial")
public class OrderDetails extends BaseModel {

    private Integer orderId; // 所属订单
    private String goodsName; // 商品名称
    private int goodsNum; // 商品数量
    private String unit; // 单位
    private float price; // 价格
    private float sum; // 总金额


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
