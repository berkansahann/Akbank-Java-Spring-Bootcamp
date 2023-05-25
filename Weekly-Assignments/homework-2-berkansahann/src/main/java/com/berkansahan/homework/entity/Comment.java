package com.berkansahan.homework.entity;

import com.berkansahan.homework.general.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author berkansahan
 */
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "comment_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "comment", length = 100, nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

