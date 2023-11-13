package weg.atividade.atividadeapi.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weg.atividade.atividadeapi.model.Produto;
import weg.atividade.atividadeapi.service.ProdutoService;

import java.util.Collection;
import java.util.NoSuchElementException;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProdutoController {

    private ProdutoService produtoService ;

    @GetMapping("/GET/{id}")
    public Produto get(@PathVariable (value = "id")Long id){
        return produtoService.get(id);
    }
    @GetMapping("/GET")
    public Collection<Produto> get() {
        return produtoService.get();
    }

    @PostMapping("/POST")
    public ResponseEntity<Produto> post(@RequestBody Produto produto){
        try {
            produtoService.get(produto.getId());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
            //NoSuchElementException é para quando já haver um id porém não está cadastrado no banco de dados
        } catch (NoSuchElementException | InvalidDataAccessApiUsageException e) {
//        } catch (NoSuchElementException | InvalidDataAccessApiUsageException e) {
            try {
                produtoService.post(produto);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception exception) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }   catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/PUT")
    public ResponseEntity<Produto> put(@RequestBody Produto produto){
        try{
            produtoService.put(produto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<Produto> delete (@RequestParam (value = "id") Long id){
        try {
            produtoService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
