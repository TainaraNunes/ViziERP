package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.BeansContasPagar;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoLancamentoContasPagar;
import org.apache.commons.lang.StringUtils;
public class LancamentoContasPagar extends javax.swing.JFrame {

    BeansContasPagar contasPagar = new BeansContasPagar();
    ConectaBD conecta = new ConectaBD();
    DaoLancamentoContasPagar dao = new DaoLancamentoContasPagar();
    PesquisaPessoas pesquisaPessoas = new PesquisaPessoas();
    ConsultaContasPagarReceber pesquisaDuplicatas = new ConsultaContasPagarReceber();

    public int incluindo = 1;
    public int alterando = 0;

    public LancamentoContasPagar() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/contaspagar.png")).getImage());
        txtPlanilha.setText(String.valueOf(dao.gerarPlanilhaContasPagar()));
        txtDataLancamento.requestFocus();
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtDataLancamento.setText(format.format(new Date()));
        
        txtFornecedorDescricao.setDocument(new Teclas());
        txtParcelaNumero.setDocument(new Teclas());        
        txtObservacoes.setDocument(new Teclas()); 
        btnExcluirLancamento.setEnabled(false);
        
        popularComboFormasPagamento();
        popularComboCategoria();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox();
        cmbFormaPagamento = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txtValorTotalFatura = new javax.swing.JTextField();
        btnPesquisaFornecedor = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDocumentoNumero = new javax.swing.JTextField();
        txtFornecedorCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPlanilha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDataLancamento = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtParcelaNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVencimentoParcela = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtValorParcela = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAcrescimos = new javax.swing.JTextField();
        txtDescontos = new javax.swing.JFormattedTextField();
        txtValorTotalPagar = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnIncluirDuplicata = new javax.swing.JButton();
        btnExcluirDuplicata = new javax.swing.JButton();
        txtFornecedorDescricao = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtObservacoes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluirLancamento = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnConsultaContasPagarReceber = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParcelas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento de Contas a Pagar");
        setName("frmLancamentoContasPagar"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Categoria:");

        jLabel5.setText("Forma de Pagamento:");

        jLabel7.setText("Cód. Fornecedor:");

        jLabel11.setText("Valor Total:");

        txtValorTotalFatura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalFaturaFocusLost(evt);
            }
        });
        txtValorTotalFatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalFaturaKeyTyped(evt);
            }
        });

        btnPesquisaFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaFornecedorActionPerformed(evt);
            }
        });

        jLabel8.setText("Nro. Documento:");

        txtDocumentoNumero.setColumns(9);
        txtDocumentoNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoNumeroFocusLost(evt);
            }
        });
        txtDocumentoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoNumeroKeyTyped(evt);
            }
        });

        txtFornecedorCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFornecedorCodigoKeyTyped(evt);
            }
        });

        jLabel6.setText("Planilha:");

        txtPlanilha.setEnabled(false);

        jLabel9.setText("Data Lançamento:");

        try {
            txtDataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataLancamento.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel12.setText("Razão Social/Fantasia:");

        jLabel13.setText("Parcela:");

        txtParcelaNumero.setEditable(false);

        jLabel2.setText("Vencimento:");

        try {
            txtVencimentoParcela.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVencimentoParcela.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel1.setText("Valor Parcela:");

        txtValorParcela.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtValorParcela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorParcelaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorParcelaFocusLost(evt);
            }
        });
        txtValorParcela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorParcelaKeyTyped(evt);
            }
        });

        jLabel10.setText("Acréscimos:");

        txtAcrescimos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAcrescimosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAcrescimosFocusLost(evt);
            }
        });
        txtAcrescimos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAcrescimosKeyTyped(evt);
            }
        });

        txtDescontos.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtDescontos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescontosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescontosFocusLost(evt);
            }
        });
        txtDescontos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescontosKeyTyped(evt);
            }
        });

        txtValorTotalPagar.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtValorTotalPagar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorTotalPagarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalPagarFocusLost(evt);
            }
        });
        txtValorTotalPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalPagarKeyTyped(evt);
            }
        });

        jLabel14.setText("Descontos:");

        jLabel15.setText("Total a Pagar: ");

        btnIncluirDuplicata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnIncluirDuplicata.setMaximumSize(new java.awt.Dimension(47, 23));
        btnIncluirDuplicata.setMinimumSize(new java.awt.Dimension(47, 23));
        btnIncluirDuplicata.setPreferredSize(new java.awt.Dimension(47, 23));
        btnIncluirDuplicata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirDuplicataActionPerformed(evt);
            }
        });

        btnExcluirDuplicata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnExcluirDuplicata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDuplicataActionPerformed(evt);
            }
        });

        jLabel16.setText("Observações:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFornecedorCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFornecedorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtDocumentoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorTotalFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtParcelaNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVencimentoParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAcrescimos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtValorTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIncluirDuplicata, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirDuplicata, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel15))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObservacoes)))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAcrescimos, txtDescontos, txtValorParcela, txtValorTotalPagar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumentoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotalFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtFornecedorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaFornecedor)
                    .addComponent(txtFornecedorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnExcluirDuplicata)
                    .addComponent(btnIncluirDuplicata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAcrescimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVencimentoParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParcelaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnExcluirLancamento.setText("Excluir");
        btnExcluirLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirLancamentoActionPerformed(evt);
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

        btnConsultaContasPagarReceber.setText("Consulta");
        btnConsultaContasPagarReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaContasPagarReceberActionPerformed(evt);
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
                .addComponent(btnExcluirLancamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultaContasPagarReceber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAbandonar, btnConsultaContasPagarReceber, btnExcluirLancamento, btnGravar, btnSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluirLancamento)
                    .addComponent(btnAbandonar)
                    .addComponent(btnSair)
                    .addComponent(btnConsultaContasPagarReceber))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Operação: 2000 - Lançamento de Contas a Pagar");

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/help.png"))); // NOI18N
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnHelp)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        tblParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcela", "Vencimento", "Valor Documento", "Acréscimos", "Descontos", "Valor a Pagar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParcelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblParcelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblParcelas);
        if (tblParcelas.getColumnModel().getColumnCount() > 0) {
            tblParcelas.getColumnModel().getColumn(0).setResizable(false);
            tblParcelas.getColumnModel().getColumn(1).setResizable(false);
            tblParcelas.getColumnModel().getColumn(2).setResizable(false);
            tblParcelas.getColumnModel().getColumn(3).setResizable(false);
            tblParcelas.getColumnModel().getColumn(4).setResizable(false);
            tblParcelas.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        boolean lGravar = true;
        if (txtDataLancamento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data do lançamento!");
            txtDataLancamento.requestFocus();
        } else if (txtDocumentoNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número do documento para lançamento!");
            txtDocumentoNumero.requestFocus();
        } else if (txtValorTotalFatura.getText().isEmpty() || txtValorTotalFatura.equals("0,00")) {
            JOptionPane.showMessageDialog(null, "Informe o valor total da fatura!");
            txtValorTotalFatura.requestFocus();
        } else if (txtFornecedorCodigo.getText().isEmpty() || txtFornecedorDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o fornecedor!");
            btnPesquisaFornecedor.requestFocus();
        } else {
            contasPagar.setOperacao("2000");

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLancamento = LocalDate.parse(txtDataLancamento.getText(), formato);
            contasPagar.setDataLancamento(dataLancamento);

            String totalFatura = txtValorTotalFatura.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalFatura = new BigDecimal(totalFatura);
            contasPagar.setValorTotalFatura(valorTotalFatura);

            contasPagar.setDocumentoNumero(txtDocumentoNumero.getText());
            
            String formaPagamentoDescricao = cmbFormaPagamento.getSelectedItem().toString();
            conecta.conexao();
            conecta.executaSql("SELECT CODIGO FROM FORMASPAGAMENTO WHERE DESCRICAO = '" + formaPagamentoDescricao + "'");
            try {
                if (conecta.rs.next()) {
                    contasPagar.setFormaPagamento(conecta.rs.getInt("CODIGO"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }

            contasPagar.setCategoria(cmbCategoria.getSelectedItem().toString());
            contasPagar.setFornecedorCodigo(Integer.parseInt(txtFornecedorCodigo.getText()));
            contasPagar.setFornecedorDescricao(txtFornecedorDescricao.getText());
            contasPagar.setPlanilha(Integer.parseInt(txtPlanilha.getText()));
            contasPagar.setObservacoes(txtObservacoes.getText()); 
            contasPagar.setSituacao("P");
            
            if (lGravar && dao.validarTotais(this) == false) {
                lGravar = false;
                txtValorTotalFatura.requestFocus();               
            }
            
            if (lGravar && dao.validarDocumento(this) == false) {
                lGravar = false;
                txtDocumentoNumero.requestFocus();
            }
         
            if (lGravar) {
                dao.gravarDuplicatasPagar(contasPagar, this);
            }        
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtDataLancamento.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnIncluirDuplicataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirDuplicataActionPerformed
        boolean lAlterandoParcela = false;
        if (txtParcelaNumero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número da parcela!");
            txtParcelaNumero.requestFocus();
        } else if (txtVencimentoParcela.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data de vencimento da parcela!");
            txtVencimentoParcela.requestFocus();
        } else if (txtValorParcela.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor da parcela!");
            txtValorParcela.requestFocus();
        } else if (txtValorTotalPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor total a pagar deve ser informado!");
            txtValorTotalPagar.requestFocus();
        } else {
            for (int x = 0; x < tblParcelas.getRowCount(); x++) {
                if (tblParcelas.getValueAt(x, 0).equals(txtParcelaNumero.getText())) {
                    lAlterandoParcela = true;
                }
            }
            if (lAlterandoParcela == false) {
                dao.incluirDuplicataTabela(this);
            } else {
                dao.alterarDuplicataTabela(this);
            }
        }
    }//GEN-LAST:event_btnIncluirDuplicataActionPerformed

    private void btnExcluirDuplicataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDuplicataActionPerformed
        if (tblParcelas.getSelectedRow() != -1) {
            ((DefaultTableModel) tblParcelas.getModel()).removeRow(tblParcelas.getSelectedRow());
            txtParcelaNumero.setText("");
            txtVencimentoParcela.setText("");
            txtValorParcela.setText("");
            txtAcrescimos.setText("");
            txtDescontos.setText("");
            txtValorTotalPagar.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a duplicata para eliminar!");
        }
    }//GEN-LAST:event_btnExcluirDuplicataActionPerformed

    private void txtValorTotalPagarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalPagarFocusGained
        String valorDuplicata = txtValorParcela.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String acrescimos = txtAcrescimos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String descontos = txtDescontos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");

        if (valorDuplicata.equals("")) {
            txtParcelaNumero.requestFocus();
        } else {
            BigDecimal vlrDuplicata = new BigDecimal(valorDuplicata);
            BigDecimal vlrAcrescimos = new BigDecimal(acrescimos);
            BigDecimal vlrDescontos = new BigDecimal(descontos);

            BigDecimal valorTotalReceber = (vlrDuplicata.add(vlrAcrescimos).subtract(vlrDescontos));
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valorTotalReceber);

            txtValorTotalPagar.setText(valorFormatado);
        }
        txtValorTotalPagar.selectAll();
    }//GEN-LAST:event_txtValorTotalPagarFocusGained

    private void txtValorParcelaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorParcelaFocusLost
        String sv = txtValorParcela.getText();
        if (!txtValorParcela.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtValorParcela.setText(valorFormatado);
        } else {
            JOptionPane.showMessageDialog(null, "Informe o valor da duplicata!");
            txtValorParcela.requestFocus();
        }
    }//GEN-LAST:event_txtValorParcelaFocusLost

    private void txtAcrescimosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAcrescimosFocusLost
        String sv = txtAcrescimos.getText();
        if (!txtAcrescimos.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtAcrescimos.setText(valorFormatado);
        } else {
            txtAcrescimos.setText("R$0,00");
        }
    }//GEN-LAST:event_txtAcrescimosFocusLost

    private void txtDescontosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontosFocusLost
        String sv = txtDescontos.getText();
        if (!txtDescontos.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtDescontos.setText(valorFormatado);
        } else {
            txtDescontos.setText("R$0,00");
        }
    }//GEN-LAST:event_txtDescontosFocusLost

    private void btnPesquisaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaFornecedorActionPerformed
        if (!txtFornecedorDescricao.getText().isEmpty()) {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.setResizable(false);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS WHERE UPPER(RAZAOSOCIAL) LIKE '%" + txtFornecedorDescricao.getText().trim().toUpperCase() + "%' ORDER BY RAZAOSOCIAL");
        } else {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS ORDER BY RAZAOSOCIAL");            
        }
    }//GEN-LAST:event_btnPesquisaFornecedorActionPerformed

    private void txtValorTotalFaturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalFaturaFocusLost
        String sv = txtValorTotalFatura.getText();
        if (!txtValorTotalFatura.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtValorTotalFatura.setText(valorFormatado);
        } else {
            txtValorTotalFatura.setText("0,00");
        }
    }//GEN-LAST:event_txtValorTotalFaturaFocusLost

    private void btnConsultaContasPagarReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaContasPagarReceberActionPerformed
        pesquisaDuplicatas = new ConsultaContasPagarReceber();
        pesquisaDuplicatas.setLocationRelativeTo(null);
        pesquisaDuplicatas.setVisible(true);
        pesquisaDuplicatas.filtrosPesquisa(null, null, null, this);
    }//GEN-LAST:event_btnConsultaContasPagarReceberActionPerformed

    private void tblParcelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblParcelasMouseClicked
        int index = tblParcelas.getSelectedRow();
        TableModel model = tblParcelas.getModel();

        //Rever
        conecta.conexao();
        conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE PLANILHA = '" + index + "'");

        /* Ao clicar no registro, verifica se possui pagamento no banco e NÃO DEIXA PROSSEGUIR. */
        String documentoNumero = txtDocumentoNumero.getText();
        conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE DOCUMENTONUMERO = '" + documentoNumero + "' AND PARCELANUMERO = '" + model.getValueAt(index, 0).toString() + "'");
        try {
            if (conecta.rs.next()) {
                if (conecta.rs.getString("DATAPAGAMENTO") != null) {
                    JOptionPane.showMessageDialog(null, "Documento " + conecta.rs.getString("documentoNumero") + "-" + conecta.rs.getString("PARCELANUMERO") + " possui pagamento, não poderá ser alterada! \n Elimine o lançamento do caixa para conseguir alterar a duplicata.");
                    txtParcelaNumero.setText("");
                    txtVencimentoParcela.setText("");
                    txtValorParcela.setText("");
                    txtAcrescimos.setText("");
                    txtDescontos.setText("");
                    txtValorTotalPagar.setText("");
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContasPagar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conecta.rs.first();

            String parcelaNumero = model.getValueAt(index, 0).toString();
            String dataVencimento = model.getValueAt(index, 1).toString();
            String valorDuplicata = model.getValueAt(index, 2).toString();
            String acrescimos = model.getValueAt(index, 3).toString();
            String descontos = model.getValueAt(index, 4).toString();
            String totalPagar = model.getValueAt(index, 5).toString();

            txtParcelaNumero.setText(parcelaNumero);
            txtVencimentoParcela.setText(dataVencimento);

            BigDecimal vlrDuplicata = new BigDecimal(valorDuplicata);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorDuplicataFormatado = nf.format(vlrDuplicata);
            txtValorParcela.setText(valorDuplicataFormatado);

            BigDecimal vlrAcrescimos = new BigDecimal(acrescimos);
            String acrescimosFormatado = nf.format(vlrAcrescimos);
            txtAcrescimos.setText(acrescimosFormatado);

            BigDecimal vlrDescontos = new BigDecimal(descontos);
            String descontosFormatado = nf.format(vlrDescontos);
            txtDescontos.setText(descontosFormatado);

            BigDecimal vlrReceber = new BigDecimal(totalPagar);
            String vlrPagarFormatado = nf.format(vlrReceber);
            txtValorTotalPagar.setText(vlrPagarFormatado);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tblParcelasMouseClicked

    private void btnExcluirLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirLancamentoActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este lançamento?");
        if (resposta == JOptionPane.YES_OPTION) {
            contasPagar.setPlanilha(Integer.parseInt(txtPlanilha.getText()));
            dao.excluirLancamentoPagar(this);
        }
    }//GEN-LAST:event_btnExcluirLancamentoActionPerformed

    private void txtValorTotalPagarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalPagarFocusLost
        if (txtValorTotalPagar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(LancamentoContasPagar.this, "Informe o valor da duplicata, acréscimos e descontos, para calcular o valor total a pagar!");
        }
    }//GEN-LAST:event_txtValorTotalPagarFocusLost

    private void txtValorTotalPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalPagarKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalPagarKeyTyped

    private void txtDescontosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescontosKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescontosKeyTyped

    private void txtAcrescimosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAcrescimosKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAcrescimosKeyTyped

    private void txtValorParcelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorParcelaKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorParcelaKeyTyped

    private void txtDocumentoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoNumeroKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoNumeroKeyTyped

    private void txtValorTotalFaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalFaturaKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalFaturaKeyTyped

    private void txtFornecedorCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFornecedorCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFornecedorCodigoKeyTyped

    private void txtValorParcelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorParcelaFocusGained
        txtValorParcela.selectAll();
    }//GEN-LAST:event_txtValorParcelaFocusGained

    private void txtAcrescimosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAcrescimosFocusGained
        txtAcrescimos.selectAll();
    }//GEN-LAST:event_txtAcrescimosFocusGained

    private void txtDescontosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescontosFocusGained
        txtDescontos.selectAll();
    }//GEN-LAST:event_txtDescontosFocusGained

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        TelaHelp obj = new TelaHelp("- Para a inclusão de uma nova conta a pagar deve ser informado o número do documento e o valor total, selecione a forma de pagamento e o a classificação, \n"
                                  + "que refere ao tipo de lançamento e selecione o fornecedor e o desdobro das parcelas. \n"
                                  + "- Quando a conta for divida em mais de uma parcela, informar as parcelas no formato 01, 02, etc. com o respectivo valor. Juros e descontos também poderão ser informados "
                                  + "no momento do lançamento ou depois, caso necessário. \n"
                                  + "- O valor total será calculado automaticamente ao preencher os outros campos. \n"
                                  + "- O valor total da fatura deverá fechar com o valor das duplicatas (sem considerar acréscimos e descontos). \n"
                                  + "- Caso não exista um documento (nota, boleto, duplicata) para informar o número deixe o campo 'Nro Documento' em branco, informe a parcela 'AVUL' que o número será gerado automaticamente. \n"
                                  + "- Para consultar asa contas a receber lançadas utilize o botão 'Consulta'. \n"
                                  + "- Para alterar ou excluir uma conta, selecione o lançamento na tela de consulta, e altere os dados necessários ou utilize o botão 'Eliminar'.");
                        
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);  
    }//GEN-LAST:event_btnHelpActionPerformed

    private void txtDocumentoNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoNumeroFocusLost
        String documento = txtDocumentoNumero.getText(), numeroFormatado = null;
        int numeroDocumento = 0;

        if (!txtDocumentoNumero.getText().isEmpty() && txtDocumentoNumero.getText().length() < 9) {
            txtDocumentoNumero.setText(StringUtils.leftPad(documento, 9, "0"));
            txtParcelaNumero.setText("01");
        } else {
            txtParcelaNumero.setText("AVUL01"); 

            conecta.conexao();
            conecta.executaSql("SELECT DOCUMENTONUMERO FROM CONTASPAGAR WHERE OPERACAO = '2000' AND PARCELANUMERO LIKE '%AVUL%' ORDER BY DOCUMENTONUMERO DESC LIMIT 1");
            try {
                if (conecta.rs.next()) {
                    numeroDocumento = (Integer.parseInt(conecta.rs.getString("DOCUMENTONUMERO"))) + 1;
                    numeroFormatado = String.format("%09d", numeroDocumento);
                    txtDocumentoNumero.setText(numeroFormatado);
                } else {
                    txtDocumentoNumero.setText("000000001");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar número do último documento emitido! \n ERRO: " + ex);
            }
            conecta.desconecta();
        }
    }//GEN-LAST:event_txtDocumentoNumeroFocusLost

    public void limpaCampos() {
        txtPlanilha.setText("");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtDataLancamento.setText(format.format(new Date()));
        txtDataLancamento.requestFocus();
        txtDocumentoNumero.setText("");
        txtValorTotalFatura.setText("");
        txtFornecedorCodigo.setText("");
        txtFornecedorDescricao.setText("");
        txtParcelaNumero.setText("");
        txtVencimentoParcela.setText("");
        txtValorParcela.setText("");
        txtAcrescimos.setText("");
        txtDescontos.setText("");
        txtValorTotalPagar.setText("");
        txtObservacoes.setText(""); 
        cmbCategoria.setSelectedIndex(0);
        cmbFormaPagamento.setSelectedIndex(0);
        ((DefaultTableModel) tblParcelas.getModel()).setRowCount(0);
        btnExcluirLancamento.setEnabled(false);        
        txtPlanilha.setText(String.valueOf(dao.gerarPlanilhaContasPagar()));
               
        incluindo = 1;
        alterando = 0;
    }

    /* Valida se o valor total da fatura é igual a soma do valor das parcelas 
    sem considerar os acréscimos ou descontos */
    public boolean validarTotais(LancamentoContasPagar contasPagar) {
        boolean resultado;
        BigDecimal totalDuplicatas = BigDecimal.ZERO;

        String valorFatura = (String) contasPagar.txtValorTotalFatura.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        BigDecimal totalFatura = new BigDecimal(valorFatura);

        for (int x = 0; x < contasPagar.tblParcelas.getRowCount(); x++) {
            String vlrDuplicata = (String) contasPagar.tblParcelas.getValueAt(x, 2);
            BigDecimal valorDuplicata = new BigDecimal(vlrDuplicata);
            totalDuplicatas = totalDuplicatas.add(valorDuplicata);
        }

        if (totalFatura.compareTo(totalDuplicatas) == 0) {
            resultado = true;
        } else {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Valor total da fatura é diferente da soma das duplicatas. Verifique!");
        }

        return resultado;
    }

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
        conecta.executaSql("SELECT CODIGO, DESCRICAO FROM CATEGORIASFINANCEIRO WHERE TIPOMOVIMENTO = 'P' ORDER BY DESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbCategoria.addItem(conecta.rs.getString("DESCRICAO").trim());
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar categorias cadastradas! \n ERRO: " + ex);
        }
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
                new LancamentoContasPagar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    private javax.swing.JButton btnConsultaContasPagarReceber;
    private javax.swing.JButton btnExcluirDuplicata;
    public javax.swing.JButton btnExcluirLancamento;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnIncluirDuplicata;
    public javax.swing.JButton btnPesquisaFornecedor;
    private javax.swing.JButton btnSair;
    public javax.swing.JComboBox cmbCategoria;
    public javax.swing.JComboBox cmbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblParcelas;
    public javax.swing.JTextField txtAcrescimos;
    public javax.swing.JFormattedTextField txtDataLancamento;
    public javax.swing.JFormattedTextField txtDescontos;
    public javax.swing.JTextField txtDocumentoNumero;
    public javax.swing.JTextField txtFornecedorCodigo;
    public javax.swing.JTextField txtFornecedorDescricao;
    public javax.swing.JTextField txtObservacoes;
    public javax.swing.JTextField txtParcelaNumero;
    public javax.swing.JTextField txtPlanilha;
    public javax.swing.JFormattedTextField txtValorParcela;
    public javax.swing.JTextField txtValorTotalFatura;
    public javax.swing.JFormattedTextField txtValorTotalPagar;
    public javax.swing.JFormattedTextField txtVencimentoParcela;
    // End of variables declaration//GEN-END:variables
}
