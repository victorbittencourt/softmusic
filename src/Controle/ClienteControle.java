/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ClienteModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author silva
 */
public class ClienteControle {
    
    Connection conexao = null;
    
    // Inserir cliente
    public boolean inserirCliente(ClienteModelo cliente) {
        System.out.println("inserirCliente");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = " INSERT INTO cliente ("
                       +    " id_cliente,"
                       +    " nome,"
                       +    " RG,"
                       +    " CPF,"
                       +    " CEP,"
                       +    " email,"
                       +    " telefone,"
                       +    " logradouro,"
                       +    " bairro,"
                       +    " numero,"
                       +    " cidade,"
                       +    " estado,"
                       +    " status"
                       + " ) " +
                         " VALUES ("
                       +         cliente.getIdCliente()
                       + ", '" + cliente.getNome() + "'"
                       + ", '" + cliente.getRg() + "'"
                       + ", '" + cliente.getCpf()+ "'"
                       + ", '" + cliente.getCep()+ "'"
                       + ", '" + cliente.getEmail()+ "'"
                       + ", '" + cliente.getTelefone()+ "'"
                       + ", '" + cliente.getLogradouro()+ "'"
                       + ", '" + cliente.getBairro()+ "'"
                       + ", '" + cliente.getNumero()+ "'"
                       + ", '" + cliente.getCidade()+ "'"
                       + ", '" + cliente.getEstado()+ "'"
                       + ", '" + cliente.getStatus()+ "');";
            
            System.out.println("SQL: " + sql);
            
            stmt.executeUpdate(sql);
            // Incluindo cliente na listaCliente que vai ser retornada
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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
    
    // Monta lista de clientes
    public ArrayList<ClienteModelo> getListaClientes() {
        ArrayList<ClienteModelo> listaClientes = new ArrayList<ClienteModelo>();
        
        // Consulta SQL
        String sql = " SELECT " + 
                        " id_cliente, " +
                        " nome, " +
                        " RG, " +
                        " CPF " +
                    " FROM cliente " +
                    " ORDER BY id_cliente ";
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Incluindo alunos na listaClientes que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    ClienteModelo cliente = new ClienteModelo(
                            Boolean.FALSE,
                            rs.getInt("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("RG"),
                            rs.getString("CPF")
                    );
                    listaClientes.add(cliente);
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
        
        return listaClientes;
    } // final do metodo
}
