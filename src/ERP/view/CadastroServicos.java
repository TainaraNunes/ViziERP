
package ERP.view;

import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Beans.BeansServicos;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoServicos;

public class CadastroServicos extends javax.swing.JFrame {

    BeansServicos ser = new BeansServicos();
    ConectaBD conecta = new ConectaBD();
    DaoServicos dao = new DaoServicos();
    PesquisaServicos pesquisaServicos = new PesquisaServicos();
    PesquisaProdutos pesquisaPecas = new PesquisaProdutos();
    
    public int incluindo = 1;
    public int alterando = 0;
    public int incluindoListaPecas = 1;
    public int alterandoListaPecas = 0;
    public int incluindoListaServicos = 1;
    public int alterandoListaServicos = 0;    
    public boolean lIncluindoPeca = true;    
    public boolean lIncluindoServico = true;  

    public CadastroServicos() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/cadastroservicos.png")).getImage());
        
        txtPesquisaServico.setDocument(new Teclas());
        txtDescricaoServico.setDocument(new Teclas());
        txtDescricaoPeca.setDocument(new Teclas());
        
        btnExcluir.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoServico = new javax.swing.JTextField();
        txtDescricaoServico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPesquisaServico = new javax.swing.JTextField();
        btnPesquisarServico = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaPecas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtQuantidadePeca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDescricaoPeca = new javax.swing.JTextField();
        btnPesquisarPeca = new javax.swing.JButton();
        btnAdicionarPeca = new javax.swing.JButton();
        btnRemoverPeca = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoPeca = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoServicoLista = new javax.swing.JTextField();
        txtDescricaoServicoLista = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListaServicos = new javax.swing.JTable();
        btnAdicionarServico = new javax.swing.JButton();
        btnRemoverServico = new javax.swing.JButton();
        btnPesquisarServicoLista = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Serviços");
        setName("frmCadastroServicos"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jLabel2.setText("Serviço:");

        txtCodigoServico.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGravar, btnSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnSair)
                    .addComponent(btnExcluir)
                    .addComponent(btnAbandonar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Procurar:");

        btnPesquisarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisarServico)
                    .addComponent(txtPesquisaServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setName(""); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblListaPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantidade", "Código Peça", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaPecas.getTableHeader().setReorderingAllowed(false);
        tblListaPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListaPecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListaPecas);
        if (tblListaPecas.getColumnModel().getColumnCount() > 0) {
            tblListaPecas.getColumnModel().getColumn(0).setResizable(false);
            tblListaPecas.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblListaPecas.getColumnModel().getColumn(1).setResizable(false);
            tblListaPecas.getColumnModel().getColumn(1).setPreferredWidth(17);
            tblListaPecas.getColumnModel().getColumn(2).setResizable(false);
            tblListaPecas.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jLabel7.setText("Quantidade:");

        txtQuantidadePeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadePecaKeyTyped(evt);
            }
        });

        jLabel8.setText("Descrição:");

        btnPesquisarPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPecaActionPerformed(evt);
            }
        });

        btnAdicionarPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnAdicionarPeca.setPreferredSize(new java.awt.Dimension(47, 23));
        btnAdicionarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPecaActionPerformed(evt);
            }
        });

        btnRemoverPeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnRemoverPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPecaActionPerformed(evt);
            }
        });

        jLabel4.setText("Código Peça:");

        txtCodigoPeca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPecaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoverPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCodigoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtDescricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtQuantidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricaoPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPeca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAdicionarPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoverPeca))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lista de Peças", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Código:");

        jLabel9.setText("Serviço:");

        tblListaServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblListaServicos);
        if (tblListaServicos.getColumnModel().getColumnCount() > 0) {
            tblListaServicos.getColumnModel().getColumn(0).setResizable(false);
            tblListaServicos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblListaServicos.getColumnModel().getColumn(1).setResizable(false);
            tblListaServicos.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        btnAdicionarServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/selecionar.png"))); // NOI18N
        btnAdicionarServico.setPreferredSize(new java.awt.Dimension(47, 23));
        btnAdicionarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarServicoActionPerformed(evt);
            }
        });

        btnRemoverServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/excluir.png"))); // NOI18N
        btnRemoverServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverServicoActionPerformed(evt);
            }
        });

        btnPesquisarServicoLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarServicoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarServicoListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCodigoServicoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescricaoServicoLista)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarServico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoverServico, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarServicoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoServicoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescricaoServicoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnAdicionarServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoverServico))
                            .addComponent(btnPesquisarServicoLista))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Serviços", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtPesquisaServico.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtDescricaoServico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição do serviço!");
            txtDescricaoServico.requestFocus();        
        } else if (incluindo == 1) {  
            incluindoListaPecas = 1;
            incluindoListaServicos = 1;
            
            ser.setDescricao(txtDescricaoServico.getText());            
            dao.gravarServico(ser, this);
            
            limpaCampos();
            ((DefaultTableModel) tblListaPecas.getModel()).setRowCount(0);
            ((DefaultTableModel) tblListaServicos.getModel()).setRowCount(0);
            
        } else if (alterando == 1) {
            alterandoListaPecas = 1;
            alterandoListaServicos = 1;
            
            ser.setCodigoServico(Integer.parseInt(txtCodigoServico.getText()));
            ser.setDescricao(txtDescricaoServico.getText());            
            dao.alterarServico(ser, this);
            
            limpaCampos();
            ((DefaultTableModel) tblListaPecas.getModel()).setRowCount(0);
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    public void limpaCampos() {
        txtCodigoServico.setText("");
        txtDescricaoServico.setText("");
        txtCodigoServicoLista.setText("");
        txtDescricaoServicoLista.setText("");
        txtQuantidadePeca.setText("");
        txtCodigoPeca.setText("");
        txtDescricaoPeca.setText(""); 
        txtCodigoPeca.setEnabled(true);
        txtDescricaoPeca.setEnabled(true); 
        ((DefaultTableModel) tblListaPecas.getModel()).setRowCount(0);
        ((DefaultTableModel) tblListaServicos.getModel()).setRowCount(0);
    
        txtDescricaoServico.requestFocus();
        btnExcluir.setEnabled(false);
        
        incluindo = 1;
        alterando = 0;
    }
    
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarServicoActionPerformed
        limpaCampos();
        if (!txtPesquisaServico.getText().isEmpty()) {
            pesquisaServicos = new PesquisaServicos();
            pesquisaServicos.setLocationRelativeTo(null);
            pesquisaServicos.setVisible(true);
            pesquisaServicos.setResizable(false);
            pesquisaServicos.preencherTabela(this, "btnPesquisarServico", "SELECT * FROM SERVICOS WHERE DESCRICAO LIKE '%" + txtPesquisaServico.getText() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaServicos = new PesquisaServicos();
            pesquisaServicos.setLocationRelativeTo(null);
            pesquisaServicos.setVisible(true);
            pesquisaServicos.setResizable(false);
            pesquisaServicos.preencherTabela(this, "btnPesquisarServico", "SELECT * FROM SERVICOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarServicoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            ser.setCodigoServico(Integer.parseInt(txtCodigoServico.getText()));
            dao.excluirServico(ser);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPecaActionPerformed
        if (!txtDescricaoPeca.getText().isEmpty()) {
            pesquisaPecas = new PesquisaProdutos();
            pesquisaPecas.setLocationRelativeTo(null);
            pesquisaPecas.setVisible(true);
            pesquisaPecas.setResizable(false);
            pesquisaPecas.preencherTabela(null, null, null, this, null, "SELECT * FROM PRODUTOS WHERE DESCRICAO LIKE '%" + txtDescricaoPeca.getText().trim() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaPecas = new PesquisaProdutos();
            pesquisaPecas.setLocationRelativeTo(null);
            pesquisaPecas.setVisible(true);
            pesquisaPecas.preencherTabela(null, null, null, this, null, "SELECT * FROM PRODUTOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarPecaActionPerformed

    private void btnAdicionarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPecaActionPerformed
        for (int x = 0; x < tblListaPecas.getRowCount(); x++) {
            if (tblListaPecas.getValueAt(x, 1).equals(txtCodigoPeca.getText())) {
                lIncluindoPeca = false;
            } 
        }
            
        if (lIncluindoPeca == true) {
            String quantidadePeca = txtQuantidadePeca.getText();
            String codigoPeca = txtCodigoPeca.getText();
            String descricaoPeca = txtDescricaoPeca.getText();

            if (txtQuantidadePeca.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade da peça!");
                txtQuantidadePeca.requestFocus();
            } else if (txtDescricaoPeca.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a descrição da peça!");
                txtDescricaoPeca.requestFocus();
            } else {
                DefaultTableModel valores = (DefaultTableModel) tblListaPecas.getModel();
                valores.addRow(new Object[]{quantidadePeca, codigoPeca, descricaoPeca});
            } 
        } else {
            if (tblListaPecas.getSelectedRow() != -1) {
                tblListaPecas.setValueAt(txtQuantidadePeca.getText(), tblListaPecas.getSelectedRow(), 0);
            }
        }
        
        txtQuantidadePeca.setText("");
        txtCodigoPeca.setText("");
        txtDescricaoPeca.setText("");
        txtQuantidadePeca.requestFocus();
        txtCodigoPeca.setEnabled(true);
        txtDescricaoPeca.setEnabled(true); 
    }//GEN-LAST:event_btnAdicionarPecaActionPerformed

    private void btnRemoverPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPecaActionPerformed
        if (tblListaPecas.getSelectedRow() != -1) {
            ((DefaultTableModel) tblListaPecas.getModel()).removeRow(tblListaPecas.getSelectedRow());
            txtCodigoPeca.setText("");
            txtDescricaoPeca.setText("");
            txtQuantidadePeca.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma peça para eliminar da lista!");
        }
        txtQuantidadePeca.setText("");
        txtCodigoPeca.setText("");
        txtDescricaoPeca.setText(""); 
    }//GEN-LAST:event_btnRemoverPecaActionPerformed

    private void tblListaPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListaPecasMouseClicked
        int index = tblListaPecas.getSelectedRow();
        TableModel model = tblListaPecas.getModel();

        conecta.conexao();
        conecta.executaSql("SELECT * FROM SERVICOLISTAPECAS WHERE CODIGOSERVICO = '"+index+"'");
        try {
            conecta.rs.first();
            
            String quantidadePeca = model.getValueAt(index, 0).toString();
            String codigoPeca = model.getValueAt(index, 1).toString();
            String descricaoPeca = model.getValueAt(index, 2).toString();
            
            txtQuantidadePeca.setText(quantidadePeca);
            txtCodigoPeca.setText(codigoPeca);
            txtCodigoPeca.setEnabled(false);
            txtDescricaoPeca.setText(descricaoPeca);
            txtDescricaoPeca.setEnabled(false);             
            btnExcluir.setEnabled(true);                   
            
            incluindoListaPecas = 0;
            alterandoListaPecas = 1;
            lIncluindoPeca = false;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados! \n" +ex);
        }        
        conecta.desconecta();
    }//GEN-LAST:event_tblListaPecasMouseClicked

    private void txtQuantidadePecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadePecaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadePecaKeyTyped

    private void txtCodigoPecaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPecaKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoPecaKeyTyped

    private void btnAdicionarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarServicoActionPerformed
        for (int x = 0; x < tblListaServicos.getRowCount(); x++) {
            if (tblListaServicos.getValueAt(x, 1).equals(txtCodigoServicoLista.getText())) {
                lIncluindoServico = false;
            } 
        }
            
        if (lIncluindoServico == true) {
            String codigoServicoLista = txtCodigoServicoLista.getText();
            String descricaoServicoLista = txtDescricaoServicoLista.getText();

            if (txtDescricaoServicoLista.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a descrição do serviço!");
                txtDescricaoServicoLista.requestFocus();
            } else {
                DefaultTableModel valores = (DefaultTableModel) tblListaServicos.getModel();
                valores.addRow(new Object[]{codigoServicoLista, descricaoServicoLista});
            } 
        } else {
            if (tblListaServicos.getSelectedRow() != -1) {
                tblListaServicos.setValueAt(txtCodigoServicoLista.getText(), tblListaServicos.getSelectedRow(), 0);
            }
        }
        
        txtCodigoServicoLista.setText("");
        txtDescricaoServicoLista.setText("");
    }//GEN-LAST:event_btnAdicionarServicoActionPerformed

    private void btnRemoverServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverServicoActionPerformed
        if (tblListaServicos.getSelectedRow() != -1) {
            ((DefaultTableModel) tblListaServicos.getModel()).removeRow(tblListaServicos.getSelectedRow());
            txtCodigoServicoLista.setText("");
            txtDescricaoServicoLista.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um serviço para eliminar da lista!");
        }
        
        txtCodigoServicoLista.setText("");
        txtDescricaoServicoLista.setText(""); 
    }//GEN-LAST:event_btnRemoverServicoActionPerformed

    private void btnPesquisarServicoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarServicoListaActionPerformed
        if (!txtPesquisaServico.getText().isEmpty()) {
            pesquisaServicos = new PesquisaServicos();
            pesquisaServicos.setLocationRelativeTo(null);
            pesquisaServicos.setVisible(true);
            pesquisaServicos.setResizable(false);
            pesquisaServicos.preencherTabela(this, "btnPesquisarServicoLista", "SELECT * FROM SERVICOS WHERE DESCRICAO LIKE '%" + txtPesquisaServico.getText() + "%' ORDER BY DESCRICAO");
        } else {
            pesquisaServicos = new PesquisaServicos();
            pesquisaServicos.setLocationRelativeTo(null);
            pesquisaServicos.setVisible(true);
            pesquisaServicos.setResizable(false);
            pesquisaServicos.preencherTabela(this, "btnPesquisarServicoLista", "SELECT * FROM SERVICOS ORDER BY DESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisarServicoListaActionPerformed

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
                new CadastroServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnAdicionarPeca;
    public javax.swing.JButton btnAdicionarServico;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    public javax.swing.JButton btnPesquisarPeca;
    public javax.swing.JButton btnPesquisarServico;
    public javax.swing.JButton btnPesquisarServicoLista;
    public javax.swing.JButton btnRemoverPeca;
    public javax.swing.JButton btnRemoverServico;
    public javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable tblListaPecas;
    public javax.swing.JTable tblListaServicos;
    public javax.swing.JTextField txtCodigoPeca;
    public javax.swing.JTextField txtCodigoServico;
    public javax.swing.JTextField txtCodigoServicoLista;
    public javax.swing.JTextField txtDescricaoPeca;
    public javax.swing.JTextField txtDescricaoServico;
    public javax.swing.JTextField txtDescricaoServicoLista;
    public javax.swing.JTextField txtPesquisaServico;
    public javax.swing.JTextField txtQuantidadePeca;
    // End of variables declaration//GEN-END:variables
}
