package com.minsub.java.test;

import lombok.Data;
import lombok.ToString;

/**
 * Created by hmm1115222 on 2016-08-18.
 */
@Data
@ToString
public class Person {
    private String name;
    private int age;
    private String address;


    public String print() {
        return this.name + " / " + this.age + " / " + this.address;
    }
}
