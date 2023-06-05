package com.berkansahan.project.controller;

import com.berkansahan.project.controller.contract.CustomerControllerContract;
import com.berkansahan.project.dto.customer.CustomerDTO;
import com.berkansahan.project.dto.customer.CustomerSaveRequest;
import com.berkansahan.project.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest request){
        var customerDTO = customerControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id){
        var customerDTO = customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping
    private ResponseEntity<RestResponse<List<CustomerDTO>>> findAll(){
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @GetMapping("/name")
    private ResponseEntity<RestResponse<List<CustomerDTO>>> findByNameContainsCharacter(@RequestParam String character){
        var customerDTOList = customerControllerContract.findByNameContainsCharacter(character);
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }
}
