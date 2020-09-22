package DAO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Beans.BeansContasReceber;
import Conection.ConectaBD;
import ERP.view.LancamentoContasReceber;

public class DaoLancamentoContasReceber {

    ConectaBD conecta = new ConectaBD();
    BeansContasReceber beansContasReceber = new BeansContasReceber();

    public int gerarPlanilhaContasReceber() {
        int novaPlanilha = 0;

        conecta.conexao();
        conecta.executaSql("SELECT PLANILHA FROM CONTASRECEBER WHERE OPERACAO = '2001' ORDER BY PLANILHA DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                novaPlanilha = (conecta.rs.getInt("PLANILHA")) + 1;
            } else {
                novaPlanilha = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar planilhas! \n ERRO: " + ex);
        }

        conecta.desconecta();
        return novaPlanilha;
    }

    public void incluirDuplicataTabela(LancamentoContasReceber contasReceber) {
        String parcelaNumero = contasReceber.txtParcelaNumero.getText().trim();
        String dataVencimento = contasReceber.txtVencimentoParcela.getText();
        String valorDuplicata = contasReceber.txtValorParcela.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String acrescimos = contasReceber.txtAcrescimos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String descontos = contasReceber.txtDescontos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String totalReceber = contasReceber.txtValorTotalReceber.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        int proximoNumeroParcela = 0;
        
        DefaultTableModel valores = (DefaultTableModel) contasReceber.tblParcelas.getModel();
        valores.addRow(new Object[]{parcelaNumero, dataVencimento, valorDuplicata, acrescimos, descontos, totalReceber});

        if (parcelaNumero.contains("AVUL")){
            proximoNumeroParcela = Integer.parseInt(parcelaNumero.substring(4)) + 1; 
            contasReceber.txtParcelaNumero.setText("AVUL" + String.valueOf(String.format("%02d", proximoNumeroParcela)));
        } else {
            proximoNumeroParcela = Integer.parseInt(parcelaNumero) + 1; 
            contasReceber.txtParcelaNumero.setText(String.valueOf(String.format("%02d", proximoNumeroParcela)));
        }
        
        contasReceber.txtVencimentoParcela.setText("");
        contasReceber.txtValorParcela.setText("");
        contasReceber.txtAcrescimos.setText("");
        contasReceber.txtDescontos.setText("");
        contasReceber.txtValorTotalReceber.setText("");
        contasReceber.txtVencimentoParcela.requestFocus();
    }

    public void alterarDuplicataTabela(LancamentoContasReceber contasReceber) {
        if (contasReceber.tblParcelas.getSelectedRow() != -1) {
            contasReceber.tblParcelas.setValueAt(contasReceber.txtParcelaNumero.getText(), contasReceber.tblParcelas.getSelectedRow(), 0);
            contasReceber.tblParcelas.setValueAt(contasReceber.txtVencimentoParcela.getText(), contasReceber.tblParcelas.getSelectedRow(), 1);
            contasReceber.tblParcelas.setValueAt(contasReceber.txtValorParcela.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasReceber.tblParcelas.getSelectedRow(), 2);
            contasReceber.tblParcelas.setValueAt(contasReceber.txtAcrescimos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasReceber.tblParcelas.getSelectedRow(), 3);
            contasReceber.tblParcelas.setValueAt(contasReceber.txtDescontos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasReceber.tblParcelas.getSelectedRow(), 4);
            contasReceber.tblParcelas.setValueAt(contasReceber.txtValorTotalReceber.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasReceber.tblParcelas.getSelectedRow(), 5);
        }

        contasReceber.txtParcelaNumero.setText("");
        contasReceber.txtParcelaNumero.requestFocus();
        contasReceber.txtVencimentoParcela.setText("");
        contasReceber.txtValorParcela.setText("");
        contasReceber.txtAcrescimos.setText("");
        contasReceber.txtDescontos.setText("");
        contasReceber.txtValorTotalReceber.setText("");
    }

