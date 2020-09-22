package ERP.view;

import Relatorios.RelatorioOrcamentosEmitidos;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;
import DAO.DaoFuncoes;
import DAO.DaoOrcamento;

public class PesquisaOrcamentos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    DaoFuncoes funcoes = new DaoFuncoes();
    DaoOrcamento dao  = new DaoOrcamento();
    
    private Orcamento orcamento;
    private Relatorios.RelatorioOrcamentosEmitidos relatorioOrcamentos;
    
    public PesquisaOrcamentos() {
        initComponents();
    }

    public void preencherTabela(java.awt.Frame formulario, String Sql) {        
        if (formulario.getName().equals("frmOrcamento")){
            orcamento = (Orcamento) formulario;
        } else if (formulario.getName().equals("frmRelatorioOrcamentosEmitidos")){
            relatorioOrcamentos = (RelatorioOrcamentosEmitidos) formulario;
        }
        
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataAbertura, dataValidade;
                
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Orcamento", "Cliente", "Abertura", "Validade", "Situação"};
        conecta.conexao();
        conecta.executaSql(Sql);

        try {
            conecta.rs.first();
            do {
                dataAbertura = formato.format(conecta.rs.getDate("DATAABERTURA"));
                dataValidade = formato.format(conecta.rs.getDate("DATAVALIDADE"));
                String orcamentoNumero = String.valueOf(String.format("%06d", conecta.rs.getInt("NUMERO")));
                
                dados.add(new Object[]{orcamentoNumero, conecta.rs.getString("RAZAOSOCIAL").trim(), dataAbertura, dataValidade, conecta.rs.getString("SITUACAO"), 
                                       conecta.rs.getString("CLIENTECODIGO"), conecta.rs.getString("VALORTOTALSERVICOS"), conecta.rs.getString("VALORDESCONTOSERVICOS"), 
                                       conecta.rs.getString("VALORTOTALORCAMENTO"), conecta.rs.getString("FORMAPAGAMENTO"), conecta.rs.getString("OBSERVACOES"), 
                                       conecta.rs.getString("VERSAO"), conecta.rs.getString("VALORTOTALPECAS"), conecta.rs.getString("VALORDESCONTOSPECAS")}); 
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum orçamento localizado!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblOrcamentos.setModel(table);
        tblOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(20); 
        tblOrcamentos.getColumnModel().getColumn(0).setResizable(false); 
        tblOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(200); 
        tblOrcamentos.getColumnModel().getColumn(1).setResizable(false); 
        tblOrcamentos.getColumnModel().getColumn(2).setPreferredWidth(10); 
        tblOrcamentos.getColumnModel().getColumn(2).setResizable(false); 
        tblOrcamentos.getColumnModel().getColumn(3).setPreferredWidth(10); 
        tblOrcamentos.getColumnModel().getColumn(3).setResizable(false); 
        tblOrcamentos.getColumnModel().getColumn(4).setPreferredWidth(5); 
        tblOrcamentos.getColumnModel().getColumn(4).setResizable(false); 

        tblOrcamentos.getTableHeader().setReorderingAllowed(false); 
        tblOrcamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrcamentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Orçamentos");

        tblOrcamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orçamento", "Cliente", "Abertura", "Validade", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrcamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrcamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrcamentos);
        if (tblOrcamentos.getColumnModel().getColumnCount() > 0) {
            tblOrcamentos.getColumnModel().getColumn(0).setResizable(false);
            tblOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblOrcamentos.getColumnModel().getColumn(1).setResizable(false);
            tblOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblOrcamentos.getColumnModel().getColumn(2).setResizable(false);
            tblOrcamentos.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblOrcamentos.getColumnModel().getColumn(3).setResizable(false);
            tblOrcamentos.getColumnModel().getColumn(3).setPreferredWidth(10);
            tblOrcamentos.getColumnModel().getColumn(4).setResizable(false);
            tblOrcamentos.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrcamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrcamentosMouseClicked
        int index = tblOrcamentos.getSelectedRow();
        TableModel model = tblOrcamentos.getModel();
        
        conecta.conexao();
        try {
            conecta.rs.first();            
            String orcamentoNumero = model.getValueAt(index, 0).toString().trim();
            String clienteDescricao = model.getValueAt(index, 1).toString().trim();
            String dataAbertura = model.getValueAt(index, 2).toString();            
            String dataValidade = model.getValueAt(index, 3).toString();
            String situacao = model.getValueAt(index, 4).toString();
            String clienteCodigo = model.getValueAt(index, 5).toString();
            String valorTotalServicos = model.getValueAt(index, 6).toString();
            String valorDescontosServicos = model.getValueAt(index, 7).toString();
            String valorTotalOrcamento = model.getValueAt(index, 8).toString();
            String formaPagamento = model.getValueAt(index, 9).toString();
            String observacoes = (String) model.getValueAt(index, 10);
            String versaoOrcamento = model.getValueAt(index, 11).toString();
            String valorTotalPecas = model.getValueAt(index, 12).toString();
            String valorDescontosPecas = model.getValueAt(index, 13).toString().trim();
                       
            //Chamada pelo lançamento de orçamentos:            
            if (orcamento != null) {
                orcamento.setVisible(true);
                orcamento.pack();
                orcamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                if (situacao.trim().equals("APROVADO")) {
                    conecta.conexao();
                    conecta.executaSql("SELECT * FROM CONTASRECEBER  WHERE ORCAMENTO = '" + orcamentoNumero + "' ");
                    try {
                        if (conecta.rs.first()) {
                            JOptionPane.showMessageDialog(rootPane, "Orçamento já está aprovado e com financeiro gerado! \n"
                                                                  + "Caso deseje alterar o orçamento, elimine os lançamentos financeiros. ");

                            orcamento.btnGravar.setEnabled(false);
                            orcamento.btnAprovarOrcamento.setEnabled(false);
                            orcamento.btnCancelarOrcamento.setEnabled(false); 
                        } 
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao consultar número do orçamento! \n ERRO: " + ex);
                    }
                } 

                if (situacao.trim().equals("CANCELADO")) {
                    int resposta = 0;
                    resposta = JOptionPane.showConfirmDialog(rootPane, "Orçamento está cancelado. Deseja reabrir?");
                    //Caso selecione sim, habilita o botão gravar e quando gravar altera a situação para aberto;
                    if (resposta == JOptionPane.NO_OPTION) {
                        orcamento.btnGravar.setEnabled(false);
                        orcamento.btnAprovarOrcamento.setEnabled(false);
                        orcamento.btnCancelarOrcamento.setEnabled(false);                         
                    } 
                }
                
                orcamento.txtOrcamentoNumero.setText(orcamentoNumero);
                orcamento.txtClienteDescricao.setText(clienteDescricao);
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");                 
                try {
                    orcamento.dataAbertura = formato.parse(dataAbertura);
                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaOrcamentos.class.getName()).log(Level.SEVERE, null, ex);
                }
                orcamento.txtDataValidadeOrcamento.setText(dataValidade);
                orcamento.txtVersaoOrcamento.setText(versaoOrcamento); 
                orcamento.txtClienteCodigo.setText(clienteCodigo);                 
                
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                orcamento.txtValorTotalServicos.setText(nf.format(new BigDecimal(valorTotalServicos)).replace("R$", "").trim());                
                orcamento.txtValorTotalServicosFechamento.setText(nf.format(new BigDecimal(valorTotalServicos)).replace("R$", "").trim()); 
                orcamento.txtValorDescontoServicos.setText(nf.format(new BigDecimal(valorDescontosServicos)).replace("R$", "").trim()); 
                if (orcamento.txtValorTotalServicosFechamento.getText().equals("0,00")){
                     orcamento.txtPercentualDescontoServicos.setText("0,00");
                     orcamento.txtValorDescontoServicos.setText("0,00");
                } else {
                    BigDecimal percentualDescontoServicos = new BigDecimal(BigInteger.ZERO);
                    BigDecimal valorDescontoServicos = new BigDecimal(valorDescontosServicos);                    
                    BigDecimal valorServicos = new BigDecimal(valorTotalServicos);                    
                    percentualDescontoServicos = valorDescontoServicos.multiply(BigDecimal.valueOf(100)).divide(valorServicos);   
                    orcamento.txtPercentualDescontoServicos.setText(percentualDescontoServicos.toString().replace(".", ","));
                }                
                
                orcamento.txtValorTotalPecas.setText(nf.format(new BigDecimal(valorTotalPecas)).replace("R$", "").trim());                
                orcamento.txtValorTotalPecasFechamento.setText(nf.format(new BigDecimal(valorTotalPecas)).replace("R$", "").trim()); 
                orcamento.txtValorDescontoPecas.setText(nf.format(new BigDecimal(valorDescontosPecas)).replace("R$", "").trim()); 
                if (orcamento.txtValorTotalPecasFechamento.getText().equals("0,00")){
                     orcamento.txtPercentualDescontoPecas.setText("0,00");
                     orcamento.txtValorDescontoPecas.setText("0,00");
                } else {
                    BigDecimal percentualDescontoPecas = new BigDecimal(BigInteger.ZERO);
                    BigDecimal valorDescontoPecas = new BigDecimal(valorDescontosPecas);                    
                    BigDecimal valorPecas = new BigDecimal(valorTotalPecas);                    
                    percentualDescontoPecas = valorDescontoPecas.multiply(BigDecimal.valueOf(100)).divide(valorPecas);   
                    orcamento.txtPercentualDescontoPecas.setText(percentualDescontoPecas.toString().replace(".", ","));                        
                }
                
                orcamento.txtValorTotalOrcamento.setText(nf.format(new BigDecimal(valorTotalOrcamento)).replace("R$", ""));
                orcamento.cmbFormaPagamento.getModel().setSelectedItem(formaPagamento);  
                orcamento.txtObservacoes.setText(observacoes);

                //Carrega os serviços do orçamento:
                conecta.conexao();
                conecta.executaSql("SELECT SERVICOS.DESCRICAO AS SERVICODESCRICAO,     "
                                 + "       ORCAMENTOSSERVICOS.QUANTIDADECOMPARTIMENTOS, "
                                 + "       ORCAMENTOSSERVICOS.VALORUNITARIOSERVICO,     "
                                 + "       ORCAMENTOSSERVICOS.VALORTOTALSERVICO,        "
                                 + "       ORCAMENTOSSERVICOS.SERVICOCODIGO             "                        
                                 + "FROM ORCAMENTOSSERVICOS "
                                 + "JOIN SERVICOS ON(SERVICOS.CODIGO = ORCAMENTOSSERVICOS.SERVICOCODIGO) "
                                 + "WHERE ORCAMENTONUMERO = " + orcamentoNumero + " ");
                try {
                    conecta.rs.first();
                    do {
                        DefaultTableModel valores = (DefaultTableModel) orcamento.tblServicos.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("SERVICODESCRICAO").trim(), conecta.rs.getString("QUANTIDADECOMPARTIMENTOS"), conecta.rs.getString("VALORUNITARIOSERVICO"), conecta.rs.getString("VALORTOTALSERVICO"), conecta.rs.getString("SERVICOCODIGO")});
                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    //JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento de serviços localizado para o orçamento!");
                    conecta.desconecta();
                }

                //Carrega as peças do orçamento:
                conecta.conexao();
                conecta.executaSql("SELECT PRODUTOS.DESCRICAO AS PECADESCRICAO,   "
                                 + "       ORCAMENTOSPECAS.QUANTIDADE,            "
                                 + "       ORCAMENTOSPECAS.VALORUNITARIOPECA,     "
                                 + "       ORCAMENTOSPECAS.VALORTOTALPECA,        "
                                 + "       ORCAMENTOSPECAS.PECACODIGO             "                        
                                 + "FROM ORCAMENTOSPECAS "
                                 + "JOIN PRODUTOS ON(PRODUTOS.CODIGO = ORCAMENTOSPECAS.PECACODIGO) "
                                 + "WHERE ORCAMENTONUMERO = " + orcamentoNumero + " ");
                try {
                    conecta.rs.first();
                    do {
                        DefaultTableModel valores = (DefaultTableModel) orcamento.tblPecas.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("PECADESCRICAO").trim(), conecta.rs.getString("QUANTIDADE"), conecta.rs.getString("VALORUNITARIOPECA"), conecta.rs.getString("VALORTOTALPECA"), conecta.rs.getString("PECACODIGO")});
                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    //JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento de peças localizado para o orçamento!");
                    conecta.desconecta();
                }
                
                //Carrega as parcelas de pagamento do orçamento:
                conecta.conexao();
                conecta.executaSql("SELECT ORCAMENTOSFINANCEIRO.PARCELANUMERO,   "
                                 + "       ORCAMENTOSFINANCEIRO.PARCELACONDICAO, "
                                 + "       ORCAMENTOSFINANCEIRO.VENCIMENTO,        "
                                 + "       ORCAMENTOSFINANCEIRO.PARCELAVALOR       "
                                 + "FROM ORCAMENTOSFINANCEIRO "
                                 + "WHERE ORCAMENTONUMERO = " + orcamentoNumero + " ");
                try {
                    conecta.rs.first();
                    do {
                        String vencimentoParcela = formato.format(conecta.rs.getDate("VENCIMENTO"));                        
                        DefaultTableModel valores = (DefaultTableModel) orcamento.tblPagamentos.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("PARCELANUMERO"), conecta.rs.getString("PARCELACONDICAO"), vencimentoParcela, conecta.rs.getString("PARCELAVALOR")});
                        orcamento.txtNumeroParcelas.setText(conecta.rs.getString("PARCELANUMERO")); 
                    } while (conecta.rs.next());                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento financeiro localizado para o orçamento!");
                    conecta.desconecta();
                }

                orcamento.incluindo = 0;
                orcamento.alterando = 1;            
                this.dispose();
                return;                
            } else if (relatorioOrcamentos != null) {                
                relatorioOrcamentos.setVisible(true);
                relatorioOrcamentos.pack();
                relatorioOrcamentos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                relatorioOrcamentos.txtOrcamento.setText(orcamentoNumero);                
                
                this.dispose();
                return;
            }             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados do orçamento! \n" + ex);
        }            
        conecta.desconecta();          
    }//GEN-LAST:event_tblOrcamentosMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaOrcamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaOrcamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrcamentos;
    // End of variables declaration//GEN-END:variables
}
