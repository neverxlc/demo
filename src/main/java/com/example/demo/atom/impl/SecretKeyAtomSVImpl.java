package com.example.demo.atom.impl;

import com.example.demo.atom.interfaces.ISecretKeyAtomSV;
import com.example.demo.domain.SecretKey;
import com.example.demo.vo.ThreadLocalPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SecretKeyAtomSVImpl implements ISecretKeyAtomSV {


    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String SECRET_KEY = "secret_key";
    @Override
    public int save(SecretKey secretKey) {
        System.err.println("controller中传过去了的值"+ThreadLocalPerson.getPerson());
        mongoTemplate.save(secretKey, SECRET_KEY);
        return 0;
    }

    @Override
    public List<SecretKey> query() {
        System.err.println(ThreadLocalPerson.getPerson());
        return mongoTemplate.findAll(SecretKey.class, SECRET_KEY);
    }
}
