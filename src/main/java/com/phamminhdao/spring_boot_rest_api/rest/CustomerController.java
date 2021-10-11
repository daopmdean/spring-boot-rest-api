package com.phamminhdao.spring_boot_rest_api.rest;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;
import com.phamminhdao.spring_boot_rest_api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new RuntimeException("customer not found");
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.save(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.save(customer);

        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new RuntimeException("customer not found");
        }

        customerService.deleteById(id);

        return "customer deleted";
    }
}
