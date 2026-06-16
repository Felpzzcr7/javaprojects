package drones;


public class Pacote {
    String descricao,enderecoDestino;
   public int distanciaEntregaKm, peso;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public int getDistanciaEntregaKm() {
        return distanciaEntregaKm;
    }

    public void setDistanciaEntregaKm(int distanciaEntregaKm) {
        this.distanciaEntregaKm = distanciaEntregaKm;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Pacote(String descricao, String enderecoDestino, int distanciaEntregaKm, int peso) {
        this.descricao = descricao;
        this.enderecoDestino = enderecoDestino;
        this.distanciaEntregaKm = distanciaEntregaKm;
        this.peso = peso;
    }
    
    public void exibirDetalhes(){
        System.out.println(descricao);
        System.out.println(enderecoDestino);
        System.out.println(distanciaEntregaKm);
        System.out.println(peso);
    }
}
