package com.mp2.controller;

import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.mp2.model.Evento;
import com.mp2.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    public EventoController() throws MPException, MPApiException {
    }

    @GetMapping("/eventos")
    @ResponseBody
    public List<Evento> eventos(){
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


    @GetMapping("/generarPreference")
    public Map<String, Object> generarPreference(@RequestParam(name = "nonce")String nonce
    , @RequestParam(name= "precio")BigDecimal precio)
    {

            System.out.println(precio);
        try {
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title("Entrada ")
                    .quantity(1)
                    .currencyId("ARS")
                    .unitPrice(precio)
                    .build();

            System.out.println("okay");


            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(item);
            PreferenceRequest request = PreferenceRequest.builder().items(items).build();
            PreferenceClient client = new PreferenceClient();
            System.out.println("okay" + client.toString());
            Preference preference = client.create(request);
            System.out.println( preference.toString());
            System.out.println("okay");



            Map<String, Object> response = new HashMap<>();
            response.put("preferenceId", preference.getId());
            System.out.println(response);
            return response;
        } catch (MPApiException apiException){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error en MercadoPago");
            errorResponse.put("message",  apiException);
            return errorResponse;
        } catch (MPException mpException){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error en Mercado Pago");
            errorResponse.put("message", mpException);
            return errorResponse;
        }
    }


}
