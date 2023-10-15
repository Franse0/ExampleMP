package com.example.demo.controller;

import com.example.demo.model.Evento;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.IEventoService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    public EventoController() throws MPException, MPApiException {
    }

    @GetMapping("/eventos")
    @ResponseBody
    public List<Evento>eventos(){
        return eventoService.eventos();
    }

    @GetMapping("/eventos/{id}")
    @ResponseBody
    public Optional<Evento> evento(@PathVariable Long id){
        return eventoService.verEvento(id);
    }

    @PostMapping("/evento/nuevo")
    public void aventoNuevo(@RequestBody Evento evento){
        eventoService.nuevoEvento(evento);
    }


    @DeleteMapping("/evento/borrar/{id}")
    public void eventoBorrar(@PathVariable Long id){
        eventoService.borrarEvento(id);
    }


 PreferenceItemRequest item = PreferenceItemRequest.builder()
         .title("Entrada para el evento, o lo que sea")
                .quantity(1)
                .currencyId("ARS")
                .unitPrice(new BigDecimal("500.0"))
            .build();

    List<PreferenceItemRequest> items = new ArrayList<>();
        items.add(item);

    PreferenceRequest request = PreferenceRequest.builder().items(items).build();
    PreferenceClient client = new PreferenceClient();
    Preference preference = client.create(request);

    // En el objeto donde devuelves el json
        eventoDTO.setPreferenceId(preference.getId());



}