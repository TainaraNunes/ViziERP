package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.BeansVeiculos;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoVeiculos;

public class CadastroVeiculos extends javax.swing.JFrame {

    BeansVeiculos vei = new BeansVeiculos();
    ConectaBD conecta = new ConectaBD();
    DaoVeiculos dao = new DaoVeiculos();
    PesquisaVeiculos pesquisaVeiculos = new PesquisaVeiculos();
    VeiculosOpcionais veiOpcionais = new VeiculosOpcionais();
    
    public int incluindo = 1;
    public int alterando = 0;
       
    public CadastroVeiculos() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/cadastroveiculos.png")).getImage());      
        txtPesquisaVeiculo.setDocument(new Teclas()); 
        txtPlaca.setDocument(new Teclas());
        txtModelo.setDocument(new Teclas());
        txtMotor.setDocument(new Teclas());
        txtChassi.setDocument(new Teclas());
        txtObservacoes.setDocument(new Teclas());
        txtOutrosOpcionais.setDocument(new Teclas());
        btnExcluir.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisaVeiculo = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCodigoVeiculo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JFormattedTextField();
        cmbMarca = new javax.swing.JComboBox();
        txtModelo = new javax.swing.JTextField();
        txtAnoFabricacao = new javax.swing.JTextField();
        txtAnoModelo = new javax.swing.JTextField();
        cmbCor = new javax.swing.JComboBox();
        cmbCombustivel = new javax.swing.JComboBox();
        txtMotor = new javax.swing.JTextField();
        txtRenavam = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        cmbTransmissao = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txtChassi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtObservacoes = new javax.swing.JTextField();
        txtKM = new javax.swing.JFormattedTextField();
        cbxEmEstoque = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txtDataCompra = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPrecoCompra = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbxArCondicionado = new javax.swing.JCheckBox();
        cbxAlarme = new javax.swing.JCheckBox();
        cbxComputadorBordo = new javax.swing.JCheckBox();
        cbxDirecaoHidraulica = new javax.swing.JCheckBox();
        cbxFreioABS = new javax.swing.JCheckBox();
        cbxAirBag = new javax.swing.JCheckBox();
        cbxVidrosEletricos = new javax.swing.JCheckBox();
        cbxFarolNeblina = new javax.swing.JCheckBox();
        cbxCDPlayer = new javax.swing.JCheckBox();
        cbxParabarroTraseiro = new javax.swing.JCheckBox();
        cbxRegulagemVolante = new javax.swing.JCheckBox();
        cbxAlarmeSonoroRe = new javax.swing.JCheckBox();
        cbxFarolMilha = new javax.swing.JCheckBox();
        txtOutrosOpcionais = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbxArQuente = new javax.swing.JCheckBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Veículos");
        setName("frmCadastroVeiculos"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnAbandonar.setText("Abandonar");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
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

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAbandonar, btnExcluir, btnGravar, btnSair});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnAbandonar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Pesquisar:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisar)
                    .addComponent(txtPesquisaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Código:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Placa:");

        jLabel5.setText("Marca:");

        jLabel6.setText("Ano Fab/Mod:");

        jLabel7.setText("Chassi:");

        jLabel8.setText("Renavam:");

        jLabel10.setText("Cor:");

        jLabel13.setText("Transmissão:");

        jLabel14.setText("Combustível:");

        jLabel15.setText("KM:");

        txtCodigoVeiculo.setEditable(false);

        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AGRALE", "CHEVROLET", "FIAT", "FORD", "HONDA", "HYUNDAI", "IVECO", "MERCEDES-BENZ", "MITSUBISHI", "NISSAN", "SCANIA", "TOYOTA", "VOLVO", "VOLKSWAGEN" }));

        txtAnoFabricacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoFabricacaoKeyTyped(evt);
            }
        });

        txtAnoModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnoModeloKeyTyped(evt);
            }
        });

        cmbCor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AMARELO", "AZUL", "BEGE", "BRANCO", "CINZA", "PRATA", "PRETO", "VERDE", "VERMELHO", " " }));

        cmbCombustivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIESEL", "FLEX", "GASOLINA", " " }));

        txtRenavam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRenavamKeyTyped(evt);
            }
        });

        jLabel17.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUTOMOVEL", "CAVALO", "CARRETA", "3/4 (CARGA)", "4X2 (TOCO)", "4X4", "6X2 (TRUCK)", "6X4", "8X2", " " }));

        cmbTransmissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AUTOMATICO", "MANUAL" }));

        jLabel9.setText("Motor:");

        txtChassi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtChassiKeyTyped(evt);
            }
        });

        jLabel11.setText("Observações:");

        txtKM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        txtKM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKMKeyTyped(evt);
            }
        });

        cbxEmEstoque.setText("Em estoque");
        cbxEmEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxEmEstoque.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel12.setText("Data da Compra:");

        try {
            txtDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataCompra.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel18.setText("Preço de Compra:");

        txtPrecoCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoCompraFocusLost(evt);
            }
        });
        txtPrecoCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoCompraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObservacoes))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCodigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxEmEstoque))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(txtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel18))
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbTipo, 0, 178, Short.MAX_VALUE)
                                            .addComponent(cmbTransmissao, 0, 124, Short.MAX_VALUE)
                                            .addComponent(cmbCor, 0, 187, Short.MAX_VALUE)
                                            .addComponent(cmbCombustivel, 0, 178, Short.MAX_VALUE)
                                            .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbCombustivel, cmbCor, cmbMarca, cmbTipo, cmbTransmissao});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodigoVeiculo, txtPlaca});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxEmEstoque)
                    .addComponent(txtCodigoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel17)
                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel14)
                            .addComponent(cmbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbTransmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Gerais", jPanel2);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbxArCondicionado.setText("Ar Condicionado");

        cbxAlarme.setText("Alarme");

        cbxComputadorBordo.setText("Computador de Bordo");
        cbxComputadorBordo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxComputadorBordoActionPerformed(evt);
            }
        });

        cbxDirecaoHidraulica.setText("Direção Hidráulica");

        cbxFreioABS.setText("Freio ABS");

        cbxAirBag.setText("Air Bag");

        cbxVidrosEletricos.setText("Vidros Elétricos");

        cbxFarolNeblina.setText("Farol de Neblina");

        cbxCDPlayer.setText("CD Player");

        cbxParabarroTraseiro.setText("Parabarro Traseiro");

        cbxRegulagemVolante.setText("Volante com Regulagem de Altura");

        cbxAlarmeSonoroRe.setText("Alarme Sonoro de Ré");

        cbxFarolMilha.setText("Farol de Milha");

        jLabel16.setText("Outros:");

        cbxArQuente.setText("Ar Quente");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxAirBag)
                            .addComponent(cbxAlarme)
                            .addComponent(cbxAlarmeSonoroRe)
                            .addComponent(cbxArCondicionado)
                            .addComponent(cbxCDPlayer)
                            .addComponent(cbxArQuente)
                            .addComponent(cbxComputadorBordo))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRegulagemVolante)
                            .addComponent(cbxVidrosEletricos)
                            .addComponent(cbxParabarroTraseiro)
                            .addComponent(cbxFreioABS)
                            .addComponent(cbxFarolNeblina)
                            .addComponent(cbxFarolMilha)
                            .addComponent(cbxDirecaoHidraulica))
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOutrosOpcionais)
                        .addGap(10, 10, 10))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxAirBag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbxAlarme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxAlarmeSonoroRe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxArCondicionado)
                                .addGap(69, 69, 69))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbxArQuente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxCDPlayer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxComputadorBordo))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbxDirecaoHidraulica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFarolMilha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFarolNeblina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFreioABS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxParabarroTraseiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxVidrosEletricos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxRegulagemVolante)))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtOutrosOpcionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Opcionais", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            vei.setCodigo(Integer.parseInt(txtCodigoVeiculo.getText()));
            dao.excluirVeiculo(vei);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a placa do veículo!");
            txtPlaca.requestFocus();
            return;
        } else if (txtPlaca.getText().length() != 7) {
            JOptionPane.showMessageDialog(null, "A placa deve conter 7 dígitos!");
            txtPlaca.requestFocus();
            return;        
        } else if (txtModelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o modelo do veículo!");
            txtModelo.requestFocus();
            return;        
        } else if (txtAnoFabricacao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o ano de fabricação do veículo!");
            txtAnoFabricacao.requestFocus();
            return;        
        } else if (txtAnoFabricacao.getText().length() != 4){
            JOptionPane.showMessageDialog(null, "Ano de fabricação deve conter 4 dígitos!"); 
            txtAnoFabricacao.requestFocus();
            return;            
        } else if (txtAnoModelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o ano de modelo do veículo!");
            txtAnoModelo.requestFocus();
            return;        
        } else if (txtAnoModelo.getText().length() != 4){
            JOptionPane.showMessageDialog(null, "Ano de modelo deve conter 4 dígitos!"); 
            txtAnoModelo.requestFocus();
            return;
        } else if (txtMotor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe a descrição do motor do veículo!");
            txtMotor.requestFocus();
            return;        
        } else if (!txtChassi.getText().isEmpty() && txtChassi.getText().length() > 17){
            JOptionPane.showMessageDialog(null, "O campo chassi deve conter até 17 caracteres!");
            txtChassi.requestFocus();
            return;        
        } else if (!txtRenavam.getText().isEmpty() && txtRenavam.getText().length() != 11){
            JOptionPane.showMessageDialog(null, "O campo renavam deve conter 11 dígitos!");
            txtRenavam.requestFocus();
            return;        
        } else if (txtPrecoCompra.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe o preço de compra do veículo!");
            txtPrecoCompra.requestFocus();
            return;
        }
        
        vei.setPlaca(txtPlaca.getText().trim());
        vei.setMarca(cmbMarca.getSelectedItem().toString().trim());
        vei.setModelo(txtModelo.getText().trim());
        vei.setTipo(cmbTipo.getSelectedItem().toString().trim());
        vei.setAnoFabricacao(txtAnoFabricacao.getText().trim());
        vei.setAnoModelo(txtAnoModelo.getText().trim());
        vei.setCor(cmbCor.getSelectedItem().toString().trim());
        vei.setMotor(txtMotor.getText().trim());
        vei.setCombustivel(cmbCombustivel.getSelectedItem().toString().trim());
        vei.setChassi(txtChassi.getText().trim());
        vei.setRenavam(txtRenavam.getText().trim());
        vei.setTransmissao(cmbTransmissao.getSelectedItem().toString().trim());
        if (!txtKM.getText().isEmpty()) {
            String km = txtKM.getText().replace(" ", "").replace(".", "").replace(",", ".");
            Double kmDouble = new Double(km);
            vei.setKm(kmDouble);
        } else {
            vei.setKm(0.00);
        }
        if (cbxEmEstoque.isSelected()){
            vei.setemEstoque(1);
        } else {
            vei.setemEstoque(0);
        }
        vei.setObservacoes(txtObservacoes.getText().trim());

        if (txtDataCompra.getText().trim().length() == 10) {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataCompra = LocalDate.parse(txtDataCompra.getText(), formato);
            vei.setDataCompra(dataCompra);
        } else {
            vei.setDataCompra(null);
        }
        
        String precoCompra = txtPrecoCompra.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        BigDecimal valorPrecoCompra = new BigDecimal(precoCompra);
        vei.setPrecoCompra(valorPrecoCompra);

        //Opcionais:
        if (cbxAirBag.isSelected()){
            vei.setOpcionalAirBag(1);
        } else {
            vei.setOpcionalAirBag(0);
        }       
        
        if (cbxAlarme.isSelected()){
            vei.setOpcionalAlarme(1);
        } else {
            vei.setOpcionalAlarme(0);
        }

        if (cbxAlarmeSonoroRe.isSelected()){
            vei.setOpcionalAlarmeSonoroRe(1);
        } else {
            vei.setOpcionalAlarmeSonoroRe(0);
        }

        if (cbxArCondicionado.isSelected()){
            vei.setOpcionalArCondicionado(1);
        } else {
            vei.setOpcionalArCondicionado(0);
        }

        if (cbxArQuente.isSelected()){
            vei.setOpcionalArQuente(1);
        } else {
            vei.setOpcionalArQuente(0);
        }
        
        if (cbxCDPlayer.isSelected()){
            vei.setOpcionalCDPlayer(1);
        } else {
            vei.setOpcionalCDPlayer(0);
        }

        if (cbxComputadorBordo.isSelected()){
            vei.setOpcionalComputadorBordo(1);
        } else {
            vei.setOpcionalComputadorBordo(0);
        }

        if (cbxDirecaoHidraulica.isSelected()){
            vei.setOpcionalDirecaoHidraulica(1);
        } else {
            vei.setOpcionalDirecaoHidraulica(0);
        }
        
        if (cbxFarolMilha.isSelected()){
            vei.setOpcionalFarolMilha(1);
        } else {
            vei.setOpcionalFarolMilha(0);
        }
        
        if (cbxFarolNeblina.isSelected()){
            vei.setOpcionalFarolNeblina(1);
        } else {
            vei.setOpcionalFarolNeblina(0);
        }
        
        if (cbxFreioABS.isSelected()){
            vei.setOpcionalFreioABS(1);
        } else {
            vei.setOpcionalFreioABS(0);
        }        

        if (cbxParabarroTraseiro.isSelected()){
            vei.setOpcionalParabarroTraseiro(1);
        } else {
            vei.setOpcionalParabarroTraseiro(0);
        }        
        
        if (cbxRegulagemVolante.isSelected()){
            vei.setOpcionalRegulagemVoltante(1);
        } else {
            vei.setOpcionalRegulagemVoltante(0);
        }        
        
        if (cbxVidrosEletricos.isSelected()){
            vei.setOpcionalVidrosEletricos(1);
        } else {
            vei.setOpcionalVidrosEletricos(0);
        }               
        
        if (!txtOutrosOpcionais.getText().isEmpty()){
            vei.setOutrosOpcionais(txtOutrosOpcionais.getText().trim()); 
        } else {
            vei.setOutrosOpcionais(""); 
        }
        
        if (incluindo == 1) {
            if (validarVeiculoCadastrado() == false){
                dao.gravarVeiculo(vei); 
                limpaCampos();
            }
        } else if (alterando == 1) {
            vei.setCodigo(Integer.parseInt(txtCodigoVeiculo.getText()));                  
            dao.alterarVeiculo(vei);
            limpaCampos();
        }               
    }//GEN-LAST:event_btnGravarActionPerformed

    public boolean validarVeiculoCadastrado(){
        boolean veiculoCadastrado = false;
        String placa = txtPlaca.getText().trim();
        String modelo = txtModelo.getText().trim();
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM VEICULOS WHERE PLACA = '" + placa + "'");
        try {
            if (conecta.rs.first()) {
                veiculoCadastrado = true;
                JOptionPane.showMessageDialog(null, "Placa já cadastrada para o veículo " + conecta.rs.getString("MODELO").trim() + "!");
                txtPlaca.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }   

        //Deve permitir modelo igual pois existem modelos de anos diferentes:
        /*conecta.executaSql("SELECT * FROM VEICULOS WHERE MODELO = '" + modelo + "'");
        try {
            if (conecta.rs.first()) {
                veiculoCadastrado = true;
                JOptionPane.showMessageDialog(null, "Modelo de veículo já cadastrado com a placa " + conecta.rs.getString("PLACA").trim() + "!");
                txtModelo.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        } */  
        
        return veiculoCadastrado;
    }
    
    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtPesquisaVeiculo.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void txtAnoFabricacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoFabricacaoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnoFabricacaoKeyTyped

    private void txtAnoModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnoModeloKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAnoModeloKeyTyped

    private void txtRenavamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRenavamKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRenavamKeyTyped

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        limpaCampos();
        if (!txtPesquisaVeiculo.getText().isEmpty()) { //Se o campo de procura tiver conteúdo;
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.setResizable(false);
            pesquisaVeiculos.preencherTabela(this, "SELECT * "
                                                 + "FROM VEICULOS "
                                                 + "WHERE PLACA LIKE '%" + txtPesquisaVeiculo.getText().trim() + "%' OR "
                                                 + "MODELO LIKE '%" +txtPesquisaVeiculo.getText().trim() + "%' ORDER BY MODELO");
        } else {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS ORDER BY MODELO");
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtChassiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChassiKeyTyped
        String caracteres = "0987654321QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtChassiKeyTyped

    private void txtKMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKMKeyTyped
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtKMKeyTyped

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        String caracteres = "0987654321QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPlacaKeyTyped

    private void cbxComputadorBordoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxComputadorBordoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxComputadorBordoActionPerformed

    private void txtPrecoCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoCompraFocusLost
        String sv = txtPrecoCompra.getText();
        if (!txtPrecoCompra.getText().isEmpty()) {
            String vsf = sv.replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            BigDecimal valor = new BigDecimal(vsf);
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String valorFormatado = nf.format(valor);
            txtPrecoCompra.setText(valorFormatado);
        } else {
            txtPrecoCompra.setText("0,00"); 
            txtPrecoCompra.requestFocus();
        }
    }//GEN-LAST:event_txtPrecoCompraFocusLost

    private void txtPrecoCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoCompraKeyTyped
        String caracteres = "0987654321,";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecoCompraKeyTyped

    public void limpaCampos() {
        txtCodigoVeiculo.setText("");
        txtPlaca.setText("");
        txtModelo.setText("");
        txtAnoFabricacao.setText("");
        txtAnoModelo.setText("");
        txtMotor.setText("");
        txtChassi.setText("");
        txtRenavam.setText("");
        txtKM.setText("");
        cbxEmEstoque.setSelected(false);
        txtObservacoes.setText("");
        cmbCombustivel.setSelectedIndex(0);
        cmbCor.setSelectedIndex(0);
        cmbMarca.setSelectedIndex(0);
        cmbTipo.setSelectedIndex(0);
        cmbTransmissao.setSelectedIndex(0);
        cbxAirBag.setSelected(false);
        cbxAlarme.setSelected(false);
        cbxAlarmeSonoroRe.setSelected(false);
        cbxArCondicionado.setSelected(false);
        cbxCDPlayer.setSelected(false);
        cbxComputadorBordo.setSelected(false);
        cbxDirecaoHidraulica.setSelected(false);
        cbxFarolMilha.setSelected(false);
        cbxFarolNeblina.setSelected(false);
        cbxFreioABS.setSelected(false);
        cbxParabarroTraseiro.setSelected(false);
        cbxRegulagemVolante.setSelected(false);
        cbxVidrosEletricos.setSelected(false); 
        txtOutrosOpcionais.setText(""); 
        jTabbedPane1.setSelectedIndex(0);
        txtDataCompra.setText(""); 
        txtPrecoCompra.setText(""); 
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    public javax.swing.JButton btnPesquisar;
    public javax.swing.JButton btnSair;
    public javax.swing.JCheckBox cbxAirBag;
    public javax.swing.JCheckBox cbxAlarme;
    public javax.swing.JCheckBox cbxAlarmeSonoroRe;
    public javax.swing.JCheckBox cbxArCondicionado;
    private javax.swing.JCheckBox cbxArQuente;
    public javax.swing.JCheckBox cbxCDPlayer;
    public javax.swing.JCheckBox cbxComputadorBordo;
    public javax.swing.JCheckBox cbxDirecaoHidraulica;
    public javax.swing.JCheckBox cbxEmEstoque;
    public javax.swing.JCheckBox cbxFarolMilha;
    public javax.swing.JCheckBox cbxFarolNeblina;
    public javax.swing.JCheckBox cbxFreioABS;
    public javax.swing.JCheckBox cbxParabarroTraseiro;
    public javax.swing.JCheckBox cbxRegulagemVolante;
    public javax.swing.JCheckBox cbxVidrosEletricos;
    public javax.swing.JComboBox cmbCombustivel;
    public javax.swing.JComboBox cmbCor;
    public javax.swing.JComboBox cmbMarca;
    public javax.swing.JComboBox cmbTipo;
    public javax.swing.JComboBox cmbTransmissao;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField txtAnoFabricacao;
    public javax.swing.JTextField txtAnoModelo;
    public javax.swing.JTextField txtChassi;
    public javax.swing.JTextField txtCodigoVeiculo;
    public javax.swing.JFormattedTextField txtDataCompra;
    public javax.swing.JFormattedTextField txtKM;
    public javax.swing.JTextField txtModelo;
    public javax.swing.JTextField txtMotor;
    public javax.swing.JTextField txtObservacoes;
    public javax.swing.JTextField txtOutrosOpcionais;
    public javax.swing.JTextField txtPesquisaVeiculo;
    public javax.swing.JFormattedTextField txtPlaca;
    public javax.swing.JTextField txtPrecoCompra;
    public javax.swing.JTextField txtRenavam;
    // End of variables declaration//GEN-END:variables
}
