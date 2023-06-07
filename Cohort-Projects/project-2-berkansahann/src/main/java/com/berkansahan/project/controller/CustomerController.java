package com.berkansahan.project.controller;

import com.berkansahan.project.controller.contract.CustomerControllerContract;
import com.berkansahan.project.dto.customer.CustomerDTO;
import com.berkansahan.project.dto.customer.CustomerSaveRequest;
import com.berkansahan.project.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    /**
     * Save a customer.
     *
     * @param request the customer save request
     * @return the response entity containing the saved customer DTO
     */
    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest request){
        var customerDTO = customerControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    /**
     * Find a customer by ID.
     *
     * @param id the customer ID
     * @return the response entity containing the found customer DTO
     */
    @GetMapping("{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id){
        var customerDTO = customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    /**
     * Get all customers.
     *
     * @return the response entity containing the list of all customer DTOs
     */
    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll(){
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    /**
     * Find customers by name containing a specific character.
     *
     * @param character the character to search for in the customer names
     * @return the response entity containing the list of customer DTOs matching the search
     */
    @GetMapping("/name/character")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findByNameContainsCharacter(@RequestParam String character){
        var customerDTOList = customerControllerContract.findByNameContainsCharacter(character);
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    /**
     * Find the total amount of customers registered in a specific month.
     *
     * @param month the month to calculate the total amount for
     * @return the response entity containing the total amount
     */
    @GetMapping("/month/total-amount")
    public ResponseEntity<RestResponse<Double>> findTotalAmountByRegisteredMonth(@RequestParam Month month){
        Double totalAmount = customerControllerContract.findTotalAmountByRegisteredMonth(month);
        return ResponseEntity.ok(RestResponse.of(totalAmount));
    }

    /**
     * Find customer names whose amount is lower than a specified value.
     *
     * @param amount the maximum amount allowed
     * @return the response entity containing the list of customer names
     */
    @GetMapping("/name/amount-lower-than")
    public ResponseEntity<RestResponse<List<String>>> findNameByAmountLowerThan(@RequestParam Double amount){
        List<String> nameList = customerControllerContract.findNameByAmountLowerThan(amount);
        return ResponseEntity.ok(RestResponse.of(nameList));
    }

    /**
     * Find customer sectors whose average amount in a specific month is greater than a specified value.
     *
     * @param month  the month to calculate the average amount for
     * @param amount the minimum average amount allowed
     * @return the response entity containing the list of customer sectors
     */
    @GetMapping("sector/month/average-amount")
    public ResponseEntity<RestResponse<List<String>>> findSectorByAverageAmountAndMonth(@RequestParam Month month, Double amount){
        List<String> sectorList = customerControllerContract.findSectorByAverageAmountAndMonth(month, amount);
        return ResponseEntity.ok(RestResponse.of(sectorList));
    }
}
