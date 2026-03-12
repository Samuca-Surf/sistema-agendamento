package com.samuel.sistema_agendamento.service;

import com.samuel.sistema_agendamento.model.Usuario;
import com.samuel.sistema_agendamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private String criptografarSenha(String senha){
        return new BCryptPasswordEncoder().encode(senha);
    }

    private Boolean validarSenha(String senhaDigitada, String senhaCriptografada){
        return new BCryptPasswordEncoder().matches(senhaDigitada, senhaCriptografada);
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
        return usuario;

    }

    //atualizar dados usuario
    public Usuario atualizarUsuario(Long id, Usuario dadosAtualizado){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        //novo nome
        usuario.setNome(dadosAtualizado.getNome());
        //novo email
        usuario.setEmail(dadosAtualizado.getEmail());
        //novo num
        usuario.setTelefone(dadosAtualizado.getTelefone());
        //nova senha
        if (dadosAtualizado.getSenha() != null){
            usuario.setSenha(dadosAtualizado.getSenha());
        }
        return usuarioRepository.save(usuario);
    }

    //deletar usuario
    public void deletarUsuario(Long id, Usuario usuario){
        Usuario user = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(user);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    //listar usuarios

}
