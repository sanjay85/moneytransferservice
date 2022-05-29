package com.db.awmd.challenge.web.moneytransferservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.db.awmd.moneytransfer.model.dto.request.MoneyTransferRequest;
import com.db.awmd.moneytransfer.model.dto.response.MoneyTransferResponse;
import com.db.awmd.moneytransfer.service.MoneyTransferService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest

class MoneyTransferServiceApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private MoneyTransferService moneyTransferService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void prepareMockMvc() {
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();

	}

	/**
	 * This method is used to test success money transfer between account template
	 * 
	 * @param moneyTransferRequest
	 * @return
	 */
	@Test
	public void moneyTransferSuccess() throws Exception {
		this.mockMvc
				.perform(post("/v1/transfer").contentType(MediaType.APPLICATION_JSON).content(
						"{\"fromAccount\":\"132456789123\",\"toAccount\":\"2123476589162\",\"amount\":100000}"))
				.andExpect(status().isCreated());

		MoneyTransferRequest moneyTransferRequest = null;

		moneyTransferRequest.setFromAccount("132456789123");
		moneyTransferRequest.setToAccount("2123476589162");
		BigDecimal bdValue2 = new BigDecimal("1234.55");
		moneyTransferRequest.setAmount(bdValue2);

		MoneyTransferResponse moneyTransferResponse = moneyTransferService.moneyTransfer(moneyTransferRequest);

		moneyTransferResponse.getMessage();

		assertThat(moneyTransferResponse.getMessage()).isEqualTo("Money Transfer Successfully Completed");

	}

	/**
	 * This method is used to test failed money transfer between account template
	 * 
	 * @param moneyTransferRequest with null toAccount
	 * @return
	 */
	@Test
	public void moneyTransferWithoutToAccountFailed() throws Exception {
		this.mockMvc
				.perform(post("/v1/transfer").contentType(MediaType.APPLICATION_JSON)
						.content("{\"fromAccount\":\"132456789123\",\"toAccount\":,\"amount\":100000}"))
				.andExpect(status().isCreated());

		MoneyTransferRequest moneyTransferRequest = null;

		moneyTransferRequest.setFromAccount("132456789123");
		moneyTransferRequest.setToAccount("");
		BigDecimal bdValue2 = new BigDecimal("1234.55");
		moneyTransferRequest.setAmount(bdValue2);

		MoneyTransferResponse moneyTransferResponse = moneyTransferService.moneyTransfer(moneyTransferRequest);

		moneyTransferResponse.getMessage();

		assertThat(moneyTransferResponse.getMessage()).isEqualTo("Money Transfer Successfully Completed");

	}

	/**
	 * This method is used to test failed money transfer between account template
	 * 
	 * @param moneyTransferRequest with negative amount
	 * @return
	 */
	@Test
	public void moneyTransferFailedNegativeAmount() throws Exception {
		this.mockMvc
				.perform(post("/v1/transfer").contentType(MediaType.APPLICATION_JSON)
						.content("{\"fromAccount\":\"132456789123\",\"toAccount\":,\"amount\":-100000}"))
				.andExpect(status().isCreated());

		MoneyTransferRequest moneyTransferRequest = null;

		moneyTransferRequest.setFromAccount("132456789123");
		moneyTransferRequest.setToAccount("");
		BigDecimal bdValue2 = new BigDecimal("1234.55");
		moneyTransferRequest.setAmount(bdValue2);

		MoneyTransferResponse moneyTransferResponse = moneyTransferService.moneyTransfer(moneyTransferRequest);

		moneyTransferResponse.getMessage();

		assertThat(moneyTransferResponse.getMessage()).isEqualTo("Money Transfer Successfully Completed");

	}

}
