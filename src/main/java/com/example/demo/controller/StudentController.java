package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.atom.impl.HumanAtomSVImpl;
import com.example.demo.atom.interfaces.IHumanAtomSV;
import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

//    @Autowired
    private IHumanAtomSV studentAtom;

//    @Bean
//    public IHumanAtomSV humanAtomSV(){
//        return new HumanAtomSVImpl();
//    }

    @Autowired
    public StudentController(IHumanAtomSV studentAtom) {
        this.studentAtom = studentAtom;
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public String save(@RequestBody Student student) {
        System.out.println(JSON.toJSONString(student));
        demo(student);
        return "success";
    }

    @GetMapping(value = "findAll")
    @ResponseBody
    public List<Student> findAll(){
        return studentAtom.findAll();
    }


    private void demo(Student student){
        studentAtom.save(student);
    }

}
