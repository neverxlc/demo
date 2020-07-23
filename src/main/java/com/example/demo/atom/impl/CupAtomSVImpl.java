package com.example.demo.atom.impl;

import com.example.demo.atom.interfaces.ICupAtomSV;
import com.example.demo.domain.Cup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CupAtomSVImpl implements ICupAtomSV {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public int save(Cup cup) {
        mongoTemplate.save(cup);
        return 0;
    }

    @Override
    public List<Cup> query() {
        return mongoTemplate.findAll(Cup.class);
    }
}
