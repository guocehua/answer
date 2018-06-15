package com.chris.guo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Chris
 */
@MappedSuperclass
public abstract class LongIdEntity extends BaseEntity<Long> {
    @Id
    @GeneratedValue
    protected Long id;

    @Override
    public Long getId() {
        return id;
    }
}
