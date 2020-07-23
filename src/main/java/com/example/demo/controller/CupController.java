package com.example.demo.controller;

import com.example.demo.atom.interfaces.ICupAtomSV;
import com.example.demo.domain.Cup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cup")
public class CupController {

    @Autowired
    ICupAtomSV cupAtomSV;

    @PostMapping("/save")
    public String save(@RequestBody Cup cup){
        cupAtomSV.save(cup);
        return "success";
    }

    @GetMapping("query")
    @ResponseBody
    public List<Cup> findAll(){
        return cupAtomSV.query();

    }

}
