package com.example.demo.atom.interfaces;

import com.example.demo.domain.Student;

import java.util.List;

public interface IHumanAtomSV {


    int save(Student student);


    List<Student> findAll();
}
