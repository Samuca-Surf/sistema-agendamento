package com.samuel.sistema_agendamento.agendamento.repository;

import com.samuel.sistema_agendamento.agendamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByEmail(String email);

    boolean existsUsuarioByEmail(String email);
}
