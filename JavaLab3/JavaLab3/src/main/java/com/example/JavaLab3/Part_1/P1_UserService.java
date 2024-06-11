package com.example.JavaLab3.Part_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class P1_UserService extends BaseService<P1_UserRepository> {

    @Autowired
    public P1_UserService(P1_UserRepository userRepo) {
        super(userRepo);
    }
}
