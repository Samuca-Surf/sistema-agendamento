package com.samuel.sistema_agendamento.agendamento.service;

import com.samuel.sistema_agendamento.agendamento.model.HorariosDisponiveis;
import com.samuel.sistema_agendamento.agendamento.repository.HorariosDisponiveisRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class HorariosDisponveisService {
    private final HorariosDisponiveisRepository repository;

    public HorariosDisponveisService(HorariosDisponiveisRepository repository) {
        this.repository = repository;
    }

    public HorariosDisponiveis salvar(HorariosDisponiveis horariosDisponiveis){
        return repository.save(horariosDisponiveis);
    }

    public List<HorariosDisponiveis> getHorariosPorDia(DayOfWeek dia){
        return repository.findByDiaDaSemana(dia);
    }

}
