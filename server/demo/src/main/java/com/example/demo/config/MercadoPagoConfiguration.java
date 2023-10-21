package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import com.mercadopago.MercadoPagoConfig;

@Component
@Configuration
public class MercadoPagoConfiguration {
    @PostConstruct
    public void init(){
        MercadoPagoConfig.setAccessToken("TEST-8105087166130054-101704-f50b494164216aeffd8e6b2385eeb8f1-519910139");
    }
}
