package com.samuel.sistema_agendamento.estoque.controller;

import com.samuel.sistema_agendamento.estoque.model.Produto;
import com.samuel.sistema_agendamento.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar(@RequestParam(required = false) String nome){
        if (nome != null){
            return service.listarPorNome(nome);
        }
        else
        {
            return service.listar();
        }
    }

    @GetMapping("/{id}")
    public Produto listarPorId(@PathVariable Long id){
        return service.listarProdutoPorID(id);
    }

    @PostMapping
    public Produto criarPeroduto(@RequestBody @Valid Produto produto){
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@PathVariable Long id ,@RequestBody @Valid Produto produto){
        produto.setId(id);
        return service.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        service.deletar(id);
    }


}
