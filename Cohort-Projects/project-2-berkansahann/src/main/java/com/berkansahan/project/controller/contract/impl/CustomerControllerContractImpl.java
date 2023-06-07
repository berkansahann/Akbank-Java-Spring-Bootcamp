package com.berkansahan.project.controller.contract.impl;

import com.berkansahan.project.controller.contract.CustomerControllerContract;
import com.berkansahan.project.dto.customer.CustomerDTO;
import com.berkansahan.project.dto.customer.CustomerSaveRequest;
import com.berkansahan.project.entity.Customer;
import com.berkansahan.project.mapper.CustomerMapper;
import com.berkansahan.project.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

    private final CustomerService service;

    // Saves a customer based on the provided request.
    @Override
    public CustomerDTO save(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        service.save(customer);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    // Retrieves a customer by ID.
    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = service.findByIdWithControl(id);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    // Retrieves all customers.
    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = service.findAll();
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
    }

    // Retrieves customers whose name contains the specified character.
    @Override
    public List<CustomerDTO> findByNameContainsCharacter(String character) {
        List<Customer> customerList = service.findByNameContainsCharacter(character);
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
    }

    // Calculates the total amount for customers registered in the specified month.
    @Override
    public Double findTotalAmountByRegisteredMonth(Month month) {
        Double totalAmount = service.findTotalAmountByRegisteredMonth(month);
        return totalAmount;
    }

    // Retrieves the names of customers invoices amount is lower than the specified amount.
    @Override
    public List<String> findNameByAmountLowerThan(Double amount) {
        List<String> nameList = service.findNameByAmountLowerThan(amount);
        return nameList;
    }

    // Retrieves the sectors of customers whose average amount is higher than the specified amount in the specified month.
    @Override
    public List<String> findSectorByAverageAmountAndMonth(Month month, Double amount) {
        List<String> sectorList = service.findSectorByAverageAmountAndMonth(month, amount);
        return sectorList;
    }
}
