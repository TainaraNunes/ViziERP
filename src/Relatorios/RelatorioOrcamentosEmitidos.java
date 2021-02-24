package Relatorios;

import ERP.view.PesquisaOrcamentos;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoFuncoes;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioOrcamentosEmitidos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    DaoFuncoes funcoes = new DaoFuncoes();
    PesquisaOrcamentos pesquisaOrcamentos = new PesquisaOrcamentos();
        
    public RelatorioOrcamentosEmitidos() {
        initComponents();
        txtCliente.setDocument(new Teclas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOrcamento = new javax.swing.JTextField();
        btnPesquisaOrcamento = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDataAberturaInicial = new javax.swing.JFormattedTextField();
        cmbSituacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataAberturaFinal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orçamentos Emitidos");
        setName("frmRelatorioOrcamentosEmitidos"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Orçamento:");

        txtOrcamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrcamentoKeyTyped(evt);
            }
        });

        btnPesquisaOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnPesquisaOrcamento.setName("frmRelatorioOrcamentosEmitidos"); // NOI18N
        btnPesquisaOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaOrcamentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data de Abertura:");

        try {
            txtDataAberturaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "ABERTO", "APROVADO", "CANCELADO", "FECHADO" }));

        jLabel4.setText("Situação:");

        jLabel2.setText("Cliente:");

        try {
            txtDataAberturaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisaOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDataAberturaInicial)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataAberturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDataAberturaFinal, txtDataAberturaInicial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisaOrcamento))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txtDataAberturaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataAberturaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
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
                .addComponent(btnVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSair, btnVisualizar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaOrcamentoActionPerformed
        if (!txtOrcamento.getText().isEmpty()) {
            pesquisaOrcamentos = new PesquisaOrcamentos();
            pesquisaOrcamentos.setLocationRelativeTo(null);
            pesquisaOrcamentos.setVisible(true);
            pesquisaOrcamentos.setResizable(false);

            pesquisaOrcamentos.preencherTabela(this, "SELECT ORCAMENTOS.NUMERO,           "
                                                    + "      ORCAMENTOS.CLIENTECODIGO,    "
                                                    + "      PESSOAS.RAZAOSOCIAL,         "
                                                    + "      FORMASPAGAMENTO.DESCRICAO AS FORMAPAGAMENTO, * "
                                                    + "FROM ORCAMENTOS "
                                                    + "JOIN PESSOAS ON (PESSOAS.CODIGO = ORCAMENTOS.CLIENTECODIGO) "
                                                    + "JOIN FORMASPAGAMENTO ON (FORMASPAGAMENTO.CODIGO = ORCAMENTOS.FORMAPAGAMENTO) "
                                                    + "WHERE ORCAMENTOS.NUMERO = " + Integer.parseInt(txtOrcamento.getText()) + " "
                                                    + "ORDER BY ORCAMENTOS.NUMERO, PESSOAS.RAZAOSOCIAL");
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
                                                    + "ORDER BY ORCAMENTOS.NUMERO, PESSOAS.RAZAOSOCIAL");
        }
    }//GEN-LAST:event_btnPesquisaOrcamentoActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        conecta.conexao();
        
        int orcamentoNumero = 0, orcamento, situacao, dataAbertura;
        String cliente = "", empresa = "";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAberturaInicial, dataAberturaFinal;
        HashMap filtro = new HashMap();

        //Filtro número do orçamento:
        if (!txtOrcamento.getText().isEmpty()) {
            orcamento = 1;
            filtro.put("orcamento", orcamento);

            orcamentoNumero = Integer.parseInt(txtOrcamento.getText());
            filtro.put("orcamentoNumero", orcamentoNumero);
        } else {
            orcamento = 2;
            filtro.put("orcamento", orcamento);        
        }        

        //Filtro período de abertura:
        if (txtDataAberturaInicial.getText().trim().length() == 10 || txtDataAberturaFinal.getText().trim().length() == 10) {
            dataAbertura = 1;
            try {
                dataAberturaInicial = format.parse(txtDataAberturaInicial.getText());
                dataAberturaFinal = format.parse(txtDataAberturaFinal.getText());

                filtro.put("dataAbertura", dataAbertura);
                filtro.put("dataAberturaInicial", dataAberturaInicial);
                filtro.put("dataAberturaFinal", dataAberturaFinal);
            } catch (ParseException ex) {
                Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dataAbertura = 2;
            filtro.put("dataAbertura", dataAbertura);
        }

        //Filtro Cliente: 
        if (!txtCliente.getText().isEmpty()) {
            cliente = txtCliente.getText().trim();
        }
        filtro.put("cliente", cliente);

        //Filtro Situação:
        if (cmbSituacao.getSelectedItem().equals("ABERTO")) {
            situacao = 1;
        } else if (cmbSituacao.getSelectedItem().equals("APROVADO")) {
            situacao = 2;
        } else if (cmbSituacao.getSelectedItem().equals("CANCELADO")) {
            situacao = 3;
        } else if (cmbSituacao.getSelectedItem().equals("FECHADO")) {
            situacao = 4;
        } else {
            situacao = 5;
        }
        filtro.put("situacao", situacao);

       //Filtro empresa:
        conecta.conexao();
        conecta.executaSql("SELECT * FROM EMPRESAS");

        try {
            if (conecta.rs.next()) {
                empresa = conecta.rs.getString("FANTASIA");
            } else {
                return;
            }
            filtro.put("empresa", empresa);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar empresas cadastradas: " + ex.getMessage());
        }

        InputStream jasperFile = Thread.currentThread().getClass().getResourceAsStream("/Relatorios/OrcamentosEmitidos.jasper");
        JasperPrint jPrint = null;

        try {
            jPrint = JasperFillManager.fillReport(jasperFile, filtro, conecta.con);
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
        }        
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void txtOrcamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrcamentoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtOrcamentoKeyTyped

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
                new RelatorioOrcamentosEmitidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnPesquisaOrcamento;
    public javax.swing.JButton btnSair;
    public javax.swing.JButton btnVisualizar;
    public javax.swing.JComboBox cmbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataAberturaFinal;
    public javax.swing.JFormattedTextField txtDataAberturaInicial;
    public javax.swing.JTextField txtOrcamento;
    // End of variables declaration//GEN-END:variables
}
