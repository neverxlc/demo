package com.example.demo.domain;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private int sex;
    private int age;

}
