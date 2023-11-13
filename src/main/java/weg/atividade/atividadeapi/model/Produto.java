package weg.atividade.atividadeapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nome;
    private Long preco;
    private Integer qtdEstoque;
    private String descricao;
    private String dataDeValidade;
    private Long codigoDeBarras;
    private Long peso;
    private Double medida;
    private String fabricante;
    private String categoria;

}
