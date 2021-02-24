package ERP.view;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.BeansContasBancarias;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoLancamentoContasReceber;

public class CadastroContaBancaria extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    BeansContasBancarias contasBancarias = new BeansContasBancarias();
    PesquisaContasBancarias pesquisaContasBancarias = new PesquisaContasBancarias();    
    
    int incluindo = 1;
    int alterando = 0;    

    public CadastroContaBancaria() {
        initComponents();
        
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/contasbancarias.png")).getImage());
        
        txtBancoDescricao.setDocument(new Teclas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBancoDescricao = new javax.swing.JTextField();
        txtAgencia = new javax.swing.JTextField();
        txtContaCorrente = new javax.swing.JTextField();
        txtSaldoInicial = new javax.swing.JTextField();
        txtBancoCodigo = new javax.swing.JTextField();
        btnPesquisaContasBancarias = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSaldoAtual = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Contas Bancárias");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Banco:");

        jLabel6.setText("Agência:");

        jLabel7.setText("Conta Corrente:");

        jLabel8.setText("Saldo Inicial:");

        txtAgencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgenciaKeyTyped(evt);
            }
        });

        txtContaCorrente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContaCorrenteKeyTyped(evt);
            }
        });

        txtSaldoInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSaldoInicialFocusLost(evt);
            }
        });
        txtSaldoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoInicialKeyTyped(evt);
            }
        });

        txtBancoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBancoCodigoKeyTyped(evt);
            }
        });

        btnPesquisaContasBancarias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaContasBancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaContasBancariasActionPerformed(evt);
            }
        });

        jLabel1.setText("Saldo Atual:");

        txtSaldoAtual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSaldoAtualFocusLost(evt);
            }
        });
        txtSaldoAtual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoAtualKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAgencia)
                        .addComponent(txtContaCorrente)
                        .addComponent(txtSaldoInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBancoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBancoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisaContasBancarias, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisaContasBancarias)
                    .addComponent(txtBancoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBancoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(txtSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAbandonar.setText("Abandonar");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnGravar, btnSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(btnAbandonar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAgenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgenciaKeyTyped
        String caracteres = "0987654321-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAgenciaKeyTyped

    private void txtContaCorrenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContaCorrenteKeyTyped
        String caracteres = "0987654321-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContaCorrenteKeyTyped

    private void txtSaldoInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSaldoInicialFocusLost
        String sv = txtSaldoInicial.getText();
        if (!txtSaldoInicial.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtSaldoInicial.setText(valorFormatado);
        } else {
            JOptionPane.showMessageDialog(null, "Informe o saldo inicial da conta!");
            txtSaldoInicial.requestFocus();
        }
    }//GEN-LAST:event_txtSaldoInicialFocusLost

    private void txtSaldoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoInicialKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSaldoInicialKeyTyped

    private void txtBancoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBancoCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBancoCodigoKeyTyped

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            contasBancarias.setBancoCodigo(txtBancoCodigo.getText());
            contasBancarias.setContaCorrente(txtContaCorrente.getText());
            excluirContaBancaria();
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtBancoCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o código do banco!");
            txtBancoCodigo.requestFocus();
        } else if (txtBancoDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição do banco!");
            txtBancoDescricao.requestFocus();            
        } else if (txtAgencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número da agência com dígito!");
            txtAgencia.requestFocus();            
        } else if (txtContaCorrente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número da conta corrente com dígito!");
            txtContaCorrente.requestFocus();            
        } else if (txtSaldoInicial.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o saldo atual da conta!");
            txtSaldoInicial.requestFocus();            
        } else if (incluindo == 1){
            contasBancarias.setBancoCodigo(txtBancoCodigo.getText());
            contasBancarias.setBancoDescricao(txtBancoDescricao.getText());
            contasBancarias.setAgencia(txtAgencia.getText());
            contasBancarias.setContaCorrente(txtContaCorrente.getText());
            
            String valorSaldoInicial = txtSaldoInicial.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal saldoInicial = new BigDecimal(valorSaldoInicial);
            contasBancarias.setSaldoInicial(saldoInicial);
            
            String valorSaldoAtual = txtSaldoAtual.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal saldoAtual = new BigDecimal(valorSaldoAtual);
            contasBancarias.setSaldoAtual(saldoAtual);            
        
            gravarContaBancaria(contasBancarias);
            limpaCampos();
            
        } else if (alterando == 1) {
            contasBancarias.setBancoCodigo(txtBancoCodigo.getText());
            contasBancarias.setBancoDescricao(txtBancoDescricao.getText());
            contasBancarias.setAgencia(txtAgencia.getText());
            contasBancarias.setContaCorrente(txtContaCorrente.getText());

            String saldoInicial = txtSaldoInicial.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorSaldoInicial = new BigDecimal(saldoInicial);
            contasBancarias.setSaldoInicial(valorSaldoInicial);
            
            String saldoAtual = txtSaldoAtual.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorSaldoAtual = new BigDecimal(saldoAtual);
            contasBancarias.setSaldoAtual(valorSaldoAtual);
            
            editarContaBancaria(contasBancarias);
            limpaCampos();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    public void gravarContaBancaria(BeansContasBancarias contasBancarias) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONTASBANCARIAS(BANCOCODIGO, BANCODESCRICAO, AGENCIA, CONTACORRENTE, SALDOINICIAL, SALDOATUAL) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, contasBancarias.getBancoCodigo());
            pst.setString(2, contasBancarias.getBancoDescricao().trim());
            pst.setString(3, contasBancarias.getAgencia());
            pst.setString(4, contasBancarias.getContaCorrente());
            pst.setBigDecimal(5, contasBancarias.getSaldoInicial());
            pst.setBigDecimal(6, contasBancarias.getSaldoAtual());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados bancários gravados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }

        conecta.desconecta();
    }

    public void editarContaBancaria(BeansContasBancarias contasBancarias) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTASBANCARIAS SET BANCOCODIGO = ?, BANCODESCRICAO = ?, AGENCIA = ?, CONTACORRENTE = ?, SALDOINICIAL = ?, SALDOATUAL = ? WHERE BANCOCODIGO = ? AND CONTACORRENTE = ?");
            pst.setString(1, contasBancarias.getBancoCodigo().trim());
            pst.setString(2, contasBancarias.getBancoDescricao().trim());
            pst.setString(3, contasBancarias.getAgencia().trim());
            pst.setString(4, contasBancarias.getContaCorrente().trim());
            pst.setBigDecimal(5, contasBancarias.getSaldoInicial());
            pst.setBigDecimal(6, contasBancarias.getSaldoAtual());
            pst.setString(7, contasBancarias.getBancoCodigo().trim());
            pst.setString(8, contasBancarias.getContaCorrente().trim());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }
    
    public void excluirContaBancaria() {
        String bancoCodigo = txtBancoCodigo.getText().trim();
        String contaCorrente = txtContaCorrente.getText().trim();
        
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CONTASBANCARIAS WHERE BANCOCODIGO = ? AND CONTACORRENTE = ?");
            pst.setString(1, bancoCodigo);
            pst.setString(2, contaCorrente);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso!");
            limpaCampos();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpaCampos() {
        txtBancoCodigo.setText("");
        txtBancoDescricao.setText("");
        txtAgencia.setText("");
        txtContaCorrente.setText("");
        txtSaldoInicial.setText("");
        txtSaldoAtual.setText("");
        
        incluindo = 1;
        alterando = 0;
    }

    private void txtSaldoAtualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSaldoAtualFocusLost
        String sv = txtSaldoAtual.getText();
        if (!txtSaldoAtual.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtSaldoAtual.setText(valorFormatado);
        } else {
            JOptionPane.showMessageDialog(null, "Informe o saldo atual da conta!");
            txtSaldoAtual.requestFocus();
        }
    }//GEN-LAST:event_txtSaldoAtualFocusLost

    private void txtSaldoAtualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoAtualKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSaldoAtualKeyTyped

    private void btnPesquisaContasBancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaContasBancariasActionPerformed
        if (!txtBancoCodigo.getText().isEmpty() || !txtBancoDescricao.getText().isEmpty()) {
            pesquisaContasBancarias = new PesquisaContasBancarias();
            pesquisaContasBancarias.setLocationRelativeTo(null);
            pesquisaContasBancarias.setVisible(true);
            pesquisaContasBancarias.setResizable(false);
            pesquisaContasBancarias.preencherTabela(this, null, "SELECT * FROM CONTASBANCARIAS WHERE BANCOCODIGO = '" + txtBancoCodigo.getText() + "' OR BANCODESCRICAO LIKE '% "+txtBancoDescricao.getText().trim() +" %' ORDER BY BANCODESCRICAO");
        } else {
            pesquisaContasBancarias = new PesquisaContasBancarias();
            pesquisaContasBancarias.setLocationRelativeTo(null);
            pesquisaContasBancarias.setVisible(true);
            pesquisaContasBancarias.preencherTabela(this, null, "SELECT * FROM CONTASBANCARIAS ORDER BY BANCODESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisaContasBancariasActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (incluindo == 1 || alterando == 1 && resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            btnPesquisaContasBancarias.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroContaBancaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    public javax.swing.JButton btnPesquisaContasBancarias;
    public javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtAgencia;
    public javax.swing.JTextField txtBancoCodigo;
    public javax.swing.JTextField txtBancoDescricao;
    public javax.swing.JTextField txtContaCorrente;
    public javax.swing.JTextField txtSaldoAtual;
    public javax.swing.JTextField txtSaldoInicial;
    // End of variables declaration//GEN-END:variables
}
