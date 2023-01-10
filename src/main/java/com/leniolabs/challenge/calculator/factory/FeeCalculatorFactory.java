package com.leniolabs.challenge.calculator.factory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leniolabs.challenge.calculator.FeeCalculatorIF;

/**
 * 
 * @author Miguel
 *
 */
@Component
public class FeeCalculatorFactory {

	/**
	 * Map with all {@code FeeCalculatorIF} implementations. The keys are the value
	 * of annotation {@code AccountType} on each FeeCalculatorIF class.
	 * 
	 */
	@Autowired
	private Map<String, FeeCalculatorIF> feeCalculatorsMap;

	/**
	 * 
	 * @param accountType
	 * @return
	 */
	public FeeCalculatorIF getFeeCalculator(String accountType) {

		FeeCalculatorIF feeCalculatorIF = feeCalculatorsMap.get(accountType);

		if (feeCalculatorIF == null) {
			throw new FeeCalculatorNotFoundException(accountType);
		}

		return feeCalculatorIF;
	}
}
