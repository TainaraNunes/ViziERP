package Beans;

import java.math.BigDecimal;

public class BeansContasBancarias {
    String bancoCodigo;
    String bancoDescricao;
    String agencia;
    String contaCorrente;
    BigDecimal saldoInicial;
    BigDecimal saldoAtual;
    
    public String getBancoCodigo() {
        return bancoCodigo;
    }

    public void setBancoCodigo(String bancoCodigo) {
        this.bancoCodigo = bancoCodigo;
    }

    public String getBancoDescricao() {
        return bancoDescricao;
    }

    public void setBancoDescricao(String bancoDescricao) {
        this.bancoDescricao = bancoDescricao;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(BigDecimal saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
}
