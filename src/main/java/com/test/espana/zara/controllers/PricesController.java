package com.test.espana.zara.controllers;

import com.test.espana.zara.dto.PricesDTO;
import com.test.espana.zara.services.PriceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class PricesController {

    private final PriceService priceService;

    /**
     * Metodo que obtiene la lista completa de precios
     *
     * @return List Price
     */
    @GetMapping("/getPrices")
    public ResponseEntity<List<PricesDTO>> getPrices() {
        log.info("Call getPrice()");
        List<PricesDTO> list = priceService.getPrices();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Metodo que obtiene la lista filtrada de precios dado
     * los parametros de entrada
     *
     * @param entryDate
     * @param productId
     * @param brandId
     * @return
     */
    @GetMapping("/getPricesWithFilter")
    public ResponseEntity<List<PricesDTO>> getPricesWithFilter(
            @RequestParam("entryDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime entryDate,
            @RequestParam int productId,
            @RequestParam int brandId
    ) {
        log.info("Call getPricesWithFilter()");
        List<PricesDTO> list = priceService.getPricesWithFilter(entryDate, productId, brandId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
