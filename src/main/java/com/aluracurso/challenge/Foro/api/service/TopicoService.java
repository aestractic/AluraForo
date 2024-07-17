package com.aluracurso.challenge.Foro.api.service;

import com.aluracurso.challenge.Foro.api.model.Topico;
import com.aluracurso.challenge.Foro.api.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    public Topico crearTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}

