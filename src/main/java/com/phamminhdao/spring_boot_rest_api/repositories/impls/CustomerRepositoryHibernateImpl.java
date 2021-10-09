package com.phamminhdao.spring_boot_rest_api.repositories.impls;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;
import com.phamminhdao.spring_boot_rest_api.repositories.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerRepositoryHibernateImpl implements CustomerRepository {
    private EntityManager entityManager;

    @Autowired
    public CustomerRepositoryHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Customer> theQuery =
                currentSession.createQuery("from Customer", Customer.class);

        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public Customer findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession
                .createQuery("delete from Customer where id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
