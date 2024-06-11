package com.example.JavaLab3.Domain;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;

@Data
public class User {
    @JMap
    private String name;
    @JMap
    private Integer age;
    private Integer id;

    @Override
    public int hashCode(){
        return id;
    }

}
