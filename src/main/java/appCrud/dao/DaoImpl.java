package appCrud.dao;

import appCrud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        Query query = entityManager.
                createQuery("SELECT e FROM User e");
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(Long id) {
        Query query = entityManager.
                createQuery("select u from User u where u.id = :id");
        query.setParameter("id", (long) id);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteUser(Long id) {
        Query query = entityManager.
                createQuery("delete from User u where u.id = :id");
        query.setParameter("id", (long) id);
        query.executeUpdate();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
