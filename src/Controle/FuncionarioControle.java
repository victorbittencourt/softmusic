
package Controle;

import Modelo.FuncionarioModelo;
import Modelo.UsuarioModelo;
import Controle.UsuarioControle;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioControle {
    
    Connection conexao = null;
    
    // insere funcionario
    public boolean inserirFuncionario(FuncionarioModelo funcionario) {
        System.out.println("inserirFuncionario");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = " INSERT INTO funcionario ("
                       +    " id_funcionario,"
                       +    " id_empresa,"
                       +    " nome,"
                       +    " CPF,"
                       +    " CEP,"
                       +    " email,"
                       +    " telefone,"
                       +    " logradouro,"
                       +    " bairro,"
                       +    " numero,"
                       +    " cidade,"
                       +    " estado,"
                       +    " cargo,"
                       +    " chapa,"
                       +    " salario"
                       + " ) " +
                         " VALUES ("
                       +         funcionario.getIdFuncionario()
                       + ", "  + funcionario.getIdEmpresa()
                       + ", '" + funcionario.getNome() + "'"
                       + ", '" + funcionario.getCpf()+ "'"
                       + ", '" + funcionario.getCep()+ "'"
                       + ", '" + funcionario.getEmail()+ "'"
                       + ", '" + funcionario.getTelefone()+ "'"
                       + ", '" + funcionario.getLogradouro()+ "'"
                       + ", '" + funcionario.getBairro()+ "'"
                       + ", "  + funcionario.getNumero()
                       + ", '" + funcionario.getCidade()+ "'"
                       + ", '" + funcionario.getEstado()+ "'"
                       + ", '" + funcionario.getCargo() + "'"
                       + ", '" + funcionario.getChapa() + "'"
                       + ", "  + funcionario.getSalario()+ ");";
            
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
    
    // insere funcionario com login
    public boolean inserirFuncionarioComLogin(FuncionarioModelo funcionario, UsuarioModelo usuario) {
        
        usuario.setIdFuncionario(funcionario.getIdFuncionario());
        UsuarioControle usuarioC = new UsuarioControle();
        
        System.out.println("inserirFuncionarioComLogin");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = " INSERT INTO funcionario ("
                       +    " id_funcionario,"
                       +    " id_empresa,"
                       +    " nome,"
                       +    " CPF,"
                       +    " CEP,"
                       +    " email,"
                       +    " telefone,"
                       +    " logradouro,"
                       +    " bairro,"
                       +    " numero,"
                       +    " cidade,"
                       +    " estado,"
                       +    " cargo,"
                       +    " chapa,"
                       +    " salario"
                       + " ) " +
                         " VALUES ("
                       +         funcionario.getIdFuncionario()
                       + ", "  + funcionario.getIdEmpresa()
                       + ", '" + funcionario.getNome() + "'"
                       + ", '" + funcionario.getCpf()+ "'"
                       + ", '" + funcionario.getCep()+ "'"
                       + ", '" + funcionario.getEmail()+ "'"
                       + ", '" + funcionario.getTelefone()+ "'"
                       + ", '" + funcionario.getLogradouro()+ "'"
                       + ", '" + funcionario.getBairro()+ "'"
                       + ", "  + funcionario.getNumero()
                       + ", '" + funcionario.getCidade()+ "'"
                       + ", '" + funcionario.getEstado()+ "'"
                       + ", '" + funcionario.getCargo() + "'"
                       + ", '" + funcionario.getChapa() + "'"
                       + ", "  + funcionario.getSalario()+ ");";
            
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
            
            //cadastrando usuario
            try {
                usuarioC.inserirUsuario(usuario);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(FuncionarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
    // popula ArrayList com funcionarios
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
    
    public FuncionarioModelo getFuncionario(int cod) {
        System.out.println("pesquisa Funcionario");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM funcionario WHERE id_funcionario = " + cod + ";";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               FuncionarioModelo funcionario = new FuncionarioModelo(
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
               return funcionario;
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
    
    // atualiza funcionario
    public boolean atualizarFuncionario(FuncionarioModelo funcionario) {
        System.out.println("atualizarFuncionario");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para atualizar");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            
            String sql = "UPDATE funcionario SET "
                       + "nome = '" + funcionario.getNome()+ "', "
                       + "CPF = '" + funcionario.getCpf()+ "', "
                       + "CEP = '" + funcionario.getCpf() + "', "
                       + "logradouro = '" + funcionario.getLogradouro() + "', "
                       + "numero = " + funcionario.getNumero() + ", "
                       + "cidade = '" + funcionario.getCidade() + "', "
                       + "estado = '" + funcionario.getEstado() + "', "
                       + "bairro = '" + funcionario.getBairro() + "', "
                       + "email = '" + funcionario.getEmail() + "', "
                       + "telefone = '" + funcionario.getTelefone() + "', "
                       + "cargo = '" + funcionario.getCargo() + "', "
                       + "chapa = '" + funcionario.getChapa() + "', "
                       + "salario = " + funcionario.getSalario() + " "
                       + "WHERE id_funcionario = " + funcionario.getIdFuncionario()+ ";";
            
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
    
    // deleta funcionario
    public boolean excluirFuncionario(FuncionarioModelo funcionario) {
        System.out.println("excluirFuncionario");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM funcionario " 
                       + " WHERE id_funcionario = " + funcionario.getIdFuncionario()+ ";";
            
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
    
    // deleta multiplos funcionarios
    public boolean excluirFuncionarioMultiplo(int codigo) {
        System.out.println("excluirFuncionario");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM funcionario " 
                       + " WHERE id_funcionario = " + codigo + ";";
            
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
