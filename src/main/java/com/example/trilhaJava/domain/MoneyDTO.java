package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;

import java.util.Map;

@Getter
@Data
public class MoneyDTO {
    private String base;
    private String date;
    private Map<String, Double> rates;

    // Getters e Setters
    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
