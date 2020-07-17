package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiInfo {

    private String appId;

    private String appName;

    private String appServiceId;

    private Date createTime;

    private Date updateTime;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppServiceId() {
        return appServiceId;
    }

    public void setAppServiceId(String appServiceId) {
        this.appServiceId = appServiceId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String name = "xlc";
        list.add(name);
        System.out.println(list);
    }
}
