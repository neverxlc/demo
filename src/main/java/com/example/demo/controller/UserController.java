package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.managedBean.NameService;
import com.example.demo.managedBean.ScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private ScannerService scannerService;
    @Autowired
    private NameService nameService;

    @GetMapping("/named")
    public String named(){
        nameService.test();
        return "SUCCESS";
    }

    @GetMapping("/managedBean")
    public String managedBean(){
        scannerService.walk();
        return "OK";
    }


    @GetMapping("/getAll")
//    @ResponseBody
    public Object getAll(){
        User user = new User();
//        user.setId(1L);
//        user.setName("许林创");
//        user.setAge(211);
//        user.setSex(1);
//        return Arrays.asList(user, User.builder()
//                .name("aaa").age(1).id(2L).build());
        return "getALL";
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Object insert(){

        return "Success";
    }
}
