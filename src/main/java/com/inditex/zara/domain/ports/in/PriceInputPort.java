package com.inditex.zara.domain.ports.in;

import com.inditex.zara.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceInputPort {

    Price getFinalPrice(LocalDateTime date, Long productId, Integer brandId);

    Price getFinalPriceWithConvention(LocalDateTime date, Long productId, Integer brandId);

    List<Price> getPricesListAll();
}