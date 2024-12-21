package com.yuiko.genocide.ejb.service;

public interface RemoteWebClientService {
    Integer killByCityId(long id);

    Integer deportFromCityToAnother(long fromCityId, long toCityId);
}
