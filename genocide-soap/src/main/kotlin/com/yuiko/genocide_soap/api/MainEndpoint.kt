package com.yuiko.genocide_soap.api

import com.yuiko.genocide_soap.service.RemoteWebClientService
import org.springframework.ws.server.endpoint.annotation.Endpoint
import org.springframework.ws.server.endpoint.annotation.PayloadRoot
import org.springframework.ws.server.endpoint.annotation.RequestPayload
import org.springframework.ws.server.endpoint.annotation.ResponsePayload
import yuiko.soa.DeportRequest
import yuiko.soa.DeportResponse
import yuiko.soa.KillRequest
import yuiko.soa.KillResponse
import yuiko.soa.PingRequest
import yuiko.soa.PingResponse

const val NAMESPACE_URI: String = "http://yuiko/soa"

@Endpoint
class MainEndpoint(
    private val remoteWebClientService: RemoteWebClientService
) {

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "pingRequest")
    @ResponsePayload
    fun ping(
        @RequestPayload pingRequest: PingRequest
    ): PingResponse {
        val response = PingResponse()
        response.result = "PONG"
        return response
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deportRequest")
    @ResponsePayload
    fun deport(
        @RequestPayload deportRequest: DeportRequest,
    ): DeportResponse {
        remoteWebClientService.deportFromCityToAnother(deportRequest.idFrom, deportRequest.idTo)
        val response = DeportResponse()
        response.result = "OK"
        response.deported = deportRequest.idFrom
        return response
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "killRequest")
    @ResponsePayload
    fun kill(
        @RequestPayload killRequest: KillRequest,
    ): KillResponse {
        remoteWebClientService.killByCityId(killRequest.id)
        val response = KillResponse()
        response.result = "OK"
        response.killed = killRequest.id
        return response
    }
}