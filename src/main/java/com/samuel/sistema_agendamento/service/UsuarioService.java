package com.samuel.sistema_agendamento.service;

import com.samuel.sistema_agendamento.model.Usuario;
import com.samuel.sistema_agendamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private String criptografarSenha(String senha){
        return new BCryptPasswordEncoder().encode(senha);
    }


    public Usuario cadastrarUsuario(Usuario user){
        if (usuarioRepository.existsUsuarioByEmail(user.getEmail())){
            throw new IllegalArgumentException("Email já registrado!!");
        }
        user.setSenha(criptografarSenha(user.getSenha()));
        return usuarioRepository.save(user);
    }

    public Usuario autenticarUsuario(String email, String senha){
        Usuario usuario = usuarioRepository.findUsuarioByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!validarSenha(senha, usuario.getSenha())){
            throw new RuntimeException("Senha Inválida.");
        }
        
    }

}
