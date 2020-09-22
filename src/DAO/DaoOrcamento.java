package DAO;

import ERP.view.Orcamento;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Beans.BeansOrcamento;
import Conection.ConectaBD;

public class DaoOrcamento {

    ConectaBD conecta = new ConectaBD();
    BeansOrcamento orcamento = new BeansOrcamento();
    
    public int numeroOrcamento() {
        int novoOrcamento = 0;

        conecta.conexao();
        conecta.executaSql("SELECT NUMERO FROM ORCAMENTOS ORDER BY NUMERO DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                novoOrcamento = (conecta.rs.getInt("NUMERO")) + 1;
            } else {
                novoOrcamento = 396;   
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar número do orçamento! \n ERRO: " + ex);
        }

        conecta.desconecta();
        return novoOrcamento;
    }
    
    public void gravar(BeansOrcamento orc, Orcamento lancamentoOrcamento){
        conecta.conexao();
        boolean lGravar = true;

        try {
            conecta.con.setAutoCommit(false);

            if (lGravar && gravarOrcamento(orc, lancamentoOrcamento) == false) {
                lGravar = false;
            }
                        
            if (lGravar && gravarOrcamentoServicos(orc, lancamentoOrcamento) == false) {
                lGravar = false;    
            }

            if (lGravar && gravarOrcamentoPecas(orc, lancamentoOrcamento) == false) {
                lGravar = false;    
            }

            if (lGravar && gravarOrcamentoFinanceiro(orc, lancamentoOrcamento) == false) {
                lGravar = false;
            }

            if (lGravar) {
                conecta.con.commit();
                JOptionPane.showMessageDialog(null, "Orçamento " + orc.getOrcamentoNumero() + " gravado com sucesso!");
            } else{
                conecta.con.rollback();
                JOptionPane.showMessageDialog(null, "Orçamento " + orc.getOrcamentoNumero() + " não foi gravado!");            
            }
        } catch (SQLException ex) {
            try {
                conecta.con.rollback();
                JOptionPane.showMessageDialog(null, "Orçamento " + orc.getOrcamentoNumero() + " não foi gravado!");
            } catch (SQLException ex1) {
                Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }   

    public boolean gravarOrcamento(BeansOrcamento orc, Orcamento lancamentoOrcamento){
        //Grava os valores na tabela geral de orçamentos:
        conecta.executaSql("SELECT  * "                        
                         + "FROM ORCAMENTOS "
                         + "WHERE NUMERO = " + orc.getOrcamentoNumero() + " ");
            
        PreparedStatement pst;
        try {
            if (conecta.rs.first()){  
                pst = conecta.con.prepareStatement("UPDATE ORCAMENTOS "
                                                 + "SET DATAABERTURA = ?, DATAVALIDADE = ?, CLIENTECODIGO = ?, VALORTOTALSERVICOS = ?, "
                                                 + "VALORDESCONTOSERVICOS = ?, VALORTOTALORCAMENTO = ?, FORMAPAGAMENTO = ?, SITUACAO = ?, "
                                                 + "OBSERVACOES = ?, VERSAO = ?, VALORTOTALPECAS = ?, VALORDESCONTOSPECAS = ?, USUARIO = ? "
                                                 + "WHERE NUMERO = ? ");
                
                lancamentoOrcamento.incluindo = 0;
                lancamentoOrcamento.alterando = 1;
                
            } else {
               pst = conecta.con.prepareStatement("INSERT INTO ORCAMENTOS(DATAABERTURA, DATAVALIDADE, CLIENTECODIGO, VALORTOTALSERVICOS, VALORDESCONTOSERVICOS, "
                                                + "                       VALORTOTALORCAMENTO, FORMAPAGAMENTO, SITUACAO, OBSERVACOES, VERSAO, VALORTOTALPECAS, "
                                                + "                       VALORDESCONTOSPECAS, USUARIO, NUMERO)"
                                                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
                lancamentoOrcamento.incluindo = 1;
                lancamentoOrcamento.alterando = 0;
            }
            
            pst.setDate(1, new java.sql.Date(orc.getDataAbertura().getTime()));
            pst.setDate(2, Date.valueOf(orc.getDataValidade()));
            pst.setInt(3, orc.getClienteCodigo());
            pst.setBigDecimal(4, orc.getValorTotalServicos());
            pst.setBigDecimal(5, orc.getValorDescontoServicos());
            pst.setBigDecimal(6, orc.getValorTotalOrcamento());
            pst.setInt(7, orc.getFormaPagamento());
            pst.setString(8, orc.getSituacao());
            pst.setString(9, orc.getObservacoes());
            pst.setString(10, orc.getVersaoOrcamento());
            pst.setBigDecimal(11, orc.getValorTotalPecas());
            pst.setBigDecimal(12, orc.getValorDescontoPecas());
            pst.setString(13, System.getProperty("usuario"));
            pst.setInt(14, orc.getOrcamentoNumero());            
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar orçamento! \n ERRO: " + ex);
            return false;
        }
        return true;
    }
    
    public boolean gravarOrcamentoServicos(BeansOrcamento orc, Orcamento lancamentoOrcamento){
        //Carrega e grava os valores da tabela de OcamentoServicos:
        for (int x = 0; x < lancamentoOrcamento.tblServicos.getRowCount(); x++) {    
            String quantidadeCompartimentos = lancamentoOrcamento.tblServicos.getValueAt(x, 1).toString();
            String valorUnitarioServico = lancamentoOrcamento.tblServicos.getValueAt(x, 2).toString();
            String valorTotalServico = lancamentoOrcamento.tblServicos.getValueAt(x, 3).toString();
            String servicoCodigo = lancamentoOrcamento.tblServicos.getValueAt(x, 4).toString();

            orc.setServicoCodigo(Integer.parseInt(servicoCodigo));
            orc.setQuantidadeCompartimentos(Integer.parseInt(quantidadeCompartimentos));
            
            BigDecimal vlrUnitarioServico = new BigDecimal(valorUnitarioServico);
            orc.setServicoValorUnitario(vlrUnitarioServico);
            
            BigDecimal vlrTotalServico = new BigDecimal(valorTotalServico);
            orc.setServicoValorTotal(vlrTotalServico);
        
            conecta.executaSql("SELECT ORCAMENTOSSERVICOS.SERVICOCODIGO "                        
                             + "FROM ORCAMENTOSSERVICOS "
                             + "WHERE ORCAMENTONUMERO = " + orc.getOrcamentoNumero() + " AND SERVICOCODIGO = " + orc.getServicoCodigo() + " ");
            
            PreparedStatement pst;
            try {
                if (conecta.rs.first()){            
                    pst = conecta.con.prepareStatement("DELETE FROM ORCAMENTOSSERVICOS "
                                                     + "WHERE ORCAMENTONUMERO = " + orc.getOrcamentoNumero() + " ");
                    pst.execute();
                } 
                
                pst = conecta.con.prepareStatement("INSERT INTO ORCAMENTOSSERVICOS(QUANTIDADECOMPARTIMENTOS, VALORUNITARIOSERVICO, VALORTOTALSERVICO, ORCAMENTONUMERO, SERVICOCODIGO)"
                                                 + "VALUES (?, ?, ?, ?, ?)");

                pst.setInt(1, orc.getQuantidadeCompartimentos());
                pst.setBigDecimal(2, orc.getServicoValorUnitario());
                pst.setBigDecimal(3, orc.getServicoValorTotal());
                pst.setInt(4, orc.getOrcamentoNumero());
                pst.setInt(5, orc.getServicoCodigo());            
                pst.execute();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar os serviços do orçamento! \n ERRO: " + ex);
                return false;
            }
        }
        return true;
    }    

    public boolean gravarOrcamentoPecas(BeansOrcamento orc, Orcamento lancamentoOrcamento){
        //Carrega e grava os valores da tabela de OcamentoPecas:
        for (int x = 0; x < lancamentoOrcamento.tblPecas.getRowCount(); x++) {    
            String quantidade = lancamentoOrcamento.tblPecas.getValueAt(x, 1).toString();
            String valorUnitarioPeca = lancamentoOrcamento.tblPecas.getValueAt(x, 2).toString();
            String valorTotalPeca = lancamentoOrcamento.tblPecas.getValueAt(x, 3).toString();
            String pecaCodigo = lancamentoOrcamento.tblPecas.getValueAt(x, 4).toString();

            orc.setPecaCodigo(Integer.parseInt(pecaCodigo));
            orc.setPecaQuantidade(Integer.parseInt(quantidade));
    
            BigDecimal vlrUnitarioPeca = new BigDecimal(valorUnitarioPeca);
            orc.setPecaValorUnitario(vlrUnitarioPeca);
            
            BigDecimal vlrTotalPeca = new BigDecimal(valorTotalPeca);
            orc.setPecaValorTotal(vlrTotalPeca);
        
            conecta.executaSql("SELECT ORCAMENTOSPECAS.PECACODIGO "                        
                             + "FROM ORCAMENTOSPECAS "
                             + "WHERE ORCAMENTONUMERO = " + orc.getOrcamentoNumero() + " AND PECACODIGO = " + orc.getPecaCodigo() + " ");
            
            PreparedStatement pst;
            try {
                if (conecta.rs.first()){            
                    pst = conecta.con.prepareStatement("DELETE FROM ORCAMENTOSPECAS "
                                                     + "WHERE ORCAMENTONUMERO = " + orc.getOrcamentoNumero() + " ");
                    pst.execute();
                } 
                
                pst = conecta.con.prepareStatement("INSERT INTO ORCAMENTOSPECAS(QUANTIDADE, VALORUNITARIOPECA, VALORTOTALPECA, ORCAMENTONUMERO, PECACODIGO)"
                                                 + "VALUES (?, ?, ?, ?, ?)");

                pst.setInt(1, orc.getPecaQuantidade());
                pst.setBigDecimal(2, orc.getPecaValorUnitario());
                pst.setBigDecimal(3, orc.getPecaValorTotal());
                pst.setInt(4, orc.getOrcamentoNumero());
                pst.setInt(5, orc.getPecaCodigo());            
                pst.execute();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar as peças do orçamento! \n ERRO: " + ex);
                return false;
            }
        }
        return true;
    }    

    public boolean gravarOrcamentoFinanceiro(BeansOrcamento orc, Orcamento lancamentoOrcamento){
        //Carrega e grava os valores da tabela de OcamentoFinanceiro:
        for (int x = 0; x < lancamentoOrcamento.tblPagamentos.getRowCount(); x++) {
            String parcelaNumero = lancamentoOrcamento.tblPagamentos.getValueAt(x, 0).toString();
            String parcelaCondicao = lancamentoOrcamento.tblPagamentos.getValueAt(x, 1).toString();
            String vencimento = lancamentoOrcamento.tblPagamentos.getValueAt(x, 2).toString();
            String parcelaValor = lancamentoOrcamento.tblPagamentos.getValueAt(x, 3).toString().replace(" ", "");
            
            orc.setParcelaNumero(Integer.parseInt(parcelaNumero));
            orc.setParcelaCondicao(Integer.parseInt(parcelaCondicao));
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parcelaVencimento = LocalDate.parse(vencimento, formato);
            orc.setParcelaVencimento(parcelaVencimento);
            
            BigDecimal vlrParcela = new BigDecimal(parcelaValor);
            orc.setParcelaValor(vlrParcela);

            conecta.executaSql("SELECT * "                        
                             + "FROM ORCAMENTOSFINANCEIRO "
                             + "WHERE ORCAMENTONUMERO = " + orc.getOrcamentoNumero() + " AND "
                             + "      PARCELANUMERO = " + orc.getParcelaNumero() + " "); 

            PreparedStatement pst;
            try {
                if (conecta.rs.first()) {
                    pst = conecta.con.prepareStatement("DELETE FROM ORCAMENTOSFINANCEIRO "
                                                     + "WHERE ORCAMENTONUMERO = " + orc.getOrcamentoNumero() + " ");
                    pst.execute();
                }
                
                pst = conecta.con.prepareStatement("INSERT INTO ORCAMENTOSFINANCEIRO(ORCAMENTONUMERO, PARCELANUMERO, PARCELACONDICAO, VENCIMENTO, PARCELAVALOR)"
                                                 + "VALUES (?, ?, ?, ?, ?)");
                
                pst.setInt(1, orc.getOrcamentoNumero());
                pst.setInt(2, orc.getParcelaNumero());
                pst.setInt(3, orc.getParcelaCondicao());
                pst.setDate(4, Date.valueOf(orc.getParcelaVencimento()));
                pst.setBigDecimal(5, orc.getParcelaValor());            
                pst.execute();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar o parcelas do orçamento! \n ERRO: " + ex);
                return false;
            }
        }
        return true;
    }

    public boolean validarTotalParcelas(Orcamento lancamentoOrcamento){
        BigDecimal valorTotalParcelas = BigDecimal.ZERO;
        String totalOrcamento = lancamentoOrcamento.txtValorTotalOrcamento.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        BigDecimal valorTotalOrcamento = new BigDecimal(totalOrcamento);
        
        for (int x = 0; x < lancamentoOrcamento.tblPagamentos.getRowCount(); x++) {
            String parcelaValor = lancamentoOrcamento.tblPagamentos.getValueAt(x, 3).toString().replace(" ", "");
            valorTotalParcelas = valorTotalParcelas.add(new BigDecimal(parcelaValor));
        }
        
        if (valorTotalParcelas.compareTo(valorTotalOrcamento) != 0){
             JOptionPane.showMessageDialog(null, "Valor total das duplicatas está diferente do valor total do orçamento, verifique!");
             return false;
        }
        return true;
    }

    public boolean cancelarOrcamento(int orcamentoNumero){    
        conecta.conexao();
        try {            
            conecta.con.setAutoCommit(false);
            conecta.executaSql("SELECT * "                        
                             + "FROM ORCAMENTOS "
                             + "WHERE NUMERO = " + orcamentoNumero + "");

            if (conecta.rs.first()) {
                PreparedStatement pst = conecta.con.prepareStatement("UPDATE ORCAMENTOS "
                                                                    + "SET SITUACAO = 'CANCELADO' "
                                                                    + "WHERE NUMERO = ?");
                pst.setInt(1, orcamentoNumero);
                pst.execute();
                
                conecta.con.commit();
                JOptionPane.showMessageDialog(null, "Orçamento cancelado com sucesso!");
            }
        } catch (SQLException ex) {
            try {
                conecta.con.rollback();
                JOptionPane.showMessageDialog(null, "Orçamento " + orcamentoNumero + " não pôde ser cancelado!");
            } catch (SQLException ex1) {
                Logger.getLogger(DaoOrcamento.class.getName()).log(Level.SEVERE, null, ex1);
            }            
            return false;
        }
        conecta.desconecta();
        return true;        
    }       
}
