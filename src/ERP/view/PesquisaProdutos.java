package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
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
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaProdutos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    private CadastroProdutos pesquisaProdutos;
    private EstoqueEntrada pesquisaLancamentoEstoqueEntrada;
    private EstoqueSaida pesquisaLancamentoEstoqueSaida;
    private CadastroServicos pesquisaCadastroServicos;
    private Orcamento pesquisaOrcamento;
    
    public PesquisaProdutos() {
        initComponents();
    }
    
    public void preencherTabela(CadastroProdutos pesquisaCadastro, EstoqueEntrada pesquisaProdutoEntradaEstoque,  EstoqueSaida pesquisaProdutoSaidaEstoque, CadastroServicos pesquisaProdutoCadastroServicos, Orcamento pesquisaPecasOrcamento, String Sql) {
        pesquisaProdutos = pesquisaCadastro;
        pesquisaLancamentoEstoqueEntrada = pesquisaProdutoEntradaEstoque;
        pesquisaLancamentoEstoqueSaida = pesquisaProdutoSaidaEstoque;
        pesquisaCadastroServicos = pesquisaProdutoCadastroServicos;
        pesquisaOrcamento = pesquisaPecasOrcamento;
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "Descrição", "Classificação", "Grupo", "Saldo de Estoque", "Preço de Venda"};

        conecta.conexao();
        conecta.executaSql(Sql);

        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("CODIGO"), conecta.rs.getString("DESCRICAO").trim(), conecta.rs.getString("CLASSIFICACAO").trim(), conecta.rs.getString("GRUPO").trim(), conecta.rs.getString("SALDOESTOQUE"), conecta.rs.getString("PRECOVENDA"), conecta.rs.getString("MARCA"), conecta.rs.getString("CUSTOULTIMACOMPRA"), conecta.rs.getString("DATAULTIMACOMPRA"), conecta.rs.getString("DATAVENCIMENTO"), conecta.rs.getString("ATIVO")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum produto localizado!");
            this.dispose();
            conecta.desconecta();
        }

        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblProdutos.setModel(table);
        tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblProdutos.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblProdutos.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblProdutos.getColumnModel().getColumn(1).setResizable(false);
        tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblProdutos.getColumnModel().getColumn(2).setResizable(false);
        tblProdutos.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblProdutos.getColumnModel().getColumn(3).setResizable(false);
        tblProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblProdutos.getColumnModel().getColumn(4).setResizable(false);
        tblProdutos.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblProdutos.getColumnModel().getColumn(5).setResizable(false);
        tblProdutos.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conecta.desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Produtos");
        setResizable(false);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Classificação", "Grupo", "Saldo de Estoque", "Preço de Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setResizable(false);
            tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProdutos.getColumnModel().getColumn(1).setResizable(false);
            tblProdutos.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblProdutos.getColumnModel().getColumn(2).setResizable(false);
            tblProdutos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblProdutos.getColumnModel().getColumn(3).setResizable(false);
            tblProdutos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblProdutos.getColumnModel().getColumn(4).setResizable(false);
            tblProdutos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblProdutos.getColumnModel().getColumn(5).setResizable(false);
            tblProdutos.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked

        int index = tblProdutos.getSelectedRow();
        TableModel model = tblProdutos.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM PRODUTOS WHERE DESCRICAO = '" + index + "'");
        try {
            conecta.rs.first();
            String codigo = model.getValueAt(index, 0).toString();
            String descricao = model.getValueAt(index, 1).toString();
            String grupo = model.getValueAt(index, 2).toString();
            String subgrupo = model.getValueAt(index, 3).toString();
            String precoVenda = model.getValueAt(index, 5).toString();
            String marca = model.getValueAt(index, 6).toString();
            String custoCompra = model.getValueAt(index, 7).toString();
            
            String dataCompra = "";
            if (model.getValueAt(index, 8) != null){
                dataCompra = model.getValueAt(index, 8).toString();
            }

            String dataVencimento = "";
            if (model.getValueAt(index, 9) != null) {
                dataVencimento = model.getValueAt(index, 9).toString();
            }
            
            String ativo = model.getValueAt(index, 10).toString();
            
            if (pesquisaProdutos != null){
                pesquisaProdutos.setVisible(true);
                pesquisaProdutos.pack();
                pesquisaProdutos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaProdutos.txtCodigo.setText(codigo);
                pesquisaProdutos.txtDescricao.setText(descricao);
                pesquisaProdutos.cmbClassificacao.getModel().setSelectedItem(grupo);
                pesquisaProdutos.cmbGrupo.getModel().setSelectedItem(subgrupo);
                pesquisaProdutos.txtMarca.setText(marca);

                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                pesquisaProdutos.txtPrecoVenda.setText(nf.format(new BigDecimal(precoVenda)));
                pesquisaProdutos.txtCustoCompra.setText(nf.format(new BigDecimal(custoCompra)));

                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String resultadoDataCompra = formatoString.format(formatoBanco.parse(dataCompra));
                    pesquisaProdutos.txtDataUltimaCompra.setText(resultadoDataCompra);

                    if (!dataVencimento.trim().isEmpty()) {
                        String resultadoDataVencimento = formatoString.format(formatoBanco.parse(dataVencimento));
                        pesquisaProdutos.txtDataValidade.setText(resultadoDataVencimento);
                    } else {
                        pesquisaProdutos.txtDataValidade.setText("");
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(ativo.equals("1")){
                    pesquisaProdutos.cbxAtivo.setSelected(true);
                }else{
                    pesquisaProdutos.cbxAtivo.setSelected(false);
                }

                pesquisaProdutos.alterando = 1;
                pesquisaProdutos.incluindo = 0;
                pesquisaProdutos.btnExcluir.setEnabled(true);
                this.dispose();
                
            //Chamada pelo lançamento de entrada em estoque:
            } else if (pesquisaLancamentoEstoqueEntrada != null) { 
                pesquisaLancamentoEstoqueEntrada.setVisible(true);
                pesquisaLancamentoEstoqueEntrada.pack();
                pesquisaLancamentoEstoqueEntrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoEstoqueEntrada.txtCodigoProduto.setText(codigo);
                pesquisaLancamentoEstoqueEntrada.txtDescricaoProduto.setText(descricao);
                this.dispose();
                
            //Chamada pelo lançamento de saída de estoque:
            } else if (pesquisaLancamentoEstoqueSaida != null) { 
                pesquisaLancamentoEstoqueSaida.setVisible(true);
                pesquisaLancamentoEstoqueSaida.pack();
                pesquisaLancamentoEstoqueSaida.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoEstoqueSaida.txtCodigoProduto.setText(codigo);
                pesquisaLancamentoEstoqueSaida.txtDescricaoProduto.setText(descricao);
                this.dispose();
             
            //Chamada pelo cadastro de servicos:
            } else if (pesquisaCadastroServicos != null){
                pesquisaCadastroServicos.setVisible(true);
                pesquisaCadastroServicos.pack();
                pesquisaCadastroServicos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaCadastroServicos.txtCodigoPeca.setText(codigo);
                pesquisaCadastroServicos.txtDescricaoPeca.setText(descricao);
                pesquisaCadastroServicos.btnAdicionarPeca.requestFocus();
                this.dispose();
            
            //Chamada pelo lançamento de peças no orçamento:
            } else if (pesquisaOrcamento != null){
                pesquisaOrcamento.setVisible(true);
                pesquisaOrcamento.pack();
                pesquisaOrcamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaOrcamento.txtCodigoPeca.setText(codigo);
                pesquisaOrcamento.txtDescricaoPeca.setText(descricao);
                
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                pesquisaOrcamento.txtValorUnitarioPeca.setText(nf.format(new BigDecimal(precoVenda)));

                pesquisaOrcamento.btnPesquisarPeca.requestFocus();
                this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tblProdutosMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
