package ERP.view;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.BeansOrcamento;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoFuncoes;
import DAO.DaoLancamentoContasReceber;
import DAO.DaoOrcamento;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class Orcamento extends javax.swing.JFrame {

    BeansOrcamento orcamento = new BeansOrcamento();
    ConectaBD conecta = new ConectaBD();
    DaoOrcamento dao = new DaoOrcamento();
    DaoFuncoes funcoes = new DaoFuncoes();
    PesquisaPessoas pesquisaPessoas = new PesquisaPessoas();
    PesquisaServicos pesquisaServicos = new PesquisaServicos();
    PesquisaProdutos pesquisaProdutos = new PesquisaProdutos();
    PesquisaOrcamentos pesquisaOrcamentos = new PesquisaOrcamentos();
    
    public Date dataAbertura = null;
    boolean lAlterandoParcela = false;
    boolean lAlterandoNumeroParcelas = false;
    public int incluindo = 1;
    public int alterando = 0;
    
    private final String logoVizipostos = "/Imagens/LogoViziPostos.png";
    private final String logoCertificacaoVizipostos = "/Imagens/CertificacaoViziPostos.png";
    private final String diretorioSubrelatorioFinanceiro = "/Relatorios/orcamento_financeiro.jasper";
    private final String diretorioSubrelatorioServicos = "/Relatorios/OrcamentoServicos.jasper";
    private final String diretorioSubrelatorioPecas = "/Relatorios/OrcamentoPecas.jasper";
    
    public String textoFixoObservacoes = "a) Os compartimentos dos tanques que serão ensaiados deverão conter no máximo 96 cm de combustível para que o ENSAIO NÃO VOLUMÉTRICO seja realizado.\n"
                                       + "b) As bocas de descarga e de visita de todos os compartimentos dos tanques que serão ensaiados deverão estar secas.       \n"
                                       + "c) As bombas de abastecimento veicular, interligadas aos compartimentos dos tanques e cujas tubulações serão ensaiadas, deverão ter seu funcionamento interrompido quando solicitado pelo Técnico de Campo que realizará o ensaio, obedecendo a um mínimo de 15 minutos antes do início do ensaio. \n"
                                       + "d) O ensaio será cobrado independente do resultado. \n"
                                       + "e) Os compartimentos dos tanques que serão ensaiados não poderão ser abastecidos nas 2 horas que antecedem ao início da realização do ensaio e durante a realização do mesmo.\n"
                                       + "f) Orçamento promocional válido para 07 dias após o envio, podendo sofrer alteração após o vencimento.";

    public Orcamento() {
        initComponents();
        calcularValidadeOrcamento();

        txtPesquisaOrcamento.setDocument(new Teclas());
        txtClienteDescricao.setDocument(new Teclas());
        txtDescricaoServico.setDocument(new Teclas());
        txtDescricaoPeca.setDocument(new Teclas()); 
        
        txtOrcamentoNumero.setText(String.valueOf(String.format("%06d", dao.numeroOrcamento())));
        
        popularComboFormasPagamento();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOrcamentoNumero = new javax.swing.JTextField();
        txtClienteCodigo = new javax.swing.JTextField();
        txtClienteDescricao = new javax.swing.JTextField();
        btnPesquisaCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtDataValidadeOrcamento = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        txtVersaoOrcamento = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtPesquisaOrcamento = new javax.swing.JTextField();
        btnPesquisaOrcamento = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoServico = new javax.swing.JTextField();
        txtDescricaoServico = new javax.swing.JTextField();
        btnPesquisarServico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        btnIncluirServico = new javax.swing.JButton();
        btnRemoverServico = new javax.swing.JButton();
        txtQuantidadeCompartimentos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtValorUnitarioServico = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtValorTotalServicos = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        txtValorTotalServico = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtDescricaoPeca = new javax.swing.JTextField();
        txtQuantidadePeca = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtValorUnitarioPeca = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtValorTotalPeca = new javax.swing.JTextField();
        btnPesquisarPeca = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        txtCodigoPeca = new javax.swing.JTextField();
        btnIncluirPeca = new javax.swing.JButton();
        btnRemoverPeca = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtValorTotalPecas = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbFormaPagamento = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPagamentos = new javax.swing.JTable();
        btnAdicionarParcela = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroParcelas = new javax.swing.JTextField();
        txtValorTotalServicosFechamento = new javax.swing.JTextField();
        txtValorDescontoServicos = new javax.swing.JTextField();
        txtValorTotalOrcamento = new javax.swing.JTextField();
        btnExcluirParcela = new javax.swing.JButton();
        txtParcelaVencimento = new javax.swing.JFormattedTextField();
        txtParcelaValor = new javax.swing.JTextField();
        txtParcelaPrazo = new javax.swing.JTextField();
        txtParcelaNumero = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacoes = new javax.swing.JTextPane();
        txtPercentualDescontoServicos = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtValorTotalPecasFechamento = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPercentualDescontoPecas = new javax.swing.JTextField();
        txtValorDescontoPecas = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnCancelarOrcamento = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnAprovarOrcamento = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orçamento");
        setName("frmOrcamento"); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setToolTipText("Geral");
        jTabbedPane1.setName(""); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 75));

        jLabel8.setText("Orçamento Nº:");

        jLabel9.setText("Cliente:");

        txtOrcamentoNumero.setEnabled(false);
        txtOrcamentoNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrcamentoNumeroKeyTyped(evt);
            }
        });

        txtClienteCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteCodigoKeyTyped(evt);
            }
        });

        btnPesquisaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });

        jLabel12.setText("Válido até:");

        try {
            txtDataValidadeOrcamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setText("Versão:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClienteDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOrcamentoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataValidadeOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVersaoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDataValidadeOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtOrcamentoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(txtVersaoOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(txtClienteCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClienteDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Procurar:");

        btnPesquisaOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaOrcamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaOrcamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPesquisaOrcamento)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtPesquisaOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setToolTipText("");
        jTabbedPane2.setName(""); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Serviço:");

        txtCodigoServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoServicoKeyTyped(evt);
            }
        });

        btnPesquisarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarServico.setName("FrmOrcamentos"); // NOI18N
        btnPesquisarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarServicoActionPerformed(evt);
            }
        });

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serviço", "Quantidade", "Valor Unitário", "Valor Total", "Código Servico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblServicos.setTableHeader(null);
        tblServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServicos);
        if (tblServicos.getColumnModel().getColumnCount() > 0) {
            tblServicos.getColumnModel().getColumn(0).setResizable(false);
            tblServicos.getColumnModel().getColumn(0).setPreferredWidth(300);
            tblServicos.getColumnModel().getColumn(1).setResizable(false);
            tblServicos.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblServicos.getColumnModel().getColumn(2).setResizable(false);
            tblServicos.getColumnModel().getColumn(2).setPreferredWidth(15);
            tblServicos.getColumnModel().getColumn(3).setResizable(false);
            tblServicos.getColumnModel().getColumn(3).setPreferredWidth(15);
            tblServicos.getColumnModel().getColumn(4).setMinWidth(0);
            tblServicos.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblServicos.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btnIncluirServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnIncluirServico.setMaximumSize(new java.awt.Dimension(47, 23));
        btnIncluirServico.setPreferredSize(new java.awt.Dimension(47, 23));
        btnIncluirServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirServicoActionPerformed(evt);
            }
        });

        btnRemoverServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnRemoverServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverServicoActionPerformed(evt);
            }
        });

        txtQuantidadeCompartimentos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeCompartimentosFocusLost(evt);
            }
        });
        txtQuantidadeCompartimentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeCompartimentosKeyTyped(evt);
            }
        });

        jLabel11.setText("Quantidade:");

        jLabel13.setText("Valor Unitário:");

        txtValorUnitarioServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorUnitarioServicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorUnitarioServicoFocusLost(evt);
            }
        });
        txtValorUnitarioServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorUnitarioServicoKeyTyped(evt);
            }
        });

        jLabel15.setText("Total de Serviços:");

        txtValorTotalServicos.setEditable(false);
        txtValorTotalServicos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        jLabel17.setText("Valor Total:");

        txtValorTotalServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalServicoFocusLost(evt);
            }
        });
        txtValorTotalServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalServicoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidadeCompartimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtValorUnitarioServico, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 58, Short.MAX_VALUE))
                            .addComponent(txtValorTotalServico)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoverServico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluirServico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnPesquisarServico, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorTotalServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorUnitarioServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidadeCompartimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnIncluirServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverServico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValorTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Serviços", jPanel2);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("Peça:");

        txtQuantidadePeca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadePecaFocusLost(evt);
            }
        });
        txtQuantidadePeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadePecaKeyTyped(evt);
            }
        });

        jLabel19.setText("Quantidade");

        txtValorUnitarioPeca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorUnitarioPecaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorUnitarioPecaFocusLost(evt);
            }
        });
        txtValorUnitarioPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorUnitarioPecaKeyTyped(evt);
            }
        });

        jLabel20.setText("Valor Unitário");

        jLabel21.setText("Valor Total");

        txtValorTotalPeca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalPecaFocusLost(evt);
            }
        });
        txtValorTotalPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalPecaKeyTyped(evt);
            }
        });

        btnPesquisarPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPecaActionPerformed(evt);
            }
        });

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Peça", "Quantidade", "Valor Unitário", "Valor Total", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPecas.setTableHeader(null);
        tblPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPecasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblPecas);
        if (tblPecas.getColumnModel().getColumnCount() > 0) {
            tblPecas.getColumnModel().getColumn(0).setResizable(false);
            tblPecas.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblPecas.getColumnModel().getColumn(1).setResizable(false);
            tblPecas.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblPecas.getColumnModel().getColumn(2).setResizable(false);
            tblPecas.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblPecas.getColumnModel().getColumn(3).setResizable(false);
            tblPecas.getColumnModel().getColumn(3).setPreferredWidth(20);
            tblPecas.getColumnModel().getColumn(4).setMinWidth(0);
            tblPecas.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblPecas.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btnIncluirPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnIncluirPeca.setMaximumSize(new java.awt.Dimension(47, 23));
        btnIncluirPeca.setPreferredSize(new java.awt.Dimension(47, 23));
        btnIncluirPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirPecaActionPerformed(evt);
            }
        });

        btnRemoverPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPecaActionPerformed(evt);
            }
        });

        jLabel24.setText("Total de Peças:");

        txtValorTotalPecas.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtCodigoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescricaoPeca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorUnitarioPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorTotalPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorTotalPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoverPeca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIncluirPeca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnPesquisarPeca)
                        .addComponent(txtDescricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValorUnitarioPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtValorTotalPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnIncluirPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverPeca)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTotalPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Peças", jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Geral", jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Condições de Pagamento:");

        jLabel4.setText("Observações:");

        jLabel5.setText("Forma de Pagamento:");

        jLabel6.setText("Total de Serviços:");

        jLabel7.setText("%  Desconto:");

        jLabel10.setText(" Total Orçamento:");

        tblPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parcela", "Prazo", "Vencimento", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPagamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPagamentos);
        if (tblPagamentos.getColumnModel().getColumnCount() > 0) {
            tblPagamentos.getColumnModel().getColumn(0).setResizable(false);
            tblPagamentos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPagamentos.getColumnModel().getColumn(1).setResizable(false);
            tblPagamentos.getColumnModel().getColumn(2).setResizable(false);
            tblPagamentos.getColumnModel().getColumn(3).setResizable(false);
        }

        btnAdicionarParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnAdicionarParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarParcelaActionPerformed(evt);
            }
        });

        jLabel2.setText("N. Parcelas:");

        txtNumeroParcelas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumeroParcelasFocusLost(evt);
            }
        });
        txtNumeroParcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroParcelasKeyTyped(evt);
            }
        });

        txtValorTotalServicosFechamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorTotalServicosFechamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalServicosFechamentoFocusLost(evt);
            }
        });
        txtValorTotalServicosFechamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalServicosFechamentoKeyTyped(evt);
            }
        });

        txtValorDescontoServicos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorDescontoServicosFocusLost(evt);
            }
        });
        txtValorDescontoServicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorDescontoServicosKeyTyped(evt);
            }
        });

        txtValorTotalOrcamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorTotalOrcamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalOrcamentoFocusLost(evt);
            }
        });
        txtValorTotalOrcamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalOrcamentoKeyTyped(evt);
            }
        });

        btnExcluirParcela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnExcluirParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirParcelaActionPerformed(evt);
            }
        });

        try {
            txtParcelaVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtParcelaVencimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtParcelaVencimentoFocusLost(evt);
            }
        });

        txtParcelaValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtParcelaValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtParcelaValorFocusLost(evt);
            }
        });

        txtParcelaPrazo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtParcelaPrazoFocusLost(evt);
            }
        });
        txtParcelaPrazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParcelaPrazoKeyTyped(evt);
            }
        });

        txtParcelaNumero.setEnabled(false);

        jScrollPane3.setViewportView(txtObservacoes);

        txtPercentualDescontoServicos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPercentualDescontoServicosFocusLost(evt);
            }
        });
        txtPercentualDescontoServicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPercentualDescontoServicosKeyTyped(evt);
            }
        });

        jLabel22.setText("Total de Peças:");

        txtValorTotalPecasFechamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorTotalPecasFechamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorTotalPecasFechamentoFocusLost(evt);
            }
        });
        txtValorTotalPecasFechamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorTotalPecasFechamentoKeyTyped(evt);
            }
        });

        jLabel23.setText("% Desconto:");

        txtPercentualDescontoPecas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPercentualDescontoPecasFocusLost(evt);
            }
        });
        txtPercentualDescontoPecas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPercentualDescontoPecasKeyTyped(evt);
            }
        });

        txtValorDescontoPecas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorDescontoPecasFocusLost(evt);
            }
        });
        txtValorDescontoPecas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorDescontoPecasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtPercentualDescontoServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtValorDescontoServicos))
                                            .addComponent(txtValorTotalOrcamento, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtValorTotalServicosFechamento, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel23))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtValorTotalPecasFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(txtPercentualDescontoPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtValorDescontoPecas))))))
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtParcelaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtParcelaPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtParcelaVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtParcelaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExcluirParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAdicionarParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 210, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtValorTotalPecasFechamento, txtValorTotalServicosFechamento});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPercentualDescontoPecas, txtPercentualDescontoServicos});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(txtValorTotalServicosFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtValorTotalPecasFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorDescontoServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPercentualDescontoServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtPercentualDescontoPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorDescontoPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(txtValorTotalOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumeroParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtParcelaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParcelaVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParcelaPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParcelaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdicionarParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirParcela))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionarParcela, btnExcluirParcela});

        jTabbedPane1.addTab("Fechamento", jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCancelarOrcamento.setText("Cancelar");
        btnCancelarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOrcamentoActionPerformed(evt);
            }
        });

        btnAbandonar.setText("Abandonar");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });

        btnAprovarOrcamento.setText("Aprovar");
        btnAprovarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAprovarOrcamentoActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar)
                .addGap(121, 121, 121)
                .addComponent(btnAprovarOrcamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarOrcamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGravar, btnSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarOrcamento)
                    .addComponent(btnAbandonar)
                    .addComponent(btnAprovarOrcamento)
                    .addComponent(btnImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularValorTotalServicos() {
        BigDecimal valorTotalServicos = BigDecimal.ZERO;

        for (int x = 0; x < tblServicos.getRowCount(); x++) {
            String valor = tblServicos.getValueAt(x, 3).toString();
            BigDecimal valorTotal = new BigDecimal(valor);
            valorTotalServicos = valorTotalServicos.add(valorTotal);
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorTotalServicosFormatado = nf.format(valorTotalServicos);
        txtValorTotalServicos.setText(valorTotalServicosFormatado.replace("R$", "").replace(" ", ""));
        txtValorTotalServicosFechamento.setText(valorTotalServicosFormatado.replace("R$", "").replace(" ", ""));
    }

    private void calcularValorTotalPecas() {
        BigDecimal valorTotalPecas = BigDecimal.ZERO;

        for (int x = 0; x < tblPecas.getRowCount(); x++) {
            String valor = tblPecas.getValueAt(x, 3).toString();
            BigDecimal valorTotal = new BigDecimal(valor);
            valorTotalPecas = valorTotalPecas.add(valorTotal);
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorTotalPecasFormatado = nf.format(valorTotalPecas);
        txtValorTotalPecas.setText(valorTotalPecasFormatado.replace("R$", "").replace(" ", ""));
        txtValorTotalPecasFechamento.setText(valorTotalPecasFormatado.replace("R$", "").replace(" ", ""));
    }

    private void btnAdicionarParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarParcelaActionPerformed
        if (txtValorTotalOrcamento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Valor total do orçamento zerado, verifique o lançamento de peças e serviços!");
            txtValorTotalOrcamento.setText(BigDecimal.ZERO.toString());
            txtValorTotalOrcamento.selectAll();
            txtValorTotalOrcamento.requestFocus();
            return;
        }
        if (txtNumeroParcelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o número de parcelas!");
            txtNumeroParcelas.requestFocus();
            return;
        }
        if (txtParcelaPrazo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o prazo para pagamento da parcela!");
            txtParcelaPrazo.requestFocus();
            return;
        }

        String parcelaNumero = txtParcelaNumero.getText();
        String parcelaPrazo = txtParcelaPrazo.getText();
        String parcelaValor = txtParcelaValor.getText();
        String parcelaVencimento = txtParcelaVencimento.getText();

        for (int x = 0; x < tblPagamentos.getRowCount(); x++) {
            if (tblPagamentos.getValueAt(x, 0).equals(txtParcelaPrazo.getText().trim())) {
                lAlterandoParcela = true;
            }
        }

        int proximoNumeroParcela = Integer.parseInt(parcelaNumero) + 1;
        if (lAlterandoParcela == false) {
            if (Integer.parseInt(txtParcelaNumero.getText()) > Integer.parseInt(txtNumeroParcelas.getText())) {
                JOptionPane.showMessageDialog(null, "Número total de parcelas já informado. Verifique!");
                txtNumeroParcelas.requestFocus();
                lAlterandoNumeroParcelas = true;
                return;
            } else {
                DefaultTableModel valores = (DefaultTableModel) tblPagamentos.getModel();
                valores.addRow(new Object[]{parcelaNumero, parcelaPrazo, parcelaVencimento, parcelaValor.replace(" ", "").replace(".", "").replace(",", ".")});
            }
        } else {
            if (tblPagamentos.getSelectedRow() != -1) {
                tblPagamentos.setValueAt(txtParcelaNumero.getText(), tblPagamentos.getSelectedRow(), 0);
                tblPagamentos.setValueAt(txtParcelaPrazo.getText(), tblPagamentos.getSelectedRow(), 1);
                tblPagamentos.setValueAt(txtParcelaVencimento.getText(), tblPagamentos.getSelectedRow(), 2);
                tblPagamentos.setValueAt(txtParcelaValor.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), tblPagamentos.getSelectedRow(), 3);
            }
        }
        txtParcelaNumero.setText(String.valueOf(proximoNumeroParcela));
        txtParcelaPrazo.setText("");
        txtParcelaVencimento.setText("");
        txtParcelaValor.setText("");
        txtParcelaPrazo.requestFocus();
        tblPagamentos.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnAdicionarParcelaActionPerformed

    private void txtValorTotalServicosFechamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalServicosFechamentoFocusLost
        BigDecimal valorTotalServicos = new BigDecimal(txtValorTotalServicosFechamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
        if (!txtValorTotalServicosFechamento.getText().isEmpty()) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorTotalServicosFechamento.setText(nf.format(valorTotalServicos).replace("R$", ""));
        } else {
            txtValorTotalServicosFechamento.setText("R$0,00");
        }
    }//GEN-LAST:event_txtValorTotalServicosFechamentoFocusLost

    private void txtValorDescontoServicosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorDescontoServicosFocusLost
        BigDecimal valorDescontosServicos = new BigDecimal(txtValorDescontoServicos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
        if (!txtValorDescontoServicos.getText().isEmpty()) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorDescontoServicos.setText(nf.format(valorDescontosServicos).replace("R$", ""));
        } else {
            txtValorDescontoServicos.setText("0,00");
        }
    }//GEN-LAST:event_txtValorDescontoServicosFocusLost

    private void txtValorTotalOrcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalOrcamentoFocusLost
        BigDecimal valorTotalOrcamento = new BigDecimal(txtValorTotalOrcamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
        if (!txtValorTotalOrcamento.getText().isEmpty()) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorTotalOrcamento.setText(nf.format(valorTotalOrcamento).replace("R$", "").replace(" ", ""));
        } else {
            txtValorTotalOrcamento.setText("R$0,00");
        }
    }//GEN-LAST:event_txtValorTotalOrcamentoFocusLost

    private void txtValorTotalOrcamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalOrcamentoFocusGained
        txtValorTotalOrcamento.selectAll();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        BigDecimal valorServicos = new BigDecimal(txtValorTotalServicosFechamento.getText().replace(" ", "").replace(".", "").replace(",", "."));
        BigDecimal valorDescontoServicos = new BigDecimal(txtValorDescontoServicos.getText().replace(" ", "").replace(".", "").replace(",", "."));
        BigDecimal valorTotalServicos = valorServicos.subtract(valorDescontoServicos);
        
        BigDecimal valorPecas = new BigDecimal(txtValorTotalPecasFechamento.getText().replace(" ", "").replace(".", "").replace(",", "."));
        BigDecimal valorDescontoPecas = new BigDecimal(txtValorDescontoPecas.getText().replace(" ", "").replace(".", "").replace(",", "."));
        BigDecimal valorTotalPecas = valorPecas.subtract(valorDescontoPecas);
        
        BigDecimal valorTotalOrcamento = BigDecimal.ZERO;
        valorTotalOrcamento = valorTotalServicos.add(valorTotalPecas);
        
        txtValorTotalOrcamento.setText(nf.format(valorTotalOrcamento).replace("R$", "").replace(" ", ""));
    }//GEN-LAST:event_txtValorTotalOrcamentoFocusGained

    private void txtValorTotalServicosFechamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalServicosFechamentoKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalServicosFechamentoKeyTyped

    private void txtValorDescontoServicosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDescontoServicosKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorDescontoServicosKeyTyped

    private void txtValorTotalOrcamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalOrcamentoKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalOrcamentoKeyTyped

    private void txtNumeroParcelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroParcelasKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroParcelasKeyTyped

    private void tblPagamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagamentosMouseClicked
        int index = tblPagamentos.getSelectedRow();
        TableModel model = tblPagamentos.getModel();

        String parcelaNumero = model.getValueAt(index, 0).toString();
        String parcelaPrazo = model.getValueAt(index, 1).toString();
        String parcelaVencimento = model.getValueAt(index, 2).toString();
        String parcelaValor = model.getValueAt(index, 3).toString();

        txtParcelaNumero.setText(parcelaNumero);
        txtParcelaPrazo.setText(parcelaPrazo);
        txtParcelaVencimento.setText(parcelaVencimento);
        txtParcelaValor.setText(parcelaValor);

        lAlterandoParcela = true;
    }//GEN-LAST:event_tblPagamentosMouseClicked

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDataValidadeOrcamento.getText().trim().length() < 10) {
            JOptionPane.showMessageDialog(null, "Informe a data de validade do orçamento!");
            txtDataValidadeOrcamento.requestFocus();
        } else if (txtClienteCodigo.getText().isEmpty() || txtClienteDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o cliente do orçamento!");
            btnPesquisaCliente.requestFocus();
        } else {
            //Carrega os valores da tabela geral de orçamentos:
            orcamento.setOrcamentoNumero(Integer.parseInt(txtOrcamentoNumero.getText()));
            if (incluindo == 1) {
                orcamento.setDataAbertura(new Date());
            } else {
                try {
                    conecta.executaSql("SELECT * "
                                     + "FROM ORCAMENTOS "
                                     + "WHERE NUMERO = " + Integer.parseInt(txtOrcamentoNumero.getText() + ""));

                    if (conecta.rs.first() && conecta.rs.getString("VERSAO").equals(txtVersaoOrcamento.getText())) {
                        orcamento.setDataAbertura(dataAbertura);
                    } else {
                        orcamento.setDataAbertura(new Date());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            orcamento.setDataValidade(funcoes.StringParaLocalDate(txtDataValidadeOrcamento.getText()));
            orcamento.setVersaoOrcamento(txtVersaoOrcamento.getText());
            orcamento.setClienteCodigo(Integer.parseInt(txtClienteCodigo.getText()));

            String totalServicos = txtValorTotalServicosFechamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalServicos = new BigDecimal(totalServicos);
            orcamento.setValorTotalServicos(valorTotalServicos);

            String totalPecas = txtValorTotalPecasFechamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalPecas = new BigDecimal(totalPecas);
            orcamento.setValorTotalPecas(valorTotalPecas);
            
            String totalDescontosServicos = txtValorDescontoServicos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalDescontos = new BigDecimal(totalDescontosServicos);
            orcamento.setValorDescontoServicos(valorTotalDescontos);

            String totalDescontosPecas = txtValorDescontoPecas.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalDescontosPecas = new BigDecimal(totalDescontosPecas);
            orcamento.setValorDescontoPecas(valorTotalDescontosPecas);

            String totalOrcamento = txtValorTotalOrcamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalOrcamento = new BigDecimal(totalOrcamento);
            orcamento.setValorTotalOrcamento(valorTotalOrcamento);

            String formaPagamentoDescricao = cmbFormaPagamento.getSelectedItem().toString();
            conecta.conexao();
            conecta.executaSql("SELECT CODIGO FROM FORMASPAGAMENTO WHERE DESCRICAO = '" + formaPagamentoDescricao + "'");
            try {
                if (conecta.rs.next()) {
                    orcamento.setFormaPagamento(conecta.rs.getInt("CODIGO"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }

            orcamento.setObservacoes(txtObservacoes.getText().trim());
//            if (txtObservacoes.getText().isEmpty()) {
//                orcamento.setObservacoes("");
//            } else {
//                if (incluindo == 1) {
//                    orcamento.setObservacoes(txtObservacoes.getText().trim());
//                } else {
//                    orcamento.setObservacoes(txtObservacoes.getText());
//                }
//            }

            orcamento.setSituacao("ABERTO");
        }

        if (dao.validarTotalParcelas(this) == true) {
            dao.gravar(orcamento, this);
            imprimirOrcamento();
            limpaCampos();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void imprimirOrcamento() {
        conecta.conexao();

        int numeroOrcamento = 0;
        HashMap filtro = new HashMap();

        //Logo por parâmetro:
        filtro.put("logoVizipostos", this.getClass().getResourceAsStream(logoVizipostos));
        filtro.put("logoCertificacaoVizipostos", this.getClass().getResourceAsStream(logoCertificacaoVizipostos));

        //Parâmetro do caminho para o subrelatorio financeiro:
        filtro.put("SUBREPORT_DIR_FINANCEIRO", this.getClass().getResourceAsStream(diretorioSubrelatorioFinanceiro));

        //Parâmetro do caminho para o subrelatorio de servicos:
        filtro.put("SUBREPORT_DIR_SERVICOS", this.getClass().getResourceAsStream(diretorioSubrelatorioServicos));

        //Parâmetro do caminho para o subrelatorio de pecas:
        filtro.put("SUBREPORT_DIR_PECAS", this.getClass().getResourceAsStream(diretorioSubrelatorioPecas));

        //Parâmetro do número do orçamento:
        numeroOrcamento = Integer.parseInt(txtOrcamentoNumero.getText());
        filtro.put("numeroOrcamento", numeroOrcamento);


        InputStream jasperFile = Thread.currentThread().getClass().getResourceAsStream("/Relatorios/orcamento.jasper");
        JasperPrint jPrint = null;

        try {
            jPrint = JasperFillManager.fillReport(jasperFile, filtro, conecta.con);
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtValorUnitarioServicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioServicoKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorUnitarioServicoKeyTyped

    private void txtValorUnitarioServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioServicoFocusLost
        int quantidadeCompartimentos = Integer.parseInt(txtQuantidadeCompartimentos.getText());
        String sv = txtValorUnitarioServico.getText();        
        if (!txtValorUnitarioServico.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorUnitarioServico = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorUnitarioFormatado = nf.format(valorUnitarioServico);
            txtValorUnitarioServico.setText(valorUnitarioFormatado);
            
            BigDecimal valorTotalServico = valorUnitarioServico.multiply(new BigDecimal(quantidadeCompartimentos));
            String valorTotalFormatado = nf.format(valorTotalServico);
            txtValorTotalServico.setText(valorTotalFormatado);        
        } else {
            txtValorUnitarioServico.setText("R$0,00");
        }
    }//GEN-LAST:event_txtValorUnitarioServicoFocusLost

    private void txtQuantidadeCompartimentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeCompartimentosKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeCompartimentosKeyTyped

    private void txtQuantidadeCompartimentosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeCompartimentosFocusLost
        if (txtQuantidadeCompartimentos.getText().isEmpty()) {
            txtQuantidadeCompartimentos.setText("1");
        }
    }//GEN-LAST:event_txtQuantidadeCompartimentosFocusLost

    private void btnRemoverServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverServicoActionPerformed
        if (tblServicos.getSelectedRow() != -1) {
            ((DefaultTableModel) tblServicos.getModel()).removeRow(tblServicos.getSelectedRow());
            txtCodigoServico.setText("");
            txtDescricaoServico.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o serviço para eliminar!");
        }

        txtCodigoServico.setText("");
        txtDescricaoServico.setText("");
        txtQuantidadeCompartimentos.setText("");
        txtValorUnitarioServico.setText("");
        txtValorTotalServico.setText(""); 
        txtDescricaoServico.requestFocus();
    }//GEN-LAST:event_btnRemoverServicoActionPerformed

    private void btnIncluirServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirServicoActionPerformed
        boolean lAlterandoServico = false;
        int quantidadeCompartimentos = 0;

        if (txtCodigoServico.getText().isEmpty() || txtDescricaoServico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o serviço!");
            txtDescricaoServico.requestFocus();
        } else if (txtQuantidadeCompartimentos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de compartimentos do tanque para executar o serviço!");
        } else if (txtValorUnitarioServico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor do serviço!");
            txtValorUnitarioServico.requestFocus();
        } else {
            String servicoCodigo = txtCodigoServico.getText();
            String servicoDescricao = txtDescricaoServico.getText().trim();
            quantidadeCompartimentos = Integer.parseInt(txtQuantidadeCompartimentos.getText());
            BigDecimal valorUnitarioServico = new BigDecimal(txtValorUnitarioServico.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
            BigDecimal valorTotalServico = valorUnitarioServico.multiply(new BigDecimal(quantidadeCompartimentos));

            if (txtDescricaoServico.getText().contains("ESTANQUEIDADE")){
                txtObservacoes.setText(textoFixoObservacoes);
            }
                                
            for (int x = 0; x < tblServicos.getRowCount(); x++) {
                if (tblServicos.getValueAt(x, 0).equals(txtDescricaoServico.getText().trim())) {
                    lAlterandoServico = true;
                }
            }
            
            if (lAlterandoServico == false) {
                DefaultTableModel valores = (DefaultTableModel) tblServicos.getModel();
                valores.addRow(new Object[]{servicoDescricao, quantidadeCompartimentos, valorUnitarioServico, valorTotalServico, servicoCodigo});

                conecta.conexao();
                conecta.executaSql("SELECT SERVICOSLISTASERVICOS.CODIGOSERVICOPRINCIPAL,  "
                                 + "       SERVICOSLISTASERVICOS.CODIGOSERVICOLISTA, "
                                 + "       (SELECT SERVICOS.DESCRICAO "
                                 + "        FROM SERVICOS "
                                 + "        WHERE SERVICOS.CODIGO = SERVICOSLISTASERVICOS.CODIGOSERVICOLISTA) "
                                 + "FROM SERVICOSLISTASERVICOS "
                                 + "JOIN SERVICOS ON(SERVICOS.CODIGO = SERVICOSLISTASERVICOS.CODIGOSERVICOPRINCIPAL) "   
                                 + "WHERE CODIGOSERVICOPRINCIPAL = " + servicoCodigo + " ");
                try {
                    if (conecta.rs.first()){                        
                        do {
                            DefaultTableModel valores1 = (DefaultTableModel) tblServicos.getModel();
                            valores1.addRow(new Object[]{conecta.rs.getString("DESCRICAO").trim(), 1, 00.00, 00.00, conecta.rs.getInt("CODIGOSERVICOLISTA")});
                        } while (conecta.rs.next()); 
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar lista de serviços do serviço! \n ERRO: " + ex);
                }
                
                tblServicos.getColumnModel().getColumn(4).setMaxWidth(0);
                tblServicos.getColumnModel().getColumn(4).setMinWidth(0);
            } else {
                if (tblServicos.getSelectedRow() != -1) {
                    tblServicos.setValueAt(txtDescricaoServico.getText(), tblServicos.getSelectedRow(), 0);
                    tblServicos.setValueAt(txtQuantidadeCompartimentos.getText(), tblServicos.getSelectedRow(), 1);
                    tblServicos.setValueAt(txtValorUnitarioServico.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), tblServicos.getSelectedRow(), 2);
                    tblServicos.setValueAt(valorTotalServico, tblServicos.getSelectedRow(), 3);
                    tblServicos.setValueAt(txtCodigoServico.getText(), tblServicos.getSelectedRow(), 4);
                }
            }            
            
            txtCodigoServico.setText("");
            txtDescricaoServico.setText("");
            txtQuantidadeCompartimentos.setText("");
            txtValorUnitarioServico.setText("");
            txtValorTotalServico.setText(""); 
            txtDescricaoServico.requestFocus();
            calcularValorTotalServicos();
        }
    }//GEN-LAST:event_btnIncluirServicoActionPerformed

    private void tblServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicosMouseClicked
        int index = tblServicos.getSelectedRow();
        TableModel model = tblServicos.getModel();

        String servicoDescricao = model.getValueAt(index, 0).toString();
        String quantidadeCompartimentos = model.getValueAt(index, 1).toString();
        String valorUnitarioServico = model.getValueAt(index, 2).toString();
        String valorTotalServico = model.getValueAt(index, 3).toString();
        String servicoCodigo = model.getValueAt(index, 4).toString();

        txtCodigoServico.setText(servicoCodigo);
        txtDescricaoServico.setText(servicoDescricao);
        txtQuantidadeCompartimentos.setText(quantidadeCompartimentos);
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        BigDecimal valorUnitario = new BigDecimal(valorUnitarioServico);
        String valorUnitarioServicoFormatado = nf.format(valorUnitario);
        txtValorUnitarioServico.setText(valorUnitarioServicoFormatado);
        
        BigDecimal valorTotal = new BigDecimal(valorTotalServico);
        String valorTotalServicoFormatado = nf.format(valorTotal);
        txtValorTotalServico.setText(valorTotalServicoFormatado);        
    }//GEN-LAST:event_tblServicosMouseClicked

    private void btnPesquisarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarServicoActionPerformed
        if (!txtDescricaoServico.getText().isEmpty()) {
            pesquisaServicos = new PesquisaServicos();
            pesquisaServicos.setLocationRelativeTo(null);
            pesquisaServicos.setVisible(true);
            pesquisaServicos.setResizable(false);
            pesquisaServicos.preencherTabela(this, "", "SELECT * FROM SERVICOS WHERE DESCRICAO LIKE '%" + txtDescricaoServico.getText() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaServicos = new PesquisaServicos();
            pesquisaServicos.setLocationRelativeTo(null);
            pesquisaServicos.setVisible(true);
            pesquisaServicos.preencherTabela(this, "", "SELECT * FROM SERVICOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarServicoActionPerformed

    private void txtCodigoServicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoServicoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoServicoKeyTyped

    private void btnPesquisaOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaOrcamentoActionPerformed
        limpaCampos();
        txtObservacoes.setText("");
        String condicao = null;
        if (!txtPesquisaOrcamento.getText().isEmpty()) {
            pesquisaOrcamentos = new PesquisaOrcamentos();
            pesquisaOrcamentos.setLocationRelativeTo(null);
            pesquisaOrcamentos.setVisible(true);
            pesquisaOrcamentos.setResizable(false);

            if (funcoes.stringNumerica(txtPesquisaOrcamento.getText()) == true) {
                condicao = "WHERE ORCAMENTOS.NUMERO = " + Integer.parseInt(txtPesquisaOrcamento.getText()) + " ";
            } else {
                condicao = "WHERE PESSOAS.RAZAOSOCIAL LIKE '%" + txtPesquisaOrcamento.getText() + "%' ";
            }

            pesquisaOrcamentos.preencherTabela(this, "SELECT ORCAMENTOS.NUMERO,           "
                                                    + "      ORCAMENTOS.CLIENTECODIGO,    "
                                                    + "      PESSOAS.RAZAOSOCIAL,         "
                                                    + "      FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, * "
                                                    + "FROM ORCAMENTOS "
                                                    + "JOIN PESSOAS ON (PESSOAS.CODIGO = ORCAMENTOS.CLIENTECODIGO) "
                                                    + "JOIN FORMASPAGAMENTO ON (FORMASPAGAMENTO.CODIGO = ORCAMENTOS.FORMAPAGAMENTO) "
                                                    + condicao
                                                    + "ORDER BY ORCAMENTOS.NUMERO DESC, PESSOAS.RAZAOSOCIAL");
        } else {
            pesquisaOrcamentos = new PesquisaOrcamentos();
            pesquisaOrcamentos.setLocationRelativeTo(null);
            pesquisaOrcamentos.setVisible(true);
            pesquisaOrcamentos.setResizable(false);
            pesquisaOrcamentos.preencherTabela(this, "SELECT ORCAMENTOS.NUMERO,           "
                                                    + "      ORCAMENTOS.CLIENTECODIGO,    "
                                                    + "      PESSOAS.RAZAOSOCIAL,         "
                                                    + "      FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, * " + "FROM ORCAMENTOS "
                                                    + "JOIN PESSOAS ON (PESSOAS.CODIGO = ORCAMENTOS.CLIENTECODIGO)"
                                                    + "JOIN FORMASPAGAMENTO ON (FORMASPAGAMENTO.CODIGO = ORCAMENTOS.FORMAPAGAMENTO) "
                                                    + "ORDER BY ORCAMENTOS.NUMERO DESC, PESSOAS.RAZAOSOCIAL");
        }
    }//GEN-LAST:event_btnPesquisaOrcamentoActionPerformed

    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
        if (!txtClienteDescricao.getText().isEmpty()) {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.setResizable(false);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS WHERE UPPER(RAZAOSOCIAL) LIKE '%" + txtClienteDescricao.getText().trim().toUpperCase() + "%' ORDER BY RAZAOSOCIAL");
        } else {
            pesquisaPessoas = new PesquisaPessoas();
            pesquisaPessoas.setLocationRelativeTo(null);
            pesquisaPessoas.setVisible(true);
            pesquisaPessoas.preencherTabela(this, "SELECT * FROM PESSOAS ORDER BY RAZAOSOCIAL");
        }
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    private void txtClienteCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClienteCodigoKeyTyped

    private void txtOrcamentoNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrcamentoNumeroKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtOrcamentoNumeroKeyTyped

    private void btnExcluirParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirParcelaActionPerformed
        if (tblPagamentos.getSelectedRow() != -1) {
            ((DefaultTableModel) tblPagamentos.getModel()).removeRow(tblPagamentos.getSelectedRow());
            lAlterandoParcela = false;
            txtParcelaPrazo.setText("");
            txtParcelaVencimento.setText("");
            txtParcelaValor.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a duplicata para eliminar!");
        }   
    }//GEN-LAST:event_btnExcluirParcelaActionPerformed

    private void txtParcelaVencimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtParcelaVencimentoFocusLost
        if (!txtParcelaVencimento.getText().isEmpty()) {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Calendar vencimentoParcela = Calendar.getInstance();
//            Calendar dataAtual = Calendar.getInstance();
//            try {
//                vencimentoParcela.setTime(sdf.parse(txtParcelaVencimento.getText()));
//                dataAtual.setTime(sdf.parse(new Date().toString()));
//            } catch (java.text.ParseException e) {
//                
//            }
//            
//            int condicao = vencimentoParcela.get(Calendar.DAY_OF_YEAR) - dataAtual.get(Calendar.DAY_OF_YEAR);
//            txtParcelaPrazo.setText(String.valueOf(String.format("%02d", condicao)));

//            String dateStart = txtParcelaVencimento.getText();
//            String dateStop = "02/2/2001 06:31"; 
           
        
            Date dataAtual = new Date();
            String dataVencimento = txtParcelaVencimento.getText();
            
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try { 
                String atual = format.format(dataAtual); 
                DateTime atualFormatado = new DateTime(format.parse(atual));                 
                DateTime vencimentoFormatado = new DateTime(format.parse(dataVencimento)); 
                
                txtParcelaPrazo.setText(String.valueOf(String.format("%03d", Days.daysBetween(atualFormatado, vencimentoFormatado).getDays())));

            } catch (ParseException ex) {
                Logger.getLogger(Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int numeroParcelas = Integer.parseInt(txtNumeroParcelas.getText());
            BigDecimal valorTotal = new BigDecimal(txtValorTotalOrcamento.getText().replace(" ", "").replace(".", "").replace(",", "."));
            BigDecimal valorParcela = valorTotal.divide(new BigDecimal(numeroParcelas), MathContext.DECIMAL64); 

            if (lAlterandoNumeroParcelas) {
                txtParcelaValor.setText("0.00");
            } else {
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                String valorParcelaFormatado = nf.format(valorParcela);
                txtParcelaValor.setText(valorParcelaFormatado.replace("R$", ""));
            }
        }
    }//GEN-LAST:event_txtParcelaVencimentoFocusLost

    private void txtParcelaPrazoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtParcelaPrazoFocusLost
        if (txtParcelaPrazo.getText().isEmpty()) {
            txtParcelaPrazo.setText("");
        } else {
            int condicao = Integer.parseInt(txtParcelaPrazo.getText());
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = new GregorianCalendar();
            c.add(Calendar.DAY_OF_MONTH, condicao);
            String dataVencimento = sd.format(c.getTime());
            txtParcelaVencimento.setText(dataVencimento);
            txtParcelaVencimento.requestFocus();
        }
    }//GEN-LAST:event_txtParcelaPrazoFocusLost

    private void txtParcelaPrazoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParcelaPrazoKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtParcelaPrazoKeyTyped

    private void txtNumeroParcelasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroParcelasFocusLost
        txtParcelaPrazo.requestFocus();

        int parcela = tblPagamentos.getRowCount() + 1;
        String numeroParcela = String.valueOf(parcela);
        txtParcelaNumero.setText(numeroParcela);
    }//GEN-LAST:event_txtNumeroParcelasFocusLost

    private void txtParcelaValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtParcelaValorFocusLost
        String sv = txtParcelaValor.getText();
        if (!txtParcelaValor.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtParcelaValor.setText(valorFormatado.replace("R$", ""));
        }
        btnAdicionarParcela.requestFocus();
    }//GEN-LAST:event_txtParcelaValorFocusLost

    private void txtParcelaValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtParcelaValorFocusGained
        txtParcelaValor.selectAll();
    }//GEN-LAST:event_txtParcelaValorFocusGained

    private void btnCancelarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOrcamentoActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente cancelar o orçamento?");
        if (resposta == JOptionPane.YES_OPTION) {
            int orcamentoNumero = Integer.parseInt(txtOrcamentoNumero.getText());
            dao.cancelarOrcamento(orcamentoNumero);
            limpaCampos();
        }
    }//GEN-LAST:event_btnCancelarOrcamentoActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtPesquisaOrcamento.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void txtPercentualDescontoServicosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPercentualDescontoServicosFocusLost
        if (!txtPercentualDescontoServicos.getText().isEmpty()) {
            BigDecimal valorServicos = new BigDecimal(txtValorTotalServicosFechamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
            BigDecimal percentualDescontoServicos = new BigDecimal(txtPercentualDescontoServicos.getText()).divide(BigDecimal.valueOf(100));
            BigDecimal valorTotalServicos = new BigDecimal(BigInteger.ZERO);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            valorTotalServicos = percentualDescontoServicos.multiply(valorServicos);
            txtValorDescontoServicos.setText(nf.format(valorTotalServicos).replace("R$", ""));
        } else {
            txtPercentualDescontoServicos.setText("0,00");
            txtValorDescontoServicos.setText("0,00");
            txtValorTotalOrcamento.setText("0,00");
        }
    }//GEN-LAST:event_txtPercentualDescontoServicosFocusLost

    private void txtValorUnitarioServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioServicoFocusGained
        txtValorUnitarioServico.selectAll();
    }//GEN-LAST:event_txtValorUnitarioServicoFocusGained

    private void txtPercentualDescontoServicosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPercentualDescontoServicosKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPercentualDescontoServicosKeyTyped

    private void btnAprovarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAprovarOrcamentoActionPerformed
        if (txtOrcamentoNumero.getText().isEmpty() || txtClienteCodigo.getText().isEmpty() || txtClienteDescricao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione o orçamento para realizar a aprovação!");
            return;
        } else {
            int planilha = 0, numeroDocumento = 0, orcamentoNumero = Integer.parseInt(txtOrcamentoNumero.getText()); 
            String operacao = "2001", numeroDocumentoFormatado = null;
            Date dataEmissao = new Date();

            String totalOrcamento = txtValorTotalOrcamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotalFatura = new BigDecimal(totalOrcamento);

            String formaPagamentoDescricao = cmbFormaPagamento.getSelectedItem().toString();
            int formaPagamentoCodigo = 0;
            
            conecta.conexao();
            conecta.executaSql("SELECT CODIGO FROM FORMASPAGAMENTO WHERE DESCRICAO = '" + formaPagamentoDescricao + "' " );
            try {
                conecta.rs.first();
                do {
                    formaPagamentoCodigo = conecta.rs.getInt("CODIGO");
                } while (conecta.rs.next());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao consultar formas de pagamento cadastradas! \n ERRO: " + ex);
            }

            String categoria = "ORCAMENTO";

            //Busca a última planilha e número de documento para gerar o próximo:
            conecta.executaSql("SELECT PLANILHA "
                             + "FROM CONTASRECEBER "
                             + "WHERE OPERACAO = '2001' "
                             + "ORDER BY PLANILHA DESC LIMIT 1");

            try {
                if (conecta.rs.first()) {
                    planilha = (conecta.rs.getInt("PLANILHA")) + 1;
                    numeroDocumento = (Integer.parseInt(txtOrcamentoNumero.getText()));
                    numeroDocumentoFormatado = String.format("%09d", numeroDocumento);
                
                    for (int x = 0; x < tblPagamentos.getRowCount(); x++) {
                        String parcelaNumero = tblPagamentos.getValueAt(x, 0).toString();
                        String vencimento = tblPagamentos.getValueAt(x, 2).toString();
                        String parcelaValor = tblPagamentos.getValueAt(x, 3).toString().replace(" ", "");

                        PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONTASRECEBER (PLANILHA, OPERACAO, DATALANCAMENTO, DOCUMENTONUMERO, VALORTOTALFATURA, FORMAPAGAMENTO, "
                                                                                                      + "CATEGORIA, CLIENTECODIGO, PARCELANUMERO, DATAVENCIMENTO, VALORDUPLICATA, ACRESCIMOS, "
                                                                                                      + "DESCONTOS, TOTALRECEBER, DATARECEBIMENTO, ORCAMENTO, USUARIO) "
                                                                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                        pst.setInt(1, planilha);
                        pst.setString(2, operacao);
                        pst.setDate(3, new java.sql.Date(dataEmissao.getTime()));
                        pst.setString(4, numeroDocumentoFormatado);
                        pst.setBigDecimal(5, valorTotalFatura);
                        pst.setInt(6, formaPagamentoCodigo);
                        pst.setString(7, categoria);
                        pst.setInt(8, Integer.parseInt(txtClienteCodigo.getText()));
                        pst.setString(9, "ORC" + StringUtils.leftPad(parcelaNumero, 2, "0"));

                        SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                        String resultadoVencimentoParcela;
                        try {
                            resultadoVencimentoParcela = formatoBanco.format(formatoString.parse(vencimento));
                            pst.setDate(10, java.sql.Date.valueOf(resultadoVencimentoParcela));
                        } catch (ParseException ex) {
                            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        BigDecimal valorDuplicata = new BigDecimal(parcelaValor);
                        pst.setBigDecimal(11, valorDuplicata);
                        pst.setBigDecimal(12, new BigDecimal(BigInteger.ZERO));
                        pst.setBigDecimal(13, new BigDecimal(BigInteger.ZERO));
                        pst.setBigDecimal(14, valorDuplicata);
                        pst.setNull(15, 0);
                        pst.setInt(16, orcamentoNumero); 
                        pst.setString(17, System.getProperty("usuario"));

                        pst.execute();
                    }
                    
                    //Atualiza a situação do orçamento para Aprovado:
                    PreparedStatement pst2 = conecta.con.prepareStatement("UPDATE ORCAMENTOS "
                                                                        + "SET SITUACAO = 'APROVADO' "
                                                                        + "WHERE NUMERO = ?");

                    pst2.setInt(1, Integer.parseInt(txtOrcamentoNumero.getText()));
                    pst2.execute();

                    JOptionPane.showMessageDialog(null, "Orçamento aprovado com sucesso! \n"
                                                      + "Lançamento de contas a receber gerado com a duplicata "+numeroDocumentoFormatado+" .");

                    limpaCampos();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na aprovação do orçamento! \n ERRO: " + ex);
            }
            conecta.desconecta();
        }        
    }//GEN-LAST:event_btnAprovarOrcamentoActionPerformed

    private void txtValorTotalServicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalServicoFocusLost
        int quantidadeCompartimentos = Integer.parseInt(txtQuantidadeCompartimentos.getText());
        String sv = txtValorTotalServico.getText();        
        if (!txtValorTotalServico.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotal = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorTotalFormatado = nf.format(valorTotal);
            
            if (txtValorUnitarioServico.getText().contains("0,00")) {
                BigDecimal valorUnitarioServico = valorTotal.divide(new BigDecimal(quantidadeCompartimentos));
                String valorUnitarioFormatado = nf.format(valorUnitarioServico);
                txtValorUnitarioServico.setText(valorUnitarioFormatado);        
            }            
            txtValorTotalServico.setText(valorTotalFormatado);
        }         
        btnIncluirServico.requestFocus();
    }//GEN-LAST:event_txtValorTotalServicoFocusLost

    private void txtValorTotalServicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalServicoKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalServicoKeyTyped

    private void tblPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPecasMouseClicked
        int index = tblPecas.getSelectedRow();
        TableModel model = tblPecas.getModel();

        String pecaDescricao = model.getValueAt(index, 0).toString();
        String quantidade = model.getValueAt(index, 1).toString();
        String valorUnitarioPeca = model.getValueAt(index, 2).toString();
        String valorTotalPeca = model.getValueAt(index, 3).toString();
        String pecaCodigo = model.getValueAt(index, 4).toString();

        txtCodigoPeca.setText(pecaCodigo);
        txtDescricaoPeca.setText(pecaDescricao);
        txtQuantidadePeca.setText(quantidade);
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        BigDecimal valorUnitario = new BigDecimal(valorUnitarioPeca);
        String valorUnitarioPecaFormatado = nf.format(valorUnitario);
        txtValorUnitarioPeca.setText(valorUnitarioPecaFormatado);
        
        BigDecimal valorTotal = new BigDecimal(valorTotalPeca);
        String valorTotalPecaFormatado = nf.format(valorTotal);
        txtValorTotalPeca.setText(valorTotalPecaFormatado);        
    }//GEN-LAST:event_tblPecasMouseClicked

    private void btnPesquisarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPecaActionPerformed
        if (!txtDescricaoPeca.getText().isEmpty()) {
            pesquisaProdutos = new PesquisaProdutos();
            pesquisaProdutos.setLocationRelativeTo(null);
            pesquisaProdutos.setVisible(true);
            pesquisaProdutos.setResizable(false);
            pesquisaProdutos.preencherTabela(null, null, null, null, this, "SELECT * FROM PRODUTOS WHERE DESCRICAO LIKE '%" + txtDescricaoPeca.getText().trim() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaProdutos = new PesquisaProdutos();
            pesquisaProdutos.setLocationRelativeTo(null);
            pesquisaProdutos.setVisible(true);
            pesquisaProdutos.preencherTabela(null, null, null, null, this, "SELECT * FROM PRODUTOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarPecaActionPerformed

    private void btnIncluirPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirPecaActionPerformed
        boolean lAlterandoPeca = false;
        int quantidade = 0;

        if (txtCodigoPeca.getText().isEmpty() || txtDescricaoPeca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a peça!");
            txtDescricaoPeca.requestFocus();
        } else if (txtQuantidadePeca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a quantidade da peça!");
        } else if (txtValorUnitarioPeca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe o valor da peça!");
            txtValorUnitarioPeca.requestFocus();
        } else {
            String pecaCodigo = txtCodigoPeca.getText();
            String pecaDescricao = txtDescricaoPeca.getText().trim();
            quantidade = Integer.parseInt(txtQuantidadePeca.getText());
            BigDecimal valorUnitarioPeca = new BigDecimal(txtValorUnitarioPeca.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
            BigDecimal valorTotalPeca = valorUnitarioPeca.multiply(new BigDecimal(quantidade));

            for (int x = 0; x < tblPecas.getRowCount(); x++) {
                if (tblPecas.getValueAt(x, 0).equals(txtDescricaoPeca.getText().trim())) {
                    lAlterandoPeca = true;
                }
            }
            if (lAlterandoPeca == false) {
                DefaultTableModel valores = (DefaultTableModel) tblPecas.getModel();
                valores.addRow(new Object[]{pecaDescricao, quantidade, valorUnitarioPeca, valorTotalPeca, pecaCodigo});

                tblPecas.getColumnModel().getColumn(4).setMaxWidth(0);
                tblPecas.getColumnModel().getColumn(4).setMinWidth(0);
            } else {
                if (tblPecas.getSelectedRow() != -1) {
                    tblPecas.setValueAt(txtDescricaoPeca.getText(), tblPecas.getSelectedRow(), 0);
                    tblPecas.setValueAt(txtQuantidadePeca.getText(), tblPecas.getSelectedRow(), 1);
                    tblPecas.setValueAt(txtValorUnitarioPeca.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), tblPecas.getSelectedRow(), 2);
                    tblPecas.setValueAt(valorTotalPeca, tblPecas.getSelectedRow(), 3);
                    tblPecas.setValueAt(txtCodigoPeca.getText(), tblPecas.getSelectedRow(), 4);
                }
            }            
            
            txtCodigoPeca.setText("");
            txtDescricaoPeca.setText("");
            txtQuantidadePeca.setText("");
            txtValorUnitarioPeca.setText("");
            txtValorTotalPeca.setText(""); 
            txtDescricaoPeca.requestFocus();
            calcularValorTotalPecas();
        }
    }//GEN-LAST:event_btnIncluirPecaActionPerformed

    private void btnRemoverPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPecaActionPerformed
        if (tblPecas.getSelectedRow() != -1) {
            ((DefaultTableModel) tblPecas.getModel()).removeRow(tblPecas.getSelectedRow());
            txtCodigoPeca.setText("");
            txtDescricaoPeca.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione a peça para eliminar!");
        }

        txtCodigoPeca.setText("");
        txtDescricaoPeca.setText("");
        txtQuantidadePeca.setText("");
        txtValorUnitarioPeca.setText("");
        txtValorTotalPeca.setText(""); 
        txtDescricaoPeca.requestFocus();
    }//GEN-LAST:event_btnRemoverPecaActionPerformed

    private void txtQuantidadePecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadePecaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadePecaKeyTyped

    private void txtValorUnitarioPecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorUnitarioPecaKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorUnitarioPecaKeyTyped

    private void txtValorTotalPecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalPecaKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalPecaKeyTyped

    private void txtQuantidadePecaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadePecaFocusLost
        if (txtQuantidadePeca.getText().isEmpty()) {
            txtQuantidadePeca.setText("1");
        }
    }//GEN-LAST:event_txtQuantidadePecaFocusLost

    private void txtValorUnitarioPecaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioPecaFocusGained
        txtValorUnitarioPeca.selectAll();
    }//GEN-LAST:event_txtValorUnitarioPecaFocusGained

    private void txtValorUnitarioPecaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorUnitarioPecaFocusLost
        int quantidade = Integer.parseInt(txtQuantidadePeca.getText());
        String valor = txtValorUnitarioPeca.getText();
        if (!txtValorUnitarioPeca.getText().isEmpty()) {
            BigDecimal valorUnitarioPeca = new BigDecimal(valor.replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorUnitarioPeca.setText(nf.format(valorUnitarioPeca));
            
            BigDecimal valorTotalPeca = valorUnitarioPeca.multiply(new BigDecimal(quantidade));
            String valorTotalFormatado = nf.format(valorTotalPeca);
            txtValorTotalPeca.setText(valorTotalFormatado);        
        } else {
            txtValorUnitarioPeca.setText("R$0,00");
        }
    }//GEN-LAST:event_txtValorUnitarioPecaFocusLost

    private void txtValorTotalPecasFechamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalPecasFechamentoFocusLost
        BigDecimal valorTotalPecas = new BigDecimal(txtValorTotalPecasFechamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
        if (!txtValorTotalPecasFechamento.getText().isEmpty()) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorTotalPecasFechamento.setText(nf.format(valorTotalPecas).replace("R$", ""));
        } else {
            txtValorTotalPecasFechamento.setText("R$0,00");
        }
    }//GEN-LAST:event_txtValorTotalPecasFechamentoFocusLost

    private void txtValorTotalPecasFechamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorTotalPecasFechamentoKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorTotalPecasFechamentoKeyTyped

    private void txtPercentualDescontoPecasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPercentualDescontoPecasKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPercentualDescontoPecasKeyTyped

    private void txtPercentualDescontoPecasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPercentualDescontoPecasFocusLost
        if (!txtPercentualDescontoPecas.getText().isEmpty()) {
            BigDecimal valorPecas = new BigDecimal(txtValorTotalPecasFechamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
            BigDecimal percentualDescontoPecas = new BigDecimal(txtPercentualDescontoPecas.getText()).divide(BigDecimal.valueOf(100));
            BigDecimal valorTotalPecas = new BigDecimal(BigInteger.ZERO);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            valorTotalPecas = percentualDescontoPecas.multiply(valorPecas); 
            txtValorDescontoPecas.setText(nf.format(valorTotalPecas).replace("R$", ""));
        } else {
            txtPercentualDescontoPecas.setText("0,00");
            txtValorDescontoPecas.setText("0,00");
            txtValorTotalOrcamento.setText("0,00");
        }
    }//GEN-LAST:event_txtPercentualDescontoPecasFocusLost

    private void txtValorDescontoPecasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorDescontoPecasFocusLost
        BigDecimal valorDescontosPecas = new BigDecimal(txtValorDescontoPecas.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."));
        if (!txtValorDescontoPecas.getText().isEmpty()) {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtValorDescontoPecas.setText(nf.format(valorDescontosPecas).replace("R$", ""));
        } else {
            txtValorDescontoPecas.setText("0,00");
        }
    }//GEN-LAST:event_txtValorDescontoPecasFocusLost

    private void txtValorDescontoPecasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDescontoPecasKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorDescontoPecasKeyTyped

    private void txtValorTotalPecaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalPecaFocusLost
        int quantidade = Integer.parseInt(txtQuantidadePeca.getText());
        String sv = txtValorTotalPeca.getText();        
        if (!txtValorTotalPeca.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valorTotal = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorTotalFormatado = nf.format(valorTotal);
            
            if (txtValorUnitarioPeca.getText().contains("0,00")) {
                BigDecimal valorUnitarioPeca = valorTotal.divide(new BigDecimal(quantidade));
                String valorUnitarioFormatado = nf.format(valorUnitarioPeca);
                txtValorUnitarioPeca.setText(valorUnitarioFormatado);        
            }
            
            txtValorTotalPeca.setText(valorTotalFormatado);
        }         
        btnIncluirPeca.requestFocus();
    }//GEN-LAST:event_txtValorTotalPecaFocusLost

    private void txtValorTotalPecasFechamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalPecasFechamentoFocusGained
        if (txtValorTotalPecas.getText().isEmpty()){
            txtValorTotalPecas.setText("0,00");
            txtValorTotalPecasFechamento.setText("0,00"); 
        }
    }//GEN-LAST:event_txtValorTotalPecasFechamentoFocusGained

    private void txtValorTotalServicosFechamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorTotalServicosFechamentoFocusGained
        if (txtValorTotalServicos.getText().isEmpty()){
            txtValorTotalServicos.setText("0,00");
            txtValorTotalServicosFechamento.setText("0,00"); 
        }
    }//GEN-LAST:event_txtValorTotalServicosFechamentoFocusGained

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimirOrcamento();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void popularComboFormasPagamento() {
        conecta.conexao();
        conecta.executaSql("SELECT CODIGO, DESCRICAO FROM FORMASPAGAMENTO ORDER BY DESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbFormaPagamento.addItem(conecta.rs.getString("DESCRICAO").trim());
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar formas de pagamento cadastradas! \n ERRO: " + ex);
        }
    }

    public void calcularValidadeOrcamento() {
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_MONTH, 7);
        String validadeOrcamento = sd.format(c.getTime());
        txtDataValidadeOrcamento.setText(validadeOrcamento);
    }

    public void limpaCampos() {
        txtOrcamentoNumero.setText(String.valueOf(String.format("%06d", dao.numeroOrcamento())));
        calcularValidadeOrcamento();
        txtVersaoOrcamento.setText("");
        txtClienteCodigo.setText("");
        txtClienteDescricao.setText("");
        txtCodigoServico.setText("");
        txtDescricaoServico.setText("");
        txtQuantidadeCompartimentos.setText("");
        txtValorUnitarioServico.setText("");
        txtValorTotalServicos.setText("");
        ((DefaultTableModel) tblServicos.getModel()).setRowCount(0);
        txtValorTotalServicosFechamento.setText("");
        txtPercentualDescontoServicos.setText(""); 
        txtValorDescontoServicos.setText("");
        txtCodigoPeca.setText("");
        txtDescricaoPeca.setText("");
        txtQuantidadePeca.setText("");
        txtValorUnitarioPeca.setText("");
        txtValorTotalPeca.setText("");
        txtValorTotalPecas.setText(""); 
        txtPercentualDescontoPecas.setText("");
        txtValorDescontoPecas.setText(""); 
        txtValorTotalPecasFechamento.setText("");
        ((DefaultTableModel) tblPecas.getModel()).setRowCount(0);
        txtValorTotalOrcamento.setText("");
        cmbFormaPagamento.setSelectedIndex(0);
        txtNumeroParcelas.setText("");
        txtParcelaNumero.setText(""); 
        txtParcelaPrazo.setText("");
        txtParcelaVencimento.setText(""); 
        txtParcelaValor.setText(""); 
        ((DefaultTableModel) tblPagamentos.getModel()).setRowCount(0);
        txtObservacoes.setText(""); 
        btnGravar.setEnabled(true);
        btnAprovarOrcamento.setEnabled(true);
        btnCancelarOrcamento.setEnabled(true); 
        
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orcamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnAdicionarParcela;
    public javax.swing.JButton btnAprovarOrcamento;
    public javax.swing.JButton btnCancelarOrcamento;
    private javax.swing.JButton btnExcluirParcela;
    public javax.swing.JButton btnGravar;
    private javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnIncluirPeca;
    public javax.swing.JButton btnIncluirServico;
    public javax.swing.JButton btnPesquisaCliente;
    public javax.swing.JButton btnPesquisaOrcamento;
    public javax.swing.JButton btnPesquisarPeca;
    public javax.swing.JButton btnPesquisarServico;
    public javax.swing.JButton btnRemoverPeca;
    public javax.swing.JButton btnRemoverServico;
    public javax.swing.JButton btnSair;
    public javax.swing.JComboBox cmbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable tblPagamentos;
    public javax.swing.JTable tblPecas;
    public javax.swing.JTable tblServicos;
    public javax.swing.JTextField txtClienteCodigo;
    public javax.swing.JTextField txtClienteDescricao;
    public javax.swing.JTextField txtCodigoPeca;
    public javax.swing.JTextField txtCodigoServico;
    public javax.swing.JFormattedTextField txtDataValidadeOrcamento;
    public javax.swing.JTextField txtDescricaoPeca;
    public javax.swing.JTextField txtDescricaoServico;
    public javax.swing.JTextField txtNumeroParcelas;
    public javax.swing.JTextPane txtObservacoes;
    public javax.swing.JTextField txtOrcamentoNumero;
    private javax.swing.JTextField txtParcelaNumero;
    private javax.swing.JTextField txtParcelaPrazo;
    private javax.swing.JTextField txtParcelaValor;
    private javax.swing.JFormattedTextField txtParcelaVencimento;
    public javax.swing.JTextField txtPercentualDescontoPecas;
    public javax.swing.JTextField txtPercentualDescontoServicos;
    public javax.swing.JTextField txtPesquisaOrcamento;
    public javax.swing.JTextField txtQuantidadeCompartimentos;
    public javax.swing.JTextField txtQuantidadePeca;
    public javax.swing.JTextField txtValorDescontoPecas;
    public javax.swing.JTextField txtValorDescontoServicos;
    public javax.swing.JTextField txtValorTotalOrcamento;
    public javax.swing.JTextField txtValorTotalPeca;
    public javax.swing.JTextField txtValorTotalPecas;
    public javax.swing.JTextField txtValorTotalPecasFechamento;
    private javax.swing.JTextField txtValorTotalServico;
    public javax.swing.JFormattedTextField txtValorTotalServicos;
    public javax.swing.JTextField txtValorTotalServicosFechamento;
    public javax.swing.JTextField txtValorUnitarioPeca;
    public javax.swing.JTextField txtValorUnitarioServico;
    public javax.swing.JTextField txtVersaoOrcamento;
    // End of variables declaration//GEN-END:variables
}
