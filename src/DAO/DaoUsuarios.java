package DAO;

import Beans.BeansUsuarios;
import Conection.ConectaBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//Métodos de insersão, procura, e alteração.
public class DaoUsuarios {

    ConectaBD conecta = new ConectaBD(); 
    BeansUsuarios usu = new BeansUsuarios();

    public void gravaUsuario(BeansUsuarios usu) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO USUARIOS (USUARIO, GRUPO, SENHA) "
                                                               + "VALUES (?, ?, ?)");
            pst.setString(1, usu.getUsuario());
            pst.setString(2, usu.getGrupo());
            pst.setString(3, usu.getSenha());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário gravado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void alterarUsuario(BeansUsuarios usu) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE USUARIOS SET USUARIO = ?, GRUPO = ?, SENHA = ? WHERE CODIGO = ?");
            pst.setString(1, usu.getUsuario());
            pst.setString(2, usu.getGrupo());
            pst.setString(3, usu.getSenha());
            pst.setInt(4, usu.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void excluirUsuario(BeansUsuarios usu) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM USUARIOS WHERE CODIGO = ?");
            pst.setInt(1, usu.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }
    
    public int codigoUsuario(){
        int codigoUsuario = 0;
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM USUARIOS ORDER BY CODIGO DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                codigoUsuario = (conecta.rs.getInt("CODIGO")) + 1;
            } else {
                codigoUsuario = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar código do usuário! \n ERRO: " + ex);
        }
        
        conecta.desconecta();
        return codigoUsuario;
    }    
}
