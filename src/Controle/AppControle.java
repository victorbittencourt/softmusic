/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Configuracao.BD_config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author silva
 */
public final class AppControle {
    String host    = BD_config.getBD_HOST();
    String bd      = BD_config.getBD_NAME();
    String user    = BD_config.getBD_USER();
    String pass    = BD_config.getBD_PASS();
    
    Connection conexao = null;
    private static AppControle instacia = null;
    
    public AppControle() {
        iniciaConexao();
    }
    
    public void iniciaConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Carregado");
        } catch (ClassNotFoundException e) {
            System.out.println("O driver do Mysql não pôde ser carregado!");
        }
    }
    
    public static AppControle getInstancia() {
        if (instacia == null) {
            instacia = new AppControle();
        }
        
        return instacia;
    }
    
    public Connection getConexao() {
        try {
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection(
                        "jdbc:mysql://" + host + "/" + bd,
                        user,
                        pass
                );
                
                System.out.println("Conexão Estabelecida");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }
    
    public void fechaConexao() {
        try {
            conexao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
