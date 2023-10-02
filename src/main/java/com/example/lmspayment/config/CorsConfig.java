package com.example.lmspayment.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("http://localhost:5173"); // Herhangi bir kaynaktan isteklere izin vermek için "*"
//        config.addAllowedHeader("*"); // Tüm başlıklara izin vermek için "*"
//        config.addAllowedMethod("POST"); // Tüm HTTP metodlarına izin vermek için "*"
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // İstemcilere izin vermek istediğiniz kaynakları burada ekleyin (örneğin, http://localhost:5173)
        config.addAllowedOrigin("http://localhost:5173");

        // Hangi HTTP yöntemlerine izin verileceğini belirtin (örneğin, GET, POST, PUT, DELETE)
        config.addAllowedMethod("*");

        // Hangi başlıkların isteklere eklenmesine izin verileceğini belirtin (örneğin, Authorization)
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
