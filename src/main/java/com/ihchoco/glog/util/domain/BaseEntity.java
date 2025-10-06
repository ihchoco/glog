package com.ihchoco.glog.util.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = "REGISTER_DATE", updatable = false)
    private LocalDateTime registerDate;

    @CreatedBy
    @Column(name = "REGISTER_ID", updatable = false, length = 50)
    private String registerId;

    @LastModifiedDate
    @Column(name = "UPDATED_DATE")
    private LocalDateTime updatedDate;

    @LastModifiedBy
    @Column(name = "UPDATED_ID", length = 50)
    private String updatedId;

    // getters
    public LocalDateTime getRegisterDate() { return registerDate; }

    public String getRegisterId() { return registerId; }

    public LocalDateTime getUpdatedDate() { return updatedDate; }

    public String getUpdatedId() { return updatedId; }

    // setters
    public void setRegisterId(String registerId) { this.registerId = registerId; }
    public void setUpdatedId(String updatedId) { this.updatedId = updatedId; }

}