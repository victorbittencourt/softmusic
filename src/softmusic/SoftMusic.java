/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmusic;

import Visao.Login;

/**
 *
 * @author silva
 */
public class SoftMusic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        Login windowLogin = new Login();
        windowLogin.setLocationRelativeTo(null); // Centraliza janela
        windowLogin.setVisible(true); // Abre janela
    }
    
}
