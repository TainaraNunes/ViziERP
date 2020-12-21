package ERP.view;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.BeansCustosVeiculos;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoCustosVeiculos;

public class CustosVeiculos extends javax.swing.JFrame {

    BeansCustosVeiculos custos = new BeansCustosVeiculos();
    ConectaBD conecta = new ConectaBD();
    DaoCustosVeiculos dao = new DaoCustosVeiculos();
    PesquisaVeiculos pesquisaVeiculos = new PesquisaVeiculos();

    public int incluindo = 1;
    public int alterando = 0;
    
    public int veiculoCodigo = 0;
    public String dataCompra = null;
    public String dataVenda = null;
    public BigDecimal precoCompra = BigDecimal.ZERO;
    public BigDecimal precoVenda = BigDecimal.ZERO;      
    public BigDecimal custoBateria = BigDecimal.ZERO;
    public BigDecimal custoCarroceria = BigDecimal.ZERO;
    public BigDecimal custoCombustivel = BigDecimal.ZERO;
    public BigDecimal custoDespachante = BigDecimal.ZERO;
    public BigDecimal custoEletrica = BigDecimal.ZERO;
    public BigDecimal custoImpostos = BigDecimal.ZERO;
    public BigDecimal custoLatariaPintura = BigDecimal.ZERO;            
    public BigDecimal custoLimpeza = BigDecimal.ZERO;
    public BigDecimal custoMecanica = BigDecimal.ZERO;            
    public BigDecimal custoMultas = BigDecimal.ZERO;
    public BigDecimal custoPecasAcessorios = BigDecimal.ZERO;
    public BigDecimal custoPneus = BigDecimal.ZERO;            
    public BigDecimal custoRecapagem = BigDecimal.ZERO;
    public BigDecimal custoTapecaria = BigDecimal.ZERO;
    public BigDecimal custoTornearia = BigDecimal.ZERO;
    public BigDecimal custoOutros = BigDecimal.ZERO;
    public BigDecimal totalDespesas = BigDecimal.ZERO;
    public BigDecimal totalCusto = BigDecimal.ZERO;
    public BigDecimal margemLucroValor = BigDecimal.ZERO;        
    
