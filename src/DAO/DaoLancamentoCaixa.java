package DAO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Beans.BeansLancamentoCaixa;
import Conection.ConectaBD;
import ERP.view.LancamentoCaixa;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DaoLancamentoCaixa {
    
    ConectaBD conecta = new ConectaBD();
    BeansLancamentoCaixa lanca = new BeansLancamentoCaixa();
    DaoCheques daoCheque = new DaoCheques();
        
    public int gerarPlanilhaLancamento() {
        int planilha = 0;
        
        conecta.conexao();
        conecta.executaSql("SELECT PLANILHA FROM LANCAMENTOCAIXA ORDER BY PLANILHA DESC LIMIT 1");
        
        try {
            if (conecta.rs.next()) {
                planilha = (conecta.rs.getInt("PLANILHA")) + 1;
            } else {
                planilha = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar planilhas! \n ERRO: " + ex);
        }
        
        conecta.desconecta();
        return planilha;
    }
    
    public void lancamentoCaixaGravar(BeansLancamentoCaixa lanca, LancamentoCaixa lancamentoCaixa) {
        int imprimirPlanilha = 0;
        
        conecta.conexao();
        try {
            if (lancamentoCaixa.alterando == 1) {
                PreparedStatement pst1 = conecta.con.prepareStatement("DELETE FROM LANCAMENTOCAIXA WHERE PLANILHA = ?");
                pst1.setInt(1, lanca.getPlanilha());
                pst1.execute();                
            }
            
            PreparedStatement pst2 = conecta.con.prepareStatement("INSERT INTO LANCAMENTOCAIXA(PLANILHA, DATALANCAMENTO, OPERACAO, CONTRAPARTIDA, PESSOACODIGO, DOCUMENTONUMERO, PARCELANUMERO, VALOR, OBSERVACOES, USUARIO) "
                                                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            if (lancamentoCaixa.incluindo == 1) {
                pst2.setInt(1, gerarPlanilhaLancamento());
                imprimirPlanilha = gerarPlanilhaLancamento();
            } else {
                pst2.setInt(1, lanca.getPlanilha());
                imprimirPlanilha = lanca.getPlanilha();
            }
            
            pst2.setInt(1, imprimirPlanilha);
            pst2.setDate(2, java.sql.Date.valueOf(lanca.getDataLancamento()));
            pst2.setString(3, lanca.getOperacao());
            pst2.setString(4, lanca.getContraPartida());
            pst2.setInt(5, lanca.getPessoaCodigo());
            pst2.setString(6, lanca.getDocumentoNumero());
            pst2.setString(7, lanca.getParcelaNumero().trim());
            pst2.setBigDecimal(8, lanca.getValor());            
            pst2.setString(9, lanca.getObservacoes());
            pst2.setString(10, System.getProperty("usuario"));           

            //Passa a planilha, o histórico, valor, data de lançamento e se é inclusão ou alteração, para atualizar o saldo da conta com o valor do lançamento.
            if (lancamentoCaixa.incluindo == 1) {            
                saldoBancarioAtualizar(imprimirPlanilha, lanca.getContraPartida(), lanca.getValor(), lanca.getDataLancamento(), "incluindo");
            } else {
                saldoBancarioAtualizar(imprimirPlanilha, lanca.getContraPartida(), lanca.getValor(), lanca.getDataLancamento(), "alterando");
            }    

            //Passa o número da parcela, a data que deve ser atualizada e que está inluindo para pegar a data do lançamento.
//            if (!lanca.getDocumentoNumero().isEmpty() && !lanca.getParcelaNumero().isEmpty()) {
//                if (duplicataAtualizar(lanca.getDocumentoNumero(), lanca.getParcelaNumero(), lanca.getPessoaCodigo(), lanca.getValor(), java.sql.Date.valueOf(lanca.getDataLancamento()), "incluindo", lanca.getOperacao().trim()) == false) {
//                    lancamentoCaixa.txtHistorico.requestFocus();
//                    return;
//                }
//            }

             if (!lanca.getDocumentoNumero().isEmpty() && !lanca.getParcelaNumero().isEmpty()) {
                if (duplicataAtualizar(lanca, lancamentoCaixa)) {
                    lancamentoCaixa.txtHistorico.requestFocus();
                    return;
                }
            }
            chequeAtualizar(lancamentoCaixa.chequeNumero, lancamentoCaixa.bancoCodigo, java.sql.Date.valueOf(lanca.getDataLancamento()), lanca.getDocumentoNumero(), lanca.getParcelaNumero());
            
            pst2.execute();
            
            if (lancamentoCaixa.incluindo == 1) {
                JOptionPane.showMessageDialog(null, "Lançamento gravado com sucesso! Planilha: " + imprimirPlanilha);
            } else {
                JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso! Planilha: " + imprimirPlanilha);
            }            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lançamento no caixa! \n ERRO: " + ex);
        }
        
        conecta.desconecta();
    }
    
    public void lancamentoCaixaEliminar(BeansLancamentoCaixa beanslanca) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LANCAMENTOCAIXA WHERE PLANILHA = ?");
            pst.setInt(1, beanslanca.getPlanilha());
            
            //Passa o número da parcela, a data que deve ser atualizada e que está eliminado para remover a data de recebimento/pagamento.
            if (!beanslanca.getDocumentoNumero().isEmpty()) {
                duplicataAtualizar(beanslanca.getDocumentoNumero(), beanslanca.getParcelaNumero(), beanslanca.getPessoaCodigo(), BigDecimal.ZERO, null, "excluindo", beanslanca.getOperacao().trim());
            }
            
            //Passa a planilha para atualizar o saldo da conta com o valor do lançamento.
            saldoBancarioAtualizar(beanslanca.getPlanilha(), beanslanca.getContraPartida(), beanslanca.getValor(), beanslanca.getDataLancamento(), "excluindo");
            
            pst.execute();            
            
            JOptionPane.showMessageDialog(null, "Lançamento eliminado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problemas ao eliminar o lançamento! \n ERRO: " + ex);
        }
        conecta.desconecta();        
    }    
  
    public void saldoBancarioAtualizar(int planilhaCaixa, String historico, BigDecimal valor, LocalDate dataLancamento, String incluindoExcluindo) {
        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOS.HISTORICOCODIGO, "
                         + "       HISTORICOS.HISTORICODESCRICAO, "
                         + "       HISTORICOS.CONTACORRENTE, "
                         + "       CONTASBANCARIAS.SALDOATUAL, "
                         + "       HISTORICOS.TIPOLANCAMENTO "
                         + "FROM HISTORICOS "
                         + "JOIN CONTASBANCARIAS ON (HISTORICOS.BANCOCODIGO = CONTASBANCARIAS.BANCOCODIGO AND "
                         + "                         HISTORICOS.CONTACORRENTE = CONTASBANCARIAS.CONTACORRENTE) "
                         + "WHERE HISTORICOCODIGO = '" + historico + "'");               
        try {
            if (conecta.rs.next()) {
                BigDecimal saldoAnterior = new BigDecimal(conecta.rs.getString("SALDOATUAL"));
                BigDecimal saldoAtual = new BigDecimal(BigInteger.ZERO);
                String contaCorrente = conecta.rs.getString("CONTACORRENTE").trim();
                                
                conecta.executaSql("SELECT HISTORICOOPERACAO.HISTORICOCODIGO AS OPERACAO, "
                                 + "       HISTORICOCONTRAPARTIDA.HISTORICOCODIGO AS CONTRAPARTIDA, "
                                 + "       HISTORICOOPERACAO.TIPOLANCAMENTO AS TIPOLANCAMENTO, "
                                 + "       LANCAMENTOCAIXA.VALOR AS VALORLANCAMENTO, "
                                 + "       LANCAMENTOCAIXA.DATALANCAMENTO AS DATALANCAMENTO "
                                 + "FROM LANCAMENTOCAIXA "
                                 + "     JOIN HISTORICOS AS HISTORICOOPERACAO ON (LANCAMENTOCAIXA.OPERACAO = HISTORICOOPERACAO.HISTORICOCODIGO) "
                                 + "     JOIN HISTORICOS AS HISTORICOCONTRAPARTIDA ON (LANCAMENTOCAIXA.CONTRAPARTIDA = HISTORICOCONTRAPARTIDA.HISTORICOCODIGO) "
                                 + "WHERE PLANILHA = " + planilhaCaixa + "");
                
                if (conecta.rs.next()) {
                    String tipoLancamento = conecta.rs.getString("TIPOLANCAMENTO");
                    
                    if (incluindoExcluindo.equals("incluindo")) {
                        if (tipoLancamento.equals("S")) {
                            saldoAtual = saldoAnterior.subtract(valor);
                        } else {
                            saldoAtual = saldoAnterior.add(valor);
                        }
                    } else if (incluindoExcluindo.equals("excluindo")) {
                        if (tipoLancamento.equals("S")) {
                            saldoAtual = saldoAnterior.add(valor);
                        } else {
                            saldoAtual = saldoAnterior.subtract(valor);
                        }
                    } else if (incluindoExcluindo.equals("alterando")) {
                        conecta.conexao();
                        conecta.executaSql("SELECT * FROM LANCAMENTOSCONTASBANCARIAS WHERE PLANILHALANCAMENTOCAIXA = " + planilhaCaixa + "");
                    
                        if (conecta.rs.next()) {
                            if (tipoLancamento.equals("S")) {
                                saldoAtual = conecta.rs.getBigDecimal("SALDOANTERIOR").subtract(valor);
                            } else {
                                saldoAtual = conecta.rs.getBigDecimal("SALDOANTERIOR").add(valor);
                            }
                        }
                    }
                    
                    PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO LANCAMENTOSCONTASBANCARIAS(PLANILHALANCAMENTOCAIXA, CONTA, SALDOANTERIOR, SALDOATUAL, DATALANCAMENTO, VALORLANCAMENTO) "
                                                                       + "VALUES (?, ?, ?, ?, ?, ?)");
                    pst.setInt(1, planilhaCaixa);
                    pst.setString(2, contaCorrente);
                    pst.setBigDecimal(3, saldoAnterior);
                    pst.setBigDecimal(4, saldoAtual);
                    pst.setDate(5, java.sql.Date.valueOf(dataLancamento));
                    pst.setBigDecimal(6, valor);
                    pst.execute();

                    PreparedStatement pst2 = conecta.con.prepareStatement("UPDATE CONTASBANCARIAS SET SALDOATUAL = ? WHERE CONTACORRENTE = ? ");
                    pst2.setBigDecimal(1, saldoAtual);
                    pst2.setString(2, contaCorrente);
                    pst2.execute();
                }
            } else {
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conecta.desconecta();
    }

    //public boolean duplicataAtualizar(String documentoNumero, String parcelaNumero, int pessoaCodigo, BigDecimal valorRecebido, java.sql.Date dataLancamento , String incluindoExcluindo, String historico) {
    public boolean duplicataAtualizar(BeansLancamentoCaixa beans, LancamentoCaixa lancamentoCaixa) {
        PreparedStatement pst = null;       
        String situacao;
        String historico = lancamentoCaixa.txtHistorico.getText().trim();
                
        BigDecimal valorRecebidoTotal, valorPagoTotal;
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM HISTORICOS WHERE HISTORICODESCRICAO = '" + historico + "'") ;
        try {
            if (conecta.rs.next()){
                if (conecta.rs.getString("TIPOLANCAMENTO").equals("E")) { 
                    conecta.conexao();
                    conecta.executaSql("SELECT * FROM CONTASRECEBER "
                                     + "WHERE DOCUMENTONUMERO = '" + beans.getDocumentoNumero() + "' AND "
                                     + "      PARCELANUMERO = '" + beans.getParcelaNumero() + "' AND "
                                     + "      CLIENTECODIGO = '" + beans.getPessoaCodigo() + "' ");
                    
                    if (conecta.rs.next()) {
                        valorRecebidoTotal = conecta.rs.getBigDecimal("VALORRECEBIDO").add(lancamentoCaixa.);
                        
                        if (valorRecebidoTotal.compareTo(conecta.rs.getBigDecimal("TOTALRECEBER")) == 0){
                            situacao = "L";
                        } else {
                            situacao = "PR";
                        }
                        
                        pst = conecta.con.prepareStatement("INSERT INTO CONTASRECEBER (PLANILHA, OPERACAO, DATALANCAMENTO, DOCUMENTONUMERO, VALORTOTALFATURA, FORMAPAGAMENTO, "
                                                         + "                           CATEGORIA, CLIENTECODIGO, PARCELANUMERO, DATAVENCIMENTO, VALORDUPLICATA, ACRESCIMOS, "
                                                         + "                           DESCONTOS, TOTALRECEBER, VALORRECEBIDO, DATARECEBIMENTO, SITUACAO, USUARIO, OBSERVACOES) "
                                                         + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                        pst.setString(1, conecta.rs.getString("PLANILHA")); 
                        pst.setString(2, conecta.rs.getString("OPERACAO"));
                        pst.setDate(3, conecta.rs.getDate("DATALANCAMENTO"));
                        pst.setString(4, conecta.rs.getString("DOCUMENTONUMERO"));
                        pst.setBigDecimal(5, conecta.rs.getBigDecimal("VALORTOTALFATURA"));
                        pst.setInt(6, conecta.rs.getInt("FORMAPAGAMENTO"));
                        pst.setString(7, conecta.rs.getString("CATEGORIA"));
                        pst.setInt(8, conecta.rs.getInt("CLIENTECODIGO"));
                        pst.setString(9, conecta.rs.getString("PARCELANUMERO"));
                        pst.setDate(10, conecta.rs.getDate("DATAVENCIMENTO"));
                        pst.setBigDecimal(11, conecta.rs.getBigDecimal("VALORDUPLICATA"));
                        pst.setBigDecimal(12, conecta.rs.getBigDecimal("ACRESCIMOS"));
                        pst.setBigDecimal(13, conecta.rs.getBigDecimal("DESCONTOS"));
                        pst.setBigDecimal(14, conecta.rs.getBigDecimal("TOTALRECEBER"));

                        BigDecimal valorRecebido = new BigDecimal(BigInteger.ZERO); 
                        pst.setBigDecimal(15, valorRecebido);

                        pst.setNull(16, 0);                
                        pst.setString(17, beansContasReceber.getSituacao());
                        pst.setString(18, System.getProperty("usuario"));
                        pst.setString(19, beansContasReceber.getObservacoes());

                        pst.execute();

//                        pst = conecta.con.prepareStatement("UPDATE CONTASRECEBER "
//                                                         + "SET DATARECEBIMENTO = ?, "
//                                                         + "    VALORRECEBIDO = ?, " 
//                                                         + "    SITUACAO = '" + situacao + "' "
//                                                         + "WHERE DOCUMENTONUMERO = ? AND "
//                                                         + "      PARCELANUMERO = ? AND "
//                                                         + "      CLIENTECODIGO = ? ");
//
//                        pst.setDate(1, dataLancamento);
//                        pst.setBigDecimal(2, valorRecebidoTotal);
//                        pst.setString(3, documentoNumero);
//                        pst.setString(4, parcelaNumero);
//                        pst.setInt(5, pessoaCodigo);
//                        pst.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Duplicata não encontrada no contas a receber!");
                        return false;
                    }
                } else if (conecta.rs.getString("TIPOLANCAMENTO").equals("S")){
                    conecta.conexao();
                    conecta.executaSql("SELECT * FROM CONTASPAGAR "
                                     + "WHERE DOCUMENTONUMERO = '" + documentoNumero + "' AND "
                                     + "      PARCELANUMERO = '" + parcelaNumero + "' AND "
                                     + "      FORNECEDORCODIGO = '" + pessoaCodigo + "' ");
                    if (conecta.rs.next()) {
                        valorPagoTotal = conecta.rs.getBigDecimal("VALORPAGO").add(valorRecebido);
                        
                        if (valorPagoTotal.compareTo(conecta.rs.getBigDecimal("TOTALPAGAR")) == 0){
                            situacao = "L";
                        } else {
                            situacao = "PP";
                        }
                        
                        pst = conecta.con.prepareStatement("UPDATE CONTASPAGAR "
                                                         + "SET DATAPAGAMENTO = ?, "
                                                         + "    VALORPAGO = ?, " 
                                                         + "    SITUACAO = '" + situacao + "' "
                                                         + "WHERE DOCUMENTONUMERO = ? AND "
                                                         + "      PARCELANUMERO = ? AND "
                                                         + "      FORNECEDORCODIGO = ? ");
                        
                        pst.setDate(1, dataLancamento);
                        pst.setBigDecimal(2, valorPagoTotal);
                        pst.setString(3, documentoNumero);
                        pst.setString(4, parcelaNumero);
                        pst.setInt(5, pessoaCodigo);
                        pst.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Duplicata não encontrada no contas a pagar!");
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma duplicata a pagar ou receber com as condições informadas!");
                    return false;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar duplicatas a receber e a pagar! \n ERRO: " + ex);
        }        

        return true;
    }
    
    public void chequeAtualizar(String chequeNumero, String bancoCodigo, java.sql.Date dataSituacao, String documento, String parcelaNumero){
        conecta.conexao();
        try {                        
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CHEQUES SET SITUACAO = 'RECEBIDO', "
                                                               + "                   SITUACAODATA = ?, "
                                                               + "                   DOCUMENTO = ?, "
                                                               + "                   PARCELANUMERO = ? "
                                                               + "WHERE NUMERO = ? AND BANCO = ? ") ;
            pst.setDate(1, dataSituacao);
            pst.setString(2, documento);
            pst.setString(3, parcelaNumero);
            pst.setString(4, chequeNumero);
            pst.setString(5, bancoCodigo);
            pst.execute();

            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados do cheque! \n ERRO: " + ex);
        }
    }
}