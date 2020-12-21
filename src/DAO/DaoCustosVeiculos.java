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
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO VEICULOSCUSTOS(DATACOMPRA, DATAVENDA, PRECOCOMPRA, PRECOVENDA, CUSTOBATERIA, CUSTOCARROCERIA, CUSTOCOMBUSTIVEL, CUSTODESPACHANTE, "
                                                               + "                           CUSTOELETRICA, CUSTOIMPOSTOS, CUSTOLATARIAPINTURA, CUSTOLIMPEZA, CUSTOMECANICA, CUSTOMULTAS, CUSTOPECASACESSORIOS, "
                                                               + "                           CUSTOPNEUS, CUSTORECAPAGEM, CUSTOTAPECARIA, CUSTOTORNEARIA, CUSTOOUTROS, CUSTOTOTAL, MARGEMLUCRO, VEICULOCODIGO)"
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
            pst.setBigDecimal(5, cus.getCustosBateria());
            pst.setBigDecimal(6, cus.getCustosCarroceria());
            pst.setBigDecimal(7, cus.getCustosCombustivel());
            pst.setBigDecimal(8, cus.getCustosDespachante());
            pst.setBigDecimal(9, cus.getCustosEletrica());
            pst.setBigDecimal(10, cus.getCustosImpostos());
            pst.setBigDecimal(11, cus.getCustosLatariaPintura());
            pst.setBigDecimal(12, cus.getCustosLimpeza());
            pst.setBigDecimal(13, cus.getCustosMecanica());
            pst.setBigDecimal(14, cus.getCustosMultas());
            pst.setBigDecimal(15, cus.getCustosPecasAcessorios());
            pst.setBigDecimal(16, cus.getCustosPneus());
            pst.setBigDecimal(17, cus.getCustosRecapagem());
            pst.setBigDecimal(18, cus.getCustosTapecaria());
            pst.setBigDecimal(19, cus.getCustosTornearia());
            pst.setBigDecimal(20, cus.getCustosOutros());
            pst.setBigDecimal(21, cus.getTotalDespesas());
            pst.setBigDecimal(22, cus.getMargemLucroValor());
            pst.setInt(23, cus.getVeiculoCodigo());
            
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
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE VEICULOSCUSTOS SET DATACOMPRA = ?, DATAVENDA = ?, PRECOCOMPRA = ?, PRECOVENDA = ?, CUSTOBATERIA = ?, CUSTOCARROCERIA = ?, "
                                                               + "                          CUSTOCOMBUSTIVEL = ?, CUSTODESPACHANTE = ?, CUSTOELETRICA = ?, CUSTOIMPOSTOS = ?, CUSTOLATARIAPINTURA = ?, "
                                                               + "                          CUSTOLIMPEZA = ?, CUSTOMECANICA = ?, CUSTOMULTAS = ?, CUSTOPECASACESSORIOS = ?, CUSTOPNEUS = ?, CUSTORECAPAGEM = ?, "
                                                               + "                          CUSTOTAPECARIA = ?, CUSTOTORNEARIA = ?, CUSTOTOTAL = ?, MARGEMLUCRO = ? "
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
            pst.setBigDecimal(5, cus.getCustosBateria());
            pst.setBigDecimal(6, cus.getCustosCarroceria());
            pst.setBigDecimal(7, cus.getCustosCombustivel());
            pst.setBigDecimal(8, cus.getCustosDespachante());
            pst.setBigDecimal(9, cus.getCustosEletrica());
            pst.setBigDecimal(10, cus.getCustosImpostos());
            pst.setBigDecimal(11, cus.getCustosLatariaPintura());
            pst.setBigDecimal(12, cus.getCustosLimpeza());
            pst.setBigDecimal(13, cus.getCustosMecanica());
            pst.setBigDecimal(14, cus.getCustosMultas());
            pst.setBigDecimal(15, cus.getCustosPecasAcessorios());
            pst.setBigDecimal(16, cus.getCustosPneus());
            pst.setBigDecimal(17, cus.getCustosRecapagem());
            pst.setBigDecimal(18, cus.getCustosTapecaria());
            pst.setBigDecimal(19, cus.getCustosTornearia());
            pst.setBigDecimal(20, cus.getCustosOutros());
            pst.setBigDecimal(21, cus.getTotalDespesas());
            pst.setBigDecimal(22, cus.getMargemLucroValor());
            pst.setInt(23, cus.getVeiculoCodigo());
            
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