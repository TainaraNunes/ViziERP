package ERP.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;

public class PesquisaPessoas extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    private CadastroPessoas pesquisaCadastroPessoas;
    private EstoqueEntrada pesquisaLancamentoEstoqueEntrada;
    private EstoqueSaida pesquisaLancamentoEstoqueSaida;
    private LancamentoContasReceber pesquisaLancamentoContasReceber;
    private LancamentoContasPagar pesquisaLancamentoContasPagar;
    private LancamentoCaixa pesquisaLancamentoCaixa;
    private DespesasVeiculos pesquisaDespesasVeiculos;
    private Orcamento pesquisaOrcamento;

    public PesquisaPessoas() {
        initComponents();
    }

    public void preencherTabela(java.awt.Frame parent, String Sql) {
    //public void preencherTabela(CadastroPessoas pesquisaCadastro, EstoqueEntrada pesquisaPessoaEntradaEstoque, EstoqueSaida pesquisaPessoaSaidaEstoque, LancamentoContasReceber pesquisaContasReceber, LancamentoContasPagar pesquisaContasPagar, LancamentoCaixa pesquisaCaixa, CotacaoPrecos pesquisaCotacao, String Sql) {
        if (parent.getName().equals("frmCadastroPessoas")){
            pesquisaCadastroPessoas = (CadastroPessoas) parent;
        } else if (parent.getName().equals("frmEstoqueEntrada")){
             pesquisaLancamentoEstoqueEntrada = (EstoqueEntrada) parent;
        } else if (parent.getName().equals("frmEstoqueSaida")){
             pesquisaLancamentoEstoqueSaida = (EstoqueSaida) parent;
        } else if (parent.getName().equals("frmLancamentoCaixa")){
             pesquisaLancamentoCaixa = (LancamentoCaixa) parent;
        } else if (parent.getName().equals("frmLancamentoContasPagar")){
             pesquisaLancamentoContasPagar = (LancamentoContasPagar) parent;
        } else if (parent.getName().equals("frmLancamentoContasReceber")){
             pesquisaLancamentoContasReceber = (LancamentoContasReceber) parent;
        } else if (parent.getName().equals("frmDespesasVeiculos")){
             pesquisaDespesasVeiculos = (DespesasVeiculos) parent;
        } else if (parent.getName().equals("frmOrcamento")){
             pesquisaOrcamento = (Orcamento) parent;
        }        
    
        String cpfcnppj = "", telefonecelular = "";
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Código", "CNPJ/CPF", "Nome", "Cidade", "Estado", "Telefone"};
        
        conecta.conexao();
        conecta.executaSql(Sql);
           try {
            conecta.rs.first();
            do {
                if (conecta.rs.getString("CNPJ").trim().length() == 18) {
                    cpfcnppj = conecta.rs.getString("CNPJ");
                } else {
                    cpfcnppj = conecta.rs.getString("CPF");
                }
                
                if (conecta.rs.getString("TELEFONE").trim().length() == 13) {
                    telefonecelular = conecta.rs.getString("TELEFONE");
                } else {
                    telefonecelular = conecta.rs.getString("CELULAR");
                }
                
                dados.add(new Object[]{conecta.rs.getInt("CODIGO"), cpfcnppj, conecta.rs.getString("RAZAOSOCIAL").trim(), conecta.rs.getString("CIDADE").trim(), conecta.rs.getString("ESTADO"), 
                                       telefonecelular, conecta.rs.getString("FANTASIA").trim(), conecta.rs.getString("CPF"), conecta.rs.getString("RG"), conecta.rs.getString("INSCRICAOESTADUAL"), 
                                       conecta.rs.getString("ENDERECO").trim(), conecta.rs.getString("NUMERO"), conecta.rs.getString("BAIRRO").trim(), conecta.rs.getString("CEP"), conecta.rs.getString("PAIS"), 
                                       conecta.rs.getString("CELULAR"), conecta.rs.getString("EMAIL").trim(), conecta.rs.getString("TIPOPESSOA").trim(), conecta.rs.getString("ATIVIDADE").trim()}); 
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum cadastro localizado!");
            this.dispose();
            conecta.desconecta();
        }

        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblPessoas.setModel(table);
        tblPessoas.getColumnModel().getColumn(0).setPreferredWidth(50); //tamanho da coluna;
        tblPessoas.getColumnModel().getColumn(0).setResizable(false); //não permite alterar o tamanho com o mouse;
        tblPessoas.getColumnModel().getColumn(1).setPreferredWidth(125);
        tblPessoas.getColumnModel().getColumn(1).setResizable(false);
        tblPessoas.getColumnModel().getColumn(2).setPreferredWidth(250);
        tblPessoas.getColumnModel().getColumn(2).setResizable(false);
        tblPessoas.getColumnModel().getColumn(3).setPreferredWidth(160);
        tblPessoas.getColumnModel().getColumn(3).setResizable(false);
        tblPessoas.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblPessoas.getColumnModel().getColumn(4).setResizable(false);
        tblPessoas.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblPessoas.getColumnModel().getColumn(5).setResizable(false);
        tblPessoas.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conecta.desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPessoas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Pessoas");
        setResizable(false);

        tblPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "CNPJ/CPF", "Nome", "Cidade", "Estado", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblPessoas, org.jdesktop.beansbinding.ObjectProperty.create(), tblPessoas, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);
        binding.bind();
        tblPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPessoas);
        if (tblPessoas.getColumnModel().getColumnCount() > 0) {
            tblPessoas.getColumnModel().getColumn(0).setResizable(false);
            tblPessoas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblPessoas.getColumnModel().getColumn(1).setResizable(false);
            tblPessoas.getColumnModel().getColumn(1).setPreferredWidth(125);
            tblPessoas.getColumnModel().getColumn(2).setResizable(false);
            tblPessoas.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblPessoas.getColumnModel().getColumn(3).setResizable(false);
            tblPessoas.getColumnModel().getColumn(3).setPreferredWidth(160);
            tblPessoas.getColumnModel().getColumn(4).setResizable(false);
            tblPessoas.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblPessoas.getColumnModel().getColumn(5).setResizable(false);
            tblPessoas.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPessoasMouseClicked
        int index = tblPessoas.getSelectedRow();
        TableModel model = tblPessoas.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM PESSOAS WHERE RAZAOSOCIAL = '" + index + "'");
        try {
            conecta.rs.first();

            String codigo = model.getValueAt(index, 0).toString();
            String cnpj = model.getValueAt(index, 1).toString();
            String razaoSocial = model.getValueAt(index, 2).toString();
            String cidade = model.getValueAt(index, 3).toString();
            String estado = model.getValueAt(index, 4).toString();
            String telefone = model.getValueAt(index, 5).toString();
            String fantasia = model.getValueAt(index, 6).toString();
            String cpf = model.getValueAt(index, 7).toString();
            String rg = model.getValueAt(index, 8).toString();
            String inscricaoEstadual = model.getValueAt(index, 9).toString();
            String endereco = model.getValueAt(index, 10).toString();
            String numero = model.getValueAt(index, 11).toString();
            String bairro = model.getValueAt(index, 12).toString();
            String cep = model.getValueAt(index, 13).toString();
            String pais = model.getValueAt(index, 14).toString();
            String celular = model.getValueAt(index, 15).toString();
            String email = model.getValueAt(index, 16).toString();
            String tipoPessoa = model.getValueAt(index, 17).toString();
            String atividade = model.getValueAt(index, 18).toString();
            
            //Chamada pelo cadastro de pessoas;
            if (pesquisaCadastroPessoas != null) { 
                pesquisaCadastroPessoas.setVisible(true);
                pesquisaCadastroPessoas.pack();
                pesquisaCadastroPessoas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaCadastroPessoas.txtCodigo.setText(codigo);
                pesquisaCadastroPessoas.txtCnpj.setText(cnpj);
                pesquisaCadastroPessoas.txtRazaoSocial.setText(razaoSocial);
                pesquisaCadastroPessoas.txtCidade.setText(cidade);
                pesquisaCadastroPessoas.txtEstado.setText(estado);
                pesquisaCadastroPessoas.txtTelefone.setText(telefone);
                pesquisaCadastroPessoas.txtFantasia.setText(fantasia);
                pesquisaCadastroPessoas.txtCpf.setText(cpf);
                pesquisaCadastroPessoas.txtRg.setText(rg);
                pesquisaCadastroPessoas.txtInscricaoEstadual.setText(inscricaoEstadual);
                pesquisaCadastroPessoas.txtEndereco.setText(endereco);
                pesquisaCadastroPessoas.txtNumero.setText(numero);
                pesquisaCadastroPessoas.txtBairro.setText(bairro);
                pesquisaCadastroPessoas.txtCep.setText(cep);
                pesquisaCadastroPessoas.txtPais.setText(pais);
                pesquisaCadastroPessoas.txtCelular.setText(celular);
                pesquisaCadastroPessoas.txtEmail.setText(email);
                pesquisaCadastroPessoas.cmbTipoPessoa.getModel().setSelectedItem(tipoPessoa);
                pesquisaCadastroPessoas.txtAtividade.setText(atividade);

                conecta.conexao();
                conecta.executaSql("SELECT * FROM CLIENTESDADOSTECNICOS WHERE CLIENTECODIGO = " + codigo + " ");

                try {
                    //Se tiver registro de dados técnicos carrega os dados se não só continua;
                    if (conecta.rs.first()) {
                        pesquisaCadastroPessoas.txtContatoResponsavel.setText(conecta.rs.getString("CONTATORESPONSAVEL").trim());
                        pesquisaCadastroPessoas.txtTanquesQuantidade.setText(conecta.rs.getString("TANQUESQUANTIDADE"));
                        
                        if (conecta.rs.getString("TANQUESMARCA1").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbTanquesMarca1.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbTanquesMarca1.getModel().setSelectedItem(conecta.rs.getString("TANQUESMARCA1").trim());
                        }
                        
                        if (conecta.rs.getString("TANQUESMARCA2").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbTanquesMarca2.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbTanquesMarca2.getModel().setSelectedItem(conecta.rs.getString("TANQUESMARCA2").trim());
                        }
                        
                        pesquisaCadastroPessoas.txtCompartimentosQuantidade.setText(conecta.rs.getString("COMPARTIMENTOSQUANTIDADE"));
                        pesquisaCadastroPessoas.txtBombasQuantidade.setText(conecta.rs.getString("BOMBASQUANTIDADE"));
                        
                        if (conecta.rs.getString("BOMBASMARCA1").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbBombasMarca1.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbBombasMarca1.getModel().setSelectedItem(conecta.rs.getString("BOMBASMARCA1").trim());
                        }
                        
                        if (conecta.rs.getString("BOMBASMARCA2").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbBombasMarca2.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbBombasMarca2.getModel().setSelectedItem(conecta.rs.getString("BOMBASMARCA2").trim());
                        }
                        
                        pesquisaCadastroPessoas.txtFiltrosQuantidade.setText(conecta.rs.getString("FILTROSQUANTIDADE"));
                        
                        if (conecta.rs.getString("FILTROSMODELO1").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbFiltrosModelo1.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbFiltrosModelo1.getModel().setSelectedItem(conecta.rs.getString("FILTROSMODELO1").trim());
                        }
                        
                        if (conecta.rs.getString("FILTROSMODELO2").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbFiltrosModelo2.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbFiltrosModelo2.getModel().setSelectedItem(conecta.rs.getString("FILTROSMODELO2").trim());
                        }
                        
                        if (conecta.rs.getString("FILTROSMODELO3").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbFiltrosModelo3.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbFiltrosModelo3.getModel().setSelectedItem(conecta.rs.getString("FILTROSMODELO3").trim());
                        }
                        
                        if (conecta.rs.getString("EQUIPAMENTOAMBIENTAL").trim().equals("")) {
                            pesquisaCadastroPessoas.cmbEquipamentoAmbiental.getModel().setSelectedItem("SELECIONE");
                        } else {
                            pesquisaCadastroPessoas.cmbEquipamentoAmbiental.getModel().setSelectedItem(conecta.rs.getString("EQUIPAMENTOAMBIENTAL").trim());
                        }
            
                        SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            if (conecta.rs.getDate("VENCIMENTOLICENCAOPERACAO") != null) {
                                String dataVencimento = conecta.rs.getDate("VENCIMENTOLICENCAOPERACAO").toString();
                                String resultadoDataVencimento = formatoString.format(formatoBanco.parse(dataVencimento));
                                pesquisaCadastroPessoas.txtVencimentoLicenca.setText(resultadoDataVencimento);
                            } else {
                                pesquisaCadastroPessoas.txtVencimentoLicenca.setText("");
                            }
                            
                            
                            if (conecta.rs.getDate("DATAFABRICACAOTANQUE") != null) {
                                String dataFabricacaoTanque = conecta.rs.getDate("DATAFABRICACAOTANQUE").toString();
                                String resultadoDataFabricacaoTanque = formatoString.format(formatoBanco.parse(dataFabricacaoTanque));
                                pesquisaCadastroPessoas.txtDataFabricacaoTanque.setText(resultadoDataFabricacaoTanque);
                            } else {
                                pesquisaCadastroPessoas.txtDataFabricacaoTanque.setText("");
                            }                            
                            
                            
                            if (conecta.rs.getDate("DATAFABRICACAOBOMBA") != null) {
                                String dataFabricacaoBomba = conecta.rs.getDate("DATAFABRICACAOBOMBA").toString();
                                String resultadoDataFabricacaoBomba = formatoString.format(formatoBanco.parse(dataFabricacaoBomba));
                                pesquisaCadastroPessoas.txtDataFabricacaoBomba.setText(resultadoDataFabricacaoBomba);
                            } else {
                                pesquisaCadastroPessoas.txtDataFabricacaoBomba.setText("");
                            }                               
                        } catch (ParseException ex) {
                            Logger.getLogger(PesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        pesquisaCadastroPessoas.alterando = 1;
                        pesquisaCadastroPessoas.incluindo = 0;
                        pesquisaCadastroPessoas.btnExcluir.setEnabled(true);
                        this.dispose();                        
                    } else {
                        pesquisaCadastroPessoas.alterando = 1;
                        pesquisaCadastroPessoas.incluindo = 0;
                        pesquisaCadastroPessoas.btnExcluir.setEnabled(true);
                        this.dispose();
                        return;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados técnicos do cliente! \n" + ex);
                }
                
            //Chamada pelo lançamento de entrada em estoque;
            } else if (pesquisaLancamentoEstoqueEntrada != null) { 
                pesquisaLancamentoEstoqueEntrada.setVisible(true);
                pesquisaLancamentoEstoqueEntrada.pack();
                pesquisaLancamentoEstoqueEntrada.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoEstoqueEntrada.txtCodigoPessoa.setText(codigo);
                pesquisaLancamentoEstoqueEntrada.txtDescricaoPessoa.setText(razaoSocial);
                this.dispose();
                
            //Chamada pelo lançamento de saída de estoque;
            } else if (pesquisaLancamentoEstoqueSaida != null) { 
                pesquisaLancamentoEstoqueSaida.setVisible(true);
                pesquisaLancamentoEstoqueSaida.pack();
                pesquisaLancamentoEstoqueSaida.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoEstoqueSaida.txtCodigoPessoa.setText(codigo);
                pesquisaLancamentoEstoqueSaida.txtDescricaoPessoa.setText(razaoSocial);
                this.dispose();
                      
            //Chamada pelo lançamento de contas a receber;
            } else if (pesquisaLancamentoContasReceber != null) { 
                pesquisaLancamentoContasReceber.setVisible(true);
                pesquisaLancamentoContasReceber.pack();
                pesquisaLancamentoContasReceber.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                pesquisaLancamentoContasReceber.txtClienteCodigo.setText(codigo);
                pesquisaLancamentoContasReceber.txtClienteDescricao.setText(razaoSocial);
                this.dispose();
                
            //Chamada pelo lançamento de contas a pagar;
            } else if (pesquisaLancamentoContasPagar != null) { 
                pesquisaLancamentoContasPagar.setVisible(true);
                pesquisaLancamentoContasPagar.pack();
                pesquisaLancamentoContasPagar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoContasPagar.txtFornecedorCodigo.setText(codigo);
                pesquisaLancamentoContasPagar.txtFornecedorDescricao.setText(razaoSocial);
                this.dispose();                
                
            //Chamado pelo lancamento de caixa;
            } else if (pesquisaLancamentoCaixa != null) { 
                pesquisaLancamentoCaixa.setVisible(true);
                pesquisaLancamentoCaixa.pack();
                pesquisaLancamentoCaixa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoCaixa.txtPessoaCodigo.setText(codigo);
                pesquisaLancamentoCaixa.txtPessoaDescricao.setText(razaoSocial);
                this.dispose();

            //Chamado pelo lancamento de despesas de veículos;
            } else if (pesquisaDespesasVeiculos != null) { 
                pesquisaDespesasVeiculos.setVisible(true);
                pesquisaDespesasVeiculos.pack();
                pesquisaDespesasVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaDespesasVeiculos.txtFornecedorCodigo.setText(codigo);
                pesquisaDespesasVeiculos.txtFornecedorDescricao.setText(razaoSocial);
                this.dispose();                
                
            //Chamado pelo formulário de orçamento;
            } else if (pesquisaOrcamento != null) { 
                pesquisaOrcamento.setVisible(true);
                pesquisaOrcamento.pack();
                pesquisaOrcamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaOrcamento.txtClienteCodigo.setText(codigo);
                pesquisaOrcamento.txtClienteDescricao.setText(razaoSocial);
                this.dispose();        
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tblPessoasMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaPessoas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaPessoas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPessoas;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
