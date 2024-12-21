package com.yuiko.genocide.ejb.service;

import jakarta.ejb.Remote;

@Remote
public interface RemoteWebClientService {
    Integer killByCityId(long id);

    Integer deportFromCityToAnother(long fromCityId, long toCityId);
}