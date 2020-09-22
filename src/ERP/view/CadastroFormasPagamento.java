package ERP.view;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import Beans.BeansFormasPagamento;
import Beans.ModeloTabela;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoLancamentoContasReceber;

public class CadastroFormasPagamento extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    BeansFormasPagamento formasPagamento = new BeansFormasPagamento();
    
    int incluindo = 1;
    int alterando = 0;    

    public CadastroFormasPagamento() {
        initComponents();
        
        txtFormaPagamentoDescricao.setDocument(new Teclas());
        txtFormaPagamentoDescricao.requestFocus();
        btnExcluir.setEnabled(false);
        
        consultarFormasPagamento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFormaPagamentoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFormaPagamentoDescricao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFormasPagamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Formas de Pagamento");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        txtFormaPagamentoCodigo.setEditable(false);

        jLabel2.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFormaPagamentoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFormaPagamentoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFormaPagamentoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFormaPagamentoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnGravar, btnSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(btnNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblFormasPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFormasPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFormasPagamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFormasPagamento);
        if (tblFormasPagamento.getColumnModel().getColumnCount() > 0) {
            tblFormasPagamento.getColumnModel().getColumn(0).setResizable(false);
            tblFormasPagamento.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblFormasPagamento.getColumnModel().getColumn(1).setResizable(false);
            tblFormasPagamento.getColumnModel().getColumn(1).setPreferredWidth(275);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtFormaPagamentoDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição da forma de pagamento!");
            txtFormaPagamentoDescricao.requestFocus();            
        } else if (incluindo == 1){
            formasPagamento.setFormaPagamentoDescricao(txtFormaPagamentoDescricao.getText());
            
            gravarFormaPagamento(formasPagamento);
            limpaCampos();
            consultarFormasPagamento();
       } else if (alterando == 1) {
            formasPagamento.setFormaPagamentoCodigo(Integer.parseInt(txtFormaPagamentoCodigo.getText()));
            formasPagamento.setFormaPagamentoDescricao(txtFormaPagamentoDescricao.getText());
            
            editarFormaPagamento(formasPagamento);
            limpaCampos();
            consultarFormasPagamento();
       }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            formasPagamento.setFormaPagamentoCodigo(Integer.parseInt(txtFormaPagamentoCodigo.getText()));
            formasPagamento.setFormaPagamentoDescricao(txtFormaPagamentoDescricao.getText());
            excluirFormaPagamento();
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblFormasPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFormasPagamentoMouseClicked
        int index = tblFormasPagamento.getSelectedRow();
        TableModel model = tblFormasPagamento.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM FORMASPAGAMENTO WHERE CODIGO = '" + index + "' ORDER BY DESCRICAO");
        try {
            conecta.rs.first();

            String codigo = model.getValueAt(index, 0).toString();
            String descricao = model.getValueAt(index, 1).toString();
            
            txtFormaPagamentoCodigo.setText(codigo);
            txtFormaPagamentoDescricao.setText(descricao);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }

        incluindo = 0;
        alterando = 1;
        btnExcluir.setEnabled(true);        
        conecta.desconecta();
    }//GEN-LAST:event_tblFormasPagamentoMouseClicked

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaCampos();
        txtFormaPagamentoCodigo.setText("");
        txtFormaPagamentoDescricao.setEnabled(true);
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    public void gravarFormaPagamento(BeansFormasPagamento formasPagamento) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO FORMASPAGAMENTO(DESCRICAO) VALUES (?)");
            pst.setString(1, formasPagamento.getFormaPagamentoDescricao().trim());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Forma de pagamento gravada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }
        
    public void editarFormaPagamento(BeansFormasPagamento formasPagamento) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE FORMASPAGAMENTO SET DESCRICAO = ? WHERE CODIGO = ?");
            pst.setString(1, formasPagamento.getFormaPagamentoDescricao().trim());
            pst.setInt(2, formasPagamento.getFormaPagamentoCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }
    
    public void excluirFormaPagamento() {
        int formaPagamentoCodigo = Integer.parseInt(txtFormaPagamentoCodigo.getText());
        String formaPagamentoDescricao = txtFormaPagamentoDescricao.getText().trim();
        
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM FORMASPAGAMENTO WHERE CODIGO = ? AND DESCRICAO = ?");
            pst.setInt(1, formaPagamentoCodigo);
            pst.setString(2, formaPagamentoDescricao);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso!");
            limpaCampos();
            consultarFormasPagamento();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarFormasPagamento(){
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "Descrição"};

        conecta.conexao();
        conecta.executaSql("SELECT CODIGO, DESCRICAO FROM FORMASPAGAMENTO ORDER BY DESCRICAO");

        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("CODIGO"), conecta.rs.getString("DESCRICAO").trim()});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            conecta.desconecta();
        }

        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblFormasPagamento.setModel(table);
        tblFormasPagamento.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblFormasPagamento.getColumnModel().getColumn(0).setResizable(false);
        tblFormasPagamento.getColumnModel().getColumn(1).setPreferredWidth(275);
        tblFormasPagamento.getColumnModel().getColumn(1).setResizable(false);

        tblFormasPagamento.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblFormasPagamento.setAutoResizeMode(tblFormasPagamento.AUTO_RESIZE_OFF); //não permite redimensionar a tabela;
        tblFormasPagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conecta.desconecta();
    }
    
    public void limpaCampos() {
        txtFormaPagamentoCodigo.setText("");
        txtFormaPagamentoDescricao.setText("");
        txtFormaPagamentoDescricao.requestFocus();
        btnExcluir.setEnabled(false);        
        incluindo = 1;
        alterando = 0;
    }
    
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
            java.util.logging.Logger.getLogger(CadastroFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFormasPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
                new CadastroFormasPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    private javax.swing.JButton btnNovo;
    public javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFormasPagamento;
    public javax.swing.JTextField txtFormaPagamentoCodigo;
    public javax.swing.JTextField txtFormaPagamentoDescricao;
    // End of variables declaration//GEN-END:variables
}
