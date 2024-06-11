package com.example.JavaLab3.Part_2;

import com.example.JavaLab3.Part_1.BaseService;
import org.springframework.stereotype.Service;

@Service
public class P2_UserService extends BaseService {

    public P2_UserService(P2_UserRepository userRepo) {
        super(userRepo);
    }
}
