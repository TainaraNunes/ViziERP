package DAO;

import ERP.view.CadastroServicos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansServicos;
import Conection.ConectaBD;

public class DaoServicos {

    ConectaBD conecta = new ConectaBD();
    BeansServicos ser = new BeansServicos();

    public void gravarServico(BeansServicos ser, CadastroServicos servicos) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO SERVICOS (DESCRICAO) VALUES (?)");
            pst.setString(1, ser.getDescricao());
            pst.execute();
            
            if (servicos.tblListaPecas.getRowCount() != 0) {           
                gravarListaPecas(ser, servicos); 
            }
            
            if (servicos.tblListaServicos.getRowCount() != 0) {           
                gravarListaServicos(ser, servicos); 
            }            

            JOptionPane.showMessageDialog(null, "Serviço gravado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro do serviço! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void alterarServico(BeansServicos ser, CadastroServicos servicos) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE SERVICOS SET DESCRICAO = ? WHERE CODIGO = ?");
            pst.setString(1, ser.getDescricao());
            pst.setInt(2, ser.getCodigoServico());
            pst.execute();
            
            if (servicos.tblListaPecas.getRowCount() != 0) {           
                gravarListaPecas(ser, servicos); 
            }
            
            if (servicos.tblListaServicos.getRowCount() != 0) {           
                gravarListaServicos(ser, servicos); 
            }            
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void excluirServico(BeansServicos ser) {
        conecta.conexao();
        conecta.executaSql("SELECT * FROM ORCAMENTOSSERVICOS WHERE SERVICOCODIGO = '" + ser.getCodigoServico()+ "'");
        try {
            if (conecta.rs.first()) {
                JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos em orçamentos!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar orçamentos emitidos! \n" + ex);
        }
        
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM SERVICOS WHERE CODIGO = ?");
            pst.setInt(1, ser.getCodigoServico());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }
    
    public void gravarListaPecas(BeansServicos ser, CadastroServicos servicos){
        PreparedStatement pst, pst1; 
        
        conecta.conexao();        
        conecta.executaSql("SELECT * FROM SERVICOLISTAPECAS WHERE CODIGOSERVICO = " + ser.getCodigoServico() + " "); 
        try {
            if (conecta.rs.first()){
                pst = conecta.con.prepareStatement("DELETE FROM SERVICOLISTAPECAS WHERE CODIGOSERVICO = ?");
                pst.setInt(1, ser.getCodigoServico());
                pst.execute();
            }
            
            pst1 = conecta.con.prepareStatement("INSERT INTO SERVICOLISTAPECAS (QUANTIDADEPECA, CODIGOPECA, DESCRICAOPECA, CODIGOSERVICO) VALUES (?, ?, ?, ?)");

            for (int x = 0; x < servicos.tblListaPecas.getRowCount(); x++) {
                pst1.setInt(1, Integer.parseInt(String.valueOf(servicos.tblListaPecas.getValueAt(x, 0))));
                pst1.setInt(2, Integer.parseInt(String.valueOf(servicos.tblListaPecas.getValueAt(x, 1))));
                pst1.setString(3, (String) servicos.tblListaPecas.getValueAt(x, 2));                   
                pst1.setInt(4, ser.getCodigoServico());               
                pst1.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lista de peças do serviço! \n ERRO: " + ex);
        }
        conecta.desconecta();        
    }
        
    public void gravarListaServicos(BeansServicos ser, CadastroServicos servicos){
        PreparedStatement pst, pst1;
        
        conecta.conexao();        
        conecta.executaSql("SELECT * FROM SERVICOSLISTASERVICOS WHERE CODIGOSERVICOPRINCIPAL = " + ser.getCodigoServico() + " "); 
        try {
            if (conecta.rs.first()){                
                pst = conecta.con.prepareStatement("DELETE FROM SERVICOSLISTASERVICOS WHERE CODIGOSERVICOPRINCIPAL = ?");
                pst.setInt(1, ser.getCodigoServico());
                pst.execute();
            }
            pst1 = conecta.con.prepareStatement("INSERT INTO SERVICOSLISTASERVICOS (CODIGOSERVICOPRINCIPAL, CODIGOSERVICOLISTA) VALUES (?, ?)");

            for (int x = 0; x < servicos.tblListaServicos.getRowCount(); x++) {
                pst1.setInt(1, ser.getCodigoServico() );
                pst1.setInt(2, Integer.parseInt(String.valueOf(servicos.tblListaServicos.getValueAt(x, 0))));
                pst1.execute();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lista de serviços do serviço! \n ERRO: " + ex);
        }
        conecta.desconecta();        
    }      
}
