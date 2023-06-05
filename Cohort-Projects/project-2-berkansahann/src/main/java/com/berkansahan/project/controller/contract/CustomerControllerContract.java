package com.berkansahan.project.controller.contract;

import com.berkansahan.project.dto.customer.CustomerDTO;
import com.berkansahan.project.dto.customer.CustomerSaveRequest;

import java.util.List;

/**
 * @author berkansahan
 */
public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveRequest requestDTO);

    CustomerDTO findById(Long id);

    List<CustomerDTO> findAll();

    List<CustomerDTO> findByNameContainsCharacter(String character);


}
