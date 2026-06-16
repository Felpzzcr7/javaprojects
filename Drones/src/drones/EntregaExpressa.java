
package drones;

public class EntregaExpressa extends Entrega{
    int taxaPrioridade;
    public EntregaExpressa(int codigoEntrega, Drone drone, int valorEntrega, String statusEntrega, int taxaPrioridade) {
        super(codigoEntrega, drone, valorEntrega, statusEntrega);
        this.taxaPrioridade =  taxaPrioridade;
       
    }
     @Override 
     public double calcularTempoEntrega(){
        return (calcularDistanciaTotal() / drone.velocidade)* 0.75;
    }
    
}
