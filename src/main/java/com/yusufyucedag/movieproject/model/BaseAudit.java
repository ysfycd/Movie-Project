package com.yusufyucedag.movieproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseAudit implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@CreatedDate
    @Column(name = "created_at")
    protected Date cretedAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected Date modifiedAt;
}
