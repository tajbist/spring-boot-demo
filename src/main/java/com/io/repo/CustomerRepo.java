package com.io.repo;

import com.io.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByEmailId(String emailId);
}
