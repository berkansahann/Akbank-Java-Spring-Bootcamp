package com.berkansahan.project.service;

import com.berkansahan.project.dto.invoice.InvoiceSaveRequest;
import com.berkansahan.project.entity.Customer;
import com.berkansahan.project.entity.Invoice;
import com.berkansahan.project.general.BaseEntityService;
import com.berkansahan.project.mapper.InvoiceMapper;
import com.berkansahan.project.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author berkansahan
 */
@Service
public class InvoiceService extends BaseEntityService<Invoice, InvoiceRepository> {

    private final CustomerService customerService;

    public InvoiceService(InvoiceRepository repository, CustomerService customerService) {
        super(repository);
        this.customerService = customerService;
    }

    // Save an invoice based on the InvoiceSaveRequest
    public Invoice saveInvoice(InvoiceSaveRequest request){
        Invoice invoice = InvoiceMapper.INSTANCE.convertToInvoice(request);
        Customer customer = customerService.findByIdWithControl(request.customerId());
        invoice.setCustomer(customer);
        save(invoice);
        return invoice;
    }

    // Get invoices with amount greater than the specified amount
    public List<Invoice> findByAmountGreaterThan(Double amount) {
        return findAll()
                .stream()
                .filter(invoice -> invoice.getAmount() > amount)
                .toList();
    }

    // Get the average amount of invoices with amount greater than the specified amount
    public Double findAverageByAmountGreaterThan(Double amount) {
        return findAll()
                .stream()
                .filter(invoice -> invoice.getAmount() > amount)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }
}
