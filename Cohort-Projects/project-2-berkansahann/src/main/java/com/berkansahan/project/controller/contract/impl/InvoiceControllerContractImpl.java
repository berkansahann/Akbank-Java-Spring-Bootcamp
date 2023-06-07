package com.berkansahan.project.controller.contract.impl;

import com.berkansahan.project.controller.contract.InvoiceControllerContract;
import com.berkansahan.project.dto.invoice.InvoiceDTO;
import com.berkansahan.project.dto.invoice.InvoiceSaveRequest;
import com.berkansahan.project.entity.Customer;
import com.berkansahan.project.entity.Invoice;
import com.berkansahan.project.mapper.InvoiceMapper;
import com.berkansahan.project.service.CustomerService;
import com.berkansahan.project.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
@RequiredArgsConstructor
public class InvoiceControllerContractImpl implements InvoiceControllerContract {

    private final InvoiceService service;

    // Save an invoice and convert it to InvoiceDTO
    @Override
    public InvoiceDTO save(InvoiceSaveRequest request) {
        Invoice invoice = service.saveInvoice(request);
        return InvoiceMapper.INSTANCE.convertToInvoiceDTO(invoice);
    }

    // Get all invoices and convert them to a list of InvoiceDTO
    @Override
    public List<InvoiceDTO> findAll() {
        List<Invoice> invoiceList = service.findAll();
        return InvoiceMapper.INSTANCE.convertToInvoiceDTOList(invoiceList);
    }

    // Get invoices with amount greater than the specified amount and convert them to a list of InvoiceDTO
    @Override
    public List<InvoiceDTO> findByAmountGreaterThan(Double amount) {
        List<Invoice> invoiceList = service.findByAmountGreaterThan(amount);
        return InvoiceMapper.INSTANCE.convertToInvoiceDTOList(invoiceList);
    }

    // Get the average amount of invoices with amount greater than the specified amount
    @Override
    public Double findAverageByAmountGreaterThan(Double amount) {
        Double averageByAmountGreaterThan = service.findAverageByAmountGreaterThan(amount);
        return averageByAmountGreaterThan;
    }
}
