package com.example.demo.service;

import com.example.demo.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EventoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService implements IEventoService{

    @Autowired
    private EventoRepository eventoRepository;
    @Override
    public void nuevoEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public Optional<Evento> verEvento(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public List<Evento> eventos() {
        return eventoRepository.findAll();
    }

    @Override
    public void borrarEvento(Long id) {
        eventoRepository.deleteById(id);
    }
}
