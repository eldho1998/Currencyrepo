package com.example.currencyconverter.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.currencyconverter.utils.ExternalApi;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	private final ExternalApi apiClient;

	public CurrencyServiceImpl(ExternalApi apiClient) {
		this.apiClient = apiClient;
	}

	private void validateCurrencyCode(String currencyCode) {

		if (currencyCode == null || currencyCode.trim().isEmpty())
			throw new IllegalArgumentException("currency code cannot be null or empty!");

		String cleanedCode = currencyCode.trim().toUpperCase();

		if (!ALLOWED_CURRENCIES.contains(cleanedCode))
			throw new IllegalArgumentException("invalid currency code!");
	}

	@Override
	public double getExchangeRate(String fromCurrency, String toCurrency) {
		validateCurrencyCode(toCurrency);
		validateCurrencyCode(fromCurrency);
		return apiClient.fetchExchangeRate(fromCurrency, toCurrency);
	}

	@Override
	public double convertCurrency(double amount, double exchangeRate) {
		if (amount <= 0) {
			throw new IllegalArgumentException("enter a valid amount!");
		}
		return amount * exchangeRate;
	}

	private static final Set<String> ALLOWED_CURRENCIES = Set.of("AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG",
			"AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP",
			"BYN", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNH", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK",
			"DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP",
			"GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR",
			"ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK",
			"LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR",
			"MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP",
			"PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
			"SLL", "SOS", "SRD", "SSP", "STD", "STN", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY",
			"TTD", "TWD", "ZWL", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XAG",
			"XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMW");

}
