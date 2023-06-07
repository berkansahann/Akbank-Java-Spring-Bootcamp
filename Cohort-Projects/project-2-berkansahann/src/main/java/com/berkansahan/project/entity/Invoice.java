package com.berkansahan.project.entity;

import com.berkansahan.project.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author berkansahan
 */
@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Invoice", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Invoice", sequenceName = "INVOICE_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    // The customer associated with this invoice
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
