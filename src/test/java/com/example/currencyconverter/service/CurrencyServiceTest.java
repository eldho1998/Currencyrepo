package com.example.currencyconverter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.currencyconverter.utils.ExternalApi;

class CurrencyServiceTest {
	private CurrencyServiceImpl currencyService;
	private ExternalApi mockApiClient;

	@BeforeEach
	void setUp() {
		mockApiClient = Mockito.mock(ExternalApi.class);
		currencyService = new CurrencyServiceImpl(mockApiClient);
	}

	@Test
	void testGetExchangeRateValidCurrencies() {
		when(mockApiClient.fetchExchangeRate("USD", "INR")).thenReturn(85.835084);

		double rate = currencyService.getExchangeRate("USD", "INR");
		assertEquals(85.835084, rate, 0.01);
		verify(mockApiClient, times(1)).fetchExchangeRate("USD", "INR");
	}

	@Test
	void testGetExchangeRateInvalidCurrency() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			currencyService.getExchangeRate("INVALID", "INR");
		});

		assertTrue(exception.getMessage().contains("invalid currency code!"));
	}

	@Test
	void testConvertCurrency() {
		double result = currencyService.convertCurrency(100, 85.835084);
		assertEquals(8583.5084, result, 0.01);
	}

	@Test
	void testConvertCurrencyNegativeAmount() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			currencyService.convertCurrency(-100, 85.835084);
		});

		assertTrue(exception.getMessage().contains("enter a valid amount!"));
	}
}
