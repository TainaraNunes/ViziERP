package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import Beans.BeansLancamentoCaixa;
import Beans.ModeloTabela;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoLancamentoCaixa;

public class LancamentoCaixa extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    BeansLancamentoCaixa lanca = new BeansLancamentoCaixa();
    ConsultaCheques consultaCheques = new ConsultaCheques(this);
    ConsultaContasPagarReceber pesquisaDuplicatas = new ConsultaContasPagarReceber();
    DaoLancamentoCaixa dao = new DaoLancamentoCaixa();
    PesquisaPessoas pesquisaPessoas = new PesquisaPessoas();
    PesquisaHistoricos pesquisaHistoricos = new PesquisaHistoricos();
    
    public int incluindo = 1;
    public int alterando = 0;
    public String chequeNumero = "", bancoCodigo = "";

    public LancamentoCaixa() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/lancamentocaixa.png")).getImage());        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        txtHistorico.setDocument(new Teclas());
        txtContraPartida.setDocument(new Teclas());
        txtPessoaDescricao.setDocument(new Teclas());
        txtObservacoes.setDocument(new Teclas());
        txtDataLancamento.setText(format.format(new Date()));
        
        btnExcluir.setEnabled(false);
        
        consultaLancamentos(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPessoaDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDataLancamento = new javax.swing.JFormattedTextField();
        txtPessoaCodigo = new javax.swing.JTextField();
        btnPesquisarPessoas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDocumentoNumero = new javax.swing.JTextField();
        txtParcelaNumero = new javax.swing.JTextField();
        btnPesquisarDuplicatas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtObservacoes = new javax.swing.JTextField();
        btnPesquisarLancamentos = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        txtHistorico = new javax.swing.JTextField();
        btnPesquisarHistorico = new javax.swing.JButton();
        txtContraPartida = new javax.swing.JTextField();
        btnPesquisarContraPartida = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLancamentosCaixa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnNovoLancamento = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento de Caixa");
        setName("frmLancamentoCaixa"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText(" Histórico:");

        jLabel2.setText("Cliente/Fornecedor:");

        jLabel3.setText("Data de Lançamento:");

        try {
            txtDataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataLancamento.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        txtPessoaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPessoaCodigoKeyTyped(evt);
            }
        });

        btnPesquisarPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPessoasActionPerformed(evt);
            }
        });

        jLabel4.setText("Documento:");

        txtDocumentoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoNumeroKeyTyped(evt);
            }
        });

        btnPesquisarDuplicatas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarDuplicatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarDuplicatasActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor:");

        txtValorTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalFocusLost(evt);
            }
        });
        txtValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalKeyTyped(evt);
            }
        });

        jLabel6.setText("Contra Partida:");

        jLabel7.setText("Observações:");

        btnPesquisarLancamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarLancamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarLancamentosActionPerformed(evt);
            }
        });

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/help.png"))); // NOI18N
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnPesquisarHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarHistoricoActionPerformed(evt);
            }
        });

        btnPesquisarContraPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarContraPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarContraPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraPartida)
                            .addComponent(txtHistorico)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPessoaCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDocumentoNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtParcelaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisarDuplicatas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPessoaDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisarLancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisarPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarContraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(197, 197, 197)
                        .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtObservacoes))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPesquisarHistorico, btnPesquisarPessoas});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHelp)
                    .addComponent(btnPesquisarLancamentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisarHistorico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtContraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(btnPesquisarContraPartida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPessoaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPessoaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnPesquisarDuplicatas)
                            .addComponent(txtParcelaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDocumentoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(btnPesquisarPessoas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPesquisarHistorico, btnPesquisarPessoas});

        tblLancamentosCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Planilha", "Cliente/Fornecedor", "Documento", "Histórico", "Contra Partida", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLancamentosCaixa.getTableHeader().setReorderingAllowed(false);
        tblLancamentosCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLancamentosCaixaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLancamentosCaixa);
        if (tblLancamentosCaixa.getColumnModel().getColumnCount() > 0) {
            tblLancamentosCaixa.getColumnModel().getColumn(0).setResizable(false);
            tblLancamentosCaixa.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLancamentosCaixa.getColumnModel().getColumn(1).setResizable(false);
            tblLancamentosCaixa.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblLancamentosCaixa.getColumnModel().getColumn(2).setResizable(false);
            tblLancamentosCaixa.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLancamentosCaixa.getColumnModel().getColumn(3).setResizable(false);
            tblLancamentosCaixa.getColumnModel().getColumn(3).setPreferredWidth(170);
            tblLancamentosCaixa.getColumnModel().getColumn(4).setResizable(false);
            tblLancamentosCaixa.getColumnModel().getColumn(4).setPreferredWidth(170);
            tblLancamentosCaixa.getColumnModel().getColumn(5).setResizable(false);
            tblLancamentosCaixa.getColumnModel().getColumn(5).setPreferredWidth(90);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovoLancamento.setText("Novo");
        btnNovoLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoLancamentoActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoLancamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnGravar, btnNovoLancamento, btnSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnNovoLancamento)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPessoasActionPerformed
        if (!txtPessoaDescricao.getText().isEmpty()) {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.setResizable(false);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS WHERE RAZAOSOCIAL LIKE '%" + txtPessoaDescricao.getText().trim() + "%' ORDER BY RAZAOSOCIAL");
        } else {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS ORDER BY RAZAOSOCIAL");
        }
    }//GEN-LAST:event_btnPesquisarPessoasActionPerformed

    private void btnPesquisarDuplicatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarDuplicatasActionPerformed
        pesquisaDuplicatas = new ConsultaContasPagarReceber();
        pesquisaDuplicatas.setLocationRelativeTo(null);
        pesquisaDuplicatas.setVisible(true);
        pesquisaDuplicatas.filtrosPesquisa(null, this, null, null);
    }//GEN-LAST:event_btnPesquisarDuplicatasActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLancamento = LocalDate.parse(txtDataLancamento.getText(), formato);
        lanca.setDataLancamento(dataLancamento);

        String historico = txtHistorico.getText();
        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOCODIGO FROM HISTORICOS WHERE HISTORICODESCRICAO = '" + historico + "'");
        try {
            if (conecta.rs.next()) {
                historico = conecta.rs.getString("HISTORICOCODIGO");
                lanca.setOperacao(historico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

        String contraPartida = txtContraPartida.getText();
        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOCODIGO FROM HISTORICOS WHERE HISTORICODESCRICAO = '" + contraPartida + "'");
        try {
            if (conecta.rs.next()) {
                contraPartida = conecta.rs.getString("HISTORICOCODIGO");
                lanca.setContraPartida(contraPartida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

        lanca.setPessoaCodigo(Integer.parseInt(txtPessoaCodigo.getText())); 
        lanca.setDocumentoNumero(txtDocumentoNumero.getText());
        lanca.setParcelaNumero(txtParcelaNumero.getText());
        
        if (txtValorTotal.getText().contains("R$")) {
            String valor = txtValorTotal.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotal = new BigDecimal(valor);
            lanca.setValor(valorTotal);
        } else {
            BigDecimal valorTotal = new BigDecimal(txtValorTotal.getText());
            lanca.setValor(valorTotal);
        }

        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este lançamento?");
        if (resposta == JOptionPane.YES_OPTION) {
            dao.lancamentoCaixaEliminar(lanca);
            limpaCampos();
            btnExcluir.setEnabled(false);
            consultaLancamentos(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDataLancamento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data de lançamento no caixa!");
            txtDataLancamento.requestFocus();
        } else if (txtPessoaCodigo.getText().trim().isEmpty() || txtPessoaDescricao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione o cliente ou fornecedor!");
            btnPesquisarPessoas.requestFocus();
        } else if (txtDocumentoNumero.getText().isEmpty() && (txtHistorico.getText().trim().contains("DUPLICATA") || txtHistorico.getText().trim().contains("DUPLICATA"))) {
            JOptionPane.showMessageDialog(null, "Selecione o documento a ser lançado!");
            btnPesquisarDuplicatas.requestFocus();
        } else if (txtHistorico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o histórico para lançamento!");
            txtHistorico.requestFocus();
        } else if (txtContraPartida.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe a forma de pagamento para lançamento!");
            txtContraPartida.requestFocus();
        } else if (txtValorTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor da baixa!");
            txtValorTotal.requestFocus();
        } else {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLancamento = LocalDate.parse(txtDataLancamento.getText(), formato);
            lanca.setDataLancamento(dataLancamento);

            String historico = txtHistorico.getText();
            conecta.conexao();
            conecta.executaSql("SELECT HISTORICOCODIGO FROM HISTORICOS WHERE HISTORICODESCRICAO = '" + historico + "'");
            try {
                if (conecta.rs.next()) {
                    historico = conecta.rs.getString("HISTORICOCODIGO");
                    lanca.setOperacao(historico);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String contraPartida = txtContraPartida.getText();
            conecta.conexao();
            conecta.executaSql("SELECT HISTORICOCODIGO FROM HISTORICOS WHERE HISTORICODESCRICAO = '" + contraPartida + "'");
            try {
                if (conecta.rs.next()) {
                    contraPartida = conecta.rs.getString("HISTORICOCODIGO");
                    lanca.setContraPartida(contraPartida);
                }
            } catch (SQLException ex) {
                Logger.getLogger(LancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }

            lanca.setPessoaCodigo(Integer.parseInt(txtPessoaCodigo.getText()));
            lanca.setDocumentoNumero(txtDocumentoNumero.getText());
            lanca.setParcelaNumero(txtParcelaNumero.getText());

            if (txtValorTotal.getText().contains("R$")) {
                String valor = txtValorTotal.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
                BigDecimal valorTotal = new BigDecimal(valor);
                lanca.setValor(valorTotal);
            } else {
                BigDecimal valorTotal = new BigDecimal(txtValorTotal.getText());
                lanca.setValor(valorTotal);
            }

            lanca.setObservacoes(txtObservacoes.getText());

            dao.lancamentoCaixaGravar(lanca, this);
            consultaLancamentos(false);
            limpaCampos();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void tblLancamentosCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLancamentosCaixaMouseClicked
        int index = tblLancamentosCaixa.getSelectedRow();
        TableModel model = tblLancamentosCaixa.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOOPERACAO.HISTORICODESCRICAO AS OPERACAO, "
                         + "       HISTORICOOPERACAO.MOVIMENTADUPLICATAS AS MOVIMENTADUPLICATAS, "
                         + "       HISTORICOCONTRAPARTIDA.HISTORICODESCRICAO AS CONTRAPARTIDA, "
                         + "       LANCAMENTOCAIXA.* "
                         + "FROM LANCAMENTOCAIXA "
                         + "     JOIN HISTORICOS AS HISTORICOOPERACAO ON (LANCAMENTOCAIXA.OPERACAO = HISTORICOOPERACAO.HISTORICOCODIGO) "
                         + "     JOIN HISTORICOS AS HISTORICOCONTRAPARTIDA ON (LANCAMENTOCAIXA.CONTRAPARTIDA = HISTORICOCONTRAPARTIDA.HISTORICOCODIGO) "
                         + "WHERE PLANILHA = '" + index + "' "
                         + "ORDER BY PLANILHA ");
        try {
            conecta.rs.first();
            String planilhaSelecionada = model.getValueAt(index, 0).toString();
            String pessoaDescricao = model.getValueAt(index, 1).toString();
            String documentoNumero = model.getValueAt(index, 2).toString().substring(0, 9);
            String parcelaNumero = model.getValueAt(index, 2).toString().substring(10, 16);
            String operacao = model.getValueAt(index, 3).toString();
            String contrapartida = model.getValueAt(index, 4).toString();
            String valor = model.getValueAt(index, 5).toString();
            String observacoes = model.getValueAt(index, 6).toString();
            String pessoaCodigo = model.getValueAt(index, 7).toString();
            
            String dataLancamento = model.getValueAt(index, 8).toString();
            SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String resultadoDataLancamento = formatoString.format(formatoBanco.parse(dataLancamento));
                txtDataLancamento.setText(resultadoDataLancamento);
            } catch (ParseException ex) {
                Logger.getLogger(PesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtHistorico.setText(operacao);
            txtContraPartida.setText(contrapartida);
            txtPessoaCodigo.setText(pessoaCodigo);
            txtPessoaDescricao.setText(pessoaDescricao);
            txtDocumentoNumero.setText(documentoNumero);
            txtParcelaNumero.setText(parcelaNumero);

            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorTotal.setText(nf.format(new BigDecimal(valor)));

            txtObservacoes.setText(observacoes);
            lanca.setPlanilha(Integer.parseInt(planilhaSelecionada));

            txtPessoaCodigo.setEnabled(false);
            txtPessoaDescricao.setEnabled(false);
            txtDocumentoNumero.setEnabled(false);
            txtParcelaNumero.setEnabled(false);
            
            if (txtDocumentoNumero.getText().trim().isEmpty()) {
                txtValorTotal.setEnabled(true);
            } else {
                txtValorTotal.setEnabled(false);
            }
            
            btnExcluir.setEnabled(true);
            
            alterando = 1;
            incluindo = 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tblLancamentosCaixaMouseClicked

    private void btnPesquisarLancamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarLancamentosActionPerformed
        if (txtDataLancamento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data para carregar os lançamentos!");
            txtDataLancamento.requestFocus();
        } else {
            consultaLancamentos(true);
        }
    }//GEN-LAST:event_btnPesquisarLancamentosActionPerformed

    private void btnNovoLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoLancamentoActionPerformed
        limpaCampos();
        txtPessoaCodigo.setEnabled(true);
        txtPessoaDescricao.setEnabled(true);
        txtDocumentoNumero.setEnabled(true);
        txtParcelaNumero.setEnabled(true);
        txtValorTotal.setEnabled(true);
        btnExcluir.setEnabled(false);
    }//GEN-LAST:event_btnNovoLancamentoActionPerformed

    private void txtDocumentoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoNumeroKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoNumeroKeyTyped

    private void txtValorTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalKeyTyped

    private void txtValorTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalFocusLost
        String sv = txtValorTotal.getText();
        if (!txtValorTotal.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtValorTotal.setText(valorFormatado);
        } else {
            txtValorTotal.setText("R$0,00");
        }
    }//GEN-LAST:event_txtValorTotalFocusLost

    private void txtPessoaCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPessoaCodigoKeyTyped
        String caracteres = "0987654321,.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPessoaCodigoKeyTyped

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        TelaHelp obj = new TelaHelp("- Para lançamentos de pagamento e recebimento de duplicatas: \n"
                                  + "  Selecione a opção desejada no campo 'Operação' e a conta bancária ou conta de caixa que será utilizada para pagar ou receber, no campo 'Contra Partida'. \n"
                                  + "  Em seguida selecione a duplicata a partir do cliente ou informando o número do documento. Os dados serão carregados automaticamente,"
                                  + " depois é só informar observações necessárias e gravar.\n\n"
                                  + "- Para lançamentos sem duplicatas, como depósitos e retiradas das contas bancárias ou do caixa, selecione o tipo da operação e no campo 'Contra Partida'"
                                  + " a conta do banco ou do caixa que será movimentada. Informe o valor do lançamento, observações e grave. \n\n "
                                  + "- Para consultar lançamentos de outras datas informe o campo 'Data de Lançamento' e clique em 'Pesquisar'."
                                  + " Os lançamentos serão listados na tela. \n\n"
                                  + "- Para excluir um registro lançado incorretamente, selecione o lançamento na tabela de lançamentos, clique em 'Excluir', e confirme a solicitação. \n\n"
                                  + "- Para realizar novo lançamento sem sair da tela, utilize o botão 'Novo', depois de gravar um lançamemto. ");
        
                
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);        
    }//GEN-LAST:event_btnHelpActionPerformed

    private void txtDuplicataParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuplicataParcelaActionPerformed

    }//GEN-LAST:event_txtDuplicataParcelaActionPerformed

    private void btnPesquisarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarHistoricoActionPerformed
        if (!txtHistorico.getText().isEmpty()) {
            pesquisaHistoricos = new PesquisaHistoricos();
            pesquisaHistoricos.setLocationRelativeTo(null);
            pesquisaHistoricos.setVisible(true);
            pesquisaHistoricos.setResizable(false);
            pesquisaHistoricos.preencherTabela(null, this, null, "SELECT * "
                                                         + "FROM HISTORICOS "
                                                         + "WHERE HISTORICODESCRICAO LIKE '%" + txtHistorico.getText().trim() + "%' AND TIPOLANCAMENTO = 'E' OR "
                                                         + "      HISTORICODESCRICAO LIKE '%" + txtHistorico.getText().trim() + "%' AND TIPOLANCAMENTO = 'S' "
                                                         + "ORDER BY HISTORICODESCRICAO ");
        } else {
            pesquisaHistoricos = new PesquisaHistoricos();
            pesquisaHistoricos.setLocationRelativeTo(null);
            pesquisaHistoricos.setVisible(true);
            pesquisaHistoricos.preencherTabela(null, this, null, "SELECT * FROM HISTORICOS WHERE TIPOLANCAMENTO = 'E' OR TIPOLANCAMENTO = 'S' ORDER BY HISTORICODESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarHistoricoActionPerformed

    private void btnPesquisarContraPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarContraPartidaActionPerformed
        if (!txtContraPartida.getText().isEmpty()) {
            pesquisaHistoricos = new PesquisaHistoricos();
            pesquisaHistoricos.setLocationRelativeTo(null);
            pesquisaHistoricos.setVisible(true);
            pesquisaHistoricos.setResizable(false);
            pesquisaHistoricos.preencherTabela(null, null, this, "SELECT * "
                                                         + "FROM HISTORICOS "
                                                         + "WHERE HISTORICODESCRICAO LIKE '%" + txtContraPartida.getText().trim() + "%' AND "
                                                         + "      TIPOLANCAMENTO = 'C' "
                                                         + "ORDER BY HISTORICODESCRICAO ");
        } else {
            pesquisaHistoricos = new PesquisaHistoricos();
            pesquisaHistoricos.setLocationRelativeTo(null);
            pesquisaHistoricos.setVisible(true);
            pesquisaHistoricos.preencherTabela(null, null, this, "SELECT * FROM HISTORICOS WHERE TIPOLANCAMENTO = 'C' ORDER BY HISTORICODESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarContraPartidaActionPerformed

    public void carregarCheque(){
        consultaCheques = new ConsultaCheques(this);
        consultaCheques.setLocationRelativeTo(null);
        consultaCheques.setVisible(true);
        consultaCheques.habilitarBotaoCadastro(true); 
    }

    public void consultaLancamentos(boolean mostrarMensagem) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLancamento = LocalDate.parse(txtDataLancamento.getText(), formato);
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Planilha", "Cliente/Fornecedor", "Documento", "Operação", "Contra Partida", "Valor"};
        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOOPERACAO.HISTORICODESCRICAO AS OPERACAO, "
                         + "       HISTORICOCONTRAPARTIDA.HISTORICODESCRICAO AS CONTRAPARTIDA, "
                         + "       PESSOAS.CODIGO, "
                         + "       PESSOAS.RAZAOSOCIAL AS PESSOADESCRICAO, "
                         + "       LANCAMENTOCAIXA.* "
                         + "FROM LANCAMENTOCAIXA "
                         + "     JOIN HISTORICOS AS HISTORICOOPERACAO ON (LANCAMENTOCAIXA.OPERACAO = HISTORICOOPERACAO.HISTORICOCODIGO) "
                         + "     JOIN HISTORICOS AS HISTORICOCONTRAPARTIDA ON (LANCAMENTOCAIXA.CONTRAPARTIDA = HISTORICOCONTRAPARTIDA.HISTORICOCODIGO) "
                         + "     JOIN PESSOAS ON(PESSOAS.CODIGO = LANCAMENTOCAIXA.PESSOACODIGO) "                  
                         + "WHERE DATALANCAMENTO = '" + dataLancamento + "' "
                         + "ORDER BY PLANILHA DESC");

        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getInt("PLANILHA"), conecta.rs.getString("PESSOADESCRICAO").trim(), conecta.rs.getString("DOCUMENTONUMERO") + "-" + conecta.rs.getString("PARCELANUMERO"), conecta.rs.getString("OPERACAO"), conecta.rs.getString("CONTRAPARTIDA"), conecta.rs.getString("VALOR"), conecta.rs.getString("OBSERVACOES"), conecta.rs.getString("PESSOACODIGO"), conecta.rs.getString("DATALANCAMENTO")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            if (mostrarMensagem == true) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
            }
            conecta.desconecta();
        }

        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblLancamentosCaixa.setModel(table);
        tblLancamentosCaixa.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblLancamentosCaixa.getColumnModel().getColumn(0).setResizable(false);
        tblLancamentosCaixa.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblLancamentosCaixa.getColumnModel().getColumn(1).setResizable(false);
        tblLancamentosCaixa.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblLancamentosCaixa.getColumnModel().getColumn(2).setResizable(false);
        tblLancamentosCaixa.getColumnModel().getColumn(3).setPreferredWidth(170);
        tblLancamentosCaixa.getColumnModel().getColumn(3).setResizable(false);
        tblLancamentosCaixa.getColumnModel().getColumn(4).setPreferredWidth(170);
        tblLancamentosCaixa.getColumnModel().getColumn(4).setResizable(false);
        tblLancamentosCaixa.getColumnModel().getColumn(5).setPreferredWidth(90);
        tblLancamentosCaixa.getColumnModel().getColumn(5).setResizable(false);

        tblLancamentosCaixa.getTableHeader().setReorderingAllowed(false); //não permite reordenar o cabeçalho;
        tblLancamentosCaixa.setAutoResizeMode(tblLancamentosCaixa.AUTO_RESIZE_OFF); //não permite redimensionar a tabela;
        tblLancamentosCaixa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conecta.desconecta();
    }

    public void limpaCampos() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtDataLancamento.setText(format.format(new Date()));
        txtHistorico.setText("");
        txtContraPartida.setText(""); 
        txtPessoaCodigo.setText("");
        txtPessoaDescricao.setText("");
        txtDocumentoNumero.setText("");
        txtParcelaNumero.setText("");
        txtValorTotal.setText("");
        txtObservacoes.setText("");
        consultaLancamentos(false);
        incluindo = 1;
        alterando = 0;
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LancamentoCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnNovoLancamento;
    public javax.swing.JButton btnPesquisarContraPartida;
    private javax.swing.JButton btnPesquisarDuplicatas;
    public javax.swing.JButton btnPesquisarHistorico;
    private javax.swing.JButton btnPesquisarLancamentos;
    public javax.swing.JButton btnPesquisarPessoas;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    public javax.swing.JTable tblLancamentosCaixa;
    public javax.swing.JTextField txtContraPartida;
    public javax.swing.JFormattedTextField txtDataLancamento;
    public javax.swing.JTextField txtDocumentoNumero;
    public javax.swing.JTextField txtHistorico;
    public javax.swing.JTextField txtObservacoes;
    public javax.swing.JTextField txtParcelaNumero;
    public javax.swing.JTextField txtPessoaCodigo;
    public javax.swing.JTextField txtPessoaDescricao;
    public javax.swing.JFormattedTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
