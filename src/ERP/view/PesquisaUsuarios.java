package ERP.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaUsuarios extends javax.swing.JFrame {
    ConectaBD conecta = new ConectaBD();    
    private CadastroUsuarios pesquisaUsuarios;    
                
    public PesquisaUsuarios() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Usuários");
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Usuário", "Grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setToolTipText("");
        tblUsuarios.setName("tblUsuarios"); // NOI18N
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void preencherTabela(CadastroUsuarios pesquisa, String Sql){
        this.pesquisaUsuarios = pesquisa;
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Código", "Usuário", "Grupo"};
        
        conecta.conexao();
        conecta.executaSql(Sql);        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("CODIGO"), conecta.rs.getString("USUARIO").trim(), conecta.rs.getString("GRUPO").trim(), conecta.rs.getString("SENHA")});
            }while(conecta.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhum usuário localizado!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblUsuarios.setModel(table);
        tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblUsuarios.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
        tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
        tblUsuarios.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }
    
    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        int index = tblUsuarios.getSelectedRow();
        TableModel model = tblUsuarios.getModel();
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM USUARIOS WHERE USUARIO = '"+index+"'");
        try {
            conecta.rs.first();
            
            String codigo = model.getValueAt(index, 0).toString();
            String usuario = model.getValueAt(index, 1).toString();
            String grupo = model.getValueAt(index, 2).toString();
            String senha = model.getValueAt(index, 3).toString();
            
            pesquisaUsuarios.setVisible(true);
            pesquisaUsuarios.pack();
            pesquisaUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            pesquisaUsuarios.txtCodigo.setText(codigo);
            pesquisaUsuarios.txtUsuario.setText(usuario);
            pesquisaUsuarios.cmbGrupoUsuario.getModel().setSelectedItem(grupo);
            pesquisaUsuarios.txtSenha.setText(senha);
            
            pesquisaUsuarios.alterando = 1;
            pesquisaUsuarios.incluindo = 0;
            pesquisaUsuarios.btnExcluir.setEnabled(true);           
            this.dispose();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }        
        conecta.desconecta();
    }//GEN-LAST:event_tblUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
