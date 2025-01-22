package com.example.currencyconverter.dao;

public interface CurrencyConverterDAO {

	double getExchangeRate(String fromCurrency, String toCurrency);
	
	double convertCurrency(double amount, double exchangeRate);
}
