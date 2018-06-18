/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.AppControle;
import Controle.ClienteControle;
import Controle.ProdutoControle;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author silva
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Inicio() {
        initComponents();
        initDashBoard();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        lblQtdProduto = new javax.swing.JLabel();
        lblQtdCliente = new javax.swing.JLabel();
        lblQtdVenda = new javax.swing.JLabel();
        txtQtdProduto = new javax.swing.JTextField();
        txtQtdCliente = new javax.swing.JTextField();
        txtQtdVenda = new javax.swing.JTextField();
        mnuBar = new javax.swing.JMenuBar();
        mnuArquivo = new javax.swing.JMenu();
        mnuItemSair = new javax.swing.JMenuItem();
        mnuCadastrar = new javax.swing.JMenu();
        mnuCadCliente = new javax.swing.JMenuItem();
        mnuCadProduto = new javax.swing.JMenuItem();
        mnuCadVenda = new javax.swing.JMenuItem();
        mnuCadUsuario = new javax.swing.JMenuItem();
        mnuCadEmpresa = new javax.swing.JMenuItem();
        mnuCadFuncionario = new javax.swing.JMenuItem();
        mnuCadFornecedor = new javax.swing.JMenuItem();
        mnuConsulta = new javax.swing.JMenu();
        mnuConCliente = new javax.swing.JMenuItem();
        mnuConProduto = new javax.swing.JMenuItem();
        mnuConVenda = new javax.swing.JMenuItem();
        mnuConEmpresa = new javax.swing.JMenuItem();
        mnuConFuncionario = new javax.swing.JMenuItem();
        mnuConFornecedor = new javax.swing.JMenuItem();
	mnuRelatorio = new javax.swing.JMenu();
        mnuRelatCliente = new javax.swing.JMenuItem();
        mnuRelatProduto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Softmusic - Início");

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTitulo.setText("Dashboard");

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/refresh.png"))); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        lblQtdProduto.setText("Produtos Cadastrados");

        lblQtdCliente.setText("Clientes Cadastrados");

        lblQtdVenda.setText("Vendas Realizadas");

        txtQtdProduto.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtQtdProduto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtQtdProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQtdProduto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQtdProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQtdProduto.setEnabled(false);

        txtQtdCliente.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtQtdCliente.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtQtdCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQtdCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQtdCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQtdCliente.setEnabled(false);

        txtQtdVenda.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        txtQtdVenda.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtQtdVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQtdVenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQtdVenda.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQtdVenda.setEnabled(false);

        mnuArquivo.setText("Arquivo");

        mnuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        mnuItemSair.setText("Sair");
        mnuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemSairActionPerformed(evt);
            }
        });
        mnuArquivo.add(mnuItemSair);

        mnuBar.add(mnuArquivo);

        mnuCadastrar.setText("Cadastrar");

        mnuCadCliente.setText("Cliente");
        mnuCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadClienteActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadCliente);

        mnuCadProduto.setText("Produto");
        mnuCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadProdutoActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadProduto);

        mnuCadVenda.setText("Venda");
        mnuCadVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadVendaActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadVenda);

        mnuCadUsuario.setText("Usuário");
        mnuCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadUsuarioActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadUsuario);

        mnuCadEmpresa.setText("Empresa");
        mnuCadEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadEmpresaActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadEmpresa);

        mnuCadFuncionario.setText("Funcionario");
        mnuCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadFuncionarioActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadFuncionario);

        mnuCadFornecedor.setText("Fornecedor");
        mnuCadFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCadFornecedorActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mnuCadFornecedor);

        mnuBar.add(mnuCadastrar);

        mnuConsulta.setText("Consulta");

        mnuConCliente.setText("Cliente");
        mnuConCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConClienteActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConCliente);

        mnuConProduto.setText("Produto");
        mnuConProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConProdutoActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConProduto);

        mnuConVenda.setText("Venda");
        mnuConVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConVendaActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConVenda);

        mnuConEmpresa.setText("Empresa");
        mnuConEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConEmpresaActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConEmpresa);

        mnuConFuncionario.setText("Funcionário");
        mnuConFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConFuncionarioActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConFuncionario);

        mnuConFornecedor.setText("Fornecedor");
        mnuConFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConFornecedorActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConFornecedor);

        mnuConFornecedor.setText("Fornecedor");
        mnuConFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConFornecedorActionPerformed(evt);
            }
        });
        mnuConsulta.add(mnuConFornecedor);

        mnuBar.add(mnuConsulta);

        mnuRelatorio.setText("Relatórios");

        mnuRelatCliente.setText("Clientes");
        mnuRelatCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatClienteActionPerformed(evt);
            }
        });
        mnuRelatorio.add(mnuRelatCliente);

        mnuRelatProduto.setText("Produtos");
        mnuRelatProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatProdutoActionPerformed(evt);
            }
        });
        mnuRelatorio.add(mnuRelatProduto);

        mnuBar.add(mnuRelatorio);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblQtdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQtdProduto))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQtdCliente)
                            .addComponent(lblQtdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtQtdVenda)
                            .addComponent(lblQtdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(172, 172, 172)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdProduto)
                    .addComponent(lblQtdCliente)
                    .addComponent(lblQtdVenda))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(381, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuItemSairActionPerformed

    private void mnuCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadProdutoActionPerformed
        Produto ViewProcuct = new Produto();
        ViewProcuct.setLocationRelativeTo(null); // Centraliza janela
        ViewProcuct.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadProdutoActionPerformed

    private void mnuCadVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadVendaActionPerformed
        Venda ViewSale = new Venda();
        ViewSale.setLocationRelativeTo(null); // Centraliza janela
        ViewSale.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadVendaActionPerformed

    private void mnuCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadClienteActionPerformed
        Cliente ViewCustomer = new Cliente();
        ViewCustomer.setLocationRelativeTo(null); // Centraliza janela
        ViewCustomer.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadClienteActionPerformed

    private void mnuConProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConProdutoActionPerformed
        ProdutoListar ViewProductList = new ProdutoListar();
        ViewProductList.setLocationRelativeTo(null); // Centraliza janela
        ViewProductList.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuConProdutoActionPerformed

    private void mnuConClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConClienteActionPerformed
        ClienteListar ViewCustomerList = new ClienteListar();
        ViewCustomerList.setLocationRelativeTo(null); // Centraliza janela
        ViewCustomerList.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuConClienteActionPerformed

    private void mnuConVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConVendaActionPerformed
        VendaListar ViewSaleList = new VendaListar();
        ViewSaleList.setLocationRelativeTo(null); // Centraliza janela
        ViewSaleList.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuConVendaActionPerformed

    private void mnuCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadUsuarioActionPerformed
        Usuario ViewUser = new Usuario();
        ViewUser.setLocationRelativeTo(null); // Centraliza janela
        ViewUser.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadUsuarioActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        initDashBoard();
    }//GEN-LAST:event_btnAtualizarActionPerformed
    
    private void mnuCadEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadEmpresaActionPerformed
        Empresa ViewCompany = new Empresa();
        ViewCompany.setLocationRelativeTo(null); // Centraliza janela
        ViewCompany.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadEmpresaActionPerformed

    private void mnuConEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConEmpresaActionPerformed
        EmpresaListar ViewCompany = new EmpresaListar();
        ViewCompany.setLocationRelativeTo(null); // Centraliza janela
        ViewCompany.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuConEmpresaActionPerformed

    private void mnuCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadFuncionarioActionPerformed
        Funcionario ViewEmployee = new Funcionario();
        ViewEmployee.setLocationRelativeTo(null); // Centraliza janela
        ViewEmployee.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadFuncionarioActionPerformed

    private void mnuConFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConFuncionarioActionPerformed
        FuncionarioListar ViewEmployee = new FuncionarioListar();
        ViewEmployee.setLocationRelativeTo(null); // Centraliza janela
        ViewEmployee.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuConFuncionarioActionPerformed

    private void mnuConFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConFornecedorActionPerformed
        FornecedorListar ViewFornecedor = new FornecedorListar();
        ViewFornecedor.setLocationRelativeTo(null); // Centraliza janela
        ViewFornecedor.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuConFornecedorActionPerformed

    private void mnuCadFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCadFornecedorActionPerformed
        Fornecedor ViewFornecedor = new Fornecedor();
        ViewFornecedor.setLocationRelativeTo(null); // Centraliza janela
        ViewFornecedor.setVisible(true); // Abre janela
    }//GEN-LAST:event_mnuCadFornecedorActionPerformed

    private void mnuRelatClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatClienteActionPerformed
        Connection conexao = AppControle.getInstancia().getConexao();
           
           JasperPrint print = null;
           
           try {
               print = JasperFillManager.fillReport(
                       "/home/silva/NetBeansProjects/SoftMusic/src/Visao/RelatCliente.jasper",null,conexao
               );
           } catch (Exception e) {
               System.out.println("Erro:"+e);
           }
           
           JasperViewer view = new JasperViewer(print,false);
           view.setVisible(true);
    }//GEN-LAST:event_mnuRelatClienteActionPerformed

    private void mnuRelatProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatProdutoActionPerformed
        Connection conexao = AppControle.getInstancia().getConexao();
           
           JasperPrint print = null;
           
           try {
               print = JasperFillManager.fillReport(
                       "/home/silva/NetBeansProjects/SoftMusic/src/Visao/RelatProduto.jasper",null,conexao
               );
           } catch (Exception e) {
               System.out.println("Erro:"+e);
           }
           
           JasperViewer view = new JasperViewer(print,false);
           view.setVisible(true);
    }//GEN-LAST:event_mnuRelatProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    private void initDashBoard() {
        // Obtem quantidade de produtos cadastrados
        ProdutoControle produto = new ProdutoControle();
        int qtdProduto          = produto.obterQuantidadeProduto();
        
        // Obtem quantidade de clientes cadastrados
        ClienteControle cliente = new ClienteControle();
        int qtdCliente          = cliente.obterQuantidadeCliente();
        
        // Obtem quantidade de vendas realizadas
        
        this.txtQtdProduto.setText(""+qtdProduto);
        this.txtQtdCliente.setText(""+qtdCliente);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel lblQtdCliente;
    private javax.swing.JLabel lblQtdProduto;
    private javax.swing.JLabel lblQtdVenda;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu mnuArquivo;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenuItem mnuCadCliente;
    private javax.swing.JMenuItem mnuCadEmpresa;
    private javax.swing.JMenuItem mnuCadFornecedor;
    private javax.swing.JMenuItem mnuCadFuncionario;
    private javax.swing.JMenuItem mnuCadProduto;
    private javax.swing.JMenuItem mnuCadUsuario;
    private javax.swing.JMenuItem mnuCadVenda;
    private javax.swing.JMenu mnuCadastrar;
    private javax.swing.JMenuItem mnuConCliente;
    private javax.swing.JMenuItem mnuConEmpresa;
    private javax.swing.JMenuItem mnuConFornecedor;
    private javax.swing.JMenuItem mnuConFuncionario;
    private javax.swing.JMenuItem mnuConProduto;
    private javax.swing.JMenuItem mnuConVenda;
    private javax.swing.JMenu mnuConsulta;
    private javax.swing.JMenuItem mnuItemSair;
    private javax.swing.JMenuItem mnuRelatCliente;
    private javax.swing.JMenuItem mnuRelatProduto;
    private javax.swing.JMenu mnuRelatorio;
    private javax.swing.JTextField txtQtdCliente;
    private javax.swing.JTextField txtQtdProduto;
    private javax.swing.JTextField txtQtdVenda;
    // End of variables declaration//GEN-END:variables
}
