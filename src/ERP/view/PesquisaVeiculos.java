package ERP.view;

import Relatorios.RelatorioCustosPorVeiculo;
import Relatorios.RelatorioDespesasPorVeiculo;
import Relatorios.RelatorioEstoqueVeiculos;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import Beans.ModeloTabela;
import Conection.ConectaBD;
import DAO.DaoVeiculos;

public class PesquisaVeiculos extends javax.swing.JFrame {

    ConectaBD conecta = new ConectaBD();
    DaoVeiculos dao = new DaoVeiculos();
    
    private CadastroVeiculos cadastroVeiculos;
    private CustosVeiculos custosVeiculos;
    private DespesasVeiculos despesasVeiculos;
    private RelatorioDespesasPorVeiculo relatorioDespesasVeiculos;
    private RelatorioCustosPorVeiculo relatorioCustosVeiculo;
    private RelatorioEstoqueVeiculos relatorioEstoqueVeiculos;
    
    public PesquisaVeiculos() {
        initComponents();
    }
    
    public void preencherTabela(java.awt.Frame formulario, String Sql) {        
        if (formulario.getName().equals("frmCadastroVeiculos")){
            cadastroVeiculos = (CadastroVeiculos) formulario;
        } else if (formulario.getName().equals("frmDespesasVeiculos")){
            despesasVeiculos = (DespesasVeiculos) formulario;
        } else if (formulario.getName().equals("frmRelatorioDespesasVeiculos")){
            relatorioDespesasVeiculos = (RelatorioDespesasPorVeiculo) formulario;
        } else if (formulario.getName().equals("frmCustosVeiculos")){
            custosVeiculos = (CustosVeiculos) formulario;
        } else if (formulario.getName().equals("frmRelatorioCustosVeiculo")){
            relatorioCustosVeiculo = (RelatorioCustosPorVeiculo) formulario;
        } else if (formulario.getName().equals("frmRelatorioEstoqueVeiculos")){
            relatorioEstoqueVeiculos = (RelatorioEstoqueVeiculos) formulario;
        }
        
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Placa", "Marca", "Modelo", "Tipo", "Ano Fab", "Ano Mod"};
        conecta.conexao();
        conecta.executaSql(Sql);

        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{conecta.rs.getString("PLACA"), conecta.rs.getString("MARCA").trim(), conecta.rs.getString("MODELO").trim(), conecta.rs.getString("TIPO"), conecta.rs.getString("ANOFABRICACAO"), conecta.rs.getString("ANOMODELO"), 
                                       conecta.rs.getString("COR"), conecta.rs.getString("COMBUSTIVEL"), conecta.rs.getString("MOTOR"), conecta.rs.getString("CHASSI"), conecta.rs.getString("RENAVAM"), conecta.rs.getString("KM"), conecta.rs.getString("TRANSMISSAO"), 
                                       conecta.rs.getInt("EMESTOQUE"), conecta.rs.getString("OBSERVACOES"), conecta.rs.getString("DATACOMPRA"), conecta.rs.getString("PRECOCOMPRA"), conecta.rs.getString("CODIGO")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Nenhum veículo localizado!");
            this.dispose();
            conecta.desconecta();
        }
        
        ModeloTabela table = new ModeloTabela(dados, colunas);
        tblVeiculos.setModel(table);
        tblVeiculos.getColumnModel().getColumn(0).setPreferredWidth(50); 
        tblVeiculos.getColumnModel().getColumn(0).setResizable(false); 
        tblVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100); 
        tblVeiculos.getColumnModel().getColumn(1).setResizable(false); 
        tblVeiculos.getColumnModel().getColumn(2).setPreferredWidth(200); 
        tblVeiculos.getColumnModel().getColumn(2).setResizable(false); 
        tblVeiculos.getColumnModel().getColumn(3).setPreferredWidth(100); 
        tblVeiculos.getColumnModel().getColumn(3).setResizable(false); 
        tblVeiculos.getColumnModel().getColumn(4).setPreferredWidth(40); 
        tblVeiculos.getColumnModel().getColumn(4).setResizable(false); 
        tblVeiculos.getColumnModel().getColumn(5).setPreferredWidth(40); 
        tblVeiculos.getColumnModel().getColumn(5).setResizable(false);  
        
