package com.leniolabs.challenge.calculator;

import com.leniolabs.challenge.custom.AccountType;
import org.springframework.stereotype.Component;

@AccountType(value = "corporate")
@Component
public class CorporateAccountFeeCalculator implements FeeCalculatorIF{

	
	public CorporateAccountFeeCalculator() {
		// TODO Auto-generated constructor stub
		
		System.out.println("test");
	}
	
	
    @Override
    public Double calculateFee() {
        return 0.05;
    }
}
