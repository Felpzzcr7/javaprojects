package Lanchonete;

public class Lanche {
    public String nome;
    public double preco;

    public Lanche(String nome, double preco) {
        this.nome= nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void mostrarLanche(){
        System.out.println("o seu lanche: " + this.nome + " saiu no valor de: " + this.preco + " reais");
    }
}
