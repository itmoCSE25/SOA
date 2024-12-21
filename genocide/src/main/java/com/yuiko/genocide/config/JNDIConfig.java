package com.yuiko.genocide.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;

import com.yuiko.genocide.ejb.service.RemoteWebClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

import static javax.naming.Context.PROVIDER_URL;

@Configuration
public class JNDIConfig {

    @Bean
    public JndiTemplate jndiTemplate() {
        Properties params = new Properties();
//        params.put(PROVIDER_URL, "remote://localhost:8085");
        return new JndiTemplate(params);
    }

    @Bean
    public RemoteWebClientService remoteWebClientService() throws NamingException {
        String path = "ejb:/%s/%s!%s".formatted(
                "genocide-ejb", "RemoteWebClientService",
                RemoteWebClientService.class.getName()
        );
//        ejb:/genocide-ejb/RemoteWebClientService!org.yuiko.genocide.service.RemoteWebClientService
        return jndiTemplate().lookup(path, RemoteWebClientService.class);
    }
}