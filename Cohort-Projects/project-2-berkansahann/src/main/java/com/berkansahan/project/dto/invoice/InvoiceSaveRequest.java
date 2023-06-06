package com.berkansahan.project.dto.invoice;

import com.berkansahan.project.dto.customer.CustomerDTO;
import com.berkansahan.project.entity.Customer;

/**
 * @author berkansahan
 */
public record InvoiceSaveRequest(Double amount,
                                 Long customerId) {
}
