package Sistemabancario;

public class Conta {
    private String nome;
    private double saldo;
    private double deposito, saque;



    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaque() {
        return saque;
    }

    public void setSaque(double saque) {
        this.saque = saque;
    }

    public void exibeSaldo(){
        System.out.println("\nseu saldo atual e de : " + this.saldo+" reais");
        System.out.println("------------------------------------------------------------\n");
    }
    public Conta(String nome, double saldo){
        this.nome= nome;
        this.saldo= saldo;
    }




    public void sacar(){
        if(saque > saldo){
            System.out.println("saque nao permitido, saldo insuficiente");
            System.out.println("------------------------------------------------------------\n");
        }
        else {
            saldo = saldo - saque;
            System.out.println("seu saque de " + saque +" reais foi realizado com sucesso \n");
            System.out.println("------------------------------------------------------------\n");
        }

    }

    public void depositar(){
        saldo= saldo+deposito;
        System.out.println("seu deposito de " + deposito +" reais foi realizado com sucesso \n");
        System.out.println("------------------------------------------------------------\n");
    }
}
