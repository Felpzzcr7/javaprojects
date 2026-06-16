

package drones;
import java.util.ArrayList;
public class CentralDrones{
    ArrayList<Drone> drones = new ArrayList <>();
    ArrayList<Entrega> entrega	= new ArrayList<>();

    
public void cadastrarDrone(int id, int capacidadeCarga, int autonomiaKm, String modelo, boolean disponivel, int velocidade ){
    drones.add(new Drone(id,  capacidadeCarga,  autonomiaKm,  modelo,  disponivel, velocidade));
 
}

public void registrarEntrega(int codigoEntrega, Drone drone, int valorEntrega, String statusEntrega){
    entrega.add(new Entrega( codigoEntrega,  drone,  valorEntrega, statusEntrega));

}
public void atribuirDrone(Entrega entrega){

    for(Drone d : drones){

        if(d.disponivel){
            entrega.drone = d;
            d.marcarOcupado();
            System.out.println("Drone " + d.modelo + " atribuido a entrega");
            return;
        }

    }

    System.out.println("Nenhum drone disponivel");
}
public void listarEntregas(){

    for(Entrega e : entrega){

        System.out.println("Entrega #" + e.codigoEntrega);

        if(e.drone != null){
            System.out.println("Drone: " + e.drone.modelo);
        }

        System.out.println("Peso total: " + e.calcularPesoTotal());
        System.out.println("Distancia total: " + e.calcularDistanciaTotal());

        System.out.println("Pacotes:");
        e.listarPacotes();

        System.out.println("Status: " + e.statusEntrega);
        System.out.println("-------------------");
    }

}
public void listarDronesDisponiveis(){

    for(Drone d : drones){

        if(d.disponivel){
            d.exibirInformacoes();
            System.out.println("-------------");
        }

    }

}


    
}
