package com.inditex.zara.domain.services;

import com.inditex.zara.domain.exceptions.PriceNotFoundException;
import com.inditex.zara.domain.model.Price;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PriceDomainService {

    public Price selectHighestPriorityPrice(List<Price> prices) {
        if (prices == null || prices.isEmpty()) {
            throw new PriceNotFoundException("No prices available for selection");
        }

        return prices.stream()
                .max(Comparator.comparingInt(Price::priority))
                .orElseThrow();
    }
}