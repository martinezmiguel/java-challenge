package com.leniolabs.challenge.calculator.factory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FeeCalculatorFactoryTests {

	@Autowired
	private FeeCalculatorFactory feeCalculatorIF;

	@Test
	void testGetFeeCalculatorOK() throws FeeCalculatorNotFoundException {
		assertNotNull(feeCalculatorIF.getFeeCalculator("corporate"));
		assertNotNull(feeCalculatorIF.getFeeCalculator("personal"));
	}

	@Test
	void testGetFeeCalculatorFail() throws FeeCalculatorNotFoundException {
		assertThrows(FeeCalculatorNotFoundException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				feeCalculatorIF.getFeeCalculator("Not Name");

			}
		});
	}

}
