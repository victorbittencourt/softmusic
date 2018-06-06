/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ProdutoModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author silva
 */
public class ProdutoControle {
    
    Connection conexao = null;
    
    public ArrayList<ProdutoModelo> getListaProdutos() {
        ArrayList<ProdutoModelo> listaProdutos = new ArrayList<ProdutoModelo>();
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(
                    " SELECT * " +
                    " FROM produto " +
                    " ORDER BY id_produto "
            );
            // Incluindo alunos na listaProdutos que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    ProdutoModelo produto = new ProdutoModelo(
                            Boolean.FALSE,
                            rs.getInt("id_produto"),
                            rs.getString("nome"),
                            rs.getInt("quantidadeMin"),
                            rs.getInt("quantidadeEstoq"),
                            rs.getString("categoria"),
                            rs.getString("marca"),
                            rs.getFloat("preco"),
                            rs.getString("codigo_de_barra"),
                            rs.getString("descricao")
                    );
                    listaProdutos.add(produto);
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
        
        return listaProdutos;
    } // final do metodo
    
}
