package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.entity.PaymentStatus;
import com.example.demo.repo.PaymentsRepo;

@Service
public class BankPaymentService {
	@Autowired
	PaymentsRepo paymentRepo;

	public List<Payment> getBankDetails() {
		return paymentRepo.findAll();
	}

	public Payment saveDetails(Payment payments) {
		return paymentRepo.save(payments);
	}

	public Payment updateBankDetails(String id, Payment payments) {
		Optional<Payment> paymentOptional = paymentRepo.findById(id);
		Payment payment = paymentOptional.get();
		List<PaymentStatus> paymentStatus = payments.getPaymentStatus();
		payment.getPaymentStatus().add(paymentStatus.get(0));
		paymentStatus.forEach(status -> status.setPayments(payment));
		return paymentRepo.save(payment);
	}

}
