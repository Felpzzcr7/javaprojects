public class SistemaLanchonete {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Ana");
        cliente1.nome = "Ana";

        Lanche lanche1 = new Lanche("X-Burguer", 18.5);

        Pedido pedido1 = new Pedido(cliente1, lanche1);
        pedido1.quantidade = 2;

        cliente1.mostrarCliente();

        lanche1.mostrarLanche();

        pedido1.mostrarPedido();
    }
}