package com.berkansahan.project.general;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author berkansahan
 */
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable, BaseEntityModel{

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
