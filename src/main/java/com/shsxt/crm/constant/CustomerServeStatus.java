package com.shsxt.crm.constant;

/**
 * Created by Tony on 2016/8/25.
 */
public enum CustomerServeStatus {
    // 新建
    NEW_CREATE("新创建", 1),
    // 已分配
    ASSIGNED("已分配", 2),
    // 已处理
    HANDLED("已处理", 3),
    // 已反馈
    FEEDBACK("已反馈", 4),
    // 已归档
    ARCHIVE("已归档", 5);

    private String name;
    private int status;

    private CustomerServeStatus(String name, Integer status) {
        this.status = status;
        this.name = name;
    }

    public static String findByStatus(int status) {
    	for (CustomerServeStatus customerServeStatus : CustomerServeStatus.values()) {
    		if (customerServeStatus.getStatus() == status) {
    			return customerServeStatus.getName();
    		}
    	}
    	/*
        if (status == 1) {
            return CustomerServeStatus.NEW_CREATE.getName();
        } else if (status == 2) {
            return CustomerServeStatus.ASSIGNED.getName();
        } else if (status == 3) {
            return CustomerServeStatus.HANDLED.getName();
        } else if (status == 4) {
            return CustomerServeStatus.FEEDBACK.getName();
        } else if (status == 4) {
            return CustomerServeStatus.ARCHIVE.getName();
        }*/
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
