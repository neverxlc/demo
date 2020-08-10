package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.atom.interfaces.IApiInfoAtomSV;
import com.example.demo.domain.ApiInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api_info")
@Api(value = "apiInfo-测试",tags={"API-INFO操作接口"})
public class ApiInfoController {

    @Autowired
    private IApiInfoAtomSV apiInfoAtom;


    @PostMapping("/save")
    @ApiOperation(value="保存",notes="注意问题点")
    public String save(@RequestBody ApiInfo apiInfo) {
        System.out.println(JSON.toJSONString(apiInfo));
        ApiInfo a = apiInfoAtom.insert(apiInfo);
        System.out.println(JSON.toJSONString(a));
        return "SUCCESS";
    }

    @GetMapping("list")
    @ApiOperation(value="查询",notes="注意问题点")
    public Object query(){
        List<ApiInfo> apiInfoList = apiInfoAtom.queryList();
        System.out.println(JSON.toJSONString(apiInfoList));
        return apiInfoList;
    }

}
