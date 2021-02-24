package DAO;

import Beans.BeansCheques;
import Conection.ConectaBD;
import ERP.view.Cheques;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class DaoCheques {

    ConectaBD conecta = new ConectaBD();
    BeansCheques beansCheques = new BeansCheques();

    public void gravarCheques(BeansCheques beansCheques, Cheques cheques) {
        PreparedStatement pst = null;
        
        conecta.conexao();
        try {
            if (cheques.incluindo == 1) {
                pst = conecta.con.prepareStatement("INSERT INTO CHEQUES (VENCIMENTO, VALOR, SITUACAO, SITUACAODATA, TITULARCODIGO, TITULARDESCRICAO, TITULARCPFCNPJ, "
                                                 + "                     EMITENTECODIGO, EMITENTEDESCRICAO, EMITENTECPFCNPJ, OBSERVACAO, DOCUMENTO, PARCELANUMERO, NUMERO, BANCO) "
                                                 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            } else {
                pst = conecta.con.prepareStatement("UPDATE CHEQUES SET VENCIMENTO = ?, VALOR = ?, SITUACAO = ?, SITUACAODATA = ?, TITULARCODIGO = ?, TITULARDESCRICAO = ?, TITULARCPFCNPJ = ?, "
                                                 + "                   EMITENTECODIGO = ?, EMITENTEDESCRICAO = ?, EMITENTECPFCNPJ = ?, OBSERVACAO = ?, DOCUMENTO = ?, PARCELANUMERO = ? ) "
                                                 + "WHERE NUMERO = ? AND BANCO = ?") ;
            }
            
            pst.setDate(1, java.sql.Date.valueOf(beansCheques.getDataVencimento()));
            pst.setBigDecimal(2, beansCheques.getValor());
            pst.setString(3, beansCheques.getSituacao());
            if (!(beansCheques.getSituacaoData() == null)) {
                pst.setDate(4, java.sql.Date.valueOf(beansCheques.getSituacaoData()));
            } else {
                pst.setNull(4, 0);
            }
            pst.setInt(5, beansCheques.getTitularCodigo());
            pst.setString(6, beansCheques.getTitularDescricao());
            pst.setString(7, beansCheques.getTitularCPFCNPJ());
            pst.setInt(8, beansCheques.getEmitenteCodigo());
            pst.setString(9, beansCheques.getEmitenteDescricao());
            pst.setString(10, beansCheques.getEmitenteCPFCNPJ());
            pst.setString(11, beansCheques.getObservacao());
            pst.setString(12, beansCheques.getDocumento());
            pst.setString(13, beansCheques.getParcelaNumero());
            pst.setString(14, beansCheques.getNumeroCheque());
            pst.setString(15, beansCheques.getBancoCodigo());
            pst.execute();

            if (cheques.incluindo == 1) {
                JOptionPane.showMessageDialog(null, "Lançamento gravado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Lançamento alterado com sucesso!");
            }

            cheques.limpaCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar cheque! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }
    
    public void excluirCheque(BeansCheques beansCheques) {
        conecta.conexao();
        conecta.executaSql("SELECT * FROM CHEQUES WHERE NUMERO = '" + beansCheques.getNumeroCheque() + "' AND BANCO = '" + beansCheques.getBancoCodigo() + "'");
         try {
             if (conecta.rs.first()) {
                 //Se não possui documento relacionado, pode ser alterado;
                 if(conecta.rs.getString("DOCUMENTO").isEmpty()){
                    PreparedStatement pst = conecta.con.prepareStatement("DELETE CHEQUES WHERE NUMERO =  '" + beansCheques.getNumeroCheque() + "' AND BANCO = '" + beansCheques.getBancoCodigo() + "'");                    
                    pst.execute();
                 } else {
                    JOptionPane.showMessageDialog(null, "Cadastro não pode ser eliminado, possui lançamentos em contas a receber!");
                    return;
                 }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar lançamento de cheques! \n" + ex);
        }
    } 
}
