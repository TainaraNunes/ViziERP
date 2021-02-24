package ERP.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;
import javax.swing.UIManager;

public class PesquisaHistoricos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();   
    ConsultaCheques consultaCheques = new ConsultaCheques(this);
    private CadastroHistoricos pesquisaHistoricos;   
    private LancamentoCaixa pesquisaLancamentoCaixaHistorico;
    private LancamentoCaixa pesquisaLancamentoCaixaContraPartida;
    
    public PesquisaHistoricos() {
        initComponents();
    }

    public void preencherTabela(CadastroHistoricos pesquisaCadastro, LancamentoCaixa pesquisaHistorico, LancamentoCaixa pesquisaContraPartida, String Sql){
        pesquisaHistoricos = pesquisaCadastro;
        pesquisaLancamentoCaixaHistorico = pesquisaHistorico;
        pesquisaLancamentoCaixaContraPartida = pesquisaContraPartida;       
        
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Código", "Histórico"};
        
        conecta.conexao();
        conecta.executaSql(Sql);
        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("HISTORICOCODIGO"), conecta.rs.getString("HISTORICODESCRICAO"), conecta.rs.getString("BANCODESCRICAO"), conecta.rs.getString("BANCOCODIGO"), conecta.rs.getString("CONTACORRENTE"), conecta.rs.getString("TIPOLANCAMENTO"), conecta.rs.getInt("MOVIMENTADUPLICATAS"), conecta.rs.getInt("MOVIMENTACHEQUE"), conecta.rs.getInt("MOVIMENTASALDOBANCARIO")});
            }while(conecta.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhum histórico localizado!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblHistoricos.setModel(table);
        tblHistoricos.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblHistoricos.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblHistoricos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblHistoricos.getColumnModel().getColumn(1).setResizable(false);
        tblHistoricos.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblHistoricos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistoricos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Históricos");
        setName("frmPesquisaHistoricosCaixa"); // NOI18N

        tblHistoricos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código ", "Histórico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHistoricos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHistoricosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHistoricos);
        if (tblHistoricos.getColumnModel().getColumnCount() > 0) {
            tblHistoricos.getColumnModel().getColumn(0).setResizable(false);
            tblHistoricos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblHistoricos.getColumnModel().getColumn(1).setResizable(false);
            tblHistoricos.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHistoricosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHistoricosMouseClicked
        int index = tblHistoricos.getSelectedRow();
        TableModel model = tblHistoricos.getModel();
        
        conecta.conexao();
        //conecta.executaSql("SELECT * FROM HISTORICOS WHERE HISTORICODESCRICAO LIKE '%" + index + "%'");
        try {
            conecta.rs.first();            
            String historicoCodigo = model.getValueAt(index, 0).toString();
            String historicoDescricao = model.getValueAt(index, 1).toString();
            String bancoDescricao = model.getValueAt(index, 2).toString();
            String bancoCodigo = model.getValueAt(index, 3).toString();
            String contaCorrente = model.getValueAt(index, 4).toString();
            String tipoLancamento = model.getValueAt(index, 5).toString();
            String movimentaDuplicatas = model.getValueAt(index, 6).toString();
            String movimentaCheque = model.getValueAt(index, 7).toString();
            String movimentaSaldoBancario = model.getValueAt(index, 8).toString();
            
            if (pesquisaHistoricos != null) {
                pesquisaHistoricos.setVisible(true);
                pesquisaHistoricos.pack();
                pesquisaHistoricos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaHistoricos.txtHistoricoCodigo.setText(historicoCodigo);
                pesquisaHistoricos.txtHistoricoDescricao.setText(historicoDescricao);

                if (tipoLancamento.equals("S")) {
                    pesquisaHistoricos.cbxLancaSaida.setSelected(true);
                } else if (tipoLancamento.equals("E")) {
                    pesquisaHistoricos.cbxLancaEntrada.setSelected(true);
                } else if (tipoLancamento.equals("C")) {
                    pesquisaHistoricos.cbxContraPartida.setSelected(true);                        
                }

                if (Integer.parseInt(movimentaDuplicatas) == 1) {
                    pesquisaHistoricos.cbxMovimentaDuplicatas.setSelected(true);
                } else {
                    pesquisaHistoricos.cbxMovimentaDuplicatas.setSelected(false);
                }
                
                if (Integer.parseInt(movimentaCheque) == 1) {
                    pesquisaHistoricos.cbxMovimentaCheque.setSelected(true);
                } else {
                    pesquisaHistoricos.cbxMovimentaCheque.setSelected(false);
                }
                
                if (Integer.parseInt(movimentaSaldoBancario) == 1) {
                    pesquisaHistoricos.cbxMovimentaSaldoBancario.setSelected(true);
                    pesquisaHistoricos.txtBancoDescricao.setText(bancoDescricao);
                    pesquisaHistoricos.txtBancoCodigo.setText(bancoCodigo);
                    pesquisaHistoricos.txtContaCorrente.setText(contaCorrente);

                    pesquisaHistoricos.txtBancoCodigo.setEnabled(true);
                    pesquisaHistoricos.txtBancoDescricao.setEnabled(true);
                    pesquisaHistoricos.txtContaCorrente.setEnabled(true);
                } else {
                    pesquisaHistoricos.cbxMovimentaSaldoBancario.setSelected(false);
                    pesquisaHistoricos.txtBancoDescricao.setText("");
                    pesquisaHistoricos.txtBancoCodigo.setText("");
                    pesquisaHistoricos.txtContaCorrente.setText("");

                    pesquisaHistoricos.txtBancoCodigo.setEnabled(false);
                    pesquisaHistoricos.txtBancoDescricao.setEnabled(false);
                    pesquisaHistoricos.txtContaCorrente.setEnabled(false);
                }

                pesquisaHistoricos.alterando = 1;
                pesquisaHistoricos.incluindo = 0;
                pesquisaHistoricos.btnExcluir.setEnabled(true);           
                this.dispose();
                
            } else if (pesquisaLancamentoCaixaHistorico != null){
                pesquisaLancamentoCaixaHistorico.setVisible(true);
                pesquisaLancamentoCaixaHistorico.pack();
                pesquisaLancamentoCaixaHistorico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoCaixaHistorico.txtHistorico.setText(historicoDescricao);         
                this.dispose();
                
            } else if (pesquisaLancamentoCaixaContraPartida != null) {
                pesquisaLancamentoCaixaContraPartida.setVisible(true);                
                pesquisaLancamentoCaixaContraPartida.pack();
                pesquisaLancamentoCaixaContraPartida.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoCaixaContraPartida.txtContraPartida.setText(historicoDescricao);    
                
                if (Integer.parseInt(movimentaCheque) == 1) {
                    pesquisaLancamentoCaixaContraPartida.carregarCheque();
                }
                
                this.dispose();
            }             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }                
        conecta.desconecta();
    }//GEN-LAST:event_tblHistoricosMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaHistoricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaHistoricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaHistoricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaHistoricos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaHistoricos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblHistoricos;
    // End of variables declaration//GEN-END:variables
}
