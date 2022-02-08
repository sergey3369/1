package appCrud.dao;

import appCrud.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoImpl implements Dao {
    final
    EntityManagerFactory entityManagerFactory;

    public DaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        Query query = entityManager.
                createQuery("SELECT e FROM User e");
        List<User> list = query.getResultList();
        return list;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(user);
        entityTransaction.commit();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = entityManager.
                createQuery("select u from User u where u.id = :id");
        query.setParameter("id", (long) id);
        entityTransaction.commit();
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Query query = entityManager.
                createQuery("delete from User u where u.id = :id");
        query.setParameter("id", (long) id);
        query.executeUpdate();
        entityTransaction.commit();
    }

    @Transactional
    @Override
    public void update(User user) {
        EntityManager entityManager = entityManagerFactory
                .createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(user);
        entityTransaction.commit();
    }
}
