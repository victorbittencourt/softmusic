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
public class ClienteModelo {
    private int idCliente;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private String cep;
    private String logradouro;
    private int numero;
    private String estado;
    private String cidade;
    private String bairro;
    private String referencia;
    private int status;
    
    public ClienteModelo(
            int idcliente,
            String nome,
            String rg,
            String cpf,
            Boolean check
    ) {
        this.idCliente = idcliente;
        this.nome      = nome;
        this.rg        = rg;
        this.cpf       = cpf;
    }

    public ClienteModelo(
            int idCliente,
            String nome,
            String rg,
            String cpf,
            String cep,
            String logradouro,
            int numero,
            String cidade,
            String estado,
            String bairro,
            String referencia,
            String email,
            String telefone
    ) {
        this.idCliente  = idCliente;
        this.nome       = nome;
        this.rg         = rg;
        this.cpf        = cpf;
        this.cep        = cep;
        this.logradouro = logradouro;
        this.numero     = numero;
        this.cidade     = cidade;
        this.estado     = estado;
        this.bairro     = bairro;
        this.referencia = referencia;
        this.email      = email;
        this.telefone   = telefone;
    }
    
    // Construtor para obterCliente2Venda
    public ClienteModelo(
        String logradouro,
        int numero,
        String cidade,
        String estado,
        String bairro,
        String referencia,
        String telefone
    ) {
        this.logradouro = logradouro;
        this.numero     = numero;
        this.cidade     = cidade;
        this.estado     = estado;
        this.cidade     = cidade;
        this.bairro     = bairro;
        this.referencia = referencia;
        this.telefone   = telefone;
    }
    
    public ClienteModelo() {}  

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
