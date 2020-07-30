package com.example.demo.transation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

public class Demo {

    @Autowired
    TransactionTemplate transactionTemplate;

    private void insert(){


        String a  =transactionTemplate.execute((status)->{


            return "";
        });
    }
}
