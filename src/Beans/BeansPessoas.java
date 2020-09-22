package Beans;

import java.time.LocalDate;

public class BeansPessoas {
    //Dados gerais:
    private Integer codigo, numero;
    private String razaoSocial, fantasia, cnpj, cpf, rg, inscricaoestadual, endereco, bairro, cep, cidade, estado, pais;
    private String telefone, celular, tipoPessoa, atividade, email;
    
    //Dados técnicos:
    private int tanquesQuantidade, bombasQuantidade, filtrosQuantidade, compartimentosQuantidade;
    private String contatoResponsavel, tanquesMarca1, tanquesMarca2, bombasMarca1, bombasMarca2;
    private String filtrosmodelo1, filtrosmodelo2, filtrosmodelo3, equipamentoambiental;
    private LocalDate vencimentoLicencaOperacao, dataFabricacaoBomba, dataFabricacaoTanque; 
            
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atvidade) {
        this.atividade = atvidade;
    }

    public String getContatoResponsavel() {
        return contatoResponsavel;
    }

    public void setContatoResponsavel(String contatoResponsavel) {
        this.contatoResponsavel = contatoResponsavel;
    }

    public int getTanquesQuantidade() {
        return tanquesQuantidade;
    }

    public void setTanquesQuantidade(int tanquesQuantidade) {
        this.tanquesQuantidade = tanquesQuantidade;
    }

    public String getTanquesMarca1() {
        return tanquesMarca1;
    }

    public void setTanquesMarca1(String tanquesMarca1) {
        this.tanquesMarca1 = tanquesMarca1;
    }

    public String getTanquesMarca2() {
        return tanquesMarca2;
    }

    public void setTanquesMarca2(String tanquesMarca2) {
        this.tanquesMarca2 = tanquesMarca2;
    }

    public int getCompartimentosQuantidade() {
        return compartimentosQuantidade;
    }

    public void setCompartimentosQuantidade(int compartimentosQuantidade) {
        this.compartimentosQuantidade = compartimentosQuantidade;
    }

    public int getBombasQuantidade() {
        return bombasQuantidade;
    }

    public void setBombasQuantidade(int bombasQuantidade) {
        this.bombasQuantidade = bombasQuantidade;
    }

    public String getBombasMarca1() {
        return bombasMarca1;
    }

    public void setBombasMarca1(String bombasMarca1) {
        this.bombasMarca1 = bombasMarca1;
    }

    public String getBombasMarca2() {
        return bombasMarca2;
    }

    public void setBombasMarca2(String bombasMarca2) {
        this.bombasMarca2 = bombasMarca2;
    }

    public int getFiltrosQuantidade() {
        return filtrosQuantidade;
    }

    public void setFiltrosQuantidade(int filtrosQuantidade) {
        this.filtrosQuantidade = filtrosQuantidade;
    }

    public String getFiltrosmodelo1() {
        return filtrosmodelo1;
    }

    public void setFiltrosmodelo1(String filtrosmodelo1) {
        this.filtrosmodelo1 = filtrosmodelo1;
    }

    public String getFiltrosmodelo2() {
        return filtrosmodelo2;
    }

    public void setFiltrosmodelo2(String filtrosmodelo2) {
        this.filtrosmodelo2 = filtrosmodelo2;
    }

    public String getFiltrosmodelo3() {
        return filtrosmodelo3;
    }

    public void setFiltrosmodelo3(String filtrosmodelo3) {
        this.filtrosmodelo3 = filtrosmodelo3;
    }

    public String getEquipamentoambiental() {
        return equipamentoambiental;
    }

    public void setEquipamentoambiental(String equipamentoambiental) {
        this.equipamentoambiental = equipamentoambiental;
    }

    public LocalDate getVencimentoLicencaOperacao() {
        return vencimentoLicencaOperacao;
    }

    public void setVencimentoLicencaOperacao(LocalDate vencimentoLicencaOperacao) {
        this.vencimentoLicencaOperacao = vencimentoLicencaOperacao;
    }    

    public LocalDate getDataFabricacaoBomba() {
        return dataFabricacaoBomba;
    }

    public void setDataFabricacaoBomba(LocalDate dataFabricacaoBomba) {
        this.dataFabricacaoBomba = dataFabricacaoBomba;
    }

    public LocalDate getDataFabricacaoTanque() {
        return dataFabricacaoTanque;
    }

    public void setDataFabricacaoTanque(LocalDate dataFabricacaoTanque) {
        this.dataFabricacaoTanque = dataFabricacaoTanque;
    }
}
