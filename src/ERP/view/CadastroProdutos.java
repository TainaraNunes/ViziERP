package ERP.view;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.BeansProdutos;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoProdutos;

public class CadastroProdutos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    BeansProdutos prod = new BeansProdutos();
    DaoProdutos dao = new DaoProdutos();
    PesquisaProdutos pesquisaProdutos = new PesquisaProdutos();

    int incluindo = 1;
    int alterando = 0;

    public CadastroProdutos() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/cadastroprodutos.png")).getImage());

        txtPesquisaProduto.setDocument(new Teclas());
        txtDescricao.setDocument(new Teclas());
        txtMarca.setDocument(new Teclas());
        txtCodigo.setText(String.valueOf(dao.codigoProduto()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisaProduto = new javax.swing.JTextField();
        btnPesquisaProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbClassificacao = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDataUltimaCompra = new javax.swing.JFormattedTextField();
        txtDataValidade = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbGrupo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxAtivo = new javax.swing.JCheckBox();
        txtPrecoVenda = new javax.swing.JFormattedTextField();
        txtCustoCompra = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Procurar:");

        btnPesquisaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisaProduto)
                    .addComponent(txtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código:");

        jLabel3.setText("Descrição:");

        jLabel4.setText("Classificação");

        txtCodigo.setEnabled(false);

        jLabel5.setText("Marca:");

        cmbClassificacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EPI", "FERRAMENTAS", "PECA PARA REVENDA", "UNIFORMES", "USO OPERACIONAL", " " }));

        jLabel6.setText("Data Última Compra:");

        jLabel7.setText("Data de Validade:");

        try {
            txtDataUltimaCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataUltimaCompra.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        try {
            txtDataValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataValidade.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel8.setText("Grupo:");

        cmbGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACESSORIOS", "FERRAMENTAS", "FILTROS", "MATERIAL ECOLOGICO", "MATERIAL ELETRICO", "MATERIAL GALVANIZADO", "MATERIAL SEGURANCA", "MEDICAO", "MONITORAMENTO", "PECAS", "PNEUS", " ", " " }));

        jLabel9.setText("Preço de Venda:");

        jLabel10.setText("Custo Última Compra:");

        cbxAtivo.setSelected(true);
        cbxAtivo.setText("Ativo");

        txtPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtPrecoVenda.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtPrecoVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoVendaFocusLost(evt);
            }
        });
        txtPrecoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoVendaKeyTyped(evt);
            }
        });

        txtCustoCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtCustoCompra.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtCustoCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoCompraFocusLost(evt);
            }
        });
        txtCustoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustoCompraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataValidade, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(cbxAtivo))
                            .addComponent(txtDataUltimaCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addComponent(txtCustoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecoVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDataUltimaCompra, txtDataValidade, txtPrecoVenda});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbClassificacao, cmbGrupo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDataUltimaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCustoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cmbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(cmbGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbClassificacao, txtDataUltimaCompra, txtDataValidade, txtDescricao, txtMarca, txtPrecoVenda});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxAtivo, txtCodigo});

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnGravar, btnSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAbandonar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição do produto!");
            txtDescricao.requestFocus();
            return;
        } else if (txtMarca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a marca do produto!");
            txtMarca.requestFocus();
            return;
        } else if (cbxAtivo.isSelected() == true && cmbClassificacao.getSelectedItem().toString().trim().equalsIgnoreCase("EPI") && txtDataValidade.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data de vencimento do EPI!");
            txtDataValidade.requestFocus();
            return;
        }

        prod.setDescricao(txtDescricao.getText());
        prod.setMarca(txtMarca.getText());
        prod.setClassificacao((String) cmbClassificacao.getSelectedItem());
        prod.setGrupo((String) cmbGrupo.getSelectedItem());

        if (txtDataUltimaCompra.getText().trim().length() == 10) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataCompra = LocalDate.parse(txtDataUltimaCompra.getText(), formato);
            prod.setDataCompra(dataCompra);
        } else {
            prod.setDataCompra(null);
        }

        if (!txtCustoCompra.getText().isEmpty()) {
            String custo = txtCustoCompra.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal custoUltimaCompra = new BigDecimal(custo);
            prod.setCustoCompra(custoUltimaCompra);
        } else {
            prod.setCustoCompra(BigDecimal.ZERO);
        }

        if (!txtPrecoVenda.getText().isEmpty()) {
            String preco = txtPrecoVenda.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal precoVenda = new BigDecimal(preco);
            prod.setPrecoVenda(precoVenda);
        } else {
            prod.setPrecoVenda(BigDecimal.ZERO);
        }

        if (txtDataValidade.getText().trim().length() == 10) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataVencimento = LocalDate.parse(txtDataValidade.getText(), formato);
            prod.setDataVencimento(dataVencimento);
        } else {
            prod.setDataVencimento(null);
        }

        if (cbxAtivo.isSelected()) {
            prod.setAtivo(1);
        } else {
            prod.setAtivo(0);
        }

        if (txtDataUltimaCompra.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data de compra do produto!");
            txtDataUltimaCompra.requestFocus();
        } else if (txtCustoCompra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o custo da última compra do produto!");
            txtCustoCompra.requestFocus();
        }
        
        prod.setDescricao(txtDescricao.getText().toUpperCase());
        prod.setMarca(txtMarca.getText().toUpperCase());
        prod.setClassificacao((String) cmbClassificacao.getSelectedItem());
        prod.setGrupo((String) cmbGrupo.getSelectedItem());

        if (!txtCustoCompra.getText().isEmpty()) {
            String custo = txtCustoCompra.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal custoUltimaCompra = new BigDecimal(custo);
            prod.setCustoCompra(custoUltimaCompra);
        } else {
            prod.setCustoCompra(BigDecimal.ZERO);
        }

        if (!txtPrecoVenda.getText().isEmpty()) {
            String preco = txtPrecoVenda.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal precoVenda = new BigDecimal(preco);
            prod.setPrecoVenda(precoVenda);
        } else {
            prod.setPrecoVenda(BigDecimal.ZERO);
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataCompra = LocalDate.parse(txtDataUltimaCompra.getText(), formato);
        prod.setDataCompra(dataCompra);

        if (txtDataValidade.getText().trim().length() == 10) {
            LocalDate dataVencimento = LocalDate.parse(txtDataValidade.getText(), formato);
            prod.setDataVencimento(dataVencimento);
        } else {
            prod.setDataVencimento(null);
        }

        if (cbxAtivo.isSelected()) {
            prod.setAtivo(1);
        } else {
            prod.setAtivo(0);
        }
    
        if (incluindo == 1) {
            dao.gravarProdutos(prod);
            limpaCampos();
        } else if (alterando == 1) {
            prod.setCodigo(Integer.parseInt(txtCodigo.getText()));            
            dao.alterarProduto(prod);
            limpaCampos();
        }
        
    }//GEN-LAST:event_btnGravarActionPerformed

    private void txtCustoCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoCompraFocusLost
        String sv = txtCustoCompra.getText();
        if (!txtCustoCompra.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtCustoCompra.setText(valorFormatado);
        } else {
            txtCustoCompra.setText("R$0,00");
        }        
    }//GEN-LAST:event_txtCustoCompraFocusLost

    private void txtPrecoVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoVendaFocusLost
        String sv = txtPrecoVenda.getText();
        if (!txtPrecoVenda.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtPrecoVenda.setText(valorFormatado);
        } else {
            txtPrecoVenda.setText("R$0,00");
        }          
    }//GEN-LAST:event_txtPrecoVendaFocusLost

    private void txtCustoCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustoCompraKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCustoCompraKeyTyped

    private void txtPrecoVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoVendaKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecoVendaKeyTyped

    private void btnPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaProdutoActionPerformed
        limpaCampos();
        if (!txtPesquisaProduto.getText().isEmpty()) {
            pesquisaProdutos = new PesquisaProdutos();
            pesquisaProdutos.setLocationRelativeTo(null);
            pesquisaProdutos.setVisible(true);
            pesquisaProdutos.setResizable(false);
            pesquisaProdutos.preencherTabela(this, null, null, null, null, "SELECT * FROM PRODUTOS WHERE DESCRICAO LIKE '%" + txtPesquisaProduto.getText().trim() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaProdutos = new PesquisaProdutos();
            pesquisaProdutos.setLocationRelativeTo(null);
            pesquisaProdutos.setVisible(true);
            pesquisaProdutos.preencherTabela(this, null, null, null, null, "SELECT * FROM PRODUTOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisaProdutoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            prod.setCodigo(Integer.parseInt(txtCodigo.getText()));
            dao.excluiProduto(prod);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (incluindo == 1 || alterando == 1 && resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtPesquisaProduto.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    public void limpaCampos() {
        txtCodigo.setText(String.valueOf(dao.codigoProduto()));
        txtDescricao.setText("");
        txtMarca.setText("");
        cmbClassificacao.setSelectedItem("");
        cmbGrupo.setSelectedItem("");
        txtCustoCompra.setText("");
        txtPrecoVenda.setText("");
        txtDataUltimaCompra.setText("");
        txtDataValidade.setText("");
        btnExcluir.setEnabled(false);
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnPesquisaProduto;
    private javax.swing.JButton btnSair;
    public javax.swing.JCheckBox cbxAtivo;
    public javax.swing.JComboBox cmbClassificacao;
    public javax.swing.JComboBox cmbGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JFormattedTextField txtCustoCompra;
    public javax.swing.JFormattedTextField txtDataUltimaCompra;
    public javax.swing.JFormattedTextField txtDataValidade;
    public javax.swing.JTextField txtDescricao;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtPesquisaProduto;
    public javax.swing.JFormattedTextField txtPrecoVenda;
    // End of variables declaration//GEN-END:variables
}
