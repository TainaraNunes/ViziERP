package DAO;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansVeiculos;
import Conection.ConectaBD;

public class DaoVeiculos {

    ConectaBD conecta = new ConectaBD();
    BeansVeiculos vei = new BeansVeiculos();

    public void gravarVeiculo(BeansVeiculos vei) {
        conecta.conexao();
        try {
            //Grava os dados principais do veículo;
            PreparedStatement pst = conecta.con.prepareStatement(" INSERT INTO VEICULOS(PLACA, MARCA, MODELO, TIPO, ANOFABRICACAO, ANOMODELO, COR, COMBUSTIVEL, MOTOR, "
                                                               + "                      CHASSI, RENAVAM, KM, TRANSMISSAO, EMESTOQUE, OBSERVACOES, DATACOMPRA, PRECOCOMPRA) "
                                                               + "              VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, vei.getPlaca());
            pst.setString(2, vei.getMarca());
            pst.setString(3, vei.getModelo());
            pst.setString(4, vei.getTipo());
            pst.setString(5, vei.getAnoFabricacao());
            pst.setString(6, vei.getAnoModelo());
            pst.setString(7, vei.getCor());
            pst.setString(8, vei.getCombustivel());
            pst.setString(9, vei.getMotor());
            pst.setString(10, vei.getChassi());
            pst.setString(11, vei.getRenavam());
            pst.setDouble(12, vei.getKm());
            pst.setString(13, vei.getTransmissao());
            pst.setInt(14, vei.getemEstoque());
            pst.setString(15, vei.getObservacoes());
            if (!(vei.getDataCompra()== null)) {
                pst.setDate(16, java.sql.Date.valueOf(vei.getDataCompra()));
            } else {
                pst.setNull(16, 0);
            }
            pst.setBigDecimal(17, vei.getPrecoCompra());
            
            pst.execute();
            
            //Atualiza os opcionais marcados para o veículo;
            if (vei.getOpcionalAirBag() != 0 || vei.getOpcionalAlarme() != 0 || vei.getOpcionalAlarmeSonoroRe() != 0 || vei.getOpcionalArCondicionado() != 0 || vei.getOpcionalArQuente() != 0 || vei.getOpcionalCDPlayer() != 0
                || vei.getOpcionalComputadorBordo() != 0 || vei.getOpcionalDirecaoHidraulica() != 0 || vei.getOpcionalFarolMilha() != 0 || vei.getOpcionalFarolNeblina() != 0 || vei.getOpcionalFreioABS() != 0
                || vei.getOpcionalParabarroTraseiro() != 0 || vei.getOpcionalRegulagemVoltante() != 0 || vei.getOpcionalVidrosEletricos() != 0 || !vei.getOutrosOpcionais().equals("")) {
                gravarOpcionais(vei); 
            }


            JOptionPane.showMessageDialog(null, "Cadastro gravado com sucesso!");            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void alterarVeiculo(BeansVeiculos vei) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement(" UPDATE VEICULOS "
                                                               + " SET PLACA = ?, MARCA = ?, MODELO = ?, TIPO = ?, ANOFABRICACAO = ?, ANOMODELO = ?, COR = ?, COMBUSTIVEL = ?, "
                                                               + "     MOTOR = ?, CHASSI = ?, RENAVAM = ?, KM = ?, TRANSMISSAO = ?, EMESTOQUE = ?, OBSERVACOES = ?, DATACOMPRA = ?, PRECOCOMPRA = ? "
                                                               + " WHERE CODIGO = ?");
            
            pst.setString(1, vei.getPlaca());
            pst.setString(2, vei.getMarca());
            pst.setString(3, vei.getModelo());
            pst.setString(4, vei.getTipo());
            pst.setString(5, vei.getAnoFabricacao());
            pst.setString(6, vei.getAnoModelo());
            pst.setString(7, vei.getCor());
            pst.setString(8, vei.getCombustivel());
            pst.setString(9, vei.getMotor());
            pst.setString(10, vei.getChassi());
            pst.setString(11, vei.getRenavam());
            pst.setDouble(12, vei.getKm());
            pst.setString(13, vei.getTransmissao());
            pst.setInt(14, vei.getemEstoque());
            pst.setString(15, vei.getObservacoes());
            if (!(vei.getDataCompra()== null)) {
                pst.setDate(16, java.sql.Date.valueOf(vei.getDataCompra()));
            } else {
                pst.setNull(16, 0);
            }
            pst.setBigDecimal(17, vei.getPrecoCompra());
            pst.setInt(18, vei.getCodigo());
            pst.execute();

            //Atualiza os opcionais marcados para o veículo;
            if (vei.getOpcionalAirBag() != 0 || vei.getOpcionalAlarme() != 0 || vei.getOpcionalAlarmeSonoroRe() != 0 || vei.getOpcionalArCondicionado() != 0 || vei.getOpcionalArCondicionado() != 0 || vei.getOpcionalCDPlayer() != 0
                || vei.getOpcionalComputadorBordo() != 0 || vei.getOpcionalDirecaoHidraulica() != 0 || vei.getOpcionalFarolMilha() != 0 || vei.getOpcionalFarolNeblina() != 0 || vei.getOpcionalFreioABS() != 0
                || vei.getOpcionalParabarroTraseiro() != 0 || vei.getOpcionalRegulagemVoltante() != 0 || vei.getOpcionalVidrosEletricos() != 0 || !vei.getOutrosOpcionais().equals("")) {
                gravarOpcionais(vei); 
            }          
          
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void excluirVeiculo(BeansVeiculos vei) {
        conecta.conexao();
        conecta.executaSql("SELECT * FROM VEICULOSDESPESAS WHERE VEICULOCODIGO = '" + vei.getCodigo() + "'");
        try {
            if (conecta.rs.first()) {
                JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos de despesas!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar despesas do veículo! \n" + ex);
        }

        try {
            //Exclui os dados opcionais do veículo da tabela própria.
            excluirOpcionaisVeiculo(vei);
            
            conecta.conexao();
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VEICULOS WHERE CODIGO = ?");
            pst.setInt(1, vei.getCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void gravarOpcionais(BeansVeiculos vei) {
        int veiculoCodigo = 0;
        
        if (vei.getCodigo() == null) {
            conecta.conexao();
            conecta.executaSql("SELECT * FROM VEICULOS ORDER BY CODIGO DESC LIMIT 1");
            try {
                if (conecta.rs.first()){
                    veiculoCodigo = conecta.rs.getInt("CODIGO");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar veículos cadastrados! \n ERRO: " + ex);
            }
        } else {
            veiculoCodigo = vei.getCodigo();
        }
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM VEICULOSOPCIONAIS WHERE VEICULOCODIGO = '" + veiculoCodigo + "'");
        try {
            if (conecta.rs.first()) {
                PreparedStatement pst2 = conecta.con.prepareStatement("DELETE FROM VEICULOSOPCIONAIS WHERE VEICULOCODIGO = ?");
                pst2.setInt(1, veiculoCodigo);
                pst2.execute();                
            }
            
            PreparedStatement pst = conecta.con.prepareStatement(" INSERT INTO VEICULOSOPCIONAIS(AIRBAG, ALARME, ALARMESONORORE, ARCONDICIONADO, ARQUENTE, CDPLAYER, COMPUTADORBORDO, DIRECAOHIDRAULICA, FAROLMILHA, "
                                                               + "                               FAROLNEBLINA, FREIOABS, PARABARROTRASEIRO, REGULAGEMVOLANTE, VIDROSELETRICOS, OUTROSOPCIONAIS, VEICULOCODIGO)"
                                                               + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
           
            pst.setInt(1, vei.getOpcionalAirBag());
            pst.setInt(2, vei.getOpcionalAlarme());
            pst.setInt(3, vei.getOpcionalAlarmeSonoroRe());
            pst.setInt(4, vei.getOpcionalArCondicionado());
            pst.setInt(5, vei.getOpcionalArQuente());
            pst.setInt(6, vei.getOpcionalCDPlayer());
            pst.setInt(7, vei.getOpcionalComputadorBordo());
            pst.setInt(8, vei.getOpcionalDirecaoHidraulica());
            pst.setInt(9, vei.getOpcionalFarolMilha());
            pst.setInt(10, vei.getOpcionalFarolNeblina());
            pst.setInt(11, vei.getOpcionalFreioABS());
            pst.setInt(12, vei.getOpcionalParabarroTraseiro());
            pst.setInt(13, vei.getOpcionalRegulagemVoltante());
            pst.setInt(14, vei.getOpcionalVidrosEletricos());
            pst.setString(15, vei.getOutrosOpcionais().trim());
            pst.setInt(16, veiculoCodigo);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar opcionais do veículo! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void excluirOpcionaisVeiculo(BeansVeiculos vei) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM VEICULOSOPCIONAIS WHERE VEICULOCODIGO = ?");
            pst.setInt(1, vei.getCodigo());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar os opcionais do veículo! \n" + ex);
        }
        conecta.desconecta();
    }
}
