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
                       +    " referencia,"
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
                       + ", '" + cliente.getReferencia() + "'"
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
    public ArrayList<ClienteModelo> listarCliente() {
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
                            rs.getInt("id_cliente"),
                            rs.getString("nome"),
                            rs.getString("RG"),
                            rs.getString("CPF"),
                            Boolean.FALSE
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
    
    // Obter cliente
    public ClienteModelo obterCliente(int Cod) {
        System.out.println("pesquisa Cliente");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = " + Cod + ";";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               ClienteModelo cliente = new ClienteModelo(
                       rs.getInt("id_cliente"),
                       rs.getString("nome"),
                       rs.getString("RG"),
                       rs.getString("CPF"),
                       rs.getString("CEP"),
                       rs.getString("logradouro"),
                       rs.getInt("numero"),
                       rs.getString("cidade"),
                       rs.getString("estado"),
                       rs.getString("bairro"),
                       rs.getString("referencia"),
                       rs.getString("email"),
                       rs.getString("telefone")
               );
               return cliente;
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
    
    // Obter cliente2venda
    public ClienteModelo obterCliente2Venda(int Cod) {
        System.out.println("obterCliente2Venda");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = " + Cod + ";";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               ClienteModelo cliente = new ClienteModelo(
                       rs.getString("nome"),
                       rs.getString("logradouro"),
                       rs.getInt("numero"),
                       rs.getString("cidade"),
                       rs.getString("estado"),
                       rs.getString("bairro"),
                       rs.getString("referencia"),
                       rs.getString("telefone")
               );
               return cliente;
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
     
    // atualiza cliente
    public boolean atualizarCliente(ClienteModelo cliente) {
        System.out.println("atualizarCliente");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para atualizar");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            
            String sql = "UPDATE cliente SET "
                       + "nome = '" + cliente.getNome()+ "', "
                       + "RG = '" + cliente.getRg() + "', "
                       + "CPF = '" + cliente.getCpf()+ "', "
                       + "CEP = '" + cliente.getCpf() + "', "
                       + "logradouro = '" + cliente.getLogradouro() + "', "
                       + "numero = '" + cliente.getNumero() + "', "
                       + "cidade = '" + cliente.getCidade() + "', "
                       + "estado = '" + cliente.getEstado() + "', "
                       + "bairro = '" + cliente.getBairro() + "', "
                       + "referencia = '" + cliente.getReferencia() + "', "
                       + "email = '" + cliente.getEmail() + "', "
                       + "telefone = '" + cliente.getTelefone() + "', "
                       + "referencia = '" + cliente.getReferencia() + "' "
                       + "WHERE id_cliente = " + cliente.getIdCliente()+ ";";
            
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            // Incluindo alunos na listaAlunos que vai ser retornada
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
    
    // Deleta cliente
    public boolean excluirCliente(ClienteModelo cliente) {
        System.out.println("excluirCliente");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM cliente " 
                       + " WHERE id_cliente = " + cliente.getIdCliente()+ ";";
            
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
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
    
    // deleta multiplos cliente
    public boolean excluirClienteMultiplo(int codigo) {
        System.out.println("excluirCliente");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM cliente " 
                       + " WHERE id_cliente = " + codigo + ";";
            
            System.out.println("SQL: " + sql);
            stmt.executeUpdate(sql);
            // Incluindo alunos na listaAlunos que vai ser retornada
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
    
    // Obter quantidade de clientes
    public int obterQuantidadeCliente() {
        System.out.println("obterQuantidadeCliente");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT COUNT(id_cliente) AS total_cliente FROM cliente;";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               return Integer.parseInt(rs.getString("total_cliente"));
            }
            else
            {
               return 0;
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
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
}
