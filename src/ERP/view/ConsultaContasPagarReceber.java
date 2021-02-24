package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoLancamentoContasReceber;

public class ConsultaContasPagarReceber extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    DaoLancamentoContasReceber daoContasReceber = new DaoLancamentoContasReceber();

    private LancamentoCaixa pesquisaLancamentoCaixa;
    private ConsultaContasPagarReceber pesquisaConsultaContasPagarReceber;
    private LancamentoContasReceber pesquisaLancamentoContasReceber;
    private LancamentoContasPagar pesquisaLancamentoContasPagar;

    public ConsultaContasPagarReceber() {
        initComponents();
        txtPessoaDescricao.setDocument(new Teclas());
        
        popularComboFormasPagamento();
        popularComboCategoria();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDtVencimentoInicial = new javax.swing.JFormattedTextField();
        txtDtVencimentoFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDtLancamentoInicial = new javax.swing.JFormattedTextField();
        txtDtLancamentoFinal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        cmbFormaPagamento = new javax.swing.JComboBox();
        chbContasReceber = new javax.swing.JCheckBox();
        chbContasPagar = new javax.swing.JCheckBox();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPessoaDescricao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDocumentoNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chbPendentes = new javax.swing.JCheckBox();
        chbLiquidadas = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txtPessoaCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultaFinanceiro = new javax.swing.JTable();
        txtTotalPagar = new javax.swing.JTextField();
        txtTotalReceber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Posição Financeira Clientes/Fornecedores");
        setName("ConsultaContasPagarReceber"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Data de Vencimento:");

        try {
            txtDtVencimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDtVencimentoInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDtVencimentoInicial.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        try {
            txtDtVencimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDtVencimentoFinal.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel3.setText("Data de Lançamento:");

        try {
            txtDtLancamentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDtLancamentoInicial.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        try {
            txtDtLancamentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDtLancamentoFinal.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel5.setText("Categoria:");

        jLabel6.setText("Forma de Pagamento:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE" }));

        cmbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECIONE", " " }));

        chbContasReceber.setText("A Receber");

        chbContasPagar.setText("A Pagar");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel7.setText("Cliente/Fornecedor:");

        jLabel8.setText("Documento:");

        txtDocumentoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoNumeroKeyTyped(evt);
            }
        });

        jLabel9.setText("Situação:");

        chbPendentes.setText("Pendentes");

        chbLiquidadas.setText("Liquidadas");

        jLabel10.setText("Classificação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDtLancamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDtVencimentoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(txtDtLancamentoFinal))
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPessoaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPessoaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocumentoNumero)
                    .addComponent(cmbFormaPagamento, 0, 179, Short.MAX_VALUE)
                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbLiquidadas)
                    .addComponent(chbPendentes)
                    .addComponent(jLabel9))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbContasPagar)
                    .addComponent(chbContasReceber)
                    .addComponent(jLabel10))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDtLancamentoFinal, txtDtLancamentoInicial, txtDtVencimentoFinal, txtDtVencimentoInicial});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLimpar, btnPesquisar});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chbLiquidadas, chbPendentes});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtDocumentoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtDtVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtDtLancamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtLancamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtPessoaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtPessoaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(btnPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chbPendentes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chbLiquidadas)
                                    .addComponent(chbContasReceber)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(chbContasPagar)
                                .addComponent(btnLimpar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblConsultaFinanceiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cliente/Fornecedor", "Documento", "Parcela", "Vencimento", "Valor Total", "Valor Recebido/Pago", "Data Rcto/Pgto", "Forma de Pagamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConsultaFinanceiro.getTableHeader().setReorderingAllowed(false);
        tblConsultaFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConsultaFinanceiroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConsultaFinanceiro);
        if (tblConsultaFinanceiro.getColumnModel().getColumnCount() > 0) {
            tblConsultaFinanceiro.getColumnModel().getColumn(0).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(0).setPreferredWidth(180);
            tblConsultaFinanceiro.getColumnModel().getColumn(1).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(1).setPreferredWidth(75);
            tblConsultaFinanceiro.getColumnModel().getColumn(2).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblConsultaFinanceiro.getColumnModel().getColumn(3).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblConsultaFinanceiro.getColumnModel().getColumn(4).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(4).setPreferredWidth(95);
            tblConsultaFinanceiro.getColumnModel().getColumn(5).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(5).setPreferredWidth(95);
            tblConsultaFinanceiro.getColumnModel().getColumn(6).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblConsultaFinanceiro.getColumnModel().getColumn(7).setResizable(false);
            tblConsultaFinanceiro.getColumnModel().getColumn(7).setPreferredWidth(130);
        }

        jLabel11.setText("Total a Receber:");

        jLabel12.setText("Total a Pagar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalReceber, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtTotalPagar, txtTotalReceber});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalReceber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void filtrosPesquisa(ConsultaContasPagarReceber pesquisaConsulta, LancamentoCaixa pesquisaCaixa, LancamentoContasReceber pesquisaContasReceber, LancamentoContasPagar pesquisaContasPagar) {
        pesquisaConsultaContasPagarReceber = pesquisaConsulta;
        pesquisaLancamentoCaixa = pesquisaCaixa;
        pesquisaLancamentoContasReceber = pesquisaContasReceber;
        pesquisaLancamentoContasPagar = pesquisaContasPagar;

        String filtroDataVencimento, filtroDataLancamento, filtroClienteCodigo, filtroFornecedorCodigo;
        String filtroFormaPagamento = null, filtroCategoria, filtroNumeroDocumento, filtroPendentesReceber, filtroPendentesPagar;
        String filtroLiquidadasReceber, filtroLiquidadasPagar, sql, sql1, sql2, sql3, sql4;

        conecta.conexao();

        //Chamada pela tela de consulta de contas a pagar e receber;
        if (pesquisaConsulta != null) {
            LocalDate dataVencimentoInicial = null, dataVencimentoFinal = null, dataLancamentoInicial = null, dataLancamentoFinal = null;
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            if (txtDtVencimentoInicial.getText().trim().length() < 10 && txtDtVencimentoFinal.getText().trim().length() < 10) {
                filtroDataVencimento = "TRUE";
            } else {
                dataVencimentoInicial = LocalDate.parse(txtDtVencimentoInicial.getText(), formato);
                dataVencimentoFinal = LocalDate.parse(txtDtVencimentoFinal.getText(), formato);

                filtroDataVencimento = "DATAVENCIMENTO BETWEEN '" + dataVencimentoInicial + "' AND '" + dataVencimentoFinal + "' ";
            }

            if (txtDtLancamentoInicial.getText().trim().length() < 10 && txtDtLancamentoFinal.getText().trim().length() < 10) {
                filtroDataLancamento = "TRUE";
            } else {
                dataLancamentoInicial = LocalDate.parse(txtDtLancamentoInicial.getText(), formato);
                dataLancamentoFinal = LocalDate.parse(txtDtLancamentoFinal.getText(), formato);

                filtroDataLancamento = "DATALANCAMENTO BETWEEN '" + dataLancamentoInicial + "' AND '" + dataLancamentoFinal + "' ";
            }

            if (cmbCategoria.getSelectedItem().equals("SELECIONE")) {
                filtroCategoria = "TRUE";
            } else {
                filtroCategoria = "CATEGORIA = '" + cmbCategoria.getSelectedItem() + "'";
            }

            if (cmbFormaPagamento.getSelectedItem().equals("SELECIONE")) {
                filtroFormaPagamento = "TRUE";
            } else {
                conecta.conexao();
                conecta.executaSql("SELECT CODIGO FROM FORMASPAGAMENTO WHERE DESCRICAO = '" + cmbFormaPagamento.getSelectedItem() + "'");
                try {
                    if (conecta.rs.next()) {
                        filtroFormaPagamento = "FORMAPAGAMENTO = " + conecta.rs.getInt("CODIGO");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (txtPessoaCodigo.getText().isEmpty()) {
                filtroClienteCodigo = "TRUE";
            } else {
                filtroClienteCodigo = "PESSOAS.CODIGO = " + txtPessoaCodigo.getText().trim() + " ";
            }

            if (txtPessoaCodigo.getText().isEmpty()) {
                filtroFornecedorCodigo = "TRUE";
            } else {
                filtroFornecedorCodigo = "PESSOAS.CODIGO =  "+ txtPessoaCodigo.getText().trim() + " ";
            }

            if (txtDocumentoNumero.getText().isEmpty()) {
                filtroNumeroDocumento = "TRUE";
            } else {
                filtroNumeroDocumento = "DOCUMENTONUMERO = '" + txtDocumentoNumero.getText() + "'";
            }

            if (chbLiquidadas.isSelected()) {
                filtroLiquidadasReceber = "SITUACAO = 'L' AND DATARECEBIMENTO IS NOT NULL";
                filtroLiquidadasPagar = "SITUACAO = 'L' AND DATAPAGAMENTO IS NOT NULL";
            } else {
                filtroLiquidadasReceber = "TRUE";
                filtroLiquidadasPagar = "TRUE";
            }

            if (chbPendentes.isSelected()) {
                filtroPendentesReceber = "SITUACAO IN('P', 'PR') AND DATARECEBIMENTO IS NULL";
                filtroPendentesPagar = "SITUACAO IN('P', 'PR') AND DATAPAGAMENTO IS NULL";
            } else {
                filtroPendentesReceber = "TRUE";
                filtroPendentesPagar = "TRUE";
            }
            
            if (chbPendentes.isSelected() && chbLiquidadas.isSelected()){
                filtroPendentesReceber = "TRUE";
                filtroPendentesPagar = "TRUE";
                filtroLiquidadasReceber = "TRUE";
                filtroLiquidadasPagar = "TRUE";
            }

            if (filtroDataVencimento.equals("TRUE") && filtroDataLancamento.equals("TRUE") && filtroClienteCodigo.equals("TRUE") && filtroCategoria.equals("TRUE") && filtroFormaPagamento.equals("TRUE") && filtroNumeroDocumento.equals("TRUE") && filtroLiquidadasReceber.equals("TRUE") && filtroPendentesReceber.equals("TRUE")) {
                sql1 = "SELECT PESSOAS.CODIGO AS CODIGO, "
                     + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                     + "       DOCUMENTONUMERO AS DOCUMENTO, "
                     + "       PARCELANUMERO AS PARCELA, "
                     + "       DATAVENCIMENTO AS VENCIMENTO, "
                     + "       DATARECEBIMENTO AS DTRECEBIDOPAGO, "
                     + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                     + "       VALORDUPLICATA AS VALORDPL, "
                     + "       ACRESCIMOS, "
                     + "       DESCONTOS, "
                     + "       TOTALRECEBER AS TOTALRECEBERPAGAR, "
                     + "       VALORRECEBIDO AS VALORRECEBIDOPAGO, "
                     + "       OPERACAO, "
                     + "       OBSERVACOES "                        
                     + "FROM CONTASRECEBER "
                     + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASRECEBER.CLIENTECODIGO) "
                     + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASRECEBER.FORMAPAGAMENTO) " ;
            } else {
                sql1 = "SELECT PESSOAS.CODIGO AS CODIGO, "
                     + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                     + "       DOCUMENTONUMERO AS DOCUMENTO, "
                     + "       PARCELANUMERO AS PARCELA, "
                     + "       DATAVENCIMENTO AS VENCIMENTO, "
                     + "       DATARECEBIMENTO AS DTRECEBIDOPAGO, "
                     + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                     + "       VALORDUPLICATA AS VALORDPL, "
                     + "       ACRESCIMOS, "
                     + "       DESCONTOS, "
                     + "       TOTALRECEBER AS TOTALRECEBERPAGAR, "
                     + "       VALORRECEBIDO AS VALORRECEBIDOPAGO, "                        
                     + "       OPERACAO, "
                     + "       OBSERVACOES "                        
                     + "FROM CONTASRECEBER "
                     + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASRECEBER.CLIENTECODIGO) "  
                     + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASRECEBER.FORMAPAGAMENTO) " 
                     + "WHERE " + filtroDataVencimento + " AND "
                                + filtroDataLancamento + " AND " 
                                + filtroClienteCodigo + " AND " 
                                + filtroCategoria + " AND " 
                                + filtroFormaPagamento + " AND " 
                                + filtroNumeroDocumento + " AND " 
                                + filtroLiquidadasReceber + " AND " 
                                + filtroPendentesReceber;
            }
            
            if (filtroDataVencimento.equals("TRUE") && filtroDataLancamento.equals("TRUE") && filtroFornecedorCodigo.equals("TRUE") && filtroCategoria.equals("TRUE") && filtroFormaPagamento.equals("TRUE") && filtroNumeroDocumento.equals("TRUE") && filtroLiquidadasPagar.equals("TRUE") && filtroPendentesPagar.equals("TRUE")) {
                sql3 = "SELECT PESSOAS.CODIGO AS CODIGO, "
                     + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                     + "       DOCUMENTONUMERO AS DOCUMENTO, "
                     + "       PARCELANUMERO AS PARCELA, "
                     + "       DATAVENCIMENTO AS VENCIMENTO, "
                     + "       DATAPAGAMENTO AS DTRECEBIDOPAGO, "
                     + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                     + "       VALORDUPLICATA AS VALORDPL, "
                     + "       ACRESCIMOS, "
                     + "       DESCONTOS, "
                     + "       TOTALPAGAR AS TOTALRECEBERPAGAR, "
                     + "       VALORPAGO AS VALORRECEBIDOPAGO, "                        
                     + "       OPERACAO, "
                     + "       OBSERVACOES "                                                
                     + "FROM CONTASPAGAR "
                     + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASPAGAR.FORNECEDORCODIGO) "
                     + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASPAGAR.FORMAPAGAMENTO) " ;
            } else {
                sql3 = "SELECT PESSOAS.CODIGO AS CODIGO, "
                     + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                     + "       DOCUMENTONUMERO AS DOCUMENTO, "
                     + "       PARCELANUMERO AS PARCELA, "
                     + "       DATAVENCIMENTO AS VENCIMENTO, "
                     + "       DATAPAGAMENTO AS DTRECEBIDOPAGO, "
                     + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                     + "       VALORDUPLICATA AS VALORDPL, "
                     + "       ACRESCIMOS, "
                     + "       DESCONTOS, "
                     + "       TOTALPAGAR AS TOTALRECEBERPAGAR, "
                     + "       VALORPAGO AS VALORRECEBIDOPAGO, "                        
                     + "       OPERACAO, "
                     + "       OBSERVACOES "                                                
                     + "FROM CONTASPAGAR "
                     + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASPAGAR.FORNECEDORCODIGO) "
                     + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASPAGAR.FORMAPAGAMENTO) "
                     + "WHERE " + filtroDataVencimento + " AND " 
                                + filtroDataLancamento + " AND " 
                                + filtroFornecedorCodigo + " AND " 
                                + filtroCategoria + " AND " 
                                + filtroFormaPagamento + " AND " 
                                + filtroNumeroDocumento + " AND " 
                                + filtroLiquidadasPagar + " AND " 
                                + filtroPendentesPagar;
            }
            sql2 = " UNION ALL ";
            sql4 = " ORDER BY PESSOA, DOCUMENTO, PARCELA";

            if (chbContasPagar.isSelected() && !(chbContasReceber.isSelected())) {
                sql = sql3.concat(sql4);
            } else if (chbContasReceber.isSelected() && !(chbContasPagar.isSelected())) {
                sql = sql1.concat(sql4);
            } else {
                sql = sql1.concat(sql2).concat(sql3).concat(sql4);
            }

            preencherTabelaConsulta(sql);

        //Chamada pelo lançamento de contas a receber;
        } else if (pesquisaContasReceber != null) {
            //Filtra pelo código do cliente:
            txtPessoaCodigo.setText(pesquisaContasReceber.txtClienteCodigo.getText().trim());
            txtPessoaDescricao.setText(pesquisaContasReceber.txtClienteDescricao.getText().trim());
    
            if (txtPessoaCodigo.getText().isEmpty()) {
                filtroClienteCodigo = "TRUE";
            } else {
                filtroClienteCodigo = "PESSOAS.CODIGO = " + txtPessoaCodigo.getText().trim() + " ";
            }

            //Filtra pelo número do documento:
            txtDocumentoNumero.setText(pesquisaContasReceber.txtDocumentoNumero.getText());
            if (txtDocumentoNumero.getText().isEmpty()) {
                filtroNumeroDocumento = "TRUE";
            } else {
                filtroNumeroDocumento = "DOCUMENTONUMERO = '" + txtDocumentoNumero.getText() + "'";
            }
            
            chbContasReceber.setSelected(true);
            chbPendentes.setSelected(true); 
            
            desabilitarCampos();
            
            preencherTabelaConsulta("SELECT PESSOAS.CODIGO AS CODIGO, "
                                  + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                                  + "       DOCUMENTONUMERO AS DOCUMENTO, "
                                  + "       PARCELANUMERO AS PARCELA, "
                                  + "       DATAVENCIMENTO AS VENCIMENTO, "
                                  + "       DATARECEBIMENTO AS DTRECEBIDOPAGO, "
                                  + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                                  + "       VALORDUPLICATA AS VALORDPL, "
                                  + "       ACRESCIMOS, "
                                  + "       DESCONTOS, "
                                  + "       VALORTOTALFATURA AS TOTALFATURA, "                    
                                  + "       TOTALRECEBER AS TOTALRECEBERPAGAR, "
                                  + "       VALORRECEBIDO AS VALORRECEBIDOPAGO, "                                        
                                  + "       CATEGORIA, "
                                  + "       PLANILHA, "
                                  + "       DATALANCAMENTO, "
                                  + "       OPERACAO, "
                                  + "       OBSERVACOES "                                            
                                  + "FROM CONTASRECEBER "
                                  + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASRECEBER.CLIENTECODIGO) "
                                  + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASRECEBER.FORMAPAGAMENTO) " 
                                  + "WHERE " + filtroClienteCodigo   + " AND " 
                                             + filtroNumeroDocumento + " AND "
                                  + "        SITUACAO IN('P', 'PR') "
                                  + "ORDER BY PESSOA, DOCUMENTONUMERO, PARCELANUMERO");

        //Chamada pelo lançamento de contas a pagar;
        } else if (pesquisaContasPagar != null) {
            txtPessoaCodigo.setText(pesquisaContasPagar.txtFornecedorCodigo.getText());
            txtPessoaDescricao.setText(pesquisaContasPagar.txtFornecedorDescricao.getText());
            
            //Filtra pelo código do fornecedor:
            if (txtPessoaCodigo.getText().isEmpty()) {
                filtroFornecedorCodigo = "TRUE";
            } else {
                filtroFornecedorCodigo = "PESSOAS.CODIGO = " + txtPessoaCodigo.getText() + " ";
            }
            
            //Filtra pelo número do documento:
            txtDocumentoNumero.setText(pesquisaContasPagar.txtDocumentoNumero.getText());
            if (txtDocumentoNumero.getText().isEmpty()) {
                filtroNumeroDocumento = "TRUE";
            } else {
                filtroNumeroDocumento = "DOCUMENTONUMERO = '" + txtDocumentoNumero.getText() + "'";
            }

            chbContasPagar.setSelected(true);
            chbPendentes.setSelected(true);
            
            desabilitarCampos();
            
            preencherTabelaConsulta("SELECT PESSOAS.CODIGO AS CODIGO, "
                                  + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                                  + "       DOCUMENTONUMERO AS DOCUMENTO, "
                                  + "       PARCELANUMERO AS PARCELA, "
                                  + "       DATAVENCIMENTO AS VENCIMENTO, "
                                  + "       DATAPAGAMENTO AS DTRECEBIDOPAGO, "
                                  + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                                  + "       VALORDUPLICATA AS VALORDPL, "
                                  + "       ACRESCIMOS, "
                                  + "       DESCONTOS, "
                                  + "       VALORTOTALFATURA AS TOTALFATURA, "
                                  + "       TOTALPAGAR AS TOTALRECEBERPAGAR, "
                                  + "       VALORPAGO AS VALORRECEBIDOPAGO, "
                                  + "       CATEGORIA, "
                                  + "       PLANILHA, "
                                  + "       DATALANCAMENTO, "
                                  + "       OPERACAO, "
                                  + "       OBSERVACOES "                                            
                                  + "FROM CONTASPAGAR "
                                  + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASPAGAR.FORNECEDORCODIGO) "
                                  + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASPAGAR.FORMAPAGAMENTO) " 
                                  + "WHERE " + filtroFornecedorCodigo + " AND " 
                                             + filtroNumeroDocumento  + " AND "
                                  + "        SITUACAO IN('P', 'PP') "
                                  + "ORDER BY PESSOA, DOCUMENTONUMERO, PARCELANUMERO");

        //Chamado pelo lançamento de caixa;
        } else if (pesquisaCaixa != null) {
            String filtroHistorico = pesquisaCaixa.txtHistorico.getText().trim();
            if (filtroHistorico.isEmpty()) {
                filtroHistorico = "TODOS";
            } else {
                conecta.conexao();
                conecta.executaSql("SELECT * FROM HISTORICOS WHERE HISTORICODESCRICAO = '" + filtroHistorico + "'");
                try {
                    conecta.rs.next();
                    if (conecta.rs.getString("TIPOLANCAMENTO").equals("E") && conecta.rs.getInt("MOVIMENTADUPLICATAS") == 1) {
                        filtroHistorico = "RECEBER";
                    } else if (conecta.rs.getString("TIPOLANCAMENTO").equals("S") && conecta.rs.getInt("MOVIMENTADUPLICATAS") == 1) {
                        filtroHistorico = "PAGAR";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaContasPagarReceber.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            txtPessoaCodigo.setText(pesquisaCaixa.txtPessoaCodigo.getText().trim()); 
            txtPessoaDescricao.setText(pesquisaCaixa.txtPessoaDescricao.getText().trim());
            if (txtPessoaCodigo.getText().isEmpty()) {
                filtroClienteCodigo = "TRUE";
                filtroFornecedorCodigo = "TRUE";
            } else {
                filtroClienteCodigo = "PESSOAS.CODIGO = " + txtPessoaCodigo.getText().trim() + " ";
                filtroFornecedorCodigo = "PESSOAS.CODIGO = " + txtPessoaCodigo.getText().trim() + " ";
            }
            
            txtDocumentoNumero.setText(pesquisaCaixa.txtDocumentoNumero.getText());            
            if (txtDocumentoNumero.getText().isEmpty()) {
                filtroNumeroDocumento = "TRUE";
            } else {
                filtroNumeroDocumento = "DOCUMENTONUMERO = '" + txtDocumentoNumero.getText() + "'";
            }

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVencimentoInicial = null, dataVencimentoFinal = null;
            if (txtDtVencimentoInicial.getText().trim().length() < 10 && txtDtVencimentoFinal.getText().trim().length() < 10) {
                filtroDataVencimento = "TRUE";
            } else {
                dataVencimentoInicial = LocalDate.parse(txtDtVencimentoInicial.getText(), formato);
                dataVencimentoFinal = LocalDate.parse(txtDtVencimentoFinal.getText(), formato);

                filtroDataVencimento = "DATAVENCIMENTO BETWEEN '" + dataVencimentoInicial + "' AND '" + dataVencimentoFinal + "' ";
            }
                       
            if (filtroHistorico.equals("RECEBER")) {
                chbContasReceber.setSelected(true);
                chbPendentes.setSelected(true);
            
                desabilitarCampos();
                
                preencherTabelaConsulta("SELECT PESSOAS.CODIGO AS CODIGO, "
                                      + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                                      + "       DOCUMENTONUMERO AS DOCUMENTO, "
                                      + "       PARCELANUMERO AS PARCELA, "
                                      + "       DATAVENCIMENTO AS VENCIMENTO, "
                                      + "       DATARECEBIMENTO AS DTRECEBIDOPAGO, "
                                      + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                                      + "       VALORDUPLICATA AS VALORDPL, "
                                      + "       ACRESCIMOS, "
                                      + "       DESCONTOS, "
                                      + "       VALORTOTALFATURA AS TOTALFATURA, "                        
                                      + "       TOTALRECEBER AS TOTALRECEBERPAGAR, "
                                      + "       VALORRECEBIDO AS VALORRECEBIDOPAGO, "
                                      + "       CATEGORIA, "
                                      + "       PLANILHA, "
                                      + "       DATALANCAMENTO, "
                                      + "       OPERACAO, "
                                      + "       OBSERVACOES "                                                
                                      + "FROM CONTASRECEBER "
                                      + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASRECEBER.CLIENTECODIGO) "
                                      + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASRECEBER.FORMAPAGAMENTO) "
                                      + "WHERE " + filtroClienteCodigo + " AND " 
                                                 + filtroNumeroDocumento + " AND "
                                                 + filtroDataVencimento + " AND "
                                      + "        SITUACAO IN('P', 'PR') "
                                      + "ORDER BY PESSOA, DOCUMENTONUMERO, PARCELANUMERO");

            } else if (filtroHistorico.equals("PAGAR")) {
                                
                chbContasPagar.setSelected(true);
                chbPendentes.setSelected(true);
                
                desabilitarCampos();
                
                preencherTabelaConsulta("SELECT PESSOAS.CODIGO AS CODIGO, "
                                      + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                                      + "       DOCUMENTONUMERO AS DOCUMENTO, "
                                      + "       PARCELANUMERO AS PARCELA, "
                                      + "       DATAVENCIMENTO AS VENCIMENTO, "
                                      + "       DATAPAGAMENTO AS DTRECEBIDOPAGO, "
                                      + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                                      + "       VALORDUPLICATA AS VALORDPL, "
                                      + "       ACRESCIMOS, "
                                      + "       DESCONTOS, "
                                      + "       VALORTOTALFATURA AS TOTALFATURA, "                        
                                      + "       TOTALPAGAR AS TOTALRECEBERPAGAR, "
                                      + "       VALORPAGO AS VALORRECEBIDOPAGO, "
                                      + "       CATEGORIA, "
                                      + "       PLANILHA, "
                                      + "       DATALANCAMENTO, "
                                      + "       OPERACAO, "
                                      + "       OBSERVACOES "                                                
                                      + "FROM CONTASPAGAR "
                                      + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASPAGAR.FORNECEDORCODIGO) "
                                      + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASPAGAR.FORMAPAGAMENTO) "
                                      + "WHERE " + filtroFornecedorCodigo + " AND " 
                                                 + filtroNumeroDocumento + " AND "
                                                 + filtroDataVencimento + " AND "
                                      + "        SITUACAO IN('P', 'PP') "
                                      + "ORDER BY PESSOA, DOCUMENTONUMERO, PARCELANUMERO");

            } else if (filtroHistorico.equals("TODOS")) {
                
                desabilitarCampos();
                
                preencherTabelaConsulta("SELECT PESSOAS.CODIGO AS CODIGO, "
                                      + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                                      + "       DOCUMENTONUMERO AS DOCUMENTO, "
                                      + "       PARCELANUMERO AS PARCELA, "
                                      + "       DATAVENCIMENTO AS VENCIMENTO, "
                                      + "       DATARECEBIMENTO AS DTRECEBIDOPAGO, "
                                      + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                                      + "       VALORDUPLICATA AS VALORDPL, "
                                      + "       ACRESCIMOS, "
                                      + "       DESCONTOS, "
                                      + "       VALORTOTALFATURA AS TOTALFATURA, "                        
                                      + "       TOTALRECEBER AS TOTALRECEBERPAGAR, "
                                      + "       VALORRECEBIDO AS VALORRECEBIDOPAGO, "
                                      + "       CATEGORIA, "
                                      + "       PLANILHA, "
                                      + "       DATALANCAMENTO, "
                                      + "       OPERACAO, "
                                      + "       OBSERVACOES "                                                
                                      + "FROM CONTASRECEBER "
                                      + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASRECEBER.CLIENTECODIGO) "
                                      + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASRECEBER.FORMAPAGAMENTO) "
                                      + "WHERE " + filtroClienteCodigo + " AND " 
                                                 + filtroNumeroDocumento + " AND "
                                                 + filtroDataVencimento + " AND "
                                      + "        SITUACAO IN('P', 'PR') "
                        
                                      + "UNION ALL "
                        
                                      + "SELECT PESSOAS.CODIGO AS CODIGO, "
                                      + "       PESSOAS.RAZAOSOCIAL AS PESSOA, "
                                      + "       DOCUMENTONUMERO AS DOCUMENTO, "
                                      + "       PARCELANUMERO AS PARCELA, "
                                      + "       DATAVENCIMENTO AS VENCIMENTO, "
                                      + "       DATAPAGAMENTO AS DTRECEBIDOPAGO, "
                                      + "       FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, "
                                      + "       VALORDUPLICATA AS VALORDPL, "
                                      + "       ACRESCIMOS, "
                                      + "       DESCONTOS, "
                                      + "       VALORTOTALFATURA AS TOTALFATURA, "                        
                                      + "       TOTALPAGAR AS TOTALRECEBERPAGAR, "
                                      + "       VALORPAGO AS VALORRECEBIDOPAGO, "
                                      + "       CATEGORIA, "
                                      + "       PLANILHA, "
                                      + "       DATALANCAMENTO, "
                                      + "       OPERACAO, "
                                      + "       OBSERVACOES "                        
                                      + "FROM CONTASPAGAR "
                                      + "JOIN PESSOAS ON(PESSOAS.CODIGO = CONTASPAGAR.FORNECEDORCODIGO) "
                                      + "JOIN FORMASPAGAMENTO ON(FORMASPAGAMENTO.CODIGO = CONTASPAGAR.FORMAPAGAMENTO) "
                                      + "WHERE " + filtroFornecedorCodigo + " AND " 
                                                 + filtroNumeroDocumento + " AND "
                                                 + filtroDataVencimento + " AND "
                                      + "        SITUACAO IN('P', 'PP') "
                                      + "ORDER BY PESSOA, DOCUMENTO, PARCELA");
            }
        }
    }

    public void preencherTabelaConsulta(String Sql) {
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataRecebidoPago;
        BigDecimal valorTotalReceber = BigDecimal.ZERO;
        BigDecimal valorTotalPagar = BigDecimal.ZERO;

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Cliente/Fornecedor", "Documento", "Parcela", "Vencimento", "Valor Total", "Valor Recebido/Pago", "Data Rcto/Pgto", "Forma de Pagamento"};

        conecta.conexao();
        conecta.executaSql(Sql);
        try {
            conecta.rs.first();
            do {
                if (conecta.rs.getDate("DTRECEBIDOPAGO") != null) {
                    dataRecebidoPago = formato.format(conecta.rs.getDate("DTRECEBIDOPAGO"));
                } else {
                    dataRecebidoPago = "";
                }

                if (pesquisaConsultaContasPagarReceber != null) {
                    dados.add(new Object[]{conecta.rs.getString("PESSOA").trim(), conecta.rs.getString("DOCUMENTO"), conecta.rs.getString("PARCELA"), 
                                           formato.format(conecta.rs.getDate("VENCIMENTO")), conecta.rs.getString("TOTALRECEBERPAGAR"), 
                                           conecta.rs.getString("VALORRECEBIDOPAGO"), dataRecebidoPago, conecta.rs.getString("FORMAPAGAMENTO").trim(), 
                                           conecta.rs.getString("CODIGO")});
                } else {
                    dados.add(new Object[]{conecta.rs.getString("PESSOA").trim(), conecta.rs.getString("DOCUMENTO"), conecta.rs.getString("PARCELA"), 
                                           formato.format(conecta.rs.getDate("VENCIMENTO")), conecta.rs.getString("TOTALRECEBERPAGAR"), 
                                           conecta.rs.getString("VALORRECEBIDOPAGO"), dataRecebidoPago, conecta.rs.getString("FORMAPAGAMENTO").trim(),
                                           conecta.rs.getString("CODIGO"), conecta.rs.getString("VALORDPL"), conecta.rs.getString("ACRESCIMOS"),  
                                           conecta.rs.getString("DESCONTOS"), conecta.rs.getString("TOTALFATURA"),conecta.rs.getString("CATEGORIA"), 
                                           conecta.rs.getString("PLANILHA"), conecta.rs.getString("OBSERVACOES"), conecta.rs.getString("DATALANCAMENTO"), 
                                           conecta.rs.getString("OPERACAO"),});
                    dados.size();
                }

                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                if (conecta.rs.getString("OPERACAO").equals("2001")) {
                    valorTotalReceber = valorTotalReceber.add(new BigDecimal(conecta.rs.getString("VALORDPL")));
                    String totalReceberFormatado = nf.format(valorTotalReceber);
                    txtTotalReceber.setText(totalReceberFormatado);
                } else {
                    valorTotalPagar = valorTotalPagar.add(new BigDecimal(conecta.rs.getString("VALORDPL")));
                    String totalPagarFormatado = nf.format(valorTotalPagar);
                    txtTotalPagar.setText(totalPagarFormatado);
                }
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
            btnLimpar.requestFocus();
            conecta.desconecta();
        }

        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblConsultaFinanceiro.setModel(table);
        tblConsultaFinanceiro.getColumnModel().getColumn(0).setPreferredWidth(180);
        tblConsultaFinanceiro.getColumnModel().getColumn(1).setPreferredWidth(75);
        tblConsultaFinanceiro.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblConsultaFinanceiro.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblConsultaFinanceiro.getColumnModel().getColumn(4).setPreferredWidth(95);
        tblConsultaFinanceiro.getColumnModel().getColumn(5).setPreferredWidth(95);
        tblConsultaFinanceiro.getColumnModel().getColumn(6).setPreferredWidth(80);
        tblConsultaFinanceiro.getColumnModel().getColumn(7).setPreferredWidth(130);
        tblConsultaFinanceiro.getTableHeader().setReorderingAllowed(false);
        tblConsultaFinanceiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conecta.desconecta();
    }

    private void tblConsultaFinanceiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConsultaFinanceiroMouseClicked
        int index = tblConsultaFinanceiro.getSelectedRow();
        TableModel model = tblConsultaFinanceiro.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM CONTASRECEBER WHERE PLANILHA = '" + index + "'");
        try {
            conecta.rs.first();            
            String pessoaDescricao = model.getValueAt(index, 0).toString();
            String documentoNumero = model.getValueAt(index, 1).toString();
            String parcelaNumero = model.getValueAt(index, 2).toString();
            String dataVencimento = model.getValueAt(index, 3).toString();
            String totalReceber = model.getValueAt(index, 4).toString();
            String valorRecebidoPago = model.getValueAt(index, 5).toString();
            String dataRecebimentoPagamento = model.getValueAt(index, 6).toString();
            String formaPagamento = model.getValueAt(index, 7).toString();
            String pessoaCodigo = model.getValueAt(index, 8).toString();
            String valorDuplicata = model.getValueAt(index, 9).toString();
            String acrescimos = model.getValueAt(index, 10).toString();
            String descontos = model.getValueAt(index, 11).toString();
            String totalFatura = model.getValueAt(index, 12).toString();
            String categoria = model.getValueAt(index, 13).toString();
            String planilha = model.getValueAt(index, 14).toString();                
            String observacoes = model.getValueAt(index, 15).toString().trim();
            String dataLancamento = model.getValueAt(index, 16).toString();

            //Chamada pelo lançamento de caixa:
            if (pesquisaLancamentoCaixa != null) {
                pesquisaLancamentoCaixa.setVisible(true);
                pesquisaLancamentoCaixa.pack();
                pesquisaLancamentoCaixa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                if (pesquisaLancamentoCaixa.txtPessoaCodigo.getText().isEmpty()) {
                    pesquisaLancamentoCaixa.txtPessoaCodigo.setText(pessoaCodigo);
                }

                if (pesquisaLancamentoCaixa.txtPessoaDescricao.getText().isEmpty()) {
                    pesquisaLancamentoCaixa.txtPessoaDescricao.setText(pessoaDescricao);
                }

                if (pesquisaLancamentoCaixa.txtDocumentoNumero.getText().isEmpty()) {
                    pesquisaLancamentoCaixa.txtDocumentoNumero.setText(documentoNumero);
                }

                pesquisaLancamentoCaixa.txtParcelaNumero.setText(parcelaNumero);

                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                BigDecimal valorPendente = new BigDecimal(totalReceber).subtract(new BigDecimal(valorRecebidoPago));
                BigDecimal valorReceber = new BigDecimal(totalReceber);
                
                if (valorPendente.compareTo(valorReceber) < 0){
                    pesquisaLancamentoCaixa.txtValorTotal.setText(valorPendente.toString()); 
                } else {
                    pesquisaLancamentoCaixa.txtValorTotal.setText(nf.format(new BigDecimal(totalReceber)));
                }                

                this.dispose();

            } else if (pesquisaLancamentoContasReceber != null) {
                pesquisaLancamentoContasReceber.setVisible(true);
                pesquisaLancamentoContasReceber.pack();
                pesquisaLancamentoContasReceber.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoContasReceber.txtClienteCodigo.setText(pessoaCodigo);
                pesquisaLancamentoContasReceber.txtClienteDescricao.setText(pessoaDescricao);
                pesquisaLancamentoContasReceber.txtDocumentoNumero.setText(documentoNumero);
                pesquisaLancamentoContasReceber.txtParcelaNumero.setText("");

                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String resultadoDataLancamento = formatoString.format(formatoBanco.parse(dataLancamento));
                    pesquisaLancamentoContasReceber.txtDataLancamento.setText(resultadoDataLancamento);
                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }

                pesquisaLancamentoContasReceber.cmbFormaPagamento.getModel().setSelectedItem(formaPagamento);
                pesquisaLancamentoContasReceber.cmbCategoria.getModel().setSelectedItem(categoria);

                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                pesquisaLancamentoContasReceber.txtValorTotalFatura.setText(nf.format(new BigDecimal(totalFatura)));
                pesquisaLancamentoContasReceber.txtPlanilha.setText(planilha);
                pesquisaLancamentoContasReceber.txtObservacoes.setText(observacoes); 

                conecta.conexao();
                conecta.executaSql("SELECT * FROM CONTASRECEBER WHERE DOCUMENTONUMERO = '" + documentoNumero + "' AND CLIENTECODIGO = '" + pessoaCodigo + "'");
                try {
                    conecta.rs.first();
                    do {
                        DefaultTableModel valores = (DefaultTableModel) pesquisaLancamentoContasReceber.tblParcelas.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("PARCELANUMERO"), formatoString.format(conecta.rs.getDate("DATAVENCIMENTO")), conecta.rs.getString("VALORDUPLICATA"), 
                                                    conecta.rs.getString("ACRESCIMOS"), conecta.rs.getString("DESCONTOS"), conecta.rs.getString("TOTALRECEBER")});
                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
                    conecta.desconecta();
                }

            pesquisaLancamentoContasReceber.alterando = 1;
            pesquisaLancamentoContasReceber.incluindo = 0;
            pesquisaLancamentoContasReceber.btnExcluirLancamento.setEnabled(true);

            this.dispose();

            } else if (pesquisaLancamentoContasPagar != null) {
                pesquisaLancamentoContasPagar.setVisible(true);
                pesquisaLancamentoContasPagar.pack();
                pesquisaLancamentoContasPagar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pesquisaLancamentoContasPagar.txtFornecedorCodigo.setText(pessoaCodigo);
                pesquisaLancamentoContasPagar.txtFornecedorDescricao.setText(pessoaDescricao);
                pesquisaLancamentoContasPagar.txtDocumentoNumero.setText(documentoNumero);

                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String resultadoDataLancamento = formatoString.format(formatoBanco.parse(dataLancamento));
                    pesquisaLancamentoContasPagar.txtDataLancamento.setText(resultadoDataLancamento);
                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }

                pesquisaLancamentoContasPagar.cmbFormaPagamento.getModel().setSelectedItem(formaPagamento);
                pesquisaLancamentoContasPagar.cmbCategoria.getModel().setSelectedItem(categoria);
                pesquisaLancamentoContasPagar.txtParcelaNumero.setText(""); 

                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                pesquisaLancamentoContasPagar.txtValorTotalFatura.setText(nf.format(new BigDecimal(totalFatura)));
                pesquisaLancamentoContasPagar.txtPlanilha.setText(planilha);
                pesquisaLancamentoContasPagar.txtObservacoes.setText(observacoes);

                conecta.conexao();
                conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE DOCUMENTONUMERO = '" + documentoNumero + "'");
                try {
                    conecta.rs.first();
                    do {
                        DefaultTableModel valores = (DefaultTableModel) pesquisaLancamentoContasPagar.tblParcelas.getModel();
                        valores.addRow(new String[]{conecta.rs.getString("PARCELANUMERO"), formatoString.format(conecta.rs.getDate("DATAVENCIMENTO")), conecta.rs.getString("VALORDUPLICATA"), conecta.rs.getString("ACRESCIMOS"), conecta.rs.getString("DESCONTOS"), conecta.rs.getString("TOTALPAGAR")});
                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
                    conecta.desconecta();
                }

                pesquisaLancamentoContasPagar.alterando = 1;
                pesquisaLancamentoContasPagar.incluindo = 0;
                pesquisaLancamentoContasPagar.btnExcluirLancamento.setEnabled(true);

                this.dispose();
            }        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }        
        conecta.desconecta();
    }//GEN-LAST:event_tblConsultaFinanceiroMouseClicked

    private void txtDocumentoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoNumeroKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoNumeroKeyTyped

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtDtVencimentoInicial.setText("");
        txtDtVencimentoFinal.setText("");
        txtDtLancamentoInicial.setText("");
        txtDtLancamentoFinal.setText("");
        txtPessoaDescricao.setText("");
        txtDocumentoNumero.setText("");
        txtTotalPagar.setText("");
        txtTotalReceber.setText("");
        cmbCategoria.setSelectedItem("SELECIONE");
        cmbFormaPagamento.setSelectedItem("SELECIONE");
        chbPendentes.setSelected(false);
        chbPendentes.setEnabled(true);
        chbLiquidadas.setSelected(false);
        chbLiquidadas.setEnabled(true);
        chbContasPagar.setSelected(false);
        chbContasPagar.setEnabled(true);
        chbContasReceber.setSelected(false);
        chbContasReceber.setEnabled(true);
    }//GEN-LAST:event_btnLimparActionPerformed

    public void desabilitarCampos() {
        txtDtVencimentoInicial.setEnabled(false);
        txtDtVencimentoFinal.setEnabled(false);
        txtDtLancamentoInicial.setEnabled(false);
        txtDtLancamentoFinal.setEnabled(false);
        txtPessoaCodigo.setEnabled(false); 
        txtPessoaDescricao.setEnabled(false);
        txtDocumentoNumero.setEnabled(false);
        txtTotalPagar.setEnabled(false);
        txtTotalReceber.setEnabled(false);
        cmbCategoria.setSelectedItem("SELECIONE");
        cmbCategoria.setEnabled(false);
        cmbFormaPagamento.setSelectedItem("SELECIONE");
        cmbFormaPagamento.setEnabled(false); 
        chbPendentes.setEnabled(false);
        chbLiquidadas.setEnabled(false);
        chbContasPagar.setEnabled(false);
        chbContasReceber.setEnabled(false);    
    }
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        txtTotalPagar.setText("");
        txtTotalReceber.setText("");

        filtrosPesquisa(this, null, null, null);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void popularComboFormasPagamento() {
        conecta.conexao();
        conecta.executaSql("SELECT CODIGO, DESCRICAO FROM FORMASPAGAMENTO ORDER BY DESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbFormaPagamento.addItem(conecta.rs.getString("DESCRICAO").trim());
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar históricos cadastrados! \n ERRO: " + ex);
        }
    }

    private void popularComboCategoria() {
        conecta.conexao();
        conecta.executaSql("SELECT CODIGO, DESCRICAO FROM CATEGORIASFINANCEIRO ORDER BY DESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbCategoria.addItem(conecta.rs.getString("DESCRICAO").trim());
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar categorias cadastradas! \n ERRO: " + ex);
        }
    }

    
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaContasPagarReceber().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLimpar;
    public javax.swing.JButton btnPesquisar;
    public javax.swing.JCheckBox chbContasPagar;
    public javax.swing.JCheckBox chbContasReceber;
    public javax.swing.JCheckBox chbLiquidadas;
    public javax.swing.JCheckBox chbPendentes;
    public javax.swing.JComboBox cmbCategoria;
    public javax.swing.JComboBox cmbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblConsultaFinanceiro;
    public javax.swing.JTextField txtDocumentoNumero;
    public javax.swing.JFormattedTextField txtDtLancamentoFinal;
    public javax.swing.JFormattedTextField txtDtLancamentoInicial;
    public javax.swing.JFormattedTextField txtDtVencimentoFinal;
    public javax.swing.JFormattedTextField txtDtVencimentoInicial;
    public javax.swing.JTextField txtPessoaCodigo;
    public javax.swing.JTextField txtPessoaDescricao;
    private javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtTotalReceber;
    // End of variables declaration//GEN-END:variables
}
