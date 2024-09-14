package com.yuiko.soa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springdoc.core.models.GroupedOpenApi;

//@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi cityApi() {
        return GroupedOpenApi.builder()
                .group("city")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public GroupedOpenApi genocideApi() {
        return GroupedOpenApi.builder()
                .group("genocide")
                .pathsToMatch("/genocide/**")
                .build();
    }
}