    public void gravarDuplicatasReceber(BeansContasReceber beansContasReceber, LancamentoContasReceber contasReceber) {
        int imprimirPlanilha;

        conecta.conexao();
        try {
            if (contasReceber.alterando == 1) {
                /*********************************************************************************
                 * Deleta somente o que não teve recebimentos para inserir o
                 * registro atualizado.  
                *********************************************************************************/
                PreparedStatement pst2 = conecta.con.prepareStatement("DELETE FROM CONTASRECEBER WHERE PLANILHA = ? AND DATARECEBIMENTO IS NULL");
                pst2.setInt(1, beansContasReceber.getPlanilha());
                pst2.execute();
            }

            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONTASRECEBER (PLANILHA, OPERACAO, DATALANCAMENTO, DOCUMENTONUMERO, VALORTOTALFATURA, FORMAPAGAMENTO, "
                                                                                          + "CATEGORIA, CLIENTECODIGO, PARCELANUMERO, DATAVENCIMENTO, VALORDUPLICATA, ACRESCIMOS, "
                                                                                          + "DESCONTOS, TOTALRECEBER, DATARECEBIMENTO, USUARIO) "
                                                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            if (contasReceber.incluindo == 1) {
                pst.setInt(1, gerarPlanilhaContasReceber());
                imprimirPlanilha = gerarPlanilhaContasReceber();
            } else {
                pst.setInt(1, beansContasReceber.getPlanilha());
                imprimirPlanilha = beansContasReceber.getPlanilha();
            }

            for (int x = 0; x < contasReceber.tblParcelas.getRowCount(); x++) {
            // O sistema vai passar por todos os registros da tabela para inserir os valores. 
            // Quando encontrar um registro, significa que teve recebimento e pula para a próxima linha. 
                conecta.conexao();
                conecta.executaSql("SELECT * FROM CONTASRECEBER WHERE PLANILHA = '" + imprimirPlanilha + "' AND DOCUMENTONUMERO = '" + beansContasReceber.getDocumentoNumero() + "' AND PARCELANUMERO = '" + contasReceber.tblParcelas.getValueAt(x, 0) + "'");

                if (conecta.rs.next()) {
                    continue;
                }

                pst.setString(2, beansContasReceber.getOperacao());
                pst.setDate(3, java.sql.Date.valueOf(beansContasReceber.getDataLancamento()));
                pst.setString(4, beansContasReceber.getDocumentoNumero());
                pst.setBigDecimal(5, beansContasReceber.getValorTotalFatura());
                pst.setInt(6, beansContasReceber.getFormaPagamento());
                pst.setString(7, beansContasReceber.getCategoria());
                pst.setInt(8, beansContasReceber.getClienteCodigo());
                pst.setString(9, ((String) contasReceber.tblParcelas.getValueAt(x, 0)).trim());

                String dataVencimento = contasReceber.tblParcelas.getValueAt(x, 1).toString();
                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                String resultadoDataVencimento;
                try {
                    resultadoDataVencimento = formatoBanco.format(formatoString.parse(dataVencimento));
                    pst.setDate(10, java.sql.Date.valueOf(resultadoDataVencimento));
                } catch (ParseException ex) {
                    Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
                }

                String vlrDuplicata = (String) contasReceber.tblParcelas.getValueAt(x, 2);
                BigDecimal valorDuplicata = new BigDecimal(vlrDuplicata);
                pst.setBigDecimal(11, valorDuplicata);

                String acrescimos = (String) contasReceber.tblParcelas.getValueAt(x, 3);
                BigDecimal valorAcrescimos = new BigDecimal(acrescimos);
                pst.setBigDecimal(12, valorAcrescimos);

                String descontos = (String) contasReceber.tblParcelas.getValueAt(x, 4);
                BigDecimal valorDescontos = new BigDecimal(descontos);
                pst.setBigDecimal(13, valorDescontos);

                String totalReceber = (String) contasReceber.tblParcelas.getValueAt(x, 5);
                BigDecimal valorTotalReceber = new BigDecimal(totalReceber);
                pst.setBigDecimal(14, valorTotalReceber);

                pst.setNull(15, 0);
                pst.setString(16, System.getProperty("usuario"));

                pst.execute();
            }

            if (contasReceber.incluindo == 1) {
                JOptionPane.showMessageDialog(null, "Lançamento gravado com sucesso! Planilha: " + imprimirPlanilha);
            } else {
                JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso! Planilha: " + imprimirPlanilha);
            }

            contasReceber.limpaCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lançamento a receber! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void excluirLancamentoReceber(LancamentoContasReceber contasReceber) {
        int possuiRecebimento = 0;
        int planilha = Integer.parseInt(contasReceber.txtPlanilha.getText());
        String documentoNumero = contasReceber.txtDocumentoNumero.getText();

        conecta.conexao();
        try {
            for (int x = 0; x < contasReceber.tblParcelas.getRowCount(); x++) {
                 /**************************************************************
                 * Passa por todos os registros da tabela e verifica se alguma
                 * parcela já foi recebida * caso não (possuiRecebimento == 0),
                 * elimina o registro da duplicata se não volta para a tela. 
                 ***************************************************************/
                conecta.executaSql("SELECT * FROM CONTASRECEBER "
                                 + "WHERE PLANILHA = '" + planilha + "' AND "
                                 + "      DOCUMENTONUMERO = '" + documentoNumero + "' AND "
                                 + "      PARCELANUMERO = '" + contasReceber.tblParcelas.getValueAt(x, 0) + "'");

                if (conecta.rs.next()) {
                    if (conecta.rs.getString("DATARECEBIMENTO") != null) {
                        possuiRecebimento = 1;
                    } else {
                        possuiRecebimento = 0;
                    }
                }
            }
            if (possuiRecebimento == 0) {
                try {
                    PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CONTASRECEBER "
                                                                       + "WHERE PLANILHA = ? AND DOCUMENTONUMERO = ? ");
                    pst.setInt(1, planilha);
                    pst.setString(2, documentoNumero);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso!");                    
                    contasReceber.limpaCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao eliminar registro do banco de dados! \n" + ex);
                }
        
                conecta.conexao();
                conecta.executaSql("SELECT * FROM ORCAMENTOS "
                                 + "WHERE NUMERO = " + documentoNumero + " ");
                
                if (conecta.rs.next()) {
                    try {
                        PreparedStatement pst = conecta.con.prepareStatement("UPDATE ORCAMENTOS "
                                                                           + "SET SITUACAO = 'ABERTO' "
                                                                           + "WHERE NUMERO = ? ");
                    pst.setInt(1, Integer.parseInt(documentoNumero));
                    pst.execute();
                    //JOptionPane.showMessageDialog(null, "Orçamento alterado para Aberto!");                    
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao voltar a situação do orçamento para 'Aberto'! \n" + ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Duplicata possui parcela com recebimento, não pode ser eliminada!");
                contasReceber.btnAbandonar.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarTotais(LancamentoContasReceber contasReceber) {
    /*************************************************************************
     * Valida se o valor total da fatura é igual a soma do valor das
     * parcelas. Não considerando os acréscimos ou descontos. 
     *************************************************************************/
        boolean resultado;
        BigDecimal totalDuplicatas = BigDecimal.ZERO;
        String valorFatura = (String) contasReceber.txtValorTotalFatura.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        BigDecimal totalFatura = new BigDecimal(valorFatura);

        for (int x = 0; x < contasReceber.tblParcelas.getRowCount(); x++) {
            String vlrDuplicata = (String) contasReceber.tblParcelas.getValueAt(x, 2);
            BigDecimal valorDuplicata = new BigDecimal(vlrDuplicata);
            totalDuplicatas = totalDuplicatas.add(valorDuplicata);
        }

        if (totalFatura.compareTo(totalDuplicatas) == 0) {
            resultado = true;
        } else {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Valor total da fatura é diferente da soma das duplicatas. Verifique!");
        }

        return resultado;
    }

    public boolean validarDocumento(LancamentoContasReceber contasReceber) {
        String documentoNumero = contasReceber.txtDocumentoNumero.getText();
        String parcelaNumero = (String)(contasReceber.tblParcelas.getValueAt(0, 0));
        boolean habilitaLancamentoDocumento = true;

        conecta.conexao();
        conecta.executaSql("SELECT * FROM CONTASRECEBER WHERE DOCUMENTONUMERO = '" +documentoNumero+ "' AND PARCELANUMERO = '" +parcelaNumero+ "' ");

        try {
            if (contasReceber.incluindo == 1 && conecta.rs.next()) {
                JOptionPane.showMessageDialog(null, "Documento já foi lançado. Verifique!");
                habilitaLancamentoDocumento = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }

        return habilitaLancamentoDocumento;
    }
}
