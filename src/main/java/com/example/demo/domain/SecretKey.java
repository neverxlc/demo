package com.example.demo.domain;

import java.util.List;

public class SecretKey {

    private String instanceId;

    private String tenantId;

    private String serviceId;

    private String secretId;

    private String secretKey;

    private List<InstanceOrder> instanceOrders;


    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public List<InstanceOrder> getInstanceOrders() {
        return instanceOrders;
    }

    public void setInstanceOrders(List<InstanceOrder> instanceOrders) {
        this.instanceOrders = instanceOrders;
    }
}
