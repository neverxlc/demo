package com.example.demo.atom.impl;

import com.example.demo.atom.interfaces.IHumanAtomSV;
import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HumanAtomSVImpl implements IHumanAtomSV {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public int save(Student student) {
//        return mongoTemplate.save(student);
        mongoTemplate.insert(student);
        demo();
        return 0;
    }

    private void demo(){

    }

    @Override
    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }

}
