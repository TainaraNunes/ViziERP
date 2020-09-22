
package ERP.view;

import Beans.BeansVeiculos;
import Beans.Teclas;
import Conection.ConectaBD;
import DAO.DaoVeiculos;

public class VeiculosOpcionais extends javax.swing.JFrame {
    
    BeansVeiculos vei = new BeansVeiculos();
    ConectaBD conecta = new ConectaBD();
    DaoVeiculos dao = new DaoVeiculos();
    int opcionalAlarme;
    public VeiculosOpcionais() {
        initComponents();
        txtOutrosOpcionais.setDocument(new Teclas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOpcionaisGravar = new javax.swing.JButton();
        btnOpcionaisSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Opcionais de Veículos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel1.setText("Outros:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxComputadorBordo)
                            .addComponent(cbxDirecaoHidraulica)
                            .addComponent(cbxAirBag)
                            .addComponent(cbxAlarme)
                            .addComponent(cbxAlarmeSonoroRe)
                            .addComponent(cbxArCondicionado)
                            .addComponent(cbxCDPlayer))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRegulagemVolante)
                            .addComponent(cbxVidrosEletricos)
                            .addComponent(cbxParabarroTraseiro)
                            .addComponent(cbxFreioABS)
                            .addComponent(cbxFarolNeblina)
                            .addComponent(cbxFarolMilha))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOutrosOpcionais)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAirBag)
                    .addComponent(cbxFarolMilha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAlarme)
                    .addComponent(cbxFarolNeblina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAlarmeSonoroRe)
                    .addComponent(cbxFreioABS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxArCondicionado)
                    .addComponent(cbxParabarroTraseiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCDPlayer)
                    .addComponent(cbxVidrosEletricos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxComputadorBordo)
                    .addComponent(cbxRegulagemVolante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxDirecaoHidraulica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOutrosOpcionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnOpcionaisGravar.setText("Gravar");
        btnOpcionaisGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionaisGravarActionPerformed(evt);
            }
        });

        btnOpcionaisSair.setText("Sair");
        btnOpcionaisSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionaisSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOpcionaisGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpcionaisSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnOpcionaisGravar, btnOpcionaisSair});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcionaisGravar)
                    .addComponent(btnOpcionaisSair))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxComputadorBordoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxComputadorBordoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxComputadorBordoActionPerformed

    private void btnOpcionaisGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionaisGravarActionPerformed
        carregarValoresOpcionais();
        this.dispose();
    }//GEN-LAST:event_btnOpcionaisGravarActionPerformed

    private void btnOpcionaisSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionaisSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOpcionaisSairActionPerformed

    public void carregarValoresOpcionais(){
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VeiculosOpcionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculosOpcionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculosOpcionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculosOpcionais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculosOpcionais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnOpcionaisGravar;
    public javax.swing.JButton btnOpcionaisSair;
    public javax.swing.JCheckBox cbxAirBag;
    public javax.swing.JCheckBox cbxAlarme;
    public javax.swing.JCheckBox cbxAlarmeSonoroRe;
    public javax.swing.JCheckBox cbxArCondicionado;
    public javax.swing.JCheckBox cbxCDPlayer;
    public javax.swing.JCheckBox cbxComputadorBordo;
    public javax.swing.JCheckBox cbxDirecaoHidraulica;
    public javax.swing.JCheckBox cbxFarolMilha;
    public javax.swing.JCheckBox cbxFarolNeblina;
    public javax.swing.JCheckBox cbxFreioABS;
    public javax.swing.JCheckBox cbxParabarroTraseiro;
    public javax.swing.JCheckBox cbxRegulagemVolante;
    public javax.swing.JCheckBox cbxVidrosEletricos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtOutrosOpcionais;
    // End of variables declaration//GEN-END:variables
}
