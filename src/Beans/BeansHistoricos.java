package Beans;

public class BeansHistoricos {

    String historicoCodigo;
    String historicoDescricao;
    String tipoLancamento;
    String bancoCodigo;
    String bancoDescricao;
    String contaCorrente;
    int movimentaDuplicatas;
    int movimentaCheque;
    int movimentaSaldoBancario;
    int ativo; 

    public String getHistoricoCodigo() {
        return historicoCodigo;
    }

    public void setHistoricoCodigo(String historicoCodigo) {
        this.historicoCodigo = historicoCodigo;
    }

    public String getHistoricoDescricao() {
        return historicoDescricao;
    }

    public void setHistoricoDescricao(String historicoDescricao) {
        this.historicoDescricao = historicoDescricao;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

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

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
        
    public int getMovimentaDuplicatas() {
        return movimentaDuplicatas;
    }

    public void setMovimentaDuplicatas(int movimentaDuplicatas) {
        this.movimentaDuplicatas = movimentaDuplicatas;
    }

    public int getMovimentaCheque() {
        return movimentaCheque;
    }

    public void setMovimentaCheque(int movimentaCheque) {
        this.movimentaCheque = movimentaCheque;
    }

    public int getMovimentaSaldoBancario() {
        return movimentaSaldoBancario;
    }

    public void setMovimentaSaldo(int movimentaSaldoBancario) {
        this.movimentaSaldoBancario = movimentaSaldoBancario;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}
