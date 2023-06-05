package com.berkansahan.project.general;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author berkansahan
 */
@Getter
@Setter
@Embeddable
public class BaseAdditionalFields {

    @Column(name = "created_by_this_id")
    private Long createdBy;

    @Column(name = "updated_by_this_id")
    private Long updatedBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
}
