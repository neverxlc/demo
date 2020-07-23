package com.example.demo.atom.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.atom.interfaces.IApiInfoAtomSV;
import com.example.demo.domain.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApiInfoAtomSVImpl implements IApiInfoAtomSV {

    @Autowired
    private MongoTemplate mongoTemplate;


    private static final String API_INFO = "api_info";

    @Override
    public ApiInfo insert(ApiInfo apiInfo) {
//        Update update = new Update();

//        Map<String,Object> map = (Map<String, Object>) JSON.toJSON(apiInfo);
//        for(Map.Entry<String, Object> entry : map.entrySet()) {
//            update.set(entry.getKey(), entry.getValue());
//        }
//        return mongoTemplate.save(apiInfo, API_INFO);
        return mongoTemplate.save(apiInfo);
    }

    @Override
    public List<ApiInfo> queryList() {
//        return mongoTemplate.findAll(ApiInfo.class, API_INFO);
        return mongoTemplate.findAll(ApiInfo.class);
    }
}
