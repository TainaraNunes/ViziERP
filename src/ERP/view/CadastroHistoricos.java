package ERP.view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.BeansHistoricos;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoHistoricos;

public class CadastroHistoricos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    BeansHistoricos historico = new BeansHistoricos();
    DaoHistoricos dao = new DaoHistoricos();
    PesquisaHistoricos pesquisaHistoricos = new PesquisaHistoricos();
    PesquisaContasBancarias pesquisaContasBancarias = new PesquisaContasBancarias();    

    int incluindo = 1;
    int alterando = 0;    

    public CadastroHistoricos() {
        initComponents();
        dao.gerarCodigoHistorico(this);

        txtBancoCodigo.setEnabled(false);
        txtBancoDescricao.setEnabled(false);
        txtContaCorrente.setEnabled(false);
        btnPesquisarBanco.setEnabled(false);

        txtPesquisaHistorico.setDocument(new Teclas());
        txtHistoricoDescricao.setDocument(new Teclas());
        txtBancoDescricao.setDocument(new Teclas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxLancaEntrada = new javax.swing.JCheckBox();
        cbxLancaSaida = new javax.swing.JCheckBox();
        txtHistoricoDescricao = new javax.swing.JTextField();
        txtHistoricoCodigo = new javax.swing.JTextField();
        cbxContraPartida = new javax.swing.JCheckBox();
        cbxMovimentaDuplicatas = new javax.swing.JCheckBox();
        cbxAtivo = new javax.swing.JCheckBox();
        cbxMovimentaCheque = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAbandonar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBancoDescricao = new javax.swing.JTextField();
        txtContaCorrente = new javax.swing.JTextField();
        txtBancoCodigo = new javax.swing.JTextField();
        cbxMovimentaSaldoBancario = new javax.swing.JCheckBox();
        btnPesquisarBanco = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtPesquisaHistorico = new javax.swing.JTextField();
        btnPesquisaHistoricos = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Históricos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição:");

        jLabel3.setText(" Lançamento:");

        cbxLancaEntrada.setText("Entrada");

        cbxLancaSaida.setText("Saída");

        txtHistoricoCodigo.setEditable(false);
        txtHistoricoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHistoricoCodigoKeyTyped(evt);
            }
        });

        cbxContraPartida.setText("Contra Partida");

        cbxMovimentaDuplicatas.setText("Movimenta lançamento de duplicatas");

        cbxAtivo.setSelected(true);
        cbxAtivo.setText("Ativo");

        cbxMovimentaCheque.setText("Movimenta cheques");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtHistoricoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbxAtivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMovimentaCheque)
                            .addComponent(cbxMovimentaDuplicatas)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtHistoricoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxLancaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(cbxLancaSaida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxContraPartida)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtHistoricoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbxAtivo))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtHistoricoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbxContraPartida)
                    .addComponent(cbxLancaSaida)
                    .addComponent(cbxLancaEntrada)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMovimentaDuplicatas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxMovimentaCheque)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbandonar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnExcluir, btnGravar, btnSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(btnAbandonar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Banco:");

        jLabel7.setText("Conta Corrente:");

        txtContaCorrente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContaCorrenteKeyTyped(evt);
            }
        });

        txtBancoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBancoCodigoKeyTyped(evt);
            }
        });

        cbxMovimentaSaldoBancario.setText("Movimenta saldo bancário");
        cbxMovimentaSaldoBancario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxMovimentaSaldoBancario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cbxMovimentaSaldoBancario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMovimentaSaldoBancarioActionPerformed(evt);
            }
        });

        btnPesquisarBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtBancoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBancoDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbxMovimentaSaldoBancario)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxMovimentaSaldoBancario)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisarBanco)
                    .addComponent(txtBancoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBancoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Pesquisar:");

        btnPesquisaHistoricos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaHistoricos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisaHistoricos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaHistoricosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisaHistoricos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnPesquisaHistoricos)
                    .addComponent(txtPesquisaHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (txtHistoricoCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe o código do histórico!");
            txtHistoricoCodigo.requestFocus();
        } else if (txtHistoricoDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição do histórico!");
            txtHistoricoDescricao.requestFocus();
        } else if (!cbxMovimentaSaldoBancario.isSelected() && !cbxLancaEntrada.isSelected() && !cbxLancaSaida.isSelected() && !cbxContraPartida.isSelected()) {
            JOptionPane.showMessageDialog(null, "Marque o tipo de lançamento!");
            cbxLancaEntrada.requestFocus();
        } else if (cbxMovimentaSaldoBancario.isSelected() && txtBancoCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione o banco e a conta a ser movimentada!");
            btnPesquisarBanco.requestFocus();
        } else if (cbxMovimentaSaldoBancario.isSelected() && txtBancoDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Informe a descrição do banco!");
            txtBancoDescricao.requestFocus();
        } else if (cbxMovimentaSaldoBancario.isSelected() && txtContaCorrente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione a conta corrente a ser movimentada!");
            txtContaCorrente.requestFocus();
        } else if (incluindo == 1) {
            historico.setHistoricoCodigo(txtHistoricoCodigo.getText());
            historico.setHistoricoDescricao(txtHistoricoDescricao.getText().trim());

            if (cbxLancaEntrada.isSelected()) {
                historico.setTipoLancamento("E");
            } else if (cbxLancaSaida.isSelected()) {
                historico.setTipoLancamento("S");
            } else if (cbxContraPartida.isSelected()) {
                historico.setTipoLancamento("C");
            }

            if (cbxMovimentaDuplicatas.isSelected()) {
                historico.setMovimentaDuplicatas(1);
            } else {
                historico.setMovimentaDuplicatas(0);
            }

            if (cbxMovimentaCheque.isSelected()) {
                historico.setMovimentaCheque(1);
            } else {
                historico.setMovimentaCheque(0);
            }
                        
            if (cbxMovimentaSaldoBancario.isSelected()) {
                historico.setMovimentaSaldo(1);                
                historico.setBancoCodigo(txtBancoCodigo.getText());
                historico.setBancoDescricao(txtBancoDescricao.getText().trim());
                historico.setContaCorrente(txtContaCorrente.getText());
            } else {
                historico.setMovimentaSaldo(0);
                historico.setBancoCodigo("");
                historico.setBancoDescricao("");
                historico.setContaCorrente("");
            }
            
            if (cbxAtivo.isSelected()){
                historico.setAtivo(1);
            } else {
                historico.setAtivo(0);
            }

            dao.gravarHistorico(historico);
            limpaCampos();
            
        } else if (alterando == 1) {
            historico.setHistoricoCodigo(txtHistoricoCodigo.getText());
            historico.setHistoricoDescricao(txtHistoricoDescricao.getText().trim());

            if (cbxLancaEntrada.isSelected()) {
                historico.setTipoLancamento("E");
            } else if (cbxLancaSaida.isSelected()) {
                historico.setTipoLancamento("S");
            } else if (cbxContraPartida.isSelected()) {
                historico.setTipoLancamento("C");
            }
            
            if (cbxMovimentaDuplicatas.isSelected()) {
                historico.setMovimentaDuplicatas(1);
            } else {
                historico.setMovimentaDuplicatas(0);
            }
            
            if (cbxMovimentaCheque.isSelected()) {
                historico.setMovimentaCheque(1);
            } else {
                historico.setMovimentaCheque(0);
            }
                                    
            if (cbxMovimentaSaldoBancario.isSelected()) {
                historico.setMovimentaSaldo(1);                
                historico.setBancoCodigo(txtBancoCodigo.getText());
                historico.setBancoDescricao(txtBancoDescricao.getText().trim());
                historico.setContaCorrente(txtContaCorrente.getText());
            } else {
                historico.setMovimentaSaldo(0);
                historico.setBancoCodigo("");
                historico.setBancoDescricao("");
                historico.setContaCorrente("");
            }
            
            if (cbxAtivo.isSelected()){
                historico.setAtivo(1);
            } else {
                historico.setAtivo(0);
            }
            
            dao.alterarHistorico(historico);
            limpaCampos();
        };
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este cadastro?");
        if (resposta == JOptionPane.YES_OPTION) {
            historico.setHistoricoCodigo(txtHistoricoCodigo.getText());
            dao.excluirHistorico(this);
            limpaCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtHistoricoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHistoricoCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHistoricoCodigoKeyTyped

    private void cbxMovimentaSaldoBancarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMovimentaSaldoBancarioActionPerformed
        if (cbxMovimentaSaldoBancario.isSelected()) {
            txtBancoCodigo.setEnabled(true);
            txtBancoDescricao.setEnabled(true);
            txtContaCorrente.setEnabled(true);
            btnPesquisarBanco.setEnabled(true);
        } else {
            txtBancoCodigo.setEnabled(false);
            txtBancoDescricao.setEnabled(false);
            txtContaCorrente.setEnabled(false);
            btnPesquisarBanco.setEnabled(false);
        }
    }//GEN-LAST:event_cbxMovimentaSaldoBancarioActionPerformed

    private void btnPesquisaHistoricosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaHistoricosActionPerformed
        if (!txtPesquisaHistorico.getText().isEmpty()) {
            pesquisaHistoricos = new PesquisaHistoricos();
            pesquisaHistoricos.setLocationRelativeTo(null);
            pesquisaHistoricos.setVisible(true);
            pesquisaHistoricos.setResizable(false);
            pesquisaHistoricos.preencherTabela(this, null, null, "SELECT * FROM HISTORICO WHERE HISTORICODESCRICAO LIKE '%" + txtPesquisaHistorico.getText().trim() + "%' ORDER BY HISTORICODESCRICAO");
        } else {
            pesquisaHistoricos = new PesquisaHistoricos();
            pesquisaHistoricos.setLocationRelativeTo(null);
            pesquisaHistoricos.setVisible(true);
            pesquisaHistoricos.preencherTabela(this, null, null, "SELECT * FROM HISTORICOS ORDER BY HISTORICODESCRICAO");
        }
    }//GEN-LAST:event_btnPesquisaHistoricosActionPerformed

    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja abandonar a operação?");
        if (incluindo == 1 || alterando == 1 && resposta == JOptionPane.YES_OPTION) {
            limpaCampos();
            txtPesquisaHistorico.requestFocus();
        }
    }//GEN-LAST:event_btnAbandonarActionPerformed

    private void txtBancoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBancoCodigoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBancoCodigoKeyTyped

    private void txtContaCorrenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContaCorrenteKeyTyped
        String caracteres = "0987654321-";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContaCorrenteKeyTyped

    private void btnPesquisarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarBancoActionPerformed
        if (!txtBancoCodigo.getText().isEmpty() || !txtBancoDescricao.getText().isEmpty()) {
            pesquisaContasBancarias = new PesquisaContasBancarias();
            pesquisaContasBancarias.setLocationRelativeTo(null);
            pesquisaContasBancarias.setVisible(true);
            pesquisaContasBancarias.setResizable(false);
            pesquisaContasBancarias.preencherTabela(null, this, "SELECT * FROM CONTASBANCARIAS WHERE BANCOCODIGO = '" + txtBancoCodigo.getText() + "' OR BANCODESCRICAO LIKE '% "+txtBancoDescricao.getText().trim() +" %' ORDER BY BANCODESCRICAO");
        } else {
            pesquisaContasBancarias = new PesquisaContasBancarias();
            pesquisaContasBancarias.setLocationRelativeTo(null);
            pesquisaContasBancarias.setVisible(true);
            pesquisaContasBancarias.preencherTabela(null, this, "SELECT * FROM CONTASBANCARIAS ORDER BY BANCODESCRICAO");
        }        
    }//GEN-LAST:event_btnPesquisarBancoActionPerformed
    
    public void eliminarHistorico(BeansHistoricos historico) {
        int resposta;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este lançamento?");
        if (resposta == JOptionPane.YES_OPTION) {
            dao.excluirHistorico(this);
            limpaCampos();
        }
    }

    public void limpaCampos() {
        txtPesquisaHistorico.setText("");
        txtHistoricoCodigo.setText("");
        txtHistoricoDescricao.setText("");
        cbxLancaEntrada.setSelected(false);
        cbxLancaSaida.setSelected(false);
        cbxContraPartida.setSelected(false);
        cbxMovimentaDuplicatas.setSelected(false);
        cbxMovimentaCheque.setSelected(false); 
        cbxMovimentaSaldoBancario.setSelected(false);
        txtBancoCodigo.setText("");
        txtBancoDescricao.setText("");
        txtContaCorrente.setText("");
        incluindo = 1;
        alterando = 0;
        dao.gerarCodigoHistorico(this);
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
                new CadastroHistoricos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    public javax.swing.JButton btnExcluir;
    public javax.swing.JButton btnGravar;
    public javax.swing.JButton btnPesquisaHistoricos;
    private javax.swing.JButton btnPesquisarBanco;
    public javax.swing.JButton btnSair;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JCheckBox cbxAtivo;
    public javax.swing.JCheckBox cbxContraPartida;
    public javax.swing.JCheckBox cbxLancaEntrada;
    public javax.swing.JCheckBox cbxLancaSaida;
    public javax.swing.JCheckBox cbxMovimentaCheque;
    public javax.swing.JCheckBox cbxMovimentaDuplicatas;
    public javax.swing.JCheckBox cbxMovimentaSaldoBancario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JTextField txtBancoCodigo;
    public javax.swing.JTextField txtBancoDescricao;
    public javax.swing.JTextField txtContaCorrente;
    public javax.swing.JTextField txtHistoricoCodigo;
    public javax.swing.JTextField txtHistoricoDescricao;
    public javax.swing.JTextField txtPesquisaHistorico;
    // End of variables declaration//GEN-END:variables
}
