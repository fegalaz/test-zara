package com.test.espana.zara.services

import com.test.espana.zara.repository.PricesRepository
import com.test.espana.zara.repository.entity.Prices
import spock.lang.Specification

import java.time.LocalDateTime

class PricesServiceTest extends Specification {

    PricesRepository pricesRepository = Mock()
    PriceService priceService = Mock()

    def "getPrices() : Returns empty data"(){
        when:
        priceService.getPrices()

        then:
        0 * pricesRepository.findAll {} >> Optional.empty() >> {throw new Exception()}
    }

    def "getPricesWithFilter() : Returns empty data"(){
        given:
        def dt = LocalDateTime.now()
        def brandId = 1
        def productId = 35455

        when:
        priceService.getPricesWithFilter(dt,productId,brandId)

        then:
        0 * pricesRepository.findByProductIdAndBrandId(_,_) {} >> Optional.empty() >> {throw new Exception()}
    }
}
