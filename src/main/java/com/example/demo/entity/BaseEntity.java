package com.example.demo.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@EntityListeners(AuditingEntityListener.class)
//@Embeddable
@MappedSuperclass
public class BaseEntity {

	@CreatedDate
	@Column(name = "CREATED_ON")
	protected Instant createdOn;
	@CreatedBy
	@Column(name = "CREATED_BY")
	protected String createdBy;
	@LastModifiedDate
	protected Instant modifiedOn;
	@LastModifiedBy
	@Column(name = "MODIFIED_BY")
	protected String modifiedBy;
	@Column(name = "RECORDED_ON")
	protected Instant recordedOn;

	/*
	 * @PrePersist public void prePersist() { String createdByUser =
	 * getUsernameOfAuthenticatedUser(); this.createdBy = createdByUser;
	 * this.modifiedBy = createdByUser; }
	 * 
	 * @PreUpdate public void preUpdate() { String modifiedByUser =
	 * getUsernameOfAuthenticatedUser(); this.modifiedBy = modifiedByUser; }
	 * 
	 * private String getUsernameOfAuthenticatedUser() { Authentication
	 * authentication = SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * if (authentication == null || !authentication.isAuthenticated()) { return
	 * null; }
	 * 
	 * return ((User) authentication.getPrincipal()).getUsername(); }
	 */

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Instant modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Instant getRecordedOn() {
		return recordedOn;
	}

	public void setRecordedOn(Instant recordedOn) {
		this.recordedOn = recordedOn;
	}

}
