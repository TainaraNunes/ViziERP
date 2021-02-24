
package ERP.view;

import Beans.BeansLancamentoCaixa;
import Beans.ModeloTabela;
import Conection.ConectaBD;
import DAO.DaoCheques;
import DAO.DaoFuncoes;
import java.awt.Dialog;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;

public class ConsultaCheques extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();      
    DaoCheques daoCheques = new DaoCheques();
    DaoFuncoes funcoes = new DaoFuncoes();
    PesquisaBancos pesquisaBancos = new PesquisaBancos();
    BeansLancamentoCaixa beansLancamentoCaixa = new BeansLancamentoCaixa();
     
    private Cheques pesquisaCadastroCheques;
    private LancamentoCaixa pesquisaLancamentoCaixa;
    private PesquisaHistoricos pesquisaHistoricos;
    
    public ConsultaCheques(java.awt.Frame parent) {
        if (parent.getName().equals("frmCheques")){
            pesquisaCadastroCheques = (Cheques) parent;
        } else if (parent.getName().equals("frmLancamentoCaixa")){
            pesquisaLancamentoCaixa = (LancamentoCaixa) parent;
        } else if (parent.getName().equals("frmPesquisaHistoricosCaixa")){
            pesquisaHistoricos = (PesquisaHistoricos) parent;
        }
        
        initComponents();
        habilitarBotaoCadastro(false); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCheques = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBancoDescricao = new javax.swing.JTextField();
        btnPesquisarBancos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDataVencimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtEmitenteDescricao = new javax.swing.JTextField();
        txtBancoCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtChequeNumero = new javax.swing.JTextField();
        btnPesquisarCheques = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnCadastrarCheque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta de Cheques");

        tblCheques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Banco", "Vencimento", "Valor", "Situação", "Emitente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCheques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChequesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCheques);
        if (tblCheques.getColumnModel().getColumnCount() > 0) {
            tblCheques.getColumnModel().getColumn(0).setResizable(false);
            tblCheques.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblCheques.getColumnModel().getColumn(1).setResizable(false);
            tblCheques.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblCheques.getColumnModel().getColumn(2).setResizable(false);
            tblCheques.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCheques.getColumnModel().getColumn(3).setResizable(false);
            tblCheques.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblCheques.getColumnModel().getColumn(4).setResizable(false);
            tblCheques.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblCheques.getColumnModel().getColumn(5).setResizable(false);
            tblCheques.getColumnModel().getColumn(5).setPreferredWidth(180);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Banco:");

        btnPesquisarBancos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarBancos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarBancosActionPerformed(evt);
            }
        });

        jLabel2.setText("Vencimento:");

        try {
            txtDataVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Situação:");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "A COMPENSAR", "CANCELADO", "COMPENSADO", "DEVOLVIDO", "NEGOCIADO", "REAPRESENTADO", "REPASSADO", "VENCIDO" }));

        jLabel4.setText("Emitente:");

        jLabel5.setText("Nº Cheque:");

        btnPesquisarCheques.setText("Pesquisar");
        btnPesquisarCheques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarChequesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEmitenteDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisarCheques))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChequeNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBancoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBancoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarBancos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtChequeNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisarBancos)
                    .addComponent(txtBancoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtBancoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtEmitenteDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCheques))
                .addContainerGap())
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCadastrarCheque.setText("Cadastrar");
        btnCadastrarCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarChequeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCadastrarCheque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnCadastrarCheque))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarBancosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarBancosActionPerformed
        if (!txtBancoDescricao.getText().isEmpty()) {
            pesquisaBancos = new PesquisaBancos();
            pesquisaBancos.setLocationRelativeTo(null);
            pesquisaBancos.setVisible(true);
            pesquisaBancos.setResizable(false);
            pesquisaBancos.preencherTabela(null, this, "SELECT * FROM BANCOS WHERE CODIGO = '" + txtBancoCodigo.getText() + "' OR DESCRICAO LIKE '% "+txtBancoDescricao.getText().trim() +" %' ORDER BY DESCRICAO");
        } else {
            pesquisaBancos = new PesquisaBancos();
            pesquisaBancos.setLocationRelativeTo(null);
            pesquisaBancos.setVisible(true);
            pesquisaBancos.preencherTabela(null, this, "SELECT * FROM BANCOS ORDER BY DESCRICAO");
        }        
    }//GEN-LAST:event_btnPesquisarBancosActionPerformed

    private void btnPesquisarChequesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarChequesActionPerformed
        PesquisarCheques();
    }//GEN-LAST:event_btnPesquisarChequesActionPerformed

    private void tblChequesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChequesMouseClicked
        int index = tblCheques.getSelectedRow();
        TableModel model = tblCheques.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM CHEQUES WHERE NUMERO = '"+index+"'");
        try {
            conecta.rs.first();            
            String chequeNumero  = model.getValueAt(index, 0).toString();
            String bancoDescricao = model.getValueAt(index, 1).toString();
            String vencimento = model.getValueAt(index, 2).toString();
            String valor = model.getValueAt(index, 3).toString();
            String situacao = model.getValueAt(index, 4).toString();
            String emitenteDescricao = model.getValueAt(index, 5).toString();
            String emitenteCodigo = model.getValueAt(index, 6).toString();
            String emitenteCpfCnpj = model.getValueAt(index, 7).toString();
            String titularDescricao = model.getValueAt(index, 8).toString();
            String titularCodigo = model.getValueAt(index, 9).toString();
            String titularCpfCnpj = model.getValueAt(index, 10).toString();
            String observacoes = model.getValueAt(index, 11).toString();
            String dataSituacao = model.getValueAt(index, 12).toString();
            String bancoCodigo = model.getValueAt(index, 13).toString();
            String documento, parcelaNumero;
            if (model.getValueAt(index, 14).toString().isEmpty()){
                documento = " ";
                parcelaNumero = " ";
            } else {
                documento = model.getValueAt(index, 14).toString();
                parcelaNumero = model.getValueAt(index, 15).toString();
            }
    
            // Chamada pelo cadastro de cheques;
            if (pesquisaCadastroCheques != null) {
                
                pesquisaCadastroCheques.setVisible(true);
                pesquisaCadastroCheques.pack();
                pesquisaCadastroCheques.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaCadastroCheques.txtNumeroCheque.setText(chequeNumero);
                pesquisaCadastroCheques.txtBancoCodigo.setText(bancoCodigo);
                pesquisaCadastroCheques.txtBancoDescricao.setText(bancoDescricao);
                pesquisaCadastroCheques.txtDataVencimento.setText(vencimento);
                
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                pesquisaCadastroCheques.txtValor.setText(nf.format(new BigDecimal(valor)));
                
                pesquisaCadastroCheques.cmbSituacao.getModel().setSelectedItem(situacao);
                pesquisaCadastroCheques.txtEmitenteDescricao.setText(emitenteDescricao.trim());
                pesquisaCadastroCheques.txtEmitenteCodigo.setText(emitenteCodigo);
                pesquisaCadastroCheques.txtEmitenteCPFCNPJ.setText(emitenteCpfCnpj);
                pesquisaCadastroCheques.txtTitularDescricao.setText(titularDescricao.trim());
                pesquisaCadastroCheques.txtTitularCodigo.setText(titularCodigo);
                pesquisaCadastroCheques.txtTitularCPFCNPJ.setText(titularCpfCnpj);
                pesquisaCadastroCheques.txtObservacao.setText(observacoes.trim());
                pesquisaCadastroCheques.txtDataSituacao.setText(dataSituacao);
                pesquisaCadastroCheques.txtDocumento.setText(documento);
                pesquisaCadastroCheques.txtParcelaNumero.setText(parcelaNumero);
                
                conecta.conexao();
                conecta.executaSql("SELECT * FROM CHEQUES WHERE NUMERO = '" + pesquisaCadastroCheques.txtNumeroCheque.getText() + "' AND BANCO = '" + pesquisaCadastroCheques.txtBancoCodigo.getText() + "'");
                try {
                    if (conecta.rs.first()) {
                        if(conecta.rs.getString("DOCUMENTO") != null){
                            pesquisaCadastroCheques.txtBancoCodigo.setEnabled(false);
                            pesquisaCadastroCheques.txtBancoDescricao.setEnabled(false);
                            pesquisaCadastroCheques.txtNumeroCheque.setEnabled(false);
                            pesquisaCadastroCheques.txtDataVencimento.setEnabled(false);
                            pesquisaCadastroCheques.txtValor.setEnabled(false);
                            pesquisaCadastroCheques.txtTitularCodigo.setEnabled(false);
                            pesquisaCadastroCheques.txtTitularDescricao.setEnabled(false);
                            pesquisaCadastroCheques.txtTitularCPFCNPJ.setEnabled(false);
                            pesquisaCadastroCheques.txtEmitenteCodigo.setEnabled(false);
                            pesquisaCadastroCheques.txtEmitenteDescricao.setEnabled(false);
                            pesquisaCadastroCheques.txtEmitenteCPFCNPJ.setEnabled(false);
                        }
                    } 
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao consultar lançamento de cheques! \n" + ex);
                }

                pesquisaCadastroCheques.incluindo = 0;
                pesquisaCadastroCheques.alterando = 1;
                
                conecta.desconecta();
                this.dispose();
            } 

            // Chamada pelo lançamento de caixa;
            else if (pesquisaLancamentoCaixa != null) {
                pesquisaLancamentoCaixa.txtObservacoes.setText("Recebimento com cheque Nº " + chequeNumero + ", Banco: " + bancoCodigo + ", de " + emitenteDescricao + " ");                
                pesquisaLancamentoCaixa.chequeNumero = chequeNumero;
                pesquisaLancamentoCaixa.bancoCodigo = bancoCodigo;
                
                conecta.desconecta();
                this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }
    }//GEN-LAST:event_tblChequesMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    public void habilitarBotaoCadastro(boolean habilitar){
        if (habilitar == false){
            btnCadastrarCheque.setVisible(false);
        } else {
            btnCadastrarCheque.setVisible(true);
        }
    }
    
    private void btnCadastrarChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarChequeActionPerformed
        Cheques cheques = new Cheques();        
        cheques.setVisible(true);
        cheques.pack();
        cheques.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
    }//GEN-LAST:event_btnCadastrarChequeActionPerformed

    public void PesquisarCheques(){
        String whereCheque, whereBanco, whereDataVencimento, whereSituacao, whereEmitente;        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if (txtChequeNumero.getText().isEmpty()){
            whereCheque = "TRUE";
        } else {
            whereCheque = "CHEQUES.NUMERO = '" + txtChequeNumero.getText() + "'";
        }
        
        if (txtBancoCodigo.getText().isEmpty()){
            whereBanco = "TRUE";
        } else {
            whereBanco = "CHEQUES.BANCO = '" + txtBancoCodigo.getText() + "'";
        }
        
        if (txtDataVencimento.getText().trim().length() < 10 ){
            whereDataVencimento = "TRUE";
        } else {
            whereDataVencimento = "CHEQUES.VENCIMENTO = '" + LocalDate.parse(txtDataVencimento.getText(), formato) + "'";
        }

        if (cmbSituacao.getSelectedItem().toString().equals("TODOS") || cmbSituacao.getSelectedItem().toString().isEmpty()){
            whereSituacao = "TRUE";
        } else {
            whereSituacao = "CHEQUES.SITUACAO = '" + cmbSituacao.getSelectedItem().toString() + "'";
        }

        if (txtEmitenteDescricao.getText().isEmpty()){
            whereEmitente = "TRUE";
        } else {
            whereEmitente = "CHEQUES.EMITENTEDESCRICAO = '" + txtEmitenteDescricao.getText() + "'";
        }
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Número", "Banco", "Vencimento", "Valor", "Situação", "Emitente"};

        conecta.conexao();
        conecta.executaSql("SELECT BANCOS.DESCRICAO AS BANCODESCRICAO , * "
                         + "FROM CHEQUES "
                         + "      JOIN BANCOS ON(CHEQUES.BANCO = BANCOS.CODIGO)"
                         + "WHERE " + whereCheque + " AND   " 
                         + "      " + whereBanco + " AND  "
                         + "      " + whereDataVencimento + " AND "
                         + "      " + whereSituacao + " AND " 
                         + "      " + whereEmitente + " ");

        try {
            conecta.rs.first();
            DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            String dataVencimento, dataSituacao;       
            do {
                if (conecta.rs.getDate("VENCIMENTO") != null) {
                    dataVencimento = formatoData.format(conecta.rs.getDate("VENCIMENTO"));
                } else {
                    dataVencimento = " ";
                }
                
                if (conecta.rs.getDate("SITUACAODATA") != null) {
                    dataSituacao = formatoData.format(conecta.rs.getDate("SITUACAODATA"));
                } else {
                    dataSituacao = " ";
                }
                                
                dados.add(new Object[]{conecta.rs.getString("NUMERO").trim(), conecta.rs.getString("BANCODESCRICAO").trim(), dataVencimento, conecta.rs.getString("VALOR"), conecta.rs.getString("SITUACAO").trim(), conecta.rs.getString("EMITENTEDESCRICAO").trim(), conecta.rs.getString("EMITENTECODIGO"), conecta.rs.getString("EMITENTECPFCNPJ"),  
                                       conecta.rs.getString("TITULARDESCRICAO"), conecta.rs.getString("TITULARCODIGO"), conecta.rs.getString("TITULARCPFCNPJ"), conecta.rs.getString("OBSERVACAO"), dataSituacao, conecta.rs.getString("BANCO"), conecta.rs.getString("DOCUMENTO"), conecta.rs.getString("PARCELANUMERO")});    
            } while (conecta.rs.next());
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblCheques.setModel(table);
        tblCheques.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblCheques.getColumnModel().getColumn(0).setResizable(false);
        tblCheques.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblCheques.getColumnModel().getColumn(1).setResizable(false);
        tblCheques.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblCheques.getColumnModel().getColumn(2).setResizable(false);
        tblCheques.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblCheques.getColumnModel().getColumn(3).setResizable(false);
        tblCheques.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblCheques.getColumnModel().getColumn(4).setResizable(false);
        tblCheques.getColumnModel().getColumn(5).setPreferredWidth(180);
        tblCheques.getColumnModel().getColumn(5).setResizable(false);

        tblCheques.getTableHeader().setReorderingAllowed(false);
        tblCheques.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();            
    }
    
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
                new ConsultaCheques(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCheque;
    public javax.swing.JButton btnPesquisarBancos;
    public javax.swing.JButton btnPesquisarCheques;
    private javax.swing.JButton btnSair;
    public javax.swing.JComboBox cmbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCheques;
    public javax.swing.JTextField txtBancoCodigo;
    public javax.swing.JTextField txtBancoDescricao;
    private javax.swing.JTextField txtChequeNumero;
    public javax.swing.JFormattedTextField txtDataVencimento;
    private javax.swing.JTextField txtEmitenteDescricao;
    // End of variables declaration//GEN-END:variables
}
