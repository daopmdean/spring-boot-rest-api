package com.phamminhdao.spring_boot_rest_api.repositories.impls;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;
import com.phamminhdao.spring_boot_rest_api.repositories.CustomerRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerRepositoryJpaImpl implements CustomerRepository {
    private EntityManager entityManager;

    @Autowired
    public CustomerRepositoryJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        Query theQuery =
                entityManager.createQuery("from Customer");
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public void save(Customer customer) {
        Customer theCustomer = entityManager.merge(customer);
        customer.setId(theCustomer.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager
                .createQuery("delete from Customer where id=:id");
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
