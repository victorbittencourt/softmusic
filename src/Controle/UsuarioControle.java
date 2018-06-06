/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.UsuarioModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.security.*;
import java.math.*;

/**
 *
 * @author silva
 */
public class UsuarioControle {
    
    Connection conexao = null;
    
    public UsuarioModelo login(String login, String senha) throws NoSuchAlgorithmException {
        System.out.println("login Usuario");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM USUARIO WHERE login = '" + login + "';";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               UsuarioModelo usuario = new UsuarioModelo(
                       rs.getInt("id_funcionario"),
                       rs.getString("login"),
                       rs.getString("senha")
               );
               
               // Criptografa a senha
               String senhaCrypt = senha;
               
               // Aplica Hash MD5
               MessageDigest m =MessageDigest.getInstance("MD5");
               m.update(senha.getBytes(),0,senha.length());
               
               // Obtem senha criptografada
               senhaCrypt = new BigInteger(1,m.digest()).toString(16);

               // Realiza comparação entre login e senha (criptografa) obtidos pelo form
               // com login e senha (criptografada) do BD
               if (login.equals(usuario.getLogin()) && senhaCrypt.equals(usuario.getSenha())) {
                    return usuario;    
               }
               
               return null;
            }
            else
            {
               return null;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            // este bloco finally sempre executa na instrução try para
            // fechar a conexão a cada conexão aberta
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
    }
    
    public ArrayList<UsuarioModelo> getListaUsuarios() {
        ArrayList<UsuarioModelo> listaUsuarios = new ArrayList<UsuarioModelo>();
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(
                    " SELECT * " +
                    " FROM usuario " +
                    " ORDER BY id_funcionario "
            );
            // Incluindo alunos na listaUsuarios que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    UsuarioModelo usuario = new UsuarioModelo(
                            Boolean.FALSE,
                            rs.getInt("id_funcionario"),
                            rs.getString("login"),
                            rs.getString("senha")
                            
                    );
                    listaUsuarios.add(usuario);
                }
            }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (Exception er) {
            System.out.println(er.getMessage());
            return null;
        }finally {
          
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar" + e.getMessage());
            }
        }
        
        return listaUsuarios;
    } // final do metodo
    
}
