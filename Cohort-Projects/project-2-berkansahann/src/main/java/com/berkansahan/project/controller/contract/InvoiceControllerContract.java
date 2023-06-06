package com.berkansahan.project.controller.contract;

import com.berkansahan.project.dto.invoice.InvoiceDTO;
import com.berkansahan.project.dto.invoice.InvoiceSaveRequest;

import java.util.List;

/**
 * @author berkansahan
 */
public interface InvoiceControllerContract {

    InvoiceDTO save(InvoiceSaveRequest request);

    List<InvoiceDTO> findAll();

    List<InvoiceDTO> findByAmountGreaterThan(Double amount);

    Double findAverageByAmountGreaterThan(Double amount);
}
