package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.atom.interfaces.ISecretKeyAtomSV;
import com.example.demo.domain.SecretKey;
import com.example.demo.vo.ThreadLocalPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("secret-key")
public class SecretKeyController {

    @Autowired
    private ISecretKeyAtomSV secretKeyAtomSV;

    @RequestMapping("save")
    public String insert(@RequestBody SecretKey secretKey){

        ThreadLocalPerson.setPerson("secretKey");
        secretKeyAtomSV.save(secretKey);
        return "成功";
    }


    @RequestMapping("list")
    public List<SecretKey> query() {
        ThreadLocalPerson.setPerson("放入当前线程"+Thread.currentThread().getName());
        List<SecretKey> secretKeys = secretKeyAtomSV.query();
        System.out.println(JSON.toJSONString(secretKeys));
        return secretKeys;
    }

}
