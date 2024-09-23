package com.kirana.transactions.service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class CurrencyService {

	@Cacheable("currencyRates")
    public Map<String, Double> getCurrencyRates() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.fxratesapi.com/latest";
        // Call the API and get the currency rates
        return restTemplate.getForObject(url, Map.class);
    }

    public double convert(String fromCurrency, String toCurrency, double amount, Map<String, Double> rates) {
        if (fromCurrency.equalsIgnoreCase(toCurrency)) {
            return amount;
        }
        double fromRate = rates.get(fromCurrency);
        double toRate = rates.get(toCurrency);
        return amount * (toRate / fromRate);
    }
}
