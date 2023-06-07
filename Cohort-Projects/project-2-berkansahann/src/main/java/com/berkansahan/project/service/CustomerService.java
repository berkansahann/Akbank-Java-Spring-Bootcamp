package com.berkansahan.project.service;

import com.berkansahan.project.entity.Customer;
import com.berkansahan.project.entity.Invoice;
import com.berkansahan.project.general.BaseEntityService;
import com.berkansahan.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author berkansahan
 */
@Service
public class CustomerService extends BaseEntityService<Customer, CustomerRepository> {

    public CustomerService(CustomerRepository repository) {
        super(repository);
    }

    // Finds customers whose name contains the specified character.
    public List<Customer> findByNameContainsCharacter(String character){
        return findAll()
                .stream()
                .filter(customer -> customer.getFirstName()
                        .contains(character))
                .toList();
    }

    // Calculates the total amount for customers registered in the specified month.
    public Double findTotalAmountByRegisteredMonth(Month month) {
        return findAll()
                .stream()
                .filter(customer -> customer.getBaseAdditionalFields().getCreatedDate().getMonth() == month)
                .flatMap(customer -> customer.getInvoiceList().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    // Retrieves the names of customers whose amount is lower than the specified amount.
    public List<String> findNameByAmountLowerThan(Double amount) {
        return findAll()
                .stream()
                .filter(customer -> customer.getInvoiceList().stream()
                        .mapToDouble(Invoice::getAmount)
                        .anyMatch(invoiceAmount -> invoiceAmount < amount))
                .map(Customer::getFirstName)
                .toList();
    }

    // Retrieves the sectors of customers whose average amount is higher than the specified amount in the specified month.
    public List<String> findSectorByAverageAmountAndMonth(Month month, Double amount) {
        return findAll()
                .stream()
                .flatMap(customer -> customer.getInvoiceList().stream())
                .filter(invoice -> invoice.getBaseAdditionalFields().getCreatedDate().getMonth() == month)
                .collect(Collectors.groupingBy(
                        invoice -> invoice.getCustomer().getSector(),
                        Collectors.averagingDouble(Invoice::getAmount)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() < amount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}