package com.samuel.sistema_agendamento.agendamento.repository;

import com.samuel.sistema_agendamento.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByDataHora(LocalDateTime dataHora);

}
