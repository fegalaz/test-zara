package com.inditex.zara.application.services.impl;

import com.inditex.zara.application.services.PriceService;
import com.inditex.zara.domain.exceptions.PriceNotFoundException;
import com.inditex.zara.domain.model.Price;
import com.inditex.zara.domain.ports.in.PriceInputPort;
import com.inditex.zara.domain.services.PriceDomainService;
import com.inditex.zara.domain.ports.out.PriceOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService, PriceInputPort {

    private final PriceOutputPort priceOutputPort;
    private final PriceDomainService priceDomainService;

    @Override
    public Price getFinalPrice(LocalDateTime date, Long productId, Integer brandId) {
        return priceOutputPort.findFinalPrice(brandId, productId, date)
                .orElseThrow(() -> new PriceNotFoundException("Price not found for the given criteria"));
    }

    @Override
    public Price getFinalPriceWithConvention(LocalDateTime date, Long productId, Integer brandId) {
        List<Price> applicablePrices = priceOutputPort.findFinalPriceWithConvention(brandId, productId, date);

        return priceDomainService.selectHighestPriorityPrice(applicablePrices);
    }

    @Override
    public List<Price> getPricesListAll() {
        return priceOutputPort.findAll();
    }
}
