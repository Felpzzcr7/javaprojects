package drones;
import java.util.ArrayList;

public class Entrega {
        
int codigoEntrega, valorEntrega;
Drone drone;
ArrayList<Pacote> pacotes = new ArrayList<>();	
String statusEntrega;

    public Entrega(int codigoEntrega, Drone drone, int valorEntrega, String statusEntrega) {
        this.codigoEntrega = codigoEntrega;
        this.drone = drone;
        this.statusEntrega = statusEntrega;
        this.valorEntrega = valorEntrega;
    }
    
    
    public void adicionarPacote(Pacote pacote){
        this.pacotes.add(pacote);
    }
    
    
    public int calcularPesoTotal(){
       int pesoTotal = 0; 
       
       for(Pacote pacotes : this.pacotes){
           pesoTotal += pacotes.peso;
       }
        return pesoTotal;
       
    }
    
    public int calcularDistanciaTotal(){
        int distanciaTotal = 0;
        for(Pacote pacotes : this.pacotes){
           distanciaTotal += pacotes.distanciaEntregaKm;
       }
        
        return distanciaTotal;
    }
    
    public double calcularTempoEntrega(){
        return calcularDistanciaTotal() / drone.velocidade;
    }
    
    public void listarPacotes(){
       for(Pacote pacotes : this.pacotes){
          pacotes.exibirDetalhes();
       }

    }
    
}
