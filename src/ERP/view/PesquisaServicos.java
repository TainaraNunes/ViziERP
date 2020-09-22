package ERP.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;
import DAO.DaoServicos;

public class PesquisaServicos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();    
    DaoServicos dao = new DaoServicos();
    
    private CadastroServicos pesquisaCadastroServicos;    
    private CadastroServicos pesquisaServicosLista;    
    private Orcamento pesquisaOrcamento;

    public PesquisaServicos() {
        initComponents();
    }
    
    public void preencherTabela(java.awt.Frame parent, String botao, String Sql){
        if (parent.getName().equals("frmCadastroServicos") && botao.equals("btnPesquisarServico")){
            pesquisaCadastroServicos = (CadastroServicos) parent;
        } else if (parent.getName().equals("frmCadastroServicos") && botao.equals("btnPesquisarServicoLista")){
            pesquisaServicosLista = (CadastroServicos) parent;            
        } else if (parent.getName().equals("frmOrcamento")){
             pesquisaOrcamento = (Orcamento) parent;
        } 
        
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Código", "Descrição"};
        
        conecta.conexao();
        conecta.executaSql(Sql);        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("CODIGO"), conecta.rs.getString("DESCRICAO").trim()});
            }while(conecta.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhum serviço localizado!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblServicos.setModel(table);
        tblServicos.getColumnModel().getColumn(0).setPreferredWidth(10); 
        tblServicos.getColumnModel().getColumn(0).setResizable(false); 
        tblServicos.getColumnModel().getColumn(1).setPreferredWidth(350);
        tblServicos.getColumnModel().getColumn(1).setResizable(false);
        tblServicos.getTableHeader().setReorderingAllowed(false); 
        tblServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
        conecta.desconecta();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Serviços");

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicos);
        if (tblServicos.getColumnModel().getColumnCount() > 0) {
            tblServicos.getColumnModel().getColumn(0).setResizable(false);
            tblServicos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblServicos.getColumnModel().getColumn(1).setResizable(false);
            tblServicos.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicosMouseClicked
        int index = tblServicos.getSelectedRow();
        TableModel model = tblServicos.getModel();
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM SERVICOS WHERE DESCRICAO = '"+index+"'");
        try {
            conecta.rs.first();
            
            String codigoServico = model.getValueAt(index, 0).toString();
            String descricaoServico = model.getValueAt(index, 1).toString();
                        
            if (pesquisaCadastroServicos != null){
                pesquisaCadastroServicos.txtCodigoServico.setText(codigoServico);
                pesquisaCadastroServicos.txtDescricaoServico.setText(descricaoServico);

                pesquisaCadastroServicos.setVisible(true);
                pesquisaCadastroServicos.pack();
                pesquisaCadastroServicos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaCadastroServicos.alterando = 1;
                pesquisaCadastroServicos.incluindo = 0;
                pesquisaCadastroServicos.btnExcluir.setEnabled(true);           
                this.dispose();
                
                consultarListaPecasServico(Integer.parseInt(codigoServico), pesquisaCadastroServicos); 
                consultarListaServicos(Integer.parseInt(codigoServico), pesquisaCadastroServicos);                 
                
            } else if (pesquisaServicosLista != null){
                pesquisaServicosLista.txtCodigoServicoLista.setText(codigoServico);
                pesquisaServicosLista.txtDescricaoServicoLista.setText(descricaoServico);

                pesquisaServicosLista.setVisible(true);
                pesquisaServicosLista.pack();
                pesquisaServicosLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                this.dispose();
                
            } else if (pesquisaOrcamento != null){
                pesquisaOrcamento.setVisible(true);
                pesquisaOrcamento.pack(); 
                pesquisaOrcamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaOrcamento.txtCodigoServico.setText(codigoServico);
                pesquisaOrcamento.txtDescricaoServico.setText(descricaoServico); 
                
                this.dispose();
            }    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }        
        conecta.desconecta();
    }//GEN-LAST:event_tblServicosMouseClicked

    public void consultarListaPecasServico(int codigoServico, CadastroServicos servico){
        conecta.conexao();
        conecta.executaSql("SELECT * FROM SERVICOLISTAPECAS WHERE CODIGOSERVICO = " + codigoServico + " ");
        try {
            if (conecta.rs.next()){
                conecta.rs.first();
                do {
                    DefaultTableModel valores = (DefaultTableModel) servico.tblListaPecas.getModel();
                    valores.addRow(new Object[]{conecta.rs.getInt("QUANTIDADEPECA"), conecta.rs.getInt("CODIGOPECA"), conecta.rs.getString("DESCRICAOPECA").trim()});
                } while (conecta.rs.next()); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar lista de peças do serviço! \n ERRO: " + ex);
        }
    }
    
    public void consultarListaServicos(int codigoServico, CadastroServicos servico){
        conecta.conexao();
        conecta.executaSql("SELECT SERVICOSLISTASERVICOS.CODIGOSERVICOPRINCIPAL,  "
                         + "       SERVICOSLISTASERVICOS.CODIGOSERVICOLISTA, "
                         + "       (SELECT SERVICOS.DESCRICAO "
                         + "        FROM SERVICOS "
                         + "        WHERE SERVICOS.CODIGO = SERVICOSLISTASERVICOS.CODIGOSERVICOLISTA) "
                         + "FROM SERVICOSLISTASERVICOS "
                         + "JOIN SERVICOS ON(SERVICOS.CODIGO = SERVICOSLISTASERVICOS.CODIGOSERVICOPRINCIPAL) "   
                         + "WHERE CODIGOSERVICOPRINCIPAL = " + codigoServico + " ");
        try {
            if (conecta.rs.next()){
                conecta.rs.first();
                do {
                    DefaultTableModel valores = (DefaultTableModel) servico.tblListaServicos.getModel();
                    valores.addRow(new Object[]{conecta.rs.getInt("CODIGOSERVICOLISTA"), conecta.rs.getString("DESCRICAO").trim()});
                } while (conecta.rs.next()); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar lista de serviços do serviço! \n ERRO: " + ex);
        }
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
            java.util.logging.Logger.getLogger(PesquisaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicos;
    // End of variables declaration//GEN-END:variables
}
