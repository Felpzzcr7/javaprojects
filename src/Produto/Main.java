import Produto.Produto;

void main() {

 Produto p1 = new Produto("banana", 1.76f, 10);

    System.out.println("voce comprou " + p1.getQuantidade() + "  "+ p1.getNome()+ "  pelo valor de: " + p1.getPreco() + " cada");

}

