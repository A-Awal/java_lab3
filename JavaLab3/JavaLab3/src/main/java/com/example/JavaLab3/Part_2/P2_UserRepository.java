package com.example.JavaLab3.Part_2;

import com.example.JavaLab3.Part_1.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final Set<User> users = new HashSet<>();

    public User findUserById(int id) {
        return users.stream().filter(u->u.getId() == id).findFirst().orElse(null);
    }

    public Iterable<User> findAllUsers() {
        return users;
    }

    public int addUser(User user) {
        Random random = new Random();
        var userId = random.nextInt(100);
        user.setId(userId);
        users.add(user);
        return userId;
    }

    public void   updateUser(User user){
        users.add(user);

    }

    public boolean deleteUserById(User user) {
        return users.remove(user);
    }


}
