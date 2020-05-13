package com.example.demo.entity;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table(name = "PAYMENT_STATUS")
@Entity(name = "paymentStatus")
public class PaymentStatus extends BaseEntity{

	@Id
	@Column(name = "ID",columnDefinition = "varchar(255)")
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",
	  strategy = "uuid")
	private String id;
	@JsonBackReference
	@JoinColumn(name = "PAYMENT_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private Payment payments;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "CREATED_GMT_ON")
	private OffsetDateTime createdGmtOn;
	
	@PrePersist
	public void updateToGmtTime() {
		this.createdGmtOn = OffsetDateTime.now(ZoneId.of("GMT"));
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Payment getPayments() {
		return payments;
	}

	public void setPayments(Payment payments) {
		this.payments = payments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OffsetDateTime getCreatedGmtOn() {
		return createdGmtOn;
	}

	public void setCreatedGmtOn(OffsetDateTime createdGmtOn) {
		this.createdGmtOn = createdGmtOn;
	}

}
