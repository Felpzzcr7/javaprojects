package Lanchonete;

public class Pedido {
    Cliente cliente;
    Lanche lanche;
    public int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido(Cliente cliente, Lanche lanche){
        this.cliente = cliente;
        this.lanche = lanche;
    }
   public double calcularTotal(){
       return lanche.preco * quantidade;

   }

   public void mostrarPedido(){
       System.out.println("Lanchonete.Cliente: " + cliente.nome);
       System.out.println("Lanchonete.Lanche: " + lanche.nome);
       System.out.println("Preço: " + lanche.preco);
       System.out.println("Quantidade: " + quantidade);
       System.out.println("Total: " + calcularTotal());
   }

}
