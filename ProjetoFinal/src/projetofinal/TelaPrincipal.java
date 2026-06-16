package projetofinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private Agencia agencia;
    private String arquivoBanco = "banco_dados.csv";

    public TelaPrincipal() {
        
        agencia = new Agencia();
        agencia.carregarDadosDoArquivo(arquivoBanco);

        setTitle("Sistema Bancário - Projeto Final");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnListar = new JButton("Listar Contas");
        JButton btnCadastrar = new JButton("Cadastrar Nova Conta");
        JButton btnApagar = new JButton("Encerrar Conta");
        JButton btnOperacoes = new JButton("Realizar Saque/Depósito");

       JButton btnAcessarConta = new JButton("Acessar Minha Conta (Área do Cliente)");

        btnAcessarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numConta = JOptionPane.showInputDialog("Digite o número da conta para acessar:");
                
                if (numConta != null && !numConta.isEmpty()) {
                    try {
                      
                        ContaBancaria conta = agencia.buscarPorNumero(numConta);

                 
                        JPasswordField pf = new JPasswordField();
                        int op = JOptionPane.showConfirmDialog(null, pf, "Digite a senha de acesso:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                        
                        if (op == JOptionPane.OK_OPTION) {
                            String senhaDigitada = new String(pf.getPassword());
                            
                           
                            if (!conta.getSenha().equals(senhaDigitada)) {
                                throw new Exception("Senha incorreta! Acesso negado.");
                            }

                          
                            TelaGerenciamentoConta painelCliente = new TelaGerenciamentoConta(conta, agencia, arquivoBanco);
                            painelCliente.setVisible(true);
                        }

                    } catch (ContaNaoEncontradaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Acesso", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        
      
        
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarContas();
            }
        });
        
        

      btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                abrirTelaCadastro();
            }
        });
      
      

        btnApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numConta = JOptionPane.showInputDialog("Digite o número da conta para encerrar:");
                if (numConta != null && !numConta.isEmpty()) {
                    try {
                        agencia.encerrarConta(numConta, arquivoBanco);
                        JOptionPane.showMessageDialog(null, "Conta " + numConta + " encerrada com sucesso!");
                    } catch (ContaNaoEncontradaException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        

       
        add(new JLabel("Bem-vindo ao Sistema Bancário", SwingConstants.CENTER));
        add(btnListar);
        add(btnAcessarConta);
        add(btnCadastrar);
        add(btnApagar);
    }

    private void listarContas() {
        StringBuilder lista = new StringBuilder("Contas Registradas:\n\n");
        for (ContaBancaria c : agencia.listarTodas()) {
            lista.append("Conta: ").append(c.getNumeroConta())
                 .append(" | Titular: ").append(c.getNomeTitular())
                 .append(" | Saldo: R$ ").append(c.getSaldo()).append("\n");
        }
        

        JTextArea textArea = new JTextArea(lista.toString());
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Lista de Contas", JOptionPane.INFORMATION_MESSAGE);
    }
   private void abrirTelaCadastro() {
        JTextField txtNumero = new JTextField();
        JTextField txtCpf = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtTelefone = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JTextField txtSaldo = new JTextField("0.0");

        String[] tipos = {"Conta Corrente", "Conta Poupança"};
        JComboBox<String> cbTipo = new JComboBox<>(tipos);

        Object[] formulario = {
            "Tipo de Conta:", cbTipo,
            "Número da Conta:", txtNumero,
            "CPF do Titular:", txtCpf,
            "Nome do Titular:", txtNome,
            "Telefone de Contato:", txtTelefone,
            "Senha da Conta:", txtSenha,
            "Saldo Inicial (R$):", txtSaldo
         
        };

        int opcao = JOptionPane.showConfirmDialog(this, formulario, "Cadastrar Nova Conta", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcao == JOptionPane.OK_OPTION) {
            try {
                String numero = txtNumero.getText();
                String cpf = txtCpf.getText();
                String nome = txtNome.getText();
                String telefone = txtTelefone.getText();
                String senha = new String(txtSenha.getPassword()); 
                
                double saldo = Double.parseDouble(txtSaldo.getText().replace(",", "."));
                ContaBancaria novaConta;

                if (cbTipo.getSelectedIndex() == 0) {

                    novaConta = new ContaCorrente(numero, cpf, nome, telefone, senha, saldo, 5000.0);
                } else {
              
                    novaConta = new ContaPoupanca(numero, cpf, nome, telefone, senha, saldo, 12.0);
                }

                agencia.cadastrarConta(novaConta);
                agencia.salvarDadosEmArquivo(arquivoBanco);

                JOptionPane.showMessageDialog(this, "Conta cadastrada com sucesso!\nLimite de crédito/Taxa aplicados automaticamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro no cadastro: Verifique se os dados estão corretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}