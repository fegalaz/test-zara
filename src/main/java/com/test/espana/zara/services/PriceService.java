package com.test.espana.zara.services;


import com.test.espana.zara.dto.PricesDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<PricesDTO> getPricesWithFilter(LocalDateTime entryDate, int productId, int branchId);
    List<PricesDTO> getPrices();
}
