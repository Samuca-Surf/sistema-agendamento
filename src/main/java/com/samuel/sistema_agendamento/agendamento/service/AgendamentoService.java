package com.samuel.sistema_agendamento.agendamento.service;

import com.samuel.sistema_agendamento.agendamento.model.Agendamento;
import com.samuel.sistema_agendamento.agendamento.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {
    //os dias e horarios de trabalho
    //defir horários disponiveis

    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    public boolean verificarDisponibilidade(LocalDateTime dataHora){

        List<Agendamento> agendamentos = repository.findByDataHora(dataHora);

        return agendamentos.isEmpty();
    }

    public Agendamento salvar(Agendamento agendamento){
        return repository.save(agendamento);
    }

}
