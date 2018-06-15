package com.chris.guo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import java.util.Date;

/**
 * @author Chris.Guo
 */
@MappedSuperclass
public abstract class BaseEntity<T> {
    @Column(updatable = false)
    private Date createTime;
    @Version
    private Date modifiedTime;
    @PrePersist
    private void onPrePersist() {
        Date current = new Date();
        if (createTime == null) {
            createTime = current;
        }
    }
    public abstract T getId();
    public Date getCreateTime() {
        return createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseEntity that = (BaseEntity) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
