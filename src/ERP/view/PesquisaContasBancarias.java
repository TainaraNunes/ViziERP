package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaContasBancarias extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();    
    private CadastroContaBancaria pesquisaContas;   
    private CadastroHistoricos pesquisaHistoricos;   
    
    public PesquisaContasBancarias() {
        initComponents();
    }
    
    public void preencherTabela(CadastroContaBancaria pesquisaConta, CadastroHistoricos pesquisaHistorico, String Sql){
        pesquisaContas = pesquisaConta;
        pesquisaHistoricos = pesquisaHistorico;
        
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Banco", "Descrição", "Agência", "Conta Corrente"};
        
        conecta.conexao();
        conecta.executaSql(Sql);
        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("BANCOCODIGO"), conecta.rs.getString("BANCODESCRICAO"), conecta.rs.getString("AGENCIA"), conecta.rs.getString("CONTACORRENTE"), conecta.rs.getString("SALDOINICIAL"), conecta.rs.getString("SALDOATUAL")});
            }while(conecta.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhuma conta localizada!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblContasBancarias.setModel(table);
        tblContasBancarias.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblContasBancarias.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblContasBancarias.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblContasBancarias.getColumnModel().getColumn(1).setResizable(false);
        tblContasBancarias.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblContasBancarias.getColumnModel().getColumn(2).setResizable(false);
        tblContasBancarias.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblContasBancarias.getColumnModel().getColumn(3).setResizable(false);
        
        tblContasBancarias.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblContasBancarias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblContasBancarias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Contas Bancárias");

        tblContasBancarias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Banco", "Descrição", "Agência", "Conta Corrente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContasBancarias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContasBancariasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContasBancarias);
        if (tblContasBancarias.getColumnModel().getColumnCount() > 0) {
            tblContasBancarias.getColumnModel().getColumn(0).setResizable(false);
            tblContasBancarias.getColumnModel().getColumn(1).setResizable(false);
            tblContasBancarias.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblContasBancariasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContasBancariasMouseClicked
        int index = tblContasBancarias.getSelectedRow();
        TableModel model = tblContasBancarias.getModel();
                
        conecta.conexao();        
        try {
            conecta.rs.first();
            
            String bancoCodigo = model.getValueAt(index, 0).toString().trim();
            String bancoDescricao = model.getValueAt(index, 1).toString().trim();
            String agencia = model.getValueAt(index, 2).toString().trim();
            String contaCorrente = model.getValueAt(index, 3).toString().trim();
            String saldoInicial = model.getValueAt(index, 4).toString();
            String saldoAtual = model.getValueAt(index, 5).toString();
                        
            if (pesquisaContas != null){
                pesquisaContas.setVisible(true);
                pesquisaContas.pack();
                pesquisaContas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaContas.txtBancoCodigo.setText(bancoCodigo);
                pesquisaContas.txtBancoDescricao.setText(bancoDescricao);
                pesquisaContas.txtAgencia.setText(agencia);
                pesquisaContas.txtContaCorrente.setText(contaCorrente);

                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                pesquisaContas.txtSaldoInicial.setText(nf.format(new BigDecimal(saldoInicial)));
                pesquisaContas.txtSaldoAtual.setText(nf.format(new BigDecimal(saldoAtual)));
                
                pesquisaContas.alterando = 1;
                pesquisaContas.incluindo = 0;
                pesquisaContas.btnExcluir.setEnabled(true);           
            
                this.dispose();
                
            } else if (pesquisaHistoricos != null) {
                pesquisaHistoricos.setVisible(true);
                pesquisaHistoricos.pack();
                pesquisaHistoricos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaHistoricos.txtBancoCodigo.setText(bancoCodigo);
                pesquisaHistoricos.txtBancoDescricao.setText(bancoDescricao);
                pesquisaHistoricos.txtContaCorrente.setText(contaCorrente);         
                
                this.dispose();
            }                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }        
        
        conecta.desconecta();                                   
    }//GEN-LAST:event_tblContasBancariasMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaContasBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaContasBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaContasBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaContasBancarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaContasBancarias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblContasBancarias;
    // End of variables declaration//GEN-END:variables
}
