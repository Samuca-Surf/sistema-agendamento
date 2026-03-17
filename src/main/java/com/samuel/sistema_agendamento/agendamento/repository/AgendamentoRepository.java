package com.samuel.sistema_agendamento.agendamento.repository;

import com.samuel.sistema_agendamento.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
