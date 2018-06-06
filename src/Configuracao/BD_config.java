/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracao;

/**
 *
 * @author silva
 */
public class BD_config {
    // Dados da conexao
    private static final String BD_HOST = "localhost"; // host
    private static final String BD_NAME = "softmusic"; // banco de dados
    private static final String BD_USER = "root"; // usuario
    private static final String BD_PASS = ""; // senha

    // "Gets" das dos dados
    public static String getBD_HOST() {
        return BD_HOST;
    }
    
    public static String getBD_NAME() {
        return BD_NAME;
    }

    public static String getBD_USER() {
        return BD_USER;
    }

    public static String getBD_PASS() {
        return BD_PASS;
    }
}
