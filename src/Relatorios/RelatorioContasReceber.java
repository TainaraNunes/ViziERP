package Relatorios;

import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.Teclas;
import Conection.ConectaBD;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioContasReceber extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();

    public RelatorioContasReceber() {
        initComponents();

        Date d = new Date();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        d = c.getTime();

        txtDataVencimentoInicial.setText(format.format(d));
        txtDataVencimentoFinal.setText(format.format(new Date()));
        txtCliente.setDocument(new Teclas());
        
        popularComboFormasPagamento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDataVencimentoInicial = new javax.swing.JFormattedTextField();
        txtDataVencimentoFinal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbFormasPagamento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtDataRecebimentoInicial = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDataRecebimentoFinal = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Contas a Receber");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Período de Vencimento:");

        try {
            txtDataVencimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVencimentoInicial.setToolTipText("");

        try {
            txtDataVencimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("a");

        jLabel3.setText("Situação:");

        cmbSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AMBAS", "PENDENTES", "LIQUIDADAS" }));

        jLabel4.setText("Forma de Pagamento:");

        cmbFormasPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));

        jLabel5.setText("Período de Recebimento:");

        try {
            txtDataRecebimentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("a");

        try {
            txtDataRecebimentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Cliente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbFormasPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataRecebimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataRecebimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCliente))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDataRecebimentoFinal, txtDataRecebimentoInicial, txtDataVencimentoFinal, txtDataVencimentoInicial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtDataVencimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtDataVencimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataRecebimentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtDataRecebimentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFormasPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSair, btnVisualizar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        this.gerarRelatorio();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    public void gerarRelatorio() {
        String empresa = "", cliente = "";
        int situacao, formaPagamento, formaPagamentoWhere = 0, dataRecebimento;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVencimentoInicial, dataVencimentoFinal, dataRecebimentoInicial, dataRecebimentoFinal;
        HashMap filtro = new HashMap();

        //Filtro período de vencimento:
        if (txtDataVencimentoInicial.getText().trim().length() == 10 || txtDataVencimentoFinal.getText().trim().length() == 10) {
            try {
                dataVencimentoInicial = format.parse(txtDataVencimentoInicial.getText());
                dataVencimentoFinal = format.parse(txtDataVencimentoFinal.getText());

                filtro.put("dataVencimentoInicial", dataVencimentoInicial);
                filtro.put("dataVencimentoFinal", dataVencimentoFinal);
            } catch (ParseException ex) {
                Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o período de vencimento para consultar!");
            txtDataVencimentoInicial.requestFocus();
        }

        //Filtro período de recebimento: Se não possui data de recebimento manda o parâmetro verdadeiro.
        if (txtDataRecebimentoInicial.getText().trim().length() == 10 || txtDataRecebimentoFinal.getText().trim().length() == 10) {
            dataRecebimento = 1;
            try {
                dataRecebimentoInicial = format.parse(txtDataRecebimentoInicial.getText());
                dataRecebimentoFinal = format.parse(txtDataRecebimentoFinal.getText());

                filtro.put("dataRecebimento", dataRecebimento);
                filtro.put("dataRecebimentoInicial", dataRecebimentoInicial);
                filtro.put("dataRecebimentoFinal", dataRecebimentoFinal);
            } catch (ParseException ex) {
                Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dataRecebimento = 2;
            filtro.put("dataRecebimento", dataRecebimento);
        }

        //Filtro cliente:
        if (!txtCliente.getText().isEmpty()) {
            cliente = txtCliente.getText().trim();
        }
        filtro.put("cliente", cliente);

        //Filtro situação:
        if (cmbSituacao.getSelectedItem().equals("PENDENTES")) {
            situacao = 1;
        } else if (cmbSituacao.getSelectedItem().equals("LIQUIDADAS")) {
            situacao = 2;
        } else {
            situacao = 0;
        }
        filtro.put("situacao", situacao);

        //Filtro forma de pagamento:
        if (cmbFormasPagamento.getSelectedItem().toString().trim().equals("TODOS")) {
            formaPagamento = 1;
        } else {
            formaPagamento = 2;

            conecta.conexao();
            conecta.executaSql("SELECT * FROM FORMASPAGAMENTO WHERE DESCRICAO = '" + cmbFormasPagamento.getSelectedItem().toString().trim() + "'");

            try {
                if (conecta.rs.first()) {
                    formaPagamentoWhere = conecta.rs.getInt("CODIGO");
                }
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        filtro.put("formaPagamento", formaPagamento);
        filtro.put("formaPagamentoWhere", formaPagamentoWhere);

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

        InputStream jasperFile = Thread.currentThread().getClass().getResourceAsStream("/Relatorios/ContasReceber.jasper");
        JasperPrint jPrint = null;

        try {
            jPrint = JasperFillManager.fillReport(jasperFile, filtro, conecta.con);
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
        }
    }

    private void popularComboFormasPagamento() {
        conecta.conexao();
        conecta.executaSql("SELECT CODIGO, DESCRICAO FROM FORMASPAGAMENTO ORDER BY DESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbFormasPagamento.addItem(conecta.rs.getString("DESCRICAO").trim());
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar formas de pagamento cadastradas! \n ERRO: " + ex);
        }
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
                new RelatorioContasReceber().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox cmbFormasPagamento;
    private javax.swing.JComboBox cmbSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtDataRecebimentoFinal;
    private javax.swing.JFormattedTextField txtDataRecebimentoInicial;
    private javax.swing.JFormattedTextField txtDataVencimentoFinal;
    private javax.swing.JFormattedTextField txtDataVencimentoInicial;
    // End of variables declaration//GEN-END:variables
}
