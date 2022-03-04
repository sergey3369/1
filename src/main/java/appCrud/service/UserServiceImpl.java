package appCrud.service;

import appCrud.dao.Dao;
import appCrud.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Dao dao;

    public UserServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public User getUser(Long id) {
        return dao.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        dao.deleteUser(id);
    }

    @Transactional
    @Override
    public void update(User user) { dao.update(user); }
}