        tblVeiculos.getTableHeader().setReorderingAllowed(false); 
        tblVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conecta.desconecta();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Veículos");

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Modelo", "Tipo", "Ano Fab", "Ano Mod"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVeiculos);
        if (tblVeiculos.getColumnModel().getColumnCount() > 0) {
            tblVeiculos.getColumnModel().getColumn(0).setResizable(false);
            tblVeiculos.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblVeiculos.getColumnModel().getColumn(1).setResizable(false);
            tblVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblVeiculos.getColumnModel().getColumn(2).setResizable(false);
            tblVeiculos.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblVeiculos.getColumnModel().getColumn(3).setResizable(false);
            tblVeiculos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblVeiculos.getColumnModel().getColumn(4).setResizable(false);
            tblVeiculos.getColumnModel().getColumn(4).setPreferredWidth(5);
            tblVeiculos.getColumnModel().getColumn(5).setResizable(false);
            tblVeiculos.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeiculosMouseClicked
        int index = tblVeiculos.getSelectedRow();
        TableModel model = tblVeiculos.getModel();
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM VEICULOS WHERE CODIGO = '"+index+"'");
        try {
            conecta.rs.first();            
            String placa = model.getValueAt(index, 0).toString().trim();
            String marca = model.getValueAt(index, 1).toString().trim();
            String modelo = model.getValueAt(index, 2).toString().trim();
            String tipo = model.getValueAt(index, 3).toString().trim();
            String anoFab = model.getValueAt(index, 4).toString().trim();
            String anoMod = model.getValueAt(index, 5).toString().trim();
            String cor = model.getValueAt(index, 6).toString().trim();
            String combustivel = model.getValueAt(index, 7).toString().trim();
            String motor = model.getValueAt(index, 8).toString().trim();
            String chassi = model.getValueAt(index, 9).toString().trim();
            String renavam = model.getValueAt(index, 10).toString().trim();
            String km = model.getValueAt(index, 11).toString();
            String transmissao = model.getValueAt(index, 12).toString().trim();
            String emEstoque = model.getValueAt(index, 13).toString();
            String observacoes = model.getValueAt(index, 14).toString().trim();
            String dataCompra = "";
            if (model.getValueAt(index, 15) != null){
                dataCompra = model.getValueAt(index, 15).toString();
            }
            String precoCompra = "";
            if (model.getValueAt(index, 16) != null){
                precoCompra = model.getValueAt(index, 16).toString();
            } else {
                precoCompra = BigDecimal.ZERO.toString();
            }
            String codigo = model.getValueAt(index, 17).toString();
            
            //Chamada pelo cadastro de veículo;            
            if (cadastroVeiculos != null) {
                cadastroVeiculos.setVisible(true);
                cadastroVeiculos.pack();
                cadastroVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                cadastroVeiculos.txtPlaca.setText(placa);
                cadastroVeiculos.cmbMarca.getModel().setSelectedItem(marca);
                cadastroVeiculos.txtModelo.setText(modelo);
                cadastroVeiculos.cmbTipo.getModel().setSelectedItem(tipo);
                cadastroVeiculos.txtAnoFabricacao.setText(anoFab);
                cadastroVeiculos.txtAnoModelo.setText(anoMod);
                cadastroVeiculos.cmbCor.getModel().setSelectedItem(cor);
                cadastroVeiculos.cmbCombustivel.getModel().setSelectedItem(combustivel);
                cadastroVeiculos.txtMotor.setText(motor);
                cadastroVeiculos.txtChassi.setText(chassi);
                cadastroVeiculos.txtRenavam.setText(renavam);
                DecimalFormat df = new DecimalFormat("#,##0");
                cadastroVeiculos.txtKM.setText(df.format(new Double(km)));
                cadastroVeiculos.cmbTransmissao.getModel().setSelectedItem(transmissao);
                if (Integer.parseInt(emEstoque) == 1){
                    cadastroVeiculos.cbxEmEstoque.setSelected(true);
                } else {
                    cadastroVeiculos.cbxEmEstoque.setSelected(false);
                }
                cadastroVeiculos.txtObservacoes.setText(observacoes);

                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    if (!dataCompra.trim().isEmpty()) {
                        String resultadoDataCompra = formatoString.format(formatoBanco.parse(dataCompra));
                        cadastroVeiculos.txtDataCompra.setText(resultadoDataCompra);
                    } else {
                        cadastroVeiculos.txtDataCompra.setText("");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(PesquisaProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
                cadastroVeiculos.txtPrecoCompra.setText(nf.format(new BigDecimal(precoCompra)));
                
                cadastroVeiculos.txtCodigoVeiculo.setText(codigo);

                conecta.conexao();
                conecta.executaSql("SELECT * FROM VEICULOSOPCIONAIS WHERE VEICULOCODIGO = " + codigo + " ");

                try {
                    if (conecta.rs.next()) {    
                        if (conecta.rs.getInt("AIRBAG") == 1){
                            cadastroVeiculos.cbxAirBag.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxAirBag.setSelected(false);
                        }

                        if (conecta.rs.getInt("ALARME") == 1){
                            cadastroVeiculos.cbxAlarme.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxAlarme.setSelected(false);
                        }

                        if (conecta.rs.getInt("ALARMESONORORE") == 1){
                            cadastroVeiculos.cbxAlarmeSonoroRe.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxAlarmeSonoroRe.setSelected(false);
                        }

                        if (conecta.rs.getInt("ARCONDICIONADO") == 1){
                            cadastroVeiculos.cbxArCondicionado.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxArCondicionado.setSelected(false);
                        }

                        if (conecta.rs.getInt("CDPLAYER") == 1){
                            cadastroVeiculos.cbxCDPlayer.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxCDPlayer.setSelected(false);
                        }

                        if (conecta.rs.getInt("COMPUTADORBORDO") == 1){
                            cadastroVeiculos.cbxComputadorBordo.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxComputadorBordo.setSelected(false);
                        }

                        if (conecta.rs.getInt("DIRECAOHIDRAULICA") == 1){
                            cadastroVeiculos.cbxDirecaoHidraulica.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxDirecaoHidraulica.setSelected(false);
                        }

                        if (conecta.rs.getInt("FAROLMILHA") == 1){
                            cadastroVeiculos.cbxFarolMilha.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxFarolMilha.setSelected(false);
                        }

                        if (conecta.rs.getInt("FAROLNEBLINA") == 1){
                            cadastroVeiculos.cbxFarolNeblina.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxFarolNeblina.setSelected(false);
                        }

                        if (conecta.rs.getInt("FREIOABS") == 1){
                            cadastroVeiculos.cbxFreioABS.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxFreioABS.setSelected(false);
                        }

                        if (conecta.rs.getInt("PARABARROTRASEIRO") == 1){
                            cadastroVeiculos.cbxParabarroTraseiro.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxParabarroTraseiro.setSelected(false);
                        }

                        if (conecta.rs.getInt("REGULAGEMVOLANTE") == 1){
                            cadastroVeiculos.cbxRegulagemVolante.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxRegulagemVolante.setSelected(false);
                        }

                        if (conecta.rs.getInt("VIDROSELETRICOS") == 1){
                            cadastroVeiculos.cbxVidrosEletricos.setSelected(true);
                        } else {
                            cadastroVeiculos.cbxVidrosEletricos.setSelected(false);
                        }

                        if (!conecta.rs.getString("OUTROSOPCIONAIS").equals("")){
                            cadastroVeiculos.txtOutrosOpcionais.setText(conecta.rs.getString("OUTROSOPCIONAIS").trim());
                        } else {
                            cadastroVeiculos.txtOutrosOpcionais.setText("");
                        }                

                        cadastroVeiculos.alterando = 1;
                        cadastroVeiculos.incluindo = 0;
                        cadastroVeiculos.btnExcluir.setEnabled(true);
                        this.dispose();                        
                    } else {
                        cadastroVeiculos.alterando = 1;
                        cadastroVeiculos.incluindo = 0;
                        cadastroVeiculos.btnExcluir.setEnabled(true);
                        this.dispose();
                        return;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível carregar os opcionais do veículo! \n" + ex);
                }            
                conecta.desconecta();          
                
            //Chamada pelo lançamento de despesas de veículos;
            } else if (despesasVeiculos != null) {
                despesasVeiculos.setVisible(true);
                despesasVeiculos.pack();
                despesasVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                despesasVeiculos.veiculoCodigo = Integer.parseInt(codigo);
                despesasVeiculos.txtVeiculoPlaca.setText(placa);
                despesasVeiculos.txtVeiculoModelo.setText(modelo);
                               
                this.dispose();
                return;
                
            //Chamada pelo relatório de despesas de veículos;
            } else if (relatorioDespesasVeiculos != null) {
                relatorioDespesasVeiculos.setVisible(true);
                relatorioDespesasVeiculos.pack();
                relatorioDespesasVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                relatorioDespesasVeiculos.txtPlaca.setText(placa);
                relatorioDespesasVeiculos.txtModelo.setText(modelo);
                               
                this.dispose();
                return;
            
            //Chamada pelo lançamento de custos de veículos;
            } else if (custosVeiculos != null) {
                custosVeiculos.setVisible(true);
                custosVeiculos.pack();
                custosVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                custosVeiculos.veiculoCodigo = Integer.parseInt(codigo);
                custosVeiculos.txtVeiculoPlaca.setText(placa);
                custosVeiculos.txtVeiculoModelo.setText(modelo);
                
                custosVeiculos.consultarCustosVeiculos();
                custosVeiculos.btnExcluir.setEnabled(true); 
                custosVeiculos.btnAtualizarCustos.setEnabled(true); 

                this.dispose();
                return;

            //Chamada pelo relatório de custos por veículo;
            } else if (relatorioCustosVeiculo != null) {
                relatorioCustosVeiculo.setVisible(true);
                relatorioCustosVeiculo.pack();
                relatorioCustosVeiculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                relatorioCustosVeiculo.txtPlaca.setText(placa);
                relatorioCustosVeiculo.txtModelo.setText(modelo);
                               
                this.dispose();
                return;
            //Chamada pelo relatório de custos por veículo;
            } else if (relatorioEstoqueVeiculos != null) {
                relatorioEstoqueVeiculos.setVisible(true);
                relatorioEstoqueVeiculos.pack();
                relatorioEstoqueVeiculos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                relatorioEstoqueVeiculos.txtPlaca.setText(placa);
                relatorioEstoqueVeiculos.txtModelo.setText(modelo);
                               
                this.dispose();
                return;
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o cadastro do veículo! \n" + ex);
        }            
        conecta.desconecta();            
    }//GEN-LAST:event_tblVeiculosMouseClicked

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
                new PesquisaVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables
}
