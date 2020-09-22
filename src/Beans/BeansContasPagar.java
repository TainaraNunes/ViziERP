package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansContasPagar {

    private String operacao;
    private int planilha;
    private LocalDate dataLancamento;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private String documentoNumero;
    private String parcelaNumero;    
    private int formaPagamento;
    private String categoria;
    private int fornecedorCodigo;
    private String fornecedorDescricao;
    private BigDecimal valorTotalFatura;
    private BigDecimal valorDuplicata;
    private BigDecimal acrescimos;
    private BigDecimal descontos;
    private BigDecimal totalPagar;
    private String usuario;
        
    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

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

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
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

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getFornecedorCodigo() {
        return fornecedorCodigo;
    }

    public void setFornecedorCodigo(int fornecedorCodigo) {
        this.fornecedorCodigo = fornecedorCodigo;
    }

    public String getFornecedorDescricao() {
        return fornecedorDescricao;
    }

    public void setFornecedorDescricao(String fornecedorDescricao) {
        this.fornecedorDescricao = fornecedorDescricao;
    }

    public BigDecimal getValorTotalFatura() {
        return valorTotalFatura;
    }

    public void setValorTotalFatura(BigDecimal valorTotalFatura) {
        this.valorTotalFatura = valorTotalFatura;
    }

    public BigDecimal getValorDuplicata() {
        return valorDuplicata;
    }

    public void setValorDuplicata(BigDecimal valorDuplicata) {
        this.valorDuplicata = valorDuplicata;
    }

    public BigDecimal getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(BigDecimal acrescimos) {
        this.acrescimos = acrescimos;
    }

    public BigDecimal getDescontos() {
        return descontos;
    }

    public void setDescontos(BigDecimal descontos) {
        this.descontos = descontos;
    }

    public BigDecimal getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(BigDecimal totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
