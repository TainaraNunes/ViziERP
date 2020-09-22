package DAO;

import ERP.view.EstoqueEntrada;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Beans.BeansSaidaEstoque;
import Conection.ConectaBD;
import ERP.view.EstoqueSaida;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoEstoqueSaida {

    ConectaBD conecta = new ConectaBD();
    BeansSaidaEstoque lanca = new BeansSaidaEstoque();

    public int gerarPlanilhaSaida() {
        int novaPlanilha = 0;

        conecta.conexao();
        conecta.executaSql("SELECT PLANILHA FROM ESTOQUE WHERE OPERACAO = '0002' ORDER BY PLANILHA DESC LIMIT 1");

        try {
            if (conecta.rs.next()) {
                novaPlanilha = (conecta.rs.getInt("PLANILHA")) + 1;
            } else {
                novaPlanilha = 20000;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar planilhas! \n ERRO: " + ex);
        }

        conecta.desconecta();
        return novaPlanilha;
    }

    public void incluirProdutoTabela(EstoqueSaida estoque) {
        String codigoProduto = estoque.txtCodigoProduto.getText().trim();
        String descricaoProduto = estoque.txtDescricaoProduto.getText().trim();
        String quantidade = estoque.txtQuantidade.getText();
        String valorUnitario = estoque.txtValorUnitario.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");
        String valorTotal = estoque.txtValorTotal.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", ".");

        if (!estoque.txtCodigoProduto.getText().isEmpty()) {
            if (estoque.txtQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade!");
                estoque.txtQuantidade.requestFocus();
            } else if (estoque.txtValorUnitario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o valor unitário do produto!");
                estoque.txtValorUnitario.requestFocus();
            } else if (estoque.txtValorTotal.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o valor total do produto!");
                estoque.txtValorTotal.requestFocus();
            } else {
                DefaultTableModel valores = (DefaultTableModel) estoque.tblProdutosEstoque.getModel();
                valores.addRow(new String[]{codigoProduto, descricaoProduto, quantidade, valorUnitario, valorTotal});
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o produto para adicionar!");
        }

        estoque.txtCodigoProduto.setText("");
        estoque.txtDescricaoProduto.setText("");
        estoque.txtQuantidade.setText("");
        estoque.txtValorUnitario.setText("");
        estoque.txtValorTotal.setText("");
        estoque.txtCodigoProduto.requestFocus();
    }

    public void alterarProdutoTabela(EstoqueSaida estoque) {
        if (estoque.tblProdutosEstoque.getSelectedRow() != -1) {
            estoque.tblProdutosEstoque.setValueAt(estoque.txtQuantidade.getText(), estoque.tblProdutosEstoque.getSelectedRow(), 2);
            estoque.tblProdutosEstoque.setValueAt(estoque.txtValorUnitario.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), estoque.tblProdutosEstoque.getSelectedRow(), 3);
            estoque.tblProdutosEstoque.setValueAt(estoque.txtValorTotal.getText().replace("R$", "").replace(" ", "").replace(".", "").replace(",", "."), estoque.tblProdutosEstoque.getSelectedRow(), 4);
        }
    }

    public void excluirProdutoTabela(EstoqueSaida saida){
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ESTOQUE WHERE PLANILHA = ? AND PRODUTOCODIGO = ?");
            pst.setInt(1, Integer.parseInt(saida.txtPlanilha.getText()));
            pst.setInt(2, Integer.parseInt(saida.txtCodigoProduto.getText()));
            pst.execute();
            saldoEstoque(Integer.parseInt(saida.txtCodigoProduto.getText()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o produto! \n" + ex);
        }
        conecta.desconecta();
    }    
    
    public void gravarSaidaEstoque(BeansSaidaEstoque lanca, EstoqueSaida prodTabela) {
        conecta.conexao();
        try {
            // Se estiver alterando apaga o registro do item no estoque e depois insere novamente.
            if (prodTabela.alterando == 1) {
                PreparedStatement pst2 = conecta.con.prepareStatement("DELETE FROM ESTOQUE WHERE PLANILHA = ?");
                pst2.setInt(1, lanca.getPlanilha());
                pst2.execute();
            }

            // Se não só insere o registro.
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO ESTOQUE (PLANILHA, OPERACAO, DATALANCAMENTO, PESSOACODIGO, PESSOADESCRICAO, NOTAFISCAL, PRODUTOCODIGO, PRODUTODESCRICAO, QUANTIDADE, VALORUNITARIO, VALORTOTAL, USUARIO) "
                                                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            // Atualiza o preço da venda no cadastro do produto.
            PreparedStatement pst3 = conecta.con.prepareStatement("UPDATE PRODUTOS SET PRECOVENDA = ? WHERE CODIGO = ?");

            int imprimirPlanilha = 0;
            if (prodTabela.incluindo == 1) {
                pst.setInt(1, gerarPlanilhaSaida());
                imprimirPlanilha = gerarPlanilhaSaida();
            } else {
                pst.setInt(1, lanca.getPlanilha());
                imprimirPlanilha = lanca.getPlanilha();
            }

            for (int x = 0; x < prodTabela.tblProdutosEstoque.getRowCount(); x++) {
                pst.setString(2, lanca.getOperacao());
                pst.setDate(3, java.sql.Date.valueOf(lanca.getDataLancamento()));
                pst.setInt(4, lanca.getPessoaCodigo());
                pst.setString(5, lanca.getPessoaDescricao());
                pst.setString(6, lanca.getNotaFiscal());
                pst.setInt(7, Integer.parseInt(String.valueOf(prodTabela.tblProdutosEstoque.getValueAt(x, 0))));
                pst.setString(8, (String) prodTabela.tblProdutosEstoque.getValueAt(x, 1));
                pst.setInt(9, Integer.parseInt(String.valueOf(prodTabela.tblProdutosEstoque.getValueAt(x, 2))));

                String unitario = (String) prodTabela.tblProdutosEstoque.getValueAt(x, 3);
                BigDecimal valorUnitario = new BigDecimal(unitario);
                pst.setBigDecimal(10, valorUnitario);

                String total = (String) prodTabela.tblProdutosEstoque.getValueAt(x, 4);
                BigDecimal valorTotal = new BigDecimal(total);
                pst.setBigDecimal(11, valorTotal);

                pst.setString(12, System.getProperty("usuario"));
                
                pst.execute();

                //Atualiza o preço de venda no cadastro do produto.
                pst3.setBigDecimal(1, valorUnitario);
                pst3.setInt(2, Integer.parseInt(String.valueOf(prodTabela.tblProdutosEstoque.getValueAt(x, 0))));
                pst3.execute();

                //Passa o código e a quantidade do produto para calcular o saldo de estoque.
                saldoEstoque(Integer.parseInt(String.valueOf(prodTabela.tblProdutosEstoque.getValueAt(x, 0))));
            }

            if (prodTabela.incluindo == 1) {
                JOptionPane.showMessageDialog(null, "Lançamento gravado com sucesso! Planilha: " + imprimirPlanilha);
            } else {
                JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso! Planilha: " + imprimirPlanilha);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar lançamento no estoque! \n ERRO: " + ex);
        }

        conecta.desconecta();
    }

    public void excluirLancamentoSaidaEstoque(BeansSaidaEstoque lanca) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM ESTOQUE WHERE PLANILHA = ?");
            pst.setInt(1, lanca.getPlanilha());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Lançamento eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o lançamento! \n" + ex);
        }
        conecta.desconecta();
    }

    public void saldoEstoque(int produtoCodigo){
        int totalEntradas = 0, totalSaidas = 0, saldoTotal = 0;

        conecta.conexao();
        conecta.executaSql("SELECT QUANTIDADE FROM ESTOQUE WHERE OPERACAO = '0001' AND PRODUTOCODIGO = " + produtoCodigo + " ");
        try {
            while(conecta.rs.next()) {
                totalEntradas = totalEntradas + conecta.rs.getInt("QUANTIDADE");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular o total de entradas de estoque do produto! \n ERRO: " + ex);
        }

        conecta.conexao();
        conecta.executaSql("SELECT QUANTIDADE FROM ESTOQUE WHERE OPERACAO = '0002' AND PRODUTOCODIGO = " + produtoCodigo + " ");
        try {
            while(conecta.rs.next()) {
                totalSaidas = totalSaidas + conecta.rs.getInt("QUANTIDADE");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular o total de saídas de estoque do produto! \n ERRO: " + ex);
        }

        saldoTotal = totalEntradas - totalSaidas;

        try {
            PreparedStatement pst = conecta.con.prepareStatement("UPDATE PRODUTOS SET SALDOESTOQUE = ? WHERE CODIGO = ?");

            pst.setInt(1, saldoTotal);
            pst.setInt(2, produtoCodigo);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstoqueEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        conecta.desconecta();
    }
}
