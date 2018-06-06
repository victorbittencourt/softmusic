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
public class VendaModelo {
    private int idVenda;
    private int idCliente;
    private int idFuncionario;
    private float total;
    private String dataVenda;

    public VendaModelo(
            Boolean FALSE,
            int idVenda,
            int idCliente,
            int idFuncionario,
            float total,
            String dataVenda
    ) {
        this.idVenda       = idVenda;
        this.idCliente     = idCliente;
        this.idFuncionario = idFuncionario;
        this.total         = total;
        this.dataVenda     = dataVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getData_venda() {
        return dataVenda;
    }

    public void setData_venda(String data_venda) {
        this.dataVenda = data_venda;
    }
    
    
}
