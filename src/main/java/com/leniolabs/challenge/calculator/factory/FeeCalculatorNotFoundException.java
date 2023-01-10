/**
 * 
 */
package com.leniolabs.challenge.calculator.factory;

/**
 * @author Miguel
 *
 */
public class FeeCalculatorNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	FeeCalculatorNotFoundException(String accountTypeName) {
	    super("Could not find FeeCalculator by account type name " + accountTypeName);
	  }

}
