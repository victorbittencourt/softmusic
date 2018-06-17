
package Controle;

import Modelo.EmpresaModelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpresaControle {
    
    Connection conexao = null;
    
    // insere empresa
    public boolean inserirEmpresa(EmpresaModelo empresa) {
        System.out.println("inserirEmpresa");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = " INSERT INTO empresa ("
                       +    " id_empresa,"
                       +    " nome_fantasia,"
                       +    " razao_social,"
                       +    " cnpj,"
                       +    " logradouro,"
                       +    " telefone,"
                       +    " email"
                       + " ) " +
                         " VALUES ("
                       +         empresa.getCodEmpresa()
                       + ", '" + empresa.getNomeFantasia() + "'"
                       + ", '" + empresa.getRazaoSocial() + "'"
                       + ", '" + empresa.getCnpj()+ "'"
                       + ", '" + empresa.getEndereco()+ "'"
                       + ", '" + empresa.getTelefone()+ "'"
                       + ", '" + empresa.getEmail()+ "');";
            
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
    
    // popula ArrayList com empresas cadastradas
    public ArrayList<EmpresaModelo> getListaEmpresas() {
        ArrayList<EmpresaModelo> listaEmpresas = new ArrayList<EmpresaModelo>();
        
        // Consulta SQL
        String sql = " SELECT " + 
                        " id_empresa, " +
                        " nome_fantasia, " +
                        " razao_social, " +
                        " cnpj, " +
                        " logradouro, " +
                        " telefone, " +
                        " email " +
                    " FROM empresa " +
                    " ORDER BY id_empresa ";
      
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando listagem");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Incluindo empresa na listaEmpresas que vai ser retornada
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    EmpresaModelo empresa = new EmpresaModelo(
                            rs.getInt("id_empresa"),
                            rs.getString("nome_fantasia"),
                            rs.getString("razao_social"),
                            rs.getString("cnpj"),
                            rs.getString("logradouro"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            Boolean.FALSE
                    );
                    listaEmpresas.add(empresa);
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
        
        return listaEmpresas;
    } // final do metodo
    
    // retorna obejeto empresa por id
    public EmpresaModelo getEmpresa(int cod) {
        System.out.println("pesquisa Empresa");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM empresa WHERE id_empresa = " + cod + ";";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               EmpresaModelo empresa = new EmpresaModelo(
                       rs.getInt("id_empresa"),
                       rs.getString("nome_fantasia"),
                       rs.getString("razao_social"),
                       rs.getString("cnpj"),
                       rs.getString("logradouro"),
                       rs.getString("telefone"),
                       rs.getString("email")
               );
               return empresa;
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
    
    // atualiza empresa
    public boolean atualizarEmpresa(EmpresaModelo empresa) {
        System.out.println("atualizarEmpresa");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para atualizar");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            
            String sql = "UPDATE empresa SET "
                       + "nome_fantasia = '" + empresa.getNomeFantasia()+ "', "
                       + "razao_social = '" + empresa.getRazaoSocial() + "', "
                       + "cnpj = '" + empresa.getCnpj()+ "', "
                       + "logradouro = '" + empresa.getEndereco() + "', "
                       + "telefone = '" + empresa.getTelefone() + "', "
                       + "email = '" + empresa.getEmail() + "' "
                       + "WHERE id_empresa = " + empresa.getCodEmpresa()+ ";";
            
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
    
    // deleta empresa
    public boolean excluirEmpresa(EmpresaModelo empresa) {
        System.out.println("excluirEmpresa");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM empresa " 
                       + " WHERE id_empresa = " + empresa.getCodEmpresa()+ ";";
            
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
    public boolean excluirEmpresaMultiplo(int codigo) {
        System.out.println("excluirEmpresas");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM empresa " 
                       + " WHERE id_empresa = " + codigo + ";";
            
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
