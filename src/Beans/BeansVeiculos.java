package Beans;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BeansVeiculos {

    private Integer codigo;
    private String placa;
    private String marca;
    private String modelo;
    private String tipo;
    private String anoFabricacao;
    private String anoModelo;
    private String cor;
    private String combustivel;
    private String motor;
    private String chassi;
    private String renavam;
    private double km;
    private String transmissao;
    private Integer emEstoque;
    private String observacoes;
    private LocalDate dataCompra;
    private BigDecimal precoCompra;
    
    private int opcionalAirBag;
    private int opcionalAlarme;
    private int opcionalAlarmeSonoroRe;
    private int opcionalArCondicionado;
    private int opcionalArQuente;
    private int opcionalCDPlayer;        
    private int opcionalComputadorBordo;
    private int opcionalDirecaoHidraulica;
    private int opcionalFarolMilha;
    private int opcionalFarolNeblina;
    private int opcionalFreioABS;
    private int opcionalParabarroTraseiro;
    private int opcionalVidrosEletricos;
    private int opcionalRegulagemVoltante;
    private String outrosOpcionais;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public Integer getemEstoque() {
        return emEstoque;
    }

    public void setemEstoque(Integer emEstoque) {
        this.emEstoque = emEstoque;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(Integer emEstoque) {
        this.emEstoque = emEstoque;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    // Opcionais:    
    public int getOpcionalAirBag() {
        return opcionalAirBag;
    }

    public void setOpcionalAirBag(int opcionalAirBag) {
        this.opcionalAirBag = opcionalAirBag;
    }

    public int getOpcionalAlarme() {
        return opcionalAlarme;
    }

    public void setOpcionalAlarme(int opcionalAlarme) {
        this.opcionalAlarme = opcionalAlarme;
    }

    public int getOpcionalAlarmeSonoroRe() {
        return opcionalAlarmeSonoroRe;
    }

    public void setOpcionalAlarmeSonoroRe(int opcionalAlarmeSonoroRe) {
        this.opcionalAlarmeSonoroRe = opcionalAlarmeSonoroRe;
    }

    public int getOpcionalArCondicionado() {
        return opcionalArCondicionado;
    }

    public void setOpcionalArCondicionado(int opcionalArCondicionado) {
        this.opcionalArCondicionado = opcionalArCondicionado;
    }
    
    public int getOpcionalArQuente() {
        return opcionalArQuente;
    }

    public void setOpcionalArQuente(int opcionalArQuente) {
        this.opcionalArQuente = opcionalArQuente;
    }    

    public int getOpcionalCDPlayer() {
        return opcionalCDPlayer;
    }

    public void setOpcionalCDPlayer(int opcionalCDPlayer) {
        this.opcionalCDPlayer = opcionalCDPlayer;
    }

    public int getOpcionalComputadorBordo() {
        return opcionalComputadorBordo;
    }

    public void setOpcionalComputadorBordo(int opcionalComputadorBordo) {
        this.opcionalComputadorBordo = opcionalComputadorBordo;
    }

    public int getOpcionalDirecaoHidraulica() {
        return opcionalDirecaoHidraulica;
    }

    public void setOpcionalDirecaoHidraulica(int opcionalDirecaoHidraulica) {
        this.opcionalDirecaoHidraulica = opcionalDirecaoHidraulica;
    }

    public int getOpcionalFarolMilha() {
        return opcionalFarolMilha;
    }

    public void setOpcionalFarolMilha(int opcionalFarolMilha) {
        this.opcionalFarolMilha = opcionalFarolMilha;
    }

    public int getOpcionalFarolNeblina() {
        return opcionalFarolNeblina;
    }

    public void setOpcionalFarolNeblina(int opcionalFarolNeblina) {
        this.opcionalFarolNeblina = opcionalFarolNeblina;
    }

    public int getOpcionalFreioABS() {
        return opcionalFreioABS;
    }

    public void setOpcionalFreioABS(int opcionalFreioABS) {
        this.opcionalFreioABS = opcionalFreioABS;
    }

    public int getOpcionalParabarroTraseiro() {
        return opcionalParabarroTraseiro;
    }

    public void setOpcionalParabarroTraseiro(int opcionalParabarroTraseiro) {
        this.opcionalParabarroTraseiro = opcionalParabarroTraseiro;
    }

    public int getOpcionalVidrosEletricos() {
        return opcionalVidrosEletricos;
    }

    public void setOpcionalVidrosEletricos(int opcionalVidrosEletricos) {
        this.opcionalVidrosEletricos = opcionalVidrosEletricos;
    }

    public int getOpcionalRegulagemVoltante() {
        return opcionalRegulagemVoltante;
    }

    public void setOpcionalRegulagemVoltante(int opcionalRegulagemVoltante) {
        this.opcionalRegulagemVoltante = opcionalRegulagemVoltante;
    }

    public String getOutrosOpcionais() {
        return outrosOpcionais;
    }

    public void setOutrosOpcionais(String outrosOpcionais) {
        this.outrosOpcionais = outrosOpcionais;
    } 
}
