package com.samuel.sistema_agendamento.estoque.service;

import com.samuel.sistema_agendamento.estoque.model.Produto;
import com.samuel.sistema_agendamento.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    //cadastrar produto, nome, preco, quantidade
    //retirar produto
    //
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //salvar
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    //deletar por id
    public void deletar(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoRepository.deleteById(id);
    }

    //diminuir quantidade do produto
    public Produto diminuirProdutoQuantidade(Long id, Integer quantidade){
        Produto pro = produtoRepository.findById(id).orElse(null);

        if (pro == null){
            throw new RuntimeException("Produto não encontrado");
        }

        if (pro.getQuantidade() >= quantidade){
            pro.setQuantidade(pro.getQuantidade() - quantidade);
            return produtoRepository.save(pro);
        }else {
            throw new RuntimeException("Não é possivel alterar a quantidade");
        }
    }

    //listarTudo
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto listarProdutoPorID(Long id){
        Produto produto = produtoRepository.findById(id).orElse(null);

        if(produto == null){
            throw new RuntimeException("ID do produto não encontrado");
        }else {
            return produto;
        }
    }

    public List<Produto> listarPorNome(String nome){
        List<Produto> produtos = produtoRepository.findByNomeContainingIgnoreCase(nome);
        if (produtos.isEmpty()){
            throw new RuntimeException("Produto nao encontrado com este nome");
        }else {
            return produtos;
        }
    }

    //alert

}
