package com.leniolabs.challenge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leniolabs.challenge.calculator.FeeCalculatorIF;
import com.leniolabs.challenge.calculator.factory.FeeCalculatorFactory;
import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.service.AccounServiceIF;

@RestController
@RequestMapping("/lenio-challenge/account/v1")
public class AccountController {

	@Autowired
	private AccounServiceIF accountControllerService;

	@Autowired
	private FeeCalculatorFactory feeCalculatorFactory;

	@Autowired
	AccounServiceIF accounServiceIF;

	@PostMapping(value = "/create")
	public ResponseEntity<String> createAccount(@RequestBody Account account) {
		String accountId = accountControllerService.createAccount(account);
		return ResponseEntity.ok(accountId);
	}

	@GetMapping(value = "/calculate-fee/{id}")
	public ResponseEntity<Double> calculateFee(@PathVariable String id) throws Exception {

		// Develop the logic inside FeeCalculatorFactory and AccountController, taking
		// into account that AccountController must return the fee based on the type of
		// the account object. HINT: try to think how the factory class can return the
		// correct implementation of the calculator interface (multiple injected
		// instances of the same class/interface). This must be done using Spring
		// Annotations, NO EXCEPTION.

		Optional<Account> accountOp = accounServiceIF.findById(id);

		if (accountOp.isPresent()) {

			Account acc = accountOp.get();

			FeeCalculatorIF feeCalculator = feeCalculatorFactory.getFeeCalculator(acc.getAccountType());

			Double fee = feeCalculator.calculateFee();

			return ResponseEntity.accepted().body(fee);

		} else {

			return ResponseEntity.badRequest().body(null);
		}

	}
}
