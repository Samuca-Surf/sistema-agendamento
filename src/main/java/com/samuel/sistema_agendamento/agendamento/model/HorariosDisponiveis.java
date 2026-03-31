package com.samuel.sistema_agendamento.agendamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
public class HorariosDisponiveis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DayOfWeek diaDaSemana;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private int duracaoServico;

}
