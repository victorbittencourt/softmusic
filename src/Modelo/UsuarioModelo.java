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
public class UsuarioModelo {
    private int idFuncionario;
    private String login;
    private String senha;

    public UsuarioModelo(
            Boolean FALSE,
            int idFuncionario,
            String login,
            String senha
    ) {
        this.idFuncionario = idFuncionario;
        this.login         = login;
        this.senha         = senha;
    }

    public UsuarioModelo(int
           idFuncionario,
           String login,
           String senha
    ) {
        this.idFuncionario = idFuncionario;
        this.login         = login;
        this.senha         = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
