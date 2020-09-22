package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansCustosVeiculos {

  private int veiculoCodigo;
  private BigDecimal precoCompra;
  private BigDecimal precoVenda;
  private LocalDate dataCompra;
  private LocalDate dataVenda;
  private BigDecimal totalDespesas;
  private BigDecimal custosCombustivel;
  private BigDecimal custosDespachante;
  private BigDecimal custosImpostos;
  private BigDecimal custosLatariaPintura;
  private BigDecimal custosLimpeza;
  private BigDecimal custosMecanica;
  private BigDecimal custosPecasAcessorios;
  private BigDecimal custosPneus;
  private BigDecimal margemLucro;

    public int getVeiculoCodigo() {
        return veiculoCodigo;
    }

    public void setVeiculoCodigo(int veiculoCodigo) {
        this.veiculoCodigo = veiculoCodigo;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(BigDecimal totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public BigDecimal getCustosCombustivel() {
        return custosCombustivel;
    }

    public void setCustosCombustivel(BigDecimal custosCombustivel) {
        this.custosCombustivel = custosCombustivel;
    }

    public BigDecimal getCustosDespachante() {
        return custosDespachante;
    }

    public void setCustosDespachante(BigDecimal custosDespachante) {
        this.custosDespachante = custosDespachante;
    }

    public BigDecimal getCustosImpostos() {
        return custosImpostos;
    }

    public void setCustosImpostos(BigDecimal custosImpostos) {
        this.custosImpostos = custosImpostos;
    }

    public BigDecimal getCustosLatariaPintura() {
        return custosLatariaPintura;
    }

    public void setCustosLatariaPintura(BigDecimal custosLatariaPintura) {
        this.custosLatariaPintura = custosLatariaPintura;
    }

    public BigDecimal getCustosLimpeza() {
        return custosLimpeza;
    }

    public void setCustosLimpeza(BigDecimal custosLimpeza) {
        this.custosLimpeza = custosLimpeza;
    }

    public BigDecimal getCustosMecanica() {
        return custosMecanica;
    }

    public void setCustosMecanica(BigDecimal custosMecanica) {
        this.custosMecanica = custosMecanica;
    }

    public BigDecimal getCustosPecasAcessorios() {
        return custosPecasAcessorios;
    }

    public void setCustosPecasAcessorios(BigDecimal custosPecasAcessorios) {
        this.custosPecasAcessorios = custosPecasAcessorios;
    }

    public BigDecimal getCustosPneus() {
        return custosPneus;
    }

    public void setCustosPneus(BigDecimal custosPneus) {
        this.custosPneus = custosPneus;
    }

    public BigDecimal getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(BigDecimal margemLucro) {
        this.margemLucro = margemLucro;
    }
}
