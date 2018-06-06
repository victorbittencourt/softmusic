/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ItemVendaModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author silva
 */
public class ItemVendaControle {
    
     Connection conexao = null;
    
    public ArrayList<ItemVendaModelo> getListaItemVendas() {
        ArrayList<ItemVendaModelo> listaItemVendas = new ArrayList<ItemVendaModelo>();
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(
                    " SELECT " + 
                        " cod_itemvenda, " +
                        " cod_produto, " +
                        " cod_venda, " +
                        " quantidade " +
                    " FROM itemvenda " +
                    " ORDER BY cod_itemvenda "
            );
            // Incluindo alunos na listaItemVendas que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    ItemVendaModelo itemvenda = new ItemVendaModelo(
                            Boolean.FALSE,
                            rs.getInt("id_itemvenda"),
                            rs.getInt("id_produto"),
                            rs.getInt("id_venda"),
                            rs.getInt("quantidade"),
                            rs.getFloat("sub_total")
                    );
                    listaItemVendas.add(itemvenda);
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
        
        return listaItemVendas;
    } // final do metodo
    
}
