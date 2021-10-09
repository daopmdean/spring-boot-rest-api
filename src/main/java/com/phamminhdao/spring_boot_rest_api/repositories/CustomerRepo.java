package com.phamminhdao.spring_boot_rest_api.repositories;

import com.phamminhdao.spring_boot_rest_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
