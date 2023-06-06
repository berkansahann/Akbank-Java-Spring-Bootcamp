package com.berkansahan.project.entity;

import com.berkansahan.project.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author berkansahan
 */
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer", sequenceName = "customer_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "address", length = 400, nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "customer")
    private List<Invoice> invoiceList = new ArrayList<>();

}
