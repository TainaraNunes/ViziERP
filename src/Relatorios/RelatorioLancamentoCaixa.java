package Relatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
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
import static Conection.ConectaBD.Read;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioLancamentoCaixa extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();

    public RelatorioLancamentoCaixa() {
        initComponents();

        Date d = new Date();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        d = c.getTime();

        txtDataLancamentoInicial.setText(format.format(d));
        txtDataLancamentoFinal.setText(format.format(new Date()));

        txtClienteFornecedor.setDocument(new Teclas());

        popularComboHistoricos();
        popularComboContraPartida();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDataLancamentoInicial = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDataLancamentoFinal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbHistorico = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbContraPartida = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtClienteFornecedor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnVisualizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Lançamentos de Caixa");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Período de Lançamento:");

        try {
            txtDataLancamentoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("a");

        try {
            txtDataLancamentoFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("Histórico:");

        cmbHistorico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));

        jLabel4.setText("Contra Partida:");

        cmbContraPartida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));

        jLabel5.setText("Cliente/Fornecedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataLancamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataLancamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE))
                    .addComponent(cmbContraPartida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbHistorico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtClienteFornecedor))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDataLancamentoFinal, txtDataLancamentoInicial});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDataLancamentoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataLancamentoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(cmbHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbContraPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtClienteFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVisualizar.setText("Visualizar");
        btnVisualizar.setAlignmentX(0.5F);
        btnVisualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.setAlignmentX(0.5F);
        btnSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                .addGap(99, 99, 99)
                .addComponent(btnVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSair, btnVisualizar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        InputStream arquivoconexao = null;
        try {
            String diretorio = System.getProperty("user.dir");
            if(diretorio.contains("Vizipostos")){
                arquivoconexao = Thread.currentThread().getClass().getResourceAsStream("/modeloConection/conexaovizipostos.txt");            
            } else {
                arquivoconexao = Thread.currentThread().getClass().getResourceAsStream("/modeloConection/conexaovizitrucks.txt");            
            }

            InputStreamReader arquivo = new InputStreamReader(arquivoconexao);
            BufferedReader buffer = new BufferedReader(arquivo);            
            String conteudo = buffer.readLine();

            String driver = conteudo.split(";")[0];
            String caminhoBanco = conteudo.split(";")[1];
            String usuarioBanco = conteudo.split(";")[2];
            String senha = conteudo.split(";")[3];
            Connection conn = null;

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dataLancamentoInicial, dataLancamentoFinal;
            int historico, contraPartida;
            String historicoWhere = "", contraPartidaWhere = "", clienteFornecedor = "", empresa = "";
            HashMap filtro = new HashMap();

            //Filtro período de lançamento:
            if (txtDataLancamentoInicial.getText().trim().length() == 10 || txtDataLancamentoFinal.getText().trim().length() == 10) {
                try {
                    dataLancamentoInicial = format.parse(txtDataLancamentoInicial.getText());
                    dataLancamentoFinal = format.parse(txtDataLancamentoFinal.getText());

                    filtro.put("dataLancamentoInicial", dataLancamentoInicial);
                    filtro.put("dataLancamentoFinal", dataLancamentoFinal);
                } catch (ParseException ex) {
                    Logger.getLogger(RelatorioContasReceber.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe o período de vencimento para consultar!");
                txtDataLancamentoInicial.requestFocus();
            }

            //Filtro histórico:
            if (cmbHistorico.getSelectedItem().toString().trim().equals("TODOS")) {
                historico = 1;
            } else {
                historico = 2;
                historicoWhere = cmbHistorico.getSelectedItem().toString().trim();
            }
            filtro.put("historico", historico);
            filtro.put("historicoWhere", historicoWhere);

            //Filtro contra partida:
            if (cmbContraPartida.getSelectedItem().toString().trim().equals("TODOS")) {
                contraPartida = 1;
            } else {
                contraPartida = 2;
                contraPartidaWhere = cmbContraPartida.getSelectedItem().toString().trim();
            }
            filtro.put("contraPartida", contraPartida);
            filtro.put("contraPartidaWhere", contraPartidaWhere);

            //Filtro cliente;fornecedor:
            if (!txtClienteFornecedor.getText().isEmpty()) {
                clienteFornecedor = txtClienteFornecedor.getText().trim();
            }
            filtro.put("clienteFornecedor", clienteFornecedor);

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

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(caminhoBanco, usuarioBanco, senha);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RelatorioLancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioLancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            }

            InputStream jasperFile = Thread.currentThread().getClass().getResourceAsStream("/Relatorios/LancamentoCaixa.jasper");
            JasperPrint jPrint = null;       

            try {
                jPrint = JasperFillManager.fillReport(jasperFile, filtro, conn);
                JasperViewer view = new JasperViewer(jPrint, false);
                view.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + ex.getMessage());
            }
        } catch (IOException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }            
    }

    private void popularComboHistoricos() {
        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOCODIGO, HISTORICODESCRICAO FROM HISTORICOS WHERE TIPOLANCAMENTO = 'E' OR TIPOLANCAMENTO = 'S' ORDER BY HISTORICODESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbHistorico.addItem(conecta.rs.getString("HISTORICODESCRICAO"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar históricos cadastrados! \n ERRO: " + ex);
        }
    }

    private void popularComboContraPartida() {
        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOCODIGO, HISTORICODESCRICAO FROM HISTORICOS WHERE TIPOLANCAMENTO = 'C' ORDER BY HISTORICODESCRICAO");

        try {
            conecta.rs.first();
            do {
                cmbContraPartida.addItem(conecta.rs.getString("HISTORICODESCRICAO"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar históricos cadastrados! \n ERRO: " + ex);
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
                new RelatorioLancamentoCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox cmbContraPartida;
    private javax.swing.JComboBox cmbHistorico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtClienteFornecedor;
    private javax.swing.JFormattedTextField txtDataLancamentoFinal;
    private javax.swing.JFormattedTextField txtDataLancamentoInicial;
    // End of variables declaration//GEN-END:variables
}
