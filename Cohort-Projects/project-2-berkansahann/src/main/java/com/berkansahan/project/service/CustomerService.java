package com.berkansahan.project.service;

import com.berkansahan.project.entity.Customer;
import com.berkansahan.project.entity.Invoice;
import com.berkansahan.project.general.BaseEntityService;
import com.berkansahan.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

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

    public Double findTotalAmountByRegisteredMonth(Month month) {
        return findAll()
                .stream()
                .filter(customer -> customer.getBaseAdditionalFields().getCreatedDate().getMonth() == month)
                .flatMap(customer -> customer.getInvoiceList().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    public List<Customer> findNameByAmountLowerThan(Double amount) {
        return findAll()
                .stream()
                .filter(customer -> customer.getInvoiceList().stream()
                        .mapToDouble(Invoice::getAmount)
                        .anyMatch(invoiceAmount -> invoiceAmount < amount))
                .toList();
    }
}