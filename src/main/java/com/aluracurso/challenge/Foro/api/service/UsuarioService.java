package com.aluracurso.challenge.Foro.api.service;

import com.aluracurso.challenge.Foro.api.model.Usuario;
import com.aluracurso.challenge.Foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre de usuario: " + username);
        }
        return new User(usuario.get().getUsername(), usuario.get().getPassword(), Collections.emptyList());
    }

    public Usuario save(Usuario usuario) {
        usuario.setPassword(bcryptEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }
}
