package ERP.view;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaLancamentoEstoque extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    private EstoqueEntrada estoqueEntrada;
    private EstoqueSaida estoqueSaida;
 

    public PesquisaLancamentoEstoque() {
        initComponents();
    }

    public void preencherTabela(String Sql, EstoqueEntrada entrada, EstoqueSaida saida) {
        estoqueEntrada = entrada;
        estoqueSaida = saida;
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Planilha", "Lançamento", "Cliente/Fornecedor", "Produto", "Quantidade", "Valor Total"};

        conecta.conexao();
        conecta.executaSql(Sql);         
        try {
            conecta.rs.first(); 
            do {
                dados.add(new Object[]{conecta.rs.getInt("PLANILHA"), formato.format(conecta.rs.getDate("DATALANCAMENTO")), conecta.rs.getString("PESSOADESCRICAO").trim(), conecta.rs.getString("PRODUTODESCRICAO").trim(), conecta.rs.getInt("QUANTIDADE"), conecta.rs.getString("VALORTOTAL")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
            this.dispose();
            conecta.desconecta();
        }

        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblLancamentosEstoque.setModel(table);
        tblLancamentosEstoque.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblLancamentosEstoque.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblLancamentosEstoque.getColumnModel().getColumn(2).setPreferredWidth(180);
        tblLancamentosEstoque.getColumnModel().getColumn(3).setPreferredWidth(180);
        tblLancamentosEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblLancamentosEstoque.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblLancamentosEstoque.getTableHeader().setReorderingAllowed(false);
        tblLancamentosEstoque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conecta.desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblLancamentosEstoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Lançamentos de Estoque");

        tblLancamentosEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Planilha", "Lançamento", "Cliente/Fornecedor", "Produto", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLancamentosEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLancamentosEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLancamentosEstoque);
        if (tblLancamentosEstoque.getColumnModel().getColumnCount() > 0) {
            tblLancamentosEstoque.getColumnModel().getColumn(0).setResizable(false);
            tblLancamentosEstoque.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLancamentosEstoque.getColumnModel().getColumn(1).setResizable(false);
            tblLancamentosEstoque.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLancamentosEstoque.getColumnModel().getColumn(2).setResizable(false);
            tblLancamentosEstoque.getColumnModel().getColumn(2).setPreferredWidth(180);
            tblLancamentosEstoque.getColumnModel().getColumn(3).setResizable(false);
            tblLancamentosEstoque.getColumnModel().getColumn(3).setPreferredWidth(180);
            tblLancamentosEstoque.getColumnModel().getColumn(4).setResizable(false);
            tblLancamentosEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
            tblLancamentosEstoque.getColumnModel().getColumn(5).setResizable(false);
            tblLancamentosEstoque.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLancamentosEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLancamentosEstoqueMouseClicked
        int index = tblLancamentosEstoque.getSelectedRow();
        TableModel model = tblLancamentosEstoque.getModel();
        String planilha = model.getValueAt(index, 0).toString();

        if (estoqueEntrada != null) {
            conecta.conexao();
            try {
                conecta.executaSql("SELECT * FROM ESTOQUE WHERE OPERACAO = '0001' AND PLANILHA = '" + planilha + "'");
                conecta.rs.first();                
                
                this.setVisible(true);
                this.pack();
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              
                estoqueEntrada.txtPlanilha.setText(planilha);
                               
                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String resultadoDataLacamento = formatoString.format(formatoBanco.parse(conecta.rs.getString("DATALANCAMENTO")));
                    estoqueEntrada.txtDataLancamento.setText(resultadoDataLacamento);
                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaLancamentoEstoque.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                estoqueEntrada.txtNotaFiscal.setText(conecta.rs.getString("NOTAFISCAL"));
                estoqueEntrada.txtCodigoPessoa.setText(conecta.rs.getString("PESSOACODIGO"));
                estoqueEntrada.txtDescricaoPessoa.setText(conecta.rs.getString("PESSOADESCRICAO"));

                try {
                    conecta.rs.first();
                    do {
                        DefaultTableModel valores = (DefaultTableModel) estoqueEntrada.tblProdutosEstoque.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("PRODUTOCODIGO"), conecta.rs.getString("PRODUTODESCRICAO").trim(), conecta.rs.getString("QUANTIDADE"), conecta.rs.getString("VALORUNITARIO"), conecta.rs.getString("VALORTOTAL")});
                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
                    this.dispose();           
                    estoqueEntrada.txtProcura.requestFocus();
                    conecta.desconecta();
                }               

                estoqueEntrada.incluindo = 0;
                estoqueEntrada.alterando = 1;
                estoqueEntrada.btnExcluir.setEnabled(true);
                this.dispose();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar lançamentos no estoque! \n ERRO: " + ex);
            }
        } else if (estoqueSaida != null) {
            conecta.conexao();
            try {
                conecta.executaSql("SELECT * FROM ESTOQUE WHERE OPERACAO = '0002' AND PLANILHA = '" + planilha + "'");
                conecta.rs.first();                
                
                this.setVisible(true);
                this.pack();
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
              
                estoqueSaida.txtPlanilha.setText(planilha);
                               
                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String resultadoDataLacamento = formatoString.format(formatoBanco.parse(conecta.rs.getString("DATALANCAMENTO")));
                    estoqueSaida.txtDataLancamento.setText(resultadoDataLacamento);
                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaLancamentoEstoque.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                estoqueSaida.txtNotaFiscal.setText(conecta.rs.getString("NOTAFISCAL"));
                estoqueSaida.txtCodigoPessoa.setText(conecta.rs.getString("PESSOACODIGO"));
                estoqueSaida.txtDescricaoPessoa.setText(conecta.rs.getString("PESSOADESCRICAO"));

                try {
                    conecta.rs.first();
                    do {
                        DefaultTableModel valores = (DefaultTableModel) estoqueSaida.tblProdutosEstoque.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("PRODUTOCODIGO"), conecta.rs.getString("PRODUTODESCRICAO").trim(), conecta.rs.getString("QUANTIDADE"), conecta.rs.getString("VALORUNITARIO"), conecta.rs.getString("VALORTOTAL")});
                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
                    this.dispose();
                    estoqueSaida.txtProcura.requestFocus();
                    conecta.desconecta();
                }
                              
                estoqueSaida.alterando = 1;
                estoqueSaida.incluindo = 0;
                estoqueSaida.btnExcluir.setEnabled(true);
                this.dispose();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar lançamentos no estoque! \n ERRO: " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum lançamento localizado para o produto ou pessoa informado!");
            this.dispose();
        }
        conecta.desconecta();
    }//GEN-LAST:event_tblLancamentosEstoqueMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaLancamentoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaLancamentoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaLancamentoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaLancamentoEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaLancamentoEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLancamentosEstoque;
    // End of variables declaration//GEN-END:variables
}
