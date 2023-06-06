package com.berkansahan.project.repository;

import com.berkansahan.project.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author berkansahan
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
