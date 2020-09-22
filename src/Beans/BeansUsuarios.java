package Beans;

//Declaração dos atributos
public class BeansUsuarios {
    private Integer codigo;
    private String  usuario;
    private String  grupo;
    private String  empresaAcesso;
    private String  pesquisaUsuario;

    public String getPesquisaUsuario() {
        return pesquisaUsuario;
    }

    public void setPesquisaUsuario(String pesquisaUsuario) {
        this.pesquisaUsuario = pesquisaUsuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    private String senha;

    public String getEmpresaAcesso() {
        return empresaAcesso;
    }

    public void setEmpresaAcesso(String empresaAcesso) {
        this.empresaAcesso = empresaAcesso;
    }
    
}
