package com.samuel.sistema_agendamento.estoque.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbestoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Produto> produto;

    private Integer minAlerta;

    public Estoque() {
    }


}
