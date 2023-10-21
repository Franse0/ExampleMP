package com.mp2.config;

import com.mercadopago.MercadoPagoConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MercadoPagoConfiguration {
    @PostConstruct
    public void init(){
        MercadoPagoConfig.setAccessToken("");
    }
}
