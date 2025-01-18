package com.yuiko.genocide_soap.api

import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import yuiko.soa.Currency
import yuiko.soa.Country
import yuiko.soa.GetCountryRequest
import yuiko.soa.GetCountryResponse

@Endpoint
class ExampleEndpoint {

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    fun getCountry(
        @RequestPayload request: GetCountryRequest,
    ): GetCountryResponse {
        val response = GetCountryResponse()
        val country = Country()
        country.name = request.name
        country.capital = "mock"
        country.population = 123
        country.currency = Currency.EUR
        response.country = country
        return response
    }
}