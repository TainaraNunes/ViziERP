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
import Beans.BeansContasPagar;
import Conection.ConectaBD;
import ERP.view.LancamentoContasPagar;
import java.math.BigInteger;

public class DaoLancamentoContasPagar {

    ConectaBD conecta = new ConectaBD();
    BeansContasPagar beansContasPagar = new BeansContasPagar();

    public int gerarPlanilhaContasPagar() {
        int novaPlanilha = 0;

        conecta.conexao();
        conecta.executaSql("SELECT PLANILHA FROM CONTASPAGAR WHERE OPERACAO = '2000' ORDER BY PLANILHA DESC LIMIT 1");

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

    public void incluirDuplicataTabela(LancamentoContasPagar contasPagar) {
        String parcelaNumero = contasPagar.txtParcelaNumero.getText().trim();
        String dataVencimento = contasPagar.txtVencimentoParcela.getText();
        String valorDuplicata = contasPagar.txtValorParcela.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String acrescimos = contasPagar.txtAcrescimos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String descontos = contasPagar.txtDescontos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String totalPagar = contasPagar.txtValorTotalPagar.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        int proximoNumeroParcela = 0;
        
        DefaultTableModel valores = (DefaultTableModel) contasPagar.tblParcelas.getModel();
        valores.addRow(new Object[]{parcelaNumero, dataVencimento, valorDuplicata, acrescimos, descontos, totalPagar});

        if (parcelaNumero.contains("AVUL")){
            proximoNumeroParcela = Integer.parseInt(parcelaNumero.substring(4)) + 1; 
            contasPagar.txtParcelaNumero.setText("AVUL" + String.valueOf(String.format("%02d", proximoNumeroParcela)));
        } else {
            proximoNumeroParcela = Integer.parseInt(parcelaNumero) + 1; 
            contasPagar.txtParcelaNumero.setText(String.valueOf(String.format("%02d", proximoNumeroParcela)));
        }
        
        contasPagar.txtVencimentoParcela.setText("");
        contasPagar.txtValorParcela.setText("");
        contasPagar.txtAcrescimos.setText("");
        contasPagar.txtDescontos.setText("");
        contasPagar.txtValorTotalPagar.setText("");
        contasPagar.txtVencimentoParcela.requestFocus();
    }

    public void alterarDuplicataTabela(LancamentoContasPagar contasPagar) {
        if (contasPagar.tblParcelas.getSelectedRow() != -1) {
            contasPagar.tblParcelas.setValueAt(contasPagar.txtParcelaNumero.getText(), contasPagar.tblParcelas.getSelectedRow(), 0);
            contasPagar.tblParcelas.setValueAt(contasPagar.txtVencimentoParcela.getText(), contasPagar.tblParcelas.getSelectedRow(), 1);
            contasPagar.tblParcelas.setValueAt(contasPagar.txtValorParcela.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasPagar.tblParcelas.getSelectedRow(), 2);
            contasPagar.tblParcelas.setValueAt(contasPagar.txtAcrescimos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasPagar.tblParcelas.getSelectedRow(), 3);
            contasPagar.tblParcelas.setValueAt(contasPagar.txtDescontos.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasPagar.tblParcelas.getSelectedRow(), 4);
            contasPagar.tblParcelas.setValueAt(contasPagar.txtValorTotalPagar.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), contasPagar.tblParcelas.getSelectedRow(), 5);
        }

        contasPagar.txtParcelaNumero.setText("");
        contasPagar.txtParcelaNumero.requestFocus();
        contasPagar.txtVencimentoParcela.setText("");
        contasPagar.txtValorParcela.setText("");
        contasPagar.txtAcrescimos.setText("");
        contasPagar.txtDescontos.setText("");
        contasPagar.txtValorTotalPagar.setText("");
    }

