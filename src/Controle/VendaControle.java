/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.VendaModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author silva
 */
public class VendaControle {
    
     Connection conexao = null;
    
    public ArrayList<VendaModelo> getListaVendas() {
        ArrayList<VendaModelo> listaVendas = new ArrayList<VendaModelo>();
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(
                    " SELECT * " +
                    " FROM venda " +
                    " ORDER BY id_venda "
            );
            // Incluindo alunos na listaVendas que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    VendaModelo venda = new VendaModelo(
                            Boolean.FALSE,
                            rs.getInt("id_venda"),
                            rs.getInt("id_cliente"),
                            rs.getInt("id_funcionario"),
                            rs.getFloat("total"),
                            rs.getString("data_venda")
                    );
                    listaVendas.add(venda);
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
        
        return listaVendas ;
    } // final do metodo
    
}
