
package ERP.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaCategoriasFinanceiro extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();    
    private CadastroCategoriasFinanceiro pesquisaCategorias;

    public PesquisaCategoriasFinanceiro() {
        initComponents();
    }

    public void preencherTabela(CadastroCategoriasFinanceiro pesquisa, String Sql){
        pesquisaCategorias = pesquisa;
        
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Código", "Categoria", "Movimento"};
        
        conecta.conexao();
        conecta.executaSql(Sql);
        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("CODIGO"), conecta.rs.getString("DESCRICAO").trim(), conecta.rs.getString("TIPOMOVIMENTO")});
            }while(conecta.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhuma categoria localizada!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblPesquisaCategoria.setModel(table);
        tblPesquisaCategoria.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblPesquisaCategoria.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblPesquisaCategoria.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblPesquisaCategoria.getColumnModel().getColumn(1).setResizable(false);
        tblPesquisaCategoria.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblPesquisaCategoria.getColumnModel().getColumn(2).setResizable(false);
        tblPesquisaCategoria.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblPesquisaCategoria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisaCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Categorias");

        tblPesquisaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Categoria", "Movimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPesquisaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisaCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisaCategoria);
        if (tblPesquisaCategoria.getColumnModel().getColumnCount() > 0) {
            tblPesquisaCategoria.getColumnModel().getColumn(0).setResizable(false);
            tblPesquisaCategoria.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblPesquisaCategoria.getColumnModel().getColumn(1).setResizable(false);
            tblPesquisaCategoria.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblPesquisaCategoria.getColumnModel().getColumn(2).setResizable(false);
            tblPesquisaCategoria.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPesquisaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisaCategoriaMouseClicked
        int index = tblPesquisaCategoria.getSelectedRow();
        TableModel model = tblPesquisaCategoria.getModel();
        
        conecta.conexao();

        try {
            conecta.rs.first();
            
            String categoriaCodigo = model.getValueAt(index, 0).toString();
            String categoriaDescricao = model.getValueAt(index, 1).toString();
            String tipoMovimento = model.getValueAt(index, 2).toString();
            
            pesquisaCategorias.setVisible(true);
            pesquisaCategorias.pack();
            pesquisaCategorias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            pesquisaCategorias.txtCodigo.setText(categoriaCodigo);
            pesquisaCategorias.txtCategoriaDescricao.setText(categoriaDescricao);
            
            if (tipoMovimento.equals("P")) {
                pesquisaCategorias.rbtContasPagar.setSelected(true);
            } else if (tipoMovimento.equals("R")) {
                pesquisaCategorias.rbtContasReceber.setSelected(true);
            }

            pesquisaCategorias.alterando = 1;
            pesquisaCategorias.incluindo = 0;
            pesquisaCategorias.btnExcluir.setEnabled(true);           
            this.dispose();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }                
        conecta.desconecta();            
    }//GEN-LAST:event_tblPesquisaCategoriaMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaCategoriasFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCategoriasFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCategoriasFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCategoriasFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaCategoriasFinanceiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPesquisaCategoria;
    // End of variables declaration//GEN-END:variables
}
