
package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansSaidaEstoque {
    private Integer planilha;
    private String operacao;
    private LocalDate dataLancamento;
    private Integer pessoaCodigo;
    private String pessoaDescricao;
    private String notaFiscal;
    private Integer produtoCodigo;
    private String produtoDescricao;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private String usuario;

    public Integer getPlanilha() {
        return planilha;
    }

    public void setPlanilha(Integer planilha) {
        this.planilha = planilha;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Integer getPessoaCodigo() {
        return pessoaCodigo;
    }

    public void setPessoaCodigo(Integer pessoaCodigo) {
        this.pessoaCodigo = pessoaCodigo;
    }

    public String getPessoaDescricao() {
        return pessoaDescricao;
    }

    public void setPessoaDescricao(String pessoaDescricao) {
        this.pessoaDescricao = pessoaDescricao;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String NotaFiscal) {
        this.notaFiscal = NotaFiscal;
    }

    public Integer getProdutoCodigo() {
        return produtoCodigo;
    }

    public void setProdutoCodigo(Integer produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
      
}

