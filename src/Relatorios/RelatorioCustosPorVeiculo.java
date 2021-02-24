package Relatorios;

import ERP.view.PesquisaVeiculos;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import Beans.Teclas;
import Conection.ConectaBD;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioCustosPorVeiculo extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    PesquisaVeiculos pesquisaVeiculos = new PesquisaVeiculos();

    public RelatorioCustosPorVeiculo() {
        initComponents();
        txtPlaca.setDocument(new Teclas());
        txtModelo.setDocument(new Teclas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnProcurarVeiculo = new javax.swing.JButton();
        txtPlaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPeriodoVendaInicial = new javax.swing.JFormattedTextField();
        txtPeriodoVendaFinal = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Custos por Veículo");
        setName("frmRelatorioCustosVeiculo"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Modelo:");

        btnProcurarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btnProcurarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarVeiculoActionPerformed(evt);
            }
        });

        jLabel1.setText("Placa:");

        jLabel3.setText("Período de Venda:");

        try {
            txtPeriodoVendaInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtPeriodoVendaFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("a");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcurarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeriodoVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPeriodoVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnProcurarVeiculo)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPeriodoVendaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPeriodoVendaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSair, btnVisualizar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarVeiculoActionPerformed
        if (!txtPlaca.getText().isEmpty()) {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.setResizable(false);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS WHERE PLACA LIKE '%" + txtPlaca.getText().trim() + "%' ORDER BY MODELO");
        } else if (!txtModelo.getText().isEmpty()) {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.setResizable(false);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS WHERE MODELO LIKE '%" + txtModelo.getText().trim() + "%' ORDER BY MODELO");
        } else {
            pesquisaVeiculos = new PesquisaVeiculos();
            pesquisaVeiculos.setLocationRelativeTo(null);
            pesquisaVeiculos.setVisible(true);
            pesquisaVeiculos.preencherTabela(this, "SELECT * FROM VEICULOS ORDER BY MODELO");
        }
    }//GEN-LAST:event_btnProcurarVeiculoActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        conecta.conexao();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVendaInicial, dataVendaFinal;
        String placa = "", modelo = "", empresa = "";
        int dataVenda;
        HashMap filtro = new HashMap();

        //Filtro placa:
        if (!txtPlaca.getText().isEmpty()) {
            placa = txtPlaca.getText().trim();
        }
        filtro.put("placa", placa);

        //Filtro modelo:
        if (!txtModelo.getText().isEmpty()) {
            modelo = txtModelo.getText().trim();
        }
        filtro.put("modelo", modelo);

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
        
        //Filtro período de venda:
        if (txtPeriodoVendaInicial.getText().trim().length() == 10 || txtPeriodoVendaFinal.getText().trim().length() == 10) {
            dataVenda = 1;
            try {
                dataVendaInicial = format.parse(txtPeriodoVendaInicial.getText());
                dataVendaFinal = format.parse(txtPeriodoVendaFinal.getText());

                filtro.put("dataVenda", dataVenda);
                filtro.put("dataVendaInicial", dataVendaInicial);
                filtro.put("dataVendaFinal", dataVendaFinal);
            } catch (ParseException ex) {
                Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dataVenda = 2;
            filtro.put("dataVenda", dataVenda);
        }

        InputStream jasperFile;
        if (!txtPlaca.getText().isEmpty()){
            jasperFile = Thread.currentThread().getClass().getResourceAsStream("/Relatorios/CustosVeiculoDetalhado.jasper");
        } else {
            jasperFile = Thread.currentThread().getClass().getResourceAsStream("/Relatorios/CustosVeiculosTotal.jasper");
        }

        JasperPrint jPrint = null;
        try {
            jPrint = JasperFillManager.fillReport(jasperFile, filtro, conecta.con);
            JasperViewer view = new JasperViewer(jPrint, false);
            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

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
                new RelatorioCustosPorVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcurarVeiculo;
    private javax.swing.JButton btnSair;
    public javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtModelo;
    private javax.swing.JFormattedTextField txtPeriodoVendaFinal;
    private javax.swing.JFormattedTextField txtPeriodoVendaInicial;
    public javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
