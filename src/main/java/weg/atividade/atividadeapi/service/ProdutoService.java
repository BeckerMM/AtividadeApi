package weg.atividade.atividadeapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import weg.atividade.atividadeapi.model.Produto;
import weg.atividade.atividadeapi.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public Produto get(Long id){
        Optional<Produto> produtos = produtoRepository.findById(id);
        return produtos.get();
    }

    public List<Produto> get() {
        return produtoRepository.findAll();
    }

    public void post(Produto produto){
        produtoRepository.save(produto);
    }

    public void put(Produto produto){
        if (produto.getId()!=null){
            if (produtoRepository.findById(produto.getId()).isPresent()){
                produtoRepository.save(produto);
            }
        }
    }

    public void delete (Long id){
        produtoRepository.deleteById(id);
    }
}
