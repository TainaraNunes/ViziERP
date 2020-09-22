package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansProdutos;
import Conection.ConectaBD;

public class DaoProdutos {

    ConectaBD conecta = new ConectaBD();
    BeansProdutos prod = new BeansProdutos();

    public void gravarProdutos(BeansProdutos prod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO PRODUTOS (DESCRICAO, MARCA, CLASSIFICACAO, GRUPO, CUSTOULTIMACOMPRA, "
                                                               + "                      PRECOVENDA, DATAULTIMACOMPRA, DATAVENCIMENTO, ATIVO) "
                                                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, prod.getDescricao());
            pst.setString(2, prod.getMarca());
            pst.setString(3, prod.getClassificacao());
            pst.setString(4, prod.getGrupo());
            pst.setBigDecimal(5, prod.getCustoCompra());
            pst.setBigDecimal(6, prod.getPrecoVenda());
            if (!(prod.getDataCompra()== null)) {
                pst.setDate(7, java.sql.Date.valueOf(prod.getDataCompra()));
            } else {
                pst.setNull(7, 0);
            }
            if (!(prod.getDataVencimento() == null)) {
                pst.setDate(8, java.sql.Date.valueOf(prod.getDataVencimento()));
            } else {
                pst.setNull(8, 0);
            }
            pst.setInt(9, prod.getAtivo());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Produto gravado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void alterarProduto(BeansProdutos prod) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRODUTOS SET DESCRICAO = ?, MARCA = ?, CLASSIFICACAO = ?, GRUPO = ?, CUSTOULTIMACOMPRA = ?, PRECOVENDA = ?, DATAULTIMACOMPRA = ?, DATAVENCIMENTO = ?, ATIVO = ? WHERE CODIGO = ?");
            pst.setString(1, prod.getDescricao());
            pst.setString(2, prod.getMarca());
            pst.setString(3, prod.getClassificacao());
            pst.setString(4, prod.getGrupo());
            pst.setBigDecimal(5, prod.getCustoCompra());
            pst.setBigDecimal(6, prod.getPrecoVenda());
            pst.setDate(7, java.sql.Date.valueOf(prod.getDataCompra()));
            if (!(prod.getDataVencimento() == null)) {
                pst.setDate(8, java.sql.Date.valueOf(prod.getDataVencimento()));
            } else {
                pst.setNull(8, 0);
            }
            pst.setInt(9, prod.getAtivo());
            pst.setInt(10, prod.getCodigo());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }

        conecta.desconecta();
    }

    public void excluiProduto(BeansProdutos prod) {
        conecta.conexao();
        conecta.executaSql("SELECT * FROM ESTOQUE WHERE PRODUTOCODIGO = '" + prod.getCodigo() + "'");
        try {
            if (conecta.rs.first()) {
                JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos de estoque!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar lançamentos de estoque do produto! \n" + ex);
        }

        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PRODUTOS WHERE CODIGO = ?");
            pst.setInt(1, prod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n" + ex);
        }

        conecta.desconecta();
    }
    
    public int codigoProduto(){
        int codigoProduto = 0;
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM PRODUTOS ORDER BY CODIGO DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                codigoProduto = (conecta.rs.getInt("CODIGO")) + 1;
            } else {
                codigoProduto = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar código do produto! \n ERRO: " + ex);
        }
        
        conecta.desconecta();
        return codigoProduto;
    }
}