    public CustosVeiculos() {
        initComponents();
        txtVeiculoPlaca.setDocument(new Teclas());
        txtVeiculoModelo.setDocument(new Teclas());
        
        btnExcluir.setEnabled(false); 
        btnAtualizarCustos.setEnabled(false); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtVeiculoModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtVeiculoPlaca = new javax.swing.JTextField();
        btnPesqusiarVeiculo = new javax.swing.JButton();
        txtDataCompra = new javax.swing.JFormattedTextField();
        txtDataVenda = new javax.swing.JFormattedTextField();
        txtPrecoVenda = new javax.swing.JFormattedTextField();
        txtPrecoCompra = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtTotalCusto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtMargemLucroPercentual = new javax.swing.JTextField();
        txtCustoLimpeza = new javax.swing.JFormattedTextField();
        txtCustoDespachante = new javax.swing.JFormattedTextField();
        txtCustoMecanica = new javax.swing.JFormattedTextField();
        txtCustoImpostos = new javax.swing.JFormattedTextField();
        txtCustoPecasAcessorios = new javax.swing.JFormattedTextField();
        txtCustoLatariaPintura = new javax.swing.JFormattedTextField();
        txtCustoPneus = new javax.swing.JFormattedTextField();
        txtCustoCombustivel = new javax.swing.JFormattedTextField();
        txtTotalDespesas = new javax.swing.JFormattedTextField();
        txtMargemLucroValor = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCustoBateria = new javax.swing.JTextField();
        txtCustoCarroceria = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCustoEletrica = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCustoMultas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCustoRecapagem = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtCustoTapecaria = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCustoTornearia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCustoOutros = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGravarCustos = new javax.swing.JButton();
        btnAtualizarCustos = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Custos de Veículos");
        setName("frmCustosVeiculos"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Veículo"));

        jLabel1.setText("Veículo:");

        jLabel2.setText("Data da Compra:");

        jLabel3.setText("Preço de Compra:");

        jLabel4.setText("Data da Venda:");

        jLabel5.setText("Preço de Venda:");

        btnPesqusiarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesqusiarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqusiarVeiculoActionPerformed(evt);
            }
        });

        try {
            txtDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtPrecoVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecoVendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoVendaFocusLost(evt);
            }
        });

        txtPrecoCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtPrecoCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecoCompraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoCompraFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVeiculoPlaca)
                                    .addComponent(txtDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesqusiarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPesqusiarVeiculo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVeiculoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Despesas"));

        jLabel6.setText("Combustível:");

        jLabel7.setText("Despachante:");

        jLabel8.setText("Impostos:");

        jLabel9.setText("Lataria e Pintura:");

        jLabel10.setText("Limpeza:");

        jLabel11.setText("Mecânica:");

        jLabel12.setText("Peças e Acessórios:");

        jLabel13.setText("Pneus:");

        jLabel14.setText("Total de Despesas:");

        jLabel15.setText("Margem de Lucro:");

        jLabel16.setText("Custo Total:");

        txtTotalCusto.setEditable(false);

        jLabel17.setText("%");

        txtMargemLucroPercentual.setEditable(false);

        txtCustoLimpeza.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoLimpeza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoLimpezaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoLimpezaFocusLost(evt);
            }
        });

        txtCustoDespachante.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoDespachante.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoDespachanteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoDespachanteFocusLost(evt);
            }
        });

        txtCustoMecanica.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoMecanica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoMecanicaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoMecanicaFocusLost(evt);
            }
        });

        txtCustoImpostos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoImpostos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoImpostosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoImpostosFocusLost(evt);
            }
        });

        txtCustoPecasAcessorios.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoPecasAcessorios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoPecasAcessoriosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoPecasAcessoriosFocusLost(evt);
            }
        });

        txtCustoLatariaPintura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoLatariaPintura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoLatariaPinturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoLatariaPinturaFocusLost(evt);
            }
        });

        txtCustoPneus.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoPneus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoPneusFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoPneusFocusLost(evt);
            }
        });

        txtCustoCombustivel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));
        txtCustoCombustivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoCombustivelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoCombustivelFocusLost(evt);
            }
        });

        txtTotalDespesas.setEditable(false);
        txtTotalDespesas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        txtMargemLucroValor.setEditable(false);
        txtMargemLucroValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        jLabel18.setText("Bateria:");

        jLabel19.setText("Carroceria:");

        txtCustoBateria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoBateriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoBateriaFocusLost(evt);
            }
        });

        txtCustoCarroceria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoCarroceriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoCarroceriaFocusLost(evt);
            }
        });

        jLabel20.setText("Elétrica:");

        txtCustoEletrica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoEletricaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoEletricaFocusLost(evt);
            }
        });

        jLabel21.setText("Multas:");

        txtCustoMultas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoMultasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoMultasFocusLost(evt);
            }
        });

        jLabel22.setText("Recapagem:");

        txtCustoRecapagem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoRecapagemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoRecapagemFocusLost(evt);
            }
        });

        jLabel23.setText("Tapeçaria:");

        txtCustoTapecaria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoTapecariaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoTapecariaFocusLost(evt);
            }
        });

        jLabel24.setText("Tornearia:");

        txtCustoTornearia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoTorneariaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoTorneariaFocusLost(evt);
            }
        });

        jLabel25.setText("Outros:");

        txtCustoOutros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustoOutrosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustoOutrosFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCustoCombustivel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustoEletrica, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(txtCustoLatariaPintura)
                            .addComponent(txtCustoMecanica)
                            .addComponent(txtCustoPecasAcessorios)
                            .addComponent(txtCustoRecapagem)
                            .addComponent(txtCustoTornearia)
                            .addComponent(txtCustoBateria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCustoDespachante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustoImpostos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustoLimpeza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCustoPneus, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtCustoCarroceria, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtCustoMultas, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtCustoTapecaria, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(txtCustoOutros)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMargemLucroValor)
                            .addComponent(txtTotalDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalCusto, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtMargemLucroPercentual))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMargemLucroValor, txtTotalDespesas});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCustoCarroceria, txtCustoDespachante, txtCustoEletrica, txtCustoImpostos, txtCustoLatariaPintura, txtCustoLimpeza, txtCustoMecanica, txtCustoMultas, txtCustoPecasAcessorios, txtCustoPneus, txtCustoRecapagem, txtCustoTapecaria, txtCustoTornearia});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(txtCustoBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustoCarroceria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txtCustoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtCustoDespachante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel20)
                            .addComponent(txtCustoEletrica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtCustoImpostos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel9)
                            .addComponent(txtCustoLatariaPintura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtCustoLimpeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCustoMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCustoMecanica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCustoPecasAcessorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustoPneus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtCustoRecapagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtCustoTapecaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtCustoTornearia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtCustoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(txtTotalCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(txtMargemLucroPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMargemLucroValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravarCustos.setText("Gravar");
        btnGravarCustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarCustosActionPerformed(evt);
            }
        });

        btnAtualizarCustos.setText("Atualizar");
        btnAtualizarCustos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCustosActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravarCustos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarCustos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAbandonar, btnAtualizarCustos, btnExcluir, btnGravarCustos, btnSair});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravarCustos)
                    .addComponent(btnAtualizarCustos)
                    .addComponent(btnSair)
                    .addComponent(btnAbandonar)
                    .addComponent(btnExcluir))
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
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnGravarCustosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarCustosActionPerformed
        if (txtVeiculoPlaca.getText().isEmpty() || txtVeiculoModelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione o veículo para lançar os custos!");
            txtVeiculoPlaca.requestFocus();
            return;
        } else if (txtPrecoCompra.getText().isEmpty() || txtPrecoCompra.getText().equals("0,00")){
            JOptionPane.showMessageDialog(null, "Informe o preço da compra para calcular o custo total!");
            txtPrecoCompra.requestFocus();
            return;
        } else {
            custos.setVeiculoCodigo(veiculoCodigo);
             
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (txtDataCompra.getText().trim().length() < 10){
                custos.setDataCompra(null);
            } else {                
                LocalDate dataCompra = LocalDate.parse(txtDataCompra.getText(), formato);
                custos.setDataCompra(dataCompra);
            }
            
            if (txtDataVenda.getText().trim().length() < 10){
                custos.setDataVenda(null);
            } else {
                LocalDate dataVenda = LocalDate.parse(txtDataVenda.getText(), formato);
                custos.setDataVenda(dataVenda);                
            }

            if (!txtPrecoCompra.getText().isEmpty()){
                String sPrecoCompra = txtPrecoCompra.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setPrecoCompra(new BigDecimal(sPrecoCompra));
            } else {
                custos.setPrecoCompra(BigDecimal.ZERO);
            }

            if (!txtPrecoVenda.getText().isEmpty()){
                String sPrecoVenda = txtPrecoVenda.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setPrecoVenda(new BigDecimal(sPrecoVenda));
            } else {
                custos.setPrecoVenda(BigDecimal.ZERO);
            }

            if (!txtCustoBateria.getText().isEmpty()){
                String sCustoBateria = txtCustoBateria.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosBateria(new BigDecimal(sCustoBateria));
            } else {
                custos.setCustosBateria(BigDecimal.ZERO);
            }
                        
            if (!txtCustoCarroceria.getText().isEmpty()){
                String sCustoCarroceria = txtCustoCarroceria.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosCarroceria(new BigDecimal(sCustoCarroceria));
            } else {
                custos.setCustosCarroceria(BigDecimal.ZERO);
            }
            
            if (!txtCustoCombustivel.getText().isEmpty()){
                String sCustoCombustivel = txtCustoCombustivel.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosCombustivel(new BigDecimal(sCustoCombustivel));
            } else {
                custos.setCustosCombustivel(BigDecimal.ZERO);
            }

            if (!txtCustoDespachante.getText().isEmpty()){
                String sCustoDespachante = txtCustoDespachante.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosDespachante(new BigDecimal(sCustoDespachante));
            } else {
                custos.setCustosDespachante(BigDecimal.ZERO);
            }
            
            if (!txtCustoEletrica.getText().isEmpty()){
                String sCustoEletrica = txtCustoEletrica.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosEletrica(new BigDecimal(sCustoEletrica));
            } else {
                custos.setCustosEletrica(BigDecimal.ZERO);
            }
            
            if (!txtCustoImpostos.getText().isEmpty()){
                String sCustoImpostos = txtCustoImpostos.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosImpostos(new BigDecimal(sCustoImpostos));
            } else {
                custos.setCustosImpostos(BigDecimal.ZERO);
            }           
            
            if (!txtCustoLatariaPintura.getText().isEmpty()){
                String sCustoLataria = txtCustoLatariaPintura.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosLatariaPintura(new BigDecimal(sCustoLataria));
            } else {
                custos.setCustosLatariaPintura(BigDecimal.ZERO);
            }                       
           
            if (!txtCustoLimpeza.getText().isEmpty()){
                String sCustoLimpeza = txtCustoLimpeza.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosLimpeza(new BigDecimal(sCustoLimpeza));
            } else {
                custos.setCustosLimpeza(BigDecimal.ZERO);
            }               
            
            if (!txtCustoMecanica.getText().isEmpty()){
                String sCustoMecanica = txtCustoMecanica.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosMecanica(new BigDecimal(sCustoMecanica));
            } else {
                custos.setCustosMecanica(BigDecimal.ZERO);
            }               
            
            if (!txtCustoMultas.getText().isEmpty()){
                String sCustoMultas = txtCustoMultas.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosMultas(new BigDecimal(sCustoMultas));
            } else {
                custos.setCustosMultas(BigDecimal.ZERO);
            }       
            
            if (!txtCustoPecasAcessorios.getText().isEmpty()){
                String sCustoPecas = txtCustoPecasAcessorios.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosPecasAcessorios(new BigDecimal(sCustoPecas));
            } else {
                custos.setCustosPecasAcessorios(BigDecimal.ZERO);
            }       
            
            if (!txtCustoPneus.getText().isEmpty()){
                String sCustoPneus = txtCustoPneus.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosPneus(new BigDecimal(sCustoPneus));
            } else {
                custos.setCustosPneus(BigDecimal.ZERO);
            }                          

            if (!txtCustoRecapagem.getText().isEmpty()){
                String sCustoRecapagem = txtCustoPneus.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosRecapagem(new BigDecimal(sCustoRecapagem));
            } else {
                custos.setCustosRecapagem(BigDecimal.ZERO);
            }    

            if (!txtCustoTapecaria.getText().isEmpty()){
                String sCustoTapecaria = txtCustoPneus.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosTapecaria(new BigDecimal(sCustoTapecaria));
            } else {
                custos.setCustosTapecaria(BigDecimal.ZERO);
            }    
            
            if (!txtCustoTornearia.getText().isEmpty()){
                String sCustoTornearia = txtCustoPneus.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosTornearia(new BigDecimal(sCustoTornearia));
            } else {
                custos.setCustosTornearia(BigDecimal.ZERO);
            }                

            if (!txtCustoOutros.getText().isEmpty()){
                String sCustoOutros = txtCustoPneus.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setCustosOutros(new BigDecimal(sCustoOutros));
            } else {
                custos.setCustosOutros(BigDecimal.ZERO);
            }    
                        
            if (!txtTotalDespesas.getText().isEmpty()){
                String sTotalDespesas = txtTotalDespesas.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setTotalDespesas(new BigDecimal(sTotalDespesas));
            } else {
                custos.setTotalDespesas(BigDecimal.ZERO);
            }                

            if (!txtTotalCusto.getText().isEmpty()){
                String sCustoTotal = txtTotalCusto.getText().replace(" ", "").replace(".", "").replace(",", ".");
                totalCusto = new BigDecimal(sCustoTotal);
            } else {
                totalCusto = BigDecimal.ZERO;
            }       
            
            if (!txtMargemLucroValor.getText().isEmpty()){
                String sMargemLucro = txtMargemLucroValor.getText().replace(" ", "").replace(".", "").replace(",", ".");
                custos.setMargemLucroValor(new BigDecimal(sMargemLucro));       
            } else {
                custos.setMargemLucroValor(BigDecimal.ZERO);
            }                  
        }
        
        if (incluindo == 1){
            dao.gravarCustosVeiculo(custos); 
            limpaCampos();
        } else {
            custos.setVeiculoCodigo(veiculoCodigo); 
            dao.alterarCustosVeiculo(custos);
            limpaCampos();
        }            
    }//GEN-LAST:event_btnGravarCustosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAtualizarCustosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCustosActionPerformed
        veiculoCodigo    = 0;
        dataCompra       = null;
        dataVenda        = null;
        precoCompra      = BigDecimal.ZERO;
        precoVenda       = BigDecimal.ZERO;      
        custoBateria     = BigDecimal.ZERO;
        custoCarroceria  = BigDecimal.ZERO;
        custoCombustivel = BigDecimal.ZERO;
        custoDespachante = BigDecimal.ZERO;
        custoEletrica    = BigDecimal.ZERO;
        custoImpostos    = BigDecimal.ZERO;
        custoLatariaPintura = BigDecimal.ZERO;            
        custoLimpeza     = BigDecimal.ZERO;
        custoMecanica    = BigDecimal.ZERO;            
        custoMultas      = BigDecimal.ZERO;
        custoPecasAcessorios = BigDecimal.ZERO;
        custoPneus       = BigDecimal.ZERO;            
        custoRecapagem   = BigDecimal.ZERO;
        custoTapecaria   = BigDecimal.ZERO;
        custoTornearia   = BigDecimal.ZERO;
        custoOutros      = BigDecimal.ZERO;
        totalDespesas    = BigDecimal.ZERO;
        totalCusto       = BigDecimal.ZERO;
        margemLucroValor = BigDecimal.ZERO;      

        consultarDespesasVeiculos();

        txtDataCompra.setText(dataCompra);
        txtDataVenda.setText(dataVenda);
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        txtCustoBateria.setText(nf.format(custoBateria).replace("R$ ", ""));
        txtCustoCarroceria.setText(nf.format(custoCarroceria).replace("R$ ", ""));
        txtCustoCombustivel.setText(nf.format(custoCombustivel).replace("R$ ", ""));
        txtCustoDespachante.setText(nf.format(custoDespachante).replace("R$ ", ""));                         
        txtCustoEletrica.setText(nf.format(custoEletrica).replace("R$ ", ""));        
        txtCustoImpostos.setText(nf.format(custoImpostos).replace("R$ ", "")); 
        txtCustoLatariaPintura.setText(nf.format(custoLatariaPintura).replace("R$ ", ""));
        txtCustoLimpeza.setText(nf.format(custoLimpeza).replace("R$ ", ""));
        txtCustoMecanica.setText(nf.format(custoMecanica).replace("R$ ", ""));    
        txtCustoMultas.setText(nf.format(custoMultas).replace("R$ ", ""));
        txtCustoPecasAcessorios.setText(nf.format(custoPecasAcessorios).replace("R$ ", ""));
        txtCustoPneus.setText(nf.format(custoPneus).replace("R$ ", "")); 
        txtCustoRecapagem.setText(nf.format(custoRecapagem).replace("R$ ", ""));
        txtCustoTapecaria.setText(nf.format(custoTapecaria).replace("R$ ", ""));
        txtCustoTornearia.setText(nf.format(custoTornearia).replace("R$ ", ""));
        txtCustoOutros.setText(nf.format(custoOutros).replace("R$ ", ""));
        txtTotalDespesas.setText(nf.format(totalDespesas).replace("R$ ", ""));
        txtTotalCusto.setText(nf.format(totalCusto).replace("R$ ", ""));
        txtMargemLucroValor.setText(nf.format(margemLucroValor).replace("R$ ", ""));
  
        incluindo = 0;
        alterando = 1;
        
        calcularCustoTotal();    
    }//GEN-LAST:event_btnAtualizarCustosActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtVeiculoPlaca.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente eliminar a relação de custos do veículo?");
        if (resposta == JOptionPane.YES_OPTION) {
            custos.setVeiculoCodigo(veiculoCodigo);
            dao.excluirCustosVeiculo(custos);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtPrecoVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoVendaFocusGained
        txtPrecoVenda.selectAll();
    }//GEN-LAST:event_txtPrecoVendaFocusGained

    private void txtPrecoVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoVendaFocusLost
        if (!txtPrecoVenda.getText().isEmpty() && !txtPrecoVenda.getText().equals("0,00")){
            String sPrecoVenda = txtPrecoVenda.getText().replace(" ", "").replace(".", "").replace(",", ".");
            precoVenda = new BigDecimal(sPrecoVenda);
        } else {
            precoVenda = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtPrecoVendaFocusLost

    private void txtPrecoCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoCompraFocusLost
        if (!txtPrecoCompra.getText().isEmpty() && !txtPrecoCompra.getText().equals("0,00")){
            String sPrecoCompra = txtPrecoCompra.getText().replace(" ", "").replace(".", "").replace(",", ".");
            precoCompra = new BigDecimal(sPrecoCompra);
        } else {
            precoCompra = BigDecimal.ZERO;
        }                
        calcularCustoTotal();
    }//GEN-LAST:event_txtPrecoCompraFocusLost

    private void txtPrecoCompraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoCompraFocusGained
        txtPrecoCompra.selectAll();
    }//GEN-LAST:event_txtPrecoCompraFocusGained

    private void txtCustoLimpezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoLimpezaFocusLost
        if (!txtCustoLimpeza.getText().isEmpty() && !txtCustoLimpeza.getText().equals("0,00")){
            String sCustoLimpeza = txtCustoLimpeza.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoLimpeza = new BigDecimal(sCustoLimpeza);
        } else {
            custoLimpeza = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoLimpezaFocusLost

    private void txtCustoLimpezaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoLimpezaFocusGained
        txtCustoLimpeza.selectAll();
    }//GEN-LAST:event_txtCustoLimpezaFocusGained

    private void txtCustoDespachanteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoDespachanteFocusLost
        if (!txtCustoDespachante.getText().isEmpty() && !txtCustoDespachante.getText().equals("0,00")){
            String sCustoDespachante = txtCustoDespachante.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoDespachante = new BigDecimal(sCustoDespachante);
        } else {
            custoDespachante = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoDespachanteFocusLost

    private void txtCustoDespachanteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoDespachanteFocusGained
        txtCustoDespachante.selectAll();
    }//GEN-LAST:event_txtCustoDespachanteFocusGained

    private void txtCustoMecanicaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoMecanicaFocusLost
        if (!txtCustoMecanica.getText().isEmpty() && !txtCustoMecanica.getText().equals("0,00")){
            String sCustoMecanica = txtCustoMecanica.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoMecanica = new BigDecimal(sCustoMecanica);
        } else {
            custoMecanica = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoMecanicaFocusLost

    private void txtCustoMecanicaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoMecanicaFocusGained
        txtCustoMecanica.selectAll();
    }//GEN-LAST:event_txtCustoMecanicaFocusGained

    private void txtCustoImpostosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoImpostosFocusLost
        if (!txtCustoImpostos.getText().isEmpty() && !txtCustoImpostos.getText().equals("0,00")){
            String sCustoImpostos = txtCustoImpostos.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoImpostos = new BigDecimal(sCustoImpostos);
        } else {
            custoImpostos = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoImpostosFocusLost

    private void txtCustoImpostosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoImpostosFocusGained
        txtCustoImpostos.selectAll();
    }//GEN-LAST:event_txtCustoImpostosFocusGained

    private void txtCustoPecasAcessoriosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoPecasAcessoriosFocusLost
        if (!txtCustoPecasAcessorios.getText().isEmpty() && !txtCustoPecasAcessorios.getText().equals("0,00")){
            String sCustoPecasAcessorios = txtCustoPecasAcessorios.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoPecasAcessorios = new BigDecimal(sCustoPecasAcessorios);
        } else {
            custoPecasAcessorios = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoPecasAcessoriosFocusLost

    private void txtCustoPecasAcessoriosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoPecasAcessoriosFocusGained
        txtCustoPecasAcessorios.selectAll();
    }//GEN-LAST:event_txtCustoPecasAcessoriosFocusGained

    private void txtCustoLatariaPinturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoLatariaPinturaFocusLost
        if (!txtCustoLatariaPintura.getText().isEmpty() && !txtCustoLatariaPintura.getText().equals("0,00")){
            String sCustoLataria = txtCustoLatariaPintura.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoLatariaPintura = new BigDecimal(sCustoLataria);
        } else {
            custoLatariaPintura = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoLatariaPinturaFocusLost

    private void txtCustoLatariaPinturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoLatariaPinturaFocusGained
        txtCustoLatariaPintura.selectAll();
    }//GEN-LAST:event_txtCustoLatariaPinturaFocusGained

    private void txtCustoPneusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoPneusFocusLost
        if (!txtCustoPneus.getText().isEmpty() && !txtCustoPneus.getText().equals("0,00")){
            String sCustoPneus = txtCustoPneus.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoPneus = new BigDecimal(sCustoPneus);
        } else {
            custoPneus = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoPneusFocusLost

    private void txtCustoPneusFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoPneusFocusGained
        txtCustoPneus.selectAll();
    }//GEN-LAST:event_txtCustoPneusFocusGained

    private void txtCustoCombustivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoCombustivelFocusLost
        if (!txtCustoCombustivel.getText().isEmpty() && !txtCustoCombustivel.getText().equals("0,00")){
            String sCustoCombustivel = txtCustoCombustivel.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoCombustivel = new BigDecimal(sCustoCombustivel);
        } else {
            custoCombustivel = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoCombustivelFocusLost

    private void txtCustoCombustivelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoCombustivelFocusGained
        txtCustoCombustivel.selectAll();
    }//GEN-LAST:event_txtCustoCombustivelFocusGained

    private void txtCustoBateriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoBateriaFocusLost
        if (!txtCustoBateria.getText().isEmpty() && !txtCustoBateria.getText().equals("0,00")){
            String sCustoBateria = txtCustoBateria.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoBateria = new BigDecimal(sCustoBateria);
        } else {
            custoBateria = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoBateriaFocusLost

    private void txtCustoBateriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoBateriaFocusGained
        txtCustoBateria.selectAll();
    }//GEN-LAST:event_txtCustoBateriaFocusGained

    private void txtCustoCarroceriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoCarroceriaFocusGained
        txtCustoCarroceria.selectAll();
    }//GEN-LAST:event_txtCustoCarroceriaFocusGained

    private void txtCustoCarroceriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoCarroceriaFocusLost
        if (!txtCustoCarroceria.getText().isEmpty() && !txtCustoCarroceria.getText().equals("0,00")){
            String sCustoCarroceria = txtCustoCarroceria.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoCarroceria = new BigDecimal(sCustoCarroceria);
        } else {
            custoCarroceria = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoCarroceriaFocusLost

    private void txtCustoEletricaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoEletricaFocusGained
        txtCustoEletrica.selectAll();
    }//GEN-LAST:event_txtCustoEletricaFocusGained

    private void txtCustoEletricaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoEletricaFocusLost
        if (!txtCustoEletrica.getText().isEmpty() && !txtCustoEletrica.getText().equals("0,00")){
            String sCustoEletrica = txtCustoEletrica.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoEletrica = new BigDecimal(sCustoEletrica);
        } else {
            custoEletrica = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoEletricaFocusLost

    private void txtCustoMultasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoMultasFocusGained
        txtCustoMultas.selectAll();
    }//GEN-LAST:event_txtCustoMultasFocusGained

    private void txtCustoMultasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoMultasFocusLost
        if (!txtCustoMultas.getText().isEmpty() && !txtCustoMultas.getText().equals("0,00")){
            String sCustoMultas = txtCustoMultas.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoMultas = new BigDecimal(sCustoMultas);
        } else {
            custoMultas = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoMultasFocusLost

    private void txtCustoRecapagemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoRecapagemFocusGained
        txtCustoRecapagem.selectAll();
    }//GEN-LAST:event_txtCustoRecapagemFocusGained

    private void txtCustoRecapagemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoRecapagemFocusLost
        if (!txtCustoRecapagem.getText().isEmpty() && !txtCustoRecapagem.getText().equals("0,00")){
            String sCustoRecapagem = txtCustoRecapagem.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoRecapagem = new BigDecimal(sCustoRecapagem);
        } else {
            custoRecapagem = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoRecapagemFocusLost

    private void txtCustoTapecariaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoTapecariaFocusGained
        txtCustoTapecaria.selectAll();
    }//GEN-LAST:event_txtCustoTapecariaFocusGained

    private void txtCustoTapecariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoTapecariaFocusLost
        if (!txtCustoTapecaria.getText().isEmpty() && !txtCustoTapecaria.getText().equals("0,00")){
            String sCustoTapecaria = txtCustoTapecaria.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoTapecaria = new BigDecimal(sCustoTapecaria);
        } else {
            custoTapecaria = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoTapecariaFocusLost

    private void txtCustoTorneariaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoTorneariaFocusGained
        txtCustoTornearia.selectAll();
    }//GEN-LAST:event_txtCustoTorneariaFocusGained

    private void txtCustoTorneariaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoTorneariaFocusLost
        if (!txtCustoTornearia.getText().isEmpty() && !txtCustoTornearia.getText().equals("0,00")){
            String sCustoTornearia = txtCustoTornearia.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoTornearia = new BigDecimal(sCustoTornearia);
        } else {
            custoTornearia = BigDecimal.ZERO;
        }
        calcularCustoTotal();
    }//GEN-LAST:event_txtCustoTorneariaFocusLost

    private void txtCustoOutrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoOutrosFocusGained
        txtCustoOutros.selectAll();
    }//GEN-LAST:event_txtCustoOutrosFocusGained

    private void txtCustoOutrosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustoOutrosFocusLost
        if (!txtCustoOutros.getText().isEmpty() && !txtCustoOutros.getText().equals("0,00")){
            String sCustoOutros = txtCustoOutros.getText().replace(" ", "").replace(".", "").replace(",", ".");
            custoOutros = new BigDecimal(sCustoOutros);
        } else {
            custoOutros = BigDecimal.ZERO;
        }
        calcularCustoTotal();
        btnGravarCustos.requestFocus();
    }//GEN-LAST:event_txtCustoOutrosFocusLost
    
    public void consultarCustosVeiculos(){
        String placa = txtVeiculoPlaca.getText();
        String modelo = txtVeiculoModelo.getText();
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM VEICULOSCUSTOS "
                         + "JOIN VEICULOS ON(VEICULOS.CODIGO = VEICULOSCUSTOS.VEICULOCODIGO) "
                         + "WHERE VEICULOS.PLACA = '" + placa + "' AND " 
                         + "      VEICULOS.MODELO = '" + modelo + "' ");
        
        try {                
            //Se possui lançamento na tabela de custos carrega para depois atualizar;
            if (conecta.rs.first()){            
                if (conecta.rs.getDate("DATACOMPRA") != null) {
                    dataCompra = formatoData.format(conecta.rs.getDate("DATACOMPRA"));
                } else {
                    dataCompra = null;
                }

                if (conecta.rs.getDate("DATAVENDA") != null) {
                    dataVenda = formatoData.format(conecta.rs.getDate("DATAVENDA"));
                } else {
                    dataVenda = null;
                }

                precoCompra = conecta.rs.getBigDecimal("PRECOCOMPRA");
                precoVenda = conecta.rs.getBigDecimal("PRECOVENDA");                
                custoBateria = conecta.rs.getBigDecimal("CUSTOBATERIA");
                custoCarroceria = conecta.rs.getBigDecimal("CUSTOCARROCERIA");
                custoCombustivel = conecta.rs.getBigDecimal("CUSTOCOMBUSTIVEL");
                custoDespachante = conecta.rs.getBigDecimal("CUSTODESPACHANTE");
                custoEletrica = conecta.rs.getBigDecimal("CUSTOELETRICA");
                custoImpostos = conecta.rs.getBigDecimal("CUSTOIMPOSTOS");
                custoLatariaPintura = conecta.rs.getBigDecimal("CUSTOLATARIAPINTURA");
                custoLimpeza = conecta.rs.getBigDecimal("CUSTOLIMPEZA");
                custoMecanica = conecta.rs.getBigDecimal("CUSTOMECANICA");
                custoMultas = conecta.rs.getBigDecimal("CUSTOMULTAS");
                custoPecasAcessorios = conecta.rs.getBigDecimal("CUSTOPECASACESSORIOS");
                custoPneus = conecta.rs.getBigDecimal("CUSTOPNEUS");
                custoRecapagem = conecta.rs.getBigDecimal("CUSTORECAPAGEM");
                custoTapecaria = conecta.rs.getBigDecimal("CUSTOTAPECARIA");
                custoTornearia = conecta.rs.getBigDecimal("CUSTOTORNEARIA");
                custoOutros = conecta.rs.getBigDecimal("CUSTOOUTROS");
                totalDespesas = conecta.rs.getBigDecimal("CUSTOTOTAL"); 
                margemLucroValor = conecta.rs.getBigDecimal("MARGEMLUCRO");             
            
                conecta.desconecta();
                incluindo = 0;
                alterando = 1;
                                
            //Se não possui na tabela de custos carrega as despesas lançadas de acordo com a categoria;
            } else {
                consultarDespesasVeiculos();  
            } 

            txtDataCompra.setText(dataCompra);
            txtDataVenda.setText(dataVenda);
               
            txtPrecoCompra.setText(nf.format(precoCompra).replace("R$ ", ""));
            txtPrecoVenda.setText(nf.format(precoVenda).replace("R$ ", ""));
            txtCustoBateria.setText(nf.format(custoBateria).replace("R$ ", ""));
            txtCustoCarroceria.setText(nf.format(custoCarroceria).replace("R$ ", ""));
            txtCustoCombustivel.setText(nf.format(custoCombustivel).replace("R$ ", ""));
            txtCustoDespachante.setText(nf.format(custoDespachante).replace("R$ ", ""));                         
            txtCustoEletrica.setText(nf.format(custoEletrica).replace("R$ ", ""));
            txtCustoImpostos.setText(nf.format(custoImpostos).replace("R$ ", "")); 
            txtCustoLatariaPintura.setText(nf.format(custoLatariaPintura).replace("R$ ", ""));
            txtCustoLimpeza.setText(nf.format(custoLimpeza).replace("R$ ", ""));
            txtCustoMecanica.setText(nf.format(custoMecanica).replace("R$ ", ""));    
            txtCustoMultas.setText(nf.format(custoMultas).replace("R$ ", ""));
            txtCustoPecasAcessorios.setText(nf.format(custoPecasAcessorios).replace("R$ ", ""));
            txtCustoPneus.setText(nf.format(custoPneus).replace("R$ ", "")); 
            txtCustoRecapagem.setText(nf.format(custoRecapagem).replace("R$ ", ""));
            txtCustoTapecaria.setText(nf.format(custoTapecaria).replace("R$ ", ""));
            txtCustoTornearia.setText(nf.format(custoTornearia).replace("R$ ", ""));
            txtCustoOutros.setText(nf.format(custoOutros).replace("R$ ", ""));
            txtTotalDespesas.setText(nf.format(totalDespesas).replace("R$ ", ""));
            txtTotalCusto.setText(nf.format(totalCusto).replace("R$ ", ""));
            txtMargemLucroValor.setText(nf.format(margemLucroValor).replace("R$ ", ""));

            calcularCustoTotal();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar custos do veículo!");
        }
        conecta.desconecta();            
    }
     
    public void consultarDespesasVeiculos(){
        String placa = txtVeiculoPlaca.getText();
        String modelo = txtVeiculoModelo.getText();
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        conecta.conexao();
        conecta.executaSql("SELECT TRIM(VEICULOSDESPESAS.CATEGORIA) AS CATEGORIA, "
                         + "       VEICULOSDESPESAS.DESPESAVALOR AS VALOR,  "
                         + "       VEICULOS.CODIGO AS VEICULOCODIGO,   "
                         + "       VEICULOS.PLACA AS PLACA ,           "
                         + "       VEICULOS.MODELO AS MODELO,          "
                         + "       VEICULOS.DATACOMPRA AS DATACOMPRA,  "
                         + "       VEICULOS.PRECOCOMPRA AS PRECOCOMPRA "
                         + "FROM VEICULOSDESPESAS                      "
                         + "     JOIN VEICULOS ON(VEICULOS.CODIGO = VEICULOSDESPESAS.VEICULOCODIGO)  "
                         + "WHERE VEICULOS.PLACA = '" + placa + "' AND " 
                         + "      VEICULOS.MODELO = '" + modelo + "' ");
        try {
            if (conecta.rs.first()){                
                if (conecta.rs.getDate("DATACOMPRA") != null) {
                    dataCompra = formatoData.format(conecta.rs.getDate("DATACOMPRA"));
                } else {
                    dataCompra = null;
                }

                if (conecta.rs.getString("PRECOCOMPRA") != null) {
                    precoCompra = conecta.rs.getBigDecimal("PRECOCOMPRA");
                } else {
                    precoCompra = BigDecimal.ZERO;
                }

                do{
                    if (conecta.rs.getString("CATEGORIA").equals("BATERIA")){
                        custoBateria = custoBateria.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }
                    
                    if (conecta.rs.getString("CATEGORIA").equals("CARROCERIA")){
                        custoCarroceria = custoCarroceria.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }

                    if (conecta.rs.getString("CATEGORIA").equals("COMBUSTIVEL")){
                        custoCombustivel = custoCombustivel.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }

                    if (conecta.rs.getString("CATEGORIA").equals("DESPACHANTE")){
                        custoDespachante = custoDespachante.add(conecta.rs.getBigDecimal("VALOR"));                                                            
                    } 

                    if (conecta.rs.getString("CATEGORIA").equals("ELETRICA")){
                        custoEletrica = custoEletrica.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }

                    if (conecta.rs.getString("CATEGORIA").equals("IMPOSTOS")){
                        custoImpostos = custoImpostos.add(conecta.rs.getBigDecimal("VALOR"));                                                           
                    }                        

                    if (conecta.rs.getString("CATEGORIA").equals("LATARIA E PINTURA")){
                        custoLatariaPintura = custoLatariaPintura.add(conecta.rs.getBigDecimal("VALOR"));                                                            
                    }                                    

                    if (conecta.rs.getString("CATEGORIA").equals("LIMPEZA")){
                        custoLimpeza = custoLimpeza.add(conecta.rs.getBigDecimal("VALOR"));                                                            
                    }                                    

                    if (conecta.rs.getString("CATEGORIA").equals("MECANICA")){
                        custoMecanica = custoMecanica.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }                                

                    if (conecta.rs.getString("CATEGORIA").equals("MULTAS")){
                        custoMultas = custoMultas.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }                    

                    if (conecta.rs.getString("CATEGORIA").equals("PECAS E ACESSORIOS")){
                        custoPecasAcessorios = custoPecasAcessorios.add(conecta.rs.getBigDecimal("VALOR"));                                                            
                    }                                                     

                    if (conecta.rs.getString("CATEGORIA").equals("PNEUS")){
                        custoPneus = custoPneus.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }
                    
                    if (conecta.rs.getString("CATEGORIA").equals("RECAPAGEM")){
                        custoRecapagem = custoRecapagem.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }
                    
                    if (conecta.rs.getString("CATEGORIA").equals("TAPECARIA")){
                        custoTapecaria = custoTapecaria.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }
                    
                    if (conecta.rs.getString("CATEGORIA").equals("TORNEARIA")){
                        custoTornearia = custoTornearia.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }

                    if (conecta.rs.getString("CATEGORIA").equals("OUTROS")){
                        custoOutros = custoOutros.add(conecta.rs.getBigDecimal("VALOR"));                            
                    }

                } while (conecta.rs.next());

            } else {
                //Se não possui nenhum lançamento solicita se deseja incluir manualmente;
                int resposta = 0;
                resposta = JOptionPane.showConfirmDialog(rootPane, "Nenhum lançamento de despesas ou custos localizado para o veículo? \n"
                                                                 + "Deseja lançar os custos manualmente?");
               
                if (resposta == JOptionPane.YES_OPTION) {
                    conecta.conexao();
                    conecta.executaSql("SELECT "
                                     + "       VEICULOS.DATACOMPRA AS DATACOMPRA,  "
                                     + "       VEICULOS.PRECOCOMPRA AS PRECOCOMPRA "
                                     + "FROM VEICULOS "
                                     + "WHERE VEICULOS.PLACA = '" + placa + "' AND " 
                                     + "      VEICULOS.MODELO = '" + modelo + "' ");

                    if (conecta.rs.first()){                
                        if (conecta.rs.getDate("DATACOMPRA") != null) {
                            dataCompra = formatoData.format(conecta.rs.getDate("DATACOMPRA"));
                            txtDataCompra.setText(dataCompra); 
                        } else {
                            dataCompra = null;
                        }

                        if (conecta.rs.getString("PRECOCOMPRA") != null) {
                            precoCompra = conecta.rs.getBigDecimal("PRECOCOMPRA");
                            txtPrecoCompra.setText(precoCompra.toString()); 
                        } else {
                            precoCompra = BigDecimal.ZERO;
                        }
                    }

                    txtDataVenda.setText(null);
                    txtPrecoVenda.setText("");
                    txtCustoBateria.setText("");
                    txtCustoCarroceria.setText("");
                    txtCustoCombustivel.setText("");
                    txtCustoDespachante.setText("");
                    txtCustoEletrica.setText("");
                    txtCustoImpostos.setText("");
                    txtCustoLatariaPintura.setText("");
                    txtCustoLimpeza.setText("");
                    txtCustoMecanica.setText("");
                    txtCustoMultas.setText("");
                    txtCustoPecasAcessorios.setText("");
                    txtCustoPneus.setText("");
                    txtCustoRecapagem.setText("");
                    txtCustoTapecaria.setText("");
                    txtCustoTornearia.setText("");
                    txtCustoOutros.setText(""); 
                    txtTotalDespesas.setText("");
                    txtTotalCusto.setText("");
                    txtMargemLucroValor.setText("");
                    txtMargemLucroPercentual.setText("");
                    txtDataCompra.requestFocus();
                    
                    dataVenda = null;
                    precoVenda = BigDecimal.ZERO;                            
                    custoBateria = BigDecimal.ZERO;            
                    custoCarroceria = BigDecimal.ZERO;            
                    custoCombustivel = BigDecimal.ZERO;
                    custoDespachante = BigDecimal.ZERO;
                    custoEletrica = BigDecimal.ZERO;            
                    custoImpostos = BigDecimal.ZERO;
                    custoLatariaPintura = BigDecimal.ZERO;            
                    custoLimpeza = BigDecimal.ZERO;
                    custoMecanica = BigDecimal.ZERO;            
                    custoMultas = BigDecimal.ZERO;            
                    custoPecasAcessorios = BigDecimal.ZERO;
                    custoPneus = BigDecimal.ZERO;            
                    custoRecapagem = BigDecimal.ZERO;            
                    custoTapecaria = BigDecimal.ZERO;            
                    custoTornearia = BigDecimal.ZERO;            
                    custoOutros = BigDecimal.ZERO;            
                    totalDespesas = BigDecimal.ZERO;
                    totalCusto = BigDecimal.ZERO;
                    margemLucroValor = BigDecimal.ZERO;         
                                        
                    incluindo = 1;
                    alterando = 0;
                    
                } else if (resposta == JOptionPane.NO_OPTION) {
                    limpaCampos();
                    txtVeiculoPlaca.requestFocus();
                } else {
                    this.dispose();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar despesas do veículo!");
        }
        conecta.desconecta();
    }
    
    public void calcularCustoTotal(){
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        BigDecimal margemPercentual;
        
        if (!txtPrecoCompra.getText().isEmpty()){
            String sPrecoCompra = txtPrecoCompra.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            precoCompra = new BigDecimal(sPrecoCompra);
        } else {
            precoCompra = BigDecimal.ZERO;
        }
        
        if (!txtPrecoVenda.getText().isEmpty()){
            String sPrecoVenda = txtPrecoVenda.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
            precoVenda = new BigDecimal(sPrecoVenda);
        } else {
            precoVenda = BigDecimal.ZERO;
        }
  
        totalDespesas = custoBateria.add(custoCarroceria).add(custoCombustivel).add(custoDespachante).add(custoEletrica).add
                       (custoImpostos).add(custoLatariaPintura).add(custoLimpeza).add(custoMecanica).add(custoMultas).add
                       (custoPecasAcessorios).add(custoPneus).add(custoRecapagem).add(custoTapecaria).add(custoTornearia).add(custoOutros); 
        
        txtTotalDespesas.setText(nf.format(totalDespesas).replace("R$ ", ""));        
        
        totalCusto = totalDespesas.add(precoCompra);
        txtTotalCusto.setText(nf.format(totalCusto).replace("R$ ", "")); 
        
        margemLucroValor = precoVenda.subtract(totalCusto); 
        txtMargemLucroValor.setText(nf.format(margemLucroValor).replace("R$ ", ""));                          
        
        if (totalCusto.compareTo(BigDecimal.ZERO) == 0 || precoCompra.compareTo(BigDecimal.ZERO) == 0 || precoVenda.compareTo(BigDecimal.ZERO) == 0){
            margemPercentual = BigDecimal.ZERO;            
        } else {
            margemPercentual = (margemLucroValor.multiply(BigDecimal.valueOf(100)).divide(totalCusto, BigDecimal.ROUND_UP)); 
        }
        txtMargemLucroPercentual.setText(nf.format(margemPercentual).replace("R$ ", "")); 
    }

    public void limpaCampos(){
        txtVeiculoPlaca.setText("");
        txtVeiculoModelo.setText("");
        txtDataCompra.setText(null);
        txtDataVenda.setText(null);
        txtPrecoCompra.setText("");
        txtPrecoVenda.setText("");
        txtCustoBateria.setText("");
        txtCustoCarroceria.setText("");
        txtCustoCombustivel.setText("");
        txtCustoDespachante.setText("");
        txtCustoEletrica.setText("");
        txtCustoImpostos.setText("");
        txtCustoLatariaPintura.setText("");
        txtCustoLimpeza.setText("");
        txtCustoMecanica.setText("");
        txtCustoMultas.setText("");
        txtCustoPecasAcessorios.setText("");
        txtCustoPneus.setText("");
        txtCustoRecapagem.setText("");
        txtCustoTapecaria.setText("");
        txtCustoTornearia.setText("");
        txtCustoOutros.setText("");
        txtTotalDespesas.setText("");
        txtTotalCusto.setText("");
        txtMargemLucroValor.setText("");
        txtMargemLucroPercentual.setText(""); 
        
        btnExcluir.setEnabled(false); 
        btnAtualizarCustos.setEnabled(false); 
        
        veiculoCodigo = 0;
        dataCompra    = null;
        dataVenda     = null;
        precoCompra   = BigDecimal.ZERO;
        precoVenda    = BigDecimal.ZERO;        
        custoBateria  = BigDecimal.ZERO;        
        custoCarroceria  = BigDecimal.ZERO;
        custoCombustivel = BigDecimal.ZERO;
        custoDespachante = BigDecimal.ZERO;
        custoEletrica    = BigDecimal.ZERO;
        custoImpostos    = BigDecimal.ZERO;
        custoLatariaPintura = BigDecimal.ZERO;            
        custoLimpeza  = BigDecimal.ZERO;
        custoMecanica = BigDecimal.ZERO;   
        custoMultas   = BigDecimal.ZERO;
        custoPecasAcessorios = BigDecimal.ZERO;
        custoPneus       = BigDecimal.ZERO;            
        custoRecapagem   = BigDecimal.ZERO;
        custoTapecaria   = BigDecimal.ZERO;
        custoTornearia   = BigDecimal.ZERO;
        custoOutros      = BigDecimal.ZERO;
        totalDespesas    = BigDecimal.ZERO;
        margemLucroValor = BigDecimal.ZERO;        
               
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
                new CustosVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnAtualizarCustos;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravarCustos;
    public javax.swing.JButton btnPesqusiarVeiculo;
    public javax.swing.JButton btnSair;
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
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCustoBateria;
    private javax.swing.JTextField txtCustoCarroceria;
    private javax.swing.JFormattedTextField txtCustoCombustivel;
    private javax.swing.JFormattedTextField txtCustoDespachante;
    private javax.swing.JTextField txtCustoEletrica;
    private javax.swing.JFormattedTextField txtCustoImpostos;
    private javax.swing.JFormattedTextField txtCustoLatariaPintura;
    private javax.swing.JFormattedTextField txtCustoLimpeza;
    private javax.swing.JFormattedTextField txtCustoMecanica;
    private javax.swing.JTextField txtCustoMultas;
    private javax.swing.JTextField txtCustoOutros;
    private javax.swing.JFormattedTextField txtCustoPecasAcessorios;
    private javax.swing.JFormattedTextField txtCustoPneus;
    private javax.swing.JTextField txtCustoRecapagem;
    private javax.swing.JTextField txtCustoTapecaria;
    private javax.swing.JTextField txtCustoTornearia;
    public javax.swing.JFormattedTextField txtDataCompra;
    public javax.swing.JFormattedTextField txtDataVenda;
    private javax.swing.JTextField txtMargemLucroPercentual;
    private javax.swing.JFormattedTextField txtMargemLucroValor;
    private javax.swing.JFormattedTextField txtPrecoCompra;
    private javax.swing.JFormattedTextField txtPrecoVenda;
    public javax.swing.JTextField txtTotalCusto;
    private javax.swing.JFormattedTextField txtTotalDespesas;
    public javax.swing.JTextField txtVeiculoModelo;
    public javax.swing.JTextField txtVeiculoPlaca;
    // End of variables declaration//GEN-END:variables
}
