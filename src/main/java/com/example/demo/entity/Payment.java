package com.example.demo.entity;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "PAYMENTS")
@Entity(name = "payment")
public class Payment extends BaseEntity {

	@Id
	@Column(name = "ID",columnDefinition = "varchar(255)")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",
	  strategy = "uuid")
	private String id;
	@Column(name = "REF_NO")
	private String refNo;
	@Column(name = "PARTNER_REF_NO")
	private String partnerRefNo;
	@Column(name = "PARTNER_CODE")
	private String partnerCode;
	@Column(name = "PRODUCT")
	private String product;
	@Column(name = "SUB_PRODUCT")
	private String subProduct;
	@Column(name = "SERVICE_TYPE")
	private String serviceType;
	@Column(name = "SERVICE_PROVIDER_CODE")
	private String serviceProviderCode;
	@Column(name = "PAYIN_CCY")
	private String payInCcy;
	@Column(name = "PAYOUT_CCY")
	private String payoutCcy;
	@Column(name = "SETTLEMENT_CCY")
	private String settlementCcy;
	@Column(name = "SERVICE_PROVIDER_CCY")
	private String serviceProviderCcy;
	@Column(name = "SETTLEMENT_EQL_PCCY")
	private String settlementEqlPccy;
	@Column(name = "PAYMENT_MODE")
	private String paymentMode;
	@Column(name = "PRN_XCHG_RATE_IN_TO_OUT")
	private Double xchgRateCustomerPayinToPayout;
	@Column(name = "PRN_XCHG_RATE_IN_TO_OUT_O")
	private Double xchgRateCustomerPayinToPayoutOriginal;
	@Column(name = "XCHG_RATE_COUNTRY_IN_TO_OUT")
	private Double xchgRateCountryPayinToPayout;
	@Column(name = "XCHG_RATE_COUNTRY_IN_TO_OUT_O")
	private Double xchgRateCountryPayinToPayoutOriginal;
	@Column(name = "XCHG_RATE_IN_TO_OUT")
	private Double ibrRate;
	@Column(name = "PAYIN_AMOUNT")
	private Double payInAmount;
	@Column(name = "PAYOUT_AMOUNT")
	private Double payoutAmount;
	@Column(name = "SETTLEMENT_AMOUNT")
	private Double settlementAmount;
	@Column(name = "SERVICE_PROVIDER_AMOUNT")
	private Double serviceProviderAmount;
	@Column(name = "SETTLEMENT_EQL_PCCY_AMT")
	private Double settlementEqlProviderAmount;
	@Column(name = "USD_AMOUNT")
	private Double usdAmount;
	@Column(name = "TOTAL_PAYIN_AMOUNT")
	private Double totalPayInAmount;
	@Column(name = "ROUNDING_AMOUNT")
	private Double roundingAmount;
	@Column(name = "CHANNEL")
	private String channel;
	@Column(name = "SOURCE")
	private String source;
	@Column(name = "RATE_CONTEXT")
	private Integer rateContext;
	@Column(name = "CANCEL_LOCK")
	private Integer cancelLock;
	@Column(name = "EXPIRE_AT")
	private OffsetDateTime expireAt;
	@Column(name = "SCREENING_REQUIRED")
	private Integer screeningRequired;
	@Column(name = "ISSUED_ON")
	private OffsetDateTime issuedOn;
	@Column(name = "ISSUED_GMT_ON")
	private OffsetDateTime issuedGmtOn;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "payments")
	List<PaymentStatus> paymentStatus;
	
	@PrePersist
	public void updateToGmtTime() {
		this.issuedGmtOn = OffsetDateTime.now(ZoneId.of("GMT"));
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getPartnerRefNo() {
		return partnerRefNo;
	}

	public void setPartnerRefNo(String partnerRefNo) {
		this.partnerRefNo = partnerRefNo;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSubProduct() {
		return subProduct;
	}

	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceProviderCode() {
		return serviceProviderCode;
	}

	public void setServiceProviderCode(String serviceProviderCode) {
		this.serviceProviderCode = serviceProviderCode;
	}

	public String getPayInCcy() {
		return payInCcy;
	}

	public void setPayInCcy(String payInCcy) {
		this.payInCcy = payInCcy;
	}

	public String getPayoutCcy() {
		return payoutCcy;
	}

	public void setPayoutCcy(String payoutCcy) {
		this.payoutCcy = payoutCcy;
	}

	public String getSettlementCcy() {
		return settlementCcy;
	}

	public void setSettlementCcy(String settlementCcy) {
		this.settlementCcy = settlementCcy;
	}

	public String getServiceProviderCcy() {
		return serviceProviderCcy;
	}

	public void setServiceProviderCcy(String serviceProviderCcy) {
		this.serviceProviderCcy = serviceProviderCcy;
	}

	public String getSettlementEqlPccy() {
		return settlementEqlPccy;
	}

	public void setSettlementEqlPccy(String settlementEqlPccy) {
		this.settlementEqlPccy = settlementEqlPccy;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getXchgRateCustomerPayinToPayout() {
		return xchgRateCustomerPayinToPayout;
	}

	public void setXchgRateCustomerPayinToPayout(Double xchgRateCustomerPayinToPayout) {
		this.xchgRateCustomerPayinToPayout = xchgRateCustomerPayinToPayout;
	}

	public Double getXchgRateCustomerPayinToPayoutOriginal() {
		return xchgRateCustomerPayinToPayoutOriginal;
	}

	public void setXchgRateCustomerPayinToPayoutOriginal(Double xchgRateCustomerPayinToPayoutOriginal) {
		this.xchgRateCustomerPayinToPayoutOriginal = xchgRateCustomerPayinToPayoutOriginal;
	}

	public Double getXchgRateCountryPayinToPayout() {
		return xchgRateCountryPayinToPayout;
	}

	public void setXchgRateCountryPayinToPayout(Double xchgRateCountryPayinToPayout) {
		this.xchgRateCountryPayinToPayout = xchgRateCountryPayinToPayout;
	}

	public Double getXchgRateCountryPayinToPayoutOriginal() {
		return xchgRateCountryPayinToPayoutOriginal;
	}

	public void setXchgRateCountryPayinToPayoutOriginal(Double xchgRateCountryPayinToPayoutOriginal) {
		this.xchgRateCountryPayinToPayoutOriginal = xchgRateCountryPayinToPayoutOriginal;
	}

	public Double getIbrRate() {
		return ibrRate;
	}

	public void setIbrRate(Double ibrRate) {
		this.ibrRate = ibrRate;
	}

	public Double getPayInAmount() {
		return payInAmount;
	}

	public void setPayInAmount(Double payInAmount) {
		this.payInAmount = payInAmount;
	}

	public Double getPayoutAmount() {
		return payoutAmount;
	}

	public void setPayoutAmount(Double payoutAmount) {
		this.payoutAmount = payoutAmount;
	}

	public Double getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(Double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public Double getServiceProviderAmount() {
		return serviceProviderAmount;
	}

	public void setServiceProviderAmount(Double serviceProviderAmount) {
		this.serviceProviderAmount = serviceProviderAmount;
	}

	public Double getSettlementEqlProviderAmount() {
		return settlementEqlProviderAmount;
	}

	public void setSettlementEqlProviderAmount(Double settlementEqlProviderAmount) {
		this.settlementEqlProviderAmount = settlementEqlProviderAmount;
	}

	public Double getUsdAmount() {
		return usdAmount;
	}

	public void setUsdAmount(Double usdAmount) {
		this.usdAmount = usdAmount;
	}

	public Double getTotalPayInAmount() {
		return totalPayInAmount;
	}

	public void setTotalPayInAmount(Double totalPayInAmount) {
		this.totalPayInAmount = totalPayInAmount;
	}

	public Double getRoundingAmount() {
		return roundingAmount;
	}

	public void setRoundingAmount(Double roundingAmount) {
		this.roundingAmount = roundingAmount;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getRateContext() {
		return rateContext;
	}

	public void setRateContext(Integer rateContext) {
		this.rateContext = rateContext;
	}

	public Integer getCancelLock() {
		return cancelLock;
	}

	public void setCancelLock(Integer cancelLock) {
		this.cancelLock = cancelLock;
	}

	public OffsetDateTime getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(OffsetDateTime expireAt) {
		this.expireAt = expireAt;
	}

	public Integer getScreeningRequired() {
		return screeningRequired;
	}

	public void setScreeningRequired(Integer screeningRequired) {
		this.screeningRequired = screeningRequired;
	}

	public OffsetDateTime getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(OffsetDateTime issuedOn) {
		this.issuedOn = issuedOn;
	}

	public OffsetDateTime getIssuedGmtOn() {
		return issuedGmtOn;
	}

	public void setIssuedGmtOn(OffsetDateTime issuedGmtOn) {
		this.issuedGmtOn = issuedGmtOn;
	}

	public List<PaymentStatus> getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(List<PaymentStatus> paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
