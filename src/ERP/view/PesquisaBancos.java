package ERP.view;

import Beans.ModeloTabela;
import Conection.ConectaBD;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;

public class PesquisaBancos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();    
    private Cheques pesquisaLancamentoCheques;
    private ConsultaCheques pesquisaConsultaCheques;
    
    public PesquisaBancos() {
        initComponents();
    }

    public void preencherTabela (Cheques lancamentoCheques, ConsultaCheques consulta, String sql){
        pesquisaLancamentoCheques = lancamentoCheques;
        pesquisaConsultaCheques = consulta;
        
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Código", "Banco"};
        
        conecta.conexao();
        conecta.executaSql(sql);        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("CODIGO"), conecta.rs.getString("DESCRICAO")});
            } while(conecta.rs.next());
            
            ModeloTabela table = new ModeloTabela(dados, colunas);
            tblBancos.setModel(table);
            tblBancos.getColumnModel().getColumn(0).setPreferredWidth(50); 
            tblBancos.getColumnModel().getColumn(0).setResizable(false); 
            tblBancos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblBancos.getColumnModel().getColumn(1).setResizable(false);
            tblBancos.getTableHeader().setReorderingAllowed(false); 
            tblBancos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
            conecta.desconecta();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhum banco localizado!");
            this.dispose();
            conecta.desconecta();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBancos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisa de Bancos");

        tblBancos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Banco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBancos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBancosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBancos);
        if (tblBancos.getColumnModel().getColumnCount() > 0) {
            tblBancos.getColumnModel().getColumn(0).setResizable(false);
            tblBancos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblBancos.getColumnModel().getColumn(1).setResizable(false);
            tblBancos.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBancosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBancosMouseClicked
        int index = tblBancos.getSelectedRow();
        TableModel model = tblBancos.getModel();
        
        conecta.conexao();
        try {
            conecta.rs.first();            
            String bancoCodigo = model.getValueAt(index, 0).toString();
            String bancoDescricao = model.getValueAt(index, 1).toString();
            
            if (pesquisaLancamentoCheques != null) {
                pesquisaLancamentoCheques.setVisible(true);
                pesquisaLancamentoCheques.pack();
                pesquisaLancamentoCheques.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoCheques.txtBancoCodigo.setText(bancoCodigo);
                pesquisaLancamentoCheques.txtBancoDescricao.setText(bancoDescricao);
                
                this.dispose();
            } else if(pesquisaConsultaCheques != null){
                pesquisaConsultaCheques.setVisible(true);
                pesquisaConsultaCheques.pack();
                pesquisaConsultaCheques.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaConsultaCheques.txtBancoCodigo.setText(bancoCodigo);
                pesquisaConsultaCheques.txtBancoDescricao.setText(bancoDescricao);
                
                this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }                
        conecta.desconecta();
    }//GEN-LAST:event_tblBancosMouseClicked

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
                new PesquisaBancos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBancos;
    // End of variables declaration//GEN-END:variables
}
