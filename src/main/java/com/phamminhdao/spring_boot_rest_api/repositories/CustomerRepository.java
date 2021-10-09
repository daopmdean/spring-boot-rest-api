package com.phamminhdao.spring_boot_rest_api.repositories;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    public List<Customer> findAll();
    public Customer findById(int id);
    public void save(Customer customer);
    public void deleteById(int id);
}
