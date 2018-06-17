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
    private int idFornecedor;
    private String nome;
    private int quantidadeMin;
    private int quantidadeEstoq;
    private String categoria;
    private String marca;
    private float precoCompra;
    private float precoVenda;
    private String codigoBarra;
    private String descricao;

    // Construtor para lista
    public ProdutoModelo(
            Boolean FALSE,
            int idProduto,
            int idFornecedor,
            String nome,
            int quantidadeMin,
            int quantidadeEstoq,
            String categoria,
            String marca,
            float precoCompra,
            float precoVenda
    ) {
        this.idProduto       = idProduto;
        this.idFornecedor    = idFornecedor;
        this.nome            = nome;
        this.quantidadeMin   = quantidadeMin;
        this.quantidadeEstoq = quantidadeEstoq;
        this.categoria       = categoria;
        this.marca           = marca;
        this.precoCompra     = precoCompra;
        this.precoVenda      = precoVenda;
    }

    // Construtor para obter Produto
    public ProdutoModelo(
            int idProduto,
            String nome,
            String codigoBarra,
            String descricao,
            String marca,
            String categoria,
            int idFornecedor,
            int quantidadeMin,
            int quantidadeEstoq,
            float precoCompra,
            float precoVenda
    ) {
        this.idProduto       = idProduto;
        this.nome            = nome;
        this.codigoBarra     = codigoBarra;
        this.descricao       = descricao;
        this.marca           = marca;
        this.categoria       = categoria;
        this.idFornecedor    = idFornecedor;
        this.quantidadeMin   = quantidadeMin;
        this.quantidadeEstoq = quantidadeEstoq;
        this.precoCompra     = precoCompra;
        this.precoVenda      = precoVenda;
    }
    
    public ProdutoModelo() {}

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
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

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
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
