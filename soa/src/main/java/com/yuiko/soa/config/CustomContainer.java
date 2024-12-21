package com.yuiko.soa.config;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

//@Component
public class CustomContainer implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {

    @Override
    public void customize(JettyServletWebServerFactory factory) {
        factory.setPort(8080);
        factory.setContextPath("/myapp");
        // Add any additional Jetty configurations if needed
    }
}
