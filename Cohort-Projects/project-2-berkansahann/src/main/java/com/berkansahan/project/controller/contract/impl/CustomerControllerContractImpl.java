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

    @Override
    public CustomerDTO save(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);
        service.save(customer);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = service.findByIdWithControl(id);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = service.findAll();
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
    }

    @Override
    public List<CustomerDTO> findByNameContainsCharacter(String character) {
        List<Customer> customerList = service.findByNameContainsCharacter(character);
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
    }

    @Override
    public Double findTotalAmountByRegisteredMonth(Month month) {
        Double totalAmount = service.findTotalAmountByRegisteredMonth(month);
        return totalAmount;
    }

    @Override
    public List<CustomerDTO> findNameByAmountLowerThan(Double amount) {
        List<Customer> customerList = service.findNameByAmountLowerThan(amount);
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customerList);
    }
}
