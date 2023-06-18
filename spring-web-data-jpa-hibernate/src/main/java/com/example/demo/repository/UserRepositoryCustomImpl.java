package com.example.demo.repository;

import com.example.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    //@PersistenceContext
    //private EntityManager entityManager; // used in case of JPA

    @Autowired
    SessionFactory sessionFactory; //in case of Hibernate

    @Override
    public List<User> findUsersByEmails(Set<String> emails) {
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        Path<String> emailPath = user.get("email");

        List<Predicate> predicates = new ArrayList<>();
        for (String email : emails) {
            predicates.add(cb.like(emailPath, email));
        }
        query.select(user)
                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));

        return sessionFactory.openSession().createQuery(query)
                .getResultList();
    }
}
