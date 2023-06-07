package com.berkansahan.project.controller;

import com.berkansahan.project.controller.contract.InvoiceControllerContract;
import com.berkansahan.project.dto.invoice.InvoiceDTO;
import com.berkansahan.project.dto.invoice.InvoiceSaveRequest;
import com.berkansahan.project.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author berkansahan
 */
@RestController
@RequestMapping("/api/v1/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceControllerContract invoiceControllerContract;

    /**
     * Save an invoice.
     *
     * @param request the invoice save request
     * @return the response entity containing the saved invoice DTO
     */
    @PostMapping
    public ResponseEntity<RestResponse<InvoiceDTO>> save(@RequestBody InvoiceSaveRequest request){
        var invoiceDTO = invoiceControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(invoiceDTO));
    }

    /**
     * Get all invoices.
     *
     * @return the response entity containing the list of all invoice DTOs
     */
    @GetMapping
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findAll(){
        var invoiceDTOList = invoiceControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(invoiceDTOList));
    }

    /**
     * Get invoices with amount greater than the specified amount.
     *
     * @param amount the minimum amount allowed
     * @return the response entity containing the list of invoice DTOs
     */
    @GetMapping("/amount-greater-than")
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findByAmountGreaterThan(@RequestParam Double amount){
        var customerDTOList = invoiceControllerContract.findByAmountGreaterThan(amount);
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    /**
     * Get the average amount of invoices with amount greater than the specified amount.
     *
     * @param amount the minimum amount allowed
     * @return the response entity containing the average amount
     */
    @GetMapping("/amount-greater-than/average")
    public ResponseEntity<RestResponse<Double>> findAverageByAmountGreaterThan(@RequestParam Double amount){
        Double averageAmount = invoiceControllerContract.findAverageByAmountGreaterThan(amount);
        return ResponseEntity.ok(RestResponse.of(averageAmount));
    }
}