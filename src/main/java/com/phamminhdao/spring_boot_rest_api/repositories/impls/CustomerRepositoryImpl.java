package com.phamminhdao.spring_boot_rest_api.repositories.impls;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;
import com.phamminhdao.spring_boot_rest_api.repositories.CustomerRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private EntityManager entityManager;

    @Autowired
    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery("from customers", Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }
}
