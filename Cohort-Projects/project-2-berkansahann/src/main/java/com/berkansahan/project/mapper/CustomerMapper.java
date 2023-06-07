package com.berkansahan.project.mapper;

import com.berkansahan.project.dto.customer.CustomerDTO;
import com.berkansahan.project.dto.customer.CustomerSaveRequest;
import com.berkansahan.project.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author berkansahan
 */
@Mapper
public interface CustomerMapper {

    // Get an instance of the CustomerMapper using MapStruct factory
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequest request);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDTOList(List<Customer> customerList);
}