    public void gravarDuplicatasPagar(BeansContasPagar beansContasPagar, LancamentoContasPagar contasPagar) {
        int imprimirPlanilha;
        conecta.conexao();

        try {
            if (contasPagar.alterando == 1) {
                /* Deleta somente o que não teve recebimentos para inserir o registro atualizado. */
                PreparedStatement pst2 = conecta.con.prepareStatement("DELETE FROM CONTASPAGAR WHERE PLANILHA = ?");
                pst2.setInt(1, beansContasPagar.getPlanilha());
                pst2.execute();
            }

            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CONTASPAGAR (PLANILHA, OPERACAO, DATALANCAMENTO, DOCUMENTONUMERO, VALORTOTALFATURA, FORMAPAGAMENTO, "
                                                               + "                         CATEGORIA, FORNECEDORCODIGO, PARCELANUMERO, DATAVENCIMENTO, VALORDUPLICATA, ACRESCIMOS, "
                                                               + "                         DESCONTOS, TOTALPAGAR, VALORPAGO, DATAPAGAMENTO, SITUACAO, USUARIO, OBSERVACOES) "
                                                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            if (contasPagar.incluindo == 1) {
                pst.setInt(1, gerarPlanilhaContasPagar());
                imprimirPlanilha = gerarPlanilhaContasPagar();
            } else {
                pst.setInt(1, beansContasPagar.getPlanilha());
                imprimirPlanilha = beansContasPagar.getPlanilha();
            }

            for (int x = 0; x < contasPagar.tblParcelas.getRowCount(); x++) {
                /* O sistema vai passar por todos os registros da tabela para inserir os valores. 
                 * Quando encontrar um registro, significa que teve recebimento e pula para a próxima linha. */                
                conecta.conexao();
                conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE PLANILHA = '" + imprimirPlanilha + "' AND DOCUMENTONUMERO = '" + beansContasPagar.getDocumentoNumero() + "' AND PARCELANUMERO = '" + contasPagar.tblParcelas.getValueAt(x, 0) + "'");

                if (conecta.rs.next()) {
                    continue;
                }

                pst.setString(2, beansContasPagar.getOperacao());
                pst.setDate(3, java.sql.Date.valueOf(beansContasPagar.getDataLancamento()));
                pst.setString(4, beansContasPagar.getDocumentoNumero());
                pst.setBigDecimal(5, beansContasPagar.getValorTotalFatura());
                pst.setInt(6, beansContasPagar.getFormaPagamento());
                pst.setString(7, beansContasPagar.getCategoria());
                pst.setInt(8, beansContasPagar.getFornecedorCodigo());
                pst.setString(9, ((String) contasPagar.tblParcelas.getValueAt(x, 0)).trim());

                String dataVencimento = contasPagar.tblParcelas.getValueAt(x, 1).toString();
                SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
                String resultadoDataVencimento;
                try {
                    resultadoDataVencimento = formatoBanco.format(formatoString.parse(dataVencimento));
                    pst.setDate(10, java.sql.Date.valueOf(resultadoDataVencimento));
                } catch (ParseException ex) {
                    Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
                }

                String vlrDuplicata = (String) contasPagar.tblParcelas.getValueAt(x, 2);
                BigDecimal valorDuplicata = new BigDecimal(vlrDuplicata);
                pst.setBigDecimal(11, valorDuplicata);

                String acrescimos = (String) contasPagar.tblParcelas.getValueAt(x, 3);
                BigDecimal valorAcrescimos = new BigDecimal(acrescimos);
                pst.setBigDecimal(12, valorAcrescimos);

                String descontos = (String) contasPagar.tblParcelas.getValueAt(x, 4);
                BigDecimal valorDescontos = new BigDecimal(descontos);
                pst.setBigDecimal(13, valorDescontos);
                
                String totalPagar = (String) contasPagar.tblParcelas.getValueAt(x, 5);
                BigDecimal valorTotalReceber = new BigDecimal(totalPagar);
                pst.setBigDecimal(14, valorTotalReceber);
                
                BigDecimal valorPago = new BigDecimal(BigInteger.ZERO); 
                pst.setBigDecimal(15, valorPago);                

                pst.setNull(16, 0);
                pst.setString(17, beansContasPagar.getSituacao());
                pst.setString(18, System.getProperty("usuario"));
                pst.setString(19, beansContasPagar.getObservacoes());
                
                pst.execute();
            }

            if (contasPagar.incluindo == 1) {
                JOptionPane.showMessageDialog(null, "Lançamento gravado com sucesso! Planilha: " + imprimirPlanilha);
            } else {
                JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso! Planilha: " + imprimirPlanilha);
            }

            contasPagar.limpaCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lançamento a pagar! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void excluirLancamentoPagar(LancamentoContasPagar contasPagar) {
        int planilha = Integer.parseInt(contasPagar.txtPlanilha.getText());
        String documentoNumero = contasPagar.txtDocumentoNumero.getText();
        int possuiPagamento = 0;

        conecta.conexao();
        try {
            for (int x = 0; x < contasPagar.tblParcelas.getRowCount(); x++) {
                /* Passa por todos os registros da tabela e verifica se alguma parcela já foi paga.
                 * Caso não, elimina o registro da duplicata se não volta para a tela. */ 
                conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE PLANILHA = '" + planilha + "' AND DOCUMENTONUMERO = '" + documentoNumero + "' AND PARCELANUMERO = '" + contasPagar.tblParcelas.getValueAt(x, 0) + "'");

                if (conecta.rs.next()) {
                    if (conecta.rs.getString("DATAPAGAMENTO") != null) {
                        possuiPagamento = possuiPagamento = 1;
                    } else {
                        possuiPagamento = 0;
                    }
                }
            }
            if (possuiPagamento == 0) {
                try {
                    PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CONTASPAGAR WHERE PLANILHA = ? AND DOCUMENTONUMERO = ?");
                    pst.setInt(1, planilha);
                    pst.setString(2, documentoNumero);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso!");
                    contasPagar.limpaCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao eliminar registro do banco de dados! \n" + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Documento possui parcela paga, não pode ser eliminada!");
                contasPagar.btnAbandonar.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* Valida se o valor total da fatura é igual a soma do valor das parcelas. 
    * Não considerando os acréscimos ou descontos. */
    public boolean validarTotais(LancamentoContasPagar contasPagar) {
        boolean resultado;
        BigDecimal totalDuplicatas = BigDecimal.ZERO;

        String valorFatura = (String) contasPagar.txtValorTotalFatura.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        BigDecimal totalFatura = new BigDecimal(valorFatura);

        for (int x = 0; x < contasPagar.tblParcelas.getRowCount(); x++) {
            String vlrDuplicata = (String) contasPagar.tblParcelas.getValueAt(x, 2);
            BigDecimal valorDuplicata = new BigDecimal(vlrDuplicata);
            totalDuplicatas = totalDuplicatas.add(valorDuplicata);
        }  

        if (totalFatura.compareTo(totalDuplicatas) == 0) {
            resultado = true;
        } else {
            resultado = false;
            JOptionPane.showMessageDialog(null, "Valor total da fatura é diferente da soma das parcelas. Verifique!");
        }

        return resultado;
    }

    public boolean validarDocumento(LancamentoContasPagar contasPagar) {
        String documentoNumero = contasPagar.txtDocumentoNumero.getText();
        String parcelaNumero = (String)(contasPagar.tblParcelas.getValueAt(0, 0));
        boolean habilitaLancamentoDocumento = true;

        conecta.conexao();
        conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE DOCUMENTONUMERO = '" +documentoNumero+ "' AND PARCELANUMERO = '" +parcelaNumero+ "' ");

        try {
            if (contasPagar.incluindo == 1 && conecta.rs.next()) {
                JOptionPane.showMessageDialog(null, "Documento já foi lançado. Verifique!");
                habilitaLancamentoDocumento = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }

        return habilitaLancamentoDocumento;
    }
}
