package com.example.JavaLab3.Part_1;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class User {
    @JMap
    public String name;
    @JMap
    public Integer age;
    public Integer id;

    @Override
    public int hashCode(){
        return id;
    }

}
