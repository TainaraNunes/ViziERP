package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Beans.BeansPessoas;
import Conection.ConectaBD;

public class DaoPessoas {

    ConectaBD conecta = new ConectaBD();
    BeansPessoas pess = new BeansPessoas();

    public void gravarPessoa(BeansPessoas pess) {
        conecta.conexao();
        try {
            //Grava os dados da aba dados gerais na tabela de pessoas.
            PreparedStatement pst = conecta.con.prepareStatement(" INSERT INTO PESSOAS (RAZAOSOCIAL, FANTASIA, CNPJ, CPF, RG, INSCRICAOESTADUAL, ENDERECO, NUMERO, "
                                                               + "                      BAIRRO, CEP, CIDADE, ESTADO, PAIS, TELEFONE, CELULAR, EMAIL, TIPOPESSOA, ATIVIDADE) "
                                                               + "              VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, pess.getRazaoSocial());
            pst.setString(2, pess.getFantasia());
            pst.setString(3, pess.getCnpj());
            pst.setString(4, pess.getCpf());
            pst.setString(5, pess.getRg());
            pst.setString(6, pess.getInscricaoestadual());
            pst.setString(7, pess.getEndereco());
            pst.setInt(8, pess.getNumero());
            pst.setString(9, pess.getBairro());
            pst.setString(10, pess.getCep());
            pst.setString(11, pess.getCidade());
            pst.setString(12, pess.getEstado());
            pst.setString(13, pess.getPais());
            pst.setString(14, pess.getTelefone());
            pst.setString(15, pess.getCelular());
            pst.setString(16, pess.getEmail());
            pst.setString(17, pess.getTipoPessoa());
            pst.setString(18, pess.getAtividade());
            pst.execute();

            //Grava os dados da aba dados técnicos na tabela própria se tiver infrmação nos campos.
            if (pess.getTanquesQuantidade() != 0 || pess.getBombasQuantidade() != 0 || pess.getCompartimentosQuantidade() != 0 || pess.getFiltrosQuantidade() != 0) {
                gravarDadosTecnicosCliente(pess);
            }
            
            JOptionPane.showMessageDialog(null, "Cadastro gravado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cadastro! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }

    public void alterarPessoa(BeansPessoas pess) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement(" UPDATE PESSOAS "
                                                               + " SET RAZAOSOCIAL = ?, FANTASIA = ?, CNPJ = ?, CPF = ?, RG = ?, INSCRICAOESTADUAL = ?, ENDERECO = ?, NUMERO = ?, "
                                                               + "     BAIRRO = ?, CEP = ?, CIDADE = ?, ESTADO = ?, PAIS = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?, TIPOPESSOA = ?, ATIVIDADE = ? "
                                                               + " WHERE CODIGO = ?");
            pst.setString(1, pess.getRazaoSocial());
            pst.setString(2, pess.getFantasia());
            pst.setString(3, pess.getCnpj());
            pst.setString(4, pess.getCpf());
            pst.setString(5, pess.getRg());
            pst.setString(6, pess.getInscricaoestadual());
            pst.setString(7, pess.getEndereco());
            pst.setInt(8, pess.getNumero());
            pst.setString(9, pess.getBairro());
            pst.setString(10, pess.getCep());
            pst.setString(11, pess.getCidade());
            pst.setString(12, pess.getEstado());
            pst.setString(13, pess.getPais());
            pst.setString(14, pess.getTelefone());
            pst.setString(15, pess.getCelular());
            pst.setString(16, pess.getEmail());
            pst.setString(17, pess.getTipoPessoa());
            pst.setString(18, pess.getAtividade());
            pst.setInt(19, pess.getCodigo());
            pst.execute();
            
            //Altera os dados técnicos do cliente se tiver informação nos campos.
            if (pess.getVencimentoLicencaOperacao() != null || !pess.getContatoResponsavel().equals("") || pess.getTanquesQuantidade() != 0 && pess.getBombasQuantidade() != 0 && pess.getCompartimentosQuantidade() != 0 && pess.getFiltrosQuantidade() != 0 || pess.getDataFabricacaoTanque() != null || pess.getDataFabricacaoBomba() != null) {
                gravarDadosTecnicosCliente(pess);
            }
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void excluirPessoa(BeansPessoas pess) {
        conecta.conexao();
        conecta.executaSql("SELECT * FROM CONTASPAGAR WHERE FORNECEDORCODIGO = '" + pess.getCodigo() + "'");
        try {
            if (conecta.rs.first()) {
                JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos em contas a pagar!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar contas a pagar da pessoa! \n" + ex);
        }

        conecta.executaSql("SELECT * FROM CONTASRECEBER WHERE CLIENTECODIGO = '" + pess.getCodigo() + "'");
        try {
            if (conecta.rs.first()) {
                JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos em contas a receber!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar contas a receber da pessoa! \n" + ex);
        }
        
        conecta.executaSql("SELECT * FROM LANCAMENTOCAIXA WHERE PESSOACODIGO = '" + pess.getCodigo() + "'");
        try {
            if (conecta.rs.first()) {
                JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos no caixa!");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar lançamentos de caixa da pessoa! \n" + ex);
        }
        
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM PESSOAS WHERE CODIGO = ?");
            pst.setInt(1, pess.getCodigo());
            pst.execute();
            
            //Exclui os dados técnicos do cliente da tabela própria.
            excluirDadosTecnicosCliente(pess);
            
            JOptionPane.showMessageDialog(null, "Cadastro eliminado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar o cadastro! \n" + ex);
        }
        conecta.desconecta();
    }

    public void gravarDadosTecnicosCliente(BeansPessoas pess) {
        int pessoaCodigo = 0;
        
        if (pess.getCodigo() == null) {
            conecta.conexao();
            conecta.executaSql("SELECT * FROM PESSOAS ORDER BY CODIGO DESC LIMIT 1");
            try {
                if (conecta.rs.next()){
                    pessoaCodigo = conecta.rs.getInt("CODIGO");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar pessoas cadastradas! \n ERRO: " + ex);
            }
        } else {
            pessoaCodigo = pess.getCodigo();
        }                
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM CLIENTESDADOSTECNICOS WHERE CLIENTECODIGO = " + pessoaCodigo + " ");
        try {
            if (conecta.rs.next()) {
                PreparedStatement pst2 = conecta.con.prepareStatement("DELETE FROM CLIENTESDADOSTECNICOS WHERE CLIENTECODIGO = ?");
                pst2.setInt(1, pessoaCodigo);
                pst2.execute();                
            }
            
            PreparedStatement pst = conecta.con.prepareStatement("INSERT INTO CLIENTESDADOSTECNICOS(CONTATORESPONSAVEL, TANQUESQUANTIDADE, TANQUESMARCA1, TANQUESMARCA2, "
                                                               + "                                  COMPARTIMENTOSQUANTIDADE, BOMBASQUANTIDADE, BOMBASMARCA1, BOMBASMARCA2, "
                                                               + "                                  FILTROSQUANTIDADE, FILTROSMODELO1, FILTROSMODELO2, FILTROSMODELO3, EQUIPAMENTOAMBIENTAL, "
                                                               + "                                  VENCIMENTOLICENCAOPERACAO, DATAFABRICACAOTANQUE, DATAFABRICACAOBOMBA, CLIENTECODIGO) "
                                                               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");                              

            pst.setString(1, pess.getContatoResponsavel());
            pst.setInt(2, pess.getTanquesQuantidade());
            pst.setString(3, pess.getTanquesMarca1());
            pst.setString(4, pess.getTanquesMarca2());
            pst.setInt(5, pess.getCompartimentosQuantidade());
            pst.setInt(6, pess.getBombasQuantidade());
            pst.setString(7, pess.getBombasMarca1());
            pst.setString(8, pess.getBombasMarca2());
            pst.setInt(9, pess.getFiltrosQuantidade());
            pst.setString(10, pess.getFiltrosmodelo1());
            pst.setString(11, pess.getFiltrosmodelo2());
            pst.setString(12, pess.getFiltrosmodelo3());
            pst.setString(13, pess.getEquipamentoambiental());
            
            if (pess.getVencimentoLicencaOperacao() != null) {
                pst.setDate(14, java.sql.Date.valueOf(pess.getVencimentoLicencaOperacao()));
            } else {
                pst.setNull(14, 0);
            }
            if (pess.getDataFabricacaoTanque() != null) {
                pst.setDate(15, java.sql.Date.valueOf(pess.getDataFabricacaoTanque()));
            } else {
                pst.setNull(15, 0);
            }
            if (pess.getDataFabricacaoBomba() != null) {
                pst.setDate(16, java.sql.Date.valueOf(pess.getDataFabricacaoBomba()));
            } else {
                pst.setNull(16, 0);
            }            
            pst.setInt(17, pessoaCodigo);
            pst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar os dados técnicos do cliente! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }
    
    public void excluirDadosTecnicosCliente(BeansPessoas pess) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.con.prepareStatement("DELETE FROM CLIENTESDADOSTECNICOS WHERE CLIENTECODIGO = ?");
            pst.setInt(1, pess.getCodigo());
            pst.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível eliminar os dados técnicos do cliente! \n" + ex);
        }
        conecta.desconecta();
    }
    
    public int codigoPessoa(){
        int codigoPessoa = 0;
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM PESSOAS ORDER BY CODIGO DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                codigoPessoa = (conecta.rs.getInt("CODIGO")) + 1;
            } else {
                codigoPessoa = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar código da pessoa! \n ERRO: " + ex);
        }
        
        conecta.desconecta();
        return codigoPessoa;
    }    
}
