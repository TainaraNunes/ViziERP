package Conection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Conexão com o banco de dados;
public class ConectaBD {
    
    public Statement st; //reponsável por realizar pesquisas no banco;
    public ResultSet rs; //responsável por armazenar o resultado de uma pesquisa;
    public Connection con; //responsável por realizar a conexão com o banco de dados;

    public void conexao() {
        InputStream arquivoconexao = null;
        try {
            String diretorio = System.getProperty("user.dir");

            if(diretorio.contains("Vizipostos")){
                arquivoconexao = Thread.currentThread().getClass().getResourceAsStream("/Conection/conexaovizipostos.txt");            
            } else if(diretorio.contains("Vizitrucks")){
                arquivoconexao = Thread.currentThread().getClass().getResourceAsStream("/Conection/conexaovizitrucks.txt");            
            } else {
                arquivoconexao = Thread.currentThread().getClass().getResourceAsStream("/Conection/conexao.txt");            
            }

            InputStreamReader arquivo = new InputStreamReader(arquivoconexao);
            BufferedReader buffer = new BufferedReader(arquivo);            
            String conteudo = buffer.readLine();

            String driver = conteudo.split(";")[0];
            String caminhoBanco = conteudo.split(";")[1];
            String usuarioBanco = conteudo.split(";")[2];
            String senha = conteudo.split(";")[3];

            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminhoBanco, usuarioBanco, senha);                

            buffer.close();
            
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo da conexão!" + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
    }

    public void desconecta() {
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados! \n" + ex.getMessage());
        }
    }

    public void executaSql(String sql) {
        try {
            st = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar sql! \n" + ex.getMessage());
        }
    }

    public static String Read(String caminhoArquivo) {
        String conteudo = "";
        FileReader arquivo;
        
        try {
            arquivo = new FileReader(caminhoArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = "";
            try {
                linha = lerArquivo.readLine();
                while(linha != null){
                    conteudo += linha;
                    linha = lerArquivo.readLine();
                }
                arquivo.close();  
            } catch (IOException ex) {
                conteudo = "Erro: Não foi possível ler o arquivo!";
            }          
        } catch (FileNotFoundException ex) {
            conteudo = "Erro: Arquivo não encontrado!";
        }
                
        if (conteudo.contains("Erro")){
            return "";
        } else {
            return conteudo;
        }
    }
    
    public boolean Write(String caminho, String texto){
        try {
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            gravarArquivo.println(texto);
            gravarArquivo.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return false;
        }        
    }
}
