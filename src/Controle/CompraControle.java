/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.CompraModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author silva
 */
public class CompraControle {
    
    Connection conexao = null;
    
    public ArrayList<CompraModelo> getListaCompras() {
        ArrayList<CompraModelo> listaCompras = new ArrayList<CompraModelo>();
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(
                    " SELECT " + 
                        " id_compra, " +
                        " id_funcionario, " +
                        " id_produto, " +
                        " id_fornecedor " +
                        " quantidade " +
                        " valor " +
                        " data_compra " +
                    " FROM compra " +
                    " ORDER BY id_compra "
            );
            // Incluindo alunos na listaCCompras que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    CompraModelo compra = new CompraModelo(
                            Boolean.FALSE,
                            rs.getInt("id_compra"),
                            rs.getInt("id_funcionario"),
                            rs.getInt("id_produto"),
                            rs.getInt("id_fornecedor"),
                            rs.getInt("quantidade"),
                            rs.getFloat("valor"),
                            rs.getString("data_compra")
                    );
                    listaCompras.add(compra);
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
        
        return listaCompras;
    } // final do metodo
    
}
