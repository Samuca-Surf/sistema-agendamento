package com.samuel.sistema_agendamento.estoque.repository;

import com.samuel.sistema_agendamento.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto removeProdutoById(Long id);
}
