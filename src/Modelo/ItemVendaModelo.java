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
public class ItemVendaModelo {
    private int idItemVenda;
    private int idProduto;
    private int idVenda;
    private int quantidade;
    private float subTotal;

    public ItemVendaModelo(
            Boolean FALSE,
            int idItemVenda,
            int idProduto,
            int idVenda,
            int quantidade,
            float subTotal
    ) {
        this.idItemVenda = idItemVenda;
        this.idProduto   = idProduto;
        this.idVenda     = idVenda;
        this.quantidade  = quantidade;
        this.subTotal    = subTotal;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getSub_total() {
        return subTotal;
    }

    public void setSub_total(float sub_total) {
        this.subTotal = sub_total;
    }
    
    
}
