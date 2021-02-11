package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
        return users;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User show(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void update(Long id, User updUser) {
        entityManager.merge(updUser);

    }
}

