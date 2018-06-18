
package Controle;

import Modelo.FornecedorModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FornecedorControle {
    
    Connection conexao = null;
    
    //insere fornecedor
    public boolean inserirFornecedor(FornecedorModelo fornecedor) {
        System.out.println("inserirFornecedor");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = " INSERT INTO fornecedor ("
                       +    " id_fornecedor,"
                       +    " nome_fantasia,"
                       +    " razao_social,"
                       +    " logradouro,"
                       +    " email,"
                       +    " telefone,"
                       +    " cnpj"
                       + " ) " +
                         " VALUES ("
                       +         fornecedor.getCodFornecedor()
                       + ", '" + fornecedor.getNomeFantasia() + "'"
                       + ", '" + fornecedor.getRazaoSocial() + "'"
                       + ", '" + fornecedor.getEndereco()+ "'"
                       + ", '" + fornecedor.getEmail()+ "'"
                       + ", '" + fornecedor.getTelefone()+ "'"
                       + ", '" + fornecedor.getCnpj()+ "');";
            
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
    
    //popula ArrayList com fornecedores cadastrados
    public ArrayList<FornecedorModelo> listarFornecedor() {
        ArrayList<FornecedorModelo> listaFornecedores = new ArrayList<FornecedorModelo>();
        
        // Consulta SQL
        String sql = " SELECT " + 
                        " id_fornecedor, " +
                        " nome_fantasia, " +
                        " razao_social, " +
                        " logradouro, " +
                        " email, " +
                        " telefone, " +
                        " cnpj " +
                    " FROM fornecedor " +
                    " ORDER BY id_fornecedor ";
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Incluindo alunos na listaFornecedores que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    FornecedorModelo fornecedor = new FornecedorModelo(
                            rs.getInt("id_fornecedor"),
                            rs.getString("nome_fantasia"),
                            rs.getString("razao_social"),
                            rs.getString("logradouro"),
                            rs.getString("email"),
                            rs.getString("telefone"),
                            rs.getString("cnpj"),
                            Boolean.FALSE
                    );
                    listaFornecedores.add(fornecedor);
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
        
        return listaFornecedores;
    } // final do metodo
    
    //obter fornecedor
    public FornecedorModelo obterFornecedor(int cod) {
        System.out.println("pesquisa Fornecedor");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM fornecedor WHERE id_fornecedor = " + cod + ";";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               FornecedorModelo fornecedor = new FornecedorModelo(
                       rs.getInt("id_fornecedor"),
                       rs.getString("nome_fantasia"),
                       rs.getString("razao_social"),
                       rs.getString("logradouro"),
                       rs.getString("email"),
                       rs.getString("telefone"),
                       rs.getString("cnpj")
               );
               return fornecedor;
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
     
    //atualiza fornecedor
    public boolean atualizarFornecedor(FornecedorModelo fornecedor) {
        System.out.println("atualizarFornecedor");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para atualizar");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            
            String sql = "UPDATE fornecedor SET "
                       + "nome_fantasia = '" + fornecedor.getNomeFantasia()+ "', "
                       + "razao_social = '" + fornecedor.getRazaoSocial() + "', "
                       + "logradouro = '" + fornecedor.getEndereco()+ "', "
                       + "email = '" + fornecedor.getEmail() + "', "
                       + "telefone = '" + fornecedor.getTelefone() + "', "
                       + "cnpj = '" + fornecedor.getCnpj() + "' "
                       + "WHERE id_fornecedor = " + fornecedor.getCodFornecedor()+ ";";
            
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
    
    //exclue fornecedor
    public boolean excluirFornecedor(FornecedorModelo fornecedor) {
        System.out.println("excluirFornecedor");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM fornecedor " 
                       + " WHERE id_fornecedor = " + fornecedor.getCodFornecedor()+ ";";
            
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
    
    //exclue multiplos fornecedores
    public boolean excluirFornecedorMultiplo(int codigo) {
        System.out.println("excluirFornecedor");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM fornecedor " 
                       + " WHERE id_fornecedor = " + codigo + ";";
            
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
    
}
