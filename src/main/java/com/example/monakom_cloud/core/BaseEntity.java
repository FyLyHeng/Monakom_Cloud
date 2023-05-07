package com.example.monakom_cloud.core;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A base entity with a few meta information for each dataset like
 * last modifier, creator, last modified date, creation date and a version
 * for collision management.
 *
 * @author Christian Claus (ch.claus@me.com)
 */
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {

    @Id
    private UUID id = UUID.randomUUID();

    @Version
    public Integer version;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdDate;

    @CreatedBy
    public String createdBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    public Date lastModifiedDate;

    @LastModifiedBy
    public String lastModifiedBy;

    public boolean deleted = false;
}