package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.BankPaymentService;

@RestController
@RequestMapping("/bankpayment")
public class PaymentController {
	
	@Autowired
	BankPaymentService bankService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/addBankDetails")
	public ResponseEntity<Payment> savePaymentDetail(@RequestBody Payment payments){
		return ResponseEntity.ok(bankService.saveDetails(payments));
	}
	@PostMapping("/updatebankdetails/{id}")
	public ResponseEntity<Payment> updateBankDetails(@PathVariable String id,@RequestBody Payment details) throws Exception{
		return ResponseEntity.ok(bankService.updateBankDetails(id,details));
	}
}
