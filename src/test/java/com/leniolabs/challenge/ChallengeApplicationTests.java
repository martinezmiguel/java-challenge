package com.leniolabs.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.leniolabs.challenge.calculator.FeeCalculatorIF;
import com.leniolabs.challenge.custom.AccountType;

@SpringBootTest
class ChallengeApplicationTests {

	@Autowired
	private Map<String, FeeCalculatorIF> feeCalculatorsMap;
	
	

	@Test
	void contextLoads() {
		
		  
		
		
	}

}
