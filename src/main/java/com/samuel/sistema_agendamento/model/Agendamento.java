package com.samuel.sistema_agendamento.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Agendamento {
    //id PK
    //usuraio_id FK
    //data_hora
    //status
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDateTime data_horario;
    private Status status;

    public Agendamento() {}

    //nao usar construtor com atributos no JPA
}
