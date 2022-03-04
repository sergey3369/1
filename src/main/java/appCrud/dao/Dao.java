package appCrud.dao;

import appCrud.model.User;

import java.util.List;

public interface Dao {
    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(Long id);

    public void deleteUser(Long id);

    void update(User user);
}
