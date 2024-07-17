package com.aluracurso.challenge.Foro.api.controller;

import com.aluracurso.challenge.Foro.api.model.Topico;
import com.aluracurso.challenge.Foro.api.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listarTopicos() {
        return topicoService.listarTopicos();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public Topico crearTopico(@RequestBody Topico topico) {
        return topicoService.crearTopico(topico);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}

