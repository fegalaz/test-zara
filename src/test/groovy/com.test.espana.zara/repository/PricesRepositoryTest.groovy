package com.test.espana.zara.repository

import com.test.espana.zara.repository.entity.Prices
import spock.lang.Specification

import java.time.LocalDateTime

class PricesRepositoryTest extends Specification{

    PricesRepository pricesRepository = Mock()

    def "Get prices from DB : The prices no exists"() {
        given:
        def productId = 35455
        def brandId = 1

        when:
        def response = pricesRepository.findByProductIdAndBrandId(productId,brandId)

        then:
        response == null
    }
}
