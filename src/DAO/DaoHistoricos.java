package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Beans.BeansHistoricos;
import Conection.ConectaBD;
import ERP.view.CadastroHistoricos;

public class DaoHistoricos {

    ConectaBD conecta = new ConectaBD();
    BeansHistoricos historico = new BeansHistoricos();

    public int incluindo = 1;
    public int alterando = 0;

    public void gravarHistorico(BeansHistoricos historico) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO HISTORICOS(HISTORICOCODIGO, HISTORICODESCRICAO, TIPOLANCAMENTO, MOVIMENTADUPLICATAS, MOVIMENTACHEQUE, MOVIMENTASALDOBANCARIO, BANCOCODIGO, BANCODESCRICAO, CONTACORRENTE, ATIVO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, historico.getHistoricoCodigo());
            pst.setString(2, historico.getHistoricoDescricao().trim());
            pst.setString(3, historico.getTipoLancamento());
            pst.setInt(4, historico.getMovimentaDuplicatas());
            pst.setInt(5, historico.getMovimentaCheque());
            pst.setInt(6, historico.getMovimentaSaldoBancario());
            pst.setString(7, historico.getBancoCodigo());
            pst.setString(8, historico.getBancoDescricao().trim());
            pst.setString(9, historico.getContaCorrente().trim());
            pst.setInt(10, historico.getAtivo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Histórico gravado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void alterarHistorico(BeansHistoricos historico) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE HISTORICOS SET HISTORICODESCRICAO = ?, "
                                                               + "                      TIPOLANCAMENTO = ?, "
                                                               + "                      MOVIMENTADUPLICATAS = ?, "
                                                               + "                      MOVIMENTACHEQUE = ?, "
                                                               + "                      MOVIMENTASALDOBANCARIO = ?, "
                                                               + "                      BANCOCODIGO = ?, "
                                                               + "                      BANCODESCRICAO = ?, "
                                                               + "                      CONTACORRENTE = ?, "
                                                               + "                      ATIVO = ? "
                                                               + "WHERE HISTORICOCODIGO = ?");
            
            pst.setString(1, historico.getHistoricoDescricao().trim());
            pst.setString(2, historico.getTipoLancamento());
            pst.setInt(3, historico.getMovimentaDuplicatas());
            pst.setInt(4, historico.getMovimentaCheque());
            pst.setInt(5, historico.getMovimentaSaldoBancario());
            pst.setString(6, historico.getBancoCodigo());
            pst.setString(7, historico.getBancoDescricao().trim());
            pst.setString(8, historico.getContaCorrente().trim());
            pst.setInt(9, historico.getAtivo());
            pst.setString(10, historico.getHistoricoCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void excluirHistorico(CadastroHistoricos historico) {
        String historicoCodigo = historico.txtHistoricoCodigo.getText();
        int possuiLancamentoCaixa = 0;

        conecta.conexao();
        try {
            /**
             * ****************************************************************
             * Consulta se o histórico já foi utilizado no lançamento de caixa *
             * caso não, elimina o cadastro, se não volta para a tela. *
             *****************************************************************
             */
            conecta.executaSql("SELECT * FROM LANCAMENTOCAIXA WHERE OPERACAO = '" + historicoCodigo + "' OR CONTRAPARTIDA = '" + historicoCodigo + "'");

            if (conecta.rs.next()) {
                possuiLancamentoCaixa = 1;
            } else {
                possuiLancamentoCaixa = 0;
            }

            if (possuiLancamentoCaixa == 0) {
                try {
                    PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM HISTORICOS WHERE HISTORICOCODIGO = ?");
                    pst.setString(1, historicoCodigo);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Registro eliminado com sucesso!");
                    historico.limpaCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao eliminar registro do banco de dados! \n" + ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Histórico já foi utilizado para lançamentos no caixa. \n"
                                                  + "Altere o cadastro para inativo!");
                historico.btnSair.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoLancamentoContasReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String gerarCodigoHistorico(CadastroHistoricos historico) {
        int codigoHsitorico = 0;
        String codigoString = "";

        conecta.conexao();
        conecta.executaSql("SELECT HISTORICOCODIGO FROM HISTORICOS ORDER BY HISTORICOCODIGO DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                codigoHsitorico = (Integer.parseInt(conecta.rs.getString("HISTORICOCODIGO"))) + 1;
                codigoString = String.format("%04d", codigoHsitorico);
                historico.txtHistoricoCodigo.setText(codigoString);
                historico.txtPesquisaHistorico.requestFocus();
            } else {
                historico.txtHistoricoCodigo.setText("0001");
                historico.txtPesquisaHistorico.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar último código de hitóricos cadastrados! \n ERRO: " + ex);
        }

        conecta.desconecta();
        return codigoString;
    }
}
