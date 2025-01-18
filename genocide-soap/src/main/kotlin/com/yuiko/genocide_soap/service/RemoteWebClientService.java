package com.yuiko.genocide_soap.service;

public interface RemoteWebClientService {
    Integer killByCityId(long id);

    Integer deportFromCityToAnother(long fromCityId, long toCityId);
}