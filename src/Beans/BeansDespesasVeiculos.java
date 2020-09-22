package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansDespesasVeiculos {

    private int planilha;
    private LocalDate dataLancamento;
    private int veiculoCodigo;
    private int fornecedorCodigo;
    private String despesaDescricao;
    private String categoria;
    private BigDecimal despesaValor;

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

    public int getVeiculoCodigo() {
        return veiculoCodigo;
    }

    public void setVeiculoCodigo(int veiculoCodigo) {
        this.veiculoCodigo = veiculoCodigo;
    }
    
    public int getFornecedorCodigo() {
        return fornecedorCodigo;
    }

    public void setFornecedorCodigo(int fornecedorCodigo) {
        this.fornecedorCodigo = fornecedorCodigo;
    }

    public String getDespesaDescricao() {
        return despesaDescricao;
    }

    public void setDespesaDescricao(String despesaDescricao) {
        this.despesaDescricao = despesaDescricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getDespesaValor() {
        return despesaValor;
    }

    public void setDespesaValor(BigDecimal despesaValor) {
        this.despesaValor = despesaValor;
    }
}
