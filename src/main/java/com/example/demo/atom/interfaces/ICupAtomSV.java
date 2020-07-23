package com.example.demo.atom.interfaces;

import com.example.demo.domain.Cup;

import java.util.List;

public interface ICupAtomSV {

    int save(Cup cup);


    List<Cup> query();
}
