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

public class DaoLancamentoCaixa {
    
    ConectaBD conecta = new ConectaBD();
    BeansLancamentoCaixa lanca = new BeansLancamentoCaixa();
    
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
    
    public void gravarLancamentoCaixa(BeansLancamentoCaixa lanca, LancamentoCaixa lancamentoCaixa) {
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
            
            pst2.execute();

            //Passa a planilha, o histórico, valor, data de lançamento e se é inclusão ou alteração, para atualizar o saldo da conta com o valor do lançamento.
            if (lancamentoCaixa.incluindo == 1) {            
                atualizaSaldoBancario(imprimirPlanilha, lanca.getContraPartida(), lanca.getValor(), lanca.getDataLancamento(), "incluindo");
            } else {
                atualizaSaldoBancario(imprimirPlanilha, lanca.getContraPartida(), lanca.getValor(), lanca.getDataLancamento(), "alterando");
            }    

            //Passa o número da parcela, a data que deve ser atualizada e que está inluindo para pegar a data do lançamento.
            if (!lanca.getDocumentoNumero().isEmpty() && !lanca.getParcelaNumero().isEmpty()) {
                atualizaDataRecebimentoPagamento(lanca.getDocumentoNumero(), lanca.getParcelaNumero(), lanca.getPessoaCodigo(), java.sql.Date.valueOf(lanca.getDataLancamento()), "incluindo");
            }
            
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
    
    public void excluirLancamentoCaixa(BeansLancamentoCaixa beanslanca) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM LANCAMENTOCAIXA WHERE PLANILHA = ?");
            pst.setInt(1, beanslanca.getPlanilha());
            
            //Passa o número da parcela, a data que deve ser atualizada e que está eliminado para remover a data de recebimento/pagamento.
            if (!beanslanca.getDocumentoNumero().isEmpty()) {
                atualizaDataRecebimentoPagamento(beanslanca.getDocumentoNumero(), beanslanca.getParcelaNumero(), beanslanca.getPessoaCodigo(), null, "excluindo");
            }
            
            //Passa a planilha para atualizar o saldo da conta com o valor do lançamento.
            atualizaSaldoBancario(beanslanca.getPlanilha(), beanslanca.getContraPartida(), beanslanca.getValor(), beanslanca.getDataLancamento(), "excluindo");
            
            pst.execute();            
            
            JOptionPane.showMessageDialog(null, "Lançamento eliminado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Problemas ao eliminar o lançamento! \n ERRO: " + ex);
        }
        conecta.desconecta();        
    }    
  
    public void atualizaSaldoBancario(int planilhaCaixa, String historico, BigDecimal valor, LocalDate dataLancamento, String incluindoExcluindo) {
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

//    public void atualizaSaldoBancario(int planilha, String incluindoExcluindo) {
//        BigDecimal saldoAtual = BigDecimal.ZERO;
//
//        conecta.conexao();
//        conecta.executaSql("SELECT HISTORICOOPERACAO.HISTORICOCODIGO AS OPERACAO, "
//                         + "       HISTORICOCONTRAPARTIDA.HISTORICOCODIGO AS CONTRAPARTIDA, "
//                         + "       HISTORICOOPERACAO.TIPOLANCAMENTO AS TIPOLANCAMENTO, "
//                         + "       LANCAMENTOCAIXA.VALOR AS VALORLANCAMENTO "
//                         + "FROM LANCAMENTOCAIXA "
//                         + "     JOIN HISTORICOS AS HISTORICOOPERACAO ON (LANCAMENTOCAIXA.OPERACAO = HISTORICOOPERACAO.HISTORICOCODIGO) "
//                         + "     JOIN HISTORICOS AS HISTORICOCONTRAPARTIDA ON (LANCAMENTOCAIXA.CONTRAPARTIDA = HISTORICOCONTRAPARTIDA.HISTORICOCODIGO) "
//                         + "WHERE PLANILHA = " + planilha + "");
//
//        try {
//            if (conecta.rs.next()) {
//                BigDecimal saldoAnterior = new BigDecimal(conecta.rs.getString("SALDO"));
//                BigDecimal valorLancamento = new BigDecimal(conecta.rs.getString("VALORLANCAMENTO"));
//
//                if (incluindoExcluindo.equals("incluindo")) {
//                    if (conecta.rs.getString("TIPOLANCAMENTO").equals("S")) {
//                        saldoAtual = saldoAnterior.subtract(valorLancamento);
//                    } else {
//                        saldoAtual = saldoAnterior.add(valorLancamento);
//                    }
//                } else {
//                    if (conecta.rs.getString("TIPOLANCAMENTO").equals("S")) {
//                        saldoAtual = saldoAnterior.add(valorLancamento);
//                    } else {
//                        saldoAtual = saldoAnterior.subtract(valorLancamento);
//                    }
//                }
//
//                PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTA SET SALDOATUAL = ? WHERE HISTORICOCODIGO = ? ");
//                pst.setBigDecimal(1, saldoAtual);
//                pst.setString(2, (conecta.rs.getString("CONTRAPARTIDA")));
//                pst.execute();
//
//            } else {
//                return;
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao calcular saldo de estoque do produto! \n ERRO: " + ex);
//        }
//
//        conecta.desconecta();
//    }    
//        BigDecimal saldoAtual = BigDecimal.ZERO;
//        
//        conecta.conexao();
//        conecta.executaSql("SELECT HISTORICOOPERACAO.HISTORICOCODIGO AS OPERACAO, "
//                         + "       HISTORICOCONTRAPARTIDA.HISTORICOCODIGO AS CONTRAPARTIDA, "
//                         + "       HISTORICOOPERACAO.TIPOLANCAMENTO AS TIPOLANCAMENTO, "
//                         + "       LANCAMENTOCAIXA.VALOR AS VALORLANCAMENTO "
//                         + "FROM LANCAMENTOCAIXA "
//                         + "     JOIN HISTORICOS AS HISTORICOOPERACAO ON (LANCAMENTOCAIXA.OPERACAO = HISTORICOOPERACAO.HISTORICOCODIGO) "
//                         + "     JOIN HISTORICOS AS HISTORICOCONTRAPARTIDA ON (LANCAMENTOCAIXA.CONTRAPARTIDA = HISTORICOCONTRAPARTIDA.HISTORICOCODIGO) "
//                         + "WHERE PLANILHA = " + planilha + "");
//        
//        try {
//            if (conecta.rs.next()) {
//                BigDecimal saldoAnterior = new BigDecimal(conecta.rs.getString("SALDO"));
//                BigDecimal valorLancamento = new BigDecimal(conecta.rs.getString("VALORLANCAMENTO"));
//                
//                if (incluindoExcluindo.equals("incluindo")) {
//                    if (conecta.rs.getString("TIPOLANCAMENTO").equals("S")) {
//                        saldoAtual = saldoAnterior.subtract(valorLancamento);
//                    } else {
//                        saldoAtual = saldoAnterior.add(valorLancamento);
//                    }                
//                } else {
//                    if (conecta.rs.getString("TIPOLANCAMENTO").equals("S")) {
//                        saldoAtual = saldoAnterior.add(valorLancamento);
//                    } else {
//                        saldoAtual = saldoAnterior.subtract(valorLancamento);
//                    }                
//                }
//                
//                PreparedStatement pst = conecta.con.prepareStatement("UPDATE CONTA SET SALDOATUAL = ? WHERE HISTORICOCODIGO = ? ");
//                pst.setBigDecimal(1, saldoAtual);
//                pst.setString(2, (conecta.rs.getString("CONTRAPARTIDA")));
//                pst.execute();
//                
//            } else {
//                return;
//            }            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao calcular saldo de estoque do produto! \n ERRO: " + ex);
//        }
//        
//        conecta.desconecta();
//    }    
    
    public void atualizaDataRecebimentoPagamento(String documentoNumero, String parcelaNumero, int pessoaCodigo, java.sql.Date dataLancamento , String incluindoExcluindo) {
        PreparedStatement pst = null;
        conecta.conexao();
        conecta.executaSql("SELECT * FROM CONTASRECEBER WHERE DOCUMENTONUMERO = '" + documentoNumero + "' AND PARCELANUMERO = '" + parcelaNumero + "' AND CLIENTECODIGO = '"+ pessoaCodigo +"'");        
        try {
            if (conecta.rs.next()) {
                pst = conecta.con.prepareStatement("UPDATE CONTASRECEBER SET DATARECEBIMENTO = ? WHERE DOCUMENTONUMERO = ? AND PARCELANUMERO = ? AND CLIENTECODIGO = ?");
            } else {
                pst = conecta.con.prepareStatement("UPDATE CONTASPAGAR SET DATAPAGAMENTO = ? WHERE DOCUMENTONUMERO = ? AND PARCELANUMERO = ? AND FORNECEDORCODIGO = ? ");
            }
                
            pst.setDate(1, dataLancamento);
            pst.setString(2, documentoNumero);
            pst.setString(3, parcelaNumero);
            pst.setInt(4, pessoaCodigo);
            pst.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}