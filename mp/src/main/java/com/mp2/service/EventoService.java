package com.mp2.service;

import com.mp2.model.Evento;
import com.mp2.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
