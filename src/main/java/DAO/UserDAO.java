package DAO;

import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAO {


    EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
    EntityManager manager = factory.createEntityManager();


public List<User> findAll(){

    return manager.createQuery("select  u from User u ", User.class).getResultList();
}

    public void save(User user){
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

    }



    public void close(){
        manager.close();
        factory.close();
    }


    public void delete(Integer valueOf) {
        manager.getTransaction().begin();
        User singleResult = manager.createQuery("select u from User where u.id = " + valueOf, User.class).getSingleResult();
        manager.remove(singleResult);
        manager.getTransaction().commit();
    }
}
