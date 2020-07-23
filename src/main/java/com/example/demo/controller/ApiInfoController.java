package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.atom.interfaces.IApiInfoAtomSV;
import com.example.demo.domain.ApiInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api_info")
public class ApiInfoController {

    @Autowired
    private IApiInfoAtomSV apiInfoAtom;


    @PostMapping("/save")
    public String save(@RequestBody ApiInfo apiInfo) {
        System.out.println(JSON.toJSONString(apiInfo));
        ApiInfo a = apiInfoAtom.insert(apiInfo);
        System.out.println(JSON.toJSONString(a));
        return "SUCCESS";
    }

    @GetMapping("list")
    public Object query(){
        List<ApiInfo> apiInfoList = apiInfoAtom.queryList();
        System.out.println(JSON.toJSONString(apiInfoList));
        return apiInfoList;
    }

}
