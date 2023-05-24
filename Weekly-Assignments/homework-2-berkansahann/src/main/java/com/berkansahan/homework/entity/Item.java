
package com.berkansahan.homework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * @author berkansahan
 */
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(generator = "Item", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Item", sequenceName = "item_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", length = 50, nullable = false)
    private Double price;

}
