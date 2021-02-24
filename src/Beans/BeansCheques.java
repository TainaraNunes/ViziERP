package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansCheques {
    private String bancoCodigo;
    private String numeroCheque;
    private LocalDate dataVencimento;
    private BigDecimal valor;
    private String situacao;
    private LocalDate situacaoData;
    private int titularCodigo;
    private String titularDescricao;
    private String titularCPFCNPJ;
    private int emitenteCodigo;
    private String emitenteDescricao;
    private String emitenteCPFCNPJ;
    private String observacao;
    private String documento;
    private String parcelaNumero;

    public String getBancoCodigo() {
        return bancoCodigo;
    }

    public void setBancoCodigo(String bancoCodigo) {
        this.bancoCodigo = bancoCodigo;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDate getSituacaoData() {
        return situacaoData;
    }

    public void setSituacaoData(LocalDate situacaoData) {
        this.situacaoData = situacaoData;
    }

    public int getTitularCodigo() {
        return titularCodigo;
    }

    public void setTitularCodigo(int titularCodigo) {
        this.titularCodigo = titularCodigo;
    }

    public String getTitularDescricao() {
        return titularDescricao;
    }

    public void setTitularDescricao(String titularDescricao) {
        this.titularDescricao = titularDescricao;
    }

    public String getTitularCPFCNPJ() {
        return titularCPFCNPJ;
    }

    public void setTitularCPFCNPJ(String titularCPFCNPJ) {
        this.titularCPFCNPJ = titularCPFCNPJ;
    }

    public int getEmitenteCodigo() {
        return emitenteCodigo;
    }

    public void setEmitenteCodigo(int emitenteCodigo) {
        this.emitenteCodigo = emitenteCodigo;
    }

    public String getEmitenteDescricao() {
        return emitenteDescricao;
    }

    public void setEmitenteDescricao(String emitenteDescricao) {
        this.emitenteDescricao = emitenteDescricao;
    }

    public String getEmitenteCPFCNPJ() {
        return emitenteCPFCNPJ;
    }

    public void setEmitenteCPFCNPJ(String emitenteCPFCNPJ) {
        this.emitenteCPFCNPJ = emitenteCPFCNPJ;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getParcelaNumero() {
        return parcelaNumero;
    }

    public void setParcelaNumero(String parcelaNumero) {
        this.parcelaNumero = parcelaNumero;
    }  
    
}
