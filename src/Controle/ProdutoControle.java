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
    
    // Inserir produto
    public boolean inserirProduto(ProdutoModelo produto) {
        System.out.println("inserirProduto");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para inserir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = " INSERT INTO produto ("
                       +    " id_produto,"
                       +    " id_fornecedor,"
                       +    " nome,"
                       +    " quantidadeMin,"
                       +    " quantidadeEstoq,"
                       +    " categoria,"
                       +    " marca,"
                       +    " preco_compra,"
                       +    " preco_venda,"
                       +    " codigo_de_barra,"
                       +    " descricao"
                       + " ) " +
                         " VALUES ("
                       +         produto.getIdProduto()
                       + ", '" + produto.getIdFornecedor()+ "'"
                       + ", '" + produto.getNome()+ "'"
                       + ", '" + produto.getQuantidadeMin()+ "'"
                       + ", '" + produto.getQuantidadeEstoq()+ "'"
                       + ", '" + produto.getCategoria()+ "'"
                       + ", '" + produto.getMarca()+ "'"
                       + ", '" + produto.getPrecoCompra()+ "'"
                       + ", '" + produto.getPrecoVenda()+ "'"
                       + ", '" + produto.getCodigoBarra()+ "'"
                       + ", '" + produto.getDescricao()+ "');";
            
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
    
    //Listar Produto
    public ArrayList<ProdutoModelo> listarProduto() {
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
                            rs.getInt("id_fornecedor"),
                            rs.getString("nome"),
                            rs.getInt("quantidadeMin"),
                            rs.getInt("quantidadeEstoq"),
                            rs.getString("categoria"),
                            rs.getString("marca"),
                            rs.getFloat("preco_compra"),
                            rs.getFloat("preco_venda")
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
    
    // Obter produto
    public ProdutoModelo obterProduto(int Cod) {
        System.out.println("pesquisa Produto");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para consultar");
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM produto WHERE id_produto = " + Cod + ";";
            System.out.println("SQL: " + sql);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
         
            // Tratando os dados retornados..
            if (rs.next()) {
               ProdutoModelo produto = new ProdutoModelo(
                       rs.getInt("id_produto"),
                       rs.getString("nome"),
                       rs.getString("codigo_de_barra"),
                       rs.getString("descricao"),
                       rs.getString("marca"),
                       rs.getString("categoria"),
                       rs.getInt("id_fornecedor"),
                       rs.getInt("quantidadeMin"),
                       rs.getInt("quantidadeEstoq"),
                       rs.getFloat("preco_compra"),
                       rs.getFloat("preco_venda")
               );
               return produto;
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
    
    // atualiza produto
    public boolean atualizarProduto(ProdutoModelo produto) {
        System.out.println("atualizarProduto");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado e preparando para atualizar");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();
            
            String sql = "UPDATE produto SET "
                       + "nome = '" + produto.getNome()+ "', "
                       + "codigo_de_barra = '" + produto.getCodigoBarra()+ "', "
                       + "descricao = '" + produto.getDescricao()+ "', "
                       + "marca = '" + produto.getMarca()+ "', "
                       + "categoria = '" + produto.getCategoria()+ "', "
                       + "id_fornecedor = '" + produto.getIdFornecedor()+ "', "
                       + "quantidadeMin = '" + produto.getQuantidadeMin()+ "', "
                       + "quantidadeEstoq = '" + produto.getQuantidadeEstoq()+ "', "
                       + "preco_compra = '" + produto.getPrecoCompra()+ "', "
                       + "preco_venda = '" + produto.getPrecoVenda()+ "' "
                       + "WHERE id_produto = " + produto.getIdProduto()+ ";";
            
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
    
    // Deleta produto
    public boolean excluirProduto(ProdutoModelo produto) {
        System.out.println("excluirProduto");
        // inicia a conexao com o Banco de dados chamando
        // a classe Conexao
        conexao = AppControle.getInstancia().getConexao();
        System.out.println("conectado. Preparando para excluir");
        Statement stmt = null;
        try {
            stmt = conexao.createStatement();

            String sql = "DELETE FROM produto " 
                       + " WHERE id_produto = " + produto.getIdProduto()+ ";";
            
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
