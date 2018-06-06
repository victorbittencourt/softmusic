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
public class CompraModelo {
    private int idCompra;
    private int idFuncionario;
    private int idProduto;
    private int idFornecedor;
    private int quantidade;
    private float valor;
    private String dataCompra;

    public CompraModelo(
            Boolean FALSE,
            int idCompra,
            int idFuncionario,
            int idProduto,
            int idFornecedor,
            int quantidade,
            float valor,
            String dataCompra
    ) {
        this.idCompra = idCompra;
        this.idFuncionario = idFuncionario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.dataCompra = dataCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData_compra() {
        return dataCompra;
    }

    public void setData_compra(String data_compra) {
        this.dataCompra = data_compra;
    }
}
