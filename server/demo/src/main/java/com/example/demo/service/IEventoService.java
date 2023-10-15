package com.example.demo.service;

import com.example.demo.model.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoService {
    public void nuevoEvento(Evento evento);
    public Optional<Evento> verEvento(Long id);
    public List<Evento> eventos();
    public void borrarEvento(Long id);
}
