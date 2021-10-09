package com.phamminhdao.spring_boot_rest_api.services;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public Customer findById(int id);
    public void save(Customer customer);
    public void deleteById(int id);
}
