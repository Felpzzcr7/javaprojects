package drones;

public class Main {

    public static void main(String[] args) {

        CentralDrones central = new CentralDrones();

        // criar drones
        central.cadastrarDrone(1, 10, 20, "Falcon X2", true, 60);
        central.cadastrarDrone(2, 15, 30, "Eagle Pro", true, 70);

        // criar pacotes
        Pacote p1 = new Pacote("Medicamentos", "Rua A", 5, 2);
        Pacote p2 = new Pacote("Documentos", "Rua B", 3, 1);

        Drone d = central.drones.get(0);

        Entrega e = new Entrega(105, d, 100, "EM PREPARACAO");

      
        e.adicionarPacote(p1);
        e.adicionarPacote(p2);

        
        central.entrega.add(e);

    
        central.listarEntregas();

    }

}