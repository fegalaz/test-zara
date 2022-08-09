package com.test.espana.zara.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.WebRequest
import spock.lang.Specification

class ControllerExceptionHandlerTest extends Specification {

     WebRequest webRequest = Mock()

     ControllerExceptionHandler handler = new ControllerExceptionHandler()

     def "client connection error exception"() {
         given:
         ClientConnectionErrorException e = new ClientConnectionErrorException("client connection error exception", new Exception())

         when:
         ResponseEntity response = handler.clientConnectionErrorException(e, webRequest)

         then:
         response.statusCode == HttpStatus.INTERNAL_SERVER_ERROR
     }
 }
