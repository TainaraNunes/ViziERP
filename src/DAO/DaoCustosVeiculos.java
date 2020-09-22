package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansCustosVeiculos;
import Conection.ConectaBD;

public class DaoCustosVeiculos {
    ConectaBD conecta = new ConectaBD();
    BeansCustosVeiculos custos = new BeansCustosVeiculos();

    public void gravarCustosVeiculo(BeansCustosVeiculos cus) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VEICULOSCUSTOS(DATACOMPRA, DATAVENDA, PRECOCOMPRA, PRECOVENDA, CUSTOCOMBUSTIVEL, CUSTODESPACHANTE, CUSTOIMPOSTOS, CUSTOLATARIAPINTURA, "
                                                               + "                           CUSTOLIMPEZA, CUSTOMECANICA, CUSTOPECASACESSORIOS, CUSTOPNEUS, CUSTOTOTAL, MARGEMLUCRO, VEICULOCODIGO)"
                                                               + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            if (!(cus.getDataCompra()== null)) {
                pst.setDate(1, java.sql.Date.valueOf(cus.getDataCompra()));
            } else {
                pst.setNull(1, 0);
            }
            
            if (!(cus.getDataVenda()== null)) {
                pst.setDate(2, java.sql.Date.valueOf(cus.getDataVenda()));
            } else {
                pst.setNull(2, 0);
            }
            
            pst.setBigDecimal(3, cus.getPrecoCompra());
            pst.setBigDecimal(4, cus.getPrecoVenda());
            pst.setBigDecimal(5, cus.getCustosCombustivel());
            pst.setBigDecimal(6, cus.getCustosDespachante());
            pst.setBigDecimal(7, cus.getCustosImpostos());
            pst.setBigDecimal(8, cus.getCustosLatariaPintura());
            pst.setBigDecimal(9, cus.getCustosLimpeza());
            pst.setBigDecimal(10, cus.getCustosMecanica());
            pst.setBigDecimal(11, cus.getCustosPecasAcessorios());
            pst.setBigDecimal(12, cus.getCustosPneus());
            pst.setBigDecimal(13, cus.getTotalDespesas());
            pst.setBigDecimal(14, cus.getMargemLucro());
            pst.setInt(15, cus.getVeiculoCodigo());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Custo do veículo gravado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lançamento! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }   
    
    public void alterarCustosVeiculo(BeansCustosVeiculos cus) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VEICULOSCUSTOS SET DATACOMPRA = ?, DATAVENDA = ?, PRECOCOMPRA = ?, PRECOVENDA = ?, CUSTOCOMBUSTIVEL = ?, CUSTODESPACHANTE = ?, CUSTOIMPOSTOS = ?,  "
                                                               + "                          CUSTOLATARIAPINTURA = ?, CUSTOLIMPEZA = ?, CUSTOMECANICA = ?, CUSTOPECASACESSORIOS = ?, CUSTOPNEUS = ?, CUSTOTOTAL = ?, MARGEMLUCRO = ? "
                                                               + " WHERE VEICULOCODIGO = ? ");
            if (!(cus.getDataCompra()== null)) {
                pst.setDate(1, java.sql.Date.valueOf(cus.getDataCompra()));
            } else {
                pst.setNull(1, 0);
            }
            
            if (!(cus.getDataVenda()== null)) {
                pst.setDate(2, java.sql.Date.valueOf(cus.getDataVenda()));
            } else {
                pst.setNull(2, 0);
            }
            
            pst.setBigDecimal(3, cus.getPrecoCompra());
            pst.setBigDecimal(4, cus.getPrecoVenda());
            pst.setBigDecimal(5, cus.getCustosCombustivel());
            pst.setBigDecimal(6, cus.getCustosDespachante());
            pst.setBigDecimal(7, cus.getCustosImpostos());
            pst.setBigDecimal(8, cus.getCustosLatariaPintura());
            pst.setBigDecimal(9, cus.getCustosLimpeza());
            pst.setBigDecimal(10, cus.getCustosMecanica());
            pst.setBigDecimal(11, cus.getCustosPecasAcessorios());
            pst.setBigDecimal(12, cus.getCustosPneus());
            pst.setBigDecimal(13, cus.getTotalDespesas());
            pst.setBigDecimal(14, cus.getMargemLucro());
            pst.setInt(15, cus.getVeiculoCodigo());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Custos do veículo alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar lançamento! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }   
    
    public void excluirCustosVeiculo(BeansCustosVeiculos cus){
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VEICULOSCUSTOS WHERE VEICULOCODIGO = ?");
            pst.setInt(1, cus.getVeiculoCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Lançamento eliminado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o lançamento! \n" + ex);
        }
        conecta.desconecta();
    }
    
}