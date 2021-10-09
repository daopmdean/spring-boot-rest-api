package com.phamminhdao.spring_boot_rest_api.services.impls;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;
import com.phamminhdao.spring_boot_rest_api.repositories.CustomerRepo;
import com.phamminhdao.spring_boot_rest_api.repositories.CustomerRepository;
import com.phamminhdao.spring_boot_rest_api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> optional = customerRepo.findById(id);
        if (!optional.isPresent()) {
            return null;
        }

        return optional.get();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepo.deleteById(id);
    }
}
