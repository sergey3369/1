package appCrud.service;

import appCrud.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(Integer id);

    void update( User user);
}
