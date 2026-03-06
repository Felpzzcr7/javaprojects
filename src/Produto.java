public class Produto {

    private String nome;
    private int quantidade;
    private float preco;

    public Produto (String nome){
        this.nome= nome;
    }

    public Produto (String nome, float preco){
        this(nome);
        this.preco= preco;

    }

    public Produto (String nome, float preco, int   quantidade){
       this(nome, preco);
        this.quantidade= quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
