//package com.yuiko.soa.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
////@EnableWebSecurity
//public class WebConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedMethods("*");
//    }
//
////    @Bean
////    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        return http
////                .requiresChannel(channel ->
////                        channel.anyRequest().requiresSecure())
////                .authorizeRequests(authorize ->
////                        authorize.anyRequest().permitAll())
////                .csrf(AbstractHttpConfigurer::disable)
////                .build();
////    }
//}
