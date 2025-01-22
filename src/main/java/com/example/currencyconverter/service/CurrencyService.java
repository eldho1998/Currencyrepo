package com.example.currencyconverter.service;

public interface CurrencyService {

	double getExchangeRate(String fromCurrency, String toCurrency);

	double convertCurrency(double amount, double exchangeRate);
}
