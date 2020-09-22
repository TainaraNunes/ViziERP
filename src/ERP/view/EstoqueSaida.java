package ERP.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
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
import Beans.BeansSaidaEstoque;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoEstoqueSaida;

public class EstoqueSaida extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    BeansSaidaEstoque lanca = new BeansSaidaEstoque();
    DaoEstoqueSaida dao = new DaoEstoqueSaida();
    PesquisaProdutos pesquisaProdutos = new PesquisaProdutos();
    PesquisaPessoas pesquisaPessoas = new PesquisaPessoas();
    PesquisaLancamentoEstoque pesquisaEstoque = new PesquisaLancamentoEstoque();

    public int incluindo = 1;
    public int alterando = 0;

    public EstoqueSaida() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/cadastroprodutos.png")).getImage());
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        txtDataLancamento.setText(format.format(new Date()));
        txtProcura.setDocument(new Teclas());
        txtDescricaoProduto.setDocument(new Teclas());
        txtDescricaoPessoa.setDocument(new Teclas());
        txtPlanilha.setText(String.valueOf(dao.gerarPlanilhaSaida()));
        
        btnExcluir.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnPesquisa = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtProcura = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPlanilha = new javax.swing.JTextField();
        txtDataLancamento = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNotaFiscal = new javax.swing.JFormattedTextField();
        txtCodigoPessoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnPesquisaPessoas = new javax.swing.JButton();
        txtDescricaoPessoa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtDescricaoProduto = new javax.swing.JTextField();
        txtCodigoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JFormattedTextField();
        btnPesquisaProdutos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutosEstoque = new javax.swing.JTable();
        btnInserirProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saída de Estoque");
        setName("frmEstoqueSaida"); // NOI18N
        setResizable(false);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnGravar, btnSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAbandonar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(449, 49));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Operação: 0002 - Saída de Estoque");

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        jLabel11.setText("Procurar:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProcura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(btnPesquisa)
                    .addComponent(txtProcura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Planilha:");

        txtPlanilha.setEditable(false);
        txtPlanilha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPlanilhaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlanilhaKeyTyped(evt);
            }
        });

        try {
            txtDataLancamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataLancamento.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel8.setText("Documento de Venda:");

        try {
            txtNotaFiscal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNotaFiscal.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtNotaFiscal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNotaFiscalKeyTyped(evt);
            }
        });

        txtCodigoPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPessoaKeyTyped(evt);
            }
        });

        jLabel4.setText("Data de Lançamento:");

        btnPesquisaPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaPessoasActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPlanilha)
                    .addComponent(txtCodigoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescricaoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDataLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPlanilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisaPessoas)
                    .addComponent(txtDescricaoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProdutoKeyTyped(evt);
            }
        });

        jLabel1.setText("Cód. Produto:");

        jLabel2.setText("Quantidade:");

        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyTyped(evt);
            }
        });

        jLabel7.setText("Valor Unitário:");

        txtValorUnitario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtValorUnitario.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtValorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorUnitarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorUnitarioFocusLost(evt);
            }
        });
        txtValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorUnitarioKeyTyped(evt);
            }
        });

        btnPesquisaProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaProdutosActionPerformed(evt);
            }
        });

        tblProdutosEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código ", "Descrição", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutosEstoque.getTableHeader().setReorderingAllowed(false);
        tblProdutosEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosEstoqueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutosEstoque);
        if (tblProdutosEstoque.getColumnModel().getColumnCount() > 0) {
            tblProdutosEstoque.getColumnModel().getColumn(0).setResizable(false);
            tblProdutosEstoque.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProdutosEstoque.getColumnModel().getColumn(1).setResizable(false);
            tblProdutosEstoque.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblProdutosEstoque.getColumnModel().getColumn(2).setResizable(false);
            tblProdutosEstoque.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblProdutosEstoque.getColumnModel().getColumn(3).setResizable(false);
            tblProdutosEstoque.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblProdutosEstoque.getColumnModel().getColumn(4).setResizable(false);
            tblProdutosEstoque.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        btnInserirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnInserirProduto.setMaximumSize(new java.awt.Dimension(47, 23));
        btnInserirProduto.setMinimumSize(new java.awt.Dimension(47, 23));
        btnInserirProduto.setPreferredSize(new java.awt.Dimension(47, 23));
        btnInserirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor Total:");

        txtValorTotal.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        txtValorTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalFocusLost(evt);
            }
        });
        txtValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalKeyTyped(evt);
            }
        });

        jLabel10.setText("Descrição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInserirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluirProduto, btnInserirProduto});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaProdutos)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInserirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnExcluirProduto, btnInserirProduto});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaProdutosActionPerformed
        if (!txtDescricaoProduto.getText().isEmpty()) {
            pesquisaProdutos = new PesquisaProdutos();
            pesquisaProdutos.setLocationRelativeTo(null);
            pesquisaProdutos.setVisible(true);
            pesquisaProdutos.setResizable(false);
            pesquisaProdutos.preencherTabela(null, null, this, null, null, "SELECT * FROM PRODUTOS WHERE DESCRICAO LIKE '%" + txtDescricaoProduto.getText().trim() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaProdutos = new PesquisaProdutos();
            pesquisaProdutos.setLocationRelativeTo(null);
            pesquisaProdutos.setVisible(true);
            pesquisaProdutos.preencherTabela(null, null, this, null, null, "SELECT * FROM PRODUTOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisaProdutosActionPerformed

    private void btnPesquisaPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaPessoasActionPerformed
        if (!txtDescricaoPessoa.getText().isEmpty()) {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.setResizable(false);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS WHERE UPPER(RAZAOSOCIAL) LIKE '%" + txtDescricaoPessoa.getText().trim().toUpperCase() + "%' ORDER BY RAZAOSOCIAL");
        } else {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS ORDER BY RAZAOSOCIAL");
        }
    }//GEN-LAST:event_btnPesquisaPessoasActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDataLancamento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data de lançamento do produto no estoque!");
            txtDataLancamento.requestFocus();
        } else if (txtDescricaoPessoa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione o cliente ou fornecedor!");
            btnPesquisaPessoas.requestFocus();
        } else if (txtNotaFiscal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o documento de saída do produto!");
            txtNotaFiscal.requestFocus();
        } else if (tblProdutosEstoque.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione o produto!");
            btnPesquisaProdutos.requestFocus();
        } else {
            lanca.setOperacao("0002");

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataLancamento = LocalDate.parse(txtDataLancamento.getText(), formato);
            lanca.setDataLancamento(dataLancamento);

            lanca.setPessoaCodigo(Integer.parseInt(txtCodigoPessoa.getText()));
            lanca.setPessoaDescricao(txtDescricaoPessoa.getText());
            lanca.setNotaFiscal(txtNotaFiscal.getText());

            if (!txtPlanilha.getText().isEmpty()) {
                lanca.setPlanilha(Integer.parseInt(txtPlanilha.getText()));
            }

            dao.gravarSaidaEstoque(lanca, this);
            limpaCampos();
            ((DefaultTableModel) tblProdutosEstoque.getModel()).setRowCount(0);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtProcura.requestFocus();
            incluindo = 1;
            alterando = 0;
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        limpaCampos();
        String pesquisa = txtProcura.getText().trim();

        if (txtProcura.getText().isEmpty()) {
            pesquisaEstoque = new PesquisaLancamentoEstoque();
            pesquisaEstoque.setLocationRelativeTo(null);
            pesquisaEstoque.setVisible(true);
            pesquisaEstoque.preencherTabela("SELECT * FROM ESTOQUE WHERE OPERACAO = '0002'", null, this);
        } else {
            pesquisaEstoque = new PesquisaLancamentoEstoque();
            pesquisaEstoque.setLocationRelativeTo(null);
            pesquisaEstoque.setVisible(true);
            pesquisaEstoque.preencherTabela("SELECT * FROM ESTOQUE WHERE OPERACAO = '0002' AND PRODUTODESCRICAO LIKE '%" + pesquisa + "%'", null, this);
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este lançamento?");
        if (resposta == JOptionPane.YES_OPTION) {
            lanca.setPlanilha(Integer.parseInt(txtPlanilha.getText()));
            dao.excluirLancamentoSaidaEstoque(lanca);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtPlanilhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlanilhaKeyPressed
        char cTeclaPressionada = evt.getKeyChar();
        if (!(txtPlanilha.getText().isEmpty()) && cTeclaPressionada == KeyEvent.VK_ENTER) {
            conecta.conexao();
            conecta.executaSql("SELECT * FROM ESTOQUE WHERE PLANILHA = '" + txtPlanilha.getText() + "'");
            try {
                conecta.rs.first();

                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    String resultadoDataLacamento = formatoString.format(formatoBanco.parse(conecta.rs.getString("DATALANCAMENTO")));
                    txtDataLancamento.setText(resultadoDataLacamento);
                } catch (ParseException ex) {
                    Logger.getLogger(EstoqueSaida.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtCodigoPessoa.setText(String.valueOf(conecta.rs.getInt("PESSOACODIGO")));
                txtDescricaoPessoa.setText(conecta.rs.getString("PESSOADESCRICAO"));
                txtNotaFiscal.setText(conecta.rs.getString("NOTAFISCAL"));
                try {
                    conecta.rs.first();
                    do {

                    } while (conecta.rs.next());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum produto localizado!");
                    this.dispose();
                    conecta.desconecta();
                }

                txtCodigoProduto.setText(String.valueOf(conecta.rs.getInt("PRODUTOCODIGO")));
                txtDescricaoProduto.setText(conecta.rs.getString("PRODUTODESCRICAO"));
                txtQuantidade.setText(String.valueOf(conecta.rs.getInt("QUANTIDADE")));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar lançamento! \n ERRO: " + ex);
                this.dispose();
                conecta.desconecta();
            }
        }
    }//GEN-LAST:event_txtPlanilhaKeyPressed

    private void btnInserirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirProdutoActionPerformed
        boolean lAlterandoProduto = false;
        for (int x = 0; x < tblProdutosEstoque.getRowCount(); x++) {
            if (tblProdutosEstoque.getValueAt(x, 0).equals(txtCodigoProduto.getText())) {
                lAlterandoProduto = true;
            }
        }

        if (lAlterandoProduto == false) {
            dao.incluirProdutoTabela(this);
        } else {
            dao.alterarProdutoTabela(this);
        }
        
        txtCodigoProduto.setText("");
        txtDescricaoProduto.setText("");
        txtQuantidade.setText("");
        txtValorUnitario.setText("");
        txtValorTotal.setText("");         
    }//GEN-LAST:event_btnInserirProdutoActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed
        dao.excluirProdutoTabela(this); 
        if (tblProdutosEstoque.getSelectedRow() != -1) {
            ((DefaultTableModel) tblProdutosEstoque.getModel()).removeRow(tblProdutosEstoque.getSelectedRow());
            txtCodigoProduto.setText("");
            txtDescricaoProduto.setText("");
            txtQuantidade.setText("");
            txtValorUnitario.setText("");
            txtValorTotal.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o produto para eliminar!");
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void txtValorTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalFocusGained
        int quantidade = 0;
        if (!txtQuantidade.getText().isEmpty()){
            quantidade = Integer.parseInt(txtQuantidade.getText());
        } 
        
        String vU = txtValorUnitario.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        if (!txtValorUnitario.getText().isEmpty()) {
            BigDecimal valorUnitario = new BigDecimal(vU);
            BigDecimal quantidadeDecimal = new BigDecimal(quantidade);
            BigDecimal valorTotal = valorUnitario.multiply(quantidadeDecimal);

            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorTotalFormatado = nf.format(valorTotal);
            txtValorTotal.setText(valorTotalFormatado);
        } else {
            txtValorTotal.setText("R$0,00");
        }
        txtValorTotal.selectAll();
    }//GEN-LAST:event_txtValorTotalFocusGained

    private void txtValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioFocusLost
        String sv = txtValorUnitario.getText();
        if (!txtValorUnitario.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtValorUnitario.setText(valorFormatado);
        } else {
            txtValorUnitario.setText("R$0,00");
        }   
    }//GEN-LAST:event_txtValorUnitarioFocusLost

    private void txtValorUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorUnitarioKeyTyped

    private void txtValorTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalKeyTyped

    private void txtQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeKeyTyped

    private void tblProdutosEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosEstoqueMouseClicked
        int index = tblProdutosEstoque.getSelectedRow();
        TableModel model = tblProdutosEstoque.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM ESTOQUE WHERE PLANILHA = '" + index + "'");

        try {
            conecta.rs.first();

            String produtoCodigo = model.getValueAt(index, 0).toString();
            String produtoDescricao = model.getValueAt(index, 1).toString();
            String quantidade = model.getValueAt(index, 2).toString();
            String valorUnitario = model.getValueAt(index, 3).toString();
            String valorTotal = model.getValueAt(index, 4).toString();

            txtCodigoProduto.setText(produtoCodigo);
            txtDescricaoProduto.setText(produtoDescricao);
            txtQuantidade.setText(quantidade);

            BigDecimal unitario = new BigDecimal(valorUnitario);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String unitarioFormatado = nf.format(unitario);
            txtValorUnitario.setText(unitarioFormatado);

            BigDecimal total = new BigDecimal(valorTotal);
            String totalFormatado = nf.format(total);
            txtValorTotal.setText(totalFormatado);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" + ex);
        }

        conecta.desconecta();
    }//GEN-LAST:event_tblProdutosEstoqueMouseClicked

    private void txtPlanilhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlanilhaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPlanilhaKeyTyped

    private void txtCodigoPessoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPessoaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoPessoaKeyTyped

    private void txtNotaFiscalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotaFiscalKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNotaFiscalKeyTyped

    private void txtCodigoProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProdutoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoProdutoKeyTyped

    private void txtValorTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalFocusLost
        if (txtValorTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(EstoqueSaida.this, "Informe a quantidade e o valor unitário para calcular o valor total!");
        }
    }//GEN-LAST:event_txtValorTotalFocusLost

    private void txtValorUnitarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioFocusGained
        txtValorUnitario.selectAll();
    }//GEN-LAST:event_txtValorUnitarioFocusGained

    public void limpaCampos() {
        txtDataLancamento.setText("");
        txtCodigoPessoa.setText("");
        txtDescricaoPessoa.setText("");
        txtNotaFiscal.setText("");
        txtCodigoProduto.setText("");
        txtDescricaoProduto.setText("");
        txtQuantidade.setText("");
        txtValorUnitario.setText("");
        txtValorTotal.setText("");
        txtProcura.requestFocus();
        txtPlanilha.setText(String.valueOf(dao.gerarPlanilhaSaida()));
        btnExcluir.setEnabled(false);
        ((DefaultTableModel) tblProdutosEstoque.getModel()).setRowCount(0);
        incluindo = 1;
        alterando = 0;
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstoqueSaida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluirProduto;
    public javax.swing.JButton btnGravar;
    private javax.swing.JButton btnInserirProduto;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnPesquisaPessoas;
    private javax.swing.JButton btnPesquisaProdutos;
    public javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblProdutosEstoque;
    public javax.swing.JTextField txtCodigoPessoa;
    public javax.swing.JTextField txtCodigoProduto;
    public javax.swing.JFormattedTextField txtDataLancamento;
    public javax.swing.JTextField txtDescricaoPessoa;
    public javax.swing.JTextField txtDescricaoProduto;
    public javax.swing.JFormattedTextField txtNotaFiscal;
    public javax.swing.JTextField txtPlanilha;
    public javax.swing.JTextField txtProcura;
    public javax.swing.JTextField txtQuantidade;
    public javax.swing.JFormattedTextField txtValorTotal;
    public javax.swing.JFormattedTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
