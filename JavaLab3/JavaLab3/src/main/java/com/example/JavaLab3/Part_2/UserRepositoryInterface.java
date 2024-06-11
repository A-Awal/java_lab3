package Part_2;

import com.example.JavaLab3.Part_1.User;

public interface UserRepositoryInterface {

    public User findUserById(int id) ;
    public Iterable<User> findAllUsers();

    public int addUser(User user);

    public void   updateUser(User user);

    public boolean deleteUserById(User user) ;


}

