package com.test.espana.zara.controllers

import com.test.espana.zara.services.PriceService
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class PricesControllerTest extends Specification {

    PriceService priceService = Mock()
    PricesController controller = new PricesController(priceService)
    MockMvc mvc = standaloneSetup(controller).build()

    def "GetPricesWithFilter : Param success request"() {

        when:
        def response = mvc.perform(
                get("/api/v1/getPricesWithFilter?entryDate=2020-06-16T21:00:00.000&productId=35455&brandId=1"))

        then:
        1 * priceService.getPricesWithFilter(_,_,_)
        response.andExpect(status().is2xxSuccessful())
    }

    def "GetPricesWithFilter : Param missed request"() {

        when:
        def response = mvc.perform(
                get("/api/v1/getPricesWithFilter?entryDate=2020-06-16T21:00:00.000&productId=35455"))

        then:
        0 * priceService.getPricesWithFilter(_,_)
        response.andExpect(status().isBadRequest())
    }


    def "GetPrices: Param success request"() {

        when:
        def response = mvc.perform(
                get("/api/v1/getPrices"))

        then:
        1 * priceService.getPrices()
        response.andExpect(status().is2xxSuccessful())
    }
}
