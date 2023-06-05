package com.berkansahan.project.service;

import com.berkansahan.project.entity.Customer;
import com.berkansahan.project.general.BaseEntityService;
import com.berkansahan.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
public class CustomerService extends BaseEntityService<Customer, CustomerRepository> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }

    public List<Customer> findByNameContainsCharacter(String character){
        return findAll()
                .stream()
                .filter(customer -> customer.getFirstName()
                        .contains(character))
                .toList();
    }
}