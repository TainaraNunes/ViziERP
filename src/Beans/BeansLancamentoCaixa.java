
package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansLancamentoCaixa {
    private int planilha;
    private LocalDate dataLancamento;
    private String operacao;
    private String contraPartida;
    private int pessoaCodigo;
    private String pessoaDescricao;
    private String documentoNumero;
    private String parcelaNumero;
    private BigDecimal valor;
    private String observacoes;

    public int getPlanilha() {
        return planilha;
    }

    public void setPlanilha(int planilha) {
        this.planilha = planilha;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getContraPartida() {
        return contraPartida;
    }

    public void setContraPartida(String contraPartida) {
        this.contraPartida = contraPartida;
    }

    public int getPessoaCodigo() {
        return pessoaCodigo;
    }

    public void setPessoaCodigo(int pessoaCodigo) {
        this.pessoaCodigo = pessoaCodigo;
    }

    public String getPessoaDescricao() {
        return pessoaDescricao;
    }

    public void setPessoaDescricao(String pessoaDescricao) {
        this.pessoaDescricao = pessoaDescricao;
    }

    public String getDocumentoNumero() {
        return documentoNumero;
    }

    public void setDocumentoNumero(String documentoNumero) {
        this.documentoNumero = documentoNumero;
    }

    public String getParcelaNumero() {
        return parcelaNumero;
    }

    public void setParcelaNumero(String parcelaNumero) {
        this.parcelaNumero = parcelaNumero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }    
}
