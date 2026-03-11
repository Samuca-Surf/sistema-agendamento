package com.samuel.sistema_agendamento.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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

    LocalDateTime data_horario;
    private Status status;

    public Agendamento() {}

    public Agendamento(Long id, Usuario usuario, LocalDateTime data_horario, Status status) {
        this.id = id;
        this.usuario = usuario;
        this.data_horario = data_horario;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getData_horario() {
        return data_horario;
    }

    public void setData_horario(LocalDateTime data_horario) {
        this.data_horario = data_horario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
