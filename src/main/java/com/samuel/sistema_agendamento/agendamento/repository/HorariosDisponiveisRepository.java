package com.samuel.sistema_agendamento.agendamento.repository;

import com.samuel.sistema_agendamento.agendamento.model.HorariosDisponiveis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface HorariosDisponiveisRepository extends JpaRepository<HorariosDisponiveis, Long> {
    List<HorariosDisponiveis> findByDiaDaSemana(DayOfWeek diaDaSemana);
}
