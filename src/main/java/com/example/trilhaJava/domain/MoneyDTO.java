package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Data
@Setter
public class MoneyDTO {
    private String base;
    private String date;
    private Map<String, Double> rates;

}
