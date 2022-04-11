package com.training.paymentService.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.training.paymentService.service.PaymentService;
import com.training.paymentService.model.Payment;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	
	@Autowired
	PaymentService PaymentService;

	
	@GetMapping("/Payments")
	public ResponseEntity<List> Payments() {
		
		return new ResponseEntity<List>(PaymentService.findAll(),HttpStatus.OK);
	}		

		
	
	@GetMapping("/Payment")
	public ResponseEntity<Payment> Payment(@RequestParam int id) {
		
		return new ResponseEntity<Payment>(PaymentService.findById(id),HttpStatus.OK);
	}	

	@PostMapping("/createPayment")
	public ResponseEntity<Payment> create(@RequestBody Payment m) throws URISyntaxException {
		
		return new ResponseEntity<Payment>(PaymentService.save(m),HttpStatus.OK);
	}

	
	
	@PutMapping("/Payment")
	public ResponseEntity<Payment> update(@RequestBody Payment m) throws URISyntaxException {
		
		return new ResponseEntity<Payment>(PaymentService.save(m),HttpStatus.OK);
	}

	@DeleteMapping("/Payment")
	public ResponseEntity<Boolean> delete(@RequestParam int id) {
		
		return new ResponseEntity<Boolean>(PaymentService.deleteById(id),HttpStatus.OK);
	}
	
	
}
