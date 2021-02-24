package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import Beans.BeansDespesasVeiculos;
import Beans.ModeloTabela;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoDespesasVeiculos;

public class DespesasVeiculos extends javax.swing.JFrame {

    BeansDespesasVeiculos despesas = new BeansDespesasVeiculos();
    ConectaBD conecta = new ConectaBD();
    DaoDespesasVeiculos dao = new DaoDespesasVeiculos();
    PesquisaVeiculos pesquisaVeiculos = new PesquisaVeiculos();
    PesquisaPessoas pesquisaPessoas = new PesquisaPessoas();

    public int incluindo = 1;
    public int alterando = 0;
    public int planilha = 0, veiculoCodigo = 0;

    public DespesasVeiculos() {
        initComponents();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtDataLancamento.setText(format.format(new Date()));

        txtVeiculoPlaca.setDocument(new Teclas());
        txtVeiculoModelo.setDocument(new Teclas());
        txtFornecedorDescricao.setDocument(new Teclas());
        txtDespesaDescricao.setDocument(new Teclas()); 

        btnExcluir.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVeiculoPlaca = new javax.swing.JTextField();
        btnPesqusiarVeiculo = new javax.swing.JButton();
        txtVeiculoModelo = new javax.swing.JTextField();
        txtDespesaDescricao = new javax.swing.JTextField();
        txtDespesaValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFornecedorDescricao = new javax.swing.JTextField();
        btnPesqusiarFornecedor = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDataLancamento = new javax.swing.JFormattedTextField();
        txtFornecedorCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculoDespesas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Despesas de Veículos");
        setName("frmDespesasVeiculos"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Placa:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Valor:");

        jLabel4.setText("Despesa:");

        txtVeiculoPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVeiculoPlacaKeyTyped(evt);
            }
        });

        btnPesqusiarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesqusiarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqusiarVeiculoActionPerformed(evt);
            }
        });

        txtDespesaValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDespesaValorFocusLost(evt);
            }
        });
        txtDespesaValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDespesaValorKeyTyped(evt);
            }
        });

        jLabel5.setText("Fornecedor:");

        btnPesqusiarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesqusiarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqusiarFornecedorActionPerformed(evt);
            }
        });

        jLabel6.setText("Data:");

        try {
            txtDataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataLancamento.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel7.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BATERIA", "CARROCERIA", "COMBUSTIVEL", "DESPACHANTE", "ELETRICA", "IMPOSTOS", "LATARIA E PINTURA", "LIMPEZA", "MECANICA", "MULTAS", "PECAS E ACESSORIOS", "PNEUS", "RECAPAGEM", "TAPECARIA", "TORNEARIA", "OUTROS" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDespesaDescricao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFornecedorCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txtVeiculoPlaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVeiculoModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                            .addComponent(txtFornecedorDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesqusiarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqusiarFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDespesaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesqusiarVeiculo)
                    .addComponent(txtVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesqusiarFornecedor)
                    .addComponent(txtFornecedorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFornecedorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDespesaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDespesaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

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

        btnAbandonar.setText("Abandonar");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAbandonar)
                    .addComponent(btnSair)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblVeiculoDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Lcto", "Placa", "Modelo", "Fornecedor", "Despesa", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVeiculoDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiculoDespesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVeiculoDespesas);
        if (tblVeiculoDespesas.getColumnModel().getColumnCount() > 0) {
            tblVeiculoDespesas.getColumnModel().getColumn(0).setResizable(false);
            tblVeiculoDespesas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblVeiculoDespesas.getColumnModel().getColumn(1).setResizable(false);
            tblVeiculoDespesas.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblVeiculoDespesas.getColumnModel().getColumn(2).setResizable(false);
            tblVeiculoDespesas.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblVeiculoDespesas.getColumnModel().getColumn(3).setResizable(false);
            tblVeiculoDespesas.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblVeiculoDespesas.getColumnModel().getColumn(4).setResizable(false);
            tblVeiculoDespesas.getColumnModel().getColumn(4).setPreferredWidth(185);
            tblVeiculoDespesas.getColumnModel().getColumn(5).setResizable(false);
            tblVeiculoDespesas.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDataLancamento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data do lançamento!");
            txtDataLancamento.requestFocus();
            return;
        } else if (txtVeiculoPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a placa do veículo!");
            txtVeiculoPlaca.requestFocus();
            return;
        } else if (txtVeiculoModelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o modelo do veículo!");
            txtVeiculoModelo.requestFocus();
            return;
        } else if (txtDespesaDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição da despesa para o veículo!");
            txtDespesaDescricao.requestFocus();
            return;
        } else if (txtDespesaValor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor da despesa!");
            txtDespesaValor.requestFocus();
            return;
        } else {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLancamento = LocalDate.parse(txtDataLancamento.getText(), formato);
            despesas.setDataLancamento(dataLancamento);            
            
            despesas.setVeiculoCodigo(veiculoCodigo);
            despesas.setFornecedorCodigo(Integer.parseInt(txtFornecedorCodigo.getText()));
            despesas.setDespesaDescricao(txtDespesaDescricao.getText());
            despesas.setCategoria(cmbCategoria.getSelectedItem().toString());             
            
            String despesaValor = txtDespesaValor.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorDespesa = new BigDecimal(despesaValor);
            despesas.setDespesaValor(valorDespesa);
        }

        if (incluindo == 1) {
            dao.gravarDespesaVeiculo(despesas);
            limpaCampos();
        } else if (alterando == 1) {
            despesas.setVeiculoCodigo(veiculoCodigo);
            despesas.setPlanilha(planilha); 
            
            dao.alterarLancamentoDespesa(despesas);
            limpaCampos();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnPesqusiarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqusiarVeiculoActionPerformed
        if (!txtVeiculoPlaca.getText().isEmpty()) {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.setResizable(false);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS WHERE PLACA LIKE '%" + txtVeiculoPlaca.getText().trim() + "%' ORDER BY MODELO");
        } else if (!txtVeiculoModelo.getText().isEmpty()) {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.setResizable(false);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS WHERE MODELO LIKE '%" + txtVeiculoModelo.getText().trim() + "%' ORDER BY MODELO");
        } else {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS ORDER BY MODELO");
        }
    }//GEN-LAST:event_btnPesqusiarVeiculoActionPerformed

    private void btnPesqusiarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqusiarFornecedorActionPerformed
        if (!txtFornecedorDescricao.getText().isEmpty()) {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.setResizable(false);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS WHERE UPPER(RAZAOSOCIAL) LIKE '%" + txtFornecedorDescricao.getText().trim() + "%' ORDER BY RAZAOSOCIAL");
        } else {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS ORDER BY RAZAOSOCIAL");
        }
    }//GEN-LAST:event_btnPesqusiarFornecedorActionPerformed

    private void txtDespesaValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDespesaValorFocusLost
        String sv = txtDespesaValor.getText();
        if (!txtDespesaValor.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtDespesaValor.setText(valorFormatado);
        } else {
            JOptionPane.showMessageDialog(null, "Informe o valor da despesa!");
            txtDespesaValor.requestFocus();
        }
    }//GEN-LAST:event_txtDespesaValorFocusLost

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            despesas.setPlanilha(planilha);
            dao.excluirLancamentoDespesa(despesas);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtVeiculoPlaca.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisarLancamentos();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public void pesquisarLancamentos(){
        String whereData, wherePlaca, whereModelo, whereFornecedor;        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if (txtDataLancamento.getText().trim().length() < 10 ){
            whereData = "TRUE";
        } else {
            whereData = "VEICULOSDESPESAS.DATALANCAMENTO = '" + LocalDate.parse(txtDataLancamento.getText(), formato) + "'";
        }
        
        if (txtVeiculoPlaca.getText().isEmpty()){
            wherePlaca = "TRUE";
        } else {
            wherePlaca = "VEICULOS.PLACA = '" + txtVeiculoPlaca.getText() + "'";
        }
        
        if (txtVeiculoModelo.getText().isEmpty()){
            whereModelo = "TRUE";
        } else {
            whereModelo = "VEICULOS.MODELO = '" + txtVeiculoModelo.getText() + "'";
        }
        
        if (txtFornecedorCodigo.getText().isEmpty()){
            whereFornecedor = "TRUE";
        } else {
            whereFornecedor = "PESSOAS.CODIGO = '" + txtFornecedorCodigo.getText() + "'";
        }

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Data Lcto", "Placa", "Modelo", "Fornecedor", "Despesa", "Valor"};

        conecta.conexao();
        conecta.executaSql("SELECT VEICULOSDESPESAS.PLANILHA, "
                         + "       VEICULOSDESPESAS.DATALANCAMENTO, "
                         + "       VEICULOSDESPESAS.DESPESADESCRICAO, "
                         + "       VEICULOSDESPESAS.CATEGORIA, "
                         + "       VEICULOSDESPESAS.DESPESAVALOR, "
                         + "       VEICULOS.CODIGO AS VEICULOCODIGO, "
                         + "       VEICULOS.PLACA,  "
                         + "       VEICULOS.MODELO, "
                         + "       PESSOAS.CODIGO AS FORNECEDORCODIGO, "
                         + "       PESSOAS.FANTASIA "
                         + "FROM VEICULOSDESPESAS "
                         + "     JOIN VEICULOS ON(VEICULOS.CODIGO = VEICULOSDESPESAS.VEICULOCODIGO)   "
                         + "     JOIN PESSOAS ON(PESSOAS.CODIGO = VEICULOSDESPESAS.FORNECEDORCODIGO)  "
                         + "WHERE " + whereData + " AND   " 
                         + "      " + wherePlaca + " AND  "
                         + "      " + whereModelo + " AND "
                         + "      " + whereFornecedor + " ");

        try {
            conecta.rs.first();
            DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            String dataLancamento;       
            do {
                if (conecta.rs.getDate("DATALANCAMENTO") != null) {
                    dataLancamento = formatoData.format(conecta.rs.getDate("DATALANCAMENTO"));
                } else {
                    dataLancamento = null;
                }
                
                dados.add(new Object[]{dataLancamento, conecta.rs.getString("PLACA").trim(), conecta.rs.getString("MODELO").trim(), conecta.rs.getString("FANTASIA").trim(), conecta.rs.getString("DESPESADESCRICAO").trim(), conecta.rs.getString("DESPESAVALOR"), conecta.rs.getString("PLANILHA"), conecta.rs.getString("VEICULOCODIGO"), conecta.rs.getString("FORNECEDORCODIGO"), conecta.rs.getString("CATEGORIA").trim()});
                
            } while (conecta.rs.next());
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum lançamento localizado!");
        }
        conecta.desconecta();
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblVeiculoDespesas.setModel(table);
        tblVeiculoDespesas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblVeiculoDespesas.getColumnModel().getColumn(0).setResizable(false);
        tblVeiculoDespesas.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblVeiculoDespesas.getColumnModel().getColumn(1).setResizable(false);
        tblVeiculoDespesas.getColumnModel().getColumn(2).setPreferredWidth(90);
        tblVeiculoDespesas.getColumnModel().getColumn(2).setResizable(false);
        tblVeiculoDespesas.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblVeiculoDespesas.getColumnModel().getColumn(3).setResizable(false);
        tblVeiculoDespesas.getColumnModel().getColumn(4).setPreferredWidth(185);
        tblVeiculoDespesas.getColumnModel().getColumn(4).setResizable(false);
        tblVeiculoDespesas.getColumnModel().getColumn(5).setPreferredWidth(80);
        tblVeiculoDespesas.getColumnModel().getColumn(5).setResizable(false);

        tblVeiculoDespesas.getTableHeader().setReorderingAllowed(false);
        tblVeiculoDespesas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();            
    }
    
    private void tblVeiculoDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiculoDespesasMouseClicked
        int index = tblVeiculoDespesas.getSelectedRow();
        TableModel model = tblVeiculoDespesas.getModel();
        
        conecta.conexao();
        conecta.executaSql("SELECT VEICULOSDESPESAS.PLANILHA, "
                         + "       VEICULOSDESPESAS.DATALANCAMENTO, "
                         + "       VEICULOSDESPESAS.DESPESADESCRICAO, "
                         + "       VEICULOSDESPESAS.CATEGORIA, "
                         + "       VEICULOSDESPESAS.DESPESAVALOR, "
                         + "       VEICULOS.CODIGO AS VEICULOCODIGO, "
                         + "       VEICULOS.PLACA,  "
                         + "       VEICULOS.MODELO, "
                         + "       PESSOAS.CODIGO AS FORNECEDORCODIGO, "
                         + "       PESSOAS.FANTASIA "
                         + "FROM VEICULOSDESPESAS"
                         + "     JOIN VEICULOS ON (VEICULOS.CODIGO = VEICULOSDESPESAS.VEICULOCODIGO) "
                         + "     JOIN PESSOAS ON (PESSOAS.CODIGO = VEICULOSDESPESAS.FORNECEDORCODIGO) "
                         + "WHERE VEICULOSDESPESAS.PLANILHA = '" + index + "'"
                         + "ORDER BY DATALANCAMENTO ");
        
        try {
            conecta.rs.first();

            String dataLancamento = model.getValueAt(index, 0).toString();
            String veiculoPlaca = model.getValueAt(index, 1).toString();
            String veiculoModelo = model.getValueAt(index, 2).toString();
            String fornecedorDescricao = model.getValueAt(index, 3).toString();
            String despesaDescricao = model.getValueAt(index, 4).toString();
            String valor = model.getValueAt(index, 5).toString();
            int planilhaAltera = Integer.parseInt(model.getValueAt(index, 6).toString());
            int veiculoCodigoAltera = Integer.parseInt(model.getValueAt(index, 7).toString());
            String fornecedorCodigo = model.getValueAt(index, 8).toString();
            String categoria = model.getValueAt(index, 9).toString();
           
            planilha = planilhaAltera;
            txtDataLancamento.setText(dataLancamento);
            txtVeiculoPlaca.setText(veiculoPlaca);
            veiculoCodigo = veiculoCodigoAltera;
            txtVeiculoModelo.setText(veiculoModelo);
            txtFornecedorCodigo.setText(fornecedorCodigo);
            txtFornecedorDescricao.setText(fornecedorDescricao);
            txtDespesaDescricao.setText(despesaDescricao);
            cmbCategoria.getModel().setSelectedItem(categoria);
            
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtDespesaValor.setText(nf.format(new BigDecimal(valor)));

            btnExcluir.setEnabled(true);
            alterando = 1;
            incluindo = 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tblVeiculoDespesasMouseClicked

    private void txtDespesaValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDespesaValorKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDespesaValorKeyTyped

    private void txtVeiculoPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVeiculoPlacaKeyTyped
        String caracteres = "0987654321QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtVeiculoPlacaKeyTyped

    public void limpaCampos() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtDataLancamento.setText(format.format(new Date()));
        txtVeiculoPlaca.setText("");
        txtVeiculoModelo.setText("");
        txtFornecedorCodigo.setText("");
        txtFornecedorDescricao.setText("");
        txtDespesaDescricao.setText("");
        txtDespesaValor.setText("");
        cmbCategoria.setSelectedIndex(0);
        
        incluindo = 1;
        alterando = 0;
        
        pesquisarLancamentos();
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
                new DespesasVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    private javax.swing.JButton btnPesquisar;
    public javax.swing.JButton btnPesqusiarFornecedor;
    public javax.swing.JButton btnPesqusiarVeiculo;
    public javax.swing.JButton btnSair;
    private javax.swing.JComboBox cmbCategoria;
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
    private javax.swing.JTable tblVeiculoDespesas;
    public javax.swing.JFormattedTextField txtDataLancamento;
    public javax.swing.JTextField txtDespesaDescricao;
    public javax.swing.JTextField txtDespesaValor;
    public javax.swing.JTextField txtFornecedorCodigo;
    public javax.swing.JTextField txtFornecedorDescricao;
    public javax.swing.JTextField txtVeiculoModelo;
    public javax.swing.JTextField txtVeiculoPlaca;
    // End of variables declaration//GEN-END:variables
}
