package com.samuel.sistema_agendamento.estoque.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

@Entity
@Getter
@Setter
@Table(name = "tbproduto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome nao pode ser vazio")
    private String nome;

    @NotNull(message = "O de preco nao pode ser vazio")
    @Positive(message = "O valor deve ser positivo")
    private Double preco;

    @NotNull(message = "A quantidade nao pode ser vazio")
    @PositiveOrZero(message = "O valor deve ser positivo ou 0")
    private Integer quantidade;

    public Produto() {
    }
}
