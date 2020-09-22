package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class BeansOrcamento {
    private int orcamentoNumero;
    private int clienteCodigo;
    private String clienteDescricao;
    private Date dataAbertura;
    private LocalDate dataValidade;
    private String versaoOrcamento;
    private int servicoCodigo;
    private int quantidadeCompartimentos;
    private BigDecimal servicoValorUnitario;
    private BigDecimal servicoValorTotal;
    private BigDecimal valorTotalServicos;
    private BigDecimal valorDescontoServicos;
    private BigDecimal valorTotalOrcamento;
    private int pecaCodigo;
    private int pecaQuantidade;
    private BigDecimal pecaValorUnitario;
    private BigDecimal pecaValorTotal;
    private BigDecimal valorTotalPecas;
    private BigDecimal valorDescontoPecas;
    private int formaPagamento;
    private int quantidadeParcelas;
    private int parcelaCondicao;
    private int parcelaNumero;
    private LocalDate parcelaVencimento;
    private BigDecimal parcelaValor;
    private String observacoes;
    private String situacao;
    private String usuario;
    
    public int getOrcamentoNumero() {
        return orcamentoNumero;
    }

    public void setOrcamentoNumero(int orcamentoNumero) {
        this.orcamentoNumero = orcamentoNumero;
    }

    public int getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(int clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    public String getClienteDescricao() {
        return clienteDescricao;
    }

    public void setClienteDescricao(String clienteDescricao) {
        this.clienteDescricao = clienteDescricao;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getVersaoOrcamento() {
        return versaoOrcamento;
    }

    public void setVersaoOrcamento(String versaoOrcamento) {
        this.versaoOrcamento = versaoOrcamento;
    }
    
    public int getServicoCodigo() {
        return servicoCodigo;
    }

    public void setServicoCodigo(int servicoCodigo) {
        this.servicoCodigo = servicoCodigo;
    }

    public int getQuantidadeCompartimentos() {
        return quantidadeCompartimentos;
    }

    public void setQuantidadeCompartimentos(int quantidadeCompartimentos) {
        this.quantidadeCompartimentos = quantidadeCompartimentos;
    }

    public BigDecimal getServicoValorUnitario() {
        return servicoValorUnitario;
    }

    public void setServicoValorUnitario(BigDecimal servicoValorUnitario) {
        this.servicoValorUnitario = servicoValorUnitario;
    }

    public BigDecimal getServicoValorTotal() {
        return servicoValorTotal;
    }

    public void setServicoValorTotal(BigDecimal servicoValorTotal) {
        this.servicoValorTotal = servicoValorTotal;
    }

    public BigDecimal getValorTotalServicos() {
        return valorTotalServicos;
    }

    public void setValorTotalServicos(BigDecimal valorTotalServicos) {
        this.valorTotalServicos = valorTotalServicos;
    }

    public BigDecimal getValorDescontoServicos() {
        return valorDescontoServicos;
    }

    public void setValorDescontoServicos(BigDecimal valorDescontoServicos) {
        this.valorDescontoServicos = valorDescontoServicos;
    }

    public int getPecaCodigo() {
        return pecaCodigo;
    }

    public void setPecaCodigo(int pecaCodigo) {
        this.pecaCodigo = pecaCodigo;
    }

    public int getPecaQuantidade() {
        return pecaQuantidade;
    }

    public void setPecaQuantidade(int pecaQuantidade) {
        this.pecaQuantidade = pecaQuantidade;
    }

    public BigDecimal getPecaValorUnitario() {
        return pecaValorUnitario;
    }

    public void setPecaValorUnitario(BigDecimal pecaValorUnitario) {
        this.pecaValorUnitario = pecaValorUnitario;
    }

    public BigDecimal getPecaValorTotal() {
        return pecaValorTotal;
    }

    public void setPecaValorTotal(BigDecimal pecaValorTotal) {
        this.pecaValorTotal = pecaValorTotal;
    }

    public BigDecimal getValorTotalPecas() {
        return valorTotalPecas;
    }

    public void setValorTotalPecas(BigDecimal valorTotalPecas) {
        this.valorTotalPecas = valorTotalPecas;
    }

    public BigDecimal getValorDescontoPecas() {
        return valorDescontoPecas;
    }

    public void setValorDescontoPecas(BigDecimal valorDescontoPecas) {
        this.valorDescontoPecas = valorDescontoPecas;
    }

    public BigDecimal getValorTotalOrcamento() {
        return valorTotalOrcamento;
    }

    public void setValorTotalOrcamento(BigDecimal valorTotalOrcamento) {
        this.valorTotalOrcamento = valorTotalOrcamento;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public int getParcelaCondicao() {
        return parcelaCondicao;
    }

    public void setParcelaCondicao(int parcelaCondicao) {
        this.parcelaCondicao = parcelaCondicao;
    }

    public int getParcelaNumero() {
        return parcelaNumero;
    }

    public void setParcelaNumero(int parcelaNumero) {
        this.parcelaNumero = parcelaNumero;
    }

    public LocalDate getParcelaVencimento() {
        return parcelaVencimento;
    }

    public void setParcelaVencimento(LocalDate parcelaVencimento) {
        this.parcelaVencimento = parcelaVencimento;
    }

    public BigDecimal getParcelaValor() {
        return parcelaValor;
    }

    public void setParcelaValor(BigDecimal parcelaValor) {
        this.parcelaValor = parcelaValor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
