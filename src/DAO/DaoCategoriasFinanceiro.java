package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansCategoriasFinanceiro;
import Conection.ConectaBD;

public class DaoCategoriasFinanceiro {

    ConectaBD conecta = new ConectaBD();
    //BeansCategoriasFinanceiro categoriasFinanceiro = new BeansCategoriasFinanceiro();
    
    public int incluindo = 1;
    public int alterando = 0;

    public void gravarCategoria(BeansCategoriasFinanceiro categoria) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CATEGORIASFINANCEIRO(DESCRICAO, TIPOMOVIMENTO) VALUES (?, ?)");
            pst.setString(1, categoria.getDescricao().trim());
            pst.setString(2, categoria.getTipoMovimento());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Categoria gravada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }
    
    public void alterarCategoria(BeansCategoriasFinanceiro categoria) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE CATEGORIASFINANCEIRO SET DESCRICAO = ?, TIPOMOVIMENTO = ? WHERE CODIGO = ?");
            pst.setString(1, categoria.getDescricao().trim());
            pst.setString(2, categoria.getTipoMovimento());
            pst.setInt(3, categoria.getCodigo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }
    
    public void excluirCategoria(BeansCategoriasFinanceiro categoria) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CATEGORIASFINANCEIRO WHERE CODIGO = ?");
            pst.setInt(1, categoria.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }    

}
