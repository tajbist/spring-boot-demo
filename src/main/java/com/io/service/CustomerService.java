package com.io.service;

import com.io.domain.Customer;
import com.io.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepo customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void  delete(Integer custId) {
        customerRepository.deleteById(custId);
    }

    public String  saveOrUpdate(Customer customer) {
        Customer customer1= customerRepository.findByEmailId(customer.getEmailId());
        if(customer == null) {
            return "Customer does not found  with this email : " + customer.getEmailId();
        }
         customerRepository.save(customer);
        return " Customer updated Successfully.";
    }


    public Optional<Customer> getCustomer(Integer custId) {
        return customerRepository.findById(custId);
    }
}
