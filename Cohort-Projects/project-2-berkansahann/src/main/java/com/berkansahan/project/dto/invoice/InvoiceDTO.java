package com.berkansahan.project.dto.invoice;

import com.berkansahan.project.entity.Customer;

/**
 * @author berkansahan
 */
public record InvoiceDTO(Long id,
                         Double amount,
                         Long customerId) {
}
