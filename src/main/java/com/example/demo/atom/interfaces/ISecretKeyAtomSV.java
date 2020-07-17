package com.example.demo.atom.interfaces;

import com.example.demo.domain.SecretKey;

import java.util.List;

public interface ISecretKeyAtomSV {


    int save(SecretKey secretKey);


    List<SecretKey> query();
}
