package com.leniolabs.challenge.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.leniolabs.challenge.calculator.CorporateAccountFeeCalculator;
import com.leniolabs.challenge.calculator.PersonalAccountFeeCalculator;
import com.leniolabs.challenge.model.Account;
import com.leniolabs.challenge.service.AccounServiceIF;

//@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccounServiceIF accounServiceIF;;

	@Autowired
	private CorporateAccountFeeCalculator corporateAccountFeeCalculator;

	@Autowired
	private PersonalAccountFeeCalculator personalAccountFeeCalculator;

	@Test
	public void calculateFeePersonal() throws Exception {

		Account acccount = new Account("1", "Miguel", "Martinez", "personal", 2.0);

		given(accounServiceIF.findById("1")).willReturn(Optional.of(acccount));

		MvcResult result = mvc
				.perform(get("/lenio-challenge/account/v1//calculate-fee/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		assertEquals(personalAccountFeeCalculator.calculateFee(),
				Double.valueOf(result.getResponse().getContentAsString()));
	}

	@Test
	public void calculateFeeCorporate() throws Exception {

		Account acccount = new Account("2", "lenio", "lab", "corporate", 10.0);

		given(accounServiceIF.findById("2")).willReturn(Optional.of(acccount));

		MvcResult result = mvc
				.perform(get("/lenio-challenge/account/v1//calculate-fee/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		assertEquals(corporateAccountFeeCalculator.calculateFee(),
				Double.valueOf(result.getResponse().getContentAsString()));
	}

	@Test
	public void calculateFeeForInvalidAccountID() throws Exception {

		Account acccount = new Account("2", "lenio", "lab", "corporate", 10.0);

		given(accounServiceIF.findById("2")).willReturn(Optional.of(acccount));

		mvc
				.perform(get("/lenio-challenge/account/v1//calculate-fee/200").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

		
	}
	
	@Test
	public void calculateFeeForInvalidAccountTypeName() throws Exception {

		Account acccount = new Account("2", "lenio", "lab", "none", 10.0);

		given(accounServiceIF.findById("2")).willReturn(Optional.of(acccount));

		mvc
				.perform(get("/lenio-challenge/account/v1//calculate-fee/2").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isConflict());
	}

}
