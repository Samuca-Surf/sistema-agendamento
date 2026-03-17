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


    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public void removerProdutoCompletoPorId(Long id){
        produtoRepository.deleteById(id);
    }

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

    public List<Produto> listarTodosProduto(){
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

    //modificar nome, referencia = id
    public Produto modificarNomeProduto(Long id, String novoNome){
        Produto produto = produtoRepository.findById(id).orElse(null);

        if(produto == null){
            throw new RuntimeException("ID do produto não encontrado");
        }else{
           produto.setNome(novoNome);
            return produto;
        }

    }

    //modificar preco, referecia = id
    public Produto modificarPrecoProduto(Long id, Double novoPreco){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto == null){
            throw new RuntimeException("ID do produto não encontrado");
        }
        produto.setPreco(novoPreco);
        return produto;
    }

    //aumentar quantidade, referencia = id
    public Produto aumentarProdutoQuantidade(Long id, Integer quantidade){
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto==null){
            throw new RuntimeException("ID de produto não encontrado");
        }else {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            return produto;
        }

    }

}
