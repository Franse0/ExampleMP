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
        MercadoPagoConfig.setAccessToken("TEST-7afb9f9d-e8e9-46f2-b369-274a8388eaa1");
    }
}
