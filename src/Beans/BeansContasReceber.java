package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansContasReceber {

    private String operacao;
    private int planilha;
    private LocalDate dataLancamento;
    private String documentoNumero;
    private BigDecimal valorTotalFatura;
    private int formaPagamento;
    private String categoria;
    private int clienteCodigo;
    private String clienteDescricao;
    private String parcelaNumero;
    private LocalDate dataVencimento;
    private LocalDate dataRecebimento;
    private BigDecimal valorDuplicata;
    private BigDecimal acrescimos;
    private BigDecimal descontos;
    private BigDecimal totalReceber;
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

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getDocumentoNumero() {
        return documentoNumero;
    }

    public void setDocumentoNumero(String documentoNumero) {
        this.documentoNumero = documentoNumero;
    }

    public BigDecimal getValorTotalFatura() {
        return valorTotalFatura;
    }

    public void setValorTotalFatura(BigDecimal valorTotalFatura) {
        this.valorTotalFatura = valorTotalFatura;
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

    public String getParcelaNumero() {
        return parcelaNumero;
    }

    public void setParcelaNumero(String parcelaNumero) {
        this.parcelaNumero = parcelaNumero;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public BigDecimal getTotalReceber() {
        return totalReceber;
    }

    public void setTotalReceber(BigDecimal totalReceber) {
        this.totalReceber = totalReceber;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
