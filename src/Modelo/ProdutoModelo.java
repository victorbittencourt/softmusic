/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author silva
 */
public class ProdutoModelo {
    private int idProduto;
    private String nome;
    private int quantidadeMin;
    private int quantidadeEstoq;
    private String categoria;
    private String marca;
    private float preco;
    private String codigoBarra;
    private String descricao;

    public ProdutoModelo(
            Boolean FALSE,
            int idProduto,
            String nome,
            int quantidadeMin,
            int quantidadeEstoq,
            String categoria,
            String marca,
            float preco,
            String codigoBarra,
            String descricao
    ) {
        this.idProduto       = idProduto;
        this.nome            = nome;
        this.quantidadeMin   = quantidadeMin;
        this.quantidadeEstoq = quantidadeEstoq;
        this.categoria       = categoria;
        this.marca           = marca;
        this.preco           = preco;
        this.codigoBarra     = codigoBarra;
        this.descricao       = descricao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public int getQuantidadeEstoq() {
        return quantidadeEstoq;
    }

    public void setQuantidadeEstoq(int quantidadeEstoq) {
        this.quantidadeEstoq = quantidadeEstoq;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
