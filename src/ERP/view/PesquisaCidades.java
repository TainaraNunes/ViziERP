package ERP.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaCidades extends javax.swing.JFrame {
    ConectaBD conecta = new ConectaBD();    
    private CadastroPessoas pesquisaCadastroPessoas;    
    private CadastroEmpresas pesquisaCadastroEmpresas;

    public PesquisaCidades() {
        initComponents();
   }
    
    public void preencherTabela(CadastroPessoas pesquisaPessoas, CadastroEmpresas pesquisaEmpresas, String Sql){
        pesquisaCadastroPessoas = pesquisaPessoas;
        pesquisaCadastroEmpresas = pesquisaEmpresas;
        
        ArrayList dados = new ArrayList();
        String [] colunas = new String[]{"Código", "Cidade", "Estado", "País"};
        conecta.conexao();
        conecta.executaSql(Sql);
        
        try{
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("CODIGO"), conecta.rs.getString("DESCRICAO"), conecta.rs.getString("UF"), conecta.rs.getString("PAIS")});
            }while(conecta.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Nenhuma cidade localizada!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblCidades.setModel(table);
        tblCidades.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblCidades.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblCidades.getColumnModel().getColumn(1).setPreferredWidth(270);
        tblCidades.getColumnModel().getColumn(1).setResizable(false);
        tblCidades.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblCidades.getColumnModel().getColumn(2).setResizable(false);
        tblCidades.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblCidades.getColumnModel().getColumn(3).setResizable(false);
        tblCidades.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblCidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCidades = new javax.swing.JTable();

        setTitle("Pesquisa de Cidades");
        setResizable(false);

        tblCidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Cidade ", "Estado", "País"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCidades);
        if (tblCidades.getColumnModel().getColumnCount() > 0) {
            tblCidades.getColumnModel().getColumn(0).setResizable(false);
            tblCidades.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblCidades.getColumnModel().getColumn(1).setResizable(false);
            tblCidades.getColumnModel().getColumn(1).setPreferredWidth(270);
            tblCidades.getColumnModel().getColumn(2).setResizable(false);
            tblCidades.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCidades.getColumnModel().getColumn(3).setResizable(false);
            tblCidades.getColumnModel().getColumn(3).setPreferredWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCidadesMouseClicked
        int index = tblCidades.getSelectedRow();
        TableModel model = tblCidades.getModel();
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM CIDADES WHERE DESCRICAO = '"+index+"'");
        try {
            conecta.rs.first();
            
            String cidade = model.getValueAt(index, 1).toString();
            String estado = model.getValueAt(index, 2).toString();
            String pais = model.getValueAt(index, 3).toString();
            
            //Chamada pelo cadastro de pessoas;
            if (pesquisaCadastroPessoas != null) {  
                pesquisaCadastroPessoas.setVisible(true);
                pesquisaCadastroPessoas.pack();
                pesquisaCadastroPessoas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
                pesquisaCadastroPessoas.txtCidade.setText(cidade);
                pesquisaCadastroPessoas.txtEstado.setText(estado);
                pesquisaCadastroPessoas.txtPais.setText(pais);
                
                this.dispose();
            } else if (pesquisaCadastroEmpresas != null){
                pesquisaCadastroEmpresas.setVisible(true);
                pesquisaCadastroEmpresas.pack();
                pesquisaCadastroEmpresas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
                pesquisaCadastroEmpresas.txtCidade.setText(cidade);
                pesquisaCadastroEmpresas.txtEstado.setText(estado);
                pesquisaCadastroEmpresas.txtPais.setText(pais);
                
                this.dispose();
            } 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }        
        conecta.desconecta();

    }//GEN-LAST:event_tblCidadesMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaCidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCidades;
    // End of variables declaration//GEN-END:variables
}
