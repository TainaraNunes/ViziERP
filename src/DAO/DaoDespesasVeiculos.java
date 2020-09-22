package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansDespesasVeiculos;
import Conection.ConectaBD;

public class DaoDespesasVeiculos {

    ConectaBD conecta = new ConectaBD();
    BeansDespesasVeiculos despesa = new BeansDespesasVeiculos();
    
    public void gravarDespesaVeiculo(BeansDespesasVeiculos desp) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VEICULOSDESPESAS (DATALANCAMENTO, VEICULOCODIGO, FORNECEDORCODIGO, DESPESADESCRICAO, CATEGORIA, DESPESAVALOR) VALUES (?, ?, ?, ?, ?, ?)");
            
            if (!(desp.getDataLancamento()== null)) {
                pst.setDate(1, java.sql.Date.valueOf(desp.getDataLancamento()));
            } else {
                pst.setNull(1, 0);
            }
            pst.setInt(2, desp.getVeiculoCodigo());
            pst.setInt(3, desp.getFornecedorCodigo());
            pst.setString(4, desp.getDespesaDescricao());
            pst.setString(5, desp.getCategoria());
            pst.setBigDecimal(6, desp.getDespesaValor());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Despesa lançada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lançamento! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }   
    
    public void alterarLancamentoDespesa(BeansDespesasVeiculos desp){
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement(" UPDATE VEICULOSDESPESAS "
                                                               + " SET DATALANCAMENTO = ?, VEICULOCODIGO = ?, FORNECEDORCODIGO = ?, "
                                                               + "     DESPESADESCRICAO = ?, CATEGORIA = ?, DESPESAVALOR = ? "
                                                               + " WHERE PLANILHA = ?");
            
            pst.setDate(1, java.sql.Date.valueOf(desp.getDataLancamento()));
            pst.setInt(2, desp.getVeiculoCodigo());
            pst.setInt(3, desp.getFornecedorCodigo());
            pst.setString(4, desp.getDespesaDescricao());
            pst.setString(5, desp.getCategoria());
            pst.setBigDecimal(6, desp.getDespesaValor());
            pst.setInt(7, desp.getPlanilha());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o lançamento! \n" + ex);
        }
        conecta.desconecta();    
    }
    
    public void excluirLancamentoDespesa(BeansDespesasVeiculos desp) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VEICULOSDESPESAS WHERE PLANILHA = ?");
            pst.setInt(1, desp.getPlanilha());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Lançamento eliminado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o lançamento! \n" + ex);
        }
        conecta.desconecta();
    }    
}
