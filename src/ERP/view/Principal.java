package ERP.view;

import Relatorios.RelatorioContasPagar;
import Relatorios.RelatorioContasReceber;
import Relatorios.RelatorioCustosPorVeiculo;
import Relatorios.RelatorioDespesasPorVeiculo;
import Relatorios.RelatorioEstoqueVeiculos;
import Relatorios.RelatorioLancamentoCaixa;
import Relatorios.RelatorioOrcamentosEmitidos;
import Relatorios.RelatorioProdutosEmEstoque;
import java.io.IOException;
import java.sql.SQLException;
import Conection.ConectaBD;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Principal extends javax.swing.JFrame {
    
    ConectaBD conecta = new ConectaBD();

    public Principal(String usuario) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
        //conecta.conexao();        
        //validarAcessoUsuario(usuario);
        lblUsuarioLogado.setText(usuario);
        lblEmpresaLogada.setText(String.valueOf(EmpresaLogada()));
       
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        lblDataHoraAtual.setText(data.format(new Date()));       
    }

    private Principal() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsuarioLogado = new javax.swing.JLabel();
        lblDataHoraAtual = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEmpresaLogada = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastros = new javax.swing.JMenu();
        MenuCadastrosPessoas = new javax.swing.JMenuItem();
        MenuCadastrosUusuarios = new javax.swing.JMenuItem();
        MenuCadastrosEmpresas = new javax.swing.JMenuItem();
        MenuComercial = new javax.swing.JMenu();
        MenuCadastrosProdutos = new javax.swing.JMenuItem();
        MenuComercialEstoque = new javax.swing.JMenu();
        MenuEstoqueEntrada = new javax.swing.JMenuItem();
        MenuEstoqueSaida = new javax.swing.JMenuItem();
        MenuEstoqueRelatorios = new javax.swing.JMenu();
        MenuEstoqueRelatoriosProdutosEstoque = new javax.swing.JMenuItem();
        MenuServicos = new javax.swing.JMenu();
        MenuServicosCadastroServicos = new javax.swing.JMenuItem();
        MenuServicosOrcamento = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        MenuServicosRelatoriosOrcamentosEmitidos = new javax.swing.JMenuItem();
        MenuVeiculos = new javax.swing.JMenu();
        MenuVeiculosCadastroVeiculos = new javax.swing.JMenuItem();
        MenuVeiculosCustos = new javax.swing.JMenu();
        MenuVeiculosCustosLancamentoCusto = new javax.swing.JMenuItem();
        MenuVeiculosCustosRelatorioCustosPorVeiculo = new javax.swing.JMenuItem();
        MenuVeiculosLancamentosDespesas = new javax.swing.JMenuItem();
        MenuVeiculosRelatorios = new javax.swing.JMenu();
        MenuVeiculosRelatoriosEstoqueVeiculos = new javax.swing.JMenuItem();
        MenuVeiculosRelatoriosDespesasPorVeiculo = new javax.swing.JMenuItem();
        MenuFinanceiro = new javax.swing.JMenu();
        MenuFinanceiroLancamentoContasPagar = new javax.swing.JMenuItem();
        MenuFinanceiroLancamentoContasReceber = new javax.swing.JMenuItem();
        MenuFinanceiroLancamentoCaixa = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuFinanceiroRelatorios = new javax.swing.JMenu();
        MenuFinanceiroRelatoriosContasPagar = new javax.swing.JMenuItem();
        MenuFinanceiroRelatoriosContasReceber = new javax.swing.JMenuItem();
        MenuFinanceiroRelatoriosLancamentosCaixa = new javax.swing.JMenuItem();
        MenuFinanceiroRelatoriosPosicaoFinanceira = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MenuFinanceiroConfiguracoes = new javax.swing.JMenu();
        MenuFinanceiroConfiguracoesCadastroContasBancarias = new javax.swing.JMenuItem();
        MenuFinanceiroConfiguracoesCadastroFormasPagamento = new javax.swing.JMenuItem();
        MenuFinanceiroConfiguracoesCadastroHistoricos = new javax.swing.JMenuItem();
        MenuFinanceiroConfiguracoesCadastroCategorias = new javax.swing.JMenuItem();
        MenuSuporte = new javax.swing.JMenu();
        MenuSuporteConexao = new javax.swing.JMenuItem();
        MenuSuporteBackup = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem Vindo!");

        jLabel1.setText("Usuário:");

        lblDataHoraAtual.setText("jLabel2");

        jLabel2.setText("Empresa:");

        MenuCadastros.setText("Cadastros");
        MenuCadastros.setName("MenuCadastros"); // NOI18N

        MenuCadastrosPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastropessoas.png"))); // NOI18N
        MenuCadastrosPessoas.setText("Pessoas");
        MenuCadastrosPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrosPessoasActionPerformed(evt);
            }
        });
        MenuCadastros.add(MenuCadastrosPessoas);

        MenuCadastrosUusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastrousuarios.png"))); // NOI18N
        MenuCadastrosUusuarios.setText("Usuários");
        MenuCadastrosUusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrosUusuariosActionPerformed(evt);
            }
        });
        MenuCadastros.add(MenuCadastrosUusuarios);

        MenuCadastrosEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastroempresas.png"))); // NOI18N
        MenuCadastrosEmpresas.setText("Empresas");
        MenuCadastrosEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrosEmpresasActionPerformed(evt);
            }
        });
        MenuCadastros.add(MenuCadastrosEmpresas);

        jMenuBar1.add(MenuCadastros);

        MenuComercial.setText("Comercial");
        MenuComercial.setName("MenuComercial"); // NOI18N
        MenuComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuComercialActionPerformed(evt);
            }
        });

        MenuCadastrosProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastroprodutos.png"))); // NOI18N
        MenuCadastrosProdutos.setText("Cadastro de Produtos");
        MenuCadastrosProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrosProdutosActionPerformed(evt);
            }
        });
        MenuComercial.add(MenuCadastrosProdutos);

        MenuComercialEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/comercialestoque.png"))); // NOI18N
        MenuComercialEstoque.setText("Estoque");

        MenuEstoqueEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/estoqueentrada.png"))); // NOI18N
        MenuEstoqueEntrada.setText("Entrada");
        MenuEstoqueEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstoqueEntradaActionPerformed(evt);
            }
        });
        MenuComercialEstoque.add(MenuEstoqueEntrada);

        MenuEstoqueSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastroprodutos.png"))); // NOI18N
        MenuEstoqueSaida.setText("Saída");
        MenuEstoqueSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstoqueSaidaActionPerformed(evt);
            }
        });
        MenuComercialEstoque.add(MenuEstoqueSaida);

        MenuComercial.add(MenuComercialEstoque);

        MenuEstoqueRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatoriosestoque.png"))); // NOI18N
        MenuEstoqueRelatorios.setText("Relatórios");

        MenuEstoqueRelatoriosProdutosEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatoriosestoque.png"))); // NOI18N
        MenuEstoqueRelatoriosProdutosEstoque.setText("Produtos em Estoque");
        MenuEstoqueRelatoriosProdutosEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEstoqueRelatoriosProdutosEstoqueActionPerformed(evt);
            }
        });
        MenuEstoqueRelatorios.add(MenuEstoqueRelatoriosProdutosEstoque);

        MenuComercial.add(MenuEstoqueRelatorios);

        jMenuBar1.add(MenuComercial);

        MenuServicos.setText("Serviços");

        MenuServicosCadastroServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastroservicos.png"))); // NOI18N
        MenuServicosCadastroServicos.setText("Cadastro de Serviços");
        MenuServicosCadastroServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServicosCadastroServicosActionPerformed(evt);
            }
        });
        MenuServicos.add(MenuServicosCadastroServicos);

        MenuServicosOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/orcamento.png"))); // NOI18N
        MenuServicosOrcamento.setText("Orçamento");
        MenuServicosOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServicosOrcamentoActionPerformed(evt);
            }
        });
        MenuServicos.add(MenuServicosOrcamento);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatoriosestoque.png"))); // NOI18N
        jMenu1.setText("Relatórios");

        MenuServicosRelatoriosOrcamentosEmitidos.setText("Orçamentos Emitidos");
        MenuServicosRelatoriosOrcamentosEmitidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuServicosRelatoriosOrcamentosEmitidosActionPerformed(evt);
            }
        });
        jMenu1.add(MenuServicosRelatoriosOrcamentosEmitidos);

        MenuServicos.add(jMenu1);

        jMenuBar1.add(MenuServicos);

        MenuVeiculos.setText("Veículos");

        MenuVeiculosCadastroVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadastroveiculos.png"))); // NOI18N
        MenuVeiculosCadastroVeiculos.setText("Cadastro de Veículos");
        MenuVeiculosCadastroVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVeiculosCadastroVeiculosActionPerformed(evt);
            }
        });
        MenuVeiculos.add(MenuVeiculosCadastroVeiculos);

        MenuVeiculosCustos.setText("Custos de Veículos");

        MenuVeiculosCustosLancamentoCusto.setText("Lançamento de Custos");
        MenuVeiculosCustosLancamentoCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVeiculosCustosLancamentoCustoActionPerformed(evt);
            }
        });
        MenuVeiculosCustos.add(MenuVeiculosCustosLancamentoCusto);

        MenuVeiculosCustosRelatorioCustosPorVeiculo.setText("Consulta Custos por Veículo");
        MenuVeiculosCustosRelatorioCustosPorVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVeiculosCustosRelatorioCustosPorVeiculoActionPerformed(evt);
            }
        });
        MenuVeiculosCustos.add(MenuVeiculosCustosRelatorioCustosPorVeiculo);

        MenuVeiculos.add(MenuVeiculosCustos);

        MenuVeiculosLancamentosDespesas.setText("Lançamento de Despesas");
        MenuVeiculosLancamentosDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVeiculosLancamentosDespesasActionPerformed(evt);
            }
        });
        MenuVeiculos.add(MenuVeiculosLancamentosDespesas);

        MenuVeiculosRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatoriosestoque.png"))); // NOI18N
        MenuVeiculosRelatorios.setText("Relatórios");

        MenuVeiculosRelatoriosEstoqueVeiculos.setText("Estoque de Veículos");
        MenuVeiculosRelatoriosEstoqueVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVeiculosRelatoriosEstoqueVeiculosActionPerformed(evt);
            }
        });
        MenuVeiculosRelatorios.add(MenuVeiculosRelatoriosEstoqueVeiculos);

        MenuVeiculosRelatoriosDespesasPorVeiculo.setText("Despesas por Veículos");
        MenuVeiculosRelatoriosDespesasPorVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVeiculosRelatoriosDespesasPorVeiculoActionPerformed(evt);
            }
        });
        MenuVeiculosRelatorios.add(MenuVeiculosRelatoriosDespesasPorVeiculo);

        MenuVeiculos.add(MenuVeiculosRelatorios);

        jMenuBar1.add(MenuVeiculos);

        MenuFinanceiro.setText("Financeiro");

        MenuFinanceiroLancamentoContasPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/contaspagar.png"))); // NOI18N
        MenuFinanceiroLancamentoContasPagar.setText("Lançamento de Contas a Pagar");
        MenuFinanceiroLancamentoContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroLancamentoContasPagarActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MenuFinanceiroLancamentoContasPagar);

        MenuFinanceiroLancamentoContasReceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/contasreceber.png"))); // NOI18N
        MenuFinanceiroLancamentoContasReceber.setText("Lançamento de Contas a Receber");
        MenuFinanceiroLancamentoContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroLancamentoContasReceberActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MenuFinanceiroLancamentoContasReceber);

        MenuFinanceiroLancamentoCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lancamentocaixa.png"))); // NOI18N
        MenuFinanceiroLancamentoCaixa.setText("Lançamento de Caixa");
        MenuFinanceiroLancamentoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroLancamentoCaixaActionPerformed(evt);
            }
        });
        MenuFinanceiro.add(MenuFinanceiroLancamentoCaixa);
        MenuFinanceiro.add(jSeparator1);

        MenuFinanceiroRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatoriosfinanceiro.png"))); // NOI18N
        MenuFinanceiroRelatorios.setText("Relatórios");

        MenuFinanceiroRelatoriosContasPagar.setText("Contas a Pagar");
        MenuFinanceiroRelatoriosContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroRelatoriosContasPagarActionPerformed(evt);
            }
        });
        MenuFinanceiroRelatorios.add(MenuFinanceiroRelatoriosContasPagar);

        MenuFinanceiroRelatoriosContasReceber.setText("Contas a Receber");
        MenuFinanceiroRelatoriosContasReceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroRelatoriosContasReceberActionPerformed(evt);
            }
        });
        MenuFinanceiroRelatorios.add(MenuFinanceiroRelatoriosContasReceber);

        MenuFinanceiroRelatoriosLancamentosCaixa.setText("Lançamentos de Caixa");
        MenuFinanceiroRelatoriosLancamentosCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroRelatoriosLancamentosCaixaActionPerformed(evt);
            }
        });
        MenuFinanceiroRelatorios.add(MenuFinanceiroRelatoriosLancamentosCaixa);

        MenuFinanceiroRelatoriosPosicaoFinanceira.setText("Posição Financeira");
        MenuFinanceiroRelatoriosPosicaoFinanceira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroRelatoriosPosicaoFinanceiraActionPerformed(evt);
            }
        });
        MenuFinanceiroRelatorios.add(MenuFinanceiroRelatoriosPosicaoFinanceira);

        MenuFinanceiro.add(MenuFinanceiroRelatorios);
        MenuFinanceiro.add(jSeparator2);

        MenuFinanceiroConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/configuracoes.png"))); // NOI18N
        MenuFinanceiroConfiguracoes.setText("Configurações");

        MenuFinanceiroConfiguracoesCadastroContasBancarias.setText("Cadastro de Contas Bancárias");
        MenuFinanceiroConfiguracoesCadastroContasBancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroConfiguracoesCadastroContasBancariasActionPerformed(evt);
            }
        });
        MenuFinanceiroConfiguracoes.add(MenuFinanceiroConfiguracoesCadastroContasBancarias);

        MenuFinanceiroConfiguracoesCadastroFormasPagamento.setText("Cadasto de Formas de Pagamento");
        MenuFinanceiroConfiguracoesCadastroFormasPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroConfiguracoesCadastroFormasPagamentoActionPerformed(evt);
            }
        });
        MenuFinanceiroConfiguracoes.add(MenuFinanceiroConfiguracoesCadastroFormasPagamento);

        MenuFinanceiroConfiguracoesCadastroHistoricos.setText("Cadastro de Históricos");
        MenuFinanceiroConfiguracoesCadastroHistoricos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroConfiguracoesCadastroHistoricosActionPerformed(evt);
            }
        });
        MenuFinanceiroConfiguracoes.add(MenuFinanceiroConfiguracoesCadastroHistoricos);

        MenuFinanceiroConfiguracoesCadastroCategorias.setText("Cadastro de Categorias");
        MenuFinanceiroConfiguracoesCadastroCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFinanceiroConfiguracoesCadastroCategoriasActionPerformed(evt);
            }
        });
        MenuFinanceiroConfiguracoes.add(MenuFinanceiroConfiguracoesCadastroCategorias);

        MenuFinanceiro.add(MenuFinanceiroConfiguracoes);

        jMenuBar1.add(MenuFinanceiro);

        MenuSuporte.setText("Suporte");

        MenuSuporteConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/suporteconexao.png"))); // NOI18N
        MenuSuporteConexao.setText("Conexão");
        MenuSuporteConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSuporteConexaoActionPerformed(evt);
            }
        });
        MenuSuporte.add(MenuSuporteConexao);

        MenuSuporteBackup.setText("Backup");
        MenuSuporteBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSuporteBackupActionPerformed(evt);
            }
        });
        MenuSuporte.add(MenuSuporteBackup);

        jMenuBar1.add(MenuSuporte);

        MenuSair.setText("Sair");
        MenuSair.setName("MenuSair"); // NOI18N
        MenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(MenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmpresaLogada, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDataHoraAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblEmpresaLogada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDataHoraAtual)
                                .addComponent(jLabel2)))))
                .addContainerGap())
        );

        setBounds(0, 0, 634, 387);
    }// </editor-fold>//GEN-END:initComponents
    
    public String EmpresaLogada() {
        String empresa = "";

        conecta.conexao();
        conecta.executaSql("SELECT FANTASIA FROM EMPRESAS");

        try {
            if (conecta.rs.next()) {
                empresa = conecta.rs.getString("FANTASIA");
            } else {
                empresa = "";
                JOptionPane.showMessageDialog(null, "Nenhuma empresa encontrada!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar planilhas! \n ERRO: " + ex);
        }

        conecta.desconecta();
        return empresa;
    }
    
    public void validarAcessoUsuario(String usuario){
        String grupo = null;
        boolean acessoCadastros = false, acessoComercial = false, acessoFinanceiro = false;
        boolean acessoServicos = false, acessoVeiculos = false, acessoVeiculosCustos = false, acessoSuporte = false;
        
        conecta.conexao();
        conecta.executaSql("SELECT * FROM USUARIOS WHERE USUARIO = '" + usuario + "'");
        
        try {
            if (conecta.rs.next()) {
                grupo = conecta.rs.getString("GRUPO").trim();
            } 

            switch (grupo){
                case "ADMINISTRATIVO":
                    acessoCadastros = true;
                    acessoVeiculos = true;
                    acessoFinanceiro = true;
                    acessoSuporte = true;
                    break;                    
                case "FINANCEIRO":
                    acessoFinanceiro = true;
                    break;                    
                case "COMERCIAL":
                    acessoComercial = true;
                    break;                    
                case "SERVICOS":
                    acessoServicos = true;
                    break;                    
                case "VENDAS":
                    acessoServicos = true;
                    acessoComercial = true;                    
                    break;
                case "COMPRAS":
                    acessoComercial = true;                    
                    break;
                case "DIRECAO":
                    acessoCadastros = true;
                    acessoComercial = true;
                    acessoFinanceiro = true;
                    acessoServicos = true;
                    acessoVeiculos = true;
                    acessoVeiculosCustos = true;
                    acessoSuporte = true;
                    break;                    
            }
            
            if (acessoCadastros == true){
                MenuCadastros.setEnabled(true);
            } else {
                MenuCadastros.setEnabled(false);
            }
            
            if (acessoComercial == true){
                MenuComercial.setEnabled(true);
                MenuCadastros.setEnabled(true);
            } else {
                MenuComercial.setEnabled(false);
            }
            
            if (acessoFinanceiro == true){
                MenuFinanceiro.setEnabled(true);
            } else {
                MenuFinanceiro.setEnabled(false);
            }
            
            if (acessoServicos == true){
                MenuServicos.setEnabled(true);
            } else {
                MenuServicos.setEnabled(false);
            }
            
            if (acessoVeiculos == true){
                MenuVeiculos.setEnabled(true);
            } else {
                MenuVeiculos.setEnabled(false);
            }
            
            if (acessoVeiculosCustos == true){
                MenuVeiculosCustos.setEnabled(true);
            } else {
                MenuVeiculosCustos.setEnabled(false);
            }
            
            if (acessoSuporte == true){
                MenuSuporte.setEnabled(true);
            } else {
                MenuSuporte.setEnabled(false);
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar acessos do usuário! \n ERRO: " + ex);
        }
        conecta.desconecta();
    }
    
    private void MenuCadastrosUusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrosUusuariosActionPerformed
        CadastroUsuarios obj = new CadastroUsuarios();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuCadastrosUusuariosActionPerformed

    private void MenuCadastrosPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrosPessoasActionPerformed
        CadastroPessoas obj = new CadastroPessoas();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuCadastrosPessoasActionPerformed

    private void MenuCadastrosProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrosProdutosActionPerformed
        CadastroProdutos obj = new CadastroProdutos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuCadastrosProdutosActionPerformed

    private void MenuFinanceiroRelatoriosContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroRelatoriosContasReceberActionPerformed
        RelatorioContasReceber obj = new RelatorioContasReceber();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroRelatoriosContasReceberActionPerformed

    private void MenuFinanceiroRelatoriosPosicaoFinanceiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroRelatoriosPosicaoFinanceiraActionPerformed
        ConsultaContasPagarReceber obj = new ConsultaContasPagarReceber();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroRelatoriosPosicaoFinanceiraActionPerformed

    private void MenuFinanceiroLancamentoContasReceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroLancamentoContasReceberActionPerformed
        LancamentoContasReceber obj = new LancamentoContasReceber();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroLancamentoContasReceberActionPerformed

    private void MenuFinanceiroLancamentoContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroLancamentoContasPagarActionPerformed
        LancamentoContasPagar obj = new LancamentoContasPagar();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroLancamentoContasPagarActionPerformed

    private void MenuFinanceiroLancamentoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroLancamentoCaixaActionPerformed
        LancamentoCaixa obj = new LancamentoCaixa();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroLancamentoCaixaActionPerformed

    private void MenuFinanceiroConfiguracoesCadastroHistoricosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroConfiguracoesCadastroHistoricosActionPerformed
        CadastroHistoricos obj = new CadastroHistoricos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroConfiguracoesCadastroHistoricosActionPerformed

    private void MenuFinanceiroRelatoriosContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroRelatoriosContasPagarActionPerformed
        RelatorioContasPagar obj = new RelatorioContasPagar();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroRelatoriosContasPagarActionPerformed

    private void MenuFinanceiroConfiguracoesCadastroFormasPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroConfiguracoesCadastroFormasPagamentoActionPerformed
        CadastroFormasPagamento obj = new CadastroFormasPagamento();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroConfiguracoesCadastroFormasPagamentoActionPerformed

    private void MenuFinanceiroConfiguracoesCadastroContasBancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroConfiguracoesCadastroContasBancariasActionPerformed
        CadastroContaBancaria obj = new CadastroContaBancaria();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroConfiguracoesCadastroContasBancariasActionPerformed

    private void MenuComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuComercialActionPerformed

    }//GEN-LAST:event_MenuComercialActionPerformed

    private void MenuEstoqueRelatoriosProdutosEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstoqueRelatoriosProdutosEstoqueActionPerformed
        RelatorioProdutosEmEstoque obj = new RelatorioProdutosEmEstoque();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuEstoqueRelatoriosProdutosEstoqueActionPerformed

    private void MenuEstoqueSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstoqueSaidaActionPerformed
        EstoqueSaida obj = new EstoqueSaida();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuEstoqueSaidaActionPerformed

    private void MenuEstoqueEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEstoqueEntradaActionPerformed
        EstoqueEntrada obj = new EstoqueEntrada();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuEstoqueEntradaActionPerformed

    private void MenuFinanceiroRelatoriosLancamentosCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroRelatoriosLancamentosCaixaActionPerformed
        RelatorioLancamentoCaixa obj = new RelatorioLancamentoCaixa();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuFinanceiroRelatoriosLancamentosCaixaActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked
        System.exit(0);
        conecta.desconecta();
    }//GEN-LAST:event_MenuSairMouseClicked

    private void MenuSuporteConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSuporteConexaoActionPerformed
        ConexaoBancoDados obj = new ConexaoBancoDados();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuSuporteConexaoActionPerformed

    private void MenuCadastrosEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrosEmpresasActionPerformed
        CadastroEmpresas obj = new CadastroEmpresas();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);
    }//GEN-LAST:event_MenuCadastrosEmpresasActionPerformed

    private void MenuServicosCadastroServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServicosCadastroServicosActionPerformed
        CadastroServicos obj = new CadastroServicos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);        
    }//GEN-LAST:event_MenuServicosCadastroServicosActionPerformed

    private void MenuVeiculosCadastroVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVeiculosCadastroVeiculosActionPerformed
        CadastroVeiculos obj = new CadastroVeiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);        
    }//GEN-LAST:event_MenuVeiculosCadastroVeiculosActionPerformed

    private void MenuFinanceiroConfiguracoesCadastroCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFinanceiroConfiguracoesCadastroCategoriasActionPerformed
        CadastroCategoriasFinanceiro obj = new CadastroCategoriasFinanceiro();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);        
    }//GEN-LAST:event_MenuFinanceiroConfiguracoesCadastroCategoriasActionPerformed

    private void MenuVeiculosRelatoriosDespesasPorVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVeiculosRelatoriosDespesasPorVeiculoActionPerformed
        RelatorioDespesasPorVeiculo obj = new RelatorioDespesasPorVeiculo();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);        
    }//GEN-LAST:event_MenuVeiculosRelatoriosDespesasPorVeiculoActionPerformed

    private void MenuVeiculosLancamentosDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVeiculosLancamentosDespesasActionPerformed
        DespesasVeiculos obj = new DespesasVeiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);   
    }//GEN-LAST:event_MenuVeiculosLancamentosDespesasActionPerformed

    private void MenuVeiculosCustosLancamentoCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVeiculosCustosLancamentoCustoActionPerformed
        CustosVeiculos obj = new CustosVeiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);   
    }//GEN-LAST:event_MenuVeiculosCustosLancamentoCustoActionPerformed

    private void MenuVeiculosCustosRelatorioCustosPorVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVeiculosCustosRelatorioCustosPorVeiculoActionPerformed
        RelatorioCustosPorVeiculo obj = new RelatorioCustosPorVeiculo();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);   
    }//GEN-LAST:event_MenuVeiculosCustosRelatorioCustosPorVeiculoActionPerformed

    private void MenuVeiculosRelatoriosEstoqueVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVeiculosRelatoriosEstoqueVeiculosActionPerformed
        RelatorioEstoqueVeiculos obj = new RelatorioEstoqueVeiculos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);   
    }//GEN-LAST:event_MenuVeiculosRelatoriosEstoqueVeiculosActionPerformed

    private void MenuSuporteBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSuporteBackupActionPerformed
        try {
            Runtime.getRuntime().exec("cmd.exe /c c:\\BKP\\BKPViziPostos.bat");
            Runtime.getRuntime().exec("cmd.exe /c c:\\BKP\\BKPVizitrucks.bat");
            JOptionPane.showMessageDialog(null, "Backup executado com sucesso!");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao executar backup! Verifique!");
        }
    }//GEN-LAST:event_MenuSuporteBackupActionPerformed

    private void MenuServicosOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServicosOrcamentoActionPerformed
        Orcamento obj = new Orcamento();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);   
    }//GEN-LAST:event_MenuServicosOrcamentoActionPerformed

    private void MenuServicosRelatoriosOrcamentosEmitidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuServicosRelatoriosOrcamentosEmitidosActionPerformed
        Relatorios.RelatorioOrcamentosEmitidos obj = new RelatorioOrcamentosEmitidos();
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setResizable(false);   
    }//GEN-LAST:event_MenuServicosRelatoriosOrcamentosEmitidosActionPerformed
    
    public static void main(String args[]) {
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu MenuCadastros;
    private javax.swing.JMenuItem MenuCadastrosEmpresas;
    private javax.swing.JMenuItem MenuCadastrosPessoas;
    private javax.swing.JMenuItem MenuCadastrosProdutos;
    private javax.swing.JMenuItem MenuCadastrosUusuarios;
    public javax.swing.JMenu MenuComercial;
    private javax.swing.JMenu MenuComercialEstoque;
    private javax.swing.JMenuItem MenuEstoqueEntrada;
    private javax.swing.JMenu MenuEstoqueRelatorios;
    private javax.swing.JMenuItem MenuEstoqueRelatoriosProdutosEstoque;
    private javax.swing.JMenuItem MenuEstoqueSaida;
    public javax.swing.JMenu MenuFinanceiro;
    private javax.swing.JMenu MenuFinanceiroConfiguracoes;
    private javax.swing.JMenuItem MenuFinanceiroConfiguracoesCadastroCategorias;
    private javax.swing.JMenuItem MenuFinanceiroConfiguracoesCadastroContasBancarias;
    private javax.swing.JMenuItem MenuFinanceiroConfiguracoesCadastroFormasPagamento;
    private javax.swing.JMenuItem MenuFinanceiroConfiguracoesCadastroHistoricos;
    private javax.swing.JMenuItem MenuFinanceiroLancamentoCaixa;
    private javax.swing.JMenuItem MenuFinanceiroLancamentoContasPagar;
    private javax.swing.JMenuItem MenuFinanceiroLancamentoContasReceber;
    private javax.swing.JMenu MenuFinanceiroRelatorios;
    private javax.swing.JMenuItem MenuFinanceiroRelatoriosContasPagar;
    private javax.swing.JMenuItem MenuFinanceiroRelatoriosContasReceber;
    private javax.swing.JMenuItem MenuFinanceiroRelatoriosLancamentosCaixa;
    private javax.swing.JMenuItem MenuFinanceiroRelatoriosPosicaoFinanceira;
    public javax.swing.JMenu MenuSair;
    public javax.swing.JMenu MenuServicos;
    private javax.swing.JMenuItem MenuServicosCadastroServicos;
    private javax.swing.JMenuItem MenuServicosOrcamento;
    private javax.swing.JMenuItem MenuServicosRelatoriosOrcamentosEmitidos;
    public javax.swing.JMenu MenuSuporte;
    private javax.swing.JMenuItem MenuSuporteBackup;
    private javax.swing.JMenuItem MenuSuporteConexao;
    private javax.swing.JMenu MenuVeiculos;
    private javax.swing.JMenuItem MenuVeiculosCadastroVeiculos;
    private javax.swing.JMenu MenuVeiculosCustos;
    private javax.swing.JMenuItem MenuVeiculosCustosLancamentoCusto;
    private javax.swing.JMenuItem MenuVeiculosCustosRelatorioCustosPorVeiculo;
    private javax.swing.JMenuItem MenuVeiculosLancamentosDespesas;
    private javax.swing.JMenu MenuVeiculosRelatorios;
    private javax.swing.JMenuItem MenuVeiculosRelatoriosDespesasPorVeiculo;
    private javax.swing.JMenuItem MenuVeiculosRelatoriosEstoqueVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblDataHoraAtual;
    public javax.swing.JLabel lblEmpresaLogada;
    private javax.swing.JLabel lblUsuarioLogado;
    // End of variables declaration//GEN-END:variables

}
