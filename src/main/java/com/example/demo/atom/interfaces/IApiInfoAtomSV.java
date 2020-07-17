package com.example.demo.atom.interfaces;

import com.example.demo.domain.ApiInfo;

import java.util.List;

public interface IApiInfoAtomSV {

    ApiInfo insert(ApiInfo apiInfo);

    List<ApiInfo> queryList();
}
