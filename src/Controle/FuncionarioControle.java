/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.FuncionarioModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author silva
 */
public class FuncionarioControle {
    
     Connection conexao = null;
    
    public ArrayList<FuncionarioModelo> getListaFuncionarios() {
        ArrayList<FuncionarioModelo> listaFuncionarios = new ArrayList<FuncionarioModelo>();
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(
                    " SELECT * " +
                    " FROM funcionario " +
                    " ORDER BY id_funcionario "
            );
            // Incluindo alunos na listaFuncionarios que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    FuncionarioModelo funcionario = new FuncionarioModelo(
                            Boolean.FALSE,
                            rs.getInt("id_funcionario"),
                            rs.getInt("id_empresa"),
                            rs.getString("nome"),
                            rs.getString("CPF"),
                            rs.getString("CEP"),
                            rs.getString("email"),
                            rs.getString("telefone"),
                            rs.getString("logradouro"),
                            rs.getString("bairro"),
                            rs.getInt("numero"),
                            rs.getString("cidade"),
                            rs.getString("estado"),
                            rs.getString("cargo"),
                            rs.getString("chapa"),
                            rs.getFloat("salario")
                    );
                    listaFuncionarios.add(funcionario);
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
        
        return listaFuncionarios;
    } // final do metodo
    
}
