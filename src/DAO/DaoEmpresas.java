package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansEmpresas;
import Conection.ConectaBD;

public class DaoEmpresas {
    ConectaBD conecta = new ConectaBD();
    BeansEmpresas emp = new BeansEmpresas();

    public void gravarEmpresa(BeansEmpresas emp){
        conecta.conexao();        
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO EMPRESAS(RAZAOSOCIAL, FANTASIA, CNPJ, INSCRICAOESTADUAL, ENDERECO, NUMERO, BAIRRO, CEP, CIDADE, ESTADO, PAIS, TELEFONE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, emp.getRazaoSocial());
            pst.setString(2, emp.getFantasia());
            pst.setString(3, emp.getCnpj());
            pst.setString(4, emp.getInscricaoestadual());
            pst.setString(5, emp.getEndereco());
            pst.setInt(6, emp.getNumero());
            pst.setString(7, emp.getBairro());
            pst.setString(8, emp.getCep());
            pst.setString(9, emp.getCidade());
            pst.setString(10, emp.getEstado());
            pst.setString(11, emp.getPais());
            pst.setString(12, emp.getTelefone());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro gravado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " +ex);
        }
        conecta.desconecta();
    }                                         
    
    public void editarEmpresa(BeansEmpresas emp){
        conecta.conexao();        
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE EMPRESAS SET RAZAOSOCIAL = ?, FANTASIA = ?, CNPJ = ?, INSCRICAOESTADUAL = ?, ENDERECO = ?, NUMERO = ?, BAIRRO = ?, CEP = ?, CIDADE = ?, ESTADO = ?, PAIS = ?, TELEFONE = ? WHERE CODIGO = ?");
            pst.setString(1, emp.getRazaoSocial());
            pst.setString(2, emp.getFantasia());
            pst.setString(3, emp.getCnpj());
            pst.setString(4, emp.getInscricaoestadual());
            pst.setString(5, emp.getEndereco());
            pst.setInt(6, emp.getNumero());
            pst.setString(7, emp.getBairro());
            pst.setString(8, emp.getCep());
            pst.setString(9, emp.getCidade());
            pst.setString(10, emp.getEstado());
            pst.setString(11, emp.getPais());
            pst.setString(12, emp.getTelefone());
            pst.setInt(13, emp.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n"+ex);
        }        
        conecta.desconecta();
    }
    
    public void excluirEmpresa(BeansEmpresas emp){
        conecta.conexao();        
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM EMPRESAS WHERE CODIGO = ?");
            pst.setInt(1, emp.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n"+ex);
        }           
        conecta.desconecta();
    }
}
  
