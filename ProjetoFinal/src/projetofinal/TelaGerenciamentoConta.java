package projetofinal;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TelaGerenciamentoConta extends JFrame {
    private ContaBancaria conta;
    private Agencia agencia;
    private String arquivoBanco;
    private String arquivoExtrato;

    private JLabel lblSaldo;
    private JLabel lblLimiteOuTaxa;
    private JLabel lblTelefone;

    public TelaGerenciamentoConta(ContaBancaria conta, Agencia agencia, String arquivoBanco) {
        this.conta = conta;
        this.agencia = agencia;
        this.arquivoBanco = arquivoBanco;
        
        String numLimpo = conta.getNumeroConta().replace("/", "-");
        this.arquivoExtrato = "extrato_" + numLimpo + ".txt";

        setTitle("Painel da Conta - " + conta.getNomeTitular());
        setSize(500, 480); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        inicializarArquivoExtrato();

        JPanel painelDados = new JPanel(new GridLayout(5, 1, 5, 5));
        painelDados.setBorder(BorderFactory.createTitledBorder("Informações da Conta"));
        
        painelDados.add(new JLabel("Titular: " + conta.getNomeTitular() + " | CPF: " + conta.getCpfTitular()));
        painelDados.add(new JLabel("Número da Conta: " + conta.getNumeroConta()));
        
        lblTelefone = new JLabel("Telefone: " + conta.getTelefone());
        painelDados.add(lblTelefone);
        
        lblSaldo = new JLabel("Saldo Atual: R$ " + conta.getSaldo());
        lblSaldo.setFont(new Font("Arial", Font.BOLD, 14));
        painelDados.add(lblSaldo);

        lblLimiteOuTaxa = new JLabel();
        atualizarLabels();
        painelDados.add(lblLimiteOuTaxa);
        
        add(painelDados, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(3, 2, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnDeposito = new JButton("Depositar");
        JButton btnSaque = new JButton("Sacar");
        JButton btnExtrato = new JButton("Ver Extrato");
        JButton btnEditarTel = new JButton("Editar Telefone");
        JButton btnEditarLimite = new JButton("Alterar Limite de Crédito");
        JButton btnPagarImposto = new JButton("Pagar Imposto Individual"); 

        if (conta instanceof ContaPoupanca) {
            btnEditarLimite.setEnabled(false);
            btnEditarLimite.setText("Limite indisponível (Poupança)");
            btnPagarImposto.setEnabled(false);
            btnPagarImposto.setText("Isento de Impostos (Poupança)");
        }

        btnDeposito.addActionListener(e -> {
            String str = JOptionPane.showInputDialog("Valor do depósito:");
            if (str != null && !str.isEmpty()) {
                try {
                    double valor = Double.parseDouble(str.replace(",", "."));
                    conta.depositar(valor);
                    salvarLinhaNoExtrato("Depósito: + R$ " + valor + " | Saldo pós-op: R$ " + conta.getSaldo());
                    salvarEAtualizar("Depósito realizado com sucesso!");
                } catch (NumberFormatException ex) {
                    erro("Digite um valor numérico válido.");
                }
            }
        });

        btnSaque.addActionListener(e -> {
            String str = JOptionPane.showInputDialog("Valor do saque:");
            if (str != null && !str.isEmpty()) {
                try {
                    double valor = Double.parseDouble(str.replace(",", "."));
                    conta.sacar(valor);
                    salvarLinhaNoExtrato("Saque: - R$ " + valor + " | Saldo pós-op: R$ " + conta.getSaldo());
                    salvarEAtualizar("Saque realizado com sucesso!");
                } catch (Exception ex) {
                    erro(ex.getMessage());
                }
            }
        });

        btnExtrato.addActionListener(e -> {
            String conteudoExtrato = lerArquivoExtrato();
            JTextArea txt = new JTextArea(conteudoExtrato);
            txt.setEditable(false);
            JOptionPane.showMessageDialog(this, new JScrollPane(txt), "Extrato Histórico Permanente", JOptionPane.INFORMATION_MESSAGE);
        });

        btnEditarTel.addActionListener(e -> {
            String novoTel = JOptionPane.showInputDialog("Digite o novo telefone:", conta.getTelefone());
            if (novoTel != null && !novoTel.isEmpty()) {
                try {
                    agencia.editarContato(conta.getNumeroConta(), novoTel);
                    lblTelefone.setText("Telefone: " + conta.getTelefone());
                    agencia.salvarDadosEmArquivo(arquivoBanco);
                    JOptionPane.showMessageDialog(this, "Contato updated!");
                } catch (ContaNaoEncontradaException ex) {
                    erro(ex.getMessage());
                }
            }
        });

        btnEditarLimite.addActionListener(e -> {
            ContaCorrente cc = (ContaCorrente) conta;
            String str = JOptionPane.showInputDialog("Digite o novo limite total (Entre R$ 0 e R$ 5.000):", cc.getLimiteCredito());
            if (str != null && !str.isEmpty()) {
                try {
                    double novoLimite = Double.parseDouble(str.replace(",", "."));
                    
                    if (novoLimite < 0 || novoLimite > 5000) {
                        erro("Erro: O limite permitido deve ser estritamente entre R$ 0 e R$ 5.000,00.");
                        return;
                    }
                    
                    double creditoUsado = (cc.getSaldo() < 0) ? Math.abs(cc.getSaldo()) : 0;
                    if (novoLimite < creditoUsado) {
                        erro("Operação Negada!\nVocê já utilizou R$ " + creditoUsado + " do limite atual.\n" +
                             "O novo limite não pode ser menor que o crédito já utilizado.");
                        return;
                    }

                    agencia.editarLimiteCredito(cc.getNumeroConta(), novoLimite);
                    salvarLinhaNoExtrato("Limite de Crédito alterado para: R$ " + novoLimite);
                    salvarEAtualizar("Limite de crédito atualizado com sucesso!");
                    
                } catch (NumberFormatException ex) {
                    erro("Digite um número válido.");
                } catch (ContaNaoEncontradaException ex) {
                    erro(ex.getMessage());
                }
            }
        });

        btnPagarImposto.addActionListener(e -> {
            if (conta instanceof Tributavel) {
                Tributavel ccTributavel = (Tributavel) conta;
                ccTributavel.calcularImpostos(); 
                salvarLinhaNoExtrato("Imposto Mensal Debitado: - R$ 2,50 | Saldo pós-op: R$ " + conta.getSaldo());
                salvarEAtualizar("Imposto de R$ 2,50 debitado do seu saldo com sucesso!");
            }
        });

        painelBotoes.add(btnDeposito);
        painelBotoes.add(btnSaque);
        painelBotoes.add(btnExtrato);
        painelBotoes.add(btnEditarTel);
        painelBotoes.add(btnEditarLimite);
        painelBotoes.add(btnPagarImposto); 

        add(painelBotoes, BorderLayout.CENTER);
    }

    private void inicializarArquivoExtrato() {
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoExtrato))) {
        } catch (IOException e) {
            salvarLinhaNoExtrato("--- HISTÓRICO DE EXTRATO PERMANENTE ---");
            salvarLinhaNoExtrato("Conta criada/acessada no sistema.");
            salvarLinhaNoExtrato("Titular: " + conta.getNomeTitular() + " | Número: " + conta.getNumeroConta());
            salvarLinhaNoExtrato("---------------------------------------");
        }
    }

    private void salvarLinhaNoExtrato(String linha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoExtrato, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao gravar histórico no extrato: " + e.getMessage());
        }
    }

    private String lerArquivoExtrato() {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoExtrato))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            return "Erro ao carregar o histórico do extrato.";
        }
        return conteudo.toString();
    }

    private void atualizarLabels() {
        lblSaldo.setText("Saldo Atual: R$ " + conta.getSaldo());
        if (conta instanceof ContaCorrente) {
            ContaCorrente cc = (ContaCorrente) conta;
            lblLimiteOuTaxa.setText("Limite de Crédito Total: R$ " + cc.getLimiteCredito());
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca cp = (ContaPoupanca) conta;
            lblLimiteOuTaxa.setText("Taxa de Rendimento: " + cp.getTaxaRendimento() + "%");
        }
    }

    private void salvarEAtualizar(String mensagemSucesso) {
        agencia.salvarDadosEmArquivo(arquivoBanco);
        atualizarLabels();
        JOptionPane.showMessageDialog(this, mensagemSucesso, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void erro(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}