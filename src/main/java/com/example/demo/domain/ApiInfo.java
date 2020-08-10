package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@ApiModel(value="user对象",description="用户对象user")
public class ApiInfo {

    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="appName",name="appName")
    private String appName;
    @ApiModelProperty(value="appServiceId",name="appServiceId")
    private String appServiceId;
    @ApiModelProperty(value="createTime",name="createTime")
    private Date createTime;
    @ApiModelProperty(value="updateTime",name="updateTime")
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
